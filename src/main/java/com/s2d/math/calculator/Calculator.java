package com.s2d.math.calculator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Collection;

import com.s2d.math.util.Random;

public interface Calculator
{
	public Calculator duplicate ();
	public Calculator abs ();
	public Calculator negate ();
	public Calculator add ();
	public Calculator subtract ();
	public Calculator multiply ();
	public Calculator divide ();
	public Calculator scale ();
	public Calculator clamp ();
	public Calculator store ();
	public Calculator load ();
	public Calculator pushRandom ();
	public Calculator push ( int value );
	public Calculator push ( long value );
	public Calculator push ( float value );
	public Calculator push ( double value );
	public Calculator push ( String value );
	public Calculator push ( BigInteger value );
	public Calculator push ( BigDecimal value );
	public BigDecimal peek ();
	public BigDecimal pop ();
	public Calculator clear ();
	public MathContext getMathContext ();
	public Calculator setContext ( MathContext context );
	public Random getRandom ();
	public Calculator setRandom ( Random random );
	public Collection < BigDecimal > getStack ();
	public BigDecimal[] getMemory ();
	public String stackToString ();
	public String memoryToString ();
}
