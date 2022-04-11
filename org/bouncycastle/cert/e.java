package org.bouncycastle.cert;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.x509.b0;
import org.bouncycastle.asn1.x509.n;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.asn1.x509.z;
import org.bouncycastle.operator.a;

public class e
{
  private b0 a;
  private n b;
  
  public e(org.bouncycastle.asn1.t2.c paramc1, BigInteger paramBigInteger, Date paramDate1, Date paramDate2, org.bouncycastle.asn1.t2.c paramc2, w paramw)
  {
    this(paramc1, paramBigInteger, new z(paramDate1), new z(paramDate2), paramc2, paramw);
  }
  
  public e(org.bouncycastle.asn1.t2.c paramc1, BigInteger paramBigInteger, z paramz1, z paramz2, org.bouncycastle.asn1.t2.c paramc2, w paramw)
  {
    b0 localb0 = new b0();
    this.a = localb0;
    localb0.e(new j(paramBigInteger));
    this.a.d(paramc1);
    this.a.g(paramz1);
    this.a.b(paramz2);
    this.a.h(paramc2);
    this.a.i(paramw);
    this.b = new n();
  }
  
  public X509CertificateHolder a(a parama)
  {
    this.a.f(parama.a());
    if (!this.b.b()) {
      this.a.c(this.b.a());
    }
    return c.b(parama, this.a.a());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */