package br.com.ADev.database.connection;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class ConnectionDbTest {

	@Test
	void test() {
		assertDoesNotThrow(ConnectionDb::getInstance);
	}

}
