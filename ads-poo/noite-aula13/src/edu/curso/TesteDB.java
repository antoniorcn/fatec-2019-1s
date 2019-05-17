package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDB {
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Driver Carregado");
			String connectionURL = "jdbc:mariadb://localhost:3306/pizzaria";
			String user = "root";
			String pass = "";
			Connection con = 
				DriverManager.getConnection(connectionURL, user, pass);
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO pizza "
					+ "(id, sabor, tamanho, ingredientes, preco, fabricacao) "
					+ " VALUES (0, 'Muzzarela', 'grande', 'Queijo e farinha', "
					+ " 14.99, '2019-05-17')";
			stmt.executeUpdate(sql);
			con.close();
			System.out.println("Conexão feita com o banco de dados");
		} catch (ClassNotFoundException e) {
			System.out.println("Falta o driver de banco de dados");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro de conexão no banco de dados");
			e.printStackTrace();
		}
	}
}
