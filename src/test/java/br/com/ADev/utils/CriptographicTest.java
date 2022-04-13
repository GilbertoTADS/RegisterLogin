package br.com.ADev.utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;

class CriptographicTest {

	@Test
	void generateHash() {
		String pass = "123456";
		
		Criptographic cript = new Criptographic();
		assertDoesNotThrow(() -> { cript.make(pass); });
		
	}
	@Test
	void passwordsAreEqual() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String pass = "123456";
		Criptographic cript = new Criptographic();
		boolean equals = cript.compare(pass, pass);
		assertTrue(equals);
	}
	@Test
	void passwordAreDiferent() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String pass = "123456";
		String diferent = "diferent";
		Criptographic cript = new Criptographic();
		boolean equals = cript.compare(pass, diferent);
		assertFalse(equals);
		
	}

}
