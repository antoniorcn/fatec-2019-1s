package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculadora extends Application implements EventHandler<ActionEvent>{

	private TextField txtNumeros;

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane painelPrincipal = new BorderPane();
		FlowPane painelDisplay = new FlowPane();
		painelDisplay.setHgap(20);		
		GridPane painelBotoes = new GridPane();
	      //Setting the orientation for the Tile Pane 
		//painelBotoes.setOrientation(Orientation.VERTICAL); 
		//painelBotoes.setPrefColumns(4);
		//painelBotoes.setPrefRows(4);
		String[] nomes = {	"7", "8", "9", "+", 
							"4", "5", "6", "-",
							"1", "2", "3", "*",
							",", "0", "=", "/"};
		int col = 0;
		int row = 0;
		painelBotoes.setHgap(10);
		painelBotoes.setVgap(10);
		for (int i = 0; i < 16; i++ ) {
			row = i / 4;
			col = i % 4;
			Button botao = new Button(nomes[i]);
			botao.setOnAction(this);
			botao.setPrefHeight(50);
			botao.setPrefWidth(50);
			painelBotoes.add( botao, col, row );
		}
		txtNumeros = new TextField();
		txtNumeros.setPrefHeight(50);
		Button btnCE = new Button("CE");
		btnCE.setPrefHeight(50);
		btnCE.setPrefWidth(50);
		painelDisplay.getChildren().addAll(txtNumeros, btnCE);
		painelPrincipal.setTop(painelDisplay);
		painelPrincipal.setCenter(painelBotoes);
		
		Scene scn = new Scene(painelPrincipal, 250, 300);
		
		stage.setScene(scn);
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void handle(ActionEvent event) {
		Button btn = (Button)event.getTarget();
		txtNumeros.setText(txtNumeros.getText() + btn.getText());
	}
}
