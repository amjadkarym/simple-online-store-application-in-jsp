package com.abc.services;

public class ManageServices {

	private ProductServices productServices = new ProductServices();
	private ProductTypeServices productTypeServices = new ProductTypeServices();
	private UserServices userServices = new UserServices();
	private UserTypeServices userTypeServices = new UserTypeServices();

	public ProductServices getProductServices() {
		return productServices;
	}

	public void setProductServices(ProductServices productServices) {
		this.productServices = productServices;
	}

	public ProductTypeServices getProductTypeServices() {
		return productTypeServices;
	}

	public void setProductTypeServices(ProductTypeServices productTypeServices) {
		this.productTypeServices = productTypeServices;
	}

	public UserServices getUserServices() {
		return userServices;
	}

	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}

	public UserTypeServices getUserTypeServices() {
		return userTypeServices;
	}

	public void setUserTypeServices(UserTypeServices userTypeServices) {
		this.userTypeServices = userTypeServices;
	}

}
