package br.com.ADev.repository.database;

import java.sql.Connection;

/**
 * @description this connection is a singleton
 * @return return a instance of Connection
 * @throws SQLException
 */
public interface IConnection {
	Connection instace = null;
}
