package br.com.ADev.presenter;

public class ResponseHTTP<T> {
	int status = 0;
	boolean error = false;
	String message = "";
	T target;
	
	public ResponseHTTP<T> setStatus(int status){
		this.status = status;
		return this;
	}
	public ResponseHTTP<T> setError(boolean error){
		this.error = true;
		return this;
	}
	public ResponseHTTP<T> setMessage(String message){
		this.message = message;
		return this;
	}
	public ResponseHTTP<T> setTarget(T target){
		this.target = target;
		return this;
	}
	public int getStatus() {
		return status;
	}
	public boolean isError() {
		return error;
	}
	public String getMessage() {
		return message;
	}
	public T getTarget() {
		return target;
	}
}
