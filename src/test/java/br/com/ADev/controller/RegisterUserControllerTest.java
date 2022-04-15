package br.com.ADev.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.ADev.database.connection.ConnectionDb;
import br.com.ADev.entity.User;
import br.com.ADev.presenter.HTTPResponse.ResponseHTTP;
import br.com.ADev.repository.database.DTO.UserDTO;

class RegisterUserControllerTest {
	UserDTO userDTO;
	RegisterUserController ruc; 
	
	@BeforeEach
	void setUp() {
		this.userDTO = new UserDTO();
		userDTO.setName("Test RegisterUserControllerTest");
		Calendar date = Calendar.getInstance();
		date.set(2000, 8, 9);
		userDTO.setBirthDate(date);
		userDTO.setEmail("test@valid.com");
		userDTO.setPass("email1234");
		
		this.ruc = new RegisterUserController();
	}
	@AfterEach
	void removeDataOnDB() throws SQLException{
		String deleteTest = "DELETE FROM `USER` WHERE `name` LIKE 'Test%'";
		Statement stmt = ConnectionDb.getInstance().createStatement();
		stmt.execute(deleteTest);
	}
	@Test
	void registerUserWithSuccess() {
		String email = "test@registerUserWithSuccess.com";
		String password = "123abc";
		
		userDTO.setEmail(email);
		userDTO.setPass(password);
		
		ResponseHTTP<User> auxResponse = this.ruc.register(userDTO);
		assertFalse(auxResponse.isError());
		assertTrue(auxResponse.getMessage().equals("CREATED"));
		assertTrue(auxResponse.getStatus() == 201);
		assertFalse(auxResponse.getTarget().equals(null));
	}
	@Test
	void NotRegisterUserWithSameEmail() {
		String email = "test@NotRegisterUserWithSameEmail.com";
		String password = "123abc";
		
		this.userDTO.setName("Test registerUser NotRegisterUserWithSameEmail");
		this.userDTO.setEmail(email);
		this.userDTO.setPass(password);
		
		ResponseHTTP<User> auxResponse = ruc.register(this.userDTO);
		assertFalse(auxResponse.isError());
		assertTrue(auxResponse.getMessage().equals("CREATED"));
		assertTrue(auxResponse.getStatus() == 201);
		assertFalse(auxResponse.getTarget().equals(null));
		
		ResponseHTTP<User> response = ruc.register(userDTO);
		assertEquals(response.isError(),true);
		assertEquals(response.getMessage(),"User exists on DB - verify user's email");
		assertEquals(response.getStatus(), 400);
		assertEquals(response.getTarget(),null);
	}
	@Test
	void dontRegisterUserIfEmailIsInvalid() {
		String email = "email invalid";
		String password = "123abc";
		RegisterUserController ruc = new RegisterUserController();
		UserDTO userDTO = new UserDTO();
		userDTO.setName("Test regiserUser registerUserWithSuccess");
		Calendar date = Calendar.getInstance();
		date.set(2000, 8, 9);
		userDTO.setBirthDate(date);
		userDTO.setEmail(email);
		userDTO.setPass(password);
		
		ResponseHTTP<User> auxResponse = ruc.register(userDTO);
		assertTrue(auxResponse.isError());
		assertEquals(auxResponse.getMessage(),"Invalid params - verify attributes");
		assertEquals(auxResponse.getStatus(), 400);
		assertEquals(auxResponse.getTarget(),null);
	}
	@Test
	void dontRegisterUserIfPasswordIsEmpty() {
		String email = "test@dontRegisterUserIfPasswordIsEmpty.com";
		String password = "";
		RegisterUserController ruc = new RegisterUserController();
		UserDTO userDTO = new UserDTO();
		userDTO.setName("Test registerUser dontRegisterUserIfPasswordIsEmpty");
		Calendar date = Calendar.getInstance();
		date.set(2000, 8, 9);
		userDTO.setBirthDate(date);
		userDTO.setEmail(email);
		userDTO.setPass(password);
		
		ResponseHTTP<User> auxResponse = ruc.register(userDTO);
		assertTrue(auxResponse.isError());
		assertEquals(auxResponse.getMessage(),"Invalid params - verify attributes");
		assertEquals(auxResponse.getStatus(), 400);
		assertEquals(auxResponse.getTarget(),null);
	}
	@Test
	void dontRegisterUserIfPasswordIsNull() {
		String email = "test@dontRegisterUserIfPasswordIsEmpty.com";
		String password = null;
		RegisterUserController ruc = new RegisterUserController();
		UserDTO userDTO = new UserDTO();
		userDTO.setName("Test registerUser dontRegisterUserIfPasswordIsEmpty");
		Calendar date = Calendar.getInstance();
		date.set(2000, 8, 9);
		userDTO.setBirthDate(date);
		userDTO.setEmail(email);
		userDTO.setPass(password);
		
		ResponseHTTP<User> auxResponse = ruc.register(userDTO);
		assertTrue(auxResponse.isError());
		assertEquals(auxResponse.getMessage(),"Invalid params - verify attributes");
		assertEquals(auxResponse.getStatus(), 400);
		assertEquals(auxResponse.getTarget(),null);
	}

}
