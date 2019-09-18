package com.pluralsight.corejdbc.m7c4;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.Predicate;

public class OdGtPredicate  implements Predicate{
	
	int columnIndex = 4;
	String columnName = "priceEach";
	double target = -1.0d;
	
	public OdGtPredicate(double target) {
		this.target = target;
	}
	
	public boolean test(Double value) {
		double columnValue = ((Double)value).doubleValue();
        if (columnValue > this.target) {
            return true;
        } else {
            return false;
        }
	}
	
	public boolean evaluate(Object value, int column) {
	        if (column == this.columnIndex) {
	            return test((Double)value);
	        }
	        return false;
	}
	
	public boolean evaluate(Object value, String columnName) {
	        if (columnName.equalsIgnoreCase(this.columnName)) {
	        	return test((Double)value);
	        }
	        return false;
	}
	
	public boolean evaluate(RowSet rs) {
		CachedRowSet frs = (CachedRowSet)rs;

        try {
            Double columnValue = -1.0d;

            if (this.columnIndex > 0) {
                columnValue = frs.getDouble(this.columnIndex);
            } else if (this.columnName != null) {
                columnValue = frs.getDouble(this.columnName);
            } else {
                return false;
            }

            return this.test(columnValue);
            
        } catch (Exception e) {
            util.ExceptionHandler.handleException(e);
            return false;
        }
	}
}