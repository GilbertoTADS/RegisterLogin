package br.com.ADev.database.userAction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.ADev.database.connection.ConnectionDb;
import br.com.ADev.repository.database.DTO.UserDTO;
import br.com.ADev.repository.database.daoActions.ReadActionDAO;
import br.com.ADev.utils.DateSQLUtil;
import br.com.ADev.utils.StringUtil;
import br.com.ADev.utils.Util;

public class ReadUser implements ReadActionDAO<UserDTO>{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDTO read(UserDTO user) {
		if (Util.isNull(user.getEmail())) return null;
		String sql = "SELECT * FROM `USER` WHERE  `deleted_in` IS NULL AND `email` = ? ";
		
		boolean passExists = StringUtil.isNotNull(user.getPass());
		if(passExists) sql += "AND `pass` = ?";
		
		try {
			PreparedStatement stmt = ConnectionDb.getInstance().prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			if(passExists) stmt.setString(2, user.getPass());
			
			ResultSet result =  stmt.executeQuery();
			while(result.next()) {
				Calendar birthDate = DateSQLUtil.toCalendar(result.getString("birthDate"));
				UserDTO userDTO = new UserDTO();
				userDTO.setId(Integer.valueOf(result.getString("id")));
				userDTO.setName(result.getString("name"));
				userDTO.setEmail(result.getString("email"));
				userDTO.setPass(result.getString("pass"));
				userDTO.setBirthDate(birthDate);
				return userDTO;
			}
			
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
