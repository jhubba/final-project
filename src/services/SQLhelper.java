package services;

public class SQLhelper {
	
	private static final Object instance = new Object();
	
	protected SQLhelper(){
		
	}
	public static Object getInstance(){
		return instance;
	}
	
	
}
