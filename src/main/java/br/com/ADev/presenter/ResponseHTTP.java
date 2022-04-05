package br.com.ADev.presenter;

public class ResponseHTTP<T> {
	int status = 200;
	boolean error = false;
	T target;
}
