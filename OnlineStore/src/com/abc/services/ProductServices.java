package com.abc.services;

import java.util.ArrayList;

import com.abc.daos.ProductDAO;
import com.abc.model.ProductModel;
import com.abc.model.ProductTypeModel;

public class ProductServices {

	static ProductDAO productDAO = new ProductDAO();
	static ProductTypeServices productTypeServices = new ProductTypeServices();

	public static ProductTypeServices getProductTypeServices() {
		return productTypeServices;
	}

	public static void setProductTypeServices( 
			ProductTypeServices productTypeServices) {
		ProductServices.productTypeServices = productTypeServices;
	}

	public void createProduct(ProductModel product) {
		productDAO.createProduct(product);
	}

	public ProductModel getProduct(ProductModel product) {

		product = productDAO.getProduct(product);
		if (product != null) {
			ProductTypeModel productType = productTypeServices
					.getProductTypeById(product.getType().getId());
			product.setType(productType);
		}
		return product;
	}

	public ArrayList<ProductModel> getProductsList() {
		ArrayList<ProductModel> productList = productDAO.getProductList();
		for (ProductModel product : productList) {
			ProductTypeModel productType = productTypeServices
					.getProductTypeById(product.getType().getId());
			product.setType(productType);
		}
		return productList;
	}

	public  ProductModel getProductById(int id) {
		ProductModel product = productDAO.getProductById(id);
		ProductTypeModel productType = productTypeServices
				.getProductTypeById(product.getType().getId());
		product.setType(productType);
		return product;

	}

	public ArrayList<ProductModel> getProdcutByType(int id) {
		ArrayList<ProductModel> productList = productDAO.getProductByType(id);
		for (ProductModel product : productList) {
			ProductTypeModel productType = productTypeServices
					.getProductTypeById(product.getType().getId());
			product.setType(productType);
		}
		return productList;
	}

	public  void updateProduct(ProductModel product) {
		productDAO.updateProduct(product);
	}

	public  void deleteProduct(ProductModel product) {
		productDAO.deleteProduct(product);
		
	}
}
