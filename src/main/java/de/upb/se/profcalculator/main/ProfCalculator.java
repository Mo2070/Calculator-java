package de.upb.se.profcalculator.main;

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
import de.upb.se.profcalculator.operations.Add;
import de.upb.se.profcalculator.operations.Subtract;
import de.upb.se.profcalculator.operations.Multiply;
import de.upb.se.profcalculator.operations.Divide;

import java.util.ArrayList;
import java.util.List;

public class ProfCalculator extends Application implements EventHandler<ActionEvent> {

    private Value currentValue;
    private StringBuilder currentEquation = new StringBuilder();
    private List<Value> resultMemory = new ArrayList<>();
    private Label errorLabel = new Label("");
    private Label memoryLabel = new Label("");
    private TextField inputField = new TextField("");
    private Label resultLabel = new Label("0");

    private void resetCalculator() {
        currentValue = new Value();  // Use the default constructor to initialize with 0
        currentEquation.setLength(0);
        resultMemory.clear();  // Clear the result memory
        resultLabel.setText("0");
        inputField.setText("");
        errorLabel.setText("");
        memoryLabel.setText("");
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Professional Calculator");
        errorLabel.setTextFill(Color.web("#AA0000"));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(errorLabel, inputField,
                createButton("+", "add"),
                createButton("-", "subtract"),
                createButton("*", "multiply"),
                createButton("/", "divide"),
                resultLabel, memoryLabel,
                createButton("Reset", "reset"));
        layout.setPadding(new Insets(20, 80, 20, 80));
        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.show();
    }

    private Button createButton(String text, String operation) {
        Button button = new Button(text);
        button.setOnAction(event -> handleOperation(operation));
        return button;
    }

    private void handleOperation(String operation) {
        if ("reset".equals(operation)) {
            resetCalculator();
            return;
        }

        try {
            Value newValue = Value.parseValue(inputField.getText());
            if (currentValue == null || currentEquation.length() == 0) {  // If it's the first input
                currentValue = newValue;
                currentEquation.append(newValue.getValue());
            } else {
                Expression expr = null;
                switch (operation) {
                    case "add":
                        expr = new Add(currentValue, newValue);
                        break;
                    case "subtract":
                        expr = new Subtract(currentValue, newValue);
                        break;
                    case "multiply":
                        expr = new Multiply(currentValue, newValue);
                        break;
                    case "divide":
                        expr = new Divide(currentValue, newValue);
                        break;
                }
                if (expr != null) {
                    updateEquationAndValue(expr);
                }
            }
            inputField.setText("");
            errorLabel.setText("");
            inputField.requestFocus();
        } catch (NumberFormatException e) {
            errorLabel.setText("\"" + inputField.getText() + "\" is not a valid integer");
        } catch (ArithmeticException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    private void updateEquationAndValue(Expression expr) {
        currentEquation.append(" = ").append(expr.evaluate());
        currentValue = new Value(expr.evaluate());
        resultLabel.setText(expr.computeEquation());
        currentEquation = new StringBuilder().append(currentValue.getValue());
        updateResultMemory(currentValue);  // Update the result memory
    }

    private void updateResultMemory(Value result) {
        int lastIndex = resultMemory.lastIndexOf(result);
        if (lastIndex == -1) {
            memoryLabel.setText("New result");
        } else {
            memoryLabel.setText("Result occurred " + (resultMemory.size() - lastIndex) + " steps ago");
        }
        resultMemory.add(result);  // Add the new result to the memory
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
    }
}
