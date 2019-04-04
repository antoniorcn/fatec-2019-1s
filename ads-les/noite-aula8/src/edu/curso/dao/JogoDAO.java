package edu.curso.dao;

import java.util.List;

import edu.curso.Jogo;

public interface JogoDAO {
	void adicionar(Jogo g) throws DAOException;
	void atualizar(long id, Jogo g) throws DAOException;
	void remover(long id) throws DAOException;
	List<Jogo> pesquisarPorNome(String nome) throws DAOException;
	List<Jogo> pesquisarTodos() throws DAOException;
	Jogo pesquisarPorId(long id) throws DAOException;
}
