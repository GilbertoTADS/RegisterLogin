package br.com.ADev.database.userAction;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ADev.database.UserDTO;
import br.com.ADev.database.connection.ConnectionDb;
import br.com.ADev.entity.User;
import br.com.ADev.repository.database.daoActions.CreateActionDAO;
import br.com.ADev.utils.DateSQLUtil;

public class CreateUser implements CreateActionDAO<UserDTO>{ 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean create(UserDTO user) {
		String sql = "INSERT INTO `USER` (`name`,`pass`,`birthDate`) VALUES (?,?,?)";

		try {
			PreparedStatement stmt = ConnectionDb.getInstance().prepareStatement(sql);
			ConnectionDb.getInstance().setAutoCommit(true);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPass());
			stmt.setDate(3, DateSQLUtil.toDate(user.getBirthDate()));
			return stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
