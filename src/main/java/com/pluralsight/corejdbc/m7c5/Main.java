package com.pluralsight.corejdbc.m7c5;

import javax.sql.rowset.CachedRowSet;

public class Main {

	public static void main(String[] args) throws Exception {

		try {
			DashboardComponent comp = new DashboardComponent();
			CachedRowSet rowSet = comp.orderDetailsPriceGreaterThan(200.0d);

			// Headers
			System.out.println("Cus#  Order Product  Price");
			System.out.println("---  ------ -------  ------");
			
			// Print out CachedRowSet
			while (rowSet.next()) {
				int customerNumber = rowSet.getInt("customerNumber");
				int orderNumber = rowSet.getInt("orderNumber");
				String productCode = rowSet.getString("productCode");
				double priceEach = rowSet.getDouble("priceEach");
				System.out.println(	customerNumber + "  " + 
									orderNumber + "  " + 
									productCode + " " + 
									priceEach );
			}

			rowSet.close();
		} catch (Exception exception) {
			util.ExceptionHandler.handleException(exception);
		}
	}
	
}
