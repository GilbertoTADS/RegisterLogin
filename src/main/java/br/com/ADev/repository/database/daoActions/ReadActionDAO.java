package br.com.ADev.repository.database.daoActions;

import java.sql.SQLException;

public interface ReadActionDAO<T> {
	/*
	 * @description : select by attributes
	 */
	T read(T param) throws SQLException;
}
