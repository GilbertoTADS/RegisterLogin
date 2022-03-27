package br.com.ADev.utils;

import java.sql.Date;
import java.util.Calendar;

public class DateSQLUtil extends Util{
	/**
	 * 
	 * @param dateSQL in format yyyy-mm-dd 
	 * @return instance of Calendar 
	 */
	public static Calendar toCalendar(String dateSQL) {
		Calendar date = Calendar.getInstance();
		date.set(
				Integer.valueOf(dateSQL.substring(0,3)),
				Integer.valueOf(dateSQL.substring(5,7)),
				Integer.valueOf(dateSQL.substring(8,10)));
		return date;
	}
	/**
	 * @return A Date SQL
	 */
	public static Date toDate(Calendar calendar) {
		StringBuilder dateStr = new StringBuilder();
		int year = calendar.get(Calendar.YEAR);
		dateStr.append(year);
		int month = calendar.get(Calendar.MONTH);
		dateStr.append("-");
		dateStr.append(month);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		dateStr.append("-");
		dateStr.append(day);
		return Date.valueOf(dateStr.toString());
	}
}
