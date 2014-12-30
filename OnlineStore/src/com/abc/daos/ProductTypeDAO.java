package com.abc.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.abc.connectiondb.ConnectionDB;
import com.abc.model.ProductTypeModel;


public class ProductTypeDAO {

	Connection conn = null;
	Statement stmt = null;

	public ArrayList<ProductTypeModel> getProductTypes() {
		ResultSet rs = null;
		ArrayList<ProductTypeModel> productTypeList = new ArrayList<ProductTypeModel>();
		ProductTypeModel productType = null;
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from products_type";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				productType = new ProductTypeModel(rs.getInt("id"),
						rs.getString("name"), rs.getString("description"));
				productTypeList.add(productType);
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
		return productTypeList;
	}

	public ProductTypeModel getProductTypeById(int id) {
		
		ResultSet rs = null;
		ProductTypeModel productType = null;
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from products_type where id = " + id;
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				productType = new ProductTypeModel(rs.getInt("id"), rs.getString("name"),
						rs.getString("description"));
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
		return productType;
	}

}
