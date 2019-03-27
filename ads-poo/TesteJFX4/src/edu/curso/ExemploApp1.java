package edu.curso;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class ExemploApp1 extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Pane panel = new Pane();
		Button btn = new Button("Teste de Botão");
		Group g = new Group();
		panel.getChildren().add(btn);
		panel.getChildren().add(new Rectangle(10, 10, 50, 50));
		Scene scn = new Scene(panel);
		stage.setScene(scn);
		stage.setTitle("Titulo da Janela");
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
