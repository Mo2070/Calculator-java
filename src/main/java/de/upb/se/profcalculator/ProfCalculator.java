package de.upb.se.profcalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProfCalculator

extends Application

implements EventHandler<ActionEvent>

	{

	private final static Value Defaultvalue = new Value(0);
	
	private Add Addition = new Add(Defaultvalue, Defaultvalue);

	private Label Error = new Label("");
	
	private TextField Input = new TextField("");
	
	private Button addButton = new Button("+");
	
	private Button resetButton = new Button("Reset");
	
	private Label Result = new Label(Addition.computeEquation());
	
	private void resetCalculator() {
		Addition = new Add(Defaultvalue, Defaultvalue);
		Result.setText(Addition.computeEquation());
		Input.setText("");
		Error.setText("");
				
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Professioral Calculator");
		Error.setTextFill(Color.web("#AA0000"));

//		Tried a different layout first, but this looked ugly.
//		BorderPane borderPane = new BorderPane();
//		borderPane.setTop(inputField);
//		borderPane.setCenter(addButton);
//		borderPane.setBottom(resultLabel);
//		Scene scene = new Scene(borderPane);
		
		VBox layout = new VBox(10);

		layout.getChildren().addAll(Error, Input, addButton, Result, resetButton);
		
		layout.setPadding(new Insets(20, 80, 20, 80));
		Scene scene = new Scene(layout);
		
		stage.setScene(scene);
		stage.show();
		addButton.setOnAction(this);
		resetButton.setOnAction(e -> resetCalculator());
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			int newValue = Integer.parseInt(Input.getText()); int oldResult = Addition.evaluate();
			Addition = new Add(new Value(oldResult), new Value(newValue)); Result.setText(Addition.computeEquation());
			Input.setText(""); Error.setText(""); Input.requestFocus();
		}                    catch (NumberFormatException e) { Error.setText("\"" + Input.getText() + "\" is not a valid integer"); }
	}
	
	public static void main(String[] args) { launch(args); }

}
