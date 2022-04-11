package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.c;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class g
  extends l
{
  c c = c.p(false);
  j d = null;
  
  private g(r paramr)
  {
    if (paramr.size() == 0)
    {
      this.c = null;
      this.d = null;
    }
    else
    {
      if ((paramr.p(0) instanceof c))
      {
        this.c = c.n(paramr.p(0));
      }
      else
      {
        this.c = null;
        this.d = j.m(paramr.p(0));
      }
      if (paramr.size() > 1) {
        if (this.c != null) {
          this.d = j.m(paramr.p(1));
        } else {
          throw new IllegalArgumentException("wrong sequence in constructor");
        }
      }
    }
  }
  
  public static g f(Object paramObject)
  {
    if ((paramObject instanceof g)) {
      return (g)paramObject;
    }
    if ((paramObject instanceof c0)) {
      return f(c0.a((c0)paramObject));
    }
    if (paramObject != null) {
      return new g(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    Object localObject = this.c;
    if (localObject != null) {
      localf.a((e)localObject);
    }
    localObject = this.d;
    if (localObject != null) {
      localf.a((e)localObject);
    }
    return new b1(localf);
  }
  
  public BigInteger g()
  {
    j localj = this.d;
    if (localj != null) {
      return localj.p();
    }
    return null;
  }
  
  public boolean h()
  {
    c localc = this.c;
    boolean bool;
    if ((localc != null) && (localc.q())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    if (this.d == null)
    {
      if (this.c == null) {
        return "BasicConstraints: isCa(false)";
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("BasicConstraints: isCa(");
      localStringBuilder.append(h());
      localStringBuilder.append(")");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("BasicConstraints: isCa(");
      localStringBuilder.append(h());
      localStringBuilder.append("), pathLenConstraint = ");
      localStringBuilder.append(this.d.p());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */