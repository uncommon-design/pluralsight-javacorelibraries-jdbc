package com.pluralsight.corejdbc.HR_Example;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class HrComponent {

	public void updateEmployeeManager(String employeeId, String managerId) throws Exception {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");
		
		PreparedStatement preparedStatement = 
				  connection.prepareStatement("UPDATE employees SET reportsTo = ? WHERE employeeNumber = ?");
				
		preparedStatement.setString(1, employeeId);
		preparedStatement.setString(2, managerId);
		preparedStatement.executeUpdate();

		preparedStatement.close();
		connection.close();
	}
	
	public void replaceSalesManager(String managerBeingReplaced, String replacementManager) throws Exception{
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");
		
		PreparedStatement preparedStatement = 
				  connection.prepareStatement("UPDATE employees SET reportsTo = ? WHERE reportsTo = ?");
				
		preparedStatement.setString(1, managerBeingReplaced);
		preparedStatement.setString(2, replacementManager);
		preparedStatement.executeUpdate();

		preparedStatement.close();
		connection.close();
		
	}

}
