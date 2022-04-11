package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class o1
  extends r
{
  private int d = -1;
  
  public o1() {}
  
  public o1(e parame)
  {
    super(parame);
  }
  
  public o1(f paramf)
  {
    super(paramf);
  }
  
  private int s()
    throws IOException
  {
    if (this.d < 0)
    {
      int i = 0;
      Enumeration localEnumeration = q();
      while (localEnumeration.hasMoreElements()) {
        i += ((e)localEnumeration.nextElement()).c().l().h();
      }
      this.d = i;
    }
    return this.d;
  }
  
  void g(p paramp)
    throws IOException
  {
    p localp = paramp.b();
    int i = s();
    paramp.c(48);
    paramp.i(i);
    paramp = q();
    while (paramp.hasMoreElements()) {
      localp.j((e)paramp.nextElement());
    }
  }
  
  int h()
    throws IOException
  {
    int i = s();
    return y1.a(i) + 1 + i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\o1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */