package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class l
  implements e
{
  public abstract q c();
  
  public byte[] d()
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    new p(localByteArrayOutputStream).j(this);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public byte[] e(String paramString)
    throws IOException
  {
    if (paramString.equals("DER"))
    {
      paramString = new ByteArrayOutputStream();
      new z0(paramString).j(this);
    }
    for (;;)
    {
      return paramString.toByteArray();
      if (!paramString.equals("DL")) {
        break;
      }
      paramString = new ByteArrayOutputStream();
      new n1(paramString).j(this);
    }
    return d();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof e)) {
      return false;
    }
    paramObject = (e)paramObject;
    return c().equals(((e)paramObject).c());
  }
  
  public int hashCode()
  {
    return c().hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */