package edu.curso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class TesteDB {
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Classe encontrada");
			String url = "jdbc:mariadb://localhost:3306/cartoon";
			String user = "root";
			String password = "alunofatec";
			Connection con = 
					DriverManager.getConnection(url, user, password);
			System.out.println("Conectado no servidor");
			String sql = "INSERT INTO personagem"
					+ " (id, nome, altura, forca, "
					+ "habilidade, do_mal, nascimento) VALUES "
					+ "(1, 'Thanos', 3.5, 99.8, 'destruidor de mundos',"
					+ "1, '1900-05-04')";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
