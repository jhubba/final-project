package services;

public class SQLhelper {
	
	private static final Object instance = new Object();
	
	protected SQLhelper(){		
	}
	
	public static Object getInstance(){
		return instance;
	}
	/*This would accept a username and a password then check the DB and return true if the username and password match*/
	public static boolean isUser(boolean user){
		return user;
	}
}
