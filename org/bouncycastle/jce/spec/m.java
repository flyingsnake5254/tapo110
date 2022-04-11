package org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class m
{
  private BigInteger a;
  private BigInteger b;
  private BigInteger c;
  
  public m(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    this.a = paramBigInteger1;
    this.b = paramBigInteger2;
    this.c = paramBigInteger3;
  }
  
  public BigInteger a()
  {
    return this.c;
  }
  
  public BigInteger b()
  {
    return this.a;
  }
  
  public BigInteger c()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof m;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (m)paramObject;
      bool3 = bool2;
      if (this.c.equals(((m)paramObject).c))
      {
        bool3 = bool2;
        if (this.a.equals(((m)paramObject).a))
        {
          bool3 = bool2;
          if (this.b.equals(((m)paramObject).b)) {
            bool3 = true;
          }
        }
      }
    }
    return bool3;
  }
  
  public int hashCode()
  {
    return this.c.hashCode() ^ this.a.hashCode() ^ this.b.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\spec\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */