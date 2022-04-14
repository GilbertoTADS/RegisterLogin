package br.com.ADev.controller;

import br.com.ADev.database.UserDAO;
import br.com.ADev.exceptions.BusinessRole;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.presenter.HTTPResponse.ResponseHTTP;
import br.com.ADev.repository.database.DTO.UserDTO;
import br.com.ADev.useCase.LoginUser;

public class LoginUserController {

	public ResponseHTTP<UserDTO> login(String email, String password) {
		
		try {
			UserDTO userDTO = new UserDTO();
			userDTO.setEmail(email);
			userDTO.setPass(password);
			
			boolean userExists = new LoginUser(userDTO, new UserDAO()).getResult();
			
			if(userExists) return new ResponseHTTP<UserDTO>().setResponseOk(userDTO);
			return new ResponseHTTP<UserDTO>().setResponseForbidden("email or password invalid");
		
		} catch (ParamException | BusinessRole e) {
			
			return new ResponseHTTP<UserDTO>().setResponseBadRequest(e.getMessage());
		}
	}
}