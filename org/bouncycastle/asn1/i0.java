package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class i0
  extends x
{
  public i0(int paramInt, e parame)
  {
    super(true, paramInt, parame);
  }
  
  public i0(boolean paramBoolean, int paramInt, e parame)
  {
    super(paramBoolean, paramInt, parame);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.k(160, this.c);
    paramp.c(128);
    if (!this.d)
    {
      if (!this.f)
      {
        Object localObject = this.q;
        if ((localObject instanceof n))
        {
          if ((localObject instanceof c0)) {
            localObject = ((c0)localObject).s();
          } else {
            localObject = new c0(((n)localObject).o()).s();
          }
        }
        else if ((localObject instanceof r))
        {
          localObject = ((r)localObject).q();
        }
        else
        {
          if (!(localObject instanceof t)) {
            break label141;
          }
          localObject = ((t)localObject).r();
        }
        while (((Enumeration)localObject).hasMoreElements()) {
          paramp.j((e)((Enumeration)localObject).nextElement());
        }
        label141:
        paramp = new StringBuilder();
        paramp.append("not implemented: ");
        paramp.append(this.q.getClass().getName());
        throw new ASN1Exception(paramp.toString());
      }
      paramp.j(this.q);
    }
    paramp.c(0);
    paramp.c(0);
  }
  
  int h()
    throws IOException
  {
    if (!this.d)
    {
      int i = this.q.c().h();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\i0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */