package com.pluralsight.corejdbc.m5c3;

public class Main {
	
	public static void main(String[] args) throws Exception{

		
		HrComponent comp = new HrComponent();
		
		int key = comp.addEmployee("Monson-Haefel", "Richard", 
									"x104", "monson@classicmodelcars.com", 
									"3", 
									"Sales Manager (NA)");
		
		System.out.println("The auto-generated primary key = " + key);

	}
}
