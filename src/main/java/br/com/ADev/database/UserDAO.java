package br.com.ADev.database;

import br.com.ADev.database.userAction.CreateUser;
import br.com.ADev.database.userAction.ReadUser;
import br.com.ADev.entity.User;
import br.com.ADev.repository.database.DAO;

public class UserDAO implements DAO<UserDTO>{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean create(UserDTO user) {
		return new CreateUser().create(user);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDTO read(UserDTO user) {
		return new ReadUser().read(user);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean update(UserDTO user) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(UserDTO user) {
		// TODO Auto-generated method stub
		return false;
	}

}
