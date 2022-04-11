package org.bouncycastle.crypto.w;

import java.math.BigInteger;

public class e
  implements org.bouncycastle.crypto.e
{
  private BigInteger c;
  private BigInteger d;
  private BigInteger f;
  private BigInteger q;
  private int x;
  private int y;
  private h z;
  
  public e(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this(paramBigInteger1, paramBigInteger2, null, 0);
  }
  
  public e(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    this(paramBigInteger1, paramBigInteger2, paramBigInteger3, 0);
  }
  
  public e(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, int paramInt)
  {
    this(paramBigInteger1, paramBigInteger2, paramBigInteger3, a(paramInt), paramInt, null, null);
  }
  
  public e(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, int paramInt1, int paramInt2, BigInteger paramBigInteger4, h paramh)
  {
    if (paramInt2 != 0) {
      if (paramInt2 <= paramBigInteger1.bitLength())
      {
        if (paramInt2 < paramInt1) {
          throw new IllegalArgumentException("when l value specified, it may not be less than m value");
        }
      }
      else {
        throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
      }
    }
    if (paramInt1 <= paramBigInteger1.bitLength())
    {
      this.c = paramBigInteger2;
      this.d = paramBigInteger1;
      this.f = paramBigInteger3;
      this.x = paramInt1;
      this.y = paramInt2;
      this.q = paramBigInteger4;
      this.z = paramh;
      return;
    }
    throw new IllegalArgumentException("unsafe p value so small specific l required");
  }
  
  public e(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, h paramh)
  {
    this(paramBigInteger1, paramBigInteger2, paramBigInteger3, 160, 0, paramBigInteger4, paramh);
  }
  
  private static int a(int paramInt)
  {
    if (paramInt == 0) {
      return 160;
    }
    if (paramInt >= 160) {
      paramInt = 160;
    }
    return paramInt;
  }
  
  public BigInteger b()
  {
    return this.c;
  }
  
  public BigInteger c()
  {
    return this.q;
  }
  
  public int d()
  {
    return this.y;
  }
  
  public int e()
  {
    return this.x;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof e;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (e)paramObject;
    if (g() != null)
    {
      if (!g().equals(((e)paramObject).g())) {
        return false;
      }
    }
    else if (((e)paramObject).g() != null) {
      return false;
    }
    bool1 = bool2;
    if (((e)paramObject).f().equals(this.d))
    {
      bool1 = bool2;
      if (((e)paramObject).b().equals(this.c)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public BigInteger f()
  {
    return this.d;
  }
  
  public BigInteger g()
  {
    return this.f;
  }
  
  public h h()
  {
    return this.z;
  }
  
  public int hashCode()
  {
    int i = f().hashCode();
    int j = b().hashCode();
    int k;
    if (g() != null) {
      k = g().hashCode();
    } else {
      k = 0;
    }
    return i ^ j ^ k;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */