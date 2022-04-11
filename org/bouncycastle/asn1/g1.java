package org.bouncycastle.asn1;

import java.io.IOException;

public class g1
  extends x
{
  private static final byte[] x = new byte[0];
  
  public g1(int paramInt, e parame)
  {
    super(true, paramInt, parame);
  }
  
  public g1(boolean paramBoolean, int paramInt, e parame)
  {
    super(paramBoolean, paramInt, parame);
  }
  
  void g(p paramp)
    throws IOException
  {
    boolean bool = this.d;
    int i = 160;
    if (!bool)
    {
      q localq = this.q.c().k();
      if (this.f)
      {
        paramp.k(160, this.c);
        paramp.i(localq.h());
        paramp.j(localq);
      }
      else
      {
        if (!localq.j()) {
          i = 128;
        }
        paramp.k(i, this.c);
        paramp.h(localq);
      }
    }
    else
    {
      paramp.f(160, this.c, x);
    }
  }
  
  int h()
    throws IOException
  {
    if (!this.d)
    {
      int i = this.q.c().k().h();
      if (this.f) {}
      for (int j = y1.b(this.c) + y1.a(i);; j = y1.b(this.c))
      {
        return j + i;
        i--;
      }
    }
    return y1.b(this.c) + 1;
  }
  
  boolean j()
  {
    if (!this.d)
    {
      if (this.f) {
        return true;
      }
      return this.q.c().k().j();
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\g1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */