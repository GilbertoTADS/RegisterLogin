package br.com.ADev.utils;

public abstract class Util {
	public static boolean isNull(Object param) {
		return param == null;
	}
	public static boolean isNotNull(Object param) {
		return !StringUtil.isNull(param);
	}
	public static boolean isEmpty(Object param) {
		return param == "";
	}
	public static boolean isNotEmpty(Object param) {
		return !isEmpty(param);
	}

}
