package org.bouncycastle.pqc.jcajce.provider.xmss;

import org.bouncycastle.asn1.j2.b;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.crypto.p.i;
import org.bouncycastle.crypto.p.k;

class a
{
  static org.bouncycastle.crypto.g a(m paramm)
  {
    if (paramm.equals(b.c)) {
      return new org.bouncycastle.crypto.p.g();
    }
    if (paramm.equals(b.e)) {
      return new i();
    }
    if (paramm.equals(b.m)) {
      return new k(128);
    }
    if (paramm.equals(b.n)) {
      return new k(256);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unrecognized digest OID: ");
    localStringBuilder.append(paramm);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static String b(m paramm)
  {
    if (paramm.equals(b.c)) {
      return "SHA256";
    }
    if (paramm.equals(b.e)) {
      return "SHA512";
    }
    if (paramm.equals(b.m)) {
      return "SHAKE128";
    }
    if (paramm.equals(b.n)) {
      return "SHAKE256";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unrecognized digest OID: ");
    localStringBuilder.append(paramm);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\xmss\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */