package e.a.c.a;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x0;

public class b
  extends l
{
  private final int c;
  private final int d;
  private final e.a.c.d.a.a f;
  private final org.bouncycastle.asn1.x509.a q;
  
  public b(int paramInt1, int paramInt2, e.a.c.d.a.a parama, org.bouncycastle.asn1.x509.a parama1)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.f = new e.a.c.d.a.a(parama.c());
    this.q = parama1;
  }
  
  private b(r paramr)
  {
    this.c = ((j)paramr.p(0)).p().intValue();
    this.d = ((j)paramr.p(1)).p().intValue();
    this.f = new e.a.c.d.a.a(((n)paramr.p(2)).o());
    this.q = org.bouncycastle.asn1.x509.a.g(paramr.p(3));
  }
  
  public static b h(Object paramObject)
  {
    if ((paramObject instanceof b)) {
      return (b)paramObject;
    }
    if (paramObject != null) {
      return new b(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(new j(this.c));
    localf.a(new j(this.d));
    localf.a(new x0(this.f.c()));
    localf.a(this.q);
    return new b1(localf);
  }
  
  public org.bouncycastle.asn1.x509.a f()
  {
    return this.q;
  }
  
  public e.a.c.d.a.a g()
  {
    return this.f;
  }
  
  public int i()
  {
    return this.c;
  }
  
  public int j()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */