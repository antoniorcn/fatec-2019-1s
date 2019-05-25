package edu.curso.dao;
import java.util.List;
import edu.curso.entidade.Pizza;
public interface PizzaDAO {
	void inserir(Pizza obj) throws DAOException ;
	List<Pizza> pesquisarPorSabor(String sabor) throws DAOException ;
}
