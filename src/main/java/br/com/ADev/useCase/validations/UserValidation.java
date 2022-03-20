package br.com.ADev.useCase.validations;

import java.util.ArrayList;

import br.com.ADev.entity.User;

public class UserValidation implements Validator<User>{
	private ArrayList<Validator<User>> validator = new ArrayList<Validator<User>>();
	private boolean result = true;
	
	public UserValidation() {
		this.add(new NameUserValidator())
			.add(new EmailUserValidator())
			.add(new PasswordUserValidator())
			.add(new BirthDateUserValidator());
	}
	private UserValidation add(Validator<User> validator){
		this.validator.add(validator);
		return this;
	}
	@Override
	public boolean isValid(User user) {
		for(Validator<User> v:validator ) {
			this.result = v.isValid(user);
			if(this.result == false) return false;
		}
		return this.result;
	}

}
