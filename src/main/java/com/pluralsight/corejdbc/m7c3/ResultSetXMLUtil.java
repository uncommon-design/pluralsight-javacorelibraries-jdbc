package com.pluralsight.corejdbc.m7c3;

import javax.sql.rowset.WebRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.ResultSet;

import javax.sql.rowset.CachedRowSet;

public class ResultSetXMLUtil {

	public void resultSetToXML(ResultSet resultSet, String fileName) throws Exception {
			
		RowSetFactory rowSetProvider = RowSetProvider.newFactory();
		WebRowSet rowSet = rowSetProvider.createWebRowSet();
		
		rowSet.populate(resultSet);
		
		FileWriter fileWriter = new FileWriter(fileName);
		rowSet.writeXml(fileWriter);
	}
	
	public CachedRowSet xmlToRowSet(String filePath) throws Exception {
		
		RowSetFactory rowSetProvider = RowSetProvider.newFactory();
		WebRowSet rowSet = rowSetProvider.createWebRowSet();
	    
	    FileReader fileReader = new FileReader(filePath);
	    rowSet.readXml(fileReader);
	    
	    return rowSet;
	}
}
