package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.a;
import org.bouncycastle.util.i;

public class i1
  extends q
  implements w
{
  private final byte[] c;
  
  public i1(String paramString)
  {
    this.c = i.h(paramString);
  }
  
  i1(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  public static i1 m(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof i1)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (i1)q.i((byte[])paramObject);
          return (i1)paramObject;
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
    return (i1)paramObject;
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof i1)) {
      return false;
    }
    paramq = (i1)paramq;
    return a.c(this.c, paramq.c);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.g(12, this.c);
  }
  
  public String getString()
  {
    return i.c(this.c);
  }
  
  int h()
    throws IOException
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\i1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */