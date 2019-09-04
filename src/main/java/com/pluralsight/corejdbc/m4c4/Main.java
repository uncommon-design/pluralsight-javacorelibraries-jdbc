package com.pluralsight.corejdbc.m4c4;

import com.pluralsight.corejdbc.m4c3.ProductsComponent;

public class Main {

public static void main(String[] args) throws Exception {
		
		final String msg = "You must specify price range as arguments (e.g. 50.0 100.0).";

		try {
			if(args.length == 2) {
				double low = Double.parseDouble(args[0]);
				double high = Double.parseDouble(args[1]);
				ProductsComponent comp = new ProductsComponent();
				comp.printProductList();
			}else {
				System.out.println(msg);
			}

		} catch (Exception exception) {
			System.out.println("\n"+msg);
			util.ExceptionHandler.handleException(exception);
		}
	}
}
