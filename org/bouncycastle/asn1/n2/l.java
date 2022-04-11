package org.bouncycastle.asn1.n2;

import org.bouncycastle.asn1.e0;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.t;

public class l
  extends org.bouncycastle.asn1.l
  implements g
{
  private j c;
  private t d;
  private d f;
  private t q;
  private t x;
  private t y;
  
  public l(j paramj, t paramt1, d paramd, t paramt2, t paramt3, t paramt4)
  {
    this.c = paramj;
    this.d = paramt1;
    this.f = paramd;
    this.q = paramt2;
    this.x = paramt3;
    this.y = paramt4;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    localf.a(this.f);
    if (this.q != null) {
      localf.a(new g1(false, 0, this.q));
    }
    if (this.x != null) {
      localf.a(new g1(false, 1, this.x));
    }
    localf.a(this.y);
    return new e0(localf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n2\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */