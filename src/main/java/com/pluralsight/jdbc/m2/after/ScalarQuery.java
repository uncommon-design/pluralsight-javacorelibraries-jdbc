package com.pluralsight.jdbc.m2.after;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ScalarQuery {

	public static void main(String [] args){	
		Connection conn;
		Statement stmt;
		ResultSet rs;
		
		try{	
				
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?user=root&password=root");			
			stmt = conn.createStatement();    		
    		rs = stmt.executeQuery("SELECT COUNT(*) FROM products;");
    		
    		if(rs.next()){
    			int count = rs.getInt(1);
    			System.out.println(" The Products table has " + count + " rows.");
    		else{
    			System.out.println("Count query on products table failed");
    		}
    				   
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
    }
}
