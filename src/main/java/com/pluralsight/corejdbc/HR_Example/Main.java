package com.pluralsight.corejdbc.HR_Example;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			HrComponent comp = new HrComponent();
		} catch (Exception exception) {
			util.ExceptionHandler.handleException(exception);
		}

	}
}
