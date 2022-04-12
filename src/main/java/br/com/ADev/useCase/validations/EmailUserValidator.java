package br.com.ADev.useCase.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.ADev.entity.User;
import br.com.ADev.repository.Validator;
import br.com.ADev.utils.StringUtil;
import br.com.ADev.utils.Util;

public class EmailUserValidator implements Validator<User>{

	@Override
	public boolean isValid(User user) {
		if(Util.isNull(user)) return false;
		if(StringUtil.isNull(user.getEmail())) return false;
		if(StringUtil.isEmpty(user.getEmail())) return false;
		
		Pattern pattern = Pattern.compile("[a-z0-9]+@[a-z]+.[a-z]+",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(user.getEmail());
		boolean emailIsCorrect = matcher.find();
		return emailIsCorrect;
	}

}
