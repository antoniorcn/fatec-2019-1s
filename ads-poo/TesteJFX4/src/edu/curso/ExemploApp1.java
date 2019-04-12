package edu.curso;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class ExemploApp1 extends Application {
	class ManipuladorMouse implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			System.out.println("Action : " + e.getEventType());
			System.out.println("Source : " + e.getSource().getClass().getName());
			System.out.println("Target : " + e.getTarget().getClass().getName());
			e.consume();
		} 	
	}
	@Override
	public void start(Stage stage) throws Exception {
		Pane panel = new Pane();
		Button btn = new Button("Ok");
		EventHandler<ActionEvent> manipulador = new ManipuladorMouse();
		stage.addEventFilter(ActionEvent.ACTION, manipulador);
		panel.getChildren().add(btn);
		Scene scn = new Scene(panel);
		stage.setScene(scn);
		stage.setTitle("Teste de Eventos");
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
