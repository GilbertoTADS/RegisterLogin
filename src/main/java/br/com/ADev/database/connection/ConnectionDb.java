package br.com.ADev.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.ADev.exceptions.DatabaseException;
import br.com.ADev.repository.database.IConnection;

public class ConnectionDb implements IConnection{
	private static Connection conn;
	
	private ConnectionDb() throws SQLException {
		try {
			DataBaseConfig dbConfig = new DataBaseConfig();
			ConnectionDb.conn = DriverManager.getConnection(
					dbConfig.getAddress(),
					dbConfig.getUser(),
					dbConfig.getPassword());
			
		} catch (DatabaseException e) {
			throw new SQLException(e.getMessage());
		}
		
	}
	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */

	public static Connection getInstance() throws SQLException {
		if(ConnectionDb.conn == null) {
			new ConnectionDb();
		}
		return ConnectionDb.conn;
	}
}
