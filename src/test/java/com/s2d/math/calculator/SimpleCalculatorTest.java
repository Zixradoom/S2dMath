package com.s2d.math.calculator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

public class SimpleCalculatorTest
{
  private static Calculator calculator = null;
  
  @Before
  public void setUpTest ()
  {
    calculator = new SimpleCalculator ();
  }

  @Test(expected=CalculatorStackException.class)
  public void popEmptyCalculatorStack ()
  {
    BigDecimal value = calculator.pop ();
  }
  
  @Test
  public void pushPeek ()
  {
    calculator.push ( BigDecimal.TEN );
    BigDecimal value = calculator.peek ();
    int compare = BigDecimal.TEN.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
  
  @Test
  public void pushPop ()
  {
    calculator.push ( BigDecimal.TEN );
    BigDecimal value = calculator.pop ();
    int compare = BigDecimal.TEN.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
  
  @Test(expected=NullPointerException.class)
  public void pushNullString ()
  {
    String value = null;
    calculator.push ( value );
  }
  
  @Test(expected=NumberFormatException.class)
  public void pushEmptyString ()
  {
    String value = "";
    calculator.push ( value );
  }
  
  @Test(expected=NullPointerException.class)
  public void pushNullBigDecimal ()
  {
    BigDecimal value = null;
    calculator.push ( value );
  }
  
  @Test(expected=NullPointerException.class)
  public void pushNullBigInteger ()
  {
    BigInteger value = null;
    calculator.push ( value );
  }
  
  @Test(expected=CalculatorStackException.class)
  public void absEmptyStack ()
  {
    calculator.abs ();
  }
  
  @Test
  public void absNegative ()
  {
    calculator.push ( BigDecimal.TEN.negate () );
    calculator.abs ();
    BigDecimal value = calculator.pop ();
    int compare = BigDecimal.TEN.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
  
  @Test
  public void absPositive ()
  {
    calculator.push ( BigDecimal.TEN );
    calculator.abs ();
    BigDecimal value = calculator.pop ();
    int compare = BigDecimal.TEN.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
  
  @Test
  public void absZero ()
  {
    calculator.push ( BigDecimal.ZERO );
    calculator.abs ();
    BigDecimal value = calculator.pop ();
    int compare = BigDecimal.ZERO.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
  
  @Test(expected=CalculatorStackException.class)
  public void duplicateEmptyStack ()
  {
    calculator.duplicate ();
  }
  
  @Test
  public void duplicateNumber ()
  {
    calculator.push ( "10" );
    calculator.duplicate ();
    BigDecimal value = calculator.pop ();
    int compare1 = BigDecimal.TEN.compareTo ( value );
    value = calculator.pop ();
    int compare2 = BigDecimal.TEN.compareTo ( value );
    assertEquals ( "", Boolean.valueOf ( true ), Boolean.valueOf ( compare1 == 0 && compare2 == 0 ) );
  }
}
