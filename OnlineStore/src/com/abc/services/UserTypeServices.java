package com.abc.services;

import java.util.ArrayList;

import com.abc.daos.UserTypeDAO;
import com.abc.model.UserTypeModel;

public class UserTypeServices {

	static UserTypeDAO userType = new UserTypeDAO();
	
	public  ArrayList<UserTypeModel> getUserTypeList() {
		// TODO Auto-generated method stub
		return userType.getUserTypeList();
	}

	public static UserTypeModel getUserTypeById(int id) {
		
		return userType.getUserTypeById(id);
	}

}
