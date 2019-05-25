package edu.curso.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static ConnectionManager instancia;
	private Connection con;
	private String connectionURL = "jdbc:mariadb://localhost:3306/pizzaria?allowMultiQueries=true";
	private String user = "root";
	private String pass = "";
	
	private ConnectionManager() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Driver Carregado");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionManager getInstance() { 
		if (instancia == null) { 
			instancia = new ConnectionManager();
		}
		return instancia;
	}
	
	public Connection getConnection() throws SQLException { 
		if (con == null || con.isClosed()) { 
			con = DriverManager.getConnection(connectionURL, user, pass);
			System.out.println("Gerada uma nova conexão");
		} else {
			System.out.println("Reusando uma conexão existente");
		}
		return con;
	}
	
	

}
