package br.com.ADev.presenter.HTTPResponse;

import javax.ws.rs.core.Response;

public class ResponseHTTP<T>{

	int status = 0;
	boolean error = false;
	String message = "";
	T target;
	
	public ResponseHTTP(){}
	
	public ResponseHTTP<T> setResponseOk(T target) {
		return new ResponseHTTP<T>()
				.setStatus(Response.Status.OK.getStatusCode())
				.setMessage(Response.Status.OK.name())
				.setError(false)
				.setTarget(target);
	}
	public ResponseHTTP<T> setResponseBadRequest(String message){
		return new ResponseHTTP<T>()
				.setStatus(Response.Status.BAD_REQUEST.getStatusCode())
				.setMessage(message)
				.setError(true)
				.setTarget(null);
	}
	public  ResponseHTTP<T> setResponseCreated(T target){
		return new ResponseHTTP<T>()
				.setError(false)
				.setMessage(Response.Status.CREATED.name())
				.setStatus(Response.Status.CREATED.getStatusCode())
				.setTarget(target);
	}
	public ResponseHTTP<T> setResponseForbidden(String string) {
		return new ResponseHTTP<T>()
				.setError(true)
				.setMessage(Response.Status.FORBIDDEN.name())
				.setStatus(Response.Status.FORBIDDEN.getStatusCode())
				.setTarget(null);
	}
	private ResponseHTTP<T> setStatus(int status){
		this.status = status;
		return this;
	}
	private ResponseHTTP<T> setError(boolean error){
		this.error = error;
		return this;
	}
	private ResponseHTTP<T> setMessage(String message){
		this.message = message;
		return this;
	}
	private ResponseHTTP<T> setTarget(T target){
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