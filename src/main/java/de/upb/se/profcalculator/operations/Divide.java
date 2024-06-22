package de.upb.se.profcalculator.operations;

import de.upb.se.profcalculator.interfaces.BinaryExpression;
import de.upb.se.profcalculator.interfaces.Expression;

public class Divide extends BinaryExpression {

    public Divide(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int evaluate() {
        if (rightOperand.evaluate() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return leftOperand.evaluate() / rightOperand.evaluate();
    }

    @Override
    protected String getOperator() {
        return "/";
    }
}
