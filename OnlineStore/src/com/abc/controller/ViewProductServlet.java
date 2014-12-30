package com.abc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.ProductModel;
import com.abc.services.ManageServices;

/**
 * Servlet implementation class ViewProductServlet
 */
public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManageServices manageServices = new ManageServices();
		Integer intParam = null;
		ProductModel product = null;
		ArrayList<ProductModel> productByType = null;
		intParam = Integer.parseInt(request.getParameter("productId"));
		String varParam = request.getParameter("action");
		if (varParam != null && varParam.equals("View")) {
			product = manageServices.getProductServices().getProductById(intParam);
			productByType = manageServices.getProductServices().getProdcutByType(product.getType().getId());
			request.setAttribute("productList", productByType);
			request.setAttribute("product", product);
			request.getRequestDispatcher("views/products/view.jsp").forward(
					request, response);
		} else if (varParam != null && varParam.equals("Update")) {
			product = manageServices.getProductServices().getProductById(intParam);
			
		}
		
	}

}
