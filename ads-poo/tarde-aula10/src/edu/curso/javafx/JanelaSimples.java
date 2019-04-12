package edu.curso.javafx;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JanelaSimples extends Application {
	private Label lblOla;
	private Pane pane;
	
	class ManipuladorClick implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent e) {
			String name = e.getButton().name();
			String texto = String.format("%s - (%f, %f) - Button %s\n", 
					e.getEventType().getName(), e.getX(), e.getY(), name);
			lblOla.setText(texto);
			if (e.getButton() == MouseButton.PRIMARY) { 
				Rectangle r = new Rectangle(e.getX(), e.getY(), 5, 5);
				pane.getChildren().add(r);
				//Line
				//Ellipse
			}
		} 
	}
	@Override
	public void start(Stage stage) throws Exception {
			pane = new Pane();
			Scene scn = new Scene(pane, 200, 100);
			lblOla = new Label("Hello World");
			lblOla.relocate(10, 10);
			Button btnOk = new Button("Aperte-me");
			btnOk.relocate(40, 30);
			pane.getChildren().addAll(lblOla);
			EventHandler<MouseEvent> manipulador = new ManipuladorClick();
			scn.addEventFilter(MouseEvent.ANY, manipulador);
			stage.setScene(scn);
			stage.setTitle("Hello World");
			stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);	
	}
}
