package com.pluralsight.corejdbc.m3c5;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsComponent_C {

	public void printProductList() throws Exception {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM products;");

			this.printHeader();

			while (resultSet.next()) {

				String name = resultSet.getString("productName");
				int quantity = resultSet.getInt("quantityInStock");
				double price = resultSet.getDouble("buyPrice");

				System.out.format("%-45s %5d %10.2f%n", name, quantity, price);

			}

			
		} catch (Exception exception) {				
			if(exception instanceof SQLException) {
				SQLException sqlException = (SQLException)exception;
				System.out.println("Error Code: " 			+ sqlException.getErrorCode());
				System.out.println("SQL State: " 			+ sqlException.getSQLState());
			}
			System.out.println("SQLException message: " + exception.getMessage());
			System.out.print("Stacktrace: "); 			  exception.printStackTrace();
			
		} finally {
			
			try { resultSet.close(); }
			catch(Exception ex) {
					System.out.println("ResultSet.close(): " + ex.getMessage());
			}
			
			try { statement.close(); }
			catch(Exception ex) {
					System.out.println("Statement.close(): " + ex.getMessage());
			}
			
			try { connection.close(); }
			catch(Exception ex) {
					System.out.println("Connection.close(): " + ex.getMessage());
			}
			
			
		}
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
		System.out.println(util.PrintUtil.repeatChars('-', 62));
	}

}
