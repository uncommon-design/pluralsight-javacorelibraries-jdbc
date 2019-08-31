package com.pluralsight.corejdbc.m5c1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


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
	
}
