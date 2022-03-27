package br.com.ADev.database;

import br.com.ADev.database.userAction.CreateUser;
import br.com.ADev.database.userAction.DeleteUser;
import br.com.ADev.database.userAction.ReadUser;
import br.com.ADev.database.userAction.UpdateUser;
import br.com.ADev.repository.database.DAO;
import br.com.ADev.repository.database.DTO.UserDTO;

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
	public boolean update(String email, UserDTO user) {
		return new UpdateUser().update(email, user);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(UserDTO user) {
		return new DeleteUser().delete(user);
	}

}
