package br.com.ADev.repository.database.daoActions;

import java.sql.SQLException;

public interface DeleteActionDAO<T> {
	/*
	 * @description : remove by attributes
	 */
	boolean delete(T param) throws SQLException;
}
