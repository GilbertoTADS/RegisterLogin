package br.com.ADev.repository;

import java.sql.SQLException;

public interface DAO<T> {
	
	/*
	 * @description : return true if user inserted with success 
	 */
	boolean create(T param) throws SQLException;
	/*
	 * @description : select by attributes
	 */
	T read(T param) throws SQLException;
	/*
	 * @description : return true if updated with success
	 */
	boolean update(T param) throws SQLException;
	/*
	 * @description : remove by attributes
	 */
	boolean delete(T param) throws SQLException;
	
}
