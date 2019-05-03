package edu.curso;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TesteEvento extends Application {
	
	class Manipulador implements EventHandler<KeyEvent> {
		@Override
		public void handle(KeyEvent e) {
			System.out.println(
					String.format("Tipo %s   Source: %s    Target: %s",
							e.getEventType(), e.getSource(), e.getTarget()));
			if (e.getCode() == KeyCode.B) { 
				System.out.println("Letra B pressionado");
				e.consume();
			}
		} 
	}

	@Override
	public void start(Stage stg) throws Exception {
		VBox p = new VBox();
		Scene scene = new Scene(p, 300, 300);
		Manipulador man = new Manipulador();
		TextField txt = new TextField();
		stg.addEventFilter(KeyEvent.ANY, man);
		txt.addEventFilter(KeyEvent.ANY, man);		
		p.getChildren().addAll(new Label("Digite Algo"), txt);
		stg.setTitle("Teste de Propagação");
		stg.setScene(scene);
		stg.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
