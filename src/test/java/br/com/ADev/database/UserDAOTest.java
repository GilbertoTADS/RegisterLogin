package br.com.ADev.database;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.ADev.database.connection.ConnectionDb;
import br.com.ADev.repository.database.DTO.UserDTO;

class UserDAOTest {
	UserDAO dao = new UserDAO();
	UserDTO user;
	static Connection conn;
	static {
		try {
			UserDAOTest.conn = ConnectionDb.getInstance();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@BeforeEach
	void setUp() {
		String name = "Test"+Calendar.getInstance().getTimeInMillis();
		String email = "mail"+Calendar.getInstance().getTimeInMillis()+"@mail.com";
		String password = "12345";
		Calendar birthDate = Calendar.getInstance();
		birthDate.set(1996, 8, 2);
		
		this.user = new UserDTO();
		user.setName(name);
		user.setEmail(email);
		user.setPass(password);
		user.setBirthDate(birthDate);
	}
	@AfterEach
	void removeDataOnDB() throws SQLException{
		String deleteTest = "DELETE FROM `USER` WHERE `name` LIKE 'Test%'";
		Statement stmt = conn.createStatement();
		stmt.execute(deleteTest);
	}
	
	@Test
	void createUser() {
		boolean success = dao.create(user);
		assertTrue(success);
	}
	@Test
	void noCreateUserWithRepeatedEmail() {
		String email = "mail"+Calendar.getInstance().getTimeInMillis()+"@mail.com";
		user.setEmail(email);
		boolean createad = dao.create(user);
		
		assertTrue(createad);
		assertFalse(dao.create(user));
	}
	@Test
	void readUser() {
		String email = "mail"+Calendar.getInstance().getTimeInMillis()+"@mail.com";
		user.setEmail(email);
		boolean criado = dao.create(user);
		assertTrue(criado);
		
		UserDTO userDTO = dao.read(user);
		assertTrue(userDTO != null);
		assertTrue(userDTO.getEmail().equals(email));
	}
	@Test
	void readUserByEmailAndPassowrd() {
		String name = "Test myUser";
		String email = "mail"+Calendar.getInstance().getTimeInMillis()+"@mail.com";
		String passowrd = "senha de teste para login";
		user.setName(name);
		user.setEmail(email);
		user.setPass(passowrd);
		
		boolean created = dao.create(user);
		assertTrue(created);
		
		UserDTO userDb = dao.read(user);
		assertTrue(userDb != null);
		assertTrue(userDb.getName().equals(name));
		assertTrue(userDb.getEmail().equals(email));
		assertTrue(userDb.getPass().equals(passowrd));
	}
	@Test 
	void noReadDeletedUser() {
		String email = "mail"+Calendar.getInstance().getTimeInMillis()+"@mail.com";
		
		user.setEmail(email);
		boolean criado = dao.create(user);
		assertTrue(criado);
		
		boolean deleted = dao.delete(user);
		assertTrue(deleted);
		
		UserDTO userDTO = dao.read(user);
		
		assertTrue(userDTO == null);
		
	}
	@Test
	void updateUser() {
		boolean created = dao.create(this.user);
		String oldEmail =  this.user.getEmail();
		
		String name = "Test"+Calendar.getInstance().getTimeInMillis();
		String email = "mail"+Calendar.getInstance().getTimeInMillis()+"@mail.com";
		String password = "12345 updated";
		
		this.user.setName(name);
		this.user.setEmail(email);
		this.user.setPass(password);
		
		boolean updated = dao.update(oldEmail,this.user);
		UserDTO userDb = dao.read(this.user);
		
		assertTrue(userDb != null);
		assertTrue(created);
		assertTrue(updated);
		assertTrue(userDb.getEmail().equals(email));
		assertTrue(userDb.getName().equals(name));
		
	}

}
