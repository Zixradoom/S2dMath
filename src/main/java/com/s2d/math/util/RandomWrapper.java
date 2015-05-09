package com.s2d.math.util;

import java.math.BigDecimal;
import java.math.MathContext;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

public final class RandomWrapper implements Random
{
  private static final XLogger LOGGER = XLoggerFactory.getXLogger ( RandomWrapper.class );
  
	private final java.util.Random random;
	
	public RandomWrapper ( java.util.Random random )
	{
	  LOGGER.entry ( random );
		if ( random == null )
			throw LOGGER.throwing ( new NullPointerException ( "Random is null!!" ) );
		
		this.random = random;
		LOGGER.exit ();
	}

	@Override
	public void nextBytes ( byte[] bytes )
	{
	  LOGGER.entry ( bytes );
		random.nextBytes ( bytes );
		LOGGER.exit ();
	}

	@Override
	public int nextInt ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( Integer.valueOf ( random.nextInt () ) ).intValue ();
	}

	@Override
	public int nextInt ( int n )
	{
	  LOGGER.entry ( Integer.valueOf ( n ) );
		return LOGGER.exit ( Integer.valueOf ( random.nextInt ( n ) ) ).intValue ();
	}

	@Override
	public long nextLong ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( Long.valueOf ( random.nextLong () ) ).longValue ();
	}

	@Override
	public boolean nextBoolean ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( Boolean.valueOf ( random.nextBoolean () ) ).booleanValue ();
	}

	@Override
	public float nextFloat ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( Float.valueOf ( random.nextFloat () ) ).floatValue ();
	}

	@Override
	public double nextDouble ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( Double.valueOf ( random.nextDouble () ) ).doubleValue ();
	}

	@Override
	public double nextGaussian ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( Double.valueOf ( random.nextGaussian ()  ) ).doubleValue ();
	}

	@Override
	public BigDecimal nextBigDecimal ()
	{
	  LOGGER.entry ();
		return LOGGER.exit ( new BigDecimal ( random.nextDouble (), MathContext.UNLIMITED ) );
	}
	
	@Override
	public BigDecimal inRange ( BigDecimal lower, BigDecimal upper )
	{
	  LOGGER.entry ( lower, upper );
		if ( lower == null )
			throw LOGGER.throwing ( new NullPointerException ( "Lower is null!!" ) );
		if ( upper == null )
			throw LOGGER.throwing ( new NullPointerException ( "Upper is null!!" ) );
		int cmpR = lower.compareTo ( upper );
		if ( cmpR >= 0 )
			throw LOGGER.throwing ( new IllegalArgumentException ( String.format ( "%s is not less than %s", lower, upper ) ) );
		return LOGGER.exit ( nextBigDecimal ().multiply ( upper.subtract ( lower ) ).add ( lower ) );
	}
}
