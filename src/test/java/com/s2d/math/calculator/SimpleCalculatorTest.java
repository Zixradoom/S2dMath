package com.s2d.math.calculator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

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
  
  @Test(expected=CalculatorStackException.class)
  public void absEmptyStack ()
  {
    calculator.abs ();
  }
  
  @Test
  public void absNegative ()
  {
    calculator.push ( BigDecimal.TEN.negate () );
    BigDecimal value = calculator.pop ();
    int compare = BigDecimal.TEN.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
  
  @Test
  public void absPositive ()
  {
    calculator.push ( BigDecimal.TEN );
    BigDecimal value = calculator.pop ();
    int compare = BigDecimal.TEN.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
  
  @Test
  public void absZero ()
  {
    calculator.push ( BigDecimal.ZERO );
    BigDecimal value = calculator.pop ();
    int compare = BigDecimal.ZERO.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
}
