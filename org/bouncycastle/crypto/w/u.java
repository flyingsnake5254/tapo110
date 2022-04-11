package org.bouncycastle.crypto.w;

import java.math.BigInteger;
import org.bouncycastle.crypto.e;

public class u
  implements e
{
  private BigInteger c;
  private BigInteger d;
  private int f;
  
  public u(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this(paramBigInteger1, paramBigInteger2, 0);
  }
  
  public u(BigInteger paramBigInteger1, BigInteger paramBigInteger2, int paramInt)
  {
    this.c = paramBigInteger2;
    this.d = paramBigInteger1;
    this.f = paramInt;
  }
  
  public BigInteger a()
  {
    return this.c;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public BigInteger c()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof u;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (u)paramObject;
    bool1 = bool2;
    if (((u)paramObject).c().equals(this.d))
    {
      bool1 = bool2;
      if (((u)paramObject).a().equals(this.c))
      {
        bool1 = bool2;
        if (((u)paramObject).b() == this.f) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (c().hashCode() ^ a().hashCode()) + this.f;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */