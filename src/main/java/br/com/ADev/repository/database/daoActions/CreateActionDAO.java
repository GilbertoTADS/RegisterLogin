package br.com.ADev.repository.database.daoActions;

import java.sql.SQLException;

public interface CreateActionDAO<T> {

	/**
	 * {@inheritDoc}
	 * @throws SQLException 
	 */
	boolean create(T param);
	
}
