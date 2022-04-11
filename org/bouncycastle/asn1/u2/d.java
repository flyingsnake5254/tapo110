package org.bouncycastle.asn1.u2;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class d
  extends l
{
  private final j c;
  private final j d;
  private final j f;
  private final j q;
  private final f x;
  
  public d(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, f paramf)
  {
    if (paramBigInteger1 != null)
    {
      if (paramBigInteger2 != null)
      {
        if (paramBigInteger3 != null)
        {
          this.c = new j(paramBigInteger1);
          this.d = new j(paramBigInteger2);
          this.f = new j(paramBigInteger3);
          if (paramBigInteger4 != null) {
            paramBigInteger1 = new j(paramBigInteger4);
          } else {
            paramBigInteger1 = null;
          }
          this.q = paramBigInteger1;
          this.x = paramf;
          return;
        }
        throw new IllegalArgumentException("'q' cannot be null");
      }
      throw new IllegalArgumentException("'g' cannot be null");
    }
    throw new IllegalArgumentException("'p' cannot be null");
  }
  
  private d(r paramr)
  {
    if ((paramr.size() >= 3) && (paramr.size() <= 5))
    {
      localObject = paramr.q();
      this.c = j.m(((Enumeration)localObject).nextElement());
      this.d = j.m(((Enumeration)localObject).nextElement());
      this.f = j.m(((Enumeration)localObject).nextElement());
      paramr = i((Enumeration)localObject);
      if ((paramr != null) && ((paramr instanceof j)))
      {
        this.q = j.m(paramr);
        paramr = i((Enumeration)localObject);
      }
      else
      {
        this.q = null;
      }
      if (paramr != null) {
        this.x = f.f(paramr.c());
      } else {
        this.x = null;
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramr.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static d g(Object paramObject)
  {
    if ((paramObject instanceof d)) {
      return (d)paramObject;
    }
    if (paramObject != null) {
      return new d(r.m(paramObject));
    }
    return null;
  }
  
  private static e i(Enumeration paramEnumeration)
  {
    if (paramEnumeration.hasMoreElements()) {
      paramEnumeration = (e)paramEnumeration.nextElement();
    } else {
      paramEnumeration = null;
    }
    return paramEnumeration;
  }
  
  public q c()
  {
    org.bouncycastle.asn1.f localf = new org.bouncycastle.asn1.f();
    localf.a(this.c);
    localf.a(this.d);
    localf.a(this.f);
    Object localObject = this.q;
    if (localObject != null) {
      localf.a((e)localObject);
    }
    localObject = this.x;
    if (localObject != null) {
      localf.a((e)localObject);
    }
    return new b1(localf);
  }
  
  public BigInteger f()
  {
    return this.d.o();
  }
  
  public BigInteger h()
  {
    j localj = this.q;
    if (localj == null) {
      return null;
    }
    return localj.o();
  }
  
  public BigInteger j()
  {
    return this.c.o();
  }
  
  public BigInteger k()
  {
    return this.f.o();
  }
  
  public f l()
  {
    return this.x;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\u2\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */