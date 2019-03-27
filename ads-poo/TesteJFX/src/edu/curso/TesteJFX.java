package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TesteJFX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btn = new Button("Hello World");
		Pane root = new Pane();
		Scene scn = new Scene(root, 640, 480);
		root.getChildren().add(btn);
		primaryStage.setScene(scn);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		System.out.println("Teste");
		launch(args);
	}
}
