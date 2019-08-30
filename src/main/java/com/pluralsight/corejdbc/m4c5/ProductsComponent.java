package com.pluralsight.corejdbc.m4c5;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class ProductsComponent {

	public void printProductList() throws Exception {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");
		
		PreparedStatement preparedStatement = 
				  connection.prepareStatement("SELECT * FROM products WHERE buyPrice BETWEEN ? AND ?");
				
		preparedStatement.setDouble(1, 50.00d);
		preparedStatement.setDouble(2, 100.00);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			
			String name = resultSet.getString("productName");
			int quantity = resultSet.getInt("quantityInStock");
			double price = resultSet.getDouble("buyPrice");
			
			System.out.format("%-45s %5d %10.2f%n", name, quantity, price);
	
		}

		resultSet.close();
		preparedStatement.close();
		connection.close();
	}
	
	public int getProductCount() throws Exception {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM products;");

		int count = 0;
		if (resultSet.next()) {
			count = resultSet.getInt(1);
		}

		resultSet.close();
		statement.close();
		connection.close();

		return count;
	}
	
	private void printHeader() {
		System.out.format("%-45s %5s %7s%n", "CODE", "IN STOCK", "PRICE");
		System.out.println(util.PrintUtil.repeatChars('-',62));
	}


}
