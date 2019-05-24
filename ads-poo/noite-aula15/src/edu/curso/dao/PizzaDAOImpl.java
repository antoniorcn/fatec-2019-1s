package edu.curso.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.curso.entidade.Pizza;
public class PizzaDAOImpl implements PizzaDAO{
	
	private String connectionURL;
	private String user;
	private String pass;

	public PizzaDAOImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Driver Carregado");
			connectionURL = "jdbc:mariadb://localhost:3306/pizzaria?allowMultiQueries=true";
			user = "root";
			pass = "";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void inserir(Pizza p) {
		try {
			Connection con = 
					DriverManager.getConnection(connectionURL, user, pass);
			String sql = "INSERT INTO pizza "
					+ "(id, sabor, tamanho, ingredientes, preco, fabricacao) "
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			System.out.println(sql);
			stmt.setLong(1, p.getId());
			stmt.setString(2, p.getSabor());
			stmt.setString(3, p.getTamanho());
			stmt.setString(4, p.getIngredientes());
			stmt.setFloat(5, p.getPreco());
			Date d = new java.sql.Date(p.getFabricacao().getTime());
			stmt.setDate(6, d);
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro de conexão no banco de dados");
			e.printStackTrace();
		}
	}

	@Override
	public List<Pizza> pesquisarPorSabor(String sabor) {
		List<Pizza> lista = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(connectionURL, user, pass);

			String sql = "SELECT * from pizza where sabor like ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + sabor + "%");
			ResultSet  rs = stmt.executeQuery();		
			while (rs.next()) { 
				Pizza p = new Pizza();
				p.setId(rs.getLong("id"));
				p.setSabor(rs.getString("sabor"));
				p.setIngredientes(rs.getString("ingredientes"));
				p.setTamanho(rs.getString("tamanho"));
				p.setPreco(rs.getFloat("preco"));
				p.setFabricacao(rs.getDate("fabricacao"));
				lista.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Erro de conexão no banco de dados");
			e.printStackTrace();
		}
		return lista;
	}
}
