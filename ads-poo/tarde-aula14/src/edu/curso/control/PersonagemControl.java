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

import edu.curso.entidade.Personagem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonagemControl {
	private List<Personagem> lista = new ArrayList<>();
	private ObservableList<Personagem> tableData = FXCollections.observableArrayList();
	private String url;
	private String user;
	private String password;
	
	public PersonagemControl() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		url = "jdbc:mariadb://localhost:3306/cartoon?allowMultiQueries=true";
		user = "root";
		password = "";
	}
	
	public void adicionar(Personagem p) { 
		lista.add(p);
		tableData.clear();
		tableData.addAll(lista);
		
		try {
			Connection con = 
					DriverManager.getConnection(url, user, password);
			System.out.println("Conectado no servidor");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sql = "INSERT INTO personagem"
					+ " (id, nome, altura, forca, "
					+ "habilidade, do_mal, nascimento) VALUES (?, ?, ?, ?, ?, ?, ?)";
			System.out.println("Query de inserção: " + sql);
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, p.getId());
			stmt.setString(2, p.getNome());
			stmt.setFloat(3, p.getAltura());
			stmt.setFloat(4,  p.getForca());
			stmt.setString(5, p.getHabilidade());
			stmt.setBoolean(6,  p.isDoMal());
			java.sql.Date d = new java.sql.Date(p.getNascimento().getTime());
			stmt.setDate(7, d);
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Personagem pesquisarPorNome(String nome) { 
		for (Personagem p : lista) { 
			if(p.getNome().contains(nome)) { 
				return p;
			}
		}
		return null;
	}
	
	public void pesquisar(String nome) { 
		tableData.clear();
		for (Personagem p : lista) { 
			if(p.getNome().contains(nome)) { 
				tableData.add(p);
			}
		}
	}

	public ObservableList<Personagem> getTableData() {
		return tableData;
	}
	public void setTableData(ObservableList<Personagem> tableData) {
		this.tableData = tableData;
	}

}
