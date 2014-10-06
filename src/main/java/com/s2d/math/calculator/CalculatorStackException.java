package com.s2d.math.calculator;

public class CalculatorStackException extends CalculatorException
{
	private static final long serialVersionUID = -53863986940215453L;

	public CalculatorStackException ()
	{
		super ();
	}
	
	public CalculatorStackException ( String message )
	{
		super ( message );
	}
	
	public CalculatorStackException ( Throwable throwable )
	{
		super ( throwable );
	}
	
	public CalculatorStackException ( String message, Throwable throwable )
	{
		super ( message, throwable );
	}
}
