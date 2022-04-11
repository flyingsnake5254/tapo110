package e.a.c.a;

import e.a.c.d.a.b;
import e.a.c.d.a.h;
import e.a.c.d.a.i;
import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x0;

public class a
  extends l
{
  private int c;
  private int d;
  private byte[] f;
  private byte[] q;
  private byte[] x;
  private org.bouncycastle.asn1.x509.a y;
  
  public a(int paramInt1, int paramInt2, b paramb, i parami, h paramh, org.bouncycastle.asn1.x509.a parama)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.f = paramb.e();
    this.q = parami.h();
    this.x = paramh.a();
    this.y = parama;
  }
  
  private a(r paramr)
  {
    this.c = ((j)paramr.p(0)).p().intValue();
    this.d = ((j)paramr.p(1)).p().intValue();
    this.f = ((n)paramr.p(2)).o();
    this.q = ((n)paramr.p(3)).o();
    this.x = ((n)paramr.p(4)).o();
    this.y = org.bouncycastle.asn1.x509.a.g(paramr.p(5));
  }
  
  public static a i(Object paramObject)
  {
    if ((paramObject instanceof a)) {
      return (a)paramObject;
    }
    if (paramObject != null) {
      return new a(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(new j(this.c));
    localf.a(new j(this.d));
    localf.a(new x0(this.f));
    localf.a(new x0(this.q));
    localf.a(new x0(this.x));
    localf.a(this.y);
    return new b1(localf);
  }
  
  public org.bouncycastle.asn1.x509.a f()
  {
    return this.y;
  }
  
  public b g()
  {
    return new b(this.f);
  }
  
  public i h()
  {
    return new i(g(), this.q);
  }
  
  public int j()
  {
    return this.d;
  }
  
  public int k()
  {
    return this.c;
  }
  
  public h l()
  {
    return new h(this.x);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */