package br.com.ADev.useCase;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.com.ADev.entity.User;
import br.com.ADev.exceptions.BusinessRole;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.repository.database.DAO;
import br.com.ADev.repository.database.DTO.UserDTO;
import br.com.ADev.utils.Util;

public abstract class UserUseCase {
	protected User user;
	protected UserDTO userDTO;
	protected DAO<UserDTO> userDAO;
	private boolean result;
	/**
	 * @Description insert a new user on DB while instanciate a user
	 * @param userDTO
	 * @param userDAO
	 * @throws ParamException
	 * @throws BusinessRole
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public UserUseCase(UserDTO userDTO, DAO<UserDTO> userDAO) throws ParamException, BusinessRole{
		this.user = new User(
				userDTO.getName(),
				userDTO.getEmail(),
				userDTO.getPass(),
				userDTO.getBirthDate());
		this.userDTO = userDTO;
		this.userDAO = userDAO;
		
		this.isValid();
		this.result = this.execute();
	}
	public boolean getResult() {
		return this.result;
	}
	/** 
	 * 
	 * @return instance of User
	 */
	public User getUser() { 
		return this.user;
	}
	/**
	 * @description verify if attributes are valid to this use case
	 * @throws ParamException if some User's attributes is invalid
	 */
	public abstract void isValid() throws ParamException;
	/**
	 * @description execute use case
	 * @throws BusinessRole if same business role for break
	 * @return true to success and false to same error
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public abstract boolean execute() throws BusinessRole;
	
	protected boolean exists() {
		UserDTO userDTODb = this.userDAO.read(userDTO);
		
		return Util.isNotNull(userDTODb);
	}
}
