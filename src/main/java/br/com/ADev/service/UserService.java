package br.com.ADev.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.ADev.controller.LoginUserController;
import br.com.ADev.controller.RegisterUserController;
import br.com.ADev.database.UserDAO;
import br.com.ADev.entity.User;
import br.com.ADev.exceptions.BusinessRole;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.presenter.ResponseHTTP;
import br.com.ADev.repository.database.DTO.UserDTO;
import br.com.ADev.useCase.RegisterUser;

@Path("/user")
public class UserService {
	RegisterUserController register = new RegisterUserController();
	LoginUserController loger = new LoginUserController();
	
	/**
	 * @description utilized to insert a new user on DB
	 * @param user
	 * @return ResponseHTTP
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseHTTP<User> register(UserDTO user) {
		return register.register(user);
	}
	/**
	 * @description verify if user is registered
	 * @param userDTO
	 * @return
	 */
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(UserDTO userDTO) {
		return loger.login(userDTO);
	}
}
