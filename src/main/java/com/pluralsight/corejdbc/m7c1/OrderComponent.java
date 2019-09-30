package com.pluralsight.corejdbc.m7c1;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.JdbcRowSet;

public class OrderComponent {

	public void printOrdersByStatus(String status) throws Exception {

		String queryString = "SELECT * FROM orders WHERE status = ?";
		
		RowSetFactory rowSetProvider = RowSetProvider.newFactory();
		
		try(JdbcRowSet rowSet = rowSetProvider.createJdbcRowSet();){
		
		rowSet.setUrl("jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");

		rowSet.setCommand(queryString);
		
		rowSet.setString(1, status);
		
		rowSet.execute();
		
		while (rowSet.next()) {

			int customerNumber = rowSet.getInt("customerNumber");
			int orderNumber = rowSet.getInt("orderNumber");

			System.out.println(customerNumber + " " + orderNumber + " " + status);
		}
		
		}
	}
}
