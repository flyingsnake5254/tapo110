package org.bouncycastle.asn1;

import java.io.FilterInputStream;
import java.io.IOException;

public abstract class q
  extends l
{
  public static q i(byte[] paramArrayOfByte)
    throws IOException
  {
    i locali = new i(paramArrayOfByte);
    try
    {
      paramArrayOfByte = locali.t();
      if (locali.available() == 0) {
        return paramArrayOfByte;
      }
      paramArrayOfByte = new java/io/IOException;
      paramArrayOfByte.<init>("Extra data detected in stream");
      throw paramArrayOfByte;
    }
    catch (ClassCastException paramArrayOfByte)
    {
      throw new IOException("cannot recognise object in stream");
    }
  }
  
  public q c()
  {
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((!(paramObject instanceof e)) || (!f(((e)paramObject).c()))) {
      bool = false;
    }
    return bool;
  }
  
  abstract boolean f(q paramq);
  
  abstract void g(p paramp)
    throws IOException;
  
  abstract int h()
    throws IOException;
  
  abstract boolean j();
  
  q k()
  {
    return this;
  }
  
  q l()
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */