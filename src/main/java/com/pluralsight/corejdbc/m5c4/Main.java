package com.pluralsight.corejdbc.m5c4;

import java.sql.SQLException;

public class Main  {

	public static void main(String[] args) throws Exception {

		try {
			int orderNumber = 10421;
			String productCode = "S18_2795";

			if (args.length > 0) {
				String orderNum = (args[0].split("="))[1];
				orderNumber = Integer.parseInt(orderNum);

				productCode = (args[1].split("="))[1];

			}

			OrderComponent comp = new OrderComponent();
			int count = comp.deleteOrderline(orderNumber, productCode);

			System.out.println(count + " records deleted");

		} catch (Exception exception) {
			util.ExceptionHandler.handleException(exception);
		}

	}


}
