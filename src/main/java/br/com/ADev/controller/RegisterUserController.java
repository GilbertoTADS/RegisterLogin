package br.com.ADev.controller;

import br.com.ADev.database.UserDAO;
import br.com.ADev.entity.User;
import br.com.ADev.exceptions.BusinessRole;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.presenter.HTTPResponse.ResponseHTTP;
import br.com.ADev.repository.database.DTO.UserDTO;
import br.com.ADev.useCase.RegisterUser;

public class RegisterUserController {
	
	public RegisterUserController() {}
	
	
	public ResponseHTTP<User> register(UserDTO user) {
		try {
			
			RegisterUser ru = new RegisterUser(user,new UserDAO());
			return new ResponseHTTP<User>().setResponseCreated(ru.getUser());
			
		} catch (ParamException | BusinessRole p) {

			return new ResponseHTTP<User>().setResponseBadRequest(p.getMessage());

		}
	}
}
