package com.pluralsight.corejdbc.m6c2;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			String employeeNumber = "1705";

			ProductComponent comp = new ProductComponent();

			comp.listProductsBy("Motorcycles");
			
		} catch (Exception exception) {
			util.ExceptionHandler.handleException(exception);
		}
	}
}
