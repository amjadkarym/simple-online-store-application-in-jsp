package com.abc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.model.ProductModel;
import com.abc.services.ManageServices;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionServlet() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer intParam = null;
		ManageServices manageServices = new ManageServices();
		String varParam = request.getParameter("action");
		HttpSession session = request.getSession();
		
//		Map<String, ProductModel> products = new HashMap<String, ProductModel>();
		
		Map<Integer, ProductModel> productList = (Map<Integer, ProductModel>) session.getAttribute("productList");
		if(productList == null) {
			productList = new HashMap<Integer, ProductModel>();
		}
		ProductModel product = null;
		if(varParam != null && varParam.equals("Wish")) {
			intParam = Integer.parseInt(request.getParameter("productId"));
			product = manageServices.getProductServices().getProductById(intParam);
			productList.put(product.getId(), product);
		}
		
		
//		ArrayList<ProductModel> productList = (ArrayList<ProductModel>) session.getAttribute("productList");
//		if(productList == null ){
//			productList = new ArrayList<ProductModel>();
//		}
//		ProductModel product = null;
//		
//
//		if (varParam != null && varParam.equals("Wish")) {
//			intParam = Integer.parseInt(request.getParameter("productId"));
//			product = ProductServices.getProductById(intParam);
//			productList.add(product);
			
			// Object product1 =
			// request.getSession().getAttribute("productSession");
			
//		}
//		session.setAttribute("productList", productList);
		session.setAttribute("productList", productList);
//		session.setAttribute("product", product);
		request.getRequestDispatcher("views/wishlist/wishList.jsp")
		.forward(request, response);
	}

}
