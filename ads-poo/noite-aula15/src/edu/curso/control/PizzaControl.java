package edu.curso.control;
import edu.curso.dao.PizzaDAO;
import edu.curso.dao.PizzaDAOImpl;
import edu.curso.entidade.Pizza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PizzaControl {
	private ObservableList<Pizza> dataList = FXCollections.observableArrayList();
	private PizzaDAO pizzaDAO = new PizzaDAOImpl();

	public PizzaControl() { 
	}

	public void adicionar(Pizza p) {
		pizzaDAO.inserir(p);
		dataList.clear();
		dataList.addAll(pizzaDAO.pesquisarPorSabor(""));
	}

	public void pesquisar(String sabor) { 
		dataList.clear();
		dataList.addAll(pizzaDAO.pesquisarPorSabor(sabor));
	}

	public ObservableList<Pizza> getDataList() {
		return dataList;
	}

	public void setDataList(ObservableList<Pizza> dataList) {
		this.dataList = dataList;
	}
}
