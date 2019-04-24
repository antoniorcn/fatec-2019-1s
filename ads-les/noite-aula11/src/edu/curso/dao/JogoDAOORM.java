package edu.curso.dao;
import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(long id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Jogo> pesquisarPorNome(String nome) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jogo> pesquisarTodos() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jogo pesquisarPorId(long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
}
