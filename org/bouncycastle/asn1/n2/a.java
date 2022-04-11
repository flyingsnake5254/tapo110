package org.bouncycastle.asn1.n2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t;

public class a
  extends l
{
  private m c;
  private t d;
  
  public a(r paramr)
  {
    this.c = ((m)paramr.p(0));
    this.d = ((t)paramr.p(1));
  }
  
  public static a h(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof a)))
    {
      if ((paramObject instanceof r)) {
        return new a((r)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in factory: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (a)paramObject;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    return new b1(localf);
  }
  
  public m f()
  {
    return this.c;
  }
  
  public t g()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */