package de.upb.se.profcalculator.operations;

import de.upb.se.profcalculator.interfaces.Expression;
import de.upb.se.profcalculator.main.Value;

public class Multiply extends Expression {
    private final Value leftValue;
    private final Value rightValue;

    public Multiply(Value leftOperand, Value rightOperand) {
        this.leftValue = leftOperand;
        this.rightValue = rightOperand;
    }

    @Override
    public String computeEquation() {
        return represent() + " = " + evaluate();
    }

    @Override
    public int evaluate() {
        return leftValue.getValue() * rightValue.getValue();
    }

    public String represent() {
        return leftValue.toString() + " * " + rightValue.toString();
    }
}
