package br.com.ADev.useCase.validations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.ADev.entity.User;

class UserValidationTest {

	static User user;
	static Calendar birthDate = Calendar.getInstance();
	
	@BeforeEach
	void setUp(){		
		UserValidationTest.birthDate.set(1996, 9, 2);
		UserValidationTest.user = new User("Gilberto","mail@mail.com","1234",birthDate);
	}
	@Test
	void userIsValid() {
		boolean userIsValid = new UserValidation().isValid(UserValidationTest.user);
		assertTrue(userIsValid);
	}
	@Test
	void userNameIsInvalid() {
		
		User user = new User("","mail@mail.com","1234",UserValidationTest.birthDate);
		
		boolean userIsValid = new UserValidation().isValid(user);
		assertFalse(userIsValid);
	}
	@Test
	void userEmailIsInvalid() {
		
		User user = new User("Gilberto","email invalido","1234",UserValidationTest.birthDate);
		
		boolean userIsValid = new UserValidation().isValid(user);
		assertFalse(userIsValid);
	}
	@Test
	void userPasswordIsInvalid() {
	
		User user = new User("Gilberto","mail@mail.com",null,UserValidationTest.birthDate);
		
		boolean userIsValid = new UserValidation().isValid(user);
		assertFalse(userIsValid);
	}
	@Test
	void userBirthDateIsInvalid() {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, 10);
		User user = new User("Gilberto","mail@mail.com","1234",date);
		
		boolean userIsValid = new UserValidation().isValid(user);
		assertFalse(userIsValid);
	}

}
