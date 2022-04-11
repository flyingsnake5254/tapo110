package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.x;

public class q
  extends l
{
  r c;
  p d;
  u f;
  private int q = 1;
  
  private q(org.bouncycastle.asn1.r paramr)
  {
    if (paramr.size() <= 3)
    {
      for (int i = 0; i != paramr.size(); i++)
      {
        localObject = x.m(paramr.p(i));
        int j = ((x)localObject).p();
        if (j != 0)
        {
          if (j != 1)
          {
            if (j == 2) {
              this.f = u.g((x)localObject, false);
            } else {
              throw new IllegalArgumentException("unknown tag in Holder");
            }
          }
          else {
            this.d = p.g((x)localObject, false);
          }
        }
        else {
          this.c = r.g((x)localObject, false);
        }
      }
      this.q = 1;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramr.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private q(x paramx)
  {
    int i = paramx.p();
    if (i != 0)
    {
      if (i == 1) {
        this.d = p.g(paramx, true);
      } else {
        throw new IllegalArgumentException("unknown tag in Holder");
      }
    }
    else {
      this.c = r.g(paramx, true);
    }
    this.q = 0;
  }
  
  public static q f(Object paramObject)
  {
    if ((paramObject instanceof q)) {
      return (q)paramObject;
    }
    if ((paramObject instanceof x)) {
      return new q(x.m(paramObject));
    }
    if (paramObject != null) {
      return new q(org.bouncycastle.asn1.r.m(paramObject));
    }
    return null;
  }
  
  public org.bouncycastle.asn1.q c()
  {
    if (this.q == 1)
    {
      f localf = new f();
      if (this.c != null) {
        localf.a(new g1(false, 0, this.c));
      }
      if (this.d != null) {
        localf.a(new g1(false, 1, this.d));
      }
      if (this.f != null) {
        localf.a(new g1(false, 2, this.f));
      }
      return new b1(localf);
    }
    if (this.d != null) {
      return new g1(true, 1, this.d);
    }
    return new g1(true, 0, this.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */