package com.abc.model;

public class UserModel {

	private int id;
	private UserTypeModel userType = null;
	private String userName;
	private String password;
	private int status;

	public UserModel(int id, int userTypeId , String userName,
			String password, int status) {
		this.id = id;
		userType = new UserTypeModel();
		userType.setId(userTypeId);
		
		this.userName = userName;
		this.password = password;
		this.status = status;
	}

	public UserModel(int userTypeId, String userName, String password,
			int status) {

		userType = new UserTypeModel();
		userType.setId(userTypeId);

		this.userName = userName;
		this.password = password;
		this.status = status;
	}

	public UserModel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserTypeModel getUserType() {
		return userType;
	}

	public void setUserType(UserTypeModel userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
