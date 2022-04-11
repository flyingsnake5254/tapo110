package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class p1
  extends t
{
  private int f = -1;
  
  public p1() {}
  
  public p1(e parame)
  {
    super(parame);
  }
  
  public p1(f paramf)
  {
    super(paramf, false);
  }
  
  public p1(e[] paramArrayOfe)
  {
    super(paramArrayOfe, false);
  }
  
  private int v()
    throws IOException
  {
    if (this.f < 0)
    {
      int i = 0;
      Enumeration localEnumeration = r();
      while (localEnumeration.hasMoreElements()) {
        i += ((e)localEnumeration.nextElement()).c().l().h();
      }
      this.f = i;
    }
    return this.f;
  }
  
  void g(p paramp)
    throws IOException
  {
    p localp = paramp.b();
    int i = v();
    paramp.c(49);
    paramp.i(i);
    paramp = r();
    while (paramp.hasMoreElements()) {
      localp.j((e)paramp.nextElement());
    }
  }
  
  int h()
    throws IOException
  {
    int i = v();
    return y1.a(i) + 1 + i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\p1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */