package org.bouncycastle.crypto.q;

import e.a.b.a.a0.c.a0;
import e.a.b.a.a0.c.c1;
import e.a.b.a.a0.c.c2;
import e.a.b.a.a0.c.e;
import e.a.b.a.a0.c.e0;
import e.a.b.a.a0.c.e1;
import e.a.b.a.a0.c.g;
import e.a.b.a.a0.c.g2;
import e.a.b.a.a0.c.i0;
import e.a.b.a.a0.c.i1;
import e.a.b.a.a0.c.i2;
import e.a.b.a.a0.c.k1;
import e.a.b.a.a0.c.m0;
import e.a.b.a.a0.c.m1;
import e.a.b.a.a0.c.m2;
import e.a.b.a.a0.c.o;
import e.a.b.a.a0.c.o2;
import e.a.b.a.a0.c.q0;
import e.a.b.a.a0.c.q1;
import e.a.b.a.a0.c.s;
import e.a.b.a.a0.c.s1;
import e.a.b.a.a0.c.s2;
import e.a.b.a.a0.c.u2;
import e.a.b.a.a0.c.w;
import e.a.b.a.a0.c.w0;
import e.a.b.a.a0.c.w1;
import e.a.b.a.a0.c.y0;
import e.a.b.a.a0.c.y1;
import e.a.b.a.b0.c;
import e.a.b.a.d.d;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.e2.b;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.asn1.u2.l;
import org.bouncycastle.util.i;

public class a
{
  static org.bouncycastle.asn1.u2.k A;
  static org.bouncycastle.asn1.u2.k B;
  static org.bouncycastle.asn1.u2.k C;
  static org.bouncycastle.asn1.u2.k D;
  static org.bouncycastle.asn1.u2.k E;
  static org.bouncycastle.asn1.u2.k F;
  static final Hashtable G;
  static final Hashtable H;
  static final Hashtable I;
  static final Hashtable J;
  static final Vector K;
  static org.bouncycastle.asn1.u2.k a = new k();
  static org.bouncycastle.asn1.u2.k b = new v();
  static org.bouncycastle.asn1.u2.k c = new z();
  static org.bouncycastle.asn1.u2.k d = new a0();
  static org.bouncycastle.asn1.u2.k e = new b0();
  static org.bouncycastle.asn1.u2.k f = new c0();
  static org.bouncycastle.asn1.u2.k g = new d0();
  static org.bouncycastle.asn1.u2.k h = new e0();
  static org.bouncycastle.asn1.u2.k i = new f0();
  static org.bouncycastle.asn1.u2.k j = new a();
  static org.bouncycastle.asn1.u2.k k = new b();
  static org.bouncycastle.asn1.u2.k l = new c();
  static org.bouncycastle.asn1.u2.k m = new d();
  static org.bouncycastle.asn1.u2.k n = new e();
  static org.bouncycastle.asn1.u2.k o = new f();
  static org.bouncycastle.asn1.u2.k p = new g();
  static org.bouncycastle.asn1.u2.k q = new h();
  static org.bouncycastle.asn1.u2.k r = new i();
  static org.bouncycastle.asn1.u2.k s = new j();
  static org.bouncycastle.asn1.u2.k t = new l();
  static org.bouncycastle.asn1.u2.k u = new m();
  static org.bouncycastle.asn1.u2.k v = new n();
  static org.bouncycastle.asn1.u2.k w = new o();
  static org.bouncycastle.asn1.u2.k x = new p();
  static org.bouncycastle.asn1.u2.k y = new q();
  static org.bouncycastle.asn1.u2.k z = new r();
  
  static
  {
    A = new s();
    B = new t();
    C = new u();
    D = new w();
    E = new x();
    F = new y();
    G = new Hashtable();
    H = new Hashtable();
    I = new Hashtable();
    J = new Hashtable();
    K = new Vector();
    e("curve25519", a);
    g("secp128r1", org.bouncycastle.asn1.p2.d.u, b);
    g("secp160k1", org.bouncycastle.asn1.p2.d.j, c);
    g("secp160r1", org.bouncycastle.asn1.p2.d.i, d);
    g("secp160r2", org.bouncycastle.asn1.p2.d.w, e);
    g("secp192k1", org.bouncycastle.asn1.p2.d.x, f);
    m localm1 = org.bouncycastle.asn1.p2.d.G;
    g("secp192r1", localm1, g);
    g("secp224k1", org.bouncycastle.asn1.p2.d.y, h);
    m localm2 = org.bouncycastle.asn1.p2.d.z;
    g("secp224r1", localm2, i);
    g("secp256k1", org.bouncycastle.asn1.p2.d.k, j);
    m localm3 = org.bouncycastle.asn1.p2.d.H;
    g("secp256r1", localm3, k);
    m localm4 = org.bouncycastle.asn1.p2.d.A;
    g("secp384r1", localm4, l);
    m localm5 = org.bouncycastle.asn1.p2.d.B;
    g("secp521r1", localm5, m);
    g("sect113r1", org.bouncycastle.asn1.p2.d.e, n);
    g("sect113r2", org.bouncycastle.asn1.p2.d.f, o);
    g("sect131r1", org.bouncycastle.asn1.p2.d.o, p);
    g("sect131r2", org.bouncycastle.asn1.p2.d.p, q);
    m localm6 = org.bouncycastle.asn1.p2.d.b;
    g("sect163k1", localm6, r);
    g("sect163r1", org.bouncycastle.asn1.p2.d.c, s);
    m localm7 = org.bouncycastle.asn1.p2.d.l;
    g("sect163r2", localm7, t);
    g("sect193r1", org.bouncycastle.asn1.p2.d.q, u);
    g("sect193r2", org.bouncycastle.asn1.p2.d.r, v);
    m localm8 = org.bouncycastle.asn1.p2.d.s;
    g("sect233k1", localm8, w);
    m localm9 = org.bouncycastle.asn1.p2.d.t;
    g("sect233r1", localm9, x);
    g("sect239k1", org.bouncycastle.asn1.p2.d.d, y);
    m localm10 = org.bouncycastle.asn1.p2.d.m;
    g("sect283k1", localm10, z);
    m localm11 = org.bouncycastle.asn1.p2.d.n;
    g("sect283r1", localm11, A);
    m localm12 = org.bouncycastle.asn1.p2.d.C;
    g("sect409k1", localm12, B);
    m localm13 = org.bouncycastle.asn1.p2.d.D;
    g("sect409r1", localm13, C);
    m localm14 = org.bouncycastle.asn1.p2.d.E;
    g("sect571k1", localm14, D);
    m localm15 = org.bouncycastle.asn1.p2.d.F;
    g("sect571r1", localm15, E);
    g("sm2p256v1", b.F, F);
    f("B-163", localm7);
    f("B-233", localm9);
    f("B-283", localm11);
    f("B-409", localm13);
    f("B-571", localm15);
    f("K-163", localm6);
    f("K-233", localm8);
    f("K-283", localm10);
    f("K-409", localm12);
    f("K-571", localm14);
    f("P-192", localm1);
    f("P-224", localm2);
    f("P-256", localm3);
    f("P-384", localm4);
    f("P-521", localm5);
  }
  
  private static e.a.b.a.d c(e.a.b.a.d paramd)
  {
    return paramd;
  }
  
  private static e.a.b.a.d d(e.a.b.a.d paramd, e.a.b.a.b0.d paramd1)
  {
    return paramd.d().b(new c(paramd, paramd1)).a();
  }
  
  static void e(String paramString, org.bouncycastle.asn1.u2.k paramk)
  {
    K.addElement(paramString);
    paramString = i.f(paramString);
    G.put(paramString, paramk);
  }
  
  static void f(String paramString, m paramm)
  {
    Object localObject = I.get(paramm);
    if (localObject != null)
    {
      paramString = i.f(paramString);
      H.put(paramString, paramm);
      G.put(paramString, localObject);
      return;
    }
    throw new IllegalStateException();
  }
  
  static void g(String paramString, m paramm, org.bouncycastle.asn1.u2.k paramk)
  {
    K.addElement(paramString);
    J.put(paramm, paramString);
    I.put(paramm, paramk);
    paramString = i.f(paramString);
    H.put(paramString, paramm);
    G.put(paramString, paramk);
  }
  
  public static j h(String paramString)
  {
    paramString = (org.bouncycastle.asn1.u2.k)G.get(i.f(paramString));
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = paramString.b();
    }
    return paramString;
  }
  
  public static j i(m paramm)
  {
    paramm = (org.bouncycastle.asn1.u2.k)I.get(paramm);
    if (paramm == null) {
      paramm = null;
    } else {
      paramm = paramm.b();
    }
    return paramm;
  }
  
  public static Enumeration j()
  {
    return K.elements();
  }
  
  static final class a
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      Object localObject = new BigInteger("7ae96a2b657c07106e64479eac3434e99cf0497512f58995c1396c28719501ee", 16);
      BigInteger localBigInteger1 = new BigInteger("5363ad4cc05c30e0a5261c028812645a122e22ea20816678df02967c1b23bd72", 16);
      BigInteger localBigInteger2 = new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16);
      BigInteger localBigInteger3 = new BigInteger("-e4437ed6010e88286f547fa90abfe4c3", 16);
      BigInteger localBigInteger4 = new BigInteger("114ca50f7a8e2f3f657c1108d9d44cfd8", 16);
      BigInteger localBigInteger5 = new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16);
      BigInteger localBigInteger6 = new BigInteger("3086d221a7d46bcde86c90e49284eb153dab", 16);
      BigInteger localBigInteger7 = new BigInteger("e4437ed6010e88286f547fa90abfe4c42212", 16);
      localObject = new e.a.b.a.b0.d((BigInteger)localObject, localBigInteger1, new BigInteger[] { localBigInteger2, localBigInteger3 }, new BigInteger[] { localBigInteger4, localBigInteger5 }, localBigInteger6, localBigInteger7, 272);
      localObject = a.b(new e0(), (e.a.b.a.b0.d)localObject);
      return new j((e.a.b.a.d)localObject, new l((e.a.b.a.d)localObject, org.bouncycastle.util.encoders.d.a("0479BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8")), ((e.a.b.a.d)localObject).w(), ((e.a.b.a.d)localObject).q(), null);
    }
  }
  
  static final class a0
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("1053CDE42C14D696E67687561517533BF3F83345");
      e.a.b.a.d locald = a.a(new g());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("044A96B5688EF573284664698968C38BB913CBFC8223A628553168947D59DCC912042351377AC5FB32")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class b
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("C49D360886E704936A6678E1139D26B7819F7E90");
      e.a.b.a.d locald = a.a(new i0());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("046B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C2964FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class b0
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("B99B99B099B323E02709A4D696E6768756151751");
      e.a.b.a.d locald = a.a(new e.a.b.a.a0.c.k());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("0452DCB034293A117E1F4FF11B30F7199D3144CE6DFEAFFEF2E331F296E071FA0DF9982CFEA7D43F2E")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class c
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("A335926AA319A27A1D00896A6773A4827ACDAC73");
      e.a.b.a.d locald = a.a(new m0());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("04AA87CA22BE8B05378EB1C71EF320AD746E1D3B628BA79B9859F741E082542A385502F25DBF55296C3A545E3872760AB73617DE4A96262C6F5D9E98BF9292DC29F8F41DBD289A147CE9DA3113B5F0B8C00A60B1CE1D7E819D7A431D7C90EA0E5F")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class c0
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      BigInteger localBigInteger1 = new BigInteger("bb85691939b869c1d087f601554b96b80cb4f55b35f433c2", 16);
      BigInteger localBigInteger2 = new BigInteger("3d84f26c12238d7b4f3d516613c1759033b1a5800175d0b1", 16);
      BigInteger localBigInteger3 = new BigInteger("71169be7330b3038edb025f1", 16);
      BigInteger localBigInteger4 = new BigInteger("-b3fb3400dec5c4adceb8655c", 16);
      Object localObject = new BigInteger("12511cfe811d0f4e6bc688b4d", 16);
      BigInteger localBigInteger5 = new BigInteger("71169be7330b3038edb025f1", 16);
      BigInteger localBigInteger6 = new BigInteger("71169be7330b3038edb025f1d0f9", 16);
      BigInteger localBigInteger7 = new BigInteger("b3fb3400dec5c4adceb8655d4c94", 16);
      localObject = new e.a.b.a.b0.d(localBigInteger1, localBigInteger2, new BigInteger[] { localBigInteger3, localBigInteger4 }, new BigInteger[] { localObject, localBigInteger5 }, localBigInteger6, localBigInteger7, 208);
      localObject = a.b(new o(), (e.a.b.a.b0.d)localObject);
      return new j((e.a.b.a.d)localObject, new l((e.a.b.a.d)localObject, org.bouncycastle.util.encoders.d.a("04DB4FF10EC057E9AE26B07D0280B7F4341DA5D1B1EAE06C7D9B2F2F6D9C5628A7844163D015BE86344082AA88D95E2F9D")), ((e.a.b.a.d)localObject).w(), ((e.a.b.a.d)localObject).q(), null);
    }
  }
  
  static final class d
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("D09E8800291CB85396CC6717393284AAA0DA64BA");
      e.a.b.a.d locald = a.a(new q0());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("0400C6858E06B70404E9CD9E3ECB662395B4429C648139053FB521F828AF606B4D3DBAA14B5E77EFE75928FE1DC127A2FFA8DE3348B3C1856A429BF97E7E31C2E5BD66011839296A789A3BC0045C8A5FB42C7D1BD998F54449579B446817AFBD17273E662C97EE72995EF42640C550B9013FAD0761353C7086A272C24088BE94769FD16650")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class d0
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("3045AE6FC8422F64ED579528D38120EAE12196D5");
      e.a.b.a.d locald = a.a(new s());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("04188DA80EB03090F67CBF20EB43A18800F4FF0AFD82FF101207192B95FFC8DA78631011ED6B24CDD573F977A11E794811")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class e
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("10E723AB14D696E6768756151756FEBF8FCB49A9");
      e.a.b.a.d locald = a.a(new w0());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("04009D73616F35F4AB1407D73562C10F00A52830277958EE84D1315ED31886")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class e0
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      Object localObject = new BigInteger("fe0e87005b4e83761908c5131d552a850b3f58b749c37cf5b84d6768", 16);
      BigInteger localBigInteger1 = new BigInteger("60dcd2104c4cbc0be6eeefc2bdd610739ec34e317f9b33046c9e4788", 16);
      BigInteger localBigInteger2 = new BigInteger("6b8cf07d4ca75c88957d9d670591", 16);
      BigInteger localBigInteger3 = new BigInteger("-b8adf1378a6eb73409fa6c9c637d", 16);
      BigInteger localBigInteger4 = new BigInteger("1243ae1b4d71613bc9f780a03690e", 16);
      BigInteger localBigInteger5 = new BigInteger("6b8cf07d4ca75c88957d9d670591", 16);
      BigInteger localBigInteger6 = new BigInteger("6b8cf07d4ca75c88957d9d67059037a4", 16);
      BigInteger localBigInteger7 = new BigInteger("b8adf1378a6eb73409fa6c9c637ba7f5", 16);
      localObject = new e.a.b.a.b0.d((BigInteger)localObject, localBigInteger1, new BigInteger[] { localBigInteger2, localBigInteger3 }, new BigInteger[] { localBigInteger4, localBigInteger5 }, localBigInteger6, localBigInteger7, 240);
      localObject = a.b(new w(), (e.a.b.a.b0.d)localObject);
      return new j((e.a.b.a.d)localObject, new l((e.a.b.a.d)localObject, org.bouncycastle.util.encoders.d.a("04A1455B334DF099DF30FC28A169A467E9E47075A90F7E650EB6B7A45C7E089FED7FBA344282CAFBD6F7E319F7C0B0BD59E2CA4BDB556D61A5")), ((e.a.b.a.d)localObject).w(), ((e.a.b.a.d)localObject).q(), null);
    }
  }
  
  static final class f
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("10C0FB15760860DEF1EEF4D696E676875615175D");
      e.a.b.a.d locald = a.a(new y0());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("0401A57A6A7B26CA5EF52FCDB816479700B3ADC94ED1FE674C06E695BABA1D")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class f0
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("BD71344799D5C7FCDC45B59FA3B9AB8F6A948BC5");
      e.a.b.a.d locald = a.a(new a0());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("04B70E0CBD6BB4BF7F321390B94A03C1D356C21122343280D6115C1D21BD376388B5F723FB4C22DFE6CD4375A05A07476444D5819985007E34")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class g
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("4D696E676875615175985BD3ADBADA21B43A97E2");
      e.a.b.a.d locald = a.a(new c1());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("040081BAF91FDF9833C40F9C181343638399078C6E7EA38C001F73C8134B1B4EF9E150")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class h
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("985BD3ADBAD4D696E676875615175A21B43A97E3");
      e.a.b.a.d locald = a.a(new e1());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("040356DCD8F2F95031AD652D23951BB366A80648F06D867940A5366D9E265DE9EB240F")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class i
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      e.a.b.a.d locald = a.a(new i1());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("0402FE13C0537BBC11ACAA07D793DE4E6D5E5C94EEE80289070FB05D38FF58321F2E800536D538CCDAA3D9")), locald.w(), locald.q(), null);
    }
  }
  
  static final class j
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("24B7B137C8A14D696E6768756151756FD0DA2E5C");
      e.a.b.a.d locald = a.a(new k1());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("040369979697AB43897789566789567F787A7876A65400435EDB42EFAFB2989D51FEFCE3C80988F41FF883")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class k
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      e.a.b.a.d locald = a.a(new e.a.b.a.a0.a.a());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("042AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD245A20AE19A1B8A086B4E01EDD2C7748D14C923D4D7E6D7C61B229E9C5A27ECED3D9")), locald.w(), locald.q(), null);
    }
  }
  
  static final class l
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("85E25BFE5C86226CDB12016F7553F9D0E693A268");
      e.a.b.a.d locald = a.a(new m1());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("0403F0EBA16286A2D57EA0991168D4994637E8343E3600D51FBC6C71A0094FA2CDD545B11C5C0C797324F1")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class m
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("103FAEC74D696E676875615175777FC5B191EF30");
      e.a.b.a.d locald = a.a(new q1());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("0401F481BC5F0FF84A74AD6CDF6FDEF4BF6179625372D8C0C5E10025E399F2903712CCF3EA9E3A1AD17FB0B3201B6AF7CE1B05")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class n
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("10B7B4D696E676875615175137C8A16FD0DA2211");
      e.a.b.a.d locald = a.a(new s1());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("0400D9B67D192E0367C803F39E1A7E82CA14A651350AAE617E8F01CE94335607C304AC29E7DEFBD9CA01F596F927224CDECF6C")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class o
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      e.a.b.a.d locald = a.a(new w1());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("04017232BA853A7E731AF129F22FF4149563A419C26BF50A4C9D6EEFAD612601DB537DECE819B7F70F555A67C427A8CD9BF18AEB9B56E0C11056FAE6A3")), locald.w(), locald.q(), null);
    }
  }
  
  static final class p
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("74D59FF07F6B413D0EA14B344B20A2DB049B50C3");
      e.a.b.a.d locald = a.a(new y1());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("0400FAC9DFCBAC8313BB2139F1BB755FEF65BC391F8B36F8F8EB7371FD558B01006A08A41903350678E58528BEBF8A0BEFF867A7CA36716F7E01F81052")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class q
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      e.a.b.a.d locald = a.a(new c2());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("0429A0B6A887A983E9730988A68727A8B2D126C44CC2CC7B2A6555193035DC76310804F12E549BDB011C103089E73510ACB275FC312A5DC6B76553F0CA")), locald.w(), locald.q(), null);
    }
  }
  
  static final class r
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      e.a.b.a.d locald = a.a(new g2());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("040503213F78CA44883F1A3B8162F188E553CD265F23C1567A16876913B0C2AC245849283601CCDA380F1C9E318D90F95D07E5426FE87E45C0E8184698E45962364E34116177DD2259")), locald.w(), locald.q(), null);
    }
  }
  
  static final class s
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("77E2B07370EB0F832A6DD5B62DFC88CD06BB84BE");
      e.a.b.a.d locald = a.a(new i2());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("0405F939258DB7DD90E1934F8C70B0DFEC2EED25B8557EAC9C80E2E198F8CDBECD86B1205303676854FE24141CB98FE6D4B20D02B4516FF702350EDDB0826779C813F0DF45BE8112F4")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class t
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      e.a.b.a.d locald = a.a(new m2());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("040060F05F658F49C1AD3AB1890F7184210EFD0987E307C84C27ACCFB8F9F67CC2C460189EB5AAAA62EE222EB1B35540CFE902374601E369050B7C4E42ACBA1DACBF04299C3460782F918EA427E6325165E9EA10E3DA5F6C42E9C55215AA9CA27A5863EC48D8E0286B")), locald.w(), locald.q(), null);
    }
  }
  
  static final class u
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("4099B5A457F9D69F79213D094C4BCD4D4262210B");
      e.a.b.a.d locald = a.a(new o2());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("04015D4860D088DDB3496B0C6064756260441CDE4AF1771D4DB01FFE5B34E59703DC255A868A1180515603AEAB60794E54BB7996A70061B1CFAB6BE5F32BBFA78324ED106A7636B9C5A7BD198D0158AA4F5488D08F38514F1FDF4B4F40D2181B3681C364BA0273C706")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class v
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("000E0D4D696E6768756151750CC03A4473D03679");
      e.a.b.a.d locald = a.a(new e.a.b.a.a0.c.a());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("04161FF7528B899B2D0C28607CA52C5B86CF5AC8395BAFEB13C02DA292DDED7A83")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class w
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      e.a.b.a.d locald = a.a(new s2());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("04026EB7A859923FBC82189631F8103FE4AC9CA2970012D5D46024804801841CA44370958493B205E647DA304DB4CEB08CBBD1BA39494776FB988B47174DCA88C7E2945283A01C89720349DC807F4FBF374F4AEADE3BCA95314DD58CEC9F307A54FFC61EFC006D8A2C9D4979C0AC44AEA74FBEBBB9F772AEDCB620B01A7BA7AF1B320430C8591984F601CD4C143EF1C7A3")), locald.w(), locald.q(), null);
    }
  }
  
  static final class x
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      byte[] arrayOfByte = org.bouncycastle.util.encoders.d.a("2AA058F73A0E33AB486B0F610410C53A7F132310");
      e.a.b.a.d locald = a.a(new u2());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("040303001D34B856296C16C0D40D3CD7750A93D1D2955FA80AA5F40FC8DB7B2ABDBDE53950F4C0D293CDD711A35B67FB1499AE60038614F1394ABFA3B4C850D927E1E7769C8EEC2D19037BF27342DA639B6DCCFFFEB73D69D78C6C27A6009CBBCA1980F8533921E8A684423E43BAB08A576291AF8F461BB2A8B3531D2F0485C19B16E2F1516E23DD3C1A4827AF1B8AC15B")), locald.w(), locald.q(), arrayOfByte);
    }
  }
  
  static final class y
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      e.a.b.a.d locald = a.a(new e.a.b.a.a0.b.a());
      return new j(locald, new l(locald, org.bouncycastle.util.encoders.d.a("0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0")), locald.w(), locald.q(), null);
    }
  }
  
  static final class z
    extends org.bouncycastle.asn1.u2.k
  {
    protected j a()
    {
      BigInteger localBigInteger1 = new BigInteger("9ba48cba5ebcb9b6bd33b92830b2a2e0e192f10a", 16);
      BigInteger localBigInteger2 = new BigInteger("c39c6c3b3a36d7701b9c71a1f5804ae5d0003f4", 16);
      BigInteger localBigInteger3 = new BigInteger("9162fbe73984472a0a9e", 16);
      BigInteger localBigInteger4 = new BigInteger("-96341f1138933bc2f505", 16);
      BigInteger localBigInteger5 = new BigInteger("127971af8721782ecffa3", 16);
      BigInteger localBigInteger6 = new BigInteger("9162fbe73984472a0a9e", 16);
      Object localObject = new BigInteger("9162fbe73984472a0a9d0590", 16);
      BigInteger localBigInteger7 = new BigInteger("96341f1138933bc2f503fd44", 16);
      localObject = new e.a.b.a.b0.d(localBigInteger1, localBigInteger2, new BigInteger[] { localBigInteger3, localBigInteger4 }, new BigInteger[] { localBigInteger5, localBigInteger6 }, (BigInteger)localObject, localBigInteger7, 176);
      localObject = a.b(new e(), (e.a.b.a.b0.d)localObject);
      return new j((e.a.b.a.d)localObject, new l((e.a.b.a.d)localObject, org.bouncycastle.util.encoders.d.a("043B4C382CE37AA192A4019E763036F4F5DD4D7EBB938CF935318FDCED6BC28286531733C3F03C4FEE")), ((e.a.b.a.d)localObject).w(), ((e.a.b.a.d)localObject).q(), null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\q\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */