package br.com.ADev.useCase;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import br.com.ADev.entity.User;
import br.com.ADev.exceptions.BusinessRole;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.repository.Validator;
import br.com.ADev.repository.database.DAO;
import br.com.ADev.repository.database.DTO.UserDTO;
import br.com.ADev.useCase.validations.EmailUserValidator;
import br.com.ADev.useCase.validations.PasswordUserValidator;
import br.com.ADev.useCase.validations.UserValidation;
import br.com.ADev.utils.Criptographic;

public class LoginUser extends UserUseCase{

	/**
	 * 
	 * {@inheritDoc}
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public LoginUser(UserDTO userDTO, DAO<UserDTO> userDAO) throws ParamException, BusinessRole {
		super(userDTO, userDAO); 
	}
	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public boolean execute() throws BusinessRole {
		Criptographic cript = new Criptographic();
		try {
			userDTO.setPass(cript.make(userDTO.getPass()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new BusinessRole(e.getMessage());
		}
		boolean exists =  this.exists();
		return exists;
	}
	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void isValid() throws ParamException {
		ArrayList<Validator<User>> validators = new ArrayList<Validator<User>>();
		validators.add(new EmailUserValidator());
		validators.add(new PasswordUserValidator());

		boolean isNotValid = !(new UserValidation(validators).isValid(this.user));
		if(isNotValid) throw new ParamException("email and password is required");
		
	}
}
