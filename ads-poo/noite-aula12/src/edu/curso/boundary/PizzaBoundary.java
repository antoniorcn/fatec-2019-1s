package edu.curso.boundary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.curso.control.PizzaControl;
import edu.curso.entidade.Pizza;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PizzaBoundary extends Application implements EventHandler<ActionEvent>{
	private ObservableList<String> tamanhos 
	= FXCollections.observableArrayList("pequeno", "medio", "grande");

	private TextField txtId = new TextField();
	private TextField txtSabor = new TextField();
	private TextField txtPreco = new TextField();
	private TextField txtIngredientes = new TextField();
	private ComboBox<String> cmbTamanho = new ComboBox(tamanhos);
	private TextField txtFabricacao = new TextField();
	private Button btnSalvar = new Button("Salvar");
	private Button btnPesquisar = new Button("Pesquisar");

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private PizzaControl control = new PizzaControl();
	
	private TableView tableView = new TableView();	
	@Override
	public void start(Stage stage) throws Exception {
		VBox box = new VBox();
		GridPane grid = new GridPane();
		Scene scene = new Scene(box, 300, 300);
		box.getChildren().addAll(grid, tableView);
		tableView.setStyle(STYLESHEET_MODENA);
		
		createTableColumns();
		
		grid.add(new Label("Id"), 0, 0);
		grid.add(txtId, 1, 0);
		grid.add(new Label("Sabor"), 0, 1);
		grid.add(txtSabor, 1, 1);
		grid.add(new Label("Preço"), 0, 2);
		grid.add(txtPreco, 1, 2);
		grid.add(new Label("Ingredientes"), 0, 3);
		grid.add(txtIngredientes, 1, 3);
		grid.add(new Label("Tamanho"), 0, 4);
		grid.add(cmbTamanho, 1, 4);
		grid.add(new Label("Fabricacao"), 0, 5);
		grid.add(txtFabricacao, 1, 5);
		grid.add(btnSalvar, 0, 6);
		grid.add(btnPesquisar, 1, 6);
		
		btnSalvar.addEventFilter(ActionEvent.ACTION, this);
		// btnPesquisar.setOnAction(this);
		btnPesquisar.addEventFilter(ActionEvent.ACTION, this);
		
		
		stage.setScene(scene);
		stage.setTitle("Gestão de Pizzas");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnSalvar) { 
			Pizza p = boundaryToPizza();
			control.adicionar(p);
			pizzaToBoundary(new Pizza());
		} else if (event.getTarget() == btnPesquisar) { 
			Pizza p = control.pesquisarPorSabor(txtSabor.getText());
			if (p != null) { 
				pizzaToBoundary( p );
			}
		}
	}

	private void pizzaToBoundary(Pizza p) {
		txtId.setText( String.valueOf(p.getId()) );
		txtSabor.setText( p.getSabor() );
		txtIngredientes.setText( p.getIngredientes() );
		cmbTamanho.setValue( p.getTamanho() );
		txtPreco.setText( String.format("%6.2f", p.getPreco()) );
		String strData = sdf.format( p.getFabricacao() );
		txtFabricacao.setText( strData );
	}

	private Pizza boundaryToPizza() {
		Pizza p = new Pizza();
		p.setSabor( txtSabor.getText() );
		p.setIngredientes( txtIngredientes.getText() );
		p.setTamanho( cmbTamanho.getValue() );
		try {
			p.setId( Long.parseLong(txtId.getText()) );
			p.setPreco( Float.parseFloat(txtPreco.getText()) );
			Date d = sdf.parse(txtFabricacao.getText());
			p.setFabricacao(d);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	private void createTableColumns() { 
		tableView.setItems( control.getDataList() );
		
		TableColumn<Pizza, Number> idColumn = new TableColumn<>("Id");
		idColumn.setCellValueFactory( 
				item -> new ReadOnlyLongWrapper(item.getValue().getId()));
		
		TableColumn<Pizza, String> saborColumn = new TableColumn<>("Sabor");
		saborColumn.setCellValueFactory( 
				item -> new ReadOnlyStringWrapper(item.getValue().getSabor()));
		
		tableView.getColumns().addAll(idColumn, saborColumn);
	}
}
