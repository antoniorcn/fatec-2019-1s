package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDBQuery {

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/pizzaria";
			String user = "root";
			String pass = "";
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Conectado no banco");
			Statement stmt = con.createStatement();
			String sql = "SELECT * from pizza";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.next();
			System.out.println("Tamanho da pizza");
			System.out.println(rs.getString("tamanho"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
