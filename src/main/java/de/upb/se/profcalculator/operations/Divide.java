package de.upb.se.profcalculator.operations;

import de.upb.se.profcalculator.interfaces.Expression;
import de.upb.se.profcalculator.main.Value;

public class Divide extends Expression {
    private final Value leftValue;
    private final Value rightValue;

    public Divide(Value leftOperand, Value rightOperand) {
        this.leftValue = leftOperand;
        this.rightValue = rightOperand;
    }

    @Override
    public String computeEquation() {
        try {
            return represent() + " = " + evaluate();
        } catch (ArithmeticException e) {
            return represent() + " = Error: " + e.getMessage();
        }
    }

    @Override
    public int evaluate() {
        if (rightValue.getValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return leftValue.getValue() / rightValue.getValue();
    }

    public String represent() {
        return leftValue.toString() + " / " + rightValue.toString();
    }
}
