package edu.curso;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Janela extends Application {

	@Override
	public void start(Stage janela) throws Exception {	
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 640, 480);
		
//		String fileNameHappy = "C:/Users/anton/git/arcarini/images/Characters/face_happy_small.png";
//		String fileNameFourious = "C:/Users/anton/git/arcarini/images/Characters/face_furious_small.png";
//		InputStream isHappy = new FileInputStream(fileNameHappy);
//		InputStream isFourious = new FileInputStream(fileNameFourious);
		
		InputStream isHappy = getClass().getResourceAsStream("/images/face_happy_small.png");
		InputStream isFourious = getClass().getResourceAsStream("/images/face_furious_small.png");
		ImageView imgHappy = new ImageView(new Image(isHappy));
		ImageView imgFourious = new ImageView(new Image(isFourious));
		Label hello = new Label("Happy Face");
		Button btn = new Button("Ok");
		btn.relocate(100,  50);
		btn.setGraphic(imgHappy);
		btn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	btn.setGraphic(imgFourious);
		    	hello.setText("Fourious Face");
		    	hello.setStyle("-fx-background-color:red");
		    }
		});
		hello.setStyle("-fx-background-color:yellow");
		painel.getChildren().addAll(hello, btn);
		
		janela.setScene(scn);
		janela.setTitle("Teste de Janela");
		janela.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
