package br.com.ADev.repository.database;

import br.com.ADev.repository.database.daoActions.CreateActionDAO;
import br.com.ADev.repository.database.daoActions.DeleteActionDAO;
import br.com.ADev.repository.database.daoActions.ReadActionDAO;
import br.com.ADev.repository.database.daoActions.UpdateActionDAO;

public interface DAO<T> extends 
							CreateActionDAO<T>,
							ReadActionDAO<T>,
							UpdateActionDAO<T>,
							DeleteActionDAO<T>{
}
