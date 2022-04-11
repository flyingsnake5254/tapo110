package com.google.common.primitives;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;

public final class j
{
  public static int a(long paramLong1, long paramLong2)
  {
    return e.c(c(paramLong1), c(paramLong2));
  }
  
  public static long b(long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L)
    {
      if (a(paramLong1, paramLong2) < 0) {
        return 0L;
      }
      return 1L;
    }
    if (paramLong1 >= 0L) {
      return paramLong1 / paramLong2;
    }
    int i = 1;
    long l = (paramLong1 >>> 1) / paramLong2 << 1;
    if (a(paramLong1 - l * paramLong2, paramLong2) < 0) {
      i = 0;
    }
    return l + i;
  }
  
  private static long c(long paramLong)
  {
    return paramLong ^ 0x8000000000000000;
  }
  
  @CanIgnoreReturnValue
  public static long d(String paramString, int paramInt)
  {
    n.o(paramString);
    if (paramString.length() != 0)
    {
      if ((paramInt >= 2) && (paramInt <= 36))
      {
        int i = a.c[paramInt];
        long l = 0L;
        int j = 0;
        while (j < paramString.length())
        {
          int k = Character.digit(paramString.charAt(j), paramInt);
          if (k != -1)
          {
            if ((j > i - 1) && (a.a(l, k, paramInt)))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Too large for unsigned long: ");
              localStringBuilder.append(paramString);
              throw new NumberFormatException(localStringBuilder.toString());
            }
            l = l * paramInt + k;
            j++;
          }
          else
          {
            throw new NumberFormatException(paramString);
          }
        }
        return l;
      }
      paramString = new StringBuilder();
      paramString.append("illegal radix: ");
      paramString.append(paramInt);
      throw new NumberFormatException(paramString.toString());
    }
    throw new NumberFormatException("empty string");
  }
  
  public static long e(long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L)
    {
      if (a(paramLong1, paramLong2) < 0) {
        return paramLong1;
      }
      return paramLong1 - paramLong2;
    }
    if (paramLong1 >= 0L) {
      return paramLong1 % paramLong2;
    }
    paramLong1 -= ((paramLong1 >>> 1) / paramLong2 << 1) * paramLong2;
    if (a(paramLong1, paramLong2) < 0) {
      paramLong2 = 0L;
    }
    return paramLong1 - paramLong2;
  }
  
  public static String f(long paramLong)
  {
    return g(paramLong, 10);
  }
  
  public static String g(long paramLong, int paramInt)
  {
    boolean bool1;
    if ((paramInt >= 2) && (paramInt <= 36)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    n.f(bool1, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", paramInt);
    boolean bool2 = paramLong < 0L;
    if (!bool2) {
      return "0";
    }
    if (bool2) {
      return Long.toString(paramLong, paramInt);
    }
    int i = 64;
    char[] arrayOfChar = new char[64];
    int j = paramInt - 1;
    int m;
    long l1;
    if ((paramInt & j) == 0)
    {
      int k = Integer.numberOfTrailingZeros(paramInt);
      do
      {
        m = i - 1;
        arrayOfChar[m] = Character.forDigit((int)paramLong & j, paramInt);
        l1 = paramLong >>> k;
        i = m;
        paramLong = l1;
      } while (l1 != 0L);
    }
    else
    {
      if ((paramInt & 0x1) == 0) {
        l1 = (paramLong >>> 1) / (paramInt >>> 1);
      } else {
        l1 = b(paramLong, paramInt);
      }
      long l2 = paramInt;
      arrayOfChar[63] = Character.forDigit((int)(paramLong - l1 * l2), paramInt);
      i = 63;
      for (;;)
      {
        m = i;
        if (l1 <= 0L) {
          break;
        }
        i--;
        arrayOfChar[i] = Character.forDigit((int)(l1 % l2), paramInt);
        l1 /= l2;
      }
    }
    return new String(arrayOfChar, m, 64 - m);
  }
  
  private static final class a
  {
    static final long[] a = new long[37];
    static final int[] b = new int[37];
    static final int[] c = new int[37];
    
    static
    {
      BigInteger localBigInteger = new BigInteger("10000000000000000", 16);
      for (int i = 2; i <= 36; i++)
      {
        long[] arrayOfLong = a;
        long l = i;
        arrayOfLong[i] = j.b(-1L, l);
        b[i] = ((int)j.e(-1L, l));
        c[i] = (localBigInteger.toString(i).length() - 1);
      }
    }
    
    static boolean a(long paramLong, int paramInt1, int paramInt2)
    {
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (paramLong >= 0L)
      {
        long[] arrayOfLong = a;
        if (paramLong < arrayOfLong[paramInt2]) {
          return false;
        }
        if (paramLong > arrayOfLong[paramInt2]) {
          return true;
        }
        if (paramInt1 > b[paramInt2]) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
      }
      return bool2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\primitives\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */