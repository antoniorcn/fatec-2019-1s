package edu.curso.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/alugueis?useTimezone=true&serverTimezone=UTC";
	private static final String DB_USER = "root"; 
	private static final String DB_PASS = "alunofatec";
	
	
	private static ConnectionFactory instancia;
	private Connection con;
	
	private ConnectionFactory() {
		try {
			if (con == null || con.isClosed()) { 
				 Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver JDBC Carregado");
				con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
				System.out.println("Conexão criada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() { 
		return con;
	}
	
	public static ConnectionFactory getInstance() { 
		if (instancia == null) { 
			instancia = new ConnectionFactory();
		}
		return instancia;
	}
	

}
