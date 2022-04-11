package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class n1
  extends p
{
  public n1(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public void j(e parame)
    throws IOException
  {
    if (parame != null)
    {
      parame.c().l().g(this);
      return;
    }
    throw new IOException("null object detected");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */