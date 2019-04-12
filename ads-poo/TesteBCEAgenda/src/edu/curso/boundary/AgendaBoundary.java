package edu.curso.boundary;
import edu.curso.control.AgendaControl;
import edu.curso.entity.Agenda;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgendaBoundary extends Application implements EventHandler<ActionEvent> {
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private TextField txtNome = new TextField();
	private TextField txtTelefone = new TextField();
	private AgendaControl control = new AgendaControl();
	private TableView<Agenda> table = new TableView<>();
	
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();
		GridPane pane = new GridPane();
		pane.add(new Label("Nome: "), 0, 0);
		pane.add(txtNome, 1, 0);
		pane.add(new Label("Telefone: "), 0, 1);
		pane.add(txtTelefone, 1, 1);
		pane.add(btnAdicionar, 0,  2);
		pane.add(btnPesquisar, 1,  2);
		
		defineTableColumns();
		root.setTop(pane);
		root.setCenter(table);
		
		btnAdicionar.setOnAction(this);
		btnPesquisar.setOnAction(this);
		
		Scene scene = new Scene(root, 400, 500);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(ActionEvent evt) {
		if (evt.getTarget().equals(btnAdicionar)) { 
			System.out.println("Adicionando");
			control.adicionar(formToAgenda());
			control.pesquisar("");
		} else if (evt.getTarget().equals(btnPesquisar)) {
			System.out.println("Pesquisando");
			agendaToForm(control.pesquisar(txtNome.getText()).get(0));
		}
		
	}

	private void agendaToForm(Agenda agenda) {
		txtNome.setText(agenda.getNome());
		txtTelefone.setText(agenda.getTelefone());
	}

	private Agenda formToAgenda() {
		Agenda a = new Agenda();
		a.setNome(txtNome.getText());
		a.setTelefone(txtTelefone.getText());
		return a;
	}
	
	private void defineTableColumns() { 
		TableColumn<Agenda, String> nomeColumn = new TableColumn<>("Nome");
		nomeColumn.setCellValueFactory(
				itemData -> new ReadOnlyStringWrapper(itemData.getValue().getNome()));
		TableColumn<Agenda, String> telefoneColumn = new TableColumn<>("Telefone");
		telefoneColumn.setCellValueFactory(
				itemData -> new ReadOnlyStringWrapper(itemData.getValue().getTelefone()));		
		
		table.getColumns().addAll(nomeColumn, telefoneColumn);
		table.setItems(control.getTableData());
	}
	

}
