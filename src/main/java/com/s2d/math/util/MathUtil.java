package com.s2d.math.util;

import java.math.BigDecimal;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

public final class MathUtil
{
  private static final XLogger LOGGER = XLoggerFactory.getXLogger ( MathUtil.class );
  
	public static BigDecimal clamp ( BigDecimal value, BigDecimal lower, BigDecimal upper )
	{
	  LOGGER.entry ( value, lower, upper );
		if ( value == null )
			throw LOGGER.throwing ( new NullPointerException ( "Value is null!!" ) );
		if ( lower == null )
			throw LOGGER.throwing ( new NullPointerException ( "Lower is null!!" ) );
		if ( upper == null )
			throw LOGGER.throwing ( new NullPointerException ( "Upper is null!!" ) );
		int cmpR = lower.compareTo ( upper );
		if ( cmpR >= 0 )
			throw LOGGER.throwing ( new IllegalArgumentException ( String.format ( "%s is not less than %s", lower, upper ) ) );
		int cmpL = lower.compareTo ( value );
		if ( cmpL >= 0 )
			return lower;
		int cmpU = value.compareTo ( upper );
		if ( cmpU >= 0 )
			return upper;
		return LOGGER.exit ( value );
	}
}
