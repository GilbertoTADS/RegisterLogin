package br.com.ADev.useCase;

import java.sql.SQLException;

import br.com.ADev.entity.User;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.repository.DAO;
import br.com.ADev.useCase.validations.EmailUserValidator;
import br.com.ADev.useCase.validations.UserValidation;

public class RegisterUser {
	private User user;
	private DAO<User> userDAO;
	
	public RegisterUser(User user, DAO<User> userDAO) throws ParamException, SQLException {
		this.user = user;
		this.userDAO = userDAO;
		
		this.isValid();
		this.execute();
		
	}
	public User getUser() {
		return this.user;
	}
	private void isValid() throws ParamException{
		boolean isValidParams = new UserValidation().isValid(this.user);
		if(!isValidParams) throw new ParamException("Invalid params - verify attributes");
	}
	private void execute() throws SQLException {
		if(this.exists()) this.userDAO.create(this.user);
	}
	private boolean exists() {
		try {
			User userDb = this.userDAO.read(user);
			return new EmailUserValidator().isValid(userDb);
		}catch(SQLException error) {
			error.printStackTrace();
			return false;
		}
		
	}
	
	
	
}
