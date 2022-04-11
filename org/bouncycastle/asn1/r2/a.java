package org.bouncycastle.asn1.r2;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class a
  extends l
{
  private int c;
  private int d;
  private int f;
  private int q;
  
  private a(r paramr)
  {
    this.c = j.m(paramr.p(0)).o().intValue();
    if ((paramr.p(1) instanceof j))
    {
      this.d = ((j)paramr.p(1)).o().intValue();
    }
    else
    {
      if (!(paramr.p(1) instanceof r)) {
        break label129;
      }
      paramr = r.m(paramr.p(1));
      this.d = j.m(paramr.p(0)).o().intValue();
      this.f = j.m(paramr.p(1)).o().intValue();
      this.q = j.m(paramr.p(2)).o().intValue();
    }
    return;
    label129:
    throw new IllegalArgumentException("object parse error");
  }
  
  public static a f(Object paramObject)
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
    f localf1 = new f();
    localf1.a(new j(this.c));
    if (this.f == 0)
    {
      localf1.a(new j(this.d));
    }
    else
    {
      f localf2 = new f();
      localf2.a(new j(this.d));
      localf2.a(new j(this.f));
      localf2.a(new j(this.q));
      localf1.a(new b1(localf2));
    }
    return new b1(localf1);
  }
  
  public int g()
  {
    return this.d;
  }
  
  public int h()
  {
    return this.f;
  }
  
  public int i()
  {
    return this.q;
  }
  
  public int j()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\r2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */