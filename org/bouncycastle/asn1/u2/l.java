package org.bouncycastle.asn1.u2;

import e.a.b.a.d;
import e.a.b.a.h;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.util.a;

public class l
  extends org.bouncycastle.asn1.l
{
  private final n c;
  private d d;
  private h f;
  
  public l(d paramd, n paramn)
  {
    this(paramd, paramn.o());
  }
  
  public l(d paramd, byte[] paramArrayOfByte)
  {
    this.d = paramd;
    this.c = new x0(a.g(paramArrayOfByte));
  }
  
  public l(h paramh)
  {
    this(paramh, false);
  }
  
  public l(h paramh, boolean paramBoolean)
  {
    this.f = paramh.A();
    this.c = new x0(paramh.l(paramBoolean));
  }
  
  public q c()
  {
    return this.c;
  }
  
  public h f()
  {
    try
    {
      if (this.f == null) {
        this.f = this.d.k(this.c.o()).A();
      }
      h localh = this.f;
      return localh;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\u2\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */