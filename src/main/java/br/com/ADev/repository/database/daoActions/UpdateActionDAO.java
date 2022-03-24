package br.com.ADev.repository.database.daoActions;

import java.sql.SQLException;

public interface UpdateActionDAO<T> {
	/*
	 * @description : return true if updated with success
	 */
	boolean update(T param) throws SQLException;
}
