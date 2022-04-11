package org.bouncycastle.asn1.r2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.util.a;

public class d
  extends l
{
  private static final byte[] c = { -87, -42, -21, 69, -15, 60, 112, -126, -128, -60, -106, 123, 35, 31, 94, -83, -10, 88, -21, -92, -64, 55, 41, 29, 56, -39, 107, -16, 37, -54, 78, 23, -8, -23, 114, 13, -58, 21, -76, 58, 40, -105, 95, 11, -63, -34, -93, 100, 56, -75, 100, -22, 44, 23, -97, -48, 18, 62, 109, -72, -6, -59, 121, 4 };
  private m d;
  private b f;
  private byte[] q = c;
  
  public d(m paramm)
  {
    this.d = paramm;
  }
  
  public d(b paramb)
  {
    this.f = paramb;
  }
  
  public static byte[] g()
  {
    return c;
  }
  
  public static d i(Object paramObject)
  {
    if ((paramObject instanceof d)) {
      return (d)paramObject;
    }
    if (paramObject != null)
    {
      Object localObject = r.m(paramObject);
      if ((((r)localObject).p(0) instanceof m)) {
        paramObject = new d(m.r(((r)localObject).p(0)));
      } else {
        paramObject = new d(b.j(((r)localObject).p(0)));
      }
      if (((r)localObject).size() == 2)
      {
        localObject = n.m(((r)localObject).p(1)).o();
        ((d)paramObject).q = ((byte[])localObject);
        if (localObject.length != c.length) {
          throw new IllegalArgumentException("object parse error");
        }
      }
      return (d)paramObject;
    }
    throw new IllegalArgumentException("object parse error");
  }
  
  public q c()
  {
    f localf = new f();
    Object localObject = this.d;
    if (localObject == null) {
      localObject = this.f;
    }
    localf.a((e)localObject);
    if (!a.c(this.q, c)) {
      localf.a(new x0(this.q));
    }
    return new b1(localf);
  }
  
  public byte[] f()
  {
    return this.q;
  }
  
  public b h()
  {
    return this.f;
  }
  
  public m j()
  {
    return this.d;
  }
  
  public boolean k()
  {
    boolean bool;
    if (this.d != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\r2\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */