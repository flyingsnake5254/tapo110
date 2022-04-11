package org.bouncycastle.asn1;

import java.io.IOException;

public class j0
  implements e, s1
{
  private boolean c;
  private int d;
  private v f;
  
  j0(boolean paramBoolean, int paramInt, v paramv)
  {
    this.c = paramBoolean;
    this.d = paramInt;
    this.f = paramv;
  }
  
  public q b()
    throws IOException
  {
    return this.f.c(this.c, this.d);
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
      throw new ASN1ParsingException(localIOException.getMessage());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\j0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */