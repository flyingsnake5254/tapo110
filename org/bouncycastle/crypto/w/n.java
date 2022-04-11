package org.bouncycastle.crypto.w;

import e.a.b.a.b;
import e.a.b.a.c;
import e.a.b.a.d;
import e.a.b.a.h;
import java.math.BigInteger;
import java.util.Objects;
import org.bouncycastle.util.a;

public class n
  implements c
{
  private d g;
  private byte[] h;
  private h i;
  private BigInteger j;
  private BigInteger k;
  private BigInteger l = null;
  
  public n(d paramd, h paramh, BigInteger paramBigInteger)
  {
    this(paramd, paramh, paramBigInteger, c.b, null);
  }
  
  public n(d paramd, h paramh, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this(paramd, paramh, paramBigInteger1, paramBigInteger2, null);
  }
  
  public n(d paramd, h paramh, BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte)
  {
    Objects.requireNonNull(paramd, "curve");
    Objects.requireNonNull(paramBigInteger1, "n");
    this.g = paramd;
    this.i = g(paramd, paramh);
    this.j = paramBigInteger1;
    this.k = paramBigInteger2;
    this.h = paramArrayOfByte;
  }
  
  static h g(d paramd, h paramh)
  {
    if (paramh != null)
    {
      if (!paramh.u())
      {
        paramh = paramh.A();
        if (paramh.w()) {
          return b.f(paramd, paramh);
        }
        throw new IllegalArgumentException("point not on curve");
      }
      throw new IllegalArgumentException("point at infinity");
    }
    throw new IllegalArgumentException("point has null value");
  }
  
  public d a()
  {
    return this.g;
  }
  
  public h b()
  {
    return this.i;
  }
  
  public BigInteger c()
  {
    return this.k;
  }
  
  public BigInteger d()
  {
    try
    {
      if (this.l == null) {
        this.l = this.k.modInverse(this.j);
      }
      BigInteger localBigInteger = this.l;
      return localBigInteger;
    }
    finally {}
  }
  
  public BigInteger e()
  {
    return this.j;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof n))
    {
      paramObject = (n)paramObject;
      if ((!this.g.m(((n)paramObject).g)) || (!this.i.e(((n)paramObject).i)) || (!this.j.equals(((n)paramObject).j)) || (!this.k.equals(((n)paramObject).k))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public byte[] f()
  {
    return a.g(this.h);
  }
  
  public int hashCode()
  {
    return ((this.g.hashCode() * 37 ^ this.i.hashCode()) * 37 ^ this.j.hashCode()) * 37 ^ this.k.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */