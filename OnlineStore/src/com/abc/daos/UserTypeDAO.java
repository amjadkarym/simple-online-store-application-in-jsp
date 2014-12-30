package com.abc.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.abc.connectiondb.ConnectionDB;
import com.abc.model.ProductModel;
import com.abc.model.ProductTypeModel;
import com.abc.model.UserTypeModel;

public class UserTypeDAO {

	Connection conn = null;
	Statement stmt = null;

	public ArrayList<UserTypeModel> getUserTypeList() {
		ResultSet rs = null;
		ArrayList<UserTypeModel> userTypeList = new ArrayList<UserTypeModel>();
		UserTypeModel userType = null;
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.createStatement();
			String sql = "select id, name, description, status from users_type ";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				userType = new UserTypeModel(rs.getInt("id"),
						rs.getString("name"), rs.getString("description"));
				/*
				 * UserTypeModel type = new UserTypeModel();
				 * type.setId(rs.getInt("typeid"));
				 * type.setName(rs.getString("typename")); user.setType(type);
				 */
				userTypeList.add(userType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return userTypeList;
	}

	public UserTypeModel getUserTypeById(int id) {
		ResultSet rs = null;
		UserTypeModel userType = null;
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from products_type where id = " + id;
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				userType = new UserTypeModel(rs.getInt("id"),
						rs.getString("name"), rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return userType;
	}

}
