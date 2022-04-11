package org.bouncycastle.operator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.n2.k;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.util.i;

public class d
{
  private static Map a = new HashMap();
  private static Set b = new HashSet();
  private static Map c = new HashMap();
  private static Set d = new HashSet();
  private static Map e = new HashMap();
  private static final m f = g.B;
  private static final m g;
  private static final m h;
  private static final m i;
  private static final m j;
  private static final m k;
  private static final m l;
  private static final m m;
  
  static
  {
    Object localObject1 = p.m3;
    g = (m)localObject1;
    Object localObject2 = p.z2;
    h = (m)localObject2;
    Object localObject3 = g.K;
    i = (m)localObject3;
    j = org.bouncycastle.asn1.d2.a.l;
    k = org.bouncycastle.asn1.d2.a.m;
    l = org.bouncycastle.asn1.o2.a.g;
    m = org.bouncycastle.asn1.o2.a.h;
    Object localObject4 = a;
    Object localObject5 = g.C;
    ((Map)localObject4).put("MD2WITHRSAENCRYPTION", localObject5);
    a.put("MD2WITHRSA", localObject5);
    localObject4 = a;
    localObject5 = g.E;
    ((Map)localObject4).put("MD5WITHRSAENCRYPTION", localObject5);
    a.put("MD5WITHRSA", localObject5);
    localObject4 = a;
    localObject5 = g.F;
    ((Map)localObject4).put("SHA1WITHRSAENCRYPTION", localObject5);
    a.put("SHA1WITHRSA", localObject5);
    localObject5 = a;
    localObject4 = g.O;
    ((Map)localObject5).put("SHA224WITHRSAENCRYPTION", localObject4);
    a.put("SHA224WITHRSA", localObject4);
    localObject4 = a;
    localObject5 = g.L;
    ((Map)localObject4).put("SHA256WITHRSAENCRYPTION", localObject5);
    a.put("SHA256WITHRSA", localObject5);
    localObject4 = a;
    localObject5 = g.M;
    ((Map)localObject4).put("SHA384WITHRSAENCRYPTION", localObject5);
    a.put("SHA384WITHRSA", localObject5);
    localObject4 = a;
    localObject5 = g.N;
    ((Map)localObject4).put("SHA512WITHRSAENCRYPTION", localObject5);
    a.put("SHA512WITHRSA", localObject5);
    a.put("SHA1WITHRSAANDMGF1", localObject3);
    a.put("SHA224WITHRSAANDMGF1", localObject3);
    a.put("SHA256WITHRSAANDMGF1", localObject3);
    a.put("SHA384WITHRSAANDMGF1", localObject3);
    a.put("SHA512WITHRSAANDMGF1", localObject3);
    a.put("SHA3-224WITHRSAANDMGF1", localObject3);
    a.put("SHA3-256WITHRSAANDMGF1", localObject3);
    a.put("SHA3-384WITHRSAANDMGF1", localObject3);
    a.put("SHA3-512WITHRSAANDMGF1", localObject3);
    localObject5 = a;
    localObject3 = org.bouncycastle.asn1.q2.b.f;
    ((Map)localObject5).put("RIPEMD160WITHRSAENCRYPTION", localObject3);
    a.put("RIPEMD160WITHRSA", localObject3);
    localObject3 = a;
    localObject5 = org.bouncycastle.asn1.q2.b.g;
    ((Map)localObject3).put("RIPEMD128WITHRSAENCRYPTION", localObject5);
    a.put("RIPEMD128WITHRSA", localObject5);
    localObject3 = a;
    localObject5 = org.bouncycastle.asn1.q2.b.h;
    ((Map)localObject3).put("RIPEMD256WITHRSAENCRYPTION", localObject5);
    a.put("RIPEMD256WITHRSA", localObject5);
    a.put("SHA1WITHDSA", localObject1);
    a.put("DSAWITHSHA1", localObject1);
    localObject1 = a;
    m localm1 = org.bouncycastle.asn1.j2.b.T;
    ((Map)localObject1).put("SHA224WITHDSA", localm1);
    localObject1 = a;
    Object localObject6 = org.bouncycastle.asn1.j2.b.U;
    ((Map)localObject1).put("SHA256WITHDSA", localObject6);
    localObject1 = a;
    Object localObject7 = org.bouncycastle.asn1.j2.b.V;
    ((Map)localObject1).put("SHA384WITHDSA", localObject7);
    localObject1 = a;
    Object localObject8 = org.bouncycastle.asn1.j2.b.W;
    ((Map)localObject1).put("SHA512WITHDSA", localObject8);
    localObject1 = a;
    m localm2 = org.bouncycastle.asn1.j2.b.X;
    ((Map)localObject1).put("SHA3-224WITHDSA", localm2);
    localObject1 = a;
    Object localObject9 = org.bouncycastle.asn1.j2.b.Y;
    ((Map)localObject1).put("SHA3-256WITHDSA", localObject9);
    localObject1 = a;
    m localm3 = org.bouncycastle.asn1.j2.b.Z;
    ((Map)localObject1).put("SHA3-384WITHDSA", localm3);
    localObject1 = a;
    Object localObject10 = org.bouncycastle.asn1.j2.b.a0;
    ((Map)localObject1).put("SHA3-512WITHDSA", localObject10);
    localObject1 = a;
    Object localObject11 = org.bouncycastle.asn1.j2.b.b0;
    ((Map)localObject1).put("SHA3-224WITHECDSA", localObject11);
    localObject1 = a;
    Object localObject12 = org.bouncycastle.asn1.j2.b.c0;
    ((Map)localObject1).put("SHA3-256WITHECDSA", localObject12);
    localObject1 = a;
    Object localObject13 = org.bouncycastle.asn1.j2.b.d0;
    ((Map)localObject1).put("SHA3-384WITHECDSA", localObject13);
    localObject1 = a;
    Object localObject14 = org.bouncycastle.asn1.j2.b.e0;
    ((Map)localObject1).put("SHA3-512WITHECDSA", localObject14);
    localObject3 = a;
    localObject1 = org.bouncycastle.asn1.j2.b.f0;
    ((Map)localObject3).put("SHA3-224WITHRSA", localObject1);
    localObject5 = a;
    localObject3 = org.bouncycastle.asn1.j2.b.g0;
    ((Map)localObject5).put("SHA3-256WITHRSA", localObject3);
    localObject4 = a;
    localObject5 = org.bouncycastle.asn1.j2.b.h0;
    ((Map)localObject4).put("SHA3-384WITHRSA", localObject5);
    Object localObject15 = a;
    localObject4 = org.bouncycastle.asn1.j2.b.i0;
    ((Map)localObject15).put("SHA3-512WITHRSA", localObject4);
    a.put("SHA3-224WITHRSAENCRYPTION", localObject1);
    a.put("SHA3-256WITHRSAENCRYPTION", localObject3);
    a.put("SHA3-384WITHRSAENCRYPTION", localObject5);
    a.put("SHA3-512WITHRSAENCRYPTION", localObject4);
    a.put("SHA1WITHECDSA", localObject2);
    a.put("ECDSAWITHSHA1", localObject2);
    localObject15 = a;
    localObject2 = p.D2;
    ((Map)localObject15).put("SHA224WITHECDSA", localObject2);
    Object localObject16 = a;
    localObject15 = p.E2;
    ((Map)localObject16).put("SHA256WITHECDSA", localObject15);
    Object localObject17 = a;
    localObject16 = p.F2;
    ((Map)localObject17).put("SHA384WITHECDSA", localObject16);
    Object localObject18 = a;
    localObject17 = p.G2;
    ((Map)localObject18).put("SHA512WITHECDSA", localObject17);
    Object localObject19 = a;
    localObject18 = org.bouncycastle.asn1.d2.a.n;
    ((Map)localObject19).put("GOST3411WITHGOST3410", localObject18);
    a.put("GOST3411WITHGOST3410-94", localObject18);
    Object localObject20 = a;
    localObject19 = org.bouncycastle.asn1.d2.a.o;
    ((Map)localObject20).put("GOST3411WITHECGOST3410", localObject19);
    a.put("GOST3411WITHECGOST3410-2001", localObject19);
    a.put("GOST3411WITHGOST3410-2001", localObject19);
    Object localObject21 = a;
    localObject20 = org.bouncycastle.asn1.o2.a.i;
    ((Map)localObject21).put("GOST3411WITHECGOST3410-2012-256", localObject20);
    Object localObject22 = a;
    localObject21 = org.bouncycastle.asn1.o2.a.j;
    ((Map)localObject22).put("GOST3411WITHECGOST3410-2012-512", localObject21);
    a.put("GOST3411WITHGOST3410-2012-256", localObject20);
    a.put("GOST3411WITHGOST3410-2012-512", localObject21);
    a.put("GOST3411-2012-256WITHECGOST3410-2012-256", localObject20);
    a.put("GOST3411-2012-512WITHECGOST3410-2012-512", localObject21);
    a.put("GOST3411-2012-256WITHGOST3410-2012-256", localObject20);
    a.put("GOST3411-2012-512WITHGOST3410-2012-512", localObject21);
    a.put("SHA1WITHPLAIN-ECDSA", org.bouncycastle.asn1.b2.a.d);
    a.put("SHA224WITHPLAIN-ECDSA", org.bouncycastle.asn1.b2.a.e);
    a.put("SHA256WITHPLAIN-ECDSA", org.bouncycastle.asn1.b2.a.f);
    a.put("SHA384WITHPLAIN-ECDSA", org.bouncycastle.asn1.b2.a.g);
    a.put("SHA512WITHPLAIN-ECDSA", org.bouncycastle.asn1.b2.a.h);
    a.put("RIPEMD160WITHPLAIN-ECDSA", org.bouncycastle.asn1.b2.a.i);
    a.put("SHA1WITHCVC-ECDSA", org.bouncycastle.asn1.eac.a.s);
    a.put("SHA224WITHCVC-ECDSA", org.bouncycastle.asn1.eac.a.t);
    a.put("SHA256WITHCVC-ECDSA", org.bouncycastle.asn1.eac.a.u);
    a.put("SHA384WITHCVC-ECDSA", org.bouncycastle.asn1.eac.a.v);
    a.put("SHA512WITHCVC-ECDSA", org.bouncycastle.asn1.eac.a.w);
    Object localObject23 = a;
    localObject22 = org.bouncycastle.asn1.a2.a.v;
    ((Map)localObject23).put("SHA3-512WITHSPHINCS256", localObject22);
    Object localObject24 = a;
    localObject23 = org.bouncycastle.asn1.a2.a.u;
    ((Map)localObject24).put("SHA512WITHSPHINCS256", localObject23);
    Object localObject25 = a;
    localObject24 = org.bouncycastle.asn1.e2.b.d0;
    ((Map)localObject25).put("SM3WITHSM2", localObject24);
    Object localObject26 = a;
    localObject25 = org.bouncycastle.asn1.a2.a.x;
    ((Map)localObject26).put("SHA256WITHXMSS", localObject25);
    Object localObject27 = a;
    localObject26 = org.bouncycastle.asn1.a2.a.y;
    ((Map)localObject27).put("SHA512WITHXMSS", localObject26);
    Object localObject28 = a;
    localObject27 = org.bouncycastle.asn1.a2.a.z;
    ((Map)localObject28).put("SHAKE128WITHXMSS", localObject27);
    Object localObject29 = a;
    localObject28 = org.bouncycastle.asn1.a2.a.A;
    ((Map)localObject29).put("SHAKE256WITHXMSS", localObject28);
    Object localObject30 = a;
    localObject29 = org.bouncycastle.asn1.a2.a.C;
    ((Map)localObject30).put("SHA256WITHXMSSMT", localObject29);
    Object localObject31 = a;
    localObject30 = org.bouncycastle.asn1.a2.a.D;
    ((Map)localObject31).put("SHA512WITHXMSSMT", localObject30);
    Object localObject32 = a;
    localObject31 = org.bouncycastle.asn1.a2.a.E;
    ((Map)localObject32).put("SHAKE128WITHXMSSMT", localObject31);
    Map localMap = a;
    localObject32 = org.bouncycastle.asn1.a2.a.F;
    localMap.put("SHAKE256WITHXMSSMT", localObject32);
    b.add(p.z2);
    b.add(localObject2);
    b.add(localObject15);
    b.add(localObject16);
    b.add(localObject17);
    b.add(p.m3);
    b.add(localm1);
    b.add(localObject6);
    b.add(localObject7);
    b.add(localObject8);
    b.add(localm2);
    b.add(localObject9);
    b.add(localm3);
    b.add(localObject10);
    b.add(localObject11);
    b.add(localObject12);
    b.add(localObject13);
    b.add(localObject14);
    b.add(localObject18);
    b.add(localObject19);
    b.add(localObject20);
    b.add(localObject21);
    b.add(localObject23);
    b.add(localObject22);
    b.add(localObject25);
    b.add(localObject26);
    b.add(localObject27);
    b.add(localObject28);
    b.add(localObject29);
    b.add(localObject30);
    b.add(localObject31);
    b.add(localObject32);
    b.add(localObject24);
    localObject6 = d;
    localm1 = g.F;
    ((Set)localObject6).add(localm1);
    localObject7 = d;
    localObject6 = g.O;
    ((Set)localObject7).add(localObject6);
    localObject8 = d;
    localObject7 = g.L;
    ((Set)localObject8).add(localObject7);
    localObject8 = d;
    localm2 = g.M;
    ((Set)localObject8).add(localm2);
    localObject8 = d;
    localm3 = g.N;
    ((Set)localObject8).add(localm3);
    localObject9 = d;
    localObject8 = org.bouncycastle.asn1.q2.b.g;
    ((Set)localObject9).add(localObject8);
    localObject10 = d;
    localObject9 = org.bouncycastle.asn1.q2.b.f;
    ((Set)localObject10).add(localObject9);
    localObject11 = d;
    localObject10 = org.bouncycastle.asn1.q2.b.h;
    ((Set)localObject11).add(localObject10);
    d.add(localObject1);
    d.add(localObject3);
    d.add(localObject5);
    d.add(localObject4);
    localObject1 = org.bouncycastle.asn1.m2.b.i;
    localObject11 = v0.c;
    localObject3 = new org.bouncycastle.asn1.x509.a((m)localObject1, (e)localObject11);
    c.put("SHA1WITHRSAANDMGF1", a((org.bouncycastle.asn1.x509.a)localObject3, 20));
    localObject3 = org.bouncycastle.asn1.j2.b.f;
    localObject5 = new org.bouncycastle.asn1.x509.a((m)localObject3, (e)localObject11);
    c.put("SHA224WITHRSAANDMGF1", a((org.bouncycastle.asn1.x509.a)localObject5, 28));
    localObject5 = org.bouncycastle.asn1.j2.b.c;
    localObject4 = new org.bouncycastle.asn1.x509.a((m)localObject5, (e)localObject11);
    c.put("SHA256WITHRSAANDMGF1", a((org.bouncycastle.asn1.x509.a)localObject4, 32));
    localObject4 = org.bouncycastle.asn1.j2.b.d;
    localObject12 = new org.bouncycastle.asn1.x509.a((m)localObject4, (e)localObject11);
    c.put("SHA384WITHRSAANDMGF1", a((org.bouncycastle.asn1.x509.a)localObject12, 48));
    localObject12 = org.bouncycastle.asn1.j2.b.e;
    localObject13 = new org.bouncycastle.asn1.x509.a((m)localObject12, (e)localObject11);
    c.put("SHA512WITHRSAANDMGF1", a((org.bouncycastle.asn1.x509.a)localObject13, 64));
    localObject13 = org.bouncycastle.asn1.j2.b.i;
    localObject14 = new org.bouncycastle.asn1.x509.a((m)localObject13, (e)localObject11);
    c.put("SHA3-224WITHRSAANDMGF1", a((org.bouncycastle.asn1.x509.a)localObject14, 28));
    localObject14 = org.bouncycastle.asn1.j2.b.j;
    localObject2 = new org.bouncycastle.asn1.x509.a((m)localObject14, (e)localObject11);
    c.put("SHA3-256WITHRSAANDMGF1", a((org.bouncycastle.asn1.x509.a)localObject2, 32));
    localObject2 = org.bouncycastle.asn1.j2.b.k;
    localObject15 = new org.bouncycastle.asn1.x509.a((m)localObject2, (e)localObject11);
    c.put("SHA3-384WITHRSAANDMGF1", a((org.bouncycastle.asn1.x509.a)localObject15, 48));
    localObject15 = org.bouncycastle.asn1.j2.b.l;
    localObject11 = new org.bouncycastle.asn1.x509.a((m)localObject15, (e)localObject11);
    c.put("SHA3-512WITHRSAANDMGF1", a((org.bouncycastle.asn1.x509.a)localObject11, 64));
    e.put(localObject6, localObject3);
    e.put(localObject7, localObject5);
    e.put(localm2, localObject4);
    e.put(localm3, localObject12);
    localObject7 = e;
    localObject6 = org.bouncycastle.asn1.j2.b.T;
    ((Map)localObject7).put(localObject6, localObject3);
    e.put(localObject6, localObject5);
    e.put(localObject6, localObject4);
    e.put(localObject6, localObject12);
    e.put(org.bouncycastle.asn1.j2.b.X, localObject13);
    e.put(org.bouncycastle.asn1.j2.b.Y, localObject14);
    e.put(org.bouncycastle.asn1.j2.b.Z, localObject2);
    e.put(org.bouncycastle.asn1.j2.b.a0, localObject15);
    e.put(org.bouncycastle.asn1.j2.b.b0, localObject13);
    e.put(org.bouncycastle.asn1.j2.b.c0, localObject14);
    e.put(org.bouncycastle.asn1.j2.b.d0, localObject2);
    e.put(org.bouncycastle.asn1.j2.b.e0, localObject15);
    e.put(org.bouncycastle.asn1.j2.b.f0, localObject13);
    e.put(org.bouncycastle.asn1.j2.b.g0, localObject14);
    e.put(org.bouncycastle.asn1.j2.b.h0, localObject2);
    e.put(org.bouncycastle.asn1.j2.b.i0, localObject15);
    e.put(g.C, g.h0);
    e.put(g.D, g.i0);
    e.put(g.E, g.j0);
    e.put(localm1, localObject1);
    e.put(localObject8, org.bouncycastle.asn1.q2.b.c);
    e.put(localObject9, org.bouncycastle.asn1.q2.b.b);
    e.put(localObject10, org.bouncycastle.asn1.q2.b.d);
    localObject5 = e;
    localObject3 = org.bouncycastle.asn1.d2.a.n;
    localObject1 = org.bouncycastle.asn1.d2.a.b;
    ((Map)localObject5).put(localObject3, localObject1);
    e.put(org.bouncycastle.asn1.d2.a.o, localObject1);
    e.put(org.bouncycastle.asn1.o2.a.i, org.bouncycastle.asn1.o2.a.c);
    e.put(org.bouncycastle.asn1.o2.a.j, org.bouncycastle.asn1.o2.a.d);
    e.put(org.bouncycastle.asn1.e2.b.d0, org.bouncycastle.asn1.e2.b.b0);
  }
  
  private static k a(org.bouncycastle.asn1.x509.a parama, int paramInt)
  {
    return new k(parama, new org.bouncycastle.asn1.x509.a(g.I, parama), new j(paramInt), new j(1L));
  }
  
  private static org.bouncycastle.asn1.x509.a c(String paramString)
  {
    paramString = i.j(paramString);
    Object localObject = (m)a.get(paramString);
    if (localObject != null)
    {
      if (b.contains(localObject)) {
        paramString = new org.bouncycastle.asn1.x509.a((m)localObject);
      } else if (c.containsKey(paramString)) {
        paramString = new org.bouncycastle.asn1.x509.a((m)localObject, (e)c.get(paramString));
      } else {
        paramString = new org.bouncycastle.asn1.x509.a((m)localObject, v0.c);
      }
      if (d.contains(localObject)) {
        new org.bouncycastle.asn1.x509.a(g.B, v0.c);
      }
      if (paramString.f().equals(g.K)) {
        ((k)paramString.i()).f();
      } else {
        new org.bouncycastle.asn1.x509.a((m)e.get(localObject), v0.c);
      }
      return paramString;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unknown signature type requested: ");
    ((StringBuilder)localObject).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public org.bouncycastle.asn1.x509.a b(String paramString)
  {
    return c(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\operator\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */