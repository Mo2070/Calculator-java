package de.upb.se.profcalculator;

public class Add {
	public Value leftvalue, rightValue;
	public Add(Value leftOperand, Value rightOperand) {
		this.leftvalue = leftOperand;
		this.rightValue = rightOperand;
	}
	// return a String Represention Of The Expression
	public String represent() {
		return leftvalue.toString() + " + " + rightValue.toString();
	}
	// evaluate the expression to an integer value
	public int evaluate() {
		return leftvalue.getValue() + rightValue.getValue();
	}
	// compute an Equation Representing The Expression And Its Value
	public String computeEquation() {
		return represent() + " = " + evaluate();
	}
}
