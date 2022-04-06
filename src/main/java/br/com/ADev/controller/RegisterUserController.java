package br.com.ADev.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.ADev.database.UserDAO;
import br.com.ADev.exceptions.BusinessRole;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.presenter.ResponseHTTP;
import br.com.ADev.repository.database.DTO.UserDTO;
import br.com.ADev.useCase.RegisterUser;

@Path("user")
public class RegisterUserController {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseHTTP<UserDTO> create(UserDTO user) {
		
		try {
			
			new RegisterUser(user,new UserDAO());
			return new ResponseHTTP<UserDTO>()
					.setStatus(Response.Status.CREATED.getStatusCode())
					.setMessage(Response.Status.CREATED.name())
					.setError(false)
					.setTarget(user);
			
		} catch (ParamException | BusinessRole e) {
			
			return new ResponseHTTP<UserDTO>()
					.setStatus(Response.Status.BAD_REQUEST.getStatusCode())
					.setMessage(e.getMessage())
					.setError(true)
					.setTarget(null);
		}
	}
}
