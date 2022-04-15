package br.com.ADev.presenter.service;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.ADev.presenter.HTTPResponse.ResponseHTTP;
import br.com.ADev.repository.database.DTO.UserDTO;
import io.restassured.http.ContentType;

class UserServiceTest {
	UserDTO userDTO;
	
	@BeforeAll
	static void setUpAll() {
		baseURI = "http://localhost";
		port = 8080;
		basePath = "/api/v1";
	}
	@BeforeEach
	void setUpEach() {
		this.userDTO = new UserDTO();
		String name = "createUserWithSuccess";
		Calendar date = Calendar.getInstance();
		date.set(2000, 8, 9);
		String email = "createUserWithSuccess@mail"+date.getTimeInMillis()+".com";
		String password = "1234567890";
		this.userDTO.setName(name);
		this.userDTO.setEmail(email);
		
		this.userDTO.setBirthDate(date);
		this.userDTO.setPass(password);
	}
	@Test
	void createUserWithSuccess() {
		
		ResponseHTTP<?> responseAPI = given()
				.body(this.userDTO)
				.contentType(ContentType.JSON)
				.when()
					.post("/user").as(ResponseHTTP.class);
		
		assertEquals(responseAPI.getStatus(),201);
		assertEquals(responseAPI.getMessage(), "CREATED");
		assertTrue(responseAPI.getTarget() != null);
		assertEquals(responseAPI.isError(),false);
		
	}
	@Test
	void dontCreateUserWithSameEmail(){
		UserDTO userNew = this.userDTO;
		
		ResponseHTTP<?> responseAPI = given()
				.body(this.userDTO)
				.contentType(ContentType.JSON)
				.when()
					.post("/user").as(ResponseHTTP.class);
		
		assertEquals(responseAPI.getStatus(),201);
		assertEquals(responseAPI.getMessage(), "CREATED");
		assertTrue(responseAPI.getTarget() != null);
		assertEquals(responseAPI.isError(),false);
		
		ResponseHTTP<?> responseAPI2 = given()
				.body(userNew)
				.contentType(ContentType.JSON)
				.when()
					.post("/user").as(ResponseHTTP.class);
		
		assertEquals(responseAPI2.getStatus(),400);
		assertEquals(responseAPI2.getMessage(), "User exists on DB - verify user's email");
		assertTrue(responseAPI2.getTarget() == null);
		assertEquals(responseAPI2.isError(),true);
	}

}
