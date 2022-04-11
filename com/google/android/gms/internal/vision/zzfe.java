package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;

final class zzfe
{
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzfg paramzzfg)
    throws zzhh
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
              throw zzhh.zzgq();
            }
            int j = paramInt1 & 0xFFFFFFF8 | 0x4;
            paramInt1 = 0;
            for (;;)
            {
              i = paramInt2;
              if (paramInt2 >= paramInt3) {
                break;
              }
              int k = zza(paramArrayOfByte, paramInt2, paramzzfg);
              paramInt2 = paramzzfg.zzsd;
              paramInt1 = paramInt2;
              i = k;
              if (paramInt2 == j) {
                break;
              }
              i = zza(paramInt2, paramArrayOfByte, k, paramInt3, paramzzfg);
              paramInt1 = paramInt2;
              paramInt2 = i;
            }
            if ((i <= paramInt3) && (paramInt1 == j)) {
              return i;
            }
            throw zzhh.zzgt();
          }
          return zza(paramArrayOfByte, paramInt2, paramzzfg) + paramzzfg.zzsd;
        }
        return paramInt2 + 8;
      }
      return zzb(paramArrayOfByte, paramInt2, paramzzfg);
    }
    throw zzhh.zzgq();
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzhe<?> paramzzhe, zzfg paramzzfg)
  {
    paramzzhe = (zzgz)paramzzhe;
    paramInt2 = zza(paramArrayOfByte, paramInt2, paramzzfg);
    paramzzhe.zzbm(paramzzfg.zzsd);
    while (paramInt2 < paramInt3)
    {
      int i = zza(paramArrayOfByte, paramInt2, paramzzfg);
      if (paramInt1 != paramzzfg.zzsd) {
        break;
      }
      paramInt2 = zza(paramArrayOfByte, i, paramzzfg);
      paramzzhe.zzbm(paramzzfg.zzsd);
    }
    return paramInt2;
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzjr paramzzjr, zzfg paramzzfg)
    throws zzhh
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
                paramzzjr.zzb(paramInt1, Integer.valueOf(zza(paramArrayOfByte, paramInt2)));
                return paramInt2 + 4;
              }
              throw zzhh.zzgq();
            }
            zzjr localzzjr = zzjr.zzii();
            int j = paramInt1 & 0xFFFFFFF8 | 0x4;
            i = 0;
            for (;;)
            {
              k = i;
              i = paramInt2;
              if (paramInt2 >= paramInt3) {
                break label140;
              }
              k = zza(paramArrayOfByte, paramInt2, paramzzfg);
              i = paramzzfg.zzsd;
              paramInt2 = i;
              if (i == j) {
                break;
              }
              paramInt2 = zza(paramInt2, paramArrayOfByte, k, paramInt3, localzzjr, paramzzfg);
            }
            i = k;
            int k = paramInt2;
            label140:
            if ((i <= paramInt3) && (k == j))
            {
              paramzzjr.zzb(paramInt1, localzzjr);
              return i;
            }
            throw zzhh.zzgt();
          }
          paramInt3 = zza(paramArrayOfByte, paramInt2, paramzzfg);
          paramInt2 = paramzzfg.zzsd;
          if (paramInt2 >= 0)
          {
            if (paramInt2 <= paramArrayOfByte.length - paramInt3)
            {
              if (paramInt2 == 0) {
                paramzzjr.zzb(paramInt1, zzfm.zzsm);
              } else {
                paramzzjr.zzb(paramInt1, zzfm.zza(paramArrayOfByte, paramInt3, paramInt2));
              }
              return paramInt3 + paramInt2;
            }
            throw zzhh.zzgn();
          }
          throw zzhh.zzgo();
        }
        paramzzjr.zzb(paramInt1, Long.valueOf(zzb(paramArrayOfByte, paramInt2)));
        return paramInt2 + 8;
      }
      paramInt2 = zzb(paramArrayOfByte, paramInt2, paramzzfg);
      paramzzjr.zzb(paramInt1, Long.valueOf(paramzzfg.zzse));
      return paramInt2;
    }
    throw zzhh.zzgq();
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, zzfg paramzzfg)
  {
    int i = paramInt1 & 0x7F;
    paramInt1 = paramInt2 + 1;
    paramInt2 = paramArrayOfByte[paramInt2];
    if (paramInt2 >= 0)
    {
      paramzzfg.zzsd = (i | paramInt2 << 7);
      return paramInt1;
    }
    paramInt2 = i | (paramInt2 & 0x7F) << 7;
    i = paramInt1 + 1;
    paramInt1 = paramArrayOfByte[paramInt1];
    if (paramInt1 >= 0)
    {
      paramzzfg.zzsd = (paramInt2 | paramInt1 << 14);
      return i;
    }
    paramInt1 = paramInt2 | (paramInt1 & 0x7F) << 14;
    paramInt2 = i + 1;
    i = paramArrayOfByte[i];
    if (i >= 0)
    {
      paramzzfg.zzsd = (paramInt1 | i << 21);
      return paramInt2;
    }
    i = paramInt1 | (i & 0x7F) << 21;
    paramInt1 = paramInt2 + 1;
    int j = paramArrayOfByte[paramInt2];
    if (j >= 0)
    {
      paramzzfg.zzsd = (i | j << 28);
      return paramInt1;
    }
    for (;;)
    {
      paramInt2 = paramInt1 + 1;
      if (paramArrayOfByte[paramInt1] >= 0)
      {
        paramzzfg.zzsd = (i | (j & 0x7F) << 28);
        return paramInt2;
      }
      paramInt1 = paramInt2;
    }
  }
  
  static int zza(zziw<?> paramzziw, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzhe<?> paramzzhe, zzfg paramzzfg)
    throws IOException
  {
    paramInt2 = zza(paramzziw, paramArrayOfByte, paramInt2, paramInt3, paramzzfg);
    paramzzhe.add(paramzzfg.zzsf);
    while (paramInt2 < paramInt3)
    {
      int i = zza(paramArrayOfByte, paramInt2, paramzzfg);
      if (paramInt1 != paramzzfg.zzsd) {
        break;
      }
      paramInt2 = zza(paramzziw, paramArrayOfByte, i, paramInt3, paramzzfg);
      paramzzhe.add(paramzzfg.zzsf);
    }
    return paramInt2;
  }
  
  static int zza(zziw paramzziw, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, zzfg paramzzfg)
    throws IOException
  {
    zzil localzzil = (zzil)paramzziw;
    paramzziw = localzzil.newInstance();
    paramInt1 = localzzil.zza(paramzziw, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramzzfg);
    localzzil.zzh(paramzziw);
    paramzzfg.zzsf = paramzziw;
    return paramInt1;
  }
  
  static int zza(zziw paramzziw, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzfg paramzzfg)
    throws IOException
  {
    int i = paramInt1 + 1;
    int j = paramArrayOfByte[paramInt1];
    paramInt1 = i;
    int k = j;
    if (j < 0)
    {
      paramInt1 = zza(j, paramArrayOfByte, i, paramzzfg);
      k = paramzzfg.zzsd;
    }
    if ((k >= 0) && (k <= paramInt2 - paramInt1))
    {
      Object localObject = paramzziw.newInstance();
      paramInt2 = k + paramInt1;
      paramzziw.zza(localObject, paramArrayOfByte, paramInt1, paramInt2, paramzzfg);
      paramzziw.zzh(localObject);
      paramzzfg.zzsf = localObject;
      return paramInt2;
    }
    throw zzhh.zzgn();
  }
  
  static int zza(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  static int zza(byte[] paramArrayOfByte, int paramInt, zzfg paramzzfg)
  {
    int i = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    if (paramInt >= 0)
    {
      paramzzfg.zzsd = paramInt;
      return i;
    }
    return zza(paramInt, paramArrayOfByte, i, paramzzfg);
  }
  
  static int zza(byte[] paramArrayOfByte, int paramInt, zzhe<?> paramzzhe, zzfg paramzzfg)
    throws IOException
  {
    paramzzhe = (zzgz)paramzzhe;
    paramInt = zza(paramArrayOfByte, paramInt, paramzzfg);
    int i = paramzzfg.zzsd + paramInt;
    while (paramInt < i)
    {
      paramInt = zza(paramArrayOfByte, paramInt, paramzzfg);
      paramzzhe.zzbm(paramzzfg.zzsd);
    }
    if (paramInt == i) {
      return paramInt;
    }
    throw zzhh.zzgn();
  }
  
  static int zzb(byte[] paramArrayOfByte, int paramInt, zzfg paramzzfg)
  {
    int i = paramInt + 1;
    long l = paramArrayOfByte[paramInt];
    if (l >= 0L)
    {
      paramzzfg.zzse = l;
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
    paramzzfg.zzse = l;
    return paramInt;
  }
  
  static int zzb(byte[] paramArrayOfByte, int paramInt, zzhe<?> paramzzhe, zzfg paramzzfg)
    throws IOException
  {
    paramzzhe = (zzhv)paramzzhe;
    paramInt = zza(paramArrayOfByte, paramInt, paramzzfg);
    int i = paramzzfg.zzsd + paramInt;
    while (paramInt < i)
    {
      paramInt = zzb(paramArrayOfByte, paramInt, paramzzfg);
      paramzzhe.zzac(paramzzfg.zzse);
    }
    if (paramInt == i) {
      return paramInt;
    }
    throw zzhh.zzgn();
  }
  
  static long zzb(byte[] paramArrayOfByte, int paramInt)
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
  
  static double zzc(byte[] paramArrayOfByte, int paramInt)
  {
    return Double.longBitsToDouble(zzb(paramArrayOfByte, paramInt));
  }
  
  static int zzc(byte[] paramArrayOfByte, int paramInt, zzfg paramzzfg)
    throws zzhh
  {
    paramInt = zza(paramArrayOfByte, paramInt, paramzzfg);
    int i = paramzzfg.zzsd;
    if (i >= 0)
    {
      if (i == 0)
      {
        paramzzfg.zzsf = "";
        return paramInt;
      }
      paramzzfg.zzsf = new String(paramArrayOfByte, paramInt, i, zzgy.UTF_8);
      return paramInt + i;
    }
    throw zzhh.zzgo();
  }
  
  static int zzc(byte[] paramArrayOfByte, int paramInt, zzhe<?> paramzzhe, zzfg paramzzfg)
    throws IOException
  {
    paramzzhe = (zzgz)paramzzhe;
    paramInt = zza(paramArrayOfByte, paramInt, paramzzfg);
    int i = paramzzfg.zzsd + paramInt;
    while (paramInt < i)
    {
      paramzzhe.zzbm(zza(paramArrayOfByte, paramInt));
      paramInt += 4;
    }
    if (paramInt == i) {
      return paramInt;
    }
    throw zzhh.zzgn();
  }
  
  static float zzd(byte[] paramArrayOfByte, int paramInt)
  {
    return Float.intBitsToFloat(zza(paramArrayOfByte, paramInt));
  }
  
  static int zzd(byte[] paramArrayOfByte, int paramInt, zzfg paramzzfg)
    throws zzhh
  {
    int i = zza(paramArrayOfByte, paramInt, paramzzfg);
    paramInt = paramzzfg.zzsd;
    if (paramInt >= 0)
    {
      if (paramInt == 0)
      {
        paramzzfg.zzsf = "";
        return i;
      }
      paramzzfg.zzsf = zzjx.zzh(paramArrayOfByte, i, paramInt);
      return i + paramInt;
    }
    throw zzhh.zzgo();
  }
  
  static int zzd(byte[] paramArrayOfByte, int paramInt, zzhe<?> paramzzhe, zzfg paramzzfg)
    throws IOException
  {
    paramzzhe = (zzhv)paramzzhe;
    paramInt = zza(paramArrayOfByte, paramInt, paramzzfg);
    int i = paramzzfg.zzsd + paramInt;
    while (paramInt < i)
    {
      paramzzhe.zzac(zzb(paramArrayOfByte, paramInt));
      paramInt += 8;
    }
    if (paramInt == i) {
      return paramInt;
    }
    throw zzhh.zzgn();
  }
  
  static int zze(byte[] paramArrayOfByte, int paramInt, zzfg paramzzfg)
    throws zzhh
  {
    int i = zza(paramArrayOfByte, paramInt, paramzzfg);
    paramInt = paramzzfg.zzsd;
    if (paramInt >= 0)
    {
      if (paramInt <= paramArrayOfByte.length - i)
      {
        if (paramInt == 0)
        {
          paramzzfg.zzsf = zzfm.zzsm;
          return i;
        }
        paramzzfg.zzsf = zzfm.zza(paramArrayOfByte, i, paramInt);
        return i + paramInt;
      }
      throw zzhh.zzgn();
    }
    throw zzhh.zzgo();
  }
  
  static int zze(byte[] paramArrayOfByte, int paramInt, zzhe<?> paramzzhe, zzfg paramzzfg)
    throws IOException
  {
    paramzzhe = (zzgt)paramzzhe;
    paramInt = zza(paramArrayOfByte, paramInt, paramzzfg);
    int i = paramzzfg.zzsd + paramInt;
    while (paramInt < i)
    {
      paramzzhe.zzu(zzd(paramArrayOfByte, paramInt));
      paramInt += 4;
    }
    if (paramInt == i) {
      return paramInt;
    }
    throw zzhh.zzgn();
  }
  
  static int zzf(byte[] paramArrayOfByte, int paramInt, zzhe<?> paramzzhe, zzfg paramzzfg)
    throws IOException
  {
    paramzzhe = (zzgg)paramzzhe;
    paramInt = zza(paramArrayOfByte, paramInt, paramzzfg);
    int i = paramzzfg.zzsd + paramInt;
    while (paramInt < i)
    {
      paramzzhe.zzc(zzc(paramArrayOfByte, paramInt));
      paramInt += 8;
    }
    if (paramInt == i) {
      return paramInt;
    }
    throw zzhh.zzgn();
  }
  
  static int zzg(byte[] paramArrayOfByte, int paramInt, zzhe<?> paramzzhe, zzfg paramzzfg)
    throws IOException
  {
    paramzzhe = (zzfk)paramzzhe;
    paramInt = zza(paramArrayOfByte, paramInt, paramzzfg);
    int i = paramzzfg.zzsd + paramInt;
    while (paramInt < i)
    {
      paramInt = zzb(paramArrayOfByte, paramInt, paramzzfg);
      boolean bool;
      if (paramzzfg.zzse != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      paramzzhe.addBoolean(bool);
    }
    if (paramInt == i) {
      return paramInt;
    }
    throw zzhh.zzgn();
  }
  
  static int zzh(byte[] paramArrayOfByte, int paramInt, zzhe<?> paramzzhe, zzfg paramzzfg)
    throws IOException
  {
    paramzzhe = (zzgz)paramzzhe;
    paramInt = zza(paramArrayOfByte, paramInt, paramzzfg);
    int i = paramzzfg.zzsd + paramInt;
    while (paramInt < i)
    {
      paramInt = zza(paramArrayOfByte, paramInt, paramzzfg);
      paramzzhe.zzbm(zzfy.zzav(paramzzfg.zzsd));
    }
    if (paramInt == i) {
      return paramInt;
    }
    throw zzhh.zzgn();
  }
  
  static int zzi(byte[] paramArrayOfByte, int paramInt, zzhe<?> paramzzhe, zzfg paramzzfg)
    throws IOException
  {
    paramzzhe = (zzhv)paramzzhe;
    paramInt = zza(paramArrayOfByte, paramInt, paramzzfg);
    int i = paramzzfg.zzsd + paramInt;
    while (paramInt < i)
    {
      paramInt = zzb(paramArrayOfByte, paramInt, paramzzfg);
      paramzzhe.zzac(zzfy.zzr(paramzzfg.zzse));
    }
    if (paramInt == i) {
      return paramInt;
    }
    throw zzhh.zzgn();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */