package com.pluralsight.jdbc.m2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ClassicModelsDB {

	public static final javax.sql.DataSource dataSource;
	
	static {
		// read properties from somewhere here
		
		MysqlDataSource mySqldataSource = new MysqlDataSource();
		mySqldataSource.setPassword("pluralsight");
		mySqldataSource.setUser("root");
		mySqldataSource.setURL("jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC");
		dataSource = mySqldataSource;
	}
}
