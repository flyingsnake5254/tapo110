package org.bouncycastle.crypto.w;

import java.math.BigInteger;

public class d0
  extends b
{
  private static final BigInteger d = BigInteger.valueOf(1L);
  private BigInteger f;
  private BigInteger q;
  
  public d0(boolean paramBoolean, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    super(paramBoolean);
    if ((!paramBoolean) && ((paramBigInteger2.intValue() & 0x1) == 0)) {
      throw new IllegalArgumentException("RSA publicExponent is even");
    }
    this.f = d(paramBigInteger1);
    this.q = paramBigInteger2;
  }
  
  private BigInteger d(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.intValue() & 0x1) != 0)
    {
      if (paramBigInteger.gcd(new BigInteger("1451887755777639901511587432083070202422614380984889313550570919659315177065956574359078912654149167643992684236991305777574330831666511589145701059710742276692757882915756220901998212975756543223550490431013061082131040808010565293748926901442915057819663730454818359472391642885328171302299245556663073719855")).equals(d)) {
        return paramBigInteger;
      }
      throw new IllegalArgumentException("RSA modulus has a small prime factor");
    }
    throw new IllegalArgumentException("RSA modulus is even");
  }
  
  public BigInteger b()
  {
    return this.q;
  }
  
  public BigInteger c()
  {
    return this.f;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */