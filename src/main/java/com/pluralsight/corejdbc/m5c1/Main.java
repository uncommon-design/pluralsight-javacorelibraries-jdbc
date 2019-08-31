package com.pluralsight.corejdbc.m5c1;

public class Main {
	
	public static void main(String[] args) throws Exception{

		int orderNumber = Integer.parseInt(args[0]);
		int lineNumber = Integer.parseInt(args[1]);
		int newQuantity = Integer.parseInt(args[2]);
		
		OrderComponent comp = new OrderComponent();
		comp.updateOrderQuantity(orderNumber, lineNumber, newQuantity);
		
		System.out.println("Quantity changed to " + newQuantity);

	}
}
