package controllers;

import com.opensymphony.xwork2.ActionSupport;

public class MainPageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(){
		return null;
	}
	
	public String createAccount(){
		return "createAccount";
	}
}
