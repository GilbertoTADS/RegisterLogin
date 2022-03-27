package br.com.ADev.useCase;

import br.com.ADev.entity.User;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.repository.database.DAO;
import br.com.ADev.useCase.validations.EmailUserValidator;
import br.com.ADev.useCase.validations.UserValidation;
import br.com.ADev.utils.Util;

public class RegisterUser {
	private User user;
	private DAO<User> userDAO;
	
	public RegisterUser(User user, DAO<User> userDAO) throws ParamException {
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
	private void execute() {
		if(this.exists()) this.userDAO.create(this.user);
	}
	private boolean exists() {
		User userDb = this.userDAO.read(user);
		
		return Util.isNull(userDb) ? false : true;
	}
	
	
	
}
