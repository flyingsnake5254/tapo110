package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.d;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

public class b
  extends l
  implements d
{
  e c;
  q d;
  
  public b(a0 parama0)
  {
    this.c = parama0;
    this.d = new g1(false, 0, this.c);
  }
  
  public b(p paramp)
  {
    this.c = paramp;
    this.d = paramp.c();
  }
  
  public static b f(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof b)))
    {
      if ((paramObject instanceof a0)) {
        return new b(a0.f(paramObject));
      }
      if ((paramObject instanceof p)) {
        return new b((p)paramObject);
      }
      if ((paramObject instanceof x)) {
        return new b(a0.g((x)paramObject, false));
      }
      if ((paramObject instanceof r)) {
        return new b(p.f(paramObject));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in factory: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (b)paramObject;
  }
  
  public q c()
  {
    return this.d;
  }
  
  public e g()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */