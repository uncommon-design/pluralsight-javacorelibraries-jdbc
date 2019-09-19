package com.pluralsight.corejdbc.m7c5;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.Predicate;

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
		JdbcRowSet jcbcRowSet = rowSetFactory.createJdbcRowSet();
		
		jcbcRowSet.setUrl("jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");

		jcbcRowSet.setCommand(queryString);

		jcbcRowSet.execute();
		
		FilteredRowSet filteredRowSet = rowSetFactory.createFilteredRowSet();
		
		filteredRowSet.populate(jcbcRowSet);
		
		return filteredRowSet;
	}
	
	public CachedRowSet orderDetailsPriceGreaterThan(Double target) throws Exception {
		
		CachedRowSet cachedRowSet = null;
		
		synchronized (orderDetailsFRS) {
			
			RowSetFactory rowSetProvider = RowSetProvider.newFactory();
			CachedRowSet cachedOrderDetails = rowSetProvider.createCachedRowSet();
			CachedRowSet cachedOrders = rowSetProvider.createCachedRowSet();
			
			OdGtPredicate predicate = new OdGtPredicate(target);
			
			orderDetailsFRS.setFilter(predicate);
			
			cachedOrderDetails.populate(orderDetailsFRS);	
			cachedOrders.populate(ordersFRS);
			orderDetailsFRS.setFilter(null);
			
			cachedOrderDetails.setMatchColumn("orderNumber");
			cachedOrders.setMatchColumn("orderNumber");
			
			JoinRowSet joinRowSet = rowSetProvider.createJoinRowSet();
			joinRowSet.addRowSet(cachedOrderDetails);
			joinRowSet.addRowSet(cachedOrders);
			
			cachedRowSet = (CachedRowSet)joinRowSet;
		}
		return cachedRowSet;
	}

}
	