package e.a.c.a;

import e.a.c.b.d.f.a;
import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x0;

public class h
  extends l
{
  private j c;
  private m d;
  private j f;
  private byte[][] q;
  private byte[][] x;
  private byte[] y;
  
  public h(int paramInt, short[][] paramArrayOfShort1, short[][] paramArrayOfShort2, short[] paramArrayOfShort)
  {
    this.c = new j(0L);
    this.f = new j(paramInt);
    this.q = a.c(paramArrayOfShort1);
    this.x = a.c(paramArrayOfShort2);
    this.y = a.a(paramArrayOfShort);
  }
  
  private h(r paramr)
  {
    if ((paramr.p(0) instanceof j)) {
      this.c = j.m(paramr.p(0));
    } else {
      this.d = m.r(paramr.p(0));
    }
    this.f = j.m(paramr.p(1));
    r localr = r.m(paramr.p(2));
    this.q = new byte[localr.size()][];
    for (int i = 0; i < localr.size(); i++) {
      this.q[i] = n.m(localr.p(i)).o();
    }
    localr = (r)paramr.p(3);
    this.x = new byte[localr.size()][];
    for (i = 0; i < localr.size(); i++) {
      this.x[i] = n.m(localr.p(i)).o();
    }
    this.y = n.m(((r)paramr.p(4)).p(0)).o();
  }
  
  public static h j(Object paramObject)
  {
    if ((paramObject instanceof h)) {
      return (h)paramObject;
    }
    if (paramObject != null) {
      return new h(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    Object localObject1 = this.c;
    if (localObject1 == null) {
      localObject1 = this.d;
    }
    localf.a((e)localObject1);
    localf.a(this.f);
    localObject1 = new f();
    int i = 0;
    for (int j = 0;; j++)
    {
      localObject2 = this.q;
      if (j >= localObject2.length) {
        break;
      }
      ((f)localObject1).a(new x0(localObject2[j]));
    }
    localf.a(new b1((f)localObject1));
    Object localObject2 = new f();
    for (j = i;; j++)
    {
      localObject1 = this.x;
      if (j >= localObject1.length) {
        break;
      }
      ((f)localObject2).a(new x0(localObject1[j]));
    }
    localf.a(new b1((f)localObject2));
    localObject1 = new f();
    ((f)localObject1).a(new x0(this.y));
    localf.a(new b1((f)localObject1));
    return new b1(localf);
  }
  
  public short[][] f()
  {
    return a.d(this.q);
  }
  
  public short[] g()
  {
    return a.b(this.y);
  }
  
  public short[][] h()
  {
    return a.d(this.x);
  }
  
  public int i()
  {
    return this.f.p().intValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */