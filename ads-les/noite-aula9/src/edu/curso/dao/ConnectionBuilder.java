package edu.curso.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {
	
	private static ConnectionBuilder instancia;
	private Connection con;
	private static final String DB_URL = "jdbc:mysql://localhost:53549/jogos?useTimezone=true&serverTimezone=UTC";
	private static final String DB_USER = "azure"; 
	private static final String DB_PASS = "6#vWHD_$";
	
	private ConnectionBuilder() { 
		
	}

	public static ConnectionBuilder getInstance() {
		if (instancia == null) { 
			instancia = new ConnectionBuilder();
		}
		return instancia;
	}

	public Connection getConnection() {
		try {
			if (con == null || con.isClosed()) { 
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
