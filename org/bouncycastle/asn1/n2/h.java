package org.bouncycastle.asn1.n2;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t;
import org.bouncycastle.asn1.x;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.asn1.x509.a;

public class h
  extends l
{
  private n c;
  private a d;
  private t f;
  
  public h(r paramr)
  {
    paramr = paramr.q();
    if (((j)paramr.nextElement()).p().intValue() == 0)
    {
      this.d = a.g(paramr.nextElement());
      this.c = n.m(paramr.nextElement());
      if (paramr.hasMoreElements()) {
        this.f = t.o((x)paramr.nextElement(), false);
      }
      return;
    }
    throw new IllegalArgumentException("wrong version for private key info");
  }
  
  public h(a parama, e parame)
    throws IOException
  {
    this(parama, parame, null);
  }
  
  public h(a parama, e parame, t paramt)
    throws IOException
  {
    this.c = new x0(parame.c().e("DER"));
    this.d = parama;
    this.f = paramt;
  }
  
  public static h g(Object paramObject)
  {
    if ((paramObject instanceof h)) {
      return (h)paramObject;
    }
    if (paramObject != null) {
      return new h(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(new j(0L));
    localf.a(this.d);
    localf.a(this.c);
    if (this.f != null) {
      localf.a(new g1(false, 0, this.f));
    }
    return new b1(localf);
  }
  
  public a f()
  {
    return this.d;
  }
  
  public a h()
  {
    return this.d;
  }
  
  public e i()
    throws IOException
  {
    return q.i(this.c.o());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n2\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */