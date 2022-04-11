package e.a.b.c;

import java.math.BigInteger;
import org.bouncycastle.util.f;

public abstract class h
{
  public static void a(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2)
  {
    paramArrayOfLong2[(paramInt2 + 0)] = paramArrayOfLong1[(paramInt1 + 0)];
    paramArrayOfLong2[(paramInt2 + 1)] = paramArrayOfLong1[(paramInt1 + 1)];
    paramArrayOfLong2[(paramInt2 + 2)] = paramArrayOfLong1[(paramInt1 + 2)];
    paramArrayOfLong2[(paramInt2 + 3)] = paramArrayOfLong1[(paramInt1 + 3)];
    paramArrayOfLong2[(paramInt2 + 4)] = paramArrayOfLong1[(paramInt1 + 4)];
  }
  
  public static long[] b()
  {
    return new long[5];
  }
  
  public static long[] c()
  {
    return new long[10];
  }
  
  public static boolean d(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    for (int i = 4; i >= 0; i--) {
      if (paramArrayOfLong1[i] != paramArrayOfLong2[i]) {
        return false;
      }
    }
    return true;
  }
  
  public static long[] e(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 320))
    {
      long[] arrayOfLong = b();
      for (int i = 0; paramBigInteger.signum() != 0; i++)
      {
        arrayOfLong[i] = paramBigInteger.longValue();
        paramBigInteger = paramBigInteger.shiftRight(64);
      }
      return arrayOfLong;
    }
    throw new IllegalArgumentException();
  }
  
  public static boolean f(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong[0] != 1L) {
      return false;
    }
    for (int i = 1; i < 5; i++) {
      if (paramArrayOfLong[i] != 0L) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean g(long[] paramArrayOfLong)
  {
    for (int i = 0; i < 5; i++) {
      if (paramArrayOfLong[i] != 0L) {
        return false;
      }
    }
    return true;
  }
  
  public static BigInteger h(long[] paramArrayOfLong)
  {
    byte[] arrayOfByte = new byte[40];
    for (int i = 0; i < 5; i++)
    {
      long l = paramArrayOfLong[i];
      if (l != 0L) {
        f.l(l, arrayOfByte, 4 - i << 3);
      }
    }
    return new BigInteger(1, arrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */