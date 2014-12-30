package com.abc.services;

import java.util.ArrayList;

import com.abc.daos.UserDAO;
import com.abc.model.UserModel;
import com.abc.model.UserTypeModel;

public class UserServices {

	static UserDAO userDAO = new UserDAO();
	

	public  void createUser(UserModel user) {
	
		userDAO.createUser(user);
		
	}

	public  UserModel getUser(UserModel user) {
		user = userDAO.getUser(user);
		if(user != null) {
			UserTypeModel userType = UserTypeServices.getUserTypeById(user.getUserType().getId());
			user.setUserType(userType);
		}
		return user;
	}

}
