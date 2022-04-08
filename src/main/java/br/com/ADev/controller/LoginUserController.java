package br.com.ADev.controller;

import javax.ws.rs.core.Response;

import br.com.ADev.repository.database.DTO.UserDTO;

public class LoginUserController {
	
	public Response login(UserDTO userDTO) {
		return Response.status(Response.Status.ACCEPTED).entity("funcionou").build();
	}

}
