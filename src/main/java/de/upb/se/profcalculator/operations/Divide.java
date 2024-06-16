package de.upb.se.profcalculator.operations;

import de.upb.se.profcalculator.main.Value;
import de.upb.se.profcalculator.main.Expression;

public class Divide extends Expression {

    public Divide(Value leftOperand, Value rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int evaluate() {
        if (rightValue.getValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return leftValue.getValue() / rightValue.getValue();
    }

    @Override
    public String computeEquation() {
        try {
            return represent("/") + " = " + evaluate();
        } catch (ArithmeticException e) {
            return represent("/") + " = Error: " + e.getMessage();
        }
    }
}
