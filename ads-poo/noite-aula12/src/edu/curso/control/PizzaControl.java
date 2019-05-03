package edu.curso.control;

import java.util.ArrayList;
import java.util.List;

import edu.curso.entidade.Pizza;

public class PizzaControl {
	private List<Pizza> lista = new ArrayList<>();
	
	public void adicionar(Pizza p) { 
		lista.add(p);
		System.out.println(
				String.format("Adicionado a pizza %s na lista, tamanho: %d ", 
						p, lista.size()));
	}
	
	public Pizza pesquisarPorSabor(String sabor) { 
		for (Pizza p : lista) { 
			if (p.getSabor().contains(sabor)) { 
				return p;
			}
		}
		return null;
	}
}
