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
public class Calculadora extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane painelPrincipal = new BorderPane();
		FlowPane painelDisplay = new FlowPane();
		GridPane painelBotoes = new GridPane();
		painelDisplay.setHgap(5);
		
		TextField txtDisplay = new TextField();
		txtDisplay.setPrefWidth(130);
		Button btnCE = new Button("CE");
		btnCE.setPrefWidth(40);
		btnCE.setPrefHeight(40);
		painelDisplay.getChildren().addAll(txtDisplay, btnCE);
		
		painelBotoes.setHgap(5);
		painelBotoes.setVgap(5);
		
		String[] nomes = {	"7", "8", "9", "+", 
							"4", "5", "6", "-", 
							"1", "2", "3", "*", 
							",", "0", "=", "/" };
		
		for (int i = 0; i < 16; i++) { 
			int row = i / 4;
			int col = i % 4;
			Button btn = new Button(nomes[i]);
			btn.setPrefWidth(40);
			btn.setPrefHeight(40);	
			
			btn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					Button b = (Button)e.getTarget();
					if (Character.isDigit(b.getText().charAt(0))) { 
						txtDisplay.setText( txtDisplay.getText() + b.getText());
					}
				} 
				
			});
			
			painelBotoes.add(btn, col, row);
		}
		
		
		painelPrincipal.setTop(painelDisplay);
		painelPrincipal.setCenter(painelBotoes);
		
		Scene scn = new Scene(painelPrincipal);
		stage.setScene(scn);
		stage.show();
	}	
}
