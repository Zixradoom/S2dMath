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

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

import com.s2d.math.util.MathUtil;
import com.s2d.math.util.Random;
import com.s2d.math.util.RandomWrapper;

public final class SimpleCalculator implements Calculator
{
  private static final XLogger LOGGER = XLoggerFactory.getXLogger ( SimpleCalculator.class );
  
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
	  LOGGER.entry ();
		BigDecimal a = checkedPop ();
		stack.push ( a );
		stack.push ( a );
		return LOGGER.exit ( this );
	}

	@Override
	public Calculator abs ()
	{
	  LOGGER.entry ();
		BigDecimal a = checkedPop ();
		stack.push ( a.abs ( mathContext ) );
		return LOGGER.exit ( this );
	}

	@Override
	public Calculator negate ()
	{
	  LOGGER.entry ();
		BigDecimal a = checkedPop ();
		stack.push ( a.negate ( mathContext ) );
		return LOGGER.exit ( this );
	}

	@Override
	public Calculator add ()
	{
	  LOGGER.entry ();
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		stack.push ( a.add ( b, mathContext ) );
		return LOGGER.exit ( this );
	}

	@Override
	public Calculator subtract ()
	{
	  LOGGER.entry ();
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		stack.push ( a.subtract ( b, mathContext ) );
		return LOGGER.exit ( this );
	}

	@Override
	public Calculator multiply ()
	{
	  LOGGER.entry ();
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		stack.push ( a.multiply ( b, mathContext ) );
		return LOGGER.exit ( this );
	}

	@Override
	public Calculator divide ()
	{
	  LOGGER.entry ();
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		stack.push ( a.divide ( b, mathContext ) );
		return LOGGER.exit ( this );
	}

	@Override
	public Calculator scale ()
	{
	  LOGGER.entry ();
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		try
		{
			stack.push ( a.setScale ( b.intValueExact (), mathContext.getRoundingMode () ) );
		}
		catch ( ArithmeticException e )
		{
			throw LOGGER.throwing ( new CalculatorPrecisionException ( "scale", 2, b, e ) );
		}
		return LOGGER.exit ( this );
	}

	@Override
	public Calculator clamp ()
	{
	  LOGGER.entry ();
		BigDecimal c = checkedPop ();
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		stack.push ( MathUtil.clamp ( a, b, c ) );
		return LOGGER.exit ( this );
	}

	@Override
	public Calculator store ()
	{
	  LOGGER.entry ();
		BigDecimal b = checkedPop ();
		BigDecimal a = checkedPop ();
		try
		{
			store ( a, b.intValueExact () );
		}
		catch ( ArithmeticException e )
		{
			throw LOGGER.throwing ( new CalculatorPrecisionException ( "store", 2, b, e ) );
		}
		return LOGGER.exit ( this );
	}

	@Override
	public Calculator load ()
	{
	  LOGGER.entry ();
		BigDecimal a = checkedPop ();
		try
		{
			stack.push ( load ( a.intValueExact () ) );
		}
		catch ( ArithmeticException e )
		{
			throw LOGGER.throwing ( new CalculatorPrecisionException ( "load", 1, a, e ) );
		}
		return LOGGER.exit ( this );
	}

	@Override
	public Calculator pushRandom ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( push ( random.nextBigDecimal () ) );
	}

	@Override
	public Calculator push ( int value )
	{
	  LOGGER.entry ( Integer.valueOf ( value ) );
		return LOGGER.exit ( push ( new BigDecimal ( value, mathContext ) ) );
	}

	@Override
	public Calculator push ( long value )
	{
	  LOGGER.entry ( Long.valueOf ( value ) );
		return LOGGER.exit ( push ( new BigDecimal ( value, mathContext ) ) );
	}

	@Override
	public Calculator push ( float value )
	{
	  LOGGER.entry ( Float.valueOf ( value ) );
		return LOGGER.exit ( push ( new BigDecimal ( value, mathContext ) ) );
	}

	@Override
	public Calculator push ( double value )
	{
	  LOGGER.entry ( Double.valueOf ( value ) );
		return LOGGER.exit ( push ( new BigDecimal ( value, mathContext ) ) );
	}

	@Override
	public Calculator push ( String value )
	{
	  LOGGER.entry ( value );
		return LOGGER.exit ( push ( new BigDecimal ( value, mathContext ) ) );
	}

	@Override
	public Calculator push ( BigInteger value )
	{
	  LOGGER.entry ( value );
		return LOGGER.exit ( push ( new BigDecimal ( value, mathContext ) ) );
	}

	@Override
	public Calculator push ( BigDecimal value )
	{
	  LOGGER.entry ( value );
		if ( value == null )
			throw LOGGER.throwing ( new NullPointerException ( "Value is null!!" ) );
		stack.push ( value );
		return LOGGER.exit ( this );
	}

	@Override
	public BigDecimal peek ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( stack.peek () );
	}

	@Override
	public BigDecimal pop ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( checkedPop () );
	}
	
	@Override
	public Calculator clear ()
	{
	  LOGGER.entry ();
		stack.clear ();
		Arrays.fill ( memory, BigDecimal.ZERO );
		return LOGGER.exit ( this );
	}

	@Override
	public MathContext getMathContext ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( mathContext );
	}

	@Override
	public Calculator setContext ( MathContext context )
	{
	  LOGGER.entry ( context );
		if ( context == null )
			this.mathContext = DEFALUT_MATH_CONTEXT;
		return LOGGER.exit ( this );
	}

	@Override
	public Random getRandom ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( random );
	}
	
	@Override
	public Calculator setRandom ( Random random )
	{
	  LOGGER.entry ( random );
		if ( random == null )
			random = DEFAULT_RANDOM;
		
		this.random = random;
		return LOGGER.exit ( this );
	}
	
	@Override
	public Collection < BigDecimal > getStack ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( Collections.unmodifiableCollection ( stack ) );
	}

	@Override
	public BigDecimal[] getMemory ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( Arrays.copyOf ( memory, memory.length ) );
	}

	@Override
	public String stackToString ()
	{
	  LOGGER.entry ();
		StringBuilder stringBuilder = new StringBuilder ();
		stringBuilder.append ( '[' );
		for ( Iterator < BigDecimal > itr = stack.descendingIterator (); itr.hasNext (); )
			stringBuilder.append ( itr.next () ).append ( ',' );
		stringBuilder.append ( ']' );
		return LOGGER.exit ( stringBuilder.toString () );
	}

	@Override
	public String memoryToString ()
	{
	  LOGGER.entry ();
		StringBuilder stringBuilder = new StringBuilder ();
		stringBuilder.append ( '[' );
		for ( int index = 0; index < memory.length; index++ )
			stringBuilder.append ( '{' ).append ( index ).append ( '=' ).append ( memory[ index ] ).append ( '}' ).append ( ',' );
		stringBuilder.append ( ']' );
		return LOGGER.exit ( stringBuilder.toString () );
	}

	private BigDecimal checkedPop ()
	{
	  LOGGER.entry ();
		try
		{
			return LOGGER.exit ( stack.pop () );
		}
		catch ( NoSuchElementException e )
		{
			throw LOGGER.throwing ( new CalculatorStackException ( "The Stack is Empty" ) );
		}
	}

	private void store ( BigDecimal value, int address )
	{
	  LOGGER.entry ( value, Integer.valueOf ( address ) );
		if ( address < 0 || address >= memory.length )
			throw LOGGER.throwing ( new CalculatorMemorySegmentationException ( address, memory.length - 1 ) );
		memory[ address ] = value;
		LOGGER.exit ();
	}

	private BigDecimal load ( int address )
	{
	  LOGGER.entry ( Integer.valueOf ( address ) );
		if ( address < 0 || address >= memory.length )
			throw LOGGER.throwing ( new CalculatorMemorySegmentationException ( address, memory.length - 1 ) );
		return LOGGER.exit ( memory[ address ] );
	}
}
