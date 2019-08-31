package com.pluralsight.corejdbc.m5c4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class OrderComponent {
	
	public int deleteOrderline(int orderNumber, String productCode) throws Exception {
		
		Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");
		
		String query = 
				"DELETE FROM orderdetails WHERE orderNumber = ? AND productCode = ?";
		PreparedStatement preparedStatement = 
						  connection.prepareStatement(query);
		
		preparedStatement.setInt(1, orderNumber);
		preparedStatement.setString(2, productCode);
		int count = preparedStatement.executeUpdate();

		preparedStatement.close();
		connection.close();
		
		return count;
		
		
	}
	
	private void handleException(Exception exception) {
		if(exception instanceof SQLException) {
			SQLException sqlException = (SQLException)exception;
			System.out.println("Error Code: " 			+ sqlException.getErrorCode());
			System.out.println("SQL State: " 			+ sqlException.getSQLState());
		}
		System.out.println("SQLException message: " + exception.getMessage());
		System.out.print("Stacktrace: ");			  exception.printStackTrace();
	}
	
}
