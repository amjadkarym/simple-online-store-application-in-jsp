package com.abc.connectiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/online_store";

	static final String USER = "root";
	static final String PASS = "";

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("connected..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
