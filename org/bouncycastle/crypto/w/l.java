package org.bouncycastle.crypto.w;

import java.math.BigInteger;

public class l
  extends i
{
  private static final BigInteger f = BigInteger.valueOf(1L);
  private static final BigInteger q = BigInteger.valueOf(2L);
  private BigInteger x = d(paramBigInteger, paramj);
  
  public l(BigInteger paramBigInteger, j paramj)
  {
    super(false, paramj);
  }
  
  private BigInteger d(BigInteger paramBigInteger, j paramj)
  {
    if (paramj != null)
    {
      BigInteger localBigInteger = q;
      if ((localBigInteger.compareTo(paramBigInteger) <= 0) && (paramj.b().subtract(localBigInteger).compareTo(paramBigInteger) >= 0) && (f.equals(paramBigInteger.modPow(paramj.c(), paramj.b())))) {
        return paramBigInteger;
      }
      throw new IllegalArgumentException("y value does not appear to be in correct group");
    }
    return paramBigInteger;
  }
  
  public BigInteger c()
  {
    return this.x;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */