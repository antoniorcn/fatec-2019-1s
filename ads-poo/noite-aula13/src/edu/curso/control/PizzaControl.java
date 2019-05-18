package edu.curso.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import edu.curso.entidade.Pizza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PizzaControl {
	private List<Pizza> lista = new ArrayList<>();
	private ObservableList<Pizza> dataList = FXCollections.observableArrayList();
	private String connectionURL;
	private String user;
	private String pass;
	
	public PizzaControl() { 
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
	
	public void adicionar(Pizza p) {
		lista.add(p);
		System.out.println(
				String.format("Adicionado a pizza %s na lista, tamanho: %d ", 
						p, lista.size()));
		dataList.clear();
		dataList.addAll(lista);
		
		try {
			Connection con = 
				DriverManager.getConnection(connectionURL, user, pass);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
	
	public Pizza pesquisarPorSabor(String sabor) { 
		for (Pizza p : lista) { 
			if (p.getSabor().contains(sabor)) { 
				return p;
			}
		}
		return null;
	}
	
	public void pesquisar(String sabor) { 
		dataList.clear();
		for (Pizza p : lista) { 
			if (p.getSabor().contains(sabor)) {
				dataList.add(p);
			}
		}
	}

	public ObservableList<Pizza> getDataList() {
		return dataList;
	}

	public void setDataList(ObservableList<Pizza> dataList) {
		this.dataList = dataList;
	}
}
