package br.com.ADev.useCase;

import br.com.ADev.entity.User;
import br.com.ADev.exceptions.BusinessRole;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.repository.database.DAO;
import br.com.ADev.repository.database.DTO.UserDTO;
import br.com.ADev.useCase.validations.UserValidation;
import br.com.ADev.utils.Util;

public class RegisterUser {
	private User user;
	private UserDTO userDTO;
	private DAO<UserDTO> userDAO;
	/**
	 * 
	 * @param userDTO to transfer data between database and domain
	 * @param userDAO to do actions on database
	 * @throws ParamException throwable when some data on USER is invalid 
	 * @throws BusinessRole throwable when some role is break
	 */
	public RegisterUser(UserDTO userDTO, DAO<UserDTO> userDAO) throws ParamException, BusinessRole {
		this.user = new User(
				userDTO.getName(),
				userDTO.getEmail(),
				userDTO.getPass(),
				userDTO.getBirthDate());
		this.userDTO = userDTO;
		this.userDAO = userDAO;
		
		this.isValid();
		this.execute();
	}
	/**
	 * 
	 * @return instance of User
	 */
	public User getUser() { 
		return this.user;
	}
	/**
	 * 
	 * @throws ParamException if some User's attributes is invalid
	 */
	private void isValid() throws ParamException{
		boolean isValidParams = new UserValidation().isValid(this.user);
		if(!isValidParams) throw new ParamException("Invalid params - verify attributes");
	}
	private void execute() throws BusinessRole{
		if(this.exists()) throw new BusinessRole("User exists on DB - verify user's email");
		
		this.userDAO.create(this.userDTO);
	}
	private boolean exists() {
		UserDTO userDTODb = this.userDAO.read(userDTO);
		
		return Util.isNotNull(userDTODb);
	}
	
	
	
}
