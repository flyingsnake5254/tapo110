package org.bouncycastle.asn1.l2;

import org.bouncycastle.asn1.g;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;

public class b
  extends l
{
  private g c;
  
  private b(g paramg)
  {
    this.c = paramg;
  }
  
  public static b f(Object paramObject)
  {
    if ((paramObject instanceof b)) {
      return (b)paramObject;
    }
    if (paramObject != null) {
      return new b(g.n(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\l2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */