package br.com.ADev.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptographic {
	public String make(String password) 
			throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest MD = MessageDigest.getInstance("MD5");
		byte[] messageDigest = MD.digest(password.getBytes("UTF-8"));
		
		StringBuilder sb = new StringBuilder();
		
		for(byte b:messageDigest) {
			sb.append(String.format("%02X",0xFF & b));
			
		}
		String senhaHex = sb.toString();
		return senhaHex;
	}
	public boolean compare(String pass1, String pass2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return make(pass1).equals(make(pass2));
	}
}
