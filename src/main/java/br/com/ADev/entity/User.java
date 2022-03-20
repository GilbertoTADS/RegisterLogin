package br.com.ADev.entity;

import java.util.Calendar;

public class User {
	private String name;
	private String email;
	private String password;
	private Calendar birthDate;
	
	public User(String name,String email,String password,Calendar birthDate){
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}
	
	

}
