package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.math.BigInteger;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.x509.e0;
import org.bouncycastle.util.c;

public class a
{
  public static final m[] a = { g.B, e0.m, g.H, g.K };
  
  static String a(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    return new c(org.bouncycastle.util.a.l(paramBigInteger1.toByteArray(), paramBigInteger2.toByteArray())).toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\rsa\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */