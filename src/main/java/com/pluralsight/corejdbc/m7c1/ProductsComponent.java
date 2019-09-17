package com.pluralsight.corejdbc.m7c1;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class ProductsComponent {

	public void printProductList() throws Exception {

		RowSetFactory rowSetProvider = RowSetProvider.newFactory();
		JdbcRowSet rowSet = rowSetProvider.createJdbcRowSet();

		rowSet.setUrl("jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");
		rowSet.setCommand("SELECT * FROM products");
		rowSet.execute();

		for (int i = 0; i < 5; i++) {
			if (rowSet.next()) {
				String name = rowSet.getString("productName");
				System.out.println(name);
			} else {
				break;
			}
		}
		
		for (int i = 0; i < 5; i++) {
			if (rowSet.previous()) {
				String name = rowSet.getString("productName");
				System.out.println(name);
			} else {
				break;
			}

		}

		/*
		 * while (rowSet.next()) { String name = rowSet.getString("productName");
		 * System.out.println(name); }
		 */
		rowSet.close();

	}
}
