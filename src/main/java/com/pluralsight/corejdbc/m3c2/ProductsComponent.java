/**
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.pluralsight.corejdbc.m3c2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.inject.Inject;
import javax.sql.DataSource;
import com.pluralsight.corejdbc.inject.MySqlDataSource;

public class ProductsComponent{
	

	@Inject
	@MySqlDataSource
	private DataSource ds;
	
	public int getProductCount() throws Exception{
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {

			conn = ds.getConnection();
			stmt = conn.createStatement();    		
    		rs = stmt.executeQuery("SELECT COUNT(*) FROM products;");
    		
    		if(rs.next()) {
				int count = rs.getInt(1);
				return count;
			}
    		return 0;
    				   
		}finally {
    		try { if (rs != null) rs.close(); } catch (Exception e) {};
    		try { if (stmt != null) stmt.close(); } catch (Exception e) {};
    		try { if (conn != null) conn.close(); } catch (Exception e) {};
    	}

	}
}
