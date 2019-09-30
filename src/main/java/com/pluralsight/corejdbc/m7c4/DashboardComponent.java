package com.pluralsight.corejdbc.m7c4;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;


public class DashboardComponent {
	
	private FilteredRowSet orderDetailsFRS;
	private FilteredRowSet ordersFRS;
	private FilteredRowSet customersFRS;
	
	public DashboardComponent() throws Exception {
		orderDetailsFRS = populateFilter("select * from orderdetails");
		ordersFRS = populateFilter("select * from orders");
		customersFRS = populateFilter("select * from customers");
	}
	
	public FilteredRowSet populateFilter(String queryString) throws Exception {
		
		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		
		try(JdbcRowSet jcbcRowSet = rowSetFactory.createJdbcRowSet();){
		
		jcbcRowSet.setUrl("jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");

		jcbcRowSet.setCommand(queryString);

		jcbcRowSet.execute();
		
		FilteredRowSet filteredRowSet = rowSetFactory.createFilteredRowSet();
		
		filteredRowSet.populate(jcbcRowSet);
		
		return filteredRowSet;
		}
	}
	
	public CachedRowSet orderDetailsPriceGreaterThan(Double target) throws Exception {
		
		CachedRowSet cachedRowSet = null;
		
		synchronized (orderDetailsFRS) {
			
			RowSetFactory rowSetProvider = RowSetProvider.newFactory();
			cachedRowSet = rowSetProvider.createCachedRowSet();

			OdGtPredicate predicate = new OdGtPredicate(target);
			
			orderDetailsFRS.setFilter(predicate);
			
			cachedRowSet.populate(orderDetailsFRS);	
			
			orderDetailsFRS.setFilter(null);
		}
		return cachedRowSet;
	}


}
