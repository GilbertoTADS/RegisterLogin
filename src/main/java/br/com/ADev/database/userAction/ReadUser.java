package br.com.ADev.database.userAction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

import br.com.ADev.database.connection.ConnectionDb;
import br.com.ADev.entity.User;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.repository.database.daoActions.ReadActionDAO;
import br.com.ADev.utils.Util;

public class ReadUser implements ReadActionDAO<User>{

	@Override
	public User read(User user) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM `USER` ");
		sql.append("WHERE  1 = 1 ");
		if (Util.isNull(user.getEmail())) throw new SQLException("email is required to found user");
		sql.append("AND `email` = ? ");
		
		try {
			PreparedStatement stmt = ConnectionDb.getInstance().prepareStatement(sql.toString());
			stmt.setString(1, user.getEmail());
			ResultSet result =  stmt.executeQuery(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
