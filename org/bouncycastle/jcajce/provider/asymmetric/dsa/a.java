package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.m2.b;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.crypto.w.j;
import org.bouncycastle.util.c;

public class a
{
  public static final m[] a = { p.l3, b.j, p.m3 };
  
  static String a(BigInteger paramBigInteger, DSAParams paramDSAParams)
  {
    return new c(org.bouncycastle.util.a.n(paramBigInteger.toByteArray(), paramDSAParams.getP().toByteArray(), paramDSAParams.getQ().toByteArray(), paramDSAParams.getG().toByteArray())).toString();
  }
  
  static j b(DSAParams paramDSAParams)
  {
    if (paramDSAParams != null) {
      return new j(paramDSAParams.getP(), paramDSAParams.getQ(), paramDSAParams.getG());
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dsa\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */