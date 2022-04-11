package org.bouncycastle.crypto.u.g;

import e.a.b.c.a;
import org.bouncycastle.util.f;

public abstract class d
{
  public static void a(long[] paramArrayOfLong, byte[] paramArrayOfByte)
  {
    f.m(paramArrayOfLong, paramArrayOfByte, 0);
  }
  
  public static void b(byte[] paramArrayOfByte, long[] paramArrayOfLong)
  {
    f.c(paramArrayOfByte, 0, paramArrayOfLong);
  }
  
  public static long[] c(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong = new long[2];
    f.c(paramArrayOfByte, 0, arrayOfLong);
    return arrayOfLong;
  }
  
  public static void d(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = l1 >> 63;
    paramArrayOfLong2[0] = ((l1 ^ 0xE100000000000000 & l3) << 1 | l2 >>> 63);
    paramArrayOfLong2[1] = (l2 << 1 | -l3);
  }
  
  public static void e(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    long[] arrayOfLong = c(paramArrayOfByte1);
    f(arrayOfLong, c(paramArrayOfByte2));
    a(arrayOfLong, paramArrayOfByte1);
  }
  
  public static void f(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    int i = 0;
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong2[0];
    long l4 = paramArrayOfLong2[1];
    long l5 = 0L;
    long l6 = 0L;
    long l7 = l6;
    while (i < 64)
    {
      long l8 = l1 >> 63;
      l1 <<= 1;
      l5 ^= l3 & l8;
      long l9 = l2 >> 63;
      l2 <<= 1;
      l7 = l7 ^ l4 & l8 ^ l3 & l9;
      l6 ^= l4 & l9;
      l8 = l4 >>> 1 | l3 << 63;
      l3 = l3 >>> 1 ^ l4 << 63 >> 8 & 0xE100000000000000;
      i++;
      l4 = l8;
    }
    paramArrayOfLong1[0] = (l6 >>> 1 ^ l6 ^ l6 >>> 2 ^ l6 >>> 7 ^ l5);
    paramArrayOfLong1[1] = (l6 << 63 ^ l6 << 62 ^ l6 << 57 ^ l7);
  }
  
  public static void g(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = l2 << 57;
    paramArrayOfLong2[0] = (l3 >>> 7 ^ l1 >>> 7 ^ l3 ^ l3 >>> 1 ^ l3 >>> 2);
    paramArrayOfLong2[1] = (l1 << 57 | l2 >>> 7);
  }
  
  public static long[] h()
  {
    long[] arrayOfLong = new long[2];
    arrayOfLong[0] = Long.MIN_VALUE;
    return arrayOfLong;
  }
  
  public static void i(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = new long[4];
    a.d(paramArrayOfLong1[0], arrayOfLong, 0);
    a.d(paramArrayOfLong1[1], arrayOfLong, 2);
    long l1 = arrayOfLong[0];
    long l2 = arrayOfLong[1];
    long l3 = arrayOfLong[2];
    long l4 = arrayOfLong[3];
    l3 ^= l4 << 57 ^ l4 << 63 ^ l4 << 62;
    paramArrayOfLong2[0] = (l1 ^ l3 >>> 1 ^ l3 ^ l3 >>> 2 ^ l3 >>> 7);
    paramArrayOfLong2[1] = (l2 ^ l4 >>> 1 ^ l4 ^ l4 >>> 2 ^ l4 >>> 7 ^ l3 << 57 ^ l3 << 63 ^ l3 << 62);
  }
  
  public static void j(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      
      if (paramInt3 < 0) {
        break;
      }
      int i = paramInt1 + paramInt3;
      paramArrayOfByte1[i] = ((byte)(byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[(paramInt2 + paramInt3)]));
    }
  }
  
  public static void k(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3, int paramInt3)
  {
    int i = 0;
    int j;
    do
    {
      paramArrayOfByte3[(paramInt3 + i)] = ((byte)(byte)(paramArrayOfByte1[(paramInt1 + i)] ^ paramArrayOfByte2[(paramInt2 + i)]));
      i++;
      paramArrayOfByte3[(paramInt3 + i)] = ((byte)(byte)(paramArrayOfByte1[(paramInt1 + i)] ^ paramArrayOfByte2[(paramInt2 + i)]));
      i++;
      paramArrayOfByte3[(paramInt3 + i)] = ((byte)(byte)(paramArrayOfByte1[(paramInt1 + i)] ^ paramArrayOfByte2[(paramInt2 + i)]));
      i++;
      paramArrayOfByte3[(paramInt3 + i)] = ((byte)(byte)(paramArrayOfByte1[(paramInt1 + i)] ^ paramArrayOfByte2[(paramInt2 + i)]));
      j = i + 1;
      i = j;
    } while (j < 16);
  }
  
  public static void l(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    int j;
    do
    {
      paramArrayOfByte1[i] = ((byte)(byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i++;
      paramArrayOfByte1[i] = ((byte)(byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i++;
      paramArrayOfByte1[i] = ((byte)(byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i++;
      paramArrayOfByte1[i] = ((byte)(byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      j = i + 1;
      i = j;
    } while (j < 16);
  }
  
  public static void m(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    int i = 0;
    int j;
    do
    {
      paramArrayOfByte1[i] = ((byte)(byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[(paramInt + i)]));
      i++;
      paramArrayOfByte1[i] = ((byte)(byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[(paramInt + i)]));
      i++;
      paramArrayOfByte1[i] = ((byte)(byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[(paramInt + i)]));
      i++;
      paramArrayOfByte1[i] = ((byte)(byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[(paramInt + i)]));
      j = i + 1;
      i = j;
    } while (j < 16);
  }
  
  public static void n(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      
      if (paramInt2 < 0) {
        break;
      }
      paramArrayOfByte1[paramInt2] = ((byte)(byte)(paramArrayOfByte1[paramInt2] ^ paramArrayOfByte2[(paramInt1 + paramInt2)]));
    }
  }
  
  public static void o(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    long l = paramArrayOfLong1[1];
    paramArrayOfLong2[1] ^= l;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\u\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */