package edu.curso.dao;

import java.util.List;
import edu.curso.entidade.Personagem;

public interface PersonagemDAO {
	void adicionar(Personagem p) throws DAOException;
	List<Personagem> pesquisar(String nome) throws DAOException;
}
