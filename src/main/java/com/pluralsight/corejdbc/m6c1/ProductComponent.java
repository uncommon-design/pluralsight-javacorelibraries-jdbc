package com.pluralsight.corejdbc.m6c1;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;

import java.sql.ResultSet;

public class ProductComponent {
	
	public boolean storeBLOB(String prodLine, FileInputStream inStream) throws Exception {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");

		String sqlString = 
				"UPDATE productLines SET image = ? where productLine = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
		
		preparedStatement.setBinaryStream(1, inStream);
		
		preparedStatement.setString(2, prodLine);
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
		inStream.close();
		
		return true;
	}
	
	public InputStream readBLOB(String prodLine) throws Exception {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");

		String sqlString = 
				"SELECT image FROM productLines WHERE productLine = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
		
		preparedStatement.setString(1, prodLine);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			return resultSet.getBinaryStream(1);
		}else {
			return null;
		}

	}

	public boolean storeCLOB(String prodLine, InputStreamReader inStream) throws Exception {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");

		String sqlString = 
				"UPDATE productLines SET htmlDescription = ? where productLine = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
		
		preparedStatement.setCharacterStream(1, inStream);
		
		preparedStatement.setString(2, prodLine);
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
		inStream.close();
		
		return true;

	}
	
	public Reader readCLOB(String prodLine) throws Exception {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");

		String sqlString = 
				"SELECT htmlDescription FROM productLines WHERE productLine = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
		
		preparedStatement.setString(1, prodLine);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			return resultSet.getCharacterStream(1);
		}else {
			return null;
		}
		
	}



}
