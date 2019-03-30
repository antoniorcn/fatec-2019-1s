package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class JFXJanela extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		Pane painel = new Pane();
		// painel.setStyle("-fx-background-color:rgba(255, 255, 0, 0.5);");
		painel.setStyle("-fx-background-image:url('/image/face_furious.png');");
		Scene scn = new Scene(painel, 400, 200);
		Label hello = new Label("Hello World");
		Button btn = new Button("Ok");
		btn.relocate(100, 40);
		painel.getChildren().add(hello);
		painel.getChildren().add(btn);
		stage.setScene(scn);
		stage.setTitle("Teste de JavaFX");
		stage.show();
	}
}
