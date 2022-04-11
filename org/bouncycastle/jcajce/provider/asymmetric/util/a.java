package org.bouncycastle.jcajce.provider.asymmetric.util;

import e.a.b.a.d.e;
import e.a.b.a.d.f;
import e.a.b.b.f;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.c;

public class a
{
  private static Map a = new HashMap();
  
  static
  {
    Object localObject = org.bouncycastle.crypto.q.a.j();
    while (((Enumeration)localObject).hasMoreElements())
    {
      String str = (String)((Enumeration)localObject).nextElement();
      j localj = org.bouncycastle.asn1.u2.e.b(str);
      if (localj != null) {
        a.put(localj.f(), org.bouncycastle.crypto.q.a.h(str).f());
      }
    }
    localObject = org.bouncycastle.crypto.q.a.h("Curve25519");
    a.put(new d.f(((j)localObject).f().s().b(), ((j)localObject).f().o().t(), ((j)localObject).f().p().t()), ((j)localObject).f());
  }
  
  public static EllipticCurve a(e.a.b.a.d paramd, byte[] paramArrayOfByte)
  {
    return new EllipticCurve(c(paramd.s()), paramd.o().t(), paramd.p().t(), null);
  }
  
  public static e.a.b.a.d b(EllipticCurve paramEllipticCurve)
  {
    Object localObject1 = paramEllipticCurve.getField();
    Object localObject2 = paramEllipticCurve.getA();
    paramEllipticCurve = paramEllipticCurve.getB();
    if ((localObject1 instanceof ECFieldFp))
    {
      localObject2 = new d.f(((ECFieldFp)localObject1).getP(), (BigInteger)localObject2, paramEllipticCurve);
      paramEllipticCurve = (EllipticCurve)localObject2;
      if (a.containsKey(localObject2)) {
        paramEllipticCurve = (e.a.b.a.d)a.get(localObject2);
      }
      return paramEllipticCurve;
    }
    localObject1 = (ECFieldF2m)localObject1;
    int i = ((ECFieldF2m)localObject1).getM();
    localObject1 = b.b(((ECFieldF2m)localObject1).getMidTermsOfReductionPolynomial());
    return new d.e(i, localObject1[0], localObject1[1], localObject1[2], (BigInteger)localObject2, paramEllipticCurve);
  }
  
  public static ECField c(e.a.b.b.a parama)
  {
    if (e.a.b.a.b.j(parama)) {
      return new ECFieldFp(parama.b());
    }
    parama = ((f)parama).c();
    int[] arrayOfInt = parama.a();
    arrayOfInt = org.bouncycastle.util.a.F(org.bouncycastle.util.a.t(arrayOfInt, 1, arrayOfInt.length - 1));
    return new ECFieldF2m(parama.b(), arrayOfInt);
  }
  
  public static ECPoint d(e.a.b.a.h paramh)
  {
    paramh = paramh.A();
    return new ECPoint(paramh.f().t(), paramh.g().t());
  }
  
  public static e.a.b.a.h e(ECParameterSpec paramECParameterSpec, ECPoint paramECPoint, boolean paramBoolean)
  {
    return f(b(paramECParameterSpec.getCurve()), paramECPoint, paramBoolean);
  }
  
  public static e.a.b.a.h f(e.a.b.a.d paramd, ECPoint paramECPoint, boolean paramBoolean)
  {
    return paramd.g(paramECPoint.getAffineX(), paramECPoint.getAffineY());
  }
  
  public static ECParameterSpec g(EllipticCurve paramEllipticCurve, org.bouncycastle.jce.spec.d paramd)
  {
    if ((paramd instanceof org.bouncycastle.jce.spec.b)) {
      return new c(((org.bouncycastle.jce.spec.b)paramd).f(), paramEllipticCurve, d(paramd.b()), paramd.d(), paramd.c());
    }
    return new ECParameterSpec(paramEllipticCurve, d(paramd.b()), paramd.d(), paramd.c().intValue());
  }
  
  public static org.bouncycastle.jce.spec.d h(ECParameterSpec paramECParameterSpec, boolean paramBoolean)
  {
    e.a.b.a.d locald = b(paramECParameterSpec.getCurve());
    return new org.bouncycastle.jce.spec.d(locald, f(locald, paramECParameterSpec.getGenerator(), paramBoolean), paramECParameterSpec.getOrder(), BigInteger.valueOf(paramECParameterSpec.getCofactor()), paramECParameterSpec.getCurve().getSeed());
  }
  
  public static ECParameterSpec i(org.bouncycastle.asn1.u2.h paramh, e.a.b.a.d paramd)
  {
    if (paramh.i())
    {
      m localm = (m)paramh.g();
      j localj = b.g(localm);
      paramh = localj;
      if (localj == null)
      {
        Map localMap = BouncyCastleProvider.CONFIGURATION.a();
        paramh = localj;
        if (!localMap.isEmpty()) {
          paramh = (j)localMap.get(localm);
        }
      }
      paramd = a(paramd, paramh.k());
      paramh = new c(b.d(localm), paramd, d(paramh.g()), paramh.j(), paramh.h());
    }
    else if (paramh.h())
    {
      paramh = null;
    }
    else
    {
      paramh = j.i(paramh.g());
      paramd = a(paramd, paramh.k());
      if (paramh.h() != null) {
        paramh = new ECParameterSpec(paramd, d(paramh.g()), paramh.j(), paramh.h().intValue());
      } else {
        paramh = new ECParameterSpec(paramd, d(paramh.g()), paramh.j(), 1);
      }
    }
    return paramh;
  }
  
  public static e.a.b.a.d j(org.bouncycastle.jcajce.provider.config.b paramb, org.bouncycastle.asn1.u2.h paramh)
  {
    Object localObject = paramb.c();
    if (paramh.i())
    {
      m localm = m.r(paramh.g());
      if ((!((Set)localObject).isEmpty()) && (!((Set)localObject).contains(localm))) {
        throw new IllegalStateException("named curve not acceptable");
      }
      localObject = b.g(localm);
      paramh = (org.bouncycastle.asn1.u2.h)localObject;
      if (localObject == null) {
        paramh = (j)paramb.a().get(localm);
      }
      paramb = paramh.f();
    }
    else if (paramh.h())
    {
      paramb = paramb.b().a();
    }
    else
    {
      if (!((Set)localObject).isEmpty()) {
        break label132;
      }
      paramb = j.i(paramh.g()).f();
    }
    return paramb;
    label132:
    throw new IllegalStateException("encoded parameters not acceptable");
  }
  
  public static n k(org.bouncycastle.jcajce.provider.config.b paramb, ECParameterSpec paramECParameterSpec)
  {
    if (paramECParameterSpec == null)
    {
      paramb = paramb.b();
      paramb = new n(paramb.a(), paramb.b(), paramb.d(), paramb.c(), paramb.e());
    }
    else
    {
      paramb = b.f(paramb, h(paramECParameterSpec, false));
    }
    return paramb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */