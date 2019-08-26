package com.pluralsight.corejdbc.m3c1;

import com.pluralsight.corejdbc.m3c2.ProductsComponent;

public class Main {
	public static void main(String[] args) throws Exception{

		ProductsComponent comp = new ProductsComponent();
			
		System.out.println("The product count is " + comp.getProductCount());

	}
}
