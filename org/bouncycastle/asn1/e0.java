package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class e0
  extends r
{
  public e0() {}
  
  public e0(e parame)
  {
    super(parame);
  }
  
  public e0(f paramf)
  {
    super(paramf);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.c(48);
    paramp.c(128);
    Enumeration localEnumeration = q();
    while (localEnumeration.hasMoreElements()) {
      paramp.j((e)localEnumeration.nextElement());
    }
    paramp.c(0);
    paramp.c(0);
  }
  
  int h()
    throws IOException
  {
    Enumeration localEnumeration = q();
    int i = 0;
    while (localEnumeration.hasMoreElements()) {
      i += ((e)localEnumeration.nextElement()).c().h();
    }
    return i + 2 + 2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */