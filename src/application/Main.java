package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	
	private PastisController ctrl;
	private PastisModel model;
	
	@Override
	public void start(Stage primaryStage) {
		model = new PastisModel();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewPastis.fxml"));
			AnchorPane root = loader.load();
			ctrl = loader.getController();
			model = new PastisModel();
			ctrl.setModel(model);
			ctrl.initializer();
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
