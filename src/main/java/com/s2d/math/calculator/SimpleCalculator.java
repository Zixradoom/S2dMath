package com.s2d.math.calculator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import com.s2d.math.util.MathUtil;
import com.s2d.math.util.Random;
import com.s2d.math.util.RandomWrapper;

public final class SimpleCalculator implements Calculator
{
	private static final int DEFAULT_MEMORY_SIZE = 16;
	private static final MathContext DEFALUT_MATH_CONTEXT = MathContext.DECIMAL128;
	private static final Random DEFAULT_RANDOM = new RandomWrapper ( new java.util.Random () );

	private MathContext mathContext = DEFALUT_MATH_CONTEXT;
	private Random random = null;

	private final Deque < BigDecimal > stack = new LinkedList < BigDecimal > ();
	private final BigDecimal[] memory;

	public SimpleCalculator ()
	{
		this ( null );
	}
	
	public SimpleCalculator ( Random random )
	{
		if ( random == null )
			random = DEFAULT_RANDOM;

		this.random = random;
		this.memory = new BigDecimal[ DEFAULT_MEMORY_SIZE ];
		Arrays.fill ( memory, BigDecimal.ZERO );
	}

	@Override
	public Calculator duplicate ()
	{
		BigDecimal a = checkedPop ();
		stack.push ( a );
		stack.push ( a );
		return this;
	}

	@Override
	public Calculator abs ()
	{
		BigDecimal a = checkedPop ();
		stack.push ( a.abs ( mathContext ) );
		return this;
	}

	@Override
	public Calculator negate ()
	{
		BigDecimal a = checkedPop ();
		stack.push ( a.negate ( mathContext ) );
		return this;
	}

	@Override
	public Calculator add ()
	{
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		stack.push ( a.add ( b, mathContext ) );
		return this;
	}

	@Override
	public Calculator subtract ()
	{
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		stack.push ( a.subtract ( b, mathContext ) );
		return this;
	}

	@Override
	public Calculator multiply ()
	{
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		stack.push ( a.multiply ( b, mathContext ) );
		return this;
	}

	@Override
	public Calculator divide ()
	{
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		stack.push ( a.divide ( b, mathContext ) );
		return this;
	}

	@Override
	public Calculator scale ()
	{
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		try
		{
			stack.push ( a.setScale ( b.intValueExact (), mathContext.getRoundingMode () ) );
		}
		catch ( ArithmeticException e )
		{
			throw new CalculatorPrecisionException ( "scale", 2, b, e );
		}
		return this;
	}

	@Override
	public Calculator clamp ()
	{
		BigDecimal c = checkedPop ();
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		stack.push ( MathUtil.clamp ( a, b, c ) );
		return this;
	}

	@Override
	public Calculator store ()
	{
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		try
		{
			store ( a, b.intValueExact () );
		}
		catch ( ArithmeticException e )
		{
			throw new CalculatorPrecisionException ( "store", 2, b, e );
		}
		return this;
	}

	@Override
	public Calculator load ()
	{
		BigDecimal a = checkedPop ();
		try
		{
			stack.push ( load ( a.intValueExact () ) );
		}
		catch ( ArithmeticException e )
		{
			throw new CalculatorPrecisionException ( "load", 1, a, e );
		}
		return this;
	}

	@Override
	public Calculator pushRandom ()
	{
		return push ( random.nextBigDecimal () );
	}

	@Override
	public Calculator push ( int value )
	{
		return push ( new BigDecimal ( value, mathContext ) );
	}

	@Override
	public Calculator push ( long value )
	{
		return push ( new BigDecimal ( value, mathContext ) );
	}

	@Override
	public Calculator push ( float value )
	{
		return push ( new BigDecimal ( value, mathContext ) );
	}

	@Override
	public Calculator push ( double value )
	{
		return push ( new BigDecimal ( value, mathContext ) );
	}

	@Override
	public Calculator push ( String value )
	{
		return push ( new BigDecimal ( value, mathContext ) );
	}

	@Override
	public Calculator push ( BigInteger value )
	{
		return push ( new BigDecimal ( value, mathContext ) );
	}

	@Override
	public Calculator push ( BigDecimal value )
	{
		if ( value == null )
			throw new NullPointerException ( "Value is null!!" );
		stack.push ( value );
		return this;
	}

	@Override
	public BigDecimal peek ()
	{
		return stack.peek ();
	}

	@Override
	public BigDecimal pop ()
	{
		return checkedPop ();
	}
	
	@Override
	public Calculator clear ()
	{
		stack.clear ();
		Arrays.fill ( memory, BigDecimal.ZERO );
		return this;
	}

	@Override
	public MathContext getMathContext ()
	{
		return mathContext;
	}

	@Override
	public Calculator setContext ( MathContext context )
	{
		if ( context == null )
			this.mathContext = DEFALUT_MATH_CONTEXT;
		return this;
	}

	@Override
	public Random getRandom ()
	{
		return random;
	}
	
	@Override
	public Calculator setRandom ( Random random )
	{
		if ( random == null )
			random = DEFAULT_RANDOM;
		
		this.random = random;
		return this;
	}
	
	@Override
	public Collection < BigDecimal > getStack ()
	{
		return Collections.unmodifiableCollection ( stack );
	}

	@Override
	public BigDecimal[] getMemory ()
	{
		return Arrays.copyOf ( memory, memory.length );
	}

	@Override
	public String stackToString ()
	{
		StringBuilder stringBuilder = new StringBuilder ();
		stringBuilder.append ( '[' );
		for ( Iterator < BigDecimal > itr = stack.descendingIterator (); itr.hasNext (); )
			stringBuilder.append ( itr.next () ).append ( ',' );
		stringBuilder.append ( ']' );
		return stringBuilder.toString ();
	}

	@Override
	public String memoryToString ()
	{
		StringBuilder stringBuilder = new StringBuilder ();
		stringBuilder.append ( '[' );
		for ( int index = 0; index < memory.length; index++ )
			stringBuilder.append ( '{' ).append ( index ).append ( '=' ).append ( memory[ index ] ).append ( '}' ).append ( ',' );
		stringBuilder.append ( ']' );
		return stringBuilder.toString ();
	}

	private BigDecimal checkedPop ()
	{
		try
		{
			return stack.pop ();
		}
		catch ( NoSuchElementException e )
		{
			throw new CalculatorStackException ( "The Stack is Empty" );
		}
	}

	private void store ( BigDecimal value, int address )
	{
		if ( address < 0 || address >= memory.length )
			throw new CalculatorMemorySegmentationException ( address, memory.length - 1 );
		memory[ address ] = value;
	}

	private BigDecimal load ( int address )
	{
		if ( address < 0 || address >= memory.length )
			throw new CalculatorMemorySegmentationException ( address, memory.length - 1 );
		return memory[ address ];
	}
}
