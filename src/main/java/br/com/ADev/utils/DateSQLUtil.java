package br.com.ADev.utils;

import java.util.Calendar;

public class DateSQLUtil extends Util{
	/**
	 * 
	 * @param dateSQL in format yyyy-mm-dd 
	 * @return instace of Calendar 
	 */
	public static Calendar DateToCalendar(String dateSQL) {
		Calendar date = Calendar.getInstance();
		date.set(
				Integer.valueOf(dateSQL.substring(0,3)),
				Integer.valueOf(dateSQL.substring(5,7)),
				Integer.valueOf(dateSQL.substring(8,10)));
		return date;
	}
}
