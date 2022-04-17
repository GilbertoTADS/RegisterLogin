package br.com.ADev.database.connection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.ADev.exceptions.DatabaseException;

class DataBaseConfigTest {

	@Test
	void doesNotThrows() {
		assertDoesNotThrow( () -> new DataBaseConfig() );
		assertDoesNotThrow( () -> new DataBaseConfig().getProperties() );
	}
	@Test
	void getPropertiesDB() throws DatabaseException {
		DataBaseConfig dbConfig = new DataBaseConfig();
		assertEquals(dbConfig.getAddress(), "jdbc:mysql://localhost:3306/engineering");
		assertEquals(dbConfig.getPassword(), "Eu+foco100");
		assertEquals(dbConfig.getUser(), "root");
	}

}
