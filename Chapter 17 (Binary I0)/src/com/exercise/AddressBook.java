package com.exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class AddressBook extends Application {

	private TextField name = new TextField();
	private TextField street = new TextField();
	private TextField city = new TextField();
	private TextField state = new TextField();
	private TextField zip = new TextField();

	private Button add = new Button("Add");
	private Button show = new Button("Show");
	private Button clear = new Button("Clear");

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane gridPane = new GridPane();
		gridPane.setHgap(1);
		gridPane.setVgap(1);

		gridPane.add(new Label("Name: "), 0, 0);
		gridPane.add(this.name, 1, 0);
		gridPane.add(new Label("Street"), 0, 1);
		gridPane.add(this.street, 1, 1);
		gridPane.add(new Label("City"), 0, 2);
		gridPane.add(this.city, 1, 2);
		gridPane.add(new Label("State"), 0, 3);
		gridPane.add(this.state, 1, 3);
		gridPane.add(new Label("Zip"), 0, 4);
		gridPane.add(this.zip, 1, 4);

		TilePane tileButtons = new TilePane(Orientation.HORIZONTAL);

		tileButtons.getChildren().addAll(add,show, clear);
		tileButtons.setPadding(new Insets(2, 1, 2, 0));
		tileButtons.setHgap(0.2);
		tileButtons.setVgap(0.5);
		tileButtons.setMaxWidth(gridPane.getMaxWidth());
		tileButtons.setAlignment(Pos.CENTER_LEFT);

		gridPane.add(tileButtons, 0, 5, 2, 1);
		;

		gridPane.setAlignment(Pos.CENTER);
		name.setAlignment(Pos.BOTTOM_RIGHT);
		street.setAlignment(Pos.BOTTOM_RIGHT);
		city.setAlignment(Pos.BOTTOM_RIGHT);
		state.setAlignment(Pos.BOTTOM_RIGHT);
		zip.setAlignment(Pos.BOTTOM_RIGHT);
		tileButtons.setAlignment(Pos.BASELINE_CENTER);
//		GridPane.setHalignment(tileButtons, Pos.BOTTOM_CENTER);

		Scene scene = new Scene(gridPane, 500, 500);
		primaryStage.setTitle("Address book");
		primaryStage.setScene(scene);
		primaryStage.show();

		add.setOnAction(e -> addAddress());
		show.setOnAction(e -> showAddress());
		clear.setOnAction(e -> clearField());

	}

	private void addAddress() {
		String name = this.name.getText() != "" ? this.name.getText() : null;
		String street =this.street.getText() != "" ?  this.street.getText() :null;
		String city = this.city.getText() != "" ? this.city.getText(): null ;
		String state = this.state.getText() != "" ? this.state.getText() : null ;
		String zip = this.zip.getText() != "" ? this.zip.getText() : null;
		
		Address address = new Address(name, street, city, state, zip);
		this.clearField();
		
		List<Address> newAddress = new ArrayList<Address>();
		newAddress.add(address);

		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("address.txt"))) {
			if(address != null) {
				stream.writeObject(newAddress);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void clearField() {
		this.name.setText("");
		this.street.setText("");
		this.city.setText("");
		this.state.setText("");
		this.zip.setText("");
	}

	private void showAddress() {
		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("address.txt"))) {
			@SuppressWarnings("unchecked")
			ArrayList<Address>addresses = (ArrayList<Address>)stream.readObject();
			for(Address address: addresses) {
				if (address != null) {
					this.name.setText(address.getName());
					this.street.setText(address.getStreet());
					this.city.setText(address.getCity());
					this.state.setText(address.getState());
					this.zip.setText(address.getZip());
				} else {
					System.out.println("No object found");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
