package edu.curso.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.curso.entidade.Personagem;

public class PersonagemDAOImpl implements PersonagemDAO{
	public PersonagemDAOImpl() { 
	}
	
	@Override
	public void adicionar(Personagem p) throws DAOException {
		try {
			Connection con = ConnectionManager.getInstance().getConnection();
			System.out.println("Conectado no servidor");
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
			throw new DAOException(e);
		}
	}

	@Override
	public List<Personagem> pesquisar(String nome) throws DAOException {
		List<Personagem> lista = new ArrayList<>();
		try {
			Connection con = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM personagem WHERE nome like ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Personagem p = new Personagem();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				p.setHabilidade(rs.getString("habilidade"));
				p.setAltura(rs.getFloat("altura"));
				p.setForca(rs.getFloat("forca"));
				p.setDoMal(rs.getBoolean("do_mal"));
				p.setNascimento(rs.getDate("nascimento"));
				lista.add(p);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return lista;
	}

}
