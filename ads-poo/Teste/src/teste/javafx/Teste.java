package teste.javafx;

import javax.xml.stream.EventFilter;
import javax.xml.stream.events.XMLEvent;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Teste extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();
		Button btn = new Button("Aperte-me");
		
		// EventFilter para o Pane
		EventHandler<Event> evtRoot = new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				System.out.println("Evento capturado na fase de Pane Processing: " + event.getEventType());
				System.out.println("Source: " + event.getSource());
			}		
		};
		root.addEventFilter(Event.ANY, evtRoot);
		
		// EventFilter para o Button
		EventHandler<ActionEvent> evt = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Evento capturado na fase de Button Processing");
				System.out.println("Source: " + event.getSource());
			}		
		};
		btn.addEventFilter(ActionEvent.ANY, evt);
		
		// EventHandler para o Botão
		EventHandler<ActionEvent> evtHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Evento capturado na fase de Button Bubbling");
				System.out.println("Source: " + event.getSource());
				// event.consume();
			} 
		};
		btn.addEventHandler(ActionEvent.ACTION, evtHandler);
		
		// EventHandler para o Botão
		EventHandler<ActionEvent> evtHandlerRoot = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Evento capturado na fase de Root Bubbling");
				System.out.println("Source: " + event.getSource());
			} 
		};
		root.addEventHandler(ActionEvent.ACTION, evtHandlerRoot);
		
		root.setCenter(btn);
		Scene scn = new Scene(root, 800, 600);
		
		stage.setScene(scn);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
