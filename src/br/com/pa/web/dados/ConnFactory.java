package br.com.pa.web.dados;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnFactory {
	
	private String connectionString, login, password;
	private Connection connection;
	
	public ConnFactory() {
		connectionString = "jdbc:mysql://localhost/biblioteca";
		login = "root";
		password = "root";
	}

	public ConnFactory(String connectionString) {
		this.connectionString = connectionString;
		login = "root";
		password = "root";
	}

	public ConnFactory(String connectionString, String login, String password) {
		this.connectionString = connectionString;
		this.login = login;
		this.password = password;
	}

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionString, login, password);
		
		return connection;
	}
}
