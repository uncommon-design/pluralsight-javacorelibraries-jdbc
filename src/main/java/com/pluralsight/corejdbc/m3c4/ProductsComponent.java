package com.pluralsight.corejdbc.m3c4;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class ProductsComponent {

	public void printProductList() throws Exception {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM products;");
		
		while(resultSet.next()) {
			
			String name = resultSet.getString(2);
			int quantity = resultSet.getInt(7);
			double price = resultSet.getDouble(8);
			
			System.out.format("%-45s %5d %10.2f%n", name, quantity, price);
	
		}

		resultSet.close();
		statement.close();
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
