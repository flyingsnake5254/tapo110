package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.h;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t2.c;
import org.bouncycastle.asn1.y;

public class x
  extends l
{
  j c;
  a d;
  c f;
  z q;
  z x;
  r y;
  m z;
  
  public x(r paramr)
  {
    if ((paramr.size() >= 3) && (paramr.size() <= 7))
    {
      int i = 0;
      if ((paramr.p(0) instanceof j))
      {
        this.c = j.m(paramr.p(0));
        i = 1;
      }
      else
      {
        this.c = null;
      }
      int j = i + 1;
      this.d = a.g(paramr.p(i));
      i = j + 1;
      this.f = c.f(paramr.p(j));
      j = i + 1;
      this.q = z.g(paramr.p(i));
      i = j;
      if (j < paramr.size()) {
        if ((!(paramr.p(j) instanceof y)) && (!(paramr.p(j) instanceof h)))
        {
          i = j;
          if (!(paramr.p(j) instanceof z)) {}
        }
        else
        {
          this.x = z.g(paramr.p(j));
          i = j + 1;
        }
      }
      j = i;
      if (i < paramr.size())
      {
        j = i;
        if (!(paramr.p(i) instanceof org.bouncycastle.asn1.x))
        {
          this.y = r.m(paramr.p(i));
          j = i + 1;
        }
      }
      if ((j < paramr.size()) && ((paramr.p(j) instanceof org.bouncycastle.asn1.x))) {
        this.z = m.k(r.n((org.bouncycastle.asn1.x)paramr.p(j), true));
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramr.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static x g(Object paramObject)
  {
    if ((paramObject instanceof x)) {
      return (x)paramObject;
    }
    if (paramObject != null) {
      return new x(r.m(paramObject));
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
    localf.a(this.d);
    localf.a(this.f);
    localf.a(this.q);
    localObject = this.x;
    if (localObject != null) {
      localf.a((e)localObject);
    }
    localObject = this.y;
    if (localObject != null) {
      localf.a((e)localObject);
    }
    if (this.z != null) {
      localf.a(new g1(0, this.z));
    }
    return new b1(localf);
  }
  
  public m f()
  {
    return this.z;
  }
  
  public c h()
  {
    return this.f;
  }
  
  public Enumeration i()
  {
    r localr = this.y;
    if (localr == null) {
      return new c(null);
    }
    return new d(localr.q());
  }
  
  public b[] j()
  {
    Object localObject = this.y;
    int i = 0;
    if (localObject == null) {
      return new b[0];
    }
    int j = ((r)localObject).size();
    localObject = new b[j];
    while (i < j)
    {
      localObject[i] = b.g(this.y.p(i));
      i++;
    }
    return (b[])localObject;
  }
  
  public a k()
  {
    return this.d;
  }
  
  public static class b
    extends l
  {
    r c;
    m d;
    
    private b(r paramr)
    {
      if ((paramr.size() >= 2) && (paramr.size() <= 3))
      {
        this.c = paramr;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Bad sequence size: ");
      localStringBuilder.append(paramr.size());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public static b g(Object paramObject)
    {
      if ((paramObject instanceof b)) {
        return (b)paramObject;
      }
      if (paramObject != null) {
        return new b(r.m(paramObject));
      }
      return null;
    }
    
    public q c()
    {
      return this.c;
    }
    
    public m f()
    {
      if ((this.d == null) && (this.c.size() == 3)) {
        this.d = m.k(this.c.p(2));
      }
      return this.d;
    }
    
    public j h()
    {
      return j.m(this.c.p(0));
    }
    
    public boolean i()
    {
      boolean bool;
      if (this.c.size() == 3) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  private class c
    implements Enumeration
  {
    private c() {}
    
    public boolean hasMoreElements()
    {
      return false;
    }
    
    public Object nextElement()
    {
      throw new NoSuchElementException("Empty Enumeration");
    }
  }
  
  private class d
    implements Enumeration
  {
    private final Enumeration a;
    
    d(Enumeration paramEnumeration)
    {
      this.a = paramEnumeration;
    }
    
    public boolean hasMoreElements()
    {
      return this.a.hasMoreElements();
    }
    
    public Object nextElement()
    {
      return x.b.g(this.a.nextElement());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */