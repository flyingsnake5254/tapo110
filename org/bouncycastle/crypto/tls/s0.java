package org.bouncycastle.crypto.tls;

import e.a.b.a.d.e;
import e.a.b.a.d.f;
import e.a.b.a.h;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.bouncycastle.asn1.u2.e;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.crypto.s.c;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.o;
import org.bouncycastle.crypto.w.s;

public class s0
{
  public static final Integer a = org.bouncycastle.util.d.b(10);
  public static final Integer b = org.bouncycastle.util.d.b(11);
  private static final String[] c = { "sect163k1", "sect163r1", "sect163r2", "sect193r1", "sect193r2", "sect233k1", "sect233r1", "sect239k1", "sect283k1", "sect283r1", "sect409k1", "sect409r1", "sect571k1", "sect571r1", "secp160k1", "secp160r1", "secp160r2", "secp192k1", "secp192r1", "secp224k1", "secp224r1", "secp256k1", "secp256r1", "secp384r1", "secp521r1", "brainpoolP256r1", "brainpoolP384r1", "brainpoolP512r1" };
  
  public static void A(short[] paramArrayOfShort, h paramh, OutputStream paramOutputStream)
    throws IOException
  {
    m1.v0(y(paramArrayOfShort, paramh), paramOutputStream);
  }
  
  public static void a(Hashtable paramHashtable, int[] paramArrayOfInt)
    throws IOException
  {
    paramHashtable.put(a, f(paramArrayOfInt));
  }
  
  public static void b(Hashtable paramHashtable, short[] paramArrayOfShort)
    throws IOException
  {
    paramHashtable.put(b, g(paramArrayOfShort));
  }
  
  public static byte[] c(s params, org.bouncycastle.crypto.w.r paramr)
  {
    org.bouncycastle.crypto.o.b localb = new org.bouncycastle.crypto.o.b();
    localb.c(paramr);
    params = localb.a(params);
    return org.bouncycastle.util.b.a(localb.b(), params);
  }
  
  private static void d(int[] paramArrayOfInt, int paramInt)
    throws IOException
  {
    if ((paramArrayOfInt != null) && (!org.bouncycastle.util.a.p(paramArrayOfInt, paramInt))) {
      throw new TlsFatalAlert((short)47);
    }
  }
  
  public static boolean e(int[] paramArrayOfInt)
  {
    for (int i = 0; i < paramArrayOfInt.length; i++) {
      if (q(paramArrayOfInt[i])) {
        return true;
      }
    }
    return false;
  }
  
  public static byte[] f(int[] paramArrayOfInt)
    throws IOException
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length >= 1)) {
      return m1.s(paramArrayOfInt);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static byte[] g(short[] paramArrayOfShort)
    throws IOException
  {
    short[] arrayOfShort;
    if (paramArrayOfShort != null)
    {
      arrayOfShort = paramArrayOfShort;
      if (org.bouncycastle.util.a.q(paramArrayOfShort, (short)0)) {}
    }
    else
    {
      arrayOfShort = org.bouncycastle.util.a.b(paramArrayOfShort, (short)0);
    }
    return m1.t(arrayOfShort);
  }
  
  public static BigInteger h(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    paramInt = (paramInt + 7) / 8;
    if (paramArrayOfByte.length == paramInt) {
      return new BigInteger(1, paramArrayOfByte);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public static h i(short[] paramArrayOfShort, e.a.b.a.d paramd, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      int i = paramArrayOfByte.length;
      short s1 = 1;
      if (i >= 1)
      {
        i = paramArrayOfByte[0];
        short s2;
        if ((i != 2) && (i != 3))
        {
          if (i == 4)
          {
            s1 = 0;
            s2 = s1;
          }
          else
          {
            throw new TlsFatalAlert((short)47);
          }
        }
        else if (e.a.b.a.b.g(paramd))
        {
          s1 = 2;
          s2 = s1;
        }
        else
        {
          if (!e.a.b.a.b.i(paramd)) {
            break label119;
          }
          s2 = s1;
        }
        if ((s2 != 0) && ((paramArrayOfShort == null) || (!org.bouncycastle.util.a.q(paramArrayOfShort, s2)))) {
          throw new TlsFatalAlert((short)47);
        }
        return paramd.k(paramArrayOfByte);
        label119:
        throw new TlsFatalAlert((short)47);
      }
    }
    throw new TlsFatalAlert((short)47);
  }
  
  public static s j(short[] paramArrayOfShort, n paramn, byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfShort = new s(i(paramArrayOfShort, paramn.a(), paramArrayOfByte), paramn);
      return paramArrayOfShort;
    }
    catch (RuntimeException paramArrayOfShort)
    {
      throw new TlsFatalAlert((short)47, paramArrayOfShort);
    }
  }
  
  public static org.bouncycastle.crypto.b k(SecureRandom paramSecureRandom, n paramn)
  {
    c localc = new c();
    localc.c(new o(paramn, paramSecureRandom));
    return localc.b();
  }
  
  public static org.bouncycastle.crypto.w.r l(SecureRandom paramSecureRandom, short[] paramArrayOfShort, n paramn, OutputStream paramOutputStream)
    throws IOException
  {
    paramSecureRandom = k(paramSecureRandom, paramn);
    A(paramArrayOfShort, ((s)paramSecureRandom.b()).c(), paramOutputStream);
    return (org.bouncycastle.crypto.w.r)paramSecureRandom.a();
  }
  
  public static String m(int paramInt)
  {
    String str;
    if (r(paramInt)) {
      str = c[(paramInt - 1)];
    } else {
      str = null;
    }
    return str;
  }
  
  public static n n(int paramInt)
  {
    String str = m(paramInt);
    if (str == null) {
      return null;
    }
    j localj1 = org.bouncycastle.crypto.q.a.h(str);
    j localj2 = localj1;
    if (localj1 == null)
    {
      localj1 = e.b(str);
      localj2 = localj1;
      if (localj1 == null) {
        return null;
      }
    }
    return new n(localj2.f(), localj2.g(), localj2.j(), localj2.h(), localj2.k());
  }
  
  public static short[] o(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = m1.B(paramHashtable, b);
    if (paramHashtable == null) {
      paramHashtable = null;
    } else {
      paramHashtable = x(paramHashtable);
    }
    return paramHashtable;
  }
  
  public static boolean p(short[] paramArrayOfShort, short paramShort)
  {
    if (paramArrayOfShort == null) {
      return false;
    }
    for (int i = 0; i < paramArrayOfShort.length; i++)
    {
      short s = paramArrayOfShort[i];
      if (s == 0) {
        return false;
      }
      if (s == paramShort) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean q(int paramInt)
  {
    if (paramInt != 52396) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        return false;
                      }
                      break;
                    }
                    break;
                  }
                  break;
                }
                break;
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
    }
    return true;
  }
  
  public static boolean r(int paramInt)
  {
    boolean bool;
    if ((paramInt > 0) && (paramInt <= c.length)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static int s(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = u(paramInputStream);
    if (paramInputStream.bitLength() < 32)
    {
      int i = paramInputStream.intValue();
      if ((i > 0) && (i < paramInt)) {
        return i;
      }
    }
    throw new TlsFatalAlert((short)47);
  }
  
  public static BigInteger t(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    return h(paramInt, m1.c0(paramInputStream));
  }
  
  public static BigInteger u(InputStream paramInputStream)
    throws IOException
  {
    return new BigInteger(1, m1.c0(paramInputStream));
  }
  
  public static n v(int[] paramArrayOfInt, short[] paramArrayOfShort, InputStream paramInputStream)
    throws IOException
  {
    try
    {
      int i = m1.j0(paramInputStream);
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            i = m1.d0(paramInputStream);
            if (u.a(i))
            {
              d(paramArrayOfInt, i);
              return n(i);
            }
            paramArrayOfInt = new org/bouncycastle/crypto/tls/TlsFatalAlert;
            paramArrayOfInt.<init>((short)47);
            throw paramArrayOfInt;
          }
          paramArrayOfInt = new org/bouncycastle/crypto/tls/TlsFatalAlert;
          paramArrayOfInt.<init>((short)47);
          throw paramArrayOfInt;
        }
        d(paramArrayOfInt, 65282);
        int j = m1.d0(paramInputStream);
        short s = m1.j0(paramInputStream);
        if (r.a(s))
        {
          int k = s(j, paramInputStream);
          int m;
          if (s == 2)
          {
            m = s(j, paramInputStream);
            i = s(j, paramInputStream);
          }
          else
          {
            m = -1;
            i = -1;
          }
          localBigInteger1 = t(j, paramInputStream);
          localBigInteger2 = t(j, paramInputStream);
          localObject1 = m1.c0(paramInputStream);
          localObject2 = u(paramInputStream);
          paramInputStream = u(paramInputStream);
          if (s == 2)
          {
            paramArrayOfInt = new e/a/b/a/d$e;
            paramArrayOfInt.<init>(j, k, m, i, localBigInteger1, localBigInteger2, (BigInteger)localObject2, paramInputStream);
          }
          else
          {
            paramArrayOfInt = new d.e(j, k, localBigInteger1, localBigInteger2, (BigInteger)localObject2, paramInputStream);
          }
          return new n(paramArrayOfInt, i(paramArrayOfShort, paramArrayOfInt, (byte[])localObject1), (BigInteger)localObject2, paramInputStream);
        }
        paramArrayOfInt = new org/bouncycastle/crypto/tls/TlsFatalAlert;
        paramArrayOfInt.<init>((short)47);
        throw paramArrayOfInt;
      }
      d(paramArrayOfInt, 65281);
      BigInteger localBigInteger1 = u(paramInputStream);
      paramArrayOfInt = t(localBigInteger1.bitLength(), paramInputStream);
      BigInteger localBigInteger2 = t(localBigInteger1.bitLength(), paramInputStream);
      Object localObject2 = m1.c0(paramInputStream);
      Object localObject1 = u(paramInputStream);
      paramInputStream = u(paramInputStream);
      d.f localf = new e/a/b/a/d$f;
      localf.<init>(localBigInteger1, paramArrayOfInt, localBigInteger2, (BigInteger)localObject1, paramInputStream);
      paramArrayOfInt = new n(localf, i(paramArrayOfShort, localf, (byte[])localObject2), (BigInteger)localObject1, paramInputStream);
      return paramArrayOfInt;
    }
    catch (RuntimeException paramArrayOfInt)
    {
      throw new TlsFatalAlert((short)47, paramArrayOfInt);
    }
  }
  
  public static int[] w(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      int i = m1.d0(paramArrayOfByte);
      if ((i >= 2) && ((i & 0x1) == 0))
      {
        int[] arrayOfInt = m1.f0(i / 2, paramArrayOfByte);
        g1.c(paramArrayOfByte);
        return arrayOfInt;
      }
      throw new TlsFatalAlert((short)50);
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static short[] x(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      int i = m1.j0(localByteArrayInputStream);
      if (i >= 1)
      {
        paramArrayOfByte = m1.l0(i, localByteArrayInputStream);
        g1.c(localByteArrayInputStream);
        if (org.bouncycastle.util.a.q(paramArrayOfByte, (short)0)) {
          return paramArrayOfByte;
        }
        throw new TlsFatalAlert((short)47);
      }
      throw new TlsFatalAlert((short)50);
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static byte[] y(short[] paramArrayOfShort, h paramh)
    throws IOException
  {
    e.a.b.a.d locald = paramh.i();
    short s1;
    if (e.a.b.a.b.i(locald)) {
      s1 = 1;
    }
    for (short s2 = s1;; s2 = s1)
    {
      bool = p(paramArrayOfShort, s2);
      break label46;
      if (!e.a.b.a.b.g(locald)) {
        break;
      }
      s1 = 2;
    }
    boolean bool = false;
    label46:
    return paramh.l(bool);
  }
  
  public static s z(s params)
    throws IOException
  {
    return params;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\s0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */