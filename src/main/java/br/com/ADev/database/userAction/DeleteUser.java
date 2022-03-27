package br.com.ADev.database.userAction;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ADev.database.UserDTO;
import br.com.ADev.database.connection.ConnectionDb;
import br.com.ADev.repository.database.daoActions.DeleteActionDAO;
import br.com.ADev.utils.Util;

public class DeleteUser implements DeleteActionDAO<UserDTO>{
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(UserDTO user) {
		if(Util.isNull(user.getEmail()) || Util.isEmpty(user.getEmail())) return false;
		
		String sql = "UPDATE `USER` SET deleted_in = now() WHERE `email` = ?";
		
		try {
			PreparedStatement stmt = ConnectionDb.getInstance().prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
