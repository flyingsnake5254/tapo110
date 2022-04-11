package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.bouncycastle.util.a;
import org.bouncycastle.util.encoders.d;
import org.bouncycastle.util.i;

public abstract class n
  extends q
  implements o
{
  byte[] c;
  
  public n(byte[] paramArrayOfByte)
  {
    Objects.requireNonNull(paramArrayOfByte, "string cannot be null");
    this.c = paramArrayOfByte;
  }
  
  public static n m(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof n)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = m(q.i((byte[])paramObject));
          return (n)paramObject;
        }
        catch (IOException paramObject)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("failed to construct OCTET STRING from byte[]: ");
          ((StringBuilder)localObject).append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      if ((paramObject instanceof e))
      {
        localObject = ((e)paramObject).c();
        if ((localObject instanceof n)) {
          return (n)localObject;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("illegal object in getInstance: ");
      ((StringBuilder)localObject).append(paramObject.getClass().getName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return (n)paramObject;
  }
  
  public static n n(x paramx, boolean paramBoolean)
  {
    paramx = paramx.o();
    if ((!paramBoolean) && (!(paramx instanceof n))) {
      return c0.q(r.m(paramx));
    }
    return m(paramx);
  }
  
  public InputStream a()
  {
    return new ByteArrayInputStream(this.c);
  }
  
  public q b()
  {
    return c();
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof n)) {
      return false;
    }
    paramq = (n)paramq;
    return a.c(this.c, paramq.c);
  }
  
  public int hashCode()
  {
    return a.w(o());
  }
  
  q k()
  {
    return new x0(this.c);
  }
  
  q l()
  {
    return new x0(this.c);
  }
  
  public byte[] o()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#");
    localStringBuilder.append(i.b(d.b(this.c)));
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */