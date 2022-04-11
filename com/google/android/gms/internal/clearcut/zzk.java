package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzk
{
  private static int zza(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  private static long zza(long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong1 = (paramLong1 ^ paramLong2) * paramLong3;
    paramLong1 = (paramLong1 ^ paramLong1 >>> 47 ^ paramLong2) * paramLong3;
    return (paramLong1 ^ paramLong1 >>> 47) * paramLong3;
  }
  
  public static long zza(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    if ((i >= 0) && (i <= paramArrayOfByte.length))
    {
      long l4;
      long l5;
      if (i <= 32)
      {
        if (i <= 16)
        {
          if (i >= 8)
          {
            l1 = (i << 1) - 7286425919675154353L;
            l2 = zzb(paramArrayOfByte, 0) - 7286425919675154353L;
            l3 = zzb(paramArrayOfByte, i + 0 - 8);
            return zza(Long.rotateRight(l3, 37) * l1 + l2, (Long.rotateRight(l2, 25) + l3) * l1, l1);
          }
          if (i >= 4)
          {
            l2 = i << 1;
            l3 = zza(paramArrayOfByte, 0);
            return zza(i + ((l3 & 0xFFFFFFFF) << 3), zza(paramArrayOfByte, i + 0 - 4) & 0xFFFFFFFF, l2 - 7286425919675154353L);
          }
          if (i > 0)
          {
            j = paramArrayOfByte[0];
            k = paramArrayOfByte[((i >> 1) + 0)];
            m = paramArrayOfByte[(i - 1 + 0)];
            l3 = ((j & 0xFF) + ((k & 0xFF) << 8)) * -7286425919675154353L ^ (i + ((m & 0xFF) << 2)) * -4348849565147123417L;
            return (l3 ^ l3 >>> 47) * -7286425919675154353L;
          }
          return -7286425919675154353L;
        }
        l1 = (i << 1) - 7286425919675154353L;
        l4 = zzb(paramArrayOfByte, 0) * -5435081209227447693L;
        l3 = zzb(paramArrayOfByte, 8);
        k = i + 0;
        l2 = zzb(paramArrayOfByte, k - 8) * l1;
        l5 = zzb(paramArrayOfByte, k - 16);
        return zza(Long.rotateRight(l4 + l3, 43) + Long.rotateRight(l2, 30) + l5 * -7286425919675154353L, l4 + Long.rotateRight(l3 - 7286425919675154353L, 18) + l2, l1);
      }
      if (i <= 64)
      {
        l3 = (i << 1) - 7286425919675154353L;
        l2 = zzb(paramArrayOfByte, 0) * -7286425919675154353L;
        l5 = zzb(paramArrayOfByte, 8);
        k = i + 0;
        l1 = zzb(paramArrayOfByte, k - 8) * l3;
        l4 = zzb(paramArrayOfByte, k - 16);
        l4 = Long.rotateRight(l2 + l5, 43) + Long.rotateRight(l1, 30) + l4 * -7286425919675154353L;
        l1 = zza(l4, Long.rotateRight(-7286425919675154353L + l5, 18) + l2 + l1, l3);
        l5 = zzb(paramArrayOfByte, 16) * l3;
        long l6 = zzb(paramArrayOfByte, 24);
        l4 = (l4 + zzb(paramArrayOfByte, k - 32)) * l3;
        long l7 = zzb(paramArrayOfByte, k - 24);
        return zza(Long.rotateRight(l5 + l6, 43) + Long.rotateRight(l4, 30) + (l1 + l7) * l3, l5 + Long.rotateRight(l6 + l2, 18) + l4, l3);
      }
      long l2 = 2480279821605975764L;
      long l3 = 1390051526045402406L;
      long[] arrayOfLong1 = new long[2];
      long[] arrayOfLong2 = new long[2];
      long l1 = zzb(paramArrayOfByte, 0) + 95310865018149119L;
      int j = i - 1;
      int k = (j / 64 << 6) + 0;
      j &= 0x3F;
      i = k + j - 63;
      int m = 0;
      for (;;)
      {
        l4 = Long.rotateRight(l1 + l2 + arrayOfLong1[0] + zzb(paramArrayOfByte, m + 8), 37);
        l1 = Long.rotateRight(l2 + arrayOfLong1[1] + zzb(paramArrayOfByte, m + 48), 42);
        l2 = l4 * -5435081209227447693L ^ arrayOfLong2[1];
        l1 = l1 * -5435081209227447693L + (arrayOfLong1[0] + zzb(paramArrayOfByte, m + 40));
        l4 = Long.rotateRight(l3 + arrayOfLong2[0], 33) * -5435081209227447693L;
        zza(paramArrayOfByte, m, arrayOfLong1[1] * -5435081209227447693L, l2 + arrayOfLong2[0], arrayOfLong1);
        zza(paramArrayOfByte, m + 32, l4 + arrayOfLong2[1], l1 + zzb(paramArrayOfByte, m + 16), arrayOfLong2);
        m += 64;
        if (m == k)
        {
          l3 = ((0xFF & l2) << 1) - 5435081209227447693L;
          arrayOfLong2[0] += j;
          arrayOfLong1[0] += arrayOfLong2[0];
          arrayOfLong2[0] += arrayOfLong1[0];
          l5 = Long.rotateRight(l4 + l1 + arrayOfLong1[0] + zzb(paramArrayOfByte, i + 8), 37);
          l4 = Long.rotateRight(l1 + arrayOfLong1[1] + zzb(paramArrayOfByte, i + 48), 42);
          l1 = l5 * l3 ^ arrayOfLong2[1] * 9L;
          l4 = l4 * l3 + (arrayOfLong1[0] * 9L + zzb(paramArrayOfByte, i + 40));
          l2 = Long.rotateRight(l2 + arrayOfLong2[0], 33) * l3;
          zza(paramArrayOfByte, i, arrayOfLong1[1] * l3, l1 + arrayOfLong2[0], arrayOfLong1);
          zza(paramArrayOfByte, i + 32, arrayOfLong2[1] + l2, zzb(paramArrayOfByte, i + 16) + l4, arrayOfLong2);
          return zza(zza(arrayOfLong1[0], arrayOfLong2[0], l3) + (l4 >>> 47 ^ l4) * -4348849565147123417L + l1, zza(arrayOfLong1[1], arrayOfLong2[1], l3) + l2, l3);
        }
        l3 = l2;
        l2 = l1;
        l1 = l4;
      }
    }
    paramArrayOfByte = new StringBuilder(67);
    paramArrayOfByte.append("Out of bound index with offput: 0 and length: ");
    paramArrayOfByte.append(i);
    throw new IndexOutOfBoundsException(paramArrayOfByte.toString());
  }
  
  private static void zza(byte[] paramArrayOfByte, int paramInt, long paramLong1, long paramLong2, long[] paramArrayOfLong)
  {
    long l1 = zzb(paramArrayOfByte, paramInt);
    long l2 = zzb(paramArrayOfByte, paramInt + 8);
    long l3 = zzb(paramArrayOfByte, paramInt + 16);
    long l4 = zzb(paramArrayOfByte, paramInt + 24);
    paramLong1 += l1;
    paramLong2 = Long.rotateRight(paramLong2 + paramLong1 + l4, 21);
    l3 = l2 + paramLong1 + l3;
    l2 = Long.rotateRight(l3, 44);
    paramArrayOfLong[0] = (l3 + l4);
    paramArrayOfLong[1] = (paramLong2 + l2 + paramLong1);
  }
  
  private static long zzb(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt, 8);
    paramArrayOfByte.order(ByteOrder.LITTLE_ENDIAN);
    return paramArrayOfByte.getLong();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */