package com.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StoreNumbers extends Application {

	private TextField textBox = new TextField();
	
	private List<Integer> numbers = new LinkedList<Integer>();

	private TextField showTextBox = new TextField();

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		pane.setHgap(1);
		pane.setVgap(1);
		this.textBox.setPromptText("Enter a list of numbers.");
		pane.add(new Label("Enter a Number"), 0, 0);
		pane.add(this.textBox, 1, 0);
		pane.add(this.showTextBox, 1, 1);

		Button addButton = new Button("Add");
		Button sortButton = new Button("Sort");
		Button shuffleButton = new Button("Shuffle");
		Button reverseButton = new Button("Reverse");
		
		addButton.setOnAction(e -> add());
		sortButton.setOnAction(e -> sort());
		shuffleButton.setOnAction(e -> shuffle());
		reverseButton.setOnAction(e -> reverse());
		
		
		

		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(addButton,sortButton, shuffleButton, reverseButton);
		hBox.setAlignment(Pos.CENTER);

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(pane);
		borderPane.setCenter(this.showTextBox);
		borderPane.setBottom(hBox);		
		
		
		Scene scene = new Scene(borderPane, 250, 200);
		primaryStage.setTitle("Add Numbers using LinkedList");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
	}
	public void add() {
		String text = this.textBox.getText().replace(" ", "");
		text.trim();
		System.out.println(text);
		List<String> splitStrings = Arrays.asList(text);
		System.out.println(splitStrings.size());
		System.out.println(splitStrings.get(0));
		for(int i = 0, length = splitStrings.size(); i < length; i++) {
			System.out.println(splitStrings.get(i));
			this.numbers.add(Integer.parseInt(splitStrings.get(i)));
		}

		this.showTextBox.setText(String.valueOf(this.numbers.toString()));
		this.textBox.setText("");
	}
	
	public void sort() {
		Collections.sort(this.numbers);
		System.out.println(this.numbers);
		this.showTextBox.setText(String.valueOf(this.numbers.toString()));
	}
	
	public void shuffle() {
		Collections.shuffle(this.numbers);
		System.out.println(this.numbers);
		this.showTextBox.setText(String.valueOf(this.numbers.toString()));
		
	}
	
	public void reverse() {
		Collections.reverse(this.numbers);
		this.showTextBox.setText(String.valueOf(this.numbers.toString()));
	}

	public static void main(String[] args) {
		Application.launch(args);
		
	}

}
