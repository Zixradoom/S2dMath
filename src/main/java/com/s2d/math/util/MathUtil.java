package com.s2d.math.util;

import java.math.BigDecimal;

public final class MathUtil
{
	public static BigDecimal clamp ( BigDecimal value, BigDecimal lower, BigDecimal upper )
	{
		if ( value == null )
			throw new NullPointerException ( "Value is null!!" );
		if ( lower == null )
			throw new NullPointerException ( "Lower is null!!" );
		if ( upper == null )
			throw new NullPointerException ( "Upper is null!!" );
		int cmpR = lower.compareTo ( upper );
		if ( cmpR >= 0 )
			throw new IllegalArgumentException ( String.format ( "%s is not less than %s", lower, upper ) );
		int cmpL = lower.compareTo ( value );
		if ( cmpL >= 0 )
			return lower;
		int cmpU = value.compareTo ( upper );
		if ( cmpU >= 0 )
			return upper;
		return value;
	}
}
