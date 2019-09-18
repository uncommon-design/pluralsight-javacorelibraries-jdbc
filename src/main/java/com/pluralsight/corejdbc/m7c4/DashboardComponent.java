package com.pluralsight.corejdbc.m7c4;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.Predicate;

public class DashboardComponent {
	
	private FilteredRowSet orderDetailsFRS;
	
	public DashboardComponent() throws Exception {
		orderDetailsFRS = populateOrderDetailsFilter();
	}
	
	public FilteredRowSet populateOrderDetailsFilter() throws Exception {

		String queryString = "select * from orderdetails WHERE priceEach";
		
		RowSetFactory rowSetProvider = RowSetProvider.newFactory();
		JdbcRowSet jcbcRowSet = rowSetProvider.createJdbcRowSet();
		
		jcbcRowSet.setUrl("jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");

		jcbcRowSet.setCommand(queryString);

		jcbcRowSet.execute();
		
		FilteredRowSet filteredRowSet = rowSetProvider.createFilteredRowSet();
		
		jcbcRowSet.beforeFirst();
		
		filteredRowSet.populate(jcbcRowSet);
		
		filteredRowSet.beforeFirst();
		
		return filteredRowSet;
	}
	
	public CachedRowSet orderDetailsPriceGreaterThan(Double target) throws Exception {
		
		CachedRowSet cachedRowSet = null;
		
		synchronized (orderDetailsFRS) {
			
			RowSetFactory rowSetProvider = RowSetProvider.newFactory();
			cachedRowSet = rowSetProvider.createCachedRowSet();

			OdGtPredicate predicate = new OdGtPredicate(target);
			
			orderDetailsFRS.setFilter(predicate);
			
			orderDetailsFRS.beforeFirst();
			
			cachedRowSet.populate(orderDetailsFRS);	
			
			cachedRowSet.beforeFirst();
		
			
			orderDetailsFRS.setFilter(null);
		}

		return cachedRowSet;

	}


}
