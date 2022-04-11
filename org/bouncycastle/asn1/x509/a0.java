package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x;

public class a0
  extends l
{
  p c;
  r d;
  u f;
  
  public a0(org.bouncycastle.asn1.r paramr)
  {
    if (paramr.size() <= 3)
    {
      int i;
      if (!(paramr.p(0) instanceof x))
      {
        this.c = p.f(paramr.p(0));
        i = 1;
      }
      else
      {
        i = 0;
      }
      while (i != paramr.size())
      {
        localObject = x.m(paramr.p(i));
        if (((x)localObject).p() == 0)
        {
          this.d = r.g((x)localObject, false);
        }
        else
        {
          if (((x)localObject).p() != 1) {
            break label101;
          }
          this.f = u.g((x)localObject, false);
        }
        i++;
        continue;
        label101:
        paramr = new StringBuilder();
        paramr.append("Bad tag number: ");
        paramr.append(((x)localObject).p());
        throw new IllegalArgumentException(paramr.toString());
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramr.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static a0 f(Object paramObject)
  {
    if ((paramObject instanceof a0)) {
      return (a0)paramObject;
    }
    if (paramObject != null) {
      return new a0(org.bouncycastle.asn1.r.m(paramObject));
    }
    return null;
  }
  
  public static a0 g(x paramx, boolean paramBoolean)
  {
    return f(org.bouncycastle.asn1.r.n(paramx, paramBoolean));
  }
  
  public q c()
  {
    f localf = new f();
    p localp = this.c;
    if (localp != null) {
      localf.a(localp);
    }
    if (this.d != null) {
      localf.a(new g1(false, 0, this.d));
    }
    if (this.f != null) {
      localf.a(new g1(false, 1, this.f));
    }
    return new b1(localf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */