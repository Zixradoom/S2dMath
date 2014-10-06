package com.s2d.math.calculator;

public class CalculatorException extends RuntimeException
{
	private static final long serialVersionUID = 4188905573596062280L;
	
	public CalculatorException ()
	{
		super ();
	}
	
	public CalculatorException ( String message )
	{
		super ( message );
	}
	
	public CalculatorException ( Throwable throwable )
	{
		super ( throwable );
	}
	
	public CalculatorException ( String message, Throwable throwable )
	{
		super ( message, throwable );
	}
}
