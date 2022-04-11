package e.a.c.a;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x509.a;

public class i
  extends l
{
  private final j c;
  private final a d;
  
  private i(r paramr)
  {
    this.c = j.m(paramr.p(0));
    this.d = a.g(paramr.p(1));
  }
  
  public i(a parama)
  {
    this.c = new j(0L);
    this.d = parama;
  }
  
  public static final i f(Object paramObject)
  {
    if ((paramObject instanceof i)) {
      return (i)paramObject;
    }
    if (paramObject != null) {
      return new i(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    return new b1(localf);
  }
  
  public a g()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */