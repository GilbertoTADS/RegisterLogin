package br.com.ADev.database.userAction;

import java.sql.SQLException;
import java.sql.Statement;

import br.com.ADev.database.connection.ConnectionDb;
import br.com.ADev.entity.User;
import br.com.ADev.repository.database.daoActions.CreateActionDAO;

public class CreateUser implements CreateActionDAO<User>{
	
	/**
	 * {@inheritDoc}
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

}
