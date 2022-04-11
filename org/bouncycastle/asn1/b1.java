package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class b1
  extends r
{
  private int d = -1;
  
  public b1() {}
  
  public b1(f paramf)
  {
    super(paramf);
  }
  
  public b1(e[] paramArrayOfe)
  {
    super(paramArrayOfe);
  }
  
  private int s()
    throws IOException
  {
    if (this.d < 0)
    {
      int i = 0;
      Enumeration localEnumeration = q();
      while (localEnumeration.hasMoreElements()) {
        i += ((e)localEnumeration.nextElement()).c().k().h();
      }
      this.d = i;
    }
    return this.d;
  }
  
  void g(p paramp)
    throws IOException
  {
    p localp = paramp.a();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\b1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */