package edu.javafx;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class TesteEventos extends Application {
	private Label lblOla;
	private Pane root;
	class Manipulador implements EventHandler<MouseEvent> {
		public void handle(MouseEvent e) {
			String nomeEvento = e.getEventType().getName();
			String botao = e.getButton().name();
			String texto = String.format("%s - (%f, %f) - %s", 
					nomeEvento, e.getX(), e.getY(), botao );
			lblOla.setText(texto);
			lblOla.relocate(e.getX(), e.getY());
			Rectangle r = new Rectangle(e.getX(), e.getY(), 5, 5);
			root.getChildren().add(r);
			
		} 
	}
	public void start(Stage stage) throws Exception {	
		Manipulador man = new Manipulador();
		root = new Pane();
		Scene scene = new Scene(root, 640, 480);
		lblOla = new Label("Ola mundo");
		lblOla.relocate(300, 220);
		stage.addEventFilter(MouseEvent.ANY, man);
		root.getChildren().add(lblOla);
		stage.setScene(scene);
		stage.setTitle("Teste de Eventos");
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
