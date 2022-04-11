package org.bouncycastle.crypto.s;

import e.a.b.a.w;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.w.e;

class b
{
  static final b a = new b();
  private static final BigInteger b = BigInteger.valueOf(1L);
  private static final BigInteger c = BigInteger.valueOf(2L);
  
  BigInteger a(e parame, SecureRandom paramSecureRandom)
  {
    int i = parame.d();
    if (i != 0)
    {
      do
      {
        parame = new BigInteger(i, paramSecureRandom).setBit(i - 1);
      } while (w.g(parame) < i >>> 2);
      return parame;
    }
    BigInteger localBigInteger1 = c;
    i = parame.e();
    BigInteger localBigInteger2;
    if (i != 0) {
      localBigInteger2 = b.shiftLeft(i - 1);
    } else {
      localBigInteger2 = localBigInteger1;
    }
    BigInteger localBigInteger3 = parame.g();
    BigInteger localBigInteger4 = localBigInteger3;
    if (localBigInteger3 == null) {
      localBigInteger4 = parame.f();
    }
    parame = localBigInteger4.subtract(localBigInteger1);
    i = parame.bitLength();
    do
    {
      localBigInteger4 = org.bouncycastle.util.b.c(localBigInteger2, parame, paramSecureRandom);
    } while (w.g(localBigInteger4) < i >>> 2);
    return localBigInteger4;
  }
  
  BigInteger b(e parame, BigInteger paramBigInteger)
  {
    return parame.b().modPow(paramBigInteger, parame.f());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\s\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */