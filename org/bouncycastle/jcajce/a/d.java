package org.bouncycastle.jcajce.a;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;

public class d
{
  private static Map<m, String> a;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put(g.h0, "MD2");
    a.put(g.i0, "MD4");
    a.put(g.j0, "MD5");
    a.put(org.bouncycastle.asn1.m2.b.i, "SHA-1");
    a.put(org.bouncycastle.asn1.j2.b.f, "SHA-224");
    a.put(org.bouncycastle.asn1.j2.b.c, "SHA-256");
    a.put(org.bouncycastle.asn1.j2.b.d, "SHA-384");
    a.put(org.bouncycastle.asn1.j2.b.e, "SHA-512");
    a.put(org.bouncycastle.asn1.q2.b.c, "RIPEMD-128");
    a.put(org.bouncycastle.asn1.q2.b.b, "RIPEMD-160");
    a.put(org.bouncycastle.asn1.q2.b.d, "RIPEMD-128");
    a.put(org.bouncycastle.asn1.g2.a.d, "RIPEMD-128");
    a.put(org.bouncycastle.asn1.g2.a.c, "RIPEMD-160");
    a.put(org.bouncycastle.asn1.d2.a.b, "GOST3411");
    a.put(org.bouncycastle.asn1.f2.a.g, "Tiger");
    a.put(org.bouncycastle.asn1.g2.a.e, "Whirlpool");
    a.put(org.bouncycastle.asn1.j2.b.i, "SHA3-224");
    a.put(org.bouncycastle.asn1.j2.b.j, "SHA3-256");
    a.put(org.bouncycastle.asn1.j2.b.k, "SHA3-384");
    a.put(org.bouncycastle.asn1.j2.b.l, "SHA3-512");
    a.put(org.bouncycastle.asn1.e2.b.b0, "SM3");
  }
  
  public static String a(m paramm)
  {
    String str = (String)a.get(paramm);
    if (str != null) {
      return str;
    }
    return paramm.q();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */