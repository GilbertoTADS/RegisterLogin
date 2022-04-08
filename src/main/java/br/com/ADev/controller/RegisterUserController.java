package br.com.ADev.controller;

import javax.ws.rs.core.Response;

import br.com.ADev.database.UserDAO;
import br.com.ADev.entity.User;
import br.com.ADev.exceptions.BusinessRole;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.presenter.ResponseHTTP;
import br.com.ADev.repository.database.DTO.UserDTO;
import br.com.ADev.useCase.RegisterUser;

public class RegisterUserController {
	
	public RegisterUserController() {}
	
	
	public ResponseHTTP<User> register(UserDTO user) {
		try {
			
			RegisterUser ru = new RegisterUser(user,new UserDAO());
			return new ResponseHTTP<User>()
					.setStatus(Response.Status.CREATED.getStatusCode())
					.setMessage(Response.Status.CREATED.name())
					.setError(false)
					.setTarget(ru.getUser());
			
		} catch (ParamException | BusinessRole e) {
			
			return new ResponseHTTP<User>()
					.setStatus(Response.Status.BAD_REQUEST.getStatusCode())
					.setMessage(e.getMessage())
					.setError(true)
					.setTarget(null);
		}
	}
}
