package e.a.c.a;

import e.a.c.d.a.a;
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

public class c
  extends l
{
  private int c;
  private int d;
  private byte[] f;
  private byte[] q;
  private byte[] x;
  private byte[] y;
  private byte[] z;
  
  public c(int paramInt1, int paramInt2, b paramb, i parami, h paramh1, h paramh2, a parama)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.f = paramb.e();
    this.q = parami.h();
    this.x = parama.c();
    this.y = paramh1.a();
    this.z = paramh2.a();
  }
  
  private c(r paramr)
  {
    this.c = ((j)paramr.p(0)).p().intValue();
    this.d = ((j)paramr.p(1)).p().intValue();
    this.f = ((n)paramr.p(2)).o();
    this.q = ((n)paramr.p(3)).o();
    this.y = ((n)paramr.p(4)).o();
    this.z = ((n)paramr.p(5)).o();
    this.x = ((n)paramr.p(6)).o();
  }
  
  public static c h(Object paramObject)
  {
    if ((paramObject instanceof c)) {
      return (c)paramObject;
    }
    if (paramObject != null) {
      return new c(r.m(paramObject));
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
    localf.a(new x0(this.y));
    localf.a(new x0(this.z));
    localf.a(new x0(this.x));
    return new b1(localf);
  }
  
  public b f()
  {
    return new b(this.f);
  }
  
  public i g()
  {
    return new i(f(), this.q);
  }
  
  public int i()
  {
    return this.d;
  }
  
  public int j()
  {
    return this.c;
  }
  
  public h k()
  {
    return new h(this.y);
  }
  
  public h l()
  {
    return new h(this.z);
  }
  
  public a m()
  {
    return new a(this.x);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */