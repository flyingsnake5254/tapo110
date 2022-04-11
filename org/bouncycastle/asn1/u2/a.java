package org.bouncycastle.asn1.u2;

import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class a
  extends l
{
  private j c;
  private j d;
  private j f;
  private j q;
  private c x;
  
  private a(r paramr)
  {
    if ((paramr.size() >= 3) && (paramr.size() <= 5))
    {
      Enumeration localEnumeration = paramr.q();
      this.c = j.m(localEnumeration.nextElement());
      this.d = j.m(localEnumeration.nextElement());
      this.f = j.m(localEnumeration.nextElement());
      localObject = h(localEnumeration);
      paramr = (r)localObject;
      if (localObject != null)
      {
        paramr = (r)localObject;
        if ((localObject instanceof j))
        {
          this.q = j.m(localObject);
          paramr = h(localEnumeration);
        }
      }
      if (paramr != null) {
        this.x = c.f(paramr.c());
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramr.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static a g(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof a)))
    {
      if ((paramObject instanceof r)) {
        return new a((r)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid DHDomainParameters: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (a)paramObject;
  }
  
  private static e h(Enumeration paramEnumeration)
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
    f localf = new f();
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
  
  public j f()
  {
    return this.d;
  }
  
  public j i()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\u2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */