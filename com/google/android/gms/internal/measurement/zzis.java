package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

final class zzis
{
  static int zza(byte[] paramArrayOfByte, int paramInt, zzir paramzzir)
  {
    int i = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    if (paramInt >= 0)
    {
      paramzzir.zza = paramInt;
      return i;
    }
    return zzb(paramInt, paramArrayOfByte, i, paramzzir);
  }
  
  static int zzb(int paramInt1, byte[] paramArrayOfByte, int paramInt2, zzir paramzzir)
  {
    paramInt1 &= 0x7F;
    int i = paramInt2 + 1;
    paramInt2 = paramArrayOfByte[paramInt2];
    if (paramInt2 >= 0)
    {
      paramzzir.zza = (paramInt1 | paramInt2 << 7);
      return i;
    }
    paramInt2 = paramInt1 | (paramInt2 & 0x7F) << 7;
    paramInt1 = i + 1;
    i = paramArrayOfByte[i];
    if (i >= 0)
    {
      paramzzir.zza = (paramInt2 | i << 14);
      return paramInt1;
    }
    i = paramInt2 | (i & 0x7F) << 14;
    paramInt2 = paramInt1 + 1;
    paramInt1 = paramArrayOfByte[paramInt1];
    if (paramInt1 >= 0)
    {
      paramzzir.zza = (i | paramInt1 << 21);
      return paramInt2;
    }
    i |= (paramInt1 & 0x7F) << 21;
    paramInt1 = paramInt2 + 1;
    int j = paramArrayOfByte[paramInt2];
    if (j >= 0)
    {
      paramzzir.zza = (i | j << 28);
      return paramInt1;
    }
    for (;;)
    {
      paramInt2 = paramInt1 + 1;
      if (paramArrayOfByte[paramInt1] >= 0) {
        break;
      }
      paramInt1 = paramInt2;
    }
    paramzzir.zza = (i | (j & 0x7F) << 28);
    return paramInt2;
  }
  
  static int zzc(byte[] paramArrayOfByte, int paramInt, zzir paramzzir)
  {
    int i = paramInt + 1;
    long l = paramArrayOfByte[paramInt];
    if (l < 0L)
    {
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
      paramzzir.zzb = l;
      return paramInt;
    }
    paramzzir.zzb = l;
    return i;
  }
  
  static int zzd(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  static long zze(byte[] paramArrayOfByte, int paramInt)
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
  
  static int zzf(byte[] paramArrayOfByte, int paramInt, zzir paramzzir)
    throws zzkn
  {
    int i = zza(paramArrayOfByte, paramInt, paramzzir);
    paramInt = paramzzir.zza;
    if (paramInt >= 0)
    {
      if (paramInt == 0)
      {
        paramzzir.zzc = "";
        return i;
      }
      paramzzir.zzc = new String(paramArrayOfByte, i, paramInt, zzkl.zza);
      return i + paramInt;
    }
    throw zzkn.zzb();
  }
  
  static int zzg(byte[] paramArrayOfByte, int paramInt, zzir paramzzir)
    throws zzkn
  {
    int i = zza(paramArrayOfByte, paramInt, paramzzir);
    paramInt = paramzzir.zza;
    if (paramInt >= 0)
    {
      if (paramInt == 0)
      {
        paramzzir.zzc = "";
        return i;
      }
      paramzzir.zzc = zzmw.zze(paramArrayOfByte, i, paramInt);
      return i + paramInt;
    }
    throw zzkn.zzb();
  }
  
  static int zzh(byte[] paramArrayOfByte, int paramInt, zzir paramzzir)
    throws zzkn
  {
    int i = zza(paramArrayOfByte, paramInt, paramzzir);
    paramInt = paramzzir.zza;
    if (paramInt >= 0)
    {
      if (paramInt <= paramArrayOfByte.length - i)
      {
        if (paramInt == 0)
        {
          paramzzir.zzc = zzjd.zzb;
          return i;
        }
        paramzzir.zzc = zzjd.zzj(paramArrayOfByte, i, paramInt);
        return i + paramInt;
      }
      throw zzkn.zza();
    }
    throw zzkn.zzb();
  }
  
  static int zzi(zzlt paramzzlt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzir paramzzir)
    throws IOException
  {
    int i = paramInt1 + 1;
    int j = paramArrayOfByte[paramInt1];
    int k = i;
    paramInt1 = j;
    if (j < 0)
    {
      k = zzb(j, paramArrayOfByte, i, paramzzir);
      paramInt1 = paramzzir.zza;
    }
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt2 - k))
    {
      Object localObject = paramzzlt.zza();
      paramInt1 += k;
      paramzzlt.zzh(localObject, paramArrayOfByte, k, paramInt1, paramzzir);
      paramzzlt.zzi(localObject);
      paramzzir.zzc = localObject;
      return paramInt1;
    }
    throw zzkn.zza();
  }
  
  static int zzj(zzlt paramzzlt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, zzir paramzzir)
    throws IOException
  {
    zzll localzzll = (zzll)paramzzlt;
    paramzzlt = localzzll.zza();
    paramInt1 = localzzll.zzg(paramzzlt, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramzzir);
    localzzll.zzi(paramzzlt);
    paramzzir.zzc = paramzzlt;
    return paramInt1;
  }
  
  static int zzk(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzkk<?> paramzzkk, zzir paramzzir)
  {
    paramzzkk = (zzke)paramzzkk;
    paramInt2 = zza(paramArrayOfByte, paramInt2, paramzzir);
    paramzzkk.zzh(paramzzir.zza);
    while (paramInt2 < paramInt3)
    {
      int i = zza(paramArrayOfByte, paramInt2, paramzzir);
      if (paramInt1 != paramzzir.zza) {
        break;
      }
      paramInt2 = zza(paramArrayOfByte, i, paramzzir);
      paramzzkk.zzh(paramzzir.zza);
    }
    return paramInt2;
  }
  
  static int zzl(byte[] paramArrayOfByte, int paramInt, zzkk<?> paramzzkk, zzir paramzzir)
    throws IOException
  {
    paramzzkk = (zzke)paramzzkk;
    paramInt = zza(paramArrayOfByte, paramInt, paramzzir);
    int i = paramzzir.zza + paramInt;
    while (paramInt < i)
    {
      paramInt = zza(paramArrayOfByte, paramInt, paramzzir);
      paramzzkk.zzh(paramzzir.zza);
    }
    if (paramInt == i) {
      return paramInt;
    }
    throw zzkn.zza();
  }
  
  static int zzm(zzlt<?> paramzzlt, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzkk<?> paramzzkk, zzir paramzzir)
    throws IOException
  {
    paramInt2 = zzi(paramzzlt, paramArrayOfByte, paramInt2, paramInt3, paramzzir);
    paramzzkk.add(paramzzir.zzc);
    while (paramInt2 < paramInt3)
    {
      int i = zza(paramArrayOfByte, paramInt2, paramzzir);
      if (paramInt1 != paramzzir.zza) {
        break;
      }
      paramInt2 = zzi(paramzzlt, paramArrayOfByte, i, paramInt3, paramzzir);
      paramzzkk.add(paramzzir.zzc);
    }
    return paramInt2;
  }
  
  static int zzn(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzmi paramzzmi, zzir paramzzir)
    throws zzkn
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
                paramzzmi.zzh(paramInt1, Integer.valueOf(zzd(paramArrayOfByte, paramInt2)));
                return paramInt2 + 4;
              }
              throw zzkn.zzc();
            }
            int j = paramInt1 & 0xFFFFFFF8 | 0x4;
            zzmi localzzmi = zzmi.zzb();
            i = 0;
            int k;
            for (;;)
            {
              k = paramInt2;
              if (paramInt2 >= paramInt3) {
                break;
              }
              k = zza(paramArrayOfByte, paramInt2, paramzzir);
              i = paramzzir.zza;
              if (i == j) {
                break;
              }
              paramInt2 = zzn(i, paramArrayOfByte, k, paramInt3, localzzmi, paramzzir);
            }
            if ((k <= paramInt3) && (i == j))
            {
              paramzzmi.zzh(paramInt1, localzzmi);
              return k;
            }
            throw zzkn.zze();
          }
          paramInt2 = zza(paramArrayOfByte, paramInt2, paramzzir);
          paramInt3 = paramzzir.zza;
          if (paramInt3 >= 0)
          {
            if (paramInt3 <= paramArrayOfByte.length - paramInt2)
            {
              if (paramInt3 == 0) {
                paramzzmi.zzh(paramInt1, zzjd.zzb);
              } else {
                paramzzmi.zzh(paramInt1, zzjd.zzj(paramArrayOfByte, paramInt2, paramInt3));
              }
              return paramInt2 + paramInt3;
            }
            throw zzkn.zza();
          }
          throw zzkn.zzb();
        }
        paramzzmi.zzh(paramInt1, Long.valueOf(zze(paramArrayOfByte, paramInt2)));
        return paramInt2 + 8;
      }
      paramInt2 = zzc(paramArrayOfByte, paramInt2, paramzzir);
      paramzzmi.zzh(paramInt1, Long.valueOf(paramzzir.zzb));
      return paramInt2;
    }
    throw zzkn.zzc();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */