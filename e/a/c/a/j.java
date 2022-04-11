package e.a.c.a;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x509.a;

public class j
  extends l
{
  private final org.bouncycastle.asn1.j c;
  private final int d;
  private final a f;
  
  public j(int paramInt, a parama)
  {
    this.c = new org.bouncycastle.asn1.j(0L);
    this.d = paramInt;
    this.f = parama;
  }
  
  private j(r paramr)
  {
    this.c = org.bouncycastle.asn1.j.m(paramr.p(0));
    this.d = org.bouncycastle.asn1.j.m(paramr.p(1)).p().intValue();
    this.f = a.g(paramr.p(2));
  }
  
  public static j g(Object paramObject)
  {
    if ((paramObject instanceof j)) {
      return (j)paramObject;
    }
    if (paramObject != null) {
      return new j(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(new org.bouncycastle.asn1.j(this.d));
    localf.a(this.f);
    return new b1(localf);
  }
  
  public int f()
  {
    return this.d;
  }
  
  public a h()
  {
    return this.f;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */