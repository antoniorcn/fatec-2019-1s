package edu.curso.control;
import edu.curso.dao.PersonagemDAO;
import edu.curso.dao.PersonagemDAOImpl;
import edu.curso.entidade.Personagem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonagemControl {
	private ObservableList<Personagem> tableData = FXCollections.observableArrayList();
	private PersonagemDAO personaDAO;
	
	public PersonagemControl() { 
		personaDAO = new PersonagemDAOImpl();
	}
	
	public void adicionar(Personagem p) { 
		personaDAO.adicionar(p);
		tableData.clear();
		tableData.addAll(personaDAO.pesquisar(""));
	}
	
	public void pesquisar(String nome) { 
		tableData.clear();
		tableData.addAll(personaDAO.pesquisar(nome));
	}

	public ObservableList<Personagem> getTableData() {
		return tableData;
	}
	public void setTableData(ObservableList<Personagem> tableData) {
		this.tableData = tableData;
	}

}
