package com.s2d.math.util;

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
    MathUtil.clamp ( BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.TEN );
  }
  
  @Test
  public void clampValueLessThanLower ()
  {
    BigDecimal value = MathUtil.clamp ( BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN );
    // TODO assertTrue
  }
  
  @Test
  public void clampValueEqualToLower ()
  {
  }
  
  @Test
  public void clampValueGreaterThanLower ()
  {
  }
  
  @Test
  public void clampValueEqualToUpper ()
  {
  }
  
  @Test
  public void clampValueGreaterThanUpper ()
  {
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