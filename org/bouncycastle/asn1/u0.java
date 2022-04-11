package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.util.a;
import org.bouncycastle.util.i;

public class u0
  extends q
  implements w
{
  private final byte[] c;
  
  public u0(String paramString)
  {
    this(paramString, false);
  }
  
  public u0(String paramString, boolean paramBoolean)
  {
    Objects.requireNonNull(paramString, "string cannot be null");
    if ((paramBoolean) && (!o(paramString))) {
      throw new IllegalArgumentException("string contains illegal characters");
    }
    this.c = i.e(paramString);
  }
  
  u0(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  public static u0 m(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof u0)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (u0)q.i((byte[])paramObject);
          return (u0)paramObject;
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
    return (u0)paramObject;
  }
  
  public static u0 n(x paramx, boolean paramBoolean)
  {
    paramx = paramx.o();
    if ((!paramBoolean) && (!(paramx instanceof u0))) {
      return new u0(((n)paramx).o());
    }
    return m(paramx);
  }
  
  public static boolean o(String paramString)
  {
    for (int i = paramString.length() - 1; i >= 0; i--) {
      if (paramString.charAt(i) > '') {
        return false;
      }
    }
    return true;
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof u0)) {
      return false;
    }
    paramq = (u0)paramq;
    return a.c(this.c, paramq.c);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.g(22, this.c);
  }
  
  public String getString()
  {
    return i.b(this.c);
  }
  
  int h()
  {
    return y1.a(this.c.length) + 1 + this.c.length;
  }
  
  public int hashCode()
  {
    return a.w(this.c);
  }
  
  boolean j()
  {
    return false;
  }
  
  public String toString()
  {
    return getString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\u0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */