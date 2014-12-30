package com.abc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.UserModel;
import com.abc.model.UserTypeModel;
import com.abc.services.ManageServices;

/**
 * Servlet implementation class CreateUserServlet
 */
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUserServlet() {
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
		UserModel user = new UserModel();

		String paramName = request.getParameter("create");

		if ("Create".equals(paramName) && paramName != null) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			int status = Integer.parseInt(request.getParameter("status"));
			user.setUserName(name);
			user.setPassword(password);
			user.setStatus(status);
			UserTypeModel userType = new UserTypeModel();
			if (request.getParameter("userType") != null
					&& !request.getParameter("userType").equals("")) {
				userType.setId(Integer.parseInt(request
						.getParameter("userType")));
				user.setUserType(userType);
			}
			manageServices.getUserServices().createUser(user);
			UserModel userGet = new UserModel();
			userGet = manageServices.getUserServices().getUser(user);
			request.setAttribute("user", userGet);

			request.getRequestDispatcher("views/users/view.jsp").forward(
					request, response);
		} else {

			ArrayList<UserTypeModel> userTypeList = null;
			userTypeList = manageServices.getUserTypeServices().getUserTypeList();
			request.setAttribute("userTypeList", userTypeList);
			request.getRequestDispatcher("views/users/create.jsp").forward(
					request, response);
		}
	}

}
