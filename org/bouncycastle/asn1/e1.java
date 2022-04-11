package org.bouncycastle.asn1;

import java.io.IOException;

public class e1
  implements u
{
  private v c;
  
  e1(v paramv)
  {
    this.c = paramv;
  }
  
  public q b()
    throws IOException
  {
    return new d1(this.c.d(), false);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\e1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */