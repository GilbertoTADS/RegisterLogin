package br.com.ADev.database.userAction;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ADev.database.UserDTO;
import br.com.ADev.database.connection.ConnectionDb;
import br.com.ADev.repository.database.daoActions.CreateActionDAO;
import br.com.ADev.utils.DateSQLUtil;

public class CreateUser implements CreateActionDAO<UserDTO>{ 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean create(UserDTO user) {
		String sql = "INSERT INTO `USER` (`name`,`email`,`pass`,`birthDate`,created_in) VALUES (?,?,?,?,now())";

		try {
			PreparedStatement stmt = ConnectionDb.getInstance().prepareStatement(sql);
			
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPass());
			stmt.setDate(4, DateSQLUtil.toDate(user.getBirthDate()));
			stmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
