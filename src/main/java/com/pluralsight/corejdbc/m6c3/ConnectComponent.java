package com.pluralsight.corejdbc.m6c3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectComponent {

	public void tryConnection() throws Exception {

		Connection con = ConnectionPool.getConnection();

		boolean validTest = con.isValid(2);

		if (validTest) {
			String msg = "   " + Thread.currentThread().getName() + " --> "
					+ this.getConnectionId(con);

			System.out.println(msg);
		}

		con.close();

	}

	public String getConnectionId(Connection con) {
		String conId = con.toString();
		int lastPos = conId.length() - 2;
		conId = conId.substring(lastPos);
		return conId;

	}

}
