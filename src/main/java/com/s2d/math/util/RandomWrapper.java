package com.s2d.math.util;

import java.math.BigDecimal;
import java.math.MathContext;

public final class RandomWrapper implements Random
{
	private final java.util.Random random;
	
	public RandomWrapper ( java.util.Random random )
	{
		if ( random == null )
			throw new NullPointerException ( "Random is null!!" );
		
		this.random = random;
	}

	@Override
	public void nextBytes ( byte[] bytes )
	{
		random.nextBytes ( bytes );
	}

	@Override
	public int nextInt ()
	{
		return random.nextInt ();
	}

	@Override
	public int nextInt ( int n )
	{
		return random.nextInt ( n );
	}

	@Override
	public long nextLong ()
	{
		return random.nextLong ();
	}

	@Override
	public boolean nextBoolean ()
	{
		return random.nextBoolean ();
	}

	@Override
	public float nextFloat ()
	{
		return random.nextFloat ();
	}

	@Override
	public double nextDouble ()
	{
		return random.nextDouble ();
	}

	@Override
	public double nextGaussian ()
	{
		return random.nextGaussian ();
	}

	@Override
	public BigDecimal nextBigDecimal ()
	{
		return new BigDecimal ( random.nextDouble (), MathContext.UNLIMITED );
	}
	
	@Override
	public BigDecimal inRange ( BigDecimal lower, BigDecimal upper )
	{
		if ( lower == null )
			throw new NullPointerException ( "Lower is null!!" );
		if ( upper == null )
			throw new NullPointerException ( "Upper is null!!" );
		int cmpR = lower.compareTo ( upper );
		if ( cmpR >= 0 )
			throw new IllegalArgumentException ( String.format ( "%s is not less than %s", lower, upper ) );
		return nextBigDecimal ().multiply ( upper.subtract ( lower ) ).add ( lower );
	}
}
