package com.s2d.math.calculator;

public class CalculatorMemorySegmentationException extends CalculatorException
{
	private static final long serialVersionUID = -5106668924370426706L;

	public CalculatorMemorySegmentationException ( int address, int memeryMaxAddress )
	{
		super ( String.format ( "Invalid Address %d, Memory Max Address %d", Integer.valueOf ( address ), Integer.valueOf ( memeryMaxAddress ) ) );
	}
}
