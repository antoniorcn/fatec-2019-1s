package edu.curso.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.curso.Jogo;
public class JogoDAOORM implements JogoDAO {
	@Override
	public void adicionar(Jogo g) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void atualizar(long id, Jogo g) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		em.getTransaction().begin();
		em.merge(g);
		em.getTransaction().commit();
		em.close();
	}
	@Override
	public void remover(long id) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		Jogo j = em.find(Jogo.class, id);
		em.getTransaction().begin();
		em.remove(j);
		em.getTransaction().commit();
		em.close();
	}
	@Override
	public List<Jogo> pesquisarPorNome(String nome) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		TypedQuery<Jogo> qry = em.createQuery(
				"select j from Jogo j where nome like :nome", Jogo.class);
		qry.setParameter("nome", "%" + nome + "%");
		List<Jogo> lista = qry.getResultList();
		em.close();
		return lista;
	}
	@Override
	public List<Jogo> pesquisarTodos() throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		TypedQuery<Jogo> qry = em.createQuery("select j from Jogo j", Jogo.class);
		List<Jogo> lista = qry.getResultList();
		em.close();
		return lista;
	}

	@Override
	public Jogo pesquisarPorId(long id) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		Jogo j = em.find(Jogo.class, id);
		em.close();
		return j;
	}
}
