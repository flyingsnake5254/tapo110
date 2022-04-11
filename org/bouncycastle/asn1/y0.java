package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

public class y0
  implements o
{
  private r1 c;
  
  y0(r1 paramr1)
  {
    this.c = paramr1;
  }
  
  public InputStream a()
  {
    return this.c;
  }
  
  public q b()
    throws IOException
  {
    return new x0(this.c.e());
  }
  
  public q c()
  {
    try
    {
      localObject = b();
      return (q)localObject;
    }
    catch (IOException localIOException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("IOException converting stream to byte array: ");
      ((StringBuilder)localObject).append(localIOException.getMessage());
      throw new ASN1ParsingException(((StringBuilder)localObject).toString(), localIOException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\y0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */