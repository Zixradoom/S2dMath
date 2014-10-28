package com.s2d.math.util;

import java.math.BigDecimal;

public interface Random
{
  public void nextBytes ( byte[] bytes );
  public int nextInt ();
  public int nextInt ( int n );
  public long nextLong ();
  public boolean nextBoolean ();
  public float nextFloat ();
  public double nextDouble ();
  public double nextGaussian ();
	public BigDecimal nextBigDecimal ();
	public BigDecimal inRange ( BigDecimal lower, BigDecimal upper );
}
