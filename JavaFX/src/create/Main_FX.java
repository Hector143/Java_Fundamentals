package create;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main_FX extends Application {

	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage stage) {
		Button btn = new Button("Hello JavaFX");

		Scene scene = new Scene(btn, 300, 200);
		stage.setTitle("JavaFX Test");
		stage.setScene(scene);
		stage.show();
	}



}
