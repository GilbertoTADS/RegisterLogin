package br.com.ADev.useCase.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.ADev.entity.User;
import br.com.ADev.repository.Validator;

public class EmailUserValidator implements Validator<User>{

	@Override
	public boolean isValid(User user) {
		Pattern pattern = Pattern.compile("[a-z0-9]+@[a-z]+.[a-z]+",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(user.getEmail());
		boolean emailIsCorrect = matcher.find();
		return emailIsCorrect;
	}

}
