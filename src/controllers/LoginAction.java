package controllers;

import java.sql.SQLException;
import java.util.Date;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import services.UserAuthenticationService;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
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
	
	@Override
	public String execute(){
		   
	       if (getUsername().equals("") || getPassword().equals("")) {
	    	   String message= "Dont leave the Username/Password blank";      
	           addActionError(message);
	           return "loginError";
	       }
	       else if (UserAuthenticationService.isValidUser(getUsername(), getPassword())) {
	    	   ServletActionContext.getRequest().getSession().setAttribute("user", getUsername());
	    	   ServletActionContext.getRequest().getSession().setAttribute("loginTime", new Date()); 
	           return "loginSuccess";
	       }
	       else {
	           String message= getText("error.login");    
	           addActionError(message);       
	           return "loginError";
	       }
	   }
}
