package com.s2d.math.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ParseTest
{
	public static void main ( String[] args )
	{
		String testValue = "woo hoo; why me?;";
		List < List < String[] > > parsedData = new ArrayList < List < String[] > > ();
		if ( args.length > 0 )
			for ( String arg : args )
				parsedData.add ( parseProgram ( arg ) );
		else
			parsedData.add ( parseProgram ( testValue ) );

		for ( List < String [] > program : parsedData )
		{
			for ( String[] line : program )
			{
				for ( String symbol : line )
					System.out.printf ( "'%s'%n", symbol );
				//System.out.printf ( "%s ", symbol );
				//System.out.println ( ";" );
				//System.out.println ();
			}
		}
	}

	private static List < String [] > parseProgram ( String expresion )
	{
		List < String[] > symboles = Collections.emptyList ();
		if ( expresion != null && !expresion.isEmpty () )
		{
			String[] lines = expresion.split ( ";+" );
			symboles = new ArrayList < String [] > ( lines.length );
			for ( String line : lines )
				symboles.add ( line.trim ().split ( "\\s+" ) );
		}
		return symboles;
	}

	private static boolean validVariable ( String symbol )
	{
		return false;
	}
	
	private static boolean validNumber ( String symbol )
	{
		try
		{
			new BigDecimal ( symbol );
			return true;
		}
		catch ( NumberFormatException e )
		{
			return false;
		}
	}
	
	private static boolean validOperator ( String symbol )
	{
		return "+".equalsIgnoreCase ( symbol ) ||
				"-".equalsIgnoreCase ( symbol ) ||
				"*".equalsIgnoreCase ( symbol ) ||
				"\\".equalsIgnoreCase ( symbol ) ||
				"/".equalsIgnoreCase ( symbol ) ||
				"**".equalsIgnoreCase ( symbol ) ||
				"dup".equalsIgnoreCase ( symbol ) ||
				"neg".equalsIgnoreCase ( symbol ) ||
				"abs".equalsIgnoreCase ( symbol ) ||
				"clamp".equalsIgnoreCase ( symbol ) ||
				"scale".equalsIgnoreCase ( symbol ) ||
				"swap".equalsIgnoreCase ( symbol );
	}
}
