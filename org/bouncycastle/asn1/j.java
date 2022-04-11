package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.a;
import org.bouncycastle.util.g;

public class j
  extends q
{
  private final byte[] c;
  
  public j(long paramLong)
  {
    this.c = BigInteger.valueOf(paramLong).toByteArray();
  }
  
  public j(BigInteger paramBigInteger)
  {
    this.c = paramBigInteger.toByteArray();
  }
  
  public j(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, true);
  }
  
  j(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((!g.c("org.bouncycastle.asn1.allow_unsafe_integer")) && (q(paramArrayOfByte))) {
      throw new IllegalArgumentException("malformed integer");
    }
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramBoolean) {
      arrayOfByte = a.g(paramArrayOfByte);
    }
    this.c = arrayOfByte;
  }
  
  public static j m(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof j)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (j)q.i((byte[])paramObject);
          return (j)paramObject;
        }
        catch (Exception paramObject)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("encoding error in getInstance: ");
          localStringBuilder.append(((Exception)paramObject).toString());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (j)paramObject;
  }
  
  public static j n(x paramx, boolean paramBoolean)
  {
    paramx = paramx.o();
    if ((!paramBoolean) && (!(paramx instanceof j))) {
      return new j(n.m(paramx).o());
    }
    return m(paramx);
  }
  
  static boolean q(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 1)
    {
      if ((paramArrayOfByte[0] == 0) && ((paramArrayOfByte[1] & 0x80) == 0)) {
        return true;
      }
      if ((paramArrayOfByte[0] == -1) && ((paramArrayOfByte[1] & 0x80) != 0)) {
        return true;
      }
    }
    return false;
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof j)) {
      return false;
    }
    paramq = (j)paramq;
    return a.c(this.c, paramq.c);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.g(2, this.c);
  }
  
  int h()
  {
    return y1.a(this.c.length) + 1 + this.c.length;
  }
  
  public int hashCode()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      byte[] arrayOfByte = this.c;
      if (i == arrayOfByte.length) {
        break;
      }
      j ^= (arrayOfByte[i] & 0xFF) << i % 4;
      i++;
    }
    return j;
  }
  
  boolean j()
  {
    return false;
  }
  
  public BigInteger o()
  {
    return new BigInteger(1, this.c);
  }
  
  public BigInteger p()
  {
    return new BigInteger(this.c);
  }
  
  public String toString()
  {
    return p().toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */