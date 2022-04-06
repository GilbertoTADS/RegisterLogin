package br.com.ADev.repository.database.DTO;

import java.io.Serializable;
import java.util.Calendar;

public class UserDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int id;
	String name;
	private String email;
	String pass;
	Calendar birthDate;
	Calendar created_in;
	Calendar deleted_in;
	Calendar updated_in;
	
	public UserDTO() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return created_in;
	}
	public void setCreate_in(Calendar create_in) {
		this.created_in = create_in;
	}
	public Calendar getDelete_in() {
		return deleted_in;
	}
	public void setDelete_in(Calendar delete_in) {
		this.deleted_in = delete_in;
	}
	public Calendar getUpdated_in() {
		return updated_in;
	}
	public void setUpdated_in(Calendar updated_in) {
		this.updated_in = updated_in;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
