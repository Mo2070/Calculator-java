package de.upb.se.profcalculator;

public class OperationFactory {
    public static Operation createOperation(String operation, Value leftValue, Value rightValue) {
        switch (operation) {
            case "add":
                return new Add(leftValue, rightValue);
            case "subtract":
                return new Subtract(leftValue, rightValue);
            case "multiply":
                return new Multiply(leftValue, rightValue);
            case "divide":
                return new Divide(leftValue, rightValue);
            default:
                return null;
        }
    }
}
