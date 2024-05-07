package de.upb.se.profcalculator;

public class Value {

	Integer value;

	public Value(int value)
	{
this.value = value;
}

	public String toString()
{
		return value.toString();
	}

public int getValue() { return value.intValue(); }}
