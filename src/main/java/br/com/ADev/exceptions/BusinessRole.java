package br.com.ADev.exceptions;

public class BusinessRole extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @description use this exception when same role business was break
	 * @param message
	 */
	public BusinessRole(String message) {
		super(message);
	}
}
