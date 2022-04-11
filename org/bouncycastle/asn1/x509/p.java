package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;
import org.bouncycastle.util.i;

public class p
  extends l
{
  private final o[] c;
  
  private p(r paramr)
  {
    this.c = new o[paramr.size()];
    for (int i = 0; i != paramr.size(); i++) {
      this.c[i] = o.f(paramr.p(i));
    }
  }
  
  public p(o paramo)
  {
    this.c = new o[] { paramo };
  }
  
  public static p f(Object paramObject)
  {
    if ((paramObject instanceof p)) {
      return (p)paramObject;
    }
    if (paramObject != null) {
      return new p(r.m(paramObject));
    }
    return null;
  }
  
  public static p g(x paramx, boolean paramBoolean)
  {
    return f(r.n(paramx, paramBoolean));
  }
  
  public q c()
  {
    return new b1(this.c);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = i.d();
    localStringBuffer.append("GeneralNames:");
    localStringBuffer.append(str);
    for (int i = 0; i != this.c.length; i++)
    {
      localStringBuffer.append("    ");
      localStringBuffer.append(this.c[i]);
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */