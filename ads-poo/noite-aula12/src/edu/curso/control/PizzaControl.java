package edu.curso.control;

import java.util.ArrayList;
import java.util.List;

import edu.curso.entidade.Pizza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PizzaControl {
	private List<Pizza> lista = new ArrayList<>();
	private ObservableList<Pizza> dataList = FXCollections.observableArrayList();
	
	public void adicionar(Pizza p) {
		lista.add(p);
		System.out.println(
				String.format("Adicionado a pizza %s na lista, tamanho: %d ", 
						p, lista.size()));
		dataList.clear();
		dataList.addAll(lista);
	}
	
	public Pizza pesquisarPorSabor(String sabor) { 
		for (Pizza p : lista) { 
			if (p.getSabor().contains(sabor)) { 
				return p;
			}
		}
		return null;
	}
	
	public void pesquisar(String sabor) { 
		dataList.clear();
		for (Pizza p : lista) { 
			if (p.getSabor().contains(sabor)) {
				dataList.add(p);
			}
		}
	}

	public ObservableList<Pizza> getDataList() {
		return dataList;
	}

	public void setDataList(ObservableList<Pizza> dataList) {
		this.dataList = dataList;
	}
}
