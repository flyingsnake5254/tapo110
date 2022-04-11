package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class d1
  extends t
{
  private int f = -1;
  
  public d1() {}
  
  public d1(e parame)
  {
    super(parame);
  }
  
  public d1(f paramf)
  {
    super(paramf, true);
  }
  
  d1(f paramf, boolean paramBoolean)
  {
    super(paramf, paramBoolean);
  }
  
  public d1(e[] paramArrayOfe)
  {
    super(paramArrayOfe, true);
  }
  
  private int v()
    throws IOException
  {
    if (this.f < 0)
    {
      int i = 0;
      Enumeration localEnumeration = r();
      while (localEnumeration.hasMoreElements()) {
        i += ((e)localEnumeration.nextElement()).c().k().h();
      }
      this.f = i;
    }
    return this.f;
  }
  
  void g(p paramp)
    throws IOException
  {
    p localp = paramp.a();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\d1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */