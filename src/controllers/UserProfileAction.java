package controllers;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class UserProfileAction extends ActionSupport{
	private static final long serialVersionUID = 2650084195542815421L;
	private String username = ServletActionContext.getRequest().getSession().getAttribute("user").toString();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String execute(){
		   
		return "SUCCESS";
	}
}
