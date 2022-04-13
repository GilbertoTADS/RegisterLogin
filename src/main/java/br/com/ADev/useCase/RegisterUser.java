package br.com.ADev.useCase;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.com.ADev.exceptions.BusinessRole;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.repository.database.DAO;
import br.com.ADev.repository.database.DTO.UserDTO;
import br.com.ADev.useCase.validations.UserValidation;
import br.com.ADev.utils.Criptographic;

public class RegisterUser extends UserUseCase{
	
	/**
	 * 
	 * {@inheritDoc}
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
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
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@Override
	public boolean execute() throws BusinessRole{
		if(this.exists()) throw new BusinessRole("User exists on DB - verify user's email");
		String passCripted;
		try {
			passCripted = new Criptographic().make(this.userDTO.getPass());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			return false;
		}
		this.userDTO.setPass(passCripted);
		return this.userDAO.create(this.userDTO);
	}
}
