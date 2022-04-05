package br.com.ADev.utils;

public class StringUtil extends Util{
	/**
	 * @description return true if a text contains letter and/or spaces, return false if contains others characters
	 * @param text
	 * @return result boolean 
	 */
	public static boolean isAlpha(String text) {
		boolean result = text.matches("^[a-zA-Z+ ]*$");
		return result;
	}
	
}
