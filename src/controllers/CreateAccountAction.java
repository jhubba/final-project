package controllers;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import services.SQLHelper;

public class CreateAccountAction extends ActionSupport{
	private static final long serialVersionUID = 3565052793853496046L;
	private String username;
	private String password;
	private String password2;
	private String firstname;
	private String lastname;
	private String email;
	
	public String createAccount(){
		boolean proceed = true;
		String usernameErrorMessage = "";
		String passwordErrorMessage = "";
		String password2ErrorMessage = "";
		String firstnameErrorMessage = "";
		String lastnameErrorMessage = "";
		String emailErrorMessage = "";
		String regex = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
		if(!getEmail().matches(regex)){
			emailErrorMessage = "*Invalid Email*";
			proceed = false;
		}
		if(!getPassword().equals(getPassword2())){
			passwordErrorMessage = "*Passwords do not match*";
		}
		if(getUsername() == "" || getUsername() == null){
			usernameErrorMessage = "*Username Field is Blank*";
			proceed = false;
		}
		if(getPassword() == "" || getPassword() == null){
			passwordErrorMessage = "*Password Field is Blank*";
			proceed = false;
		}
		if(getPassword2() == "" || getPassword2() == null){
			password2ErrorMessage = "*Password2 Field is Blank*";
			proceed = false;
		}
		if(getFirstname() == "" || getFirstname() == null){
			firstnameErrorMessage = "*FirstName Field is Blank*";
			proceed = false;
		}
		if(getLastname() == "" || getLastname() == null){
			lastnameErrorMessage ="*LastName Field is Blank*";
			proceed = false;
		}
		if(getEmail() == "" || getEmail() == null){
			emailErrorMessage = "*Email Field is Blank*";
			proceed = false;
		}
		if(SQLHelper.doesUsernameExist(getUsername())){
			usernameErrorMessage = "*User name already taken please select another*";
			proceed = false;
		}
		if(proceed == true){
			if(SQLHelper.createUser(username, password, firstname, lastname, email)){
				ServletActionContext.getRequest().getSession().setAttribute("user", getUsername());
				return "SUCCESS";
			}
			else{
				String returnErrorMessage= "There was an error creating account try again!";   
				addActionError(returnErrorMessage);
				return "FAIL";
			}
			
		}else{
			String returnErrorMessage= "There was an error processing the account please try again!";   
			addActionError(returnErrorMessage);
			if(!usernameErrorMessage.equals("")){
				addActionError(usernameErrorMessage);
			}
			if(!passwordErrorMessage.equals("")){
				addActionError(passwordErrorMessage);
			}
			if(!password2ErrorMessage.equals("")){
				addActionError(password2ErrorMessage);
			}
			if(!firstnameErrorMessage.equals("")){
				addActionError(firstnameErrorMessage);
			}
			if(!lastnameErrorMessage.equals("")){
				addActionError(lastnameErrorMessage);
			}
			if(!emailErrorMessage.equals("")){
				addActionError(emailErrorMessage);
			}      
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

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
}
