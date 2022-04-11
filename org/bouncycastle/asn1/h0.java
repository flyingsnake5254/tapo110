package org.bouncycastle.asn1;

import java.io.IOException;

public class h0
  implements u
{
  private v c;
  
  h0(v paramv)
  {
    this.c = paramv;
  }
  
  public q b()
    throws IOException
  {
    return new g0(this.c.d());
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
      throw new ASN1ParsingException(localIOException.getMessage(), localIOException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */