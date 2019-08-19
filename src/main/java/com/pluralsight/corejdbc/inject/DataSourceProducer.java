package com.pluralsight.corejdbc.inject;

import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSourceProducer {

	@Produces
	@MySqlDataSource
	public DataSource produceDataSource() {
		// read properties from somewhere here
		
		MysqlDataSource mySqldataSource = new MysqlDataSource();
		mySqldataSource.setPassword("pluralsight");
		mySqldataSource.setUser("root");
		mySqldataSource.setURL("jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC");
		
		return mySqldataSource;
	}
}
