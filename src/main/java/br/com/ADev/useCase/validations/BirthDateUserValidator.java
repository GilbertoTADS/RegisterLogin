package br.com.ADev.useCase.validations;

import br.com.ADev.entity.User;
import br.com.ADev.repository.Validator;
import br.com.ADev.utils.DateUtil;
import br.com.ADev.utils.Util;

public class BirthDateUserValidator implements Validator<User> {

	@Override
	public boolean isValid(User user) {
		if(Util.isNull(user)) return false;
		if(Util.isNull(user.getBirthDate())) return false;
		
		if(DateUtil.isGreaterToday(user.getBirthDate())) return false;
		return true;
	}

}
