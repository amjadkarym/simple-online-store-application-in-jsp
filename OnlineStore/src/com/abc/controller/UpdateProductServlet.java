package com.abc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.ProductModel;
import com.abc.model.ProductTypeModel;
import com.abc.services.ManageServices;

/**
 * Servlet implementation class UpdateProductServlet
 */
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ManageServices manageServices = new ManageServices();
		String varParam = request.getParameter("action");
		Integer intParam = null;
		ProductModel product = new ProductModel();
		ArrayList<ProductTypeModel> listProducts = null;
		String paramName = request.getParameter("paramName");
		String name = request.getParameter("name");

		product.setName(name);

		listProducts = manageServices.getProductTypeServices()
				.getProductTypes();

		if (varParam != null && varParam.equals("Update")) {
			intParam = Integer.parseInt(request.getParameter("productId"));
			ProductModel productUpdate = null;
			product.setId(intParam);
			productUpdate = manageServices.getProductServices().getProduct(
					product);
			request.setAttribute("product", productUpdate);
			request.setAttribute("listProducts", listProducts);

			request.getRequestDispatcher("views/products/update.jsp").forward(
					request, response);
		} else if (paramName != null && paramName.equals("Edit")) {
			intParam = Integer.parseInt(request.getParameter("productId"));
			product.setId(intParam);

			int status = Integer.parseInt(request.getParameter("status"));
			product.setStatus(status);

			ProductTypeModel productTypeVal = new ProductTypeModel();
			if (request.getParameter("listProducts") != null
					&& !request.getParameter("listProducts").equals("")) {
				productTypeVal.setId(Integer.parseInt(request
						.getParameter("listProducts")));
			}
			product.setType(productTypeVal);

			manageServices.getProductServices().updateProduct(product);
			response.sendRedirect("sucess.jsp");
		} else if (varParam != null && varParam.equals("Delete")) {
			intParam = Integer.parseInt(request.getParameter("productId"));
			product.setId(intParam);
			manageServices.getProductServices().deleteProduct(product);
			response.sendRedirect("sucess.jsp");
		}
	}

}
