package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.util.Map;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.q;
import org.bouncycastle.util.c;
import org.bouncycastle.util.i;

public class b
{
  private static e.a.b.a.h a(BigInteger paramBigInteger, org.bouncycastle.jce.spec.d paramd)
  {
    return paramd.b().y(paramBigInteger).A();
  }
  
  static int[] b(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[3];
    if (paramArrayOfInt.length == 1)
    {
      arrayOfInt[0] = paramArrayOfInt[0];
    }
    else
    {
      if (paramArrayOfInt.length != 3) {
        break label186;
      }
      if ((paramArrayOfInt[0] < paramArrayOfInt[1]) && (paramArrayOfInt[0] < paramArrayOfInt[2]))
      {
        arrayOfInt[0] = paramArrayOfInt[0];
        if (paramArrayOfInt[1] < paramArrayOfInt[2])
        {
          arrayOfInt[1] = paramArrayOfInt[1];
          arrayOfInt[2] = paramArrayOfInt[2];
        }
        else
        {
          arrayOfInt[1] = paramArrayOfInt[2];
          arrayOfInt[2] = paramArrayOfInt[1];
        }
      }
      else if (paramArrayOfInt[1] < paramArrayOfInt[2])
      {
        arrayOfInt[0] = paramArrayOfInt[1];
        if (paramArrayOfInt[0] < paramArrayOfInt[2])
        {
          arrayOfInt[1] = paramArrayOfInt[0];
          arrayOfInt[2] = paramArrayOfInt[2];
        }
        else
        {
          arrayOfInt[1] = paramArrayOfInt[2];
          arrayOfInt[2] = paramArrayOfInt[0];
        }
      }
      else
      {
        arrayOfInt[0] = paramArrayOfInt[2];
        if (paramArrayOfInt[0] < paramArrayOfInt[1])
        {
          arrayOfInt[1] = paramArrayOfInt[0];
          arrayOfInt[2] = paramArrayOfInt[1];
        }
        else
        {
          arrayOfInt[1] = paramArrayOfInt[1];
          arrayOfInt[2] = paramArrayOfInt[0];
        }
      }
    }
    return arrayOfInt;
    label186:
    throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
  }
  
  public static String c(e.a.b.a.h paramh, org.bouncycastle.jce.spec.d paramd)
  {
    e.a.b.a.d locald = paramd.a();
    paramd = paramd.b();
    if (locald != null) {
      return new c(org.bouncycastle.util.a.n(paramh.l(false), locald.o().e(), locald.p().e(), paramd.l(false))).toString();
    }
    return new c(paramh.l(false)).toString();
  }
  
  public static String d(m paramm)
  {
    return org.bouncycastle.asn1.u2.e.d(paramm);
  }
  
  public static n e(org.bouncycastle.jcajce.provider.config.b paramb, org.bouncycastle.asn1.u2.h paramh)
  {
    if (paramh.i())
    {
      m localm = m.r(paramh.g());
      j localj = g(localm);
      paramh = localj;
      if (localj == null) {
        paramh = (j)paramb.a().get(localm);
      }
      paramb = new q(localm, paramh.f(), paramh.g(), paramh.j(), paramh.h(), paramh.k());
    }
    else if (paramh.h())
    {
      paramb = paramb.b();
      paramb = new n(paramb.a(), paramb.b(), paramb.d(), paramb.c(), paramb.e());
    }
    else
    {
      paramb = j.i(paramh.g());
      paramb = new n(paramb.f(), paramb.g(), paramb.j(), paramb.h(), paramb.k());
    }
    return paramb;
  }
  
  public static n f(org.bouncycastle.jcajce.provider.config.b paramb, org.bouncycastle.jce.spec.d paramd)
  {
    if ((paramd instanceof org.bouncycastle.jce.spec.b))
    {
      paramb = (org.bouncycastle.jce.spec.b)paramd;
      paramb = new q(h(paramb.f()), paramb.a(), paramb.b(), paramb.d(), paramb.c(), paramb.e());
    }
    else if (paramd == null)
    {
      paramb = paramb.b();
      paramb = new n(paramb.a(), paramb.b(), paramb.d(), paramb.c(), paramb.e());
    }
    else
    {
      paramb = new n(paramd.a(), paramd.b(), paramd.d(), paramd.c(), paramd.e());
    }
    return paramb;
  }
  
  public static j g(m paramm)
  {
    j localj1 = org.bouncycastle.crypto.q.a.i(paramm);
    j localj2 = localj1;
    if (localj1 == null) {
      localj2 = org.bouncycastle.asn1.u2.e.c(paramm);
    }
    return localj2;
  }
  
  public static m h(String paramString)
  {
    int i = paramString.indexOf(' ');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i + 1);
    }
    try
    {
      if ((str.charAt(0) >= '0') && (str.charAt(0) <= '2'))
      {
        paramString = new m(str);
        return paramString;
      }
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;) {}
    }
    return org.bouncycastle.asn1.u2.e.e(str);
  }
  
  public static int i(org.bouncycastle.jcajce.provider.config.b paramb, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    if (paramBigInteger1 == null)
    {
      paramb = paramb.b();
      if (paramb == null) {
        return paramBigInteger2.bitLength();
      }
      return paramb.d().bitLength();
    }
    return paramBigInteger1.bitLength();
  }
  
  public static String j(String paramString, BigInteger paramBigInteger, org.bouncycastle.jce.spec.d paramd)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = i.d();
    paramBigInteger = a(paramBigInteger, paramd);
    localStringBuffer.append(paramString);
    localStringBuffer.append(" Private Key [");
    localStringBuffer.append(c(paramBigInteger, paramd));
    localStringBuffer.append("]");
    localStringBuffer.append(str);
    localStringBuffer.append("            X: ");
    localStringBuffer.append(paramBigInteger.f().t().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("            Y: ");
    localStringBuffer.append(paramBigInteger.g().t().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
  
  public static String k(String paramString, e.a.b.a.h paramh, org.bouncycastle.jce.spec.d paramd)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = i.d();
    localStringBuffer.append(paramString);
    localStringBuffer.append(" Public Key [");
    localStringBuffer.append(c(paramh, paramd));
    localStringBuffer.append("]");
    localStringBuffer.append(str);
    localStringBuffer.append("            X: ");
    localStringBuffer.append(paramh.f().t().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("            Y: ");
    localStringBuffer.append(paramh.g().t().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */