package controllers;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	private static final long serialVersionUID = -6164261795412070623L;
	private String username, password;
		
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public String execute() {
		if (ServletActionContext.getRequest().getSession().getAttribute("user") != null) {
			ServletActionContext.getRequest().getSession().setAttribute("user", null);
			setUsername(null);
			return "logout";	
		} else {
			return ""; 
		}		
	}
}