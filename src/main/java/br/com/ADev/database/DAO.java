package br.com.ADev.database;

public interface DAO<T> {
	/*
	 * @description : return index that user inserted 
	 */
	String create(T param);
	/*
	 * @description : select by attributes
	 */
	T read(T param);
	/*
	 * @description : return true if updated with success
	 */
	boolean update(T param);
	/*
	 * @description : remove by attributes
	 */
	boolean delete(T param);
	
}
