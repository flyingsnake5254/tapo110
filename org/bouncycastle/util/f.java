package org.bouncycastle.util;

public abstract class f
{
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[j];
    j++;
    int k = paramArrayOfByte[j];
    return paramArrayOfByte[(j + 1)] & 0xFF | i << 24 | (paramInt & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public static long b(byte[] paramArrayOfByte, int paramInt)
  {
    int i = a(paramArrayOfByte, paramInt);
    paramInt = a(paramArrayOfByte, paramInt + 4);
    long l = i;
    return paramInt & 0xFFFFFFFF | (l & 0xFFFFFFFF) << 32;
  }
  
  public static void c(byte[] paramArrayOfByte, int paramInt, long[] paramArrayOfLong)
  {
    for (int i = 0; i < paramArrayOfLong.length; i++)
    {
      paramArrayOfLong[i] = b(paramArrayOfByte, paramInt);
      paramInt += 8;
    }
  }
  
  public static void d(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 24));
    paramInt2++;
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 16));
    paramInt2++;
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(byte)paramInt1);
  }
  
  public static void e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(byte)paramInt1);
    paramInt2++;
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 8));
    paramInt2++;
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 16));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(byte)(paramInt1 >>> 24));
  }
  
  public static void f(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt)
  {
    for (int i = 0; i < paramArrayOfInt.length; i++)
    {
      e(paramArrayOfInt[i], paramArrayOfByte, paramInt);
      paramInt += 4;
    }
  }
  
  public static int g(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[j];
    int k = j + 1;
    j = paramArrayOfByte[k];
    return paramArrayOfByte[(k + 1)] << 24 | i & 0xFF | (paramInt & 0xFF) << 8 | (j & 0xFF) << 16;
  }
  
  public static void h(byte[] paramArrayOfByte, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    for (int i = 0; i < paramInt3; i++)
    {
      paramArrayOfInt[(paramInt2 + i)] = g(paramArrayOfByte, paramInt1);
      paramInt1 += 4;
    }
  }
  
  public static int[] i(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[paramInt2];
    for (int i = 0; i < paramInt2; i++)
    {
      arrayOfInt[i] = g(paramArrayOfByte, paramInt1);
      paramInt1 += 4;
    }
    return arrayOfInt;
  }
  
  public static long j(byte[] paramArrayOfByte, int paramInt)
  {
    int i = g(paramArrayOfByte, paramInt);
    return (g(paramArrayOfByte, paramInt + 4) & 0xFFFFFFFF) << 32 | i & 0xFFFFFFFF;
  }
  
  public static short k(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    return (short)((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | i & 0xFF);
  }
  
  public static void l(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    d((int)(paramLong >>> 32), paramArrayOfByte, paramInt);
    d((int)(paramLong & 0xFFFFFFFF), paramArrayOfByte, paramInt + 4);
  }
  
  public static void m(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = paramInt;
    for (paramInt = i; paramInt < paramArrayOfLong.length; paramInt++)
    {
      l(paramArrayOfLong[paramInt], paramArrayOfByte, j);
      j += 8;
    }
  }
  
  public static byte[] n(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    l(paramLong, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static void o(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    e((int)(0xFFFFFFFF & paramLong), paramArrayOfByte, paramInt);
    e((int)(paramLong >>> 32), paramArrayOfByte, paramInt + 4);
  }
  
  public static void p(long[] paramArrayOfLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    int i = 0;
    int j = paramInt3;
    for (paramInt3 = i; paramInt3 < paramInt2; paramInt3++)
    {
      o(paramArrayOfLong[(paramInt1 + paramInt3)], paramArrayOfByte, j);
      j += 8;
    }
  }
  
  public static byte[] q(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    o(paramLong, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static void r(short paramShort, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)(byte)paramShort);
    paramArrayOfByte[(paramInt + 1)] = ((byte)(byte)(paramShort >>> 8));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */