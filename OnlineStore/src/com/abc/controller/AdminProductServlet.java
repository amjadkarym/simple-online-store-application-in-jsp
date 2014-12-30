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
 * Servlet implementation class AdminServlet
 */
public class AdminProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProductServlet() {
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
		ArrayList<ProductModel> productList = null;
		productList = manageServices.getProductServices().getProductsList();
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("views/products/admin.jsp").forward(request, response);
	}

}
