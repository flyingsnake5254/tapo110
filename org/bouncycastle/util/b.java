package org.bouncycastle.util;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class b
{
  private static final BigInteger a = BigInteger.valueOf(0L);
  
  public static byte[] a(int paramInt, BigInteger paramBigInteger)
  {
    byte[] arrayOfByte = paramBigInteger.toByteArray();
    if (arrayOfByte.length == paramInt) {
      return arrayOfByte;
    }
    int i = 0;
    if (arrayOfByte[0] == 0) {
      i = 1;
    }
    int j = arrayOfByte.length - i;
    if (j <= paramInt)
    {
      paramBigInteger = new byte[paramInt];
      System.arraycopy(arrayOfByte, i, paramBigInteger, paramInt - j, j);
      return paramBigInteger;
    }
    throw new IllegalArgumentException("standard length exceeded for value");
  }
  
  public static byte[] b(BigInteger paramBigInteger)
  {
    byte[] arrayOfByte = paramBigInteger.toByteArray();
    if (arrayOfByte[0] == 0)
    {
      int i = arrayOfByte.length - 1;
      paramBigInteger = new byte[i];
      System.arraycopy(arrayOfByte, 1, paramBigInteger, 0, i);
      return paramBigInteger;
    }
    return arrayOfByte;
  }
  
  public static BigInteger c(BigInteger paramBigInteger1, BigInteger paramBigInteger2, SecureRandom paramSecureRandom)
  {
    int i = paramBigInteger1.compareTo(paramBigInteger2);
    if (i >= 0)
    {
      if (i <= 0) {
        return paramBigInteger1;
      }
      throw new IllegalArgumentException("'min' may not be greater than 'max'");
    }
    if (paramBigInteger1.bitLength() > paramBigInteger2.bitLength() / 2) {
      return c(a, paramBigInteger2.subtract(paramBigInteger1), paramSecureRandom).add(paramBigInteger1);
    }
    for (i = 0; i < 1000; i++)
    {
      BigInteger localBigInteger = new BigInteger(paramBigInteger2.bitLength(), paramSecureRandom);
      if ((localBigInteger.compareTo(paramBigInteger1) >= 0) && (localBigInteger.compareTo(paramBigInteger2) <= 0)) {
        return localBigInteger;
      }
    }
    return new BigInteger(paramBigInteger2.subtract(paramBigInteger1).bitLength() - 1, paramSecureRandom).add(paramBigInteger1);
  }
  
  public static BigInteger d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte;
    if (paramInt1 == 0)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramInt2 == paramArrayOfByte.length) {}
    }
    else
    {
      arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    }
    return new BigInteger(1, arrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */