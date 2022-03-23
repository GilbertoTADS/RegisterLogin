package br.com.ADev.database;

import java.sql.SQLException;
import java.sql.Statement;

import br.com.ADev.database.connection.ConnectionDb;
import br.com.ADev.entity.User;
import br.com.ADev.repository.DAO;

public class UserDAO implements DAO<User>{

	/**
	 * {@inheritDoc}
	 * @throws SQLException 
	 */
	@Override
	public boolean create(User user) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO `USER` (`name`,`pass`,`birthDate`,`created_in`)");
		sql.append("VALUES ('Gilberto Carlos de Melo','1234','1996-09-02',now())");
		
		try {
			Statement stmt = ConnectionDb.getInstance().createStatement();
			return stmt.execute(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User read(User user) {
		// TODO Auto-generated method stub
		return null;
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
