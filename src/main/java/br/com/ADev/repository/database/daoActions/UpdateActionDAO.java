package br.com.ADev.repository.database.daoActions;

public interface UpdateActionDAO<T> {
	/**
	 * @description : return true if updated with success.If some object's value is null then this will are ignore
	 * @param indentifier to found record,and Objects with new values to update
	 */
	boolean update(String identifier,T param);
}
