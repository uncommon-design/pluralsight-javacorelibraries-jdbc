package com.pluralsight.corejdbc.m7c1;

public class Main {

	public static void main(String[] args) throws Exception {

		try {
			OrderComponent comp = new OrderComponent();
			comp.printOrdersByStatus("In Process");
		} catch (Exception exception) {
			util.ExceptionHandler.handleException(exception);
		}
	}
}
