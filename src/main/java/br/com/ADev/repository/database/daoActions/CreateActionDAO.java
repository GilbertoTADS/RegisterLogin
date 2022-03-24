package br.com.ADev.repository.database.daoActions;

import java.sql.SQLException;

import br.com.ADev.entity.User;

public interface CreateActionDAO<T> {

	/**
	 * {@inheritDoc}
	 * @throws SQLException 
	 */
	boolean create(User user);
	
}
