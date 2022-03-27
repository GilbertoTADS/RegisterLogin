package br.com.ADev.repository.database.daoActions;

public interface ReadActionDAO<T> {
	/*
	 * @description : select by attributes
	 */
	T read(T param);
}
