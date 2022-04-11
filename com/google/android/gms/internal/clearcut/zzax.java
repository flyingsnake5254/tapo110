package com.google.android.gms.internal.clearcut;

import java.io.IOException;

final class zzax
{
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzay paramzzay)
    throws zzco
  {
    if (paramInt1 >>> 3 != 0)
    {
      int i = paramInt1 & 0x7;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 5) {
                return paramInt2 + 4;
              }
              throw zzco.zzbm();
            }
            int j = paramInt1 & 0xFFFFFFF8 | 0x4;
            paramInt1 = 0;
            for (;;)
            {
              i = paramInt2;
              if (paramInt2 >= paramInt3) {
                break;
              }
              int k = zza(paramArrayOfByte, paramInt2, paramzzay);
              paramInt2 = paramzzay.zzfd;
              paramInt1 = paramInt2;
              i = k;
              if (paramInt2 == j) {
                break;
              }
              i = zza(paramInt2, paramArrayOfByte, k, paramInt3, paramzzay);
              paramInt1 = paramInt2;
              paramInt2 = i;
            }
            if ((i <= paramInt3) && (paramInt1 == j)) {
              return i;
            }
            throw zzco.zzbo();
          }
          return zza(paramArrayOfByte, paramInt2, paramzzay) + paramzzay.zzfd;
        }
        return paramInt2 + 8;
      }
      return zzb(paramArrayOfByte, paramInt2, paramzzay);
    }
    throw zzco.zzbm();
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzcn<?> paramzzcn, zzay paramzzay)
  {
    paramzzcn = (zzch)paramzzcn;
    int i;
    for (paramInt2 = zza(paramArrayOfByte, paramInt2, paramzzay);; paramInt2 = zza(paramArrayOfByte, i, paramzzay))
    {
      paramzzcn.zzac(paramzzay.zzfd);
      if (paramInt2 >= paramInt3) {
        break;
      }
      i = zza(paramArrayOfByte, paramInt2, paramzzay);
      if (paramInt1 != paramzzay.zzfd) {
        break;
      }
    }
    return paramInt2;
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzey paramzzey, zzay paramzzay)
    throws IOException
  {
    if (paramInt1 >>> 3 != 0)
    {
      int i = paramInt1 & 0x7;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 5)
              {
                paramzzey.zzb(paramInt1, Integer.valueOf(zzc(paramArrayOfByte, paramInt2)));
                return paramInt2 + 4;
              }
              throw zzco.zzbm();
            }
            zzey localzzey = zzey.zzeb();
            int j = paramInt1 & 0xFFFFFFF8 | 0x4;
            i = 0;
            for (;;)
            {
              k = i;
              i = paramInt2;
              if (paramInt2 >= paramInt3) {
                break label140;
              }
              k = zza(paramArrayOfByte, paramInt2, paramzzay);
              i = paramzzay.zzfd;
              paramInt2 = i;
              if (i == j) {
                break;
              }
              paramInt2 = zza(paramInt2, paramArrayOfByte, k, paramInt3, localzzey, paramzzay);
            }
            i = k;
            int k = paramInt2;
            label140:
            if ((i <= paramInt3) && (k == j))
            {
              paramzzey.zzb(paramInt1, localzzey);
              return i;
            }
            throw zzco.zzbo();
          }
          paramInt2 = zza(paramArrayOfByte, paramInt2, paramzzay);
          paramInt3 = paramzzay.zzfd;
          if (paramInt3 == 0) {
            paramArrayOfByte = zzbb.zzfi;
          } else {
            paramArrayOfByte = zzbb.zzb(paramArrayOfByte, paramInt2, paramInt3);
          }
          paramzzey.zzb(paramInt1, paramArrayOfByte);
          return paramInt2 + paramInt3;
        }
        paramzzey.zzb(paramInt1, Long.valueOf(zzd(paramArrayOfByte, paramInt2)));
        return paramInt2 + 8;
      }
      paramInt2 = zzb(paramArrayOfByte, paramInt2, paramzzay);
      paramzzey.zzb(paramInt1, Long.valueOf(paramzzay.zzfe));
      return paramInt2;
    }
    throw zzco.zzbm();
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, zzay paramzzay)
  {
    int i = paramInt1 & 0x7F;
    paramInt1 = paramInt2 + 1;
    paramInt2 = paramArrayOfByte[paramInt2];
    if (paramInt2 >= 0)
    {
      paramInt2 <<= 7;
      paramzzay.zzfd = (i | paramInt2);
      return paramInt1;
    }
    i |= (paramInt2 & 0x7F) << 7;
    int j = paramInt1 + 1;
    paramInt1 = paramArrayOfByte[paramInt1];
    if (paramInt1 >= 0)
    {
      paramInt2 = paramInt1 << 14;
      paramInt1 = j;
    }
    for (;;)
    {
      paramzzay.zzfd = (i | paramInt2);
      return paramInt1;
      i |= (paramInt1 & 0x7F) << 14;
      paramInt2 = j + 1;
      paramInt1 = paramArrayOfByte[j];
      if (paramInt1 >= 0)
      {
        j = paramInt1 << 21;
        paramInt1 = paramInt2;
        paramInt2 = j;
        break;
      }
      i |= (paramInt1 & 0x7F) << 21;
      paramInt1 = paramInt2 + 1;
      j = paramArrayOfByte[paramInt2];
      if (j < 0) {
        break label151;
      }
      paramInt2 = j << 28;
    }
    for (;;)
    {
      label151:
      paramInt2 = paramInt1 + 1;
      if (paramArrayOfByte[paramInt1] >= 0)
      {
        paramzzay.zzfd = (i | (j & 0x7F) << 28);
        return paramInt2;
      }
      paramInt1 = paramInt2;
    }
  }
  
  static int zza(byte[] paramArrayOfByte, int paramInt, zzay paramzzay)
  {
    int i = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    if (paramInt >= 0)
    {
      paramzzay.zzfd = paramInt;
      return i;
    }
    return zza(paramInt, paramArrayOfByte, i, paramzzay);
  }
  
  static int zza(byte[] paramArrayOfByte, int paramInt, zzcn<?> paramzzcn, zzay paramzzay)
    throws IOException
  {
    paramzzcn = (zzch)paramzzcn;
    paramInt = zza(paramArrayOfByte, paramInt, paramzzay);
    int i = paramzzay.zzfd + paramInt;
    while (paramInt < i)
    {
      paramInt = zza(paramArrayOfByte, paramInt, paramzzay);
      paramzzcn.zzac(paramzzay.zzfd);
    }
    if (paramInt == i) {
      return paramInt;
    }
    throw zzco.zzbl();
  }
  
  static int zzb(byte[] paramArrayOfByte, int paramInt, zzay paramzzay)
  {
    int i = paramInt + 1;
    long l = paramArrayOfByte[paramInt];
    if (l >= 0L)
    {
      paramzzay.zzfe = l;
      return i;
    }
    paramInt = i + 1;
    int j = paramArrayOfByte[i];
    l = l & 0x7F | (j & 0x7F) << 7;
    i = 7;
    while (j < 0)
    {
      j = paramArrayOfByte[paramInt];
      i += 7;
      l |= (j & 0x7F) << i;
      paramInt++;
    }
    paramzzay.zzfe = l;
    return paramInt;
  }
  
  static int zzc(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  static int zzc(byte[] paramArrayOfByte, int paramInt, zzay paramzzay)
  {
    int i = zza(paramArrayOfByte, paramInt, paramzzay);
    paramInt = paramzzay.zzfd;
    if (paramInt == 0)
    {
      paramzzay.zzff = "";
      return i;
    }
    paramzzay.zzff = new String(paramArrayOfByte, i, paramInt, zzci.UTF_8);
    return i + paramInt;
  }
  
  static int zzd(byte[] paramArrayOfByte, int paramInt, zzay paramzzay)
    throws IOException
  {
    int i = zza(paramArrayOfByte, paramInt, paramzzay);
    paramInt = paramzzay.zzfd;
    if (paramInt == 0)
    {
      paramzzay.zzff = "";
      return i;
    }
    int j = i + paramInt;
    if (zzff.zze(paramArrayOfByte, i, j))
    {
      paramzzay.zzff = new String(paramArrayOfByte, i, paramInt, zzci.UTF_8);
      return j;
    }
    throw zzco.zzbp();
  }
  
  static long zzd(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = paramArrayOfByte[paramInt];
    long l2 = paramArrayOfByte[(paramInt + 1)];
    long l3 = paramArrayOfByte[(paramInt + 2)];
    long l4 = paramArrayOfByte[(paramInt + 3)];
    long l5 = paramArrayOfByte[(paramInt + 4)];
    long l6 = paramArrayOfByte[(paramInt + 5)];
    long l7 = paramArrayOfByte[(paramInt + 6)];
    return (paramArrayOfByte[(paramInt + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
  
  static double zze(byte[] paramArrayOfByte, int paramInt)
  {
    return Double.longBitsToDouble(zzd(paramArrayOfByte, paramInt));
  }
  
  static int zze(byte[] paramArrayOfByte, int paramInt, zzay paramzzay)
  {
    paramInt = zza(paramArrayOfByte, paramInt, paramzzay);
    int i = paramzzay.zzfd;
    if (i == 0)
    {
      paramzzay.zzff = zzbb.zzfi;
      return paramInt;
    }
    paramzzay.zzff = zzbb.zzb(paramArrayOfByte, paramInt, i);
    return paramInt + i;
  }
  
  static float zzf(byte[] paramArrayOfByte, int paramInt)
  {
    return Float.intBitsToFloat(zzc(paramArrayOfByte, paramInt));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */