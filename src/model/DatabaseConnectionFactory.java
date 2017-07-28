package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

public class DatabaseConnectionFactory {
	private static DatabaseConnectionFactory factory;
	private static final Properties properties = new Properties();
	
	static {
		// Load all application properties into a single-initialized variable
		// This may not reload properties when configuration changes - any possibly
		// dynamic variables shouldn't load this way
		try {
			properties.load(Class.forName("invoice.model.DatabaseConnectionFactory").getClassLoader()
					.getResourceAsStream("/config.properties"));
		} catch (ClassNotFoundException | IOException e) {
			// These errors should probably terminate execution of the application
			System.err.println("Error loading properties file");
			e.printStackTrace();
			System.exit(-1);
		}

	}
	
	private DatabaseConnectionFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// Same here - any error means we can't connect to the database
			System.err.println("Error loading JDBC driver");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public static DatabaseConnectionFactory getInstance() {
		if (factory == null) {
			factory = new DatabaseConnectionFactory();
		}
		
		return factory;
	}
	
	public Connection getDatabaseConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/midterm", properties);
		} catch (SQLException e) {
			System.err.println("Unable to obtain database connection");
			e.printStackTrace();
		}
		
		return connection;
	}
	
}