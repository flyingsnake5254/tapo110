package org.bouncycastle.crypto.w;

import java.math.BigInteger;
import org.bouncycastle.crypto.e;

public class j
  implements e
{
  private BigInteger c;
  private BigInteger d;
  private BigInteger f;
  private m q;
  
  public j(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    this.c = paramBigInteger3;
    this.f = paramBigInteger1;
    this.d = paramBigInteger2;
  }
  
  public j(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, m paramm)
  {
    this.c = paramBigInteger3;
    this.f = paramBigInteger1;
    this.d = paramBigInteger2;
    this.q = paramm;
  }
  
  public BigInteger a()
  {
    return this.c;
  }
  
  public BigInteger b()
  {
    return this.f;
  }
  
  public BigInteger c()
  {
    return this.d;
  }
  
  public m d()
  {
    return this.q;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof j;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (j)paramObject;
    bool1 = bool2;
    if (((j)paramObject).b().equals(this.f))
    {
      bool1 = bool2;
      if (((j)paramObject).c().equals(this.d))
      {
        bool1 = bool2;
        if (((j)paramObject).a().equals(this.c)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return b().hashCode() ^ c().hashCode() ^ a().hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */