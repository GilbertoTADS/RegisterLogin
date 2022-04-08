package br.com.ADev.useCase;

import br.com.ADev.exceptions.BusinessRole;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.repository.database.DAO;
import br.com.ADev.repository.database.DTO.UserDTO;
import br.com.ADev.useCase.validations.UserValidation;

public class RegisterUser extends UserUseCase{
	
	/**
	 * 
	 * {@inheritDoc}
	 */
	public RegisterUser(UserDTO userDTO, DAO<UserDTO> userDAO) throws ParamException, BusinessRole {
		super(userDTO,userDAO);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isValid() throws ParamException{
		boolean isValidParams = new UserValidation().isValid(this.user);
		if(!isValidParams) throw new ParamException("Invalid params - verify attributes");
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean execute() throws BusinessRole{
		if(this.exists()) throw new BusinessRole("User exists on DB - verify user's email");
		
		return this.userDAO.create(this.userDTO);
	}
}
