package edu.curso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import edu.curso.AluguelCarro;

public class AluguelDAOImpl implements AluguelDAO {
	public AluguelDAOImpl() { 
	}

	@Override
	public void adicionar(AluguelCarro a) {
		EntityManager em = ConnectionFactory.getInstance().getEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

	@Override
	public List<AluguelCarro> pesquisar(Date d) {
		List<AluguelCarro> lista = new ArrayList<>();
		String sql = "SELECT * FROM aluguel_carro WHERE data_inicio=?";
		
		return lista;
	}

	@Override
	public void remover(long id) {
		String sql = "DELETE FROM aluguel_carro WHERE id=?";
		
	}

	@Override
	public void atualizar(long id, AluguelCarro a) {
		String sql = "UPDATE aluguel_carro SET modelo=?, "
				+ "data_inicio=?, dias=?, valor_diaria=? WHERE id=?";
		
	}

	@Override
	public AluguelCarro pesquisarPorId(long id) {
		String sql = "SELECT * FROM aluguel_carro WHERE id=?";
		
		return null;
	}

	@Override
	public List<AluguelCarro> pesquisarTodos() {
		List<AluguelCarro> lista = new ArrayList<>();
		String sql = "SELECT * FROM aluguel_carro";
		
		return lista;
	}

}
