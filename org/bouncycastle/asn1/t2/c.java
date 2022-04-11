package org.bouncycastle.asn1.t2;

import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.d;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

public class c
  extends l
  implements d
{
  private static e c = org.bouncycastle.asn1.t2.f.b.M;
  private boolean d;
  private int f;
  private e q;
  private b[] x;
  
  public c(String paramString)
  {
    this(c, paramString);
  }
  
  private c(r paramr)
  {
    this(c, paramr);
  }
  
  public c(e parame, String paramString)
  {
    this(parame.b(paramString));
    this.q = parame;
  }
  
  private c(e parame, r paramr)
  {
    this.q = parame;
    this.x = new b[paramr.size()];
    parame = paramr.q();
    for (int i = 0; parame.hasMoreElements(); i++) {
      this.x[i] = b.g(parame.nextElement());
    }
  }
  
  public c(e parame, c paramc)
  {
    this.x = paramc.x;
    this.q = parame;
  }
  
  public c(e parame, b[] paramArrayOfb)
  {
    this.x = paramArrayOfb;
    this.q = parame;
  }
  
  public c(b[] paramArrayOfb)
  {
    this(c, paramArrayOfb);
  }
  
  public static c f(Object paramObject)
  {
    if ((paramObject instanceof c)) {
      return (c)paramObject;
    }
    if (paramObject != null) {
      return new c(r.m(paramObject));
    }
    return null;
  }
  
  public static c g(x paramx, boolean paramBoolean)
  {
    return f(r.n(paramx, true));
  }
  
  public static c h(e parame, Object paramObject)
  {
    if ((paramObject instanceof c)) {
      return new c(parame, (c)paramObject);
    }
    if (paramObject != null) {
      return new c(parame, r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    return new b1(this.x);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((!(paramObject instanceof c)) && (!(paramObject instanceof r))) {
      return false;
    }
    Object localObject = ((org.bouncycastle.asn1.e)paramObject).c();
    if (c().equals(localObject)) {
      return true;
    }
    try
    {
      e locale = this.q;
      localObject = new org/bouncycastle/asn1/t2/c;
      ((c)localObject).<init>(r.m(((org.bouncycastle.asn1.e)paramObject).c()));
      boolean bool = locale.a(this, (c)localObject);
      return bool;
    }
    catch (Exception paramObject) {}
    return false;
  }
  
  public int hashCode()
  {
    if (this.d) {
      return this.f;
    }
    this.d = true;
    int i = this.q.d(this);
    this.f = i;
    return i;
  }
  
  public b[] i()
  {
    b[] arrayOfb1 = this.x;
    int i = arrayOfb1.length;
    b[] arrayOfb2 = new b[i];
    System.arraycopy(arrayOfb1, 0, arrayOfb2, 0, i);
    return arrayOfb2;
  }
  
  public String toString()
  {
    return this.q.f(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\t2\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */