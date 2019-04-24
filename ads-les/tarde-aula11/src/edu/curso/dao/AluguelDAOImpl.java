package edu.curso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
		em.close();
	}

	@Override
	public List<AluguelCarro> pesquisar(Date d) {
		EntityManager em = ConnectionFactory.getInstance().getEntityManager();
		String sql = "select ac from aluguel_carros ac where dataInicio = :data";
		TypedQuery<AluguelCarro> qry = em.createQuery(sql, AluguelCarro.class);
		qry.setParameter("data", d);
		List<AluguelCarro> lista = qry.getResultList();
		em.close();
		return lista;
	}

	@Override
	public void remover(long id) {
		EntityManager em = ConnectionFactory.getInstance().getEntityManager();
		AluguelCarro ac = em.find(AluguelCarro.class, id);
		em.getTransaction().begin();
		em.remove(ac);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void atualizar(long id, AluguelCarro a) {
		EntityManager em = ConnectionFactory.getInstance().getEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public AluguelCarro pesquisarPorId(long id) {
		EntityManager em = ConnectionFactory.getInstance().getEntityManager();
		AluguelCarro ac = em.find(AluguelCarro.class, id);
		em.close();
		return ac;
	}

	@Override
	public List<AluguelCarro> pesquisarTodos() {
		EntityManager em = ConnectionFactory.getInstance().getEntityManager();
		String sql = "select ac from aluguel_carros ac";
		TypedQuery<AluguelCarro> qry = em.createQuery(sql, AluguelCarro.class);
		List<AluguelCarro> lista = qry.getResultList();
		em.close();
		return lista;
	}

}
