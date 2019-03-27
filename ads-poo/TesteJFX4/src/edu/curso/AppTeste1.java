package edu.curso;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppTeste1 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Janela JavaFX");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		FlowPane pane = new FlowPane();

		//grid.setStyle("-fx-background-color:#62A39F;");
		grid.setStyle("-fx-background-color:#2CBE93;");
	
		Text txt = new Text("Elemento Gráfico");
		txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		//grid.add(txt, 0, 0, 2, 1);
		pane.getChildren().add(txt);

		Label userName = new Label("Elemento Gráfico:");
		//grid.add(userName, 0, 1);
		pane.getChildren().add(userName);

		TextField userTextField = new TextField();
		userTextField.setText("Elemento Gráfico");
		//grid.add(userTextField, 1, 1);
		pane.getChildren().add(userTextField);
			
		Button btn = new Button();
		btn.setText("Elemento gráfico");
		//grid.add(btn, 0, 2);
		pane.getChildren().add(btn);
			
		Scene scn = new Scene(pane, 600, 400);	
		stage.setScene(scn);
		stage.show();
	}
}
