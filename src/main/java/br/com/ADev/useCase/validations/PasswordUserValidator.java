package br.com.ADev.useCase.validations;

import br.com.ADev.entity.User;
import br.com.ADev.useCase.utils.StringUtil;

public class PasswordUserValidator implements Validator<User>{
	
	@Override
	public boolean isValid(User user) {
		if(StringUtil.isNull(user.getPassword())) return false;
		if(StringUtil.isEmpty(user.getPassword())) return false;
		return true;
	}

}
