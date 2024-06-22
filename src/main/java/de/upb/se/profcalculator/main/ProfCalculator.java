package de.upb.se.profcalculator.main;

import de.upb.se.profcalculator.interfaces.Expression;
import de.upb.se.profcalculator.operations.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ProfCalculator extends Application {

    private Expression currentValue;
    private StringBuilder currentEquation = new StringBuilder();
    private List<Value> resultMemory = new ArrayList<>();
    private Label errorLabel = new Label("");
    private Label memoryLabel = new Label("");
    private TextField inputField = new TextField("");
    private Label resultLabel = new Label("0");
    private TextArea previousCalculationsArea = new TextArea();
    private Set<String> uniqueCalculations = new LinkedHashSet<>();
    private boolean isCalculationsVisible = false;

    private void resetCalculator() {
        currentValue = new Value();  // Use the default constructor to initialize with 0
        currentEquation.setLength(0);
        resultMemory.clear();  // Clear the result memory
        resultLabel.setText("0");
        inputField.setText("");
        errorLabel.setText("");
        memoryLabel.setText("");
        previousCalculationsArea.clear();
        uniqueCalculations.clear();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Professional Calculator");
        errorLabel.setTextFill(Color.web("#AA0000"));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(errorLabel, inputField,
                createButton("+", "add"),
                createButton("-", "subtract"),
                createButton("*", "multiply"),
                createButton("/", "divide"),
                resultLabel, memoryLabel,
                createButton("Reset", "reset"),
                createButton("Print", "print"),
                previousCalculationsArea);
        layout.setPadding(new Insets(20, 80, 20, 80));
        Scene scene = new Scene(layout);

        previousCalculationsArea.setVisible(isCalculationsVisible);  // Initially hidden

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
        } else if ("print".equals(operation)) {
            toggleCalculationsVisibility();
            return;
        }

        try {
            Expression newValue = Value.parseValue(inputField.getText());
            if (currentValue == null || currentEquation.length() == 0) {  
                currentValue = newValue;
                currentEquation.append(newValue.computeEquation());
            } else {
                Expression expression = null;
                switch (operation) {
                    case "add":
                        expression = new Add(currentValue, newValue);
                        break;
                    case "subtract":
                        expression = new Subtract(currentValue, newValue);
                        break;
                    case "multiply":
                        expression = new Multiply(currentValue, newValue);
                        break;
                    case "divide":
                        expression = new Divide(currentValue, newValue);
                        break;
                }

                if (expression != null) {
                    String equation = expression.computeEquation();
                    currentValue = expression.evaluate();
                    Value resultValue = (Value) currentValue;
                    currentEquation.append(" = ").append(resultValue.getValue());
                    resultLabel.setText(currentEquation.toString());
                    uniqueCalculations.add(equation);  // Add unique calculation
                    updatePreviousCalculationsArea();  // Update the text area
                    currentEquation.setLength(0);  // Clear current equation
                    currentEquation.append(resultValue.getValue());
                }
            }
            inputField.setText("");
            errorLabel.setText("");
        } catch (NumberFormatException e) {
            errorLabel.setText("\"" + inputField.getText() + "\" is not a valid integer");
        } catch (ArithmeticException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    private void toggleCalculationsVisibility() {
        isCalculationsVisible = !isCalculationsVisible;
        previousCalculationsArea.setVisible(isCalculationsVisible);
        if (isCalculationsVisible) {
            updatePreviousCalculationsArea();
        }
    }

    private void updatePreviousCalculationsArea() {
        StringBuilder calculationsText = new StringBuilder();
        for (String calculation : uniqueCalculations) {
            calculationsText.append(calculation).append("\n");
        }
        previousCalculationsArea.setText(calculationsText.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
