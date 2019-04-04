package edu.curso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.curso.Jogo;

public class JogoDAOImpl implements JogoDAO {
	private Connection con; 

	@Override
	public void adicionar(Jogo j) throws DAOException {
		con = ConnectionBuilder.getInstance().getConnection();
		try {
			String sql = "INSERT INTO jogo "
					+ "(id, nome, genero, preco, lancamento) VALUES "
					+ "(0, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, j.getNome());
			stmt.setString(2, j.getGenero());
			stmt.setDouble(3, j.getPreco());
			stmt.setDate(4, 
					new java.sql.Date(j.getLancamento().getTime()));
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	@Override
	public void atualizar(long id, Jogo j) throws DAOException {
		con = ConnectionBuilder.getInstance().getConnection();
		try {
			String sql = "UPDATE jogo SET nome=?, genero=?, "
					+ "preco=?, lancamento=? WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, j.getNome());
			stmt.setString(2, j.getGenero());
			stmt.setDouble(3, j.getPreco());
			stmt.setDate(4, 
					new java.sql.Date(j.getLancamento().getTime()));
			stmt.setLong(5, id);
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	@Override
	public void remover(long id) throws DAOException {
		con = ConnectionBuilder.getInstance().getConnection();
		try {
			String sql = "DELETE FROM jogo WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	@Override
	public List<Jogo> pesquisarPorNome(String nome) throws DAOException {
		List<Jogo> lista = new ArrayList<>();
		con = ConnectionBuilder.getInstance().getConnection();
		try {
			String sql = "SELECT * FROM jogo WHERE nome like ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) { 
				Jogo j = new Jogo();
				j.setId(rs.getLong("id"));
				j.setNome(rs.getString("nome"));
				j.setGenero(rs.getString("genero"));
				j.setLancamento(rs.getDate("lancamento"));
				j.setPreco(rs.getFloat("preco"));
				lista.add(j);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return lista;
	}

	@Override
	public List<Jogo> pesquisarTodos() throws DAOException {
		return pesquisarPorNome("");
	}

}
