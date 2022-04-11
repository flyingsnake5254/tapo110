package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class g0
  extends t
{
  public g0() {}
  
  public g0(e parame)
  {
    super(parame);
  }
  
  public g0(f paramf)
  {
    super(paramf, false);
  }
  
  public g0(e[] paramArrayOfe)
  {
    super(paramArrayOfe, false);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.c(49);
    paramp.c(128);
    Enumeration localEnumeration = r();
    while (localEnumeration.hasMoreElements()) {
      paramp.j((e)localEnumeration.nextElement());
    }
    paramp.c(0);
    paramp.c(0);
  }
  
  int h()
    throws IOException
  {
    Enumeration localEnumeration = r();
    int i = 0;
    while (localEnumeration.hasMoreElements()) {
      i += ((e)localEnumeration.nextElement()).c().h();
    }
    return i + 2 + 2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */