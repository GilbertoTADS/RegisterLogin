package br.com.ADev.useCase.validations;

import br.com.ADev.entity.User;
import br.com.ADev.repository.Validator;
import br.com.ADev.utils.StringUtil;

public class NameUserValidator implements Validator<User>{

	public boolean isValid(User user) {
		if(StringUtil.isNull(user.getName())) return false;
		if(StringUtil.isEmpty(user.getName())) return false;
		return true;
	}
}
