package com.s2d.math.util;

/**
 * 
 * Parsing utility functions
 * 
 * @author Anthony J Simon
 *
 */
public final class ParseUtil
{
	public static Byte tryParseByte ( String str )
	{
		try
		{
			return Byte.valueOf ( str );
		}
		catch ( NumberFormatException e )
		{
			return null;
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
