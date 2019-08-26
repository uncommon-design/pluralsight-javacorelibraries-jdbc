package com.pluralsight.corejdbc.m3c2;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ProductsComponent {

	public int getProductCount() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","pluralsight");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM products;");

			if (rs.next()) {
				int count = rs.getInt(1);
				return count;
			}
			return 0;

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			;
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			;
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
			;
		}
	}

}
