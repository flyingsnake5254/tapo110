package e.a.c.a;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x509.a;

public class k
  extends l
{
  private final j c;
  private final int d;
  private final int f;
  private final a q;
  
  public k(int paramInt1, int paramInt2, a parama)
  {
    this.c = new j(0L);
    this.d = paramInt1;
    this.f = paramInt2;
    this.q = parama;
  }
  
  private k(r paramr)
  {
    this.c = j.m(paramr.p(0));
    this.d = j.m(paramr.p(1)).p().intValue();
    this.f = j.m(paramr.p(2)).p().intValue();
    this.q = a.g(paramr.p(3));
  }
  
  public static k g(Object paramObject)
  {
    if ((paramObject instanceof k)) {
      return (k)paramObject;
    }
    if (paramObject != null) {
      return new k(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(new j(this.d));
    localf.a(new j(this.f));
    localf.a(this.q);
    return new b1(localf);
  }
  
  public int f()
  {
    return this.d;
  }
  
  public int h()
  {
    return this.f;
  }
  
  public a i()
  {
    return this.q;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */