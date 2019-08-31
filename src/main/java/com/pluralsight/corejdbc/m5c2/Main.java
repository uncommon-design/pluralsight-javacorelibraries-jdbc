package com.pluralsight.corejdbc.m5c2;

public class Main {
	
	public static void main(String[] args) throws Exception{

		
		String fromManager = (args[0].split("="))[1];
		String toManager = (args[1].split("="))[1];
		
		HrComponent comp = new HrComponent();
		
		int count = comp.replaceSalesManager(fromManager, toManager);
		System.out.println(count + " Employees have been reassigned");

	}
}
