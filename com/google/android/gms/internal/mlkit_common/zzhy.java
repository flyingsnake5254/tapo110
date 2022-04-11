package com.google.android.gms.internal.mlkit_common;

final class zzhy
{
  private static final zzhx zza;
  
  static
  {
    int i;
    if ((zzhw.zza()) && (zzhw.zzb())) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject;
    if ((i != 0) && (!zzdt.zza())) {
      localObject = new zzic();
    } else {
      localObject = new zzia();
    }
    zza = (zzhx)localObject;
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
              throw new zzhz(k, i1);
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
    return zza.zza(paramCharSequence, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static boolean zza(byte[] paramArrayOfByte)
  {
    return zza.zza(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static boolean zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zza.zza(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static int zzb(int paramInt)
  {
    int i = paramInt;
    if (paramInt > -12) {
      i = -1;
    }
    return i;
  }
  
  private static int zzb(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65)) {
      return paramInt1 ^ paramInt2 << 8;
    }
    return -1;
  }
  
  private static int zzb(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65) && (paramInt3 <= -65)) {
      return paramInt1 ^ paramInt2 << 8 ^ paramInt3 << 16;
    }
    return -1;
  }
  
  private static int zzc(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[(paramInt1 - 1)];
    paramInt2 -= paramInt1;
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          return zzb(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
        }
        throw new AssertionError();
      }
      return zzb(i, paramArrayOfByte[paramInt1]);
    }
    return zzb(i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzhy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */