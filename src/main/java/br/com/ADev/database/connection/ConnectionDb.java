package br.com.ADev.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
	private static Connection conn;
	private String address = "jdbc:mysql://localhost:3306";
	private String user = "root";
	private String password = "Eu+foco100";
	
	private ConnectionDb() throws SQLException {
		ConnectionDb.conn = DriverManager.getConnection(
				address,user,password);
	}
	public static Connection getInstance() throws SQLException {
		if(ConnectionDb.conn == null) {
			new ConnectionDb();
		}
		return ConnectionDb.conn;
	}
}
