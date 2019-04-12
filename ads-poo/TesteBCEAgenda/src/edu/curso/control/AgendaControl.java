package edu.curso.control;

import java.util.ArrayList;
import java.util.List;

import edu.curso.entity.Agenda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AgendaControl {
	private List<Agenda> lista = new ArrayList<Agenda>();
	private ObservableList<Agenda> tableData = FXCollections.observableArrayList();
	
	public void adicionar(Agenda a) { 
		lista.add(a);
	}
	
	public void remover(String nome) { 
		for (Agenda a : getTableData()) { 
			if (a.getNome().equals(nome)) { 
				lista.remove(a);
				break;
			}
		}
	}
	
	public ObservableList<Agenda> pesquisar(String nome) {
		tableData.clear();
		for (Agenda a : lista) { 
			if (a.getNome().contains(nome)) { 
				tableData.add(a);
			}
		}
		return tableData;
	}

	public ObservableList<Agenda> getTableData() {
		return tableData;
	}

	public void setTableData(ObservableList<Agenda> tableData) {
		this.tableData = tableData;
	}
	
}
