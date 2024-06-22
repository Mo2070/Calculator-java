package de.upb.se.profcalculator.operations;

import de.upb.se.profcalculator.interfaces.BinaryExpression;
import de.upb.se.profcalculator.interfaces.Expression;

public class Add extends BinaryExpression {

    public Add(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int evaluate() {
        return leftOperand.evaluate() + rightOperand.evaluate();
    }

    @Override
    protected String getOperator() {
        return "+";
    }
}
