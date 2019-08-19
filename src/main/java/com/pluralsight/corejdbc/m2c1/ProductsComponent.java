package com.pluralsight.corejdbc.m2c1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ProductsComponent {

	public int getProductCount() {	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
				
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");			
			stmt = conn.createStatement();    		
    		rs = stmt.executeQuery("SELECT COUNT(*) FROM products;");
    		
    		if(rs.next()) {
				int count = rs.getInt(1);
				return count;
			}
    		return 0;
    				   
		}catch (SQLException ex){
    		// handle any errors
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
    		try { if (rs != null) rs.close(); } catch (Exception e) {};
    		try { if (stmt != null) stmt.close(); } catch (Exception e) {};
    		try { if (conn != null) conn.close(); } catch (Exception e) {};
    	}
    	
    	return 0;
    }

}
