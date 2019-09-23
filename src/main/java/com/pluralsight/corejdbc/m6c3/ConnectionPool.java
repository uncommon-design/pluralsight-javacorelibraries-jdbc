package com.pluralsight.corejdbc.m6c3;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {
	  
    private static HikariDataSource dataSource;
 
    static {
    	HikariConfig config = new HikariConfig();
        config.setJdbcUrl( "jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC" );
        
        // set more configuration properties
        
        dataSource = new HikariDataSource( config );
        dataSource.setMaximumPoolSize(4);
    }
 
    public ConnectionPool() {}
 
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
