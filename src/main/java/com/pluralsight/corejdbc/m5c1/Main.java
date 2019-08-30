package com.pluralsight.corejdbc.m5c1;

public class Main {
	
	public static void main(String[] args) throws Exception{
		
		final String errorMsg = "Error: Must specifify a quantity as a integer";
		
		if(args.length < 1) {
			System.out.println(errorMsg);
			return;
		}
		int intValue = 0;
		String strValue = args[0];
		try {
			 intValue = Integer.parseInt(strValue);
		}catch(NumberFormatException nfe) {
			System.out.println(errorMsg);
			return;
		}

		OrderComponent comp = new OrderComponent();
		System.out.println("== Quantity before update ==");
		comp.reportOrderLine(10138, 1, true);
		comp.updateOrderQuantity(10138, 1, intValue);
		System.out.println("\n");

		System.out.println("== Quantity after update ==");
		comp.reportOrderLine(10138, 1, false);
		System.out.println("\n");

	}
}
