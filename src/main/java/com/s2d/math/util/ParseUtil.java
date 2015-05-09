package com.s2d.math.util;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLogger.Level;
import org.slf4j.ext.XLoggerFactory;

/**
 * 
 * Parsing utility functions
 * 
 * @author Anthony J Simon
 *
 */
public final class ParseUtil
{
  private static final XLogger LOGGER = XLoggerFactory.getXLogger ( ParseUtil.class );
  
	public static Byte tryParseByte ( String str )
	{
	  LOGGER.entry ( str );
		try
		{
			return LOGGER.exit ( Byte.valueOf ( str ) );
		}
		catch ( NumberFormatException e )
		{
		  LOGGER.catching ( Level.TRACE, e );
			return LOGGER.exit ( null );
		}
	}
	
	public static Short tryParseShort ( String str )
	{
		try
		{
			return Short.valueOf ( str );
		}
		catch ( NumberFormatException e )
		{
			return null;
		}
	}
	
	public static Integer tryParseInt ( String str )
	{
		try
		{
			return Integer.valueOf ( str );
		}
		catch ( NumberFormatException e )
		{
			return null;
		}
	}
	
	public static Long tryParseLong ( String str )
	{
		try
		{
			return Long.valueOf ( str );
		}
		catch ( NumberFormatException e )
		{
			return null;
		}
	}
	
	public static Float tryParseFloat ( String str )
	{
		try
		{
			return Float.valueOf ( str );
		}
		catch ( NumberFormatException e )
		{
			return null;
		}
	}
	
	public static Double tryParseDouble ( String str )
	{
		try
		{
			return Double.valueOf ( str );
		}
		catch ( NumberFormatException e )
		{
			return null;
		}
	}
}
