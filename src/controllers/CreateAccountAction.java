package controllers;

import com.opensymphony.xwork2.ActionSupport;

public class CreateAccountAction extends ActionSupport{
	private static final long serialVersionUID = 3565052793853496046L;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	
	public String createAccount(){
		boolean temp = false;
		if(temp == true && getUsername() != null && getPassword() != null && getFirstname() != null && getLastname() != null && getEmail() != null){
			return "SUCCESS";
		}else{
			String message= "There was an error processing the account please try again!";    
	        addActionError(message);
			return "FAIL";
		}	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
