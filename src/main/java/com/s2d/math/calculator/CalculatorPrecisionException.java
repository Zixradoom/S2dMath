package com.s2d.math.calculator;

import java.math.BigDecimal;

public class CalculatorPrecisionException extends CalculatorException
{
	private static final long serialVersionUID = -8906478269490859906L;

	public CalculatorPrecisionException ( String operation, int operand, BigDecimal value,
			ArithmeticException e )
	{
		super ( String.format ( "Invalid value %s, Operation %s, Operand %d, requires and integral argument",
				value, operation, Integer.valueOf ( operand ) ), e );
	}
}
