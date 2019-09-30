package com.pluralsight.corejdbc.m7c3;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

public class Main {

	public static void main(String[] args) throws Exception {

		String fileName = "employees.xml";

		ResultSetXMLUtil comp = new ResultSetXMLUtil();

		try (Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employees");) {

		// Read from database and write to file
		comp.resultSetToXML(resultSet, fileName);

		// Convert XML file to CachedRowSet
		try(CachedRowSet rowSet = comp.xmlToRowSet(fileName);){

		// Print out CachedRowSet
		while (rowSet.next()) {
			int employeeNumber = rowSet.getInt("employeeNumber");
			String lastName = rowSet.getString("lastName");
			String firstName = rowSet.getString("firstName");

			System.out.println(employeeNumber + " " + firstName + " " + lastName);
		}

		}} catch (Exception exception) {
			util.ExceptionHandler.handleException(exception);
		}
	}
}
