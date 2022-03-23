package br.com.ADev.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil extends Util{
	
	public static boolean isGreaterToday(Calendar date) {
		long today = new Date().getTime();
		long minor = date.getTime().getTime();
		boolean result = minor > today;
		return result;
	
	}
	
}
