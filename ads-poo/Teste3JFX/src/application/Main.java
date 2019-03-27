package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Button btn = new Button("Hello World");
			btn.setStyle("-fx-margin: 40px");
			Pane root = new Pane();
			root.setStyle("-fx-background-color:black; -fx-padding: 40");
			Scene scn = new Scene(root, 640, 480);
			root.getChildren().add(btn);
			primaryStage.setScene(scn);
			primaryStage.show();
			
			primaryStage.setScene(scn);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
