package br.com.ADev;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;

public class Authenticator {
	private static final String methodAuth = "auth0";

	public Authenticator() {
		
	}
	
	public static String generateToken(String secret){
		Algorithm algorithmHS = Algorithm.HMAC256(secret);
		
		String token = JWT.create()
			.withIssuer(Authenticator.methodAuth)
			.sign(algorithmHS);
		
		return token;
	}
	public static boolean TokenEqual(String token,String secret) {
		Algorithm algorithmHS = Algorithm.HMAC256(secret);
		try {
			JWTVerifier verifier = JWT.require(algorithmHS)
					.withIssuer(Authenticator.methodAuth)
					.build();
			verifier.verify(token);
			return true;
		}catch(JWTVerificationException ex) {
			return false;
		}
	}
}
