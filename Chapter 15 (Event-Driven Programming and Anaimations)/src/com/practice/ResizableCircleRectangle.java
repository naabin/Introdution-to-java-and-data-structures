package com.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ResizableCircleRectangle extends Application {
	
	private Circle circle = new Circle(60);
	private Rectangle rectangle = new Rectangle(120, 120);
	
	private StackPane pane = new StackPane();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.circle.setFill(Color.GRAY);
		this.rectangle.setFill(Color.WHITE);
		this.rectangle.setStroke(Color.BLACK);
		this.pane.getChildren().addAll(rectangle, circle);
		
		//Create a scene and place the pane in the stage
		Scene scene = new Scene(pane, 140, 140);
		primaryStage.setTitle("ResizableCirlceRectangle");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		pane.widthProperty().addListener(ov -> resize());
		pane.heightProperty().addListener(ov -> resize());
		
	}
	
	private void resize() {
		double length = Math.min(pane.getWidth(), pane.getHeight());
		circle.setRadius(length / 2 - 15);
		rectangle.setWidth(length - 30);
		rectangle.setHeight(length - 30);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
