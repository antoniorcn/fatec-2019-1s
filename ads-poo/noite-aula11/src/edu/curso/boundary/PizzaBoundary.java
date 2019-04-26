package edu.curso.boundary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.curso.entidade.Pizza;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PizzaBoundary extends Application implements EventHandler<ActionEvent>{
	private TextField txtId = new TextField();
	private TextField txtSabor = new TextField();
	private TextField txtPreco = new TextField();
	private TextField txtIngredientes = new TextField();
	private TextField txtTamanho = new TextField();
	private TextField txtFabricacao = new TextField();
	private Button btnSalvar = new Button("Salvar");
	
	List<Pizza> lista = new ArrayList<>();
	
	
	@Override
	public void start(Stage stage) throws Exception {
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 300, 300);
		grid.add(new Label("Id"), 0, 0);
		grid.add(txtId, 1, 0);
		grid.add(new Label("Sabor"), 0, 1);
		grid.add(txtSabor, 1, 1);
		grid.add(new Label("Preço"), 0, 2);
		grid.add(txtPreco, 1, 2);
		grid.add(new Label("Ingredientes"), 0, 3);
		grid.add(txtIngredientes, 1, 3);
		grid.add(new Label("Tamanho"), 0, 4);
		grid.add(txtTamanho, 1, 4);
		grid.add(new Label("Fabricacao"), 0, 5);
		grid.add(txtFabricacao, 1, 5);
		grid.add(btnSalvar, 0, 6);
		
		btnSalvar.addEventFilter(ActionEvent.ACTION, this);
		
		
		stage.setScene(scene);
		stage.setTitle("Gestão de Pizzas");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(ActionEvent event) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Pizza p = new Pizza();
		p.setSabor( txtSabor.getText() );
		p.setIngredientes( txtIngredientes.getText() );
		p.setTamanho( txtTamanho.getText() );
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
		lista.add(p);
		System.out.println("Adicionado na lista, tamanho: "+ lista.size());
	}
}
