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
	  LOGGER.entry ( str );
		try
		{
			return LOGGER.exit ( Short.valueOf ( str ) );
		}
		catch ( NumberFormatException e )
		{
		  LOGGER.catching ( Level.TRACE, e );
		  return LOGGER.exit ( null );
		}
	}
	
	public static Integer tryParseInt ( String str )
	{
	  LOGGER.entry ( str );
		try
		{
			return LOGGER.exit ( Integer.valueOf ( str ) );
		}
		catch ( NumberFormatException e )
		{
		  LOGGER.catching ( Level.TRACE, e );
      return LOGGER.exit ( null );
		}
	}
	
	public static Long tryParseLong ( String str )
	{
	  LOGGER.entry ( str );
		try
		{
			return LOGGER.exit ( Long.valueOf ( str ) );
		}
		catch ( NumberFormatException e )
		{
		  LOGGER.catching ( Level.TRACE, e );
      return LOGGER.exit ( null );
		}
	}
	
	public static Float tryParseFloat ( String str )
	{
	  LOGGER.entry ( str );
		try
		{
			return LOGGER.exit ( Float.valueOf ( str ) );
		}
		catch ( NumberFormatException e )
		{
		  LOGGER.catching ( Level.TRACE, e );
      return LOGGER.exit ( null );
		}
	}
	
	public static Double tryParseDouble ( String str )
	{
	  LOGGER.entry ( str );
		try
		{
			return LOGGER.exit ( Double.valueOf ( str ) );
		}
		catch ( NumberFormatException e )
		{
		  LOGGER.catching ( Level.TRACE, e );
      return LOGGER.exit ( null );
		}
	}
}
