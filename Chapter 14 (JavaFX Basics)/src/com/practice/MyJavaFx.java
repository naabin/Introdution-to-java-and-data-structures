package com.practice;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyJavaFx extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button btOk = new Button("OK");
		Scene scene = new Scene(btOk, 200, 250);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
