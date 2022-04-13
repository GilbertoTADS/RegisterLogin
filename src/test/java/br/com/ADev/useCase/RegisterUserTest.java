package br.com.ADev.useCase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.ADev.database.UserDAO;
import br.com.ADev.database.connection.ConnectionDb;
import br.com.ADev.entity.User;
import br.com.ADev.exceptions.BusinessRole;
import br.com.ADev.exceptions.ParamException;
import br.com.ADev.repository.database.DTO.UserDTO;

class RegisterUserTest {

	static User user;
	static UserDTO userDTO;
	static UserDAO dao = new UserDAO();
	
	@BeforeEach
	void setUp() {
		String name = "Test userTest";
		String email = "mail"+Calendar.getInstance().getTimeInMillis()+"@mail.com";
		String password = "12345";
		Calendar birthDate = Calendar.getInstance();
		birthDate.set(1996, 8, 2);
		
		RegisterUserTest.user = new User(name,email,password,birthDate);
		RegisterUserTest.userDTO = new UserDTO();
		RegisterUserTest.userDTO.setName(user.getName());
		RegisterUserTest.userDTO.setEmail(user.getEmail());
		RegisterUserTest.userDTO.setPass(user.getPassword());
		RegisterUserTest.userDTO.setBirthDate(user.getBirthDate());
		
	}
	@AfterEach
	void removeDataOnDB() throws SQLException{
		String deleteTest = "DELETE FROM `USER` WHERE `name` LIKE 'Test%'";
		Statement stmt = ConnectionDb.getInstance().createStatement();
		stmt.execute(deleteTest);
	}
	@Test
	void notInsertUserOnDbWhenEmailIsNull() {
		RegisterUserTest.userDTO.setEmail(null);
		
		assertThrows(
				ParamException.class, 
				() -> new RegisterUser(
						RegisterUserTest.userDTO,
						RegisterUserTest.dao)
				);
		
	}
	@Test
	void notInsertUserOnDbWhenEmailOnlyExistsOne() {
		RegisterUserTest.userDTO.setEmail("justExists@gmail.com");
		
		assertDoesNotThrow( () -> new RegisterUser(userDTO, dao) );
		
		assertThrows(
				BusinessRole.class, 
				() -> new RegisterUser(
						RegisterUserTest.userDTO,
						RegisterUserTest.dao)
				);
		
	}
	@Test
	void insertUserDb() {

		assertDoesNotThrow(
				() -> new RegisterUser(
						RegisterUserTest.userDTO,
						RegisterUserTest.dao)
				);
		UserDTO userDb = dao.read(userDTO);
		assertTrue(userDb != null);
	}


}
