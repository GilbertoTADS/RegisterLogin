package br.com.ADev.database.userAction;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ADev.database.connection.ConnectionDb;
import br.com.ADev.repository.database.DTO.UserDTO;
import br.com.ADev.repository.database.daoActions.UpdateActionDAO;
import br.com.ADev.utils.DateSQLUtil;
import br.com.ADev.utils.Util;

public class UpdateUser implements UpdateActionDAO<UserDTO>{
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean update(String email, UserDTO user) {
		if(Util.isNull(email) || Util.isEmpty(email)) return false;
		
		String sql = "UPDATE `USER` SET updated_in = now() ";
		
		boolean emailExists = Util.isNotNull(user.getEmail());
		if(emailExists) sql += ", email = ? ";
		
		boolean nameExists =  Util.isNotNull(user.getName());
		if(nameExists) sql += ", name = ? ";
		
		boolean passwordExists = Util.isNotNull(user.getPass());
		if(passwordExists) sql += ", pass = ? ";
		
		boolean birthDateExists = Util.isNotNull(user.getBirthDate());
		if(birthDateExists) sql += ", birthDate = ? ";
		
		sql += " WHERE email = ? ";
		
		try {
			int columns = 0;
			PreparedStatement stmt =  ConnectionDb.getInstance().prepareStatement(sql);
			
			if(emailExists) stmt.setString(++columns, user.getEmail());
			if(nameExists) stmt.setString(++columns, user.getName());
			if(passwordExists) stmt.setString(++columns, user.getPass());
			if(birthDateExists) stmt.setDate(++columns, DateSQLUtil.toDate(user.getBirthDate()) );
			
			stmt.setString(++columns, email);
		
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
