package br.com.ADev.presenter.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.ADev.controller.LoginUserController;
import br.com.ADev.controller.RegisterUserController;
import br.com.ADev.entity.User;
import br.com.ADev.presenter.HTTPResponse.ResponseHTTP;
import br.com.ADev.repository.database.DTO.UserDTO;

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
	 * @description allow user's authentication
	 * @param userDTO
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseHTTP<UserDTO> login(
			@HeaderParam(value = "email") String email,
			@HeaderParam(value = "password") String password) {
		
		return loger.login(email,password); 
	}
}
