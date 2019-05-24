package edu.curso.dao;
import java.util.List;
import edu.curso.entidade.Pizza;
public interface PizzaDAO {
	void inserir(Pizza obj);
	List<Pizza> pesquisarPorSabor(String sabor);
}
