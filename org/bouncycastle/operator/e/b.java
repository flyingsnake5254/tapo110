package org.bouncycastle.operator.e;

import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.spec.PSSParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.n2.k;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.jcajce.a.c;

class b
{
  private static final Map a;
  private static final Map b;
  private static final Map c;
  private static final Map d;
  private static final Map e;
  private c f;
  
  static
  {
    Object localObject1 = new HashMap();
    a = (Map)localObject1;
    Object localObject2 = new HashMap();
    b = (Map)localObject2;
    Object localObject3 = new HashMap();
    c = (Map)localObject3;
    HashMap localHashMap1 = new HashMap();
    d = localHashMap1;
    HashMap localHashMap2 = new HashMap();
    e = localHashMap2;
    ((Map)localObject1).put(new m("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
    ((Map)localObject1).put(g.O, "SHA224WITHRSA");
    ((Map)localObject1).put(g.L, "SHA256WITHRSA");
    ((Map)localObject1).put(g.M, "SHA384WITHRSA");
    ((Map)localObject1).put(g.N, "SHA512WITHRSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.d2.a.n, "GOST3411WITHGOST3410");
    ((Map)localObject1).put(org.bouncycastle.asn1.d2.a.o, "GOST3411WITHECGOST3410");
    ((Map)localObject1).put(org.bouncycastle.asn1.o2.a.i, "GOST3411-2012-256WITHECGOST3410-2012-256");
    ((Map)localObject1).put(org.bouncycastle.asn1.o2.a.j, "GOST3411-2012-512WITHECGOST3410-2012-512");
    ((Map)localObject1).put(org.bouncycastle.asn1.b2.a.d, "SHA1WITHPLAIN-ECDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.b2.a.e, "SHA224WITHPLAIN-ECDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.b2.a.f, "SHA256WITHPLAIN-ECDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.b2.a.g, "SHA384WITHPLAIN-ECDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.b2.a.h, "SHA512WITHPLAIN-ECDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.b2.a.i, "RIPEMD160WITHPLAIN-ECDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.eac.a.s, "SHA1WITHCVC-ECDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.eac.a.t, "SHA224WITHCVC-ECDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.eac.a.u, "SHA256WITHCVC-ECDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.eac.a.v, "SHA384WITHCVC-ECDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.eac.a.w, "SHA512WITHCVC-ECDSA");
    ((Map)localObject1).put(new m("1.2.840.113549.1.1.4"), "MD5WITHRSA");
    ((Map)localObject1).put(new m("1.2.840.113549.1.1.2"), "MD2WITHRSA");
    ((Map)localObject1).put(new m("1.2.840.10040.4.3"), "SHA1WITHDSA");
    ((Map)localObject1).put(p.z2, "SHA1WITHECDSA");
    ((Map)localObject1).put(p.D2, "SHA224WITHECDSA");
    ((Map)localObject1).put(p.E2, "SHA256WITHECDSA");
    ((Map)localObject1).put(p.F2, "SHA384WITHECDSA");
    ((Map)localObject1).put(p.G2, "SHA512WITHECDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.m2.b.k, "SHA1WITHRSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.m2.b.j, "SHA1WITHDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.j2.b.T, "SHA224WITHDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.j2.b.U, "SHA256WITHDSA");
    ((Map)localObject1).put(org.bouncycastle.asn1.m2.b.i, "SHA1");
    ((Map)localObject1).put(org.bouncycastle.asn1.j2.b.f, "SHA224");
    ((Map)localObject1).put(org.bouncycastle.asn1.j2.b.c, "SHA256");
    ((Map)localObject1).put(org.bouncycastle.asn1.j2.b.d, "SHA384");
    ((Map)localObject1).put(org.bouncycastle.asn1.j2.b.e, "SHA512");
    ((Map)localObject1).put(org.bouncycastle.asn1.q2.b.c, "RIPEMD128");
    ((Map)localObject1).put(org.bouncycastle.asn1.q2.b.b, "RIPEMD160");
    ((Map)localObject1).put(org.bouncycastle.asn1.q2.b.d, "RIPEMD256");
    ((Map)localObject2).put(g.B, "RSA/ECB/PKCS1Padding");
    ((Map)localObject2).put(org.bouncycastle.asn1.d2.a.m, "ECGOST3410");
    m localm1 = g.m2;
    ((Map)localObject3).put(localm1, "DESEDEWrap");
    ((Map)localObject3).put(g.n2, "RC2Wrap");
    m localm2 = org.bouncycastle.asn1.j2.b.x;
    ((Map)localObject3).put(localm2, "AESWrap");
    m localm3 = org.bouncycastle.asn1.j2.b.F;
    ((Map)localObject3).put(localm3, "AESWrap");
    m localm4 = org.bouncycastle.asn1.j2.b.N;
    ((Map)localObject3).put(localm4, "AESWrap");
    localObject2 = org.bouncycastle.asn1.k2.a.d;
    ((Map)localObject3).put(localObject2, "CamelliaWrap");
    m localm5 = org.bouncycastle.asn1.k2.a.e;
    ((Map)localObject3).put(localm5, "CamelliaWrap");
    m localm6 = org.bouncycastle.asn1.k2.a.f;
    ((Map)localObject3).put(localm6, "CamelliaWrap");
    m localm7 = org.bouncycastle.asn1.h2.a.d;
    ((Map)localObject3).put(localm7, "SEEDWrap");
    localObject1 = g.d0;
    ((Map)localObject3).put(localObject1, "DESede");
    localHashMap2.put(localm1, org.bouncycastle.util.d.b(192));
    localHashMap2.put(localm2, org.bouncycastle.util.d.b(128));
    localHashMap2.put(localm3, org.bouncycastle.util.d.b(192));
    localHashMap2.put(localm4, org.bouncycastle.util.d.b(256));
    localHashMap2.put(localObject2, org.bouncycastle.util.d.b(128));
    localHashMap2.put(localm5, org.bouncycastle.util.d.b(192));
    localHashMap2.put(localm6, org.bouncycastle.util.d.b(256));
    localHashMap2.put(localm7, org.bouncycastle.util.d.b(128));
    localHashMap2.put(localObject1, org.bouncycastle.util.d.b(192));
    localHashMap1.put(org.bouncycastle.asn1.j2.b.s, "AES");
    localObject3 = d;
    ((Map)localObject3).put(org.bouncycastle.asn1.j2.b.u, "AES");
    ((Map)localObject3).put(org.bouncycastle.asn1.j2.b.C, "AES");
    ((Map)localObject3).put(org.bouncycastle.asn1.j2.b.K, "AES");
    ((Map)localObject3).put(localObject1, "DESede");
    ((Map)localObject3).put(g.e0, "RC2");
  }
  
  b(c paramc)
  {
    this.f = paramc;
  }
  
  private static String c(m paramm)
  {
    String str = org.bouncycastle.jcajce.a.d.a(paramm);
    int i = str.indexOf('-');
    if ((i > 0) && (!str.startsWith("SHA3")))
    {
      paramm = new StringBuilder();
      paramm.append(str.substring(0, i));
      paramm.append(str.substring(i + 1));
      return paramm.toString();
    }
    return org.bouncycastle.jcajce.a.d.a(paramm);
  }
  
  private static String d(org.bouncycastle.asn1.x509.a parama)
  {
    Object localObject = parama.i();
    if ((localObject != null) && (!v0.c.equals(localObject)) && (parama.f().equals(g.K)))
    {
      parama = k.g(localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c(parama.f().f()));
      ((StringBuilder)localObject).append("WITHRSAANDMGF1");
      return ((StringBuilder)localObject).toString();
    }
    localObject = a;
    boolean bool = ((Map)localObject).containsKey(parama.f());
    parama = parama.f();
    if (bool) {
      return (String)((Map)localObject).get(parama);
    }
    return parama.q();
  }
  
  private boolean e(r paramr)
    throws GeneralSecurityException
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramr != null) {
      if (paramr.size() == 0)
      {
        bool2 = bool1;
      }
      else
      {
        paramr = k.g(paramr);
        if (!paramr.h().f().equals(g.I)) {
          return true;
        }
        if (!paramr.f().equals(org.bouncycastle.asn1.x509.a.g(paramr.h().i()))) {
          return true;
        }
        MessageDigest localMessageDigest = a(paramr.f());
        bool2 = bool1;
        if (paramr.i().intValue() != localMessageDigest.getDigestLength()) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  MessageDigest a(org.bouncycastle.asn1.x509.a parama)
    throws GeneralSecurityException
  {
    Map localMap;
    try
    {
      MessageDigest localMessageDigest = this.f.d(org.bouncycastle.jcajce.a.d.a(parama.f()));
      parama = localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localMap = a;
      if (localMap.get(parama.f()) == null) {
        break label67;
      }
    }
    parama = (String)localMap.get(parama.f());
    parama = this.f.d(parama);
    return parama;
    label67:
    throw localNoSuchAlgorithmException;
  }
  
  Signature b(org.bouncycastle.asn1.x509.a parama)
    throws GeneralSecurityException
  {
    try
    {
      localObject = this.f.b(d(parama));
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localObject = a;
      if (((Map)localObject).get(parama.f()) == null) {
        break label164;
      }
    }
    Object localObject = (String)((Map)localObject).get(parama.f());
    localObject = this.f.b((String)localObject);
    r localr;
    if (parama.f().equals(g.K))
    {
      localr = r.m(parama.i());
      if (e(localr)) {
        try
        {
          parama = this.f.e("PSS");
          parama.init(localr.d());
          ((Signature)localObject).setParameter(parama.getParameterSpec(PSSParameterSpec.class));
        }
        catch (IOException parama)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("unable to process PSS parameters: ");
          ((StringBuilder)localObject).append(parama.getMessage());
          throw new GeneralSecurityException(((StringBuilder)localObject).toString());
        }
      }
    }
    return (Signature)localObject;
    label164:
    throw localr;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\operator\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */