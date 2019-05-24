package edu.curso.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionManager {
	
	private String url = "jdbc:mariadb://localhost:3306/cartoon?allowMultiQueries=true";
	private String user = "root";
	private String password = "";
	private Connection con;
	private static ConnectionManager cm;

	private ConnectionManager() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionManager getInstance() { 
		if (cm == null) { 
			cm = new ConnectionManager();
		}
		return cm;
	}
	
	public Connection getConnection() throws SQLException { 
		if (con == null || con.isClosed()) {
			System.out.println("Nova conexão criada");
			con = DriverManager.getConnection(url, user, password);
		} else { 
			System.out.println("Usando a mesma conexão");
		}
		return con;
	}

}
