package br.com.ADev.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.ADev.database.UserDAO;
import br.com.ADev.exceptions.BusinessRole;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.repository.database.DTO.UserDTO;
import br.com.ADev.useCase.RegisterUser;

@Path("user")
public class RegisterUserController {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(UserDTO user) {
		UserDAO dao = new UserDAO();
		try {
			RegisterUser ru = new RegisterUser(user,dao);
			return Response.status(Response.Status.CREATED)
							.entity(ru.getUser())
							.build();
		} catch (ParamException | BusinessRole e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
							.entity(e.getMessage())
							.build();
		}
	}
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
}
