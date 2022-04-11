package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;

final class zzff
{
  private static final zzfg zzqb;
  
  static
  {
    int i;
    if ((zzfd.zzed()) && (zzfd.zzee())) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject;
    if (i != 0) {
      localObject = new zzfj();
    } else {
      localObject = new zzfh();
    }
    zzqb = (zzfg)localObject;
  }
  
  static int zza(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    int j = 0;
    for (int k = 0; (k < i) && (paramCharSequence.charAt(k) < ''); k++) {}
    int m = i;
    for (;;)
    {
      n = m;
      if (k >= i) {
        break label213;
      }
      n = paramCharSequence.charAt(k);
      if (n >= 2048) {
        break;
      }
      m += (127 - n >>> 31);
      k++;
    }
    int i1 = paramCharSequence.length();
    int n = j;
    while (k < i1)
    {
      int i2 = paramCharSequence.charAt(k);
      if (i2 < 2048)
      {
        n += (127 - i2 >>> 31);
        j = k;
      }
      else
      {
        int i3 = n + 2;
        n = i3;
        j = k;
        if (55296 <= i2)
        {
          n = i3;
          j = k;
          if (i2 <= 57343) {
            if (Character.codePointAt(paramCharSequence, k) >= 65536)
            {
              j = k + 1;
              n = i3;
            }
            else
            {
              throw new zzfi(k, i1);
            }
          }
        }
      }
      k = j + 1;
    }
    n = m + n;
    label213:
    if (n >= i) {
      return n;
    }
    long l = n;
    paramCharSequence = new StringBuilder(54);
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(l + 4294967296L);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  static int zza(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zzqb.zzb(paramCharSequence, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    zzfg localzzfg = zzqb;
    if (paramByteBuffer.hasArray())
    {
      int i = paramByteBuffer.arrayOffset();
      paramByteBuffer.position(zza(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.position() + i, paramByteBuffer.remaining()) - i);
      return;
    }
    if (paramByteBuffer.isDirect())
    {
      localzzfg.zzb(paramCharSequence, paramByteBuffer);
      return;
    }
    zzfg.zzc(paramCharSequence, paramByteBuffer);
  }
  
  private static int zzam(int paramInt)
  {
    int i = paramInt;
    if (paramInt > -12) {
      i = -1;
    }
    return i;
  }
  
  private static int zzd(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65) && (paramInt3 <= -65)) {
      return paramInt1 ^ paramInt2 << 8 ^ paramInt3 << 16;
    }
    return -1;
  }
  
  public static boolean zze(byte[] paramArrayOfByte)
  {
    return zzqb.zze(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static boolean zze(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zzqb.zze(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static int zzf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[(paramInt1 - 1)];
    paramInt2 -= paramInt1;
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          return zzd(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
        }
        throw new AssertionError();
      }
      return zzp(i, paramArrayOfByte[paramInt1]);
    }
    return zzam(i);
  }
  
  private static int zzp(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65)) {
      return paramInt1 ^ paramInt2 << 8;
    }
    return -1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */