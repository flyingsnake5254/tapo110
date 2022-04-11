package org.bouncycastle.crypto.w;

import java.math.BigInteger;
import java.util.Objects;

public class g
  extends d
{
  private static final BigInteger f = BigInteger.valueOf(1L);
  private static final BigInteger q = BigInteger.valueOf(2L);
  private BigInteger x = d(paramBigInteger, parame);
  
  public g(BigInteger paramBigInteger, e parame)
  {
    super(false, parame);
  }
  
  private BigInteger d(BigInteger paramBigInteger, e parame)
  {
    Objects.requireNonNull(paramBigInteger, "y value cannot be null");
    BigInteger localBigInteger = q;
    if ((paramBigInteger.compareTo(localBigInteger) >= 0) && (paramBigInteger.compareTo(parame.f().subtract(localBigInteger)) <= 0))
    {
      if (parame.g() != null)
      {
        if (f.equals(paramBigInteger.modPow(parame.g(), parame.f()))) {
          return paramBigInteger;
        }
        throw new IllegalArgumentException("Y value does not appear to be in correct group");
      }
      return paramBigInteger;
    }
    throw new IllegalArgumentException("invalid DH public key");
  }
  
  public BigInteger c()
  {
    return this.x;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof g;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (((g)paramObject).c().equals(this.x))
    {
      bool1 = bool2;
      if (super.equals(paramObject)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.x.hashCode() ^ super.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */