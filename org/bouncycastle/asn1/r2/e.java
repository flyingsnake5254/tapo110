package org.bouncycastle.asn1.r2;

import e.a.b.a.c;
import e.a.b.a.d;
import e.a.b.a.h;
import java.math.BigInteger;
import java.util.Random;

public abstract class e
{
  public static h a(d paramd, byte[] paramArrayOfByte)
  {
    e.a.b.a.e locale1 = paramd.n(BigInteger.valueOf(paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0x1));
    paramArrayOfByte = paramd.n(new BigInteger(1, paramArrayOfByte));
    Object localObject = paramArrayOfByte;
    if (!d(paramArrayOfByte).equals(paramd.o())) {
      localObject = paramArrayOfByte.b();
    }
    paramArrayOfByte = null;
    if (((e.a.b.a.e)localObject).i())
    {
      paramArrayOfByte = paramd.p().n();
    }
    else
    {
      e.a.b.a.e locale2 = c(paramd, ((e.a.b.a.e)localObject).o().g().j(paramd.p()).a(paramd.o()).a((e.a.b.a.e)localObject));
      if (locale2 != null)
      {
        paramArrayOfByte = locale2;
        if (!d(locale2).equals(locale1)) {
          paramArrayOfByte = locale2.b();
        }
        paramArrayOfByte = ((e.a.b.a.e)localObject).j(paramArrayOfByte);
      }
    }
    if (paramArrayOfByte != null) {
      return paramd.D(((e.a.b.a.e)localObject).t(), paramArrayOfByte.t());
    }
    throw new IllegalArgumentException("Invalid point compression");
  }
  
  public static byte[] b(h paramh)
  {
    h localh = paramh.A();
    e.a.b.a.e locale = localh.f();
    paramh = locale.e();
    if (!locale.i())
    {
      int i;
      if (d(localh.g().d(locale)).h())
      {
        i = paramh.length - 1;
        paramh[i] = ((byte)(byte)(paramh[i] | 0x1));
      }
      else
      {
        i = paramh.length - 1;
        paramh[i] = ((byte)(byte)(paramh[i] & 0xFE));
      }
    }
    return paramh;
  }
  
  private static e.a.b.a.e c(d paramd, e.a.b.a.e parame)
  {
    if (parame.i()) {
      return parame;
    }
    e.a.b.a.e locale1 = paramd.n(c.a);
    Random localRandom = new Random();
    int i = parame.f();
    e.a.b.a.e locale4;
    do
    {
      e.a.b.a.e locale2 = paramd.n(new BigInteger(i, localRandom));
      int j = 1;
      e.a.b.a.e locale3 = parame;
      locale4 = locale1;
      while (j <= i - 1)
      {
        locale3 = locale3.o();
        locale4 = locale4.o().a(locale3.j(locale2));
        locale3 = locale3.a(parame);
        j++;
      }
      if (!locale3.i()) {
        return null;
      }
    } while (locale4.o().a(locale4).i());
    return locale4;
  }
  
  private static e.a.b.a.e d(e.a.b.a.e parame)
  {
    int i = 1;
    e.a.b.a.e locale = parame;
    while (i < parame.f())
    {
      locale = locale.o().a(parame);
      i++;
    }
    return locale;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\r2\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */