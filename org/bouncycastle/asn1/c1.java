package org.bouncycastle.asn1;

import java.io.IOException;

public class c1
  implements s
{
  private v c;
  
  c1(v paramv)
  {
    this.c = paramv;
  }
  
  public q b()
    throws IOException
  {
    return new b1(this.c.d());
  }
  
  public q c()
  {
    try
    {
      q localq = b();
      return localq;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException.getMessage());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\c1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */