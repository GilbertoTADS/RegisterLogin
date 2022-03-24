package br.com.ADev.database;

import br.com.ADev.database.userAction.CreateUser;
import br.com.ADev.database.userAction.ReadUser;
import br.com.ADev.entity.User;
import br.com.ADev.repository.database.DAO;

public class UserDAO implements DAO<User>{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean create(User user) {
		return new CreateUser().create(user);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User read(User user) {
		new ReadUser().read(user);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
