package com.pluralsight.corejdbc.m5c1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;

public class OrderComponent {
	
	public void updateOrderQuantity(int orderNumber, int lineNumber, int newQuantity) throws Exception {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");
		
		String query = "update orderdetails set quantityOrdered=? " + 
						"where orderNumber = ? " + 
						"  and orderLineNumber = ?";
		
		PreparedStatement preparedStatement = 
				  connection.prepareStatement(query);
		
		preparedStatement.setInt(1, newQuantity);
		preparedStatement.setInt(2, orderNumber);
		preparedStatement.setInt(3, lineNumber);
		preparedStatement.executeUpdate();

		preparedStatement.close();
		connection.close();
	}
	
	public void reportOrderLine(int orderNumber, int lineNumber, boolean showCustomerName) throws Exception {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");
		
		PreparedStatement preparedStatement = 
				connection.prepareStatement(
						" SELECT" + 
				  		"	orderNumber," + 
				  		"	orderLineNumber," + 
				  		"	quantityOrdered" + 
				  		" FROM" + 
				  		"	orderdetails" + 
				  		" WHERE" + 
				  		"	    orderdetails.orderNumber = ?" + 
				  		"	AND orderdetails.orderLineNumber = ?");
				
		preparedStatement.setInt(1, orderNumber);
		preparedStatement.setDouble(2, lineNumber);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			
			int ordNum = resultSet.getInt("orderdetails.orderNumber");
			int ordLnNum = resultSet.getInt("orderdetails.orderLineNumber");
			int ordQty = resultSet.getInt("orderdetails.quantityOrdered");
			
			System.out.println("\nOrderNum  LnNum   Qty    Time");
			System.out.println("-----------------------------------");
			System.out.format("%-10d %2d %7d    %d", ordNum, ordLnNum, ordQty, (new Date()).getTime());
	
		}

		resultSet.close();
		preparedStatement.close();
		connection.close();
	}
	

}
