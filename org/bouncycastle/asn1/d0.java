package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.b;

public class d0
  implements o
{
  private v c;
  
  d0(v paramv)
  {
    this.c = paramv;
  }
  
  public InputStream a()
  {
    return new k0(this.c);
  }
  
  public q b()
    throws IOException
  {
    return new c0(b.b(a()));
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IOException converting stream to byte array: ");
      localStringBuilder.append(localIOException.getMessage());
      throw new ASN1ParsingException(localStringBuilder.toString(), localIOException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */