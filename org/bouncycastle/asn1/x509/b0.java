package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.t2.c;

public class b0
{
  g1 a = new g1(true, 0, new j(2L));
  j b;
  a c;
  c d;
  z e;
  z f;
  c g;
  w h;
  m i;
  private boolean j;
  private n0 k;
  private n0 l;
  
  public y a()
  {
    if ((this.b != null) && (this.c != null) && (this.d != null) && (this.e != null) && (this.f != null) && ((this.g != null) || (this.j)) && (this.h != null))
    {
      f localf = new f();
      localf.a(this.a);
      localf.a(this.b);
      localf.a(this.c);
      localf.a(this.d);
      Object localObject = new f();
      ((f)localObject).a(this.e);
      ((f)localObject).a(this.f);
      localf.a(new b1((f)localObject));
      localObject = this.g;
      if (localObject == null) {
        localObject = new b1();
      }
      localf.a((e)localObject);
      localf.a(this.h);
      if (this.k != null) {
        localf.a(new g1(false, 1, this.k));
      }
      if (this.l != null) {
        localf.a(new g1(false, 2, this.l));
      }
      if (this.i != null) {
        localf.a(new g1(true, 3, this.i));
      }
      return y.h(new b1(localf));
    }
    throw new IllegalStateException("not all mandatory fields set in V3 TBScertificate generator");
  }
  
  public void b(z paramz)
  {
    this.f = paramz;
  }
  
  public void c(m paramm)
  {
    this.i = paramm;
    if (paramm != null)
    {
      paramm = paramm.g(l.x);
      if ((paramm != null) && (paramm.k())) {
        this.j = true;
      }
    }
  }
  
  public void d(c paramc)
  {
    this.d = paramc;
  }
  
  public void e(j paramj)
  {
    this.b = paramj;
  }
  
  public void f(a parama)
  {
    this.c = parama;
  }
  
  public void g(z paramz)
  {
    this.e = paramz;
  }
  
  public void h(c paramc)
  {
    this.g = paramc;
  }
  
  public void i(w paramw)
  {
    this.h = paramw;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */