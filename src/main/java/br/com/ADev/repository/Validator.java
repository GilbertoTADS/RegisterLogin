package br.com.ADev.repository;

public interface Validator<T> {
	
	/*
	 * @description: define chain of verifications, change next Validator if result is true
	 */
	boolean isValid(T param);
	
}
