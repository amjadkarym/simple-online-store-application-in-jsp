package com.abc.services;

import java.util.ArrayList;
import java.util.List;

import com.abc.daos.ProductTypeDAO;
import com.abc.model.ProductTypeModel;

public class ProductTypeServices {

	static ProductTypeDAO productTypeDAO = new ProductTypeDAO();
	
	public  ArrayList<ProductTypeModel> getProductTypes() {
		// TODO Auto-generated method stub
		return productTypeDAO.getProductTypes();
	}

	public  ProductTypeModel getProductTypeById(int id) {
		return productTypeDAO.getProductTypeById(id);
		
	}
}
