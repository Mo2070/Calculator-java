package de.upb.se.profcalculator.operations;

import de.upb.se.profcalculator.interfaces.BinaryExpression;
import de.upb.se.profcalculator.interfaces.Expression;

public class Multiply extends BinaryExpression {

    public Multiply(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int evaluate() {
        return leftOperand.evaluate() * rightOperand.evaluate();
    }

    @Override
    protected String getOperator() {
        return "*";
    }
}
