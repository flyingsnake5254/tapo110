package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class g
  extends q
{
  private static g[] c = new g[12];
  private final byte[] d;
  
  public g(byte[] paramArrayOfByte)
  {
    if ((!org.bouncycastle.util.g.c("org.bouncycastle.asn1.allow_unsafe_integer")) && (j.q(paramArrayOfByte))) {
      throw new IllegalArgumentException("malformed enumerated");
    }
    this.d = a.g(paramArrayOfByte);
  }
  
  static g m(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 1) {
      return new g(paramArrayOfByte);
    }
    if (paramArrayOfByte.length != 0)
    {
      int i = paramArrayOfByte[0] & 0xFF;
      g[] arrayOfg = c;
      if (i >= arrayOfg.length) {
        return new g(a.g(paramArrayOfByte));
      }
      g localg1 = arrayOfg[i];
      g localg2 = localg1;
      if (localg1 == null)
      {
        localg2 = new g(a.g(paramArrayOfByte));
        arrayOfg[i] = localg2;
      }
      return localg2;
    }
    throw new IllegalArgumentException("ENUMERATED has zero length");
  }
  
  public static g n(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof g)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (g)q.i((byte[])paramObject);
          return (g)paramObject;
        }
        catch (Exception localException)
        {
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("encoding error in getInstance: ");
          ((StringBuilder)paramObject).append(localException.toString());
          throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (g)paramObject;
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof g)) {
      return false;
    }
    paramq = (g)paramq;
    return a.c(this.d, paramq.d);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.g(10, this.d);
  }
  
  int h()
  {
    return y1.a(this.d.length) + 1 + this.d.length;
  }
  
  public int hashCode()
  {
    return a.w(this.d);
  }
  
  boolean j()
  {
    return false;
  }
  
  public BigInteger o()
  {
    return new BigInteger(this.d);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */