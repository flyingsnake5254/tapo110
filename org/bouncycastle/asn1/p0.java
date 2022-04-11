package org.bouncycastle.asn1;

import java.io.IOException;

public class p0
  implements e, s1
{
  private v c;
  
  public p0(v paramv)
  {
    this.c = paramv;
  }
  
  public q b()
    throws IOException
  {
    try
    {
      o0 localo0 = new o0(this.c.d());
      return localo0;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ASN1Exception(localIllegalArgumentException.getMessage(), localIllegalArgumentException);
    }
  }
  
  public q c()
  {
    try
    {
      q localq = b();
      return localq;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ASN1ParsingException("unable to get DER object", localIllegalArgumentException);
    }
    catch (IOException localIOException)
    {
      throw new ASN1ParsingException("unable to get DER object", localIOException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\p0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */