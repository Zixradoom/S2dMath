package com.s2d.math.util;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public final class MathUtilTest
{
  @Before
  public void setUpTest ()
  {
  }
  
  @After
  public void cleanUpTest ()
  {
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void clampLowerGreaterThanUpper ()
  {
    MathUtil.clamp ( BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.ONE );
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void clampLowerEqualToUpper ()
  {
    MathUtil.clamp ( BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ONE );
  }
  
  @Test
  public void clampLowerLessThanUpper ()
  {
    BigDecimal value = MathUtil.clamp ( BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.TEN );
    int compare = BigDecimal.ONE.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
  
  @Test
  public void clampValueLessThanLower ()
  {
    BigDecimal value = MathUtil.clamp ( BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN );
    int compare = BigDecimal.ONE.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
  
  @Test
  public void clampValueEqualToLower ()
  {
    BigDecimal value = MathUtil.clamp ( BigDecimal.ONE, BigDecimal.ONE, BigDecimal.TEN );
    int compare = BigDecimal.ONE.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
  
  @Test
  public void clampValueGreaterThanLower ()
  {
    BigDecimal value = MathUtil.clamp ( BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.TEN );
    int compare = BigDecimal.ONE.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
  
  @Test
  public void clampValueEqualToUpper ()
  {
    BigDecimal value = MathUtil.clamp ( BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.TEN );
    int compare = BigDecimal.TEN.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
  
  @Test
  public void clampValueGreaterThanUpper ()
  {
    BigDecimal value = MathUtil.clamp ( BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.ONE );
    int compare = BigDecimal.ONE.compareTo ( value );
    assertEquals ( "", Integer.valueOf ( 0 ), Integer.valueOf ( compare ) );
  }
  
  @Test(expected=NullPointerException.class)
  public void clampValueNull ()
  {
    MathUtil.clamp ( null, BigDecimal.ONE, BigDecimal.ONE );
  }
  
  @Test(expected=NullPointerException.class)
  public void clampLowerNull ()
  {
    MathUtil.clamp ( BigDecimal.ONE, null, BigDecimal.ONE );
  }
  
  @Test(expected=NullPointerException.class)
  public void clampUpperNull ()
  {
    MathUtil.clamp ( BigDecimal.ONE, BigDecimal.ONE, null );
  }
}