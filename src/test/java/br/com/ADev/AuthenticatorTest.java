package br.com.ADev;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AuthenticatorTest {
	String secret = "secret";

	@Test
	void HaveToGenerateTokenBySecret() {
		String token = Authenticator.generateToken(this.secret);
		assertNotNull(token);
		
	}
	@Test
	void HaveToTokenEquals() {
		String token = Authenticator.generateToken(this.secret);
		assertNotNull(token);
		assertTrue(Authenticator.TokenEqual(token, this.secret));
	}
	
	@Test
	void HaveToTokenNotEquals() {
		String token = Authenticator.generateToken(this.secret);
		
		assertNotNull(token);
		assertFalse(Authenticator.TokenEqual(token, "wrong secret"));
	}

}
