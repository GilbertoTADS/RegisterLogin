package br.com.ADev.exceptions;

/**
 * 
 * @author Gilberto
 * 
 */
public class DatabaseException extends Exception{
	
	private static final long serialVersionUID = 1L;

	/**
	 * @description use this exception when setting database fail
	 * @param message
	 */
	public DatabaseException(String message) {
		super(message);
	}

}
