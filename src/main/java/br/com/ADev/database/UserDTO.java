package br.com.ADev.database;

import java.util.Calendar;

public abstract class UserDTO {
	
	int id;
	String im;
	String pass;
	Calendar birthDate;
	Calendar create_in;
	Calendar delete_in;
	Calendar updated_in;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIm() {
		return im;
	}
	public void setIm(String im) {
		this.im = im;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Calendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	public Calendar getCreate_in() {
		return create_in;
	}
	public void setCreate_in(Calendar create_in) {
		this.create_in = create_in;
	}
	public Calendar getDelete_in() {
		return delete_in;
	}
	public void setDelete_in(Calendar delete_in) {
		this.delete_in = delete_in;
	}
	public Calendar getUpdated_in() {
		return updated_in;
	}
	public void setUpdated_in(Calendar updated_in) {
		this.updated_in = updated_in;
	}
	
	
}
