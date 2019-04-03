package edu.curso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.curso.AluguelCarro;

public class AluguelDAOImpl implements AluguelDAO {
	private Connection con;
	
	public AluguelDAOImpl() { 
		con = ConnectionFactory.getInstance().getConnection();
	}

	@Override
	public void adicionar(AluguelCarro a) {
		String sql = "INSERT INTO aluguel_carro "
				+ "(id, modelo, data_inicio, dias, valor_diaria) VALUES "
				+ "(0, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, a.getModeloCarro());
			stmt.setDate(2, new java.sql.Date(a.getDataInicio().getTime()));
			stmt.setInt(3,  a.getDias());
			stmt.setDouble(4, a.getValorDiaria());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AluguelCarro> pesquisar(Date d) {
		List<AluguelCarro> lista = new ArrayList<>();
		String sql = "SELECT * FROM aluguel_carro WHERE data_inicio=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(d.getTime()));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				AluguelCarro a = new AluguelCarro();
				a.setId(rs.getLong("id"));
				a.setModeloCarro(rs.getString("modelo"));
				a.setDataInicio(rs.getDate("data_inicio"));
				a.setDias(rs.getInt("dias"));
				a.setValorDiaria(rs.getLong("valor_diaria"));
				lista.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void remover(long id) {
		String sql = "DELETE FROM aluguel_carro WHERE id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(long id, AluguelCarro a) {
		String sql = "UPDATE aluguel_carro SET modelo=?, "
				+ "data_inicio=?, dias=?, valor_diaria=? WHERE id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, a.getModeloCarro());
			stmt.setDate(2, new java.sql.Date(a.getDataInicio().getTime()));
			stmt.setInt(3,  a.getDias());
			stmt.setDouble(4, a.getValorDiaria());
			stmt.setLong(5, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public AluguelCarro pesquisarPorId(long id) {
		String sql = "SELECT * FROM aluguel_carro WHERE id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) { 
				AluguelCarro a = new AluguelCarro();
				a.setId(rs.getLong("id"));
				a.setModeloCarro(rs.getString("modelo"));
				a.setDataInicio(rs.getDate("data_inicio"));
				a.setDias(rs.getInt("dias"));
				a.setValorDiaria(rs.getLong("valor_diaria"));
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AluguelCarro> pesquisarTodos() {
		List<AluguelCarro> lista = new ArrayList<>();
		String sql = "SELECT * FROM aluguel_carro";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				AluguelCarro a = new AluguelCarro();
				a.setId(rs.getLong("id"));
				a.setModeloCarro(rs.getString("modelo"));
				a.setDataInicio(rs.getDate("data_inicio"));
				a.setDias(rs.getInt("dias"));
				a.setValorDiaria(rs.getLong("valor_diaria"));
				lista.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
