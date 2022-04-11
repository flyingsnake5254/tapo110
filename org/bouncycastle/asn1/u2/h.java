package org.bouncycastle.asn1.u2;

import org.bouncycastle.asn1.d;
import org.bouncycastle.asn1.k;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;

public class h
  extends l
  implements d
{
  private q c = null;
  
  public h(k paramk)
  {
    this.c = paramk;
  }
  
  public h(m paramm)
  {
    this.c = paramm;
  }
  
  public h(q paramq)
  {
    this.c = paramq;
  }
  
  public h(j paramj)
  {
    this.c = paramj.c();
  }
  
  public static h f(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof h)))
    {
      if ((paramObject instanceof q)) {
        return new h((q)paramObject);
      }
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = new h(q.i((byte[])paramObject));
          return (h)paramObject;
        }
        catch (Exception localException)
        {
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("unable to parse encoded data: ");
          ((StringBuilder)paramObject).append(localException.getMessage());
          throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        }
      }
      throw new IllegalArgumentException("unknown object in getInstance()");
    }
    return (h)paramObject;
  }
  
  public q c()
  {
    return this.c;
  }
  
  public q g()
  {
    return this.c;
  }
  
  public boolean h()
  {
    return this.c instanceof k;
  }
  
  public boolean i()
  {
    return this.c instanceof m;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\u2\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */