package br.com.ADev.database.userAction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.ADev.database.UserDTO;
import br.com.ADev.database.connection.ConnectionDb;
import br.com.ADev.repository.database.daoActions.ReadActionDAO;
import br.com.ADev.utils.DateSQLUtil;
import br.com.ADev.utils.Util;

public class ReadUser implements ReadActionDAO<UserDTO>{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDTO read(UserDTO user) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM `USER` ");
		sql.append("WHERE  1 = 1 ");
		
		if (Util.isNotNull(user.getEmail())) sql.append("AND `email` = ? ");
		else return null;
		
		try {
			PreparedStatement stmt = ConnectionDb.getInstance().prepareStatement(sql.toString());
			stmt.setString(0, user.getEmail());
			ResultSet result =  stmt.executeQuery(sql.toString());
			Calendar birthDate = DateSQLUtil.toCalendar(result.getNString("birthDate"));
			UserDTO userDTO = new UserDTO();
			userDTO.setName(result.getNString("name"));
			userDTO.setEmail(result.getNString("email"));
			userDTO.setPass(result.getNString("pass"));
			userDTO.setBirthDate(birthDate);
			return userDTO;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
