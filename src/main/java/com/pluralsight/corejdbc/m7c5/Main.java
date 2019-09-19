package com.pluralsight.corejdbc.m7c5;

import javax.sql.rowset.CachedRowSet;

public class Main {

	public static void main(String[] args) throws Exception {

		try {
			DashboardComponent comp = new DashboardComponent();
			CachedRowSet rowSet = comp.orderDetailsPriceGreaterThan(200.0d);
			
			// Print out CachedRowSet
			while (rowSet.next()) {
				String productCode = rowSet.getString("productCode");
				double priceEach = rowSet.getDouble("priceEach");
				System.out.println(productCode + " " + priceEach );
			}

			rowSet.close();
		} catch (Exception exception) {
			util.ExceptionHandler.handleException(exception);
		}
	}
	
}
