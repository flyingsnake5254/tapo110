package e.a.c.a;

import e.a.c.d.a.a;
import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x0;

public class d
  extends l
{
  private final int c;
  private final int d;
  private final a f;
  
  public d(int paramInt1, int paramInt2, a parama)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.f = new a(parama);
  }
  
  private d(r paramr)
  {
    this.c = ((j)paramr.p(0)).p().intValue();
    this.d = ((j)paramr.p(1)).p().intValue();
    this.f = new a(((n)paramr.p(2)).o());
  }
  
  public static d g(Object paramObject)
  {
    if ((paramObject instanceof d)) {
      return (d)paramObject;
    }
    if (paramObject != null) {
      return new d(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(new j(this.c));
    localf.a(new j(this.d));
    localf.a(new x0(this.f.c()));
    return new b1(localf);
  }
  
  public a f()
  {
    return new a(this.f);
  }
  
  public int h()
  {
    return this.c;
  }
  
  public int i()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */