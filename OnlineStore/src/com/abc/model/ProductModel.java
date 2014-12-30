package com.abc.model;

import java.util.Date;

public class ProductModel {

	private int id;
	private String name;
	private ProductTypeModel type = null;
	private int status;
	private Date createdDate;
	private Date updatedDate;
	private String image;

	public ProductModel(int id, String name, int userTypeId, int status) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.type = new ProductTypeModel();
		type.setId(userTypeId);
	}

	public ProductModel() {
		// TODO Auto-generated constructor stub
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductTypeModel getType() {
		return type;
	}

	public void setType(ProductTypeModel type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
