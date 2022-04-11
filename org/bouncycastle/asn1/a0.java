package org.bouncycastle.asn1;

import java.io.IOException;

public class a0
  implements e, s1
{
  private final int c;
  private final v d;
  
  a0(int paramInt, v paramv)
  {
    this.c = paramInt;
    this.d = paramv;
  }
  
  public q b()
    throws IOException
  {
    return new z(this.c, this.d.d());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */