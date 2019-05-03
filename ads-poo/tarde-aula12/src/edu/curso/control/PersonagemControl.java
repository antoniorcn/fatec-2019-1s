package edu.curso.control;

import java.util.ArrayList;
import java.util.List;

import edu.curso.entidade.Personagem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonagemControl {
	private List<Personagem> lista = new ArrayList<>();
	private ObservableList<Personagem> tableData = FXCollections.observableArrayList();
	
	public void adicionar(Personagem p) { 
		lista.add(p);
	}
	
	public Personagem pesquisarPorNome(String nome) { 
		for (Personagem p : lista) { 
			if(p.getNome().contains(nome)) { 
				return p;
			}
		}
		return null;
	}
	
	public void pesquisar(String nome) { 
		tableData.clear();
		for (Personagem p : lista) { 
			if(p.getNome().contains(nome)) { 
				tableData.add(p);
			}
		}
	}

	public ObservableList<Personagem> getTableData() {
		return tableData;
	}
	public void setTableData(ObservableList<Personagem> tableData) {
		this.tableData = tableData;
	}

}
