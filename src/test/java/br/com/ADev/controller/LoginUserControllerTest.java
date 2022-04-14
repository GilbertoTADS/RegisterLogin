package br.com.ADev.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.ADev.database.connection.ConnectionDb;
import br.com.ADev.entity.User;
import br.com.ADev.presenter.HTTPResponse.ResponseHTTP;
import br.com.ADev.repository.database.DTO.UserDTO;

class LoginUserControllerTest {
	
	@AfterEach
	void removeDataOnDB() throws SQLException{
		String deleteTest = "DELETE FROM `USER` WHERE `name` LIKE 'Test%'";
		Statement stmt = ConnectionDb.getInstance().createStatement();
		stmt.execute(deleteTest);
	}
	@Test
	void loginUserWithSuccess() {
		String email = "test@loginUserWithSuccess.com";
		String password = "123abc";
		RegisterUserController ruc = new RegisterUserController();
		UserDTO userDTO = new UserDTO();
		userDTO.setName("Test loginRegister loginUserWithSuccess");
		Calendar date = Calendar.getInstance();
		date.set(2000, 8, 9);
		userDTO.setBirthDate(date);
		userDTO.setEmail(email);
		userDTO.setPass(password);
		
		ResponseHTTP<User> auxResponse = ruc.register(userDTO);
		assertFalse(auxResponse.isError());
		assertTrue(auxResponse.getMessage().equals("CREATED"));
		assertTrue(auxResponse.getStatus() == 201);
		assertFalse(auxResponse.getTarget().equals(null));
		
		LoginUserController luc = new LoginUserController();
		ResponseHTTP<UserDTO> response = luc.login(email, password);
		
		assertFalse(response.isError());
		assertTrue(response.getMessage().equals("OK"));
		assertTrue(response.getStatus() == 200);
		assertFalse(response.getTarget().equals(null));
	}
	@Test
	void UserAccessForbidden() {
		LoginUserController luc = new LoginUserController();
		ResponseHTTP<UserDTO> response = luc.login("test@UserAccessForbiden", "54321");
		
		assertTrue(response.isError());
		assertTrue(response.getMessage().equals("FORBIDDEN"));
		assertTrue(response.getStatus() == 403);
		assertTrue(response.getTarget() == null);
	}
	@Test
	void UserWithouPassCantAccess() {
		LoginUserController luc = new LoginUserController();
		ResponseHTTP<UserDTO> response = luc.login("test@UserWithouPassCantAccess", null);
		
		assertTrue(response.isError());
		assertEquals(response.getMessage(),"email and password is required");
		assertTrue(response.getStatus() == 400);
		assertTrue(response.getTarget() == null);
	}

}
