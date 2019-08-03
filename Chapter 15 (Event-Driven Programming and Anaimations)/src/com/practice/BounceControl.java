package com.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class BounceControl extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BallPane ballPane = new BallPane();
		
		//pause and resume animation
		ballPane.setOnMousePressed(e -> ballPane.pause());
		ballPane.setOnMouseReleased(e -> ballPane.play());
		
		//Increase and decrease animation
		ballPane.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.UP) {
				ballPane.increaseSpeed();
			}
			else if(e.getCode() == KeyCode.DOWN) {
				ballPane.decreaseSpeed();
			}
		});
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(ballPane, 250, 150);
		primaryStage.setTitle("BouncingBallControl");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		ballPane.requestFocus();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}

}
