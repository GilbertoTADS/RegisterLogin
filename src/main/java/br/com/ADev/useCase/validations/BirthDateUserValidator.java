package br.com.ADev.useCase.validations;

import br.com.ADev.entity.User;
import br.com.ADev.repository.Validator;
import br.com.ADev.utils.DateUtil;

public class BirthDateUserValidator implements Validator<User> {

	@Override
	public boolean isValid(User user) {
		if(DateUtil.isGreaterToday(user.getBirthDate())) return false;
		return true;
	}

}
