package edu.curso.dao;

import java.util.Date;
import java.util.List;

import edu.curso.AluguelCarro;

public interface AluguelDAO {
	void adicionar(AluguelCarro a);
	List<AluguelCarro> pesquisar(Date d);
	List<AluguelCarro> pesquisarTodos();
	AluguelCarro pesquisarPorId(long id);
	void remover(long id);
	void atualizar(long id, AluguelCarro a);
}
