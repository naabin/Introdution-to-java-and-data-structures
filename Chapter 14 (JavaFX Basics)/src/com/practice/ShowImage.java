package com.practice;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShowImage extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane pane = new HBox(20);
		pane.setPadding(new Insets(5, 5, 5, 5));
		Image image = new Image("https://avatars0.githubusercontent.com/u/26199402?s=400&v=4");
		
		pane.getChildren().add(new ImageView(image));
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowImage");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
