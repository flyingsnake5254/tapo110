package org.bouncycastle.asn1.n2;

import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.e0;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.i0;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.o1;
import org.bouncycastle.asn1.q;

public class d
  extends l
  implements g
{
  private m c;
  private e d;
  private boolean f = true;
  
  public d(m paramm, e parame)
  {
    this.c = paramm;
    this.d = parame;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    e locale = this.d;
    if (locale != null) {
      localf.a(new i0(true, 0, locale));
    }
    if (this.f) {
      return new e0(localf);
    }
    return new o1(localf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n2\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */