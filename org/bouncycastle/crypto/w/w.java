package org.bouncycastle.crypto.w;

import java.math.BigInteger;

public class w
  extends t
{
  private BigInteger f;
  
  public w(BigInteger paramBigInteger, u paramu)
  {
    super(false, paramu);
    this.f = paramBigInteger;
  }
  
  public BigInteger c()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof w;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (((w)paramObject).c().equals(this.f))
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
    return this.f.hashCode() ^ super.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */