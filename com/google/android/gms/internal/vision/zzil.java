package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import sun.misc.Unsafe;

final class zzil<T>
  implements zziw<T>
{
  private static final int[] zzzh = new int[0];
  private static final Unsafe zzzi = zzju.zzim();
  private final int[] zzzj;
  private final Object[] zzzk;
  private final int zzzl;
  private final int zzzm;
  private final zzih zzzn;
  private final boolean zzzo;
  private final boolean zzzp;
  private final boolean zzzq;
  private final boolean zzzr;
  private final int[] zzzs;
  private final int zzzt;
  private final int zzzu;
  private final zzip zzzv;
  private final zzhr zzzw;
  private final zzjo<?, ?> zzzx;
  private final zzgk<?> zzzy;
  private final zzia zzzz;
  
  private zzil(int[] paramArrayOfInt1, Object[] paramArrayOfObject, int paramInt1, int paramInt2, zzih paramzzih, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt2, int paramInt3, int paramInt4, zzip paramzzip, zzhr paramzzhr, zzjo<?, ?> paramzzjo, zzgk<?> paramzzgk, zzia paramzzia)
  {
    this.zzzj = paramArrayOfInt1;
    this.zzzk = paramArrayOfObject;
    this.zzzl = paramInt1;
    this.zzzm = paramInt2;
    this.zzzp = (paramzzih instanceof zzgx);
    this.zzzq = paramBoolean1;
    if ((paramzzgk != null) && (paramzzgk.zze(paramzzih))) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.zzzo = paramBoolean1;
    this.zzzr = false;
    this.zzzs = paramArrayOfInt2;
    this.zzzt = paramInt3;
    this.zzzu = paramInt4;
    this.zzzv = paramzzip;
    this.zzzw = paramzzhr;
    this.zzzx = paramzzjo;
    this.zzzy = paramzzgk;
    this.zzzn = paramzzih;
    this.zzzz = paramzzia;
  }
  
  private static <UT, UB> int zza(zzjo<UT, UB> paramzzjo, T paramT)
  {
    return paramzzjo.zzs(paramzzjo.zzw(paramT));
  }
  
  private final int zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong, int paramInt8, zzfg paramzzfg)
    throws IOException
  {
    Unsafe localUnsafe = zzzi;
    long l = this.zzzj[(paramInt8 + 2)] & 0xFFFFF;
    switch (paramInt7)
    {
    default: 
      break;
    case 68: 
      if (paramInt5 != 3) {
        return paramInt1;
      }
      paramInt1 = zzfe.zza(zzbn(paramInt8), paramArrayOfByte, paramInt1, paramInt2, paramInt3 & 0xFFFFFFF8 | 0x4, paramzzfg);
      if (localUnsafe.getInt(paramT, l) == paramInt4) {
        paramArrayOfByte = localUnsafe.getObject(paramT, paramLong);
      } else {
        paramArrayOfByte = null;
      }
      if (paramArrayOfByte == null) {
        localUnsafe.putObject(paramT, paramLong, paramzzfg.zzsf);
      } else {
        localUnsafe.putObject(paramT, paramLong, zzgy.zzb(paramArrayOfByte, paramzzfg.zzsf));
      }
      break;
    case 67: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzfe.zzb(paramArrayOfByte, paramInt1, paramzzfg);
      localUnsafe.putObject(paramT, paramLong, Long.valueOf(zzfy.zzr(paramzzfg.zzse)));
      break;
    case 66: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzfe.zza(paramArrayOfByte, paramInt1, paramzzfg);
      localUnsafe.putObject(paramT, paramLong, Integer.valueOf(zzfy.zzav(paramzzfg.zzsd)));
      break;
    case 63: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzfe.zza(paramArrayOfByte, paramInt1, paramzzfg);
      paramInt2 = paramzzfg.zzsd;
      paramArrayOfByte = zzbp(paramInt8);
      if ((paramArrayOfByte != null) && (!paramArrayOfByte.zzg(paramInt2)))
      {
        zzt(paramT).zzb(paramInt3, Long.valueOf(paramInt2));
        return paramInt1;
      }
      localUnsafe.putObject(paramT, paramLong, Integer.valueOf(paramInt2));
      break;
    case 61: 
      if (paramInt5 != 2) {
        return paramInt1;
      }
      paramInt1 = zzfe.zze(paramArrayOfByte, paramInt1, paramzzfg);
      localUnsafe.putObject(paramT, paramLong, paramzzfg.zzsf);
      break;
    case 60: 
      if (paramInt5 != 2) {
        return paramInt1;
      }
      paramInt1 = zzfe.zza(zzbn(paramInt8), paramArrayOfByte, paramInt1, paramInt2, paramzzfg);
      if (localUnsafe.getInt(paramT, l) == paramInt4) {
        paramArrayOfByte = localUnsafe.getObject(paramT, paramLong);
      } else {
        paramArrayOfByte = null;
      }
      if (paramArrayOfByte == null) {
        localUnsafe.putObject(paramT, paramLong, paramzzfg.zzsf);
      } else {
        localUnsafe.putObject(paramT, paramLong, zzgy.zzb(paramArrayOfByte, paramzzfg.zzsf));
      }
      localUnsafe.putInt(paramT, l, paramInt4);
      break;
    case 59: 
      if (paramInt5 != 2) {
        return paramInt1;
      }
      paramInt1 = zzfe.zza(paramArrayOfByte, paramInt1, paramzzfg);
      paramInt2 = paramzzfg.zzsd;
      if (paramInt2 == 0)
      {
        localUnsafe.putObject(paramT, paramLong, "");
      }
      else
      {
        if (((paramInt6 & 0x20000000) != 0) && (!zzjx.zzf(paramArrayOfByte, paramInt1, paramInt1 + paramInt2))) {
          throw zzhh.zzgu();
        }
        localUnsafe.putObject(paramT, paramLong, new String(paramArrayOfByte, paramInt1, paramInt2, zzgy.UTF_8));
        paramInt1 += paramInt2;
      }
      localUnsafe.putInt(paramT, l, paramInt4);
      break;
    case 58: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzfe.zzb(paramArrayOfByte, paramInt1, paramzzfg);
      boolean bool;
      if (paramzzfg.zzse != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      localUnsafe.putObject(paramT, paramLong, Boolean.valueOf(bool));
      break;
    case 57: 
    case 64: 
      if (paramInt5 != 5) {
        return paramInt1;
      }
      localUnsafe.putObject(paramT, paramLong, Integer.valueOf(zzfe.zza(paramArrayOfByte, paramInt1)));
      break;
    case 56: 
    case 65: 
      if (paramInt5 != 1) {
        return paramInt1;
      }
      localUnsafe.putObject(paramT, paramLong, Long.valueOf(zzfe.zzb(paramArrayOfByte, paramInt1)));
      break;
    case 55: 
    case 62: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzfe.zza(paramArrayOfByte, paramInt1, paramzzfg);
      localUnsafe.putObject(paramT, paramLong, Integer.valueOf(paramzzfg.zzsd));
      break;
    case 53: 
    case 54: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzfe.zzb(paramArrayOfByte, paramInt1, paramzzfg);
      localUnsafe.putObject(paramT, paramLong, Long.valueOf(paramzzfg.zzse));
      break;
    case 52: 
      if (paramInt5 != 5) {
        return paramInt1;
      }
      localUnsafe.putObject(paramT, paramLong, Float.valueOf(zzfe.zzd(paramArrayOfByte, paramInt1)));
      paramInt1 += 4;
      break;
    }
    if (paramInt5 == 1)
    {
      localUnsafe.putObject(paramT, paramLong, Double.valueOf(zzfe.zzc(paramArrayOfByte, paramInt1)));
      paramInt1 += 8;
      localUnsafe.putInt(paramT, l, paramInt4);
    }
    return paramInt1;
  }
  
  private final int zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, int paramInt7, long paramLong2, zzfg paramzzfg)
    throws IOException
  {
    int i = paramInt1;
    Unsafe localUnsafe = zzzi;
    zzhe localzzhe1 = (zzhe)localUnsafe.getObject(paramT, paramLong2);
    zzhe localzzhe2 = localzzhe1;
    if (!localzzhe1.zzdp())
    {
      int j = localzzhe1.size();
      if (j == 0) {
        j = 10;
      } else {
        j <<= 1;
      }
      localzzhe2 = localzzhe1.zzah(j);
      localUnsafe.putObject(paramT, paramLong2, localzzhe2);
    }
    switch (paramInt7)
    {
    default: 
      paramInt7 = i;
      break;
    case 49: 
      paramInt7 = i;
      if (paramInt5 == 3)
      {
        paramT = zzbn(paramInt6);
        paramInt4 = paramInt3 & 0xFFFFFFF8 | 0x4;
        paramInt1 = zzfe.zza(paramT, paramArrayOfByte, paramInt1, paramInt2, paramInt4, paramzzfg);
        localzzhe2.add(paramzzfg.zzsf);
        for (;;)
        {
          paramInt7 = paramInt1;
          if (paramInt1 >= paramInt2) {
            break;
          }
          paramInt5 = zzfe.zza(paramArrayOfByte, paramInt1, paramzzfg);
          paramInt7 = paramInt1;
          if (paramInt3 != paramzzfg.zzsd) {
            break;
          }
          paramInt1 = zzfe.zza(paramT, paramArrayOfByte, paramInt5, paramInt2, paramInt4, paramzzfg);
          localzzhe2.add(paramzzfg.zzsf);
        }
      }
      break;
    case 34: 
    case 48: 
      if (paramInt5 == 2) {
        return zzfe.zzi(paramArrayOfByte, i, localzzhe2, paramzzfg);
      }
      paramInt7 = i;
      if (paramInt5 == 0)
      {
        paramT = (zzhv)localzzhe2;
        paramInt4 = zzfe.zzb(paramArrayOfByte, i, paramzzfg);
        paramT.zzac(zzfy.zzr(paramzzfg.zzse));
        for (;;)
        {
          paramInt1 = paramInt4;
          if (paramInt4 >= paramInt2) {
            break;
          }
          paramInt5 = zzfe.zza(paramArrayOfByte, paramInt4, paramzzfg);
          paramInt1 = paramInt4;
          if (paramInt3 != paramzzfg.zzsd) {
            break;
          }
          paramInt4 = zzfe.zzb(paramArrayOfByte, paramInt5, paramzzfg);
          paramT.zzac(zzfy.zzr(paramzzfg.zzse));
        }
      }
      break;
    case 33: 
    case 47: 
      if (paramInt5 == 2) {
        return zzfe.zzh(paramArrayOfByte, i, localzzhe2, paramzzfg);
      }
      paramInt7 = i;
      if (paramInt5 == 0)
      {
        paramT = (zzgz)localzzhe2;
        paramInt4 = zzfe.zza(paramArrayOfByte, i, paramzzfg);
        paramT.zzbm(zzfy.zzav(paramzzfg.zzsd));
        for (;;)
        {
          paramInt1 = paramInt4;
          if (paramInt4 >= paramInt2) {
            break;
          }
          paramInt5 = zzfe.zza(paramArrayOfByte, paramInt4, paramzzfg);
          paramInt1 = paramInt4;
          if (paramInt3 != paramzzfg.zzsd) {
            break;
          }
          paramInt4 = zzfe.zza(paramArrayOfByte, paramInt5, paramzzfg);
          paramT.zzbm(zzfy.zzav(paramzzfg.zzsd));
        }
      }
      break;
    case 30: 
    case 44: 
      if (paramInt5 == 2)
      {
        paramInt1 = zzfe.zza(paramArrayOfByte, i, localzzhe2, paramzzfg);
      }
      else
      {
        paramInt7 = i;
        if (paramInt5 != 0) {
          break;
        }
        paramInt1 = zzfe.zza(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localzzhe2, paramzzfg);
      }
      paramzzfg = (zzgx)paramT;
      paramArrayOfByte = paramzzfg.zzws;
      paramT = paramArrayOfByte;
      if (paramArrayOfByte == zzjr.zzih()) {
        paramT = null;
      }
      paramT = (zzjr)zziy.zza(paramInt4, localzzhe2, zzbp(paramInt6), paramT, this.zzzx);
      if (paramT != null) {
        paramzzfg.zzws = paramT;
      }
      break;
    case 28: 
      paramInt7 = i;
      if (paramInt5 == 2)
      {
        paramInt1 = zzfe.zza(paramArrayOfByte, i, paramzzfg);
        paramInt4 = paramzzfg.zzsd;
        if (paramInt4 >= 0)
        {
          if (paramInt4 <= paramArrayOfByte.length - paramInt1)
          {
            if (paramInt4 == 0)
            {
              localzzhe2.add(zzfm.zzsm);
              paramInt4 = paramInt1;
            }
            else
            {
              localzzhe2.add(zzfm.zza(paramArrayOfByte, paramInt1, paramInt4));
            }
            for (;;)
            {
              for (paramInt4 = paramInt1 + paramInt4;; paramInt4 = paramInt1)
              {
                paramInt1 = paramInt4;
                if (paramInt4 >= paramInt2) {
                  return paramInt1;
                }
                paramInt5 = zzfe.zza(paramArrayOfByte, paramInt4, paramzzfg);
                paramInt1 = paramInt4;
                if (paramInt3 != paramzzfg.zzsd) {
                  return paramInt1;
                }
                paramInt1 = zzfe.zza(paramArrayOfByte, paramInt5, paramzzfg);
                paramInt4 = paramzzfg.zzsd;
                if (paramInt4 < 0) {
                  break label869;
                }
                if (paramInt4 > paramArrayOfByte.length - paramInt1) {
                  break label865;
                }
                if (paramInt4 != 0) {
                  break;
                }
                localzzhe2.add(zzfm.zzsm);
              }
              localzzhe2.add(zzfm.zza(paramArrayOfByte, paramInt1, paramInt4));
            }
            throw zzhh.zzgn();
            throw zzhh.zzgo();
          }
          throw zzhh.zzgn();
        }
        throw zzhh.zzgo();
      }
      break;
    case 27: 
      paramInt7 = i;
      if (paramInt5 == 2) {
        paramInt1 = zzfe.zza(zzbn(paramInt6), paramInt3, paramArrayOfByte, paramInt1, paramInt2, localzzhe2, paramzzfg);
      }
      break;
    case 26: 
      paramInt7 = i;
      if (paramInt5 == 2)
      {
        if ((paramLong1 & 0x20000000) == 0L)
        {
          paramInt1 = zzfe.zza(paramArrayOfByte, i, paramzzfg);
          paramInt4 = paramzzfg.zzsd;
          if (paramInt4 >= 0)
          {
            if (paramInt4 == 0) {
              localzzhe2.add("");
            } else {
              localzzhe2.add(new String(paramArrayOfByte, paramInt1, paramInt4, zzgy.UTF_8));
            }
            for (;;)
            {
              paramInt1 += paramInt4;
              for (;;)
              {
                paramInt7 = paramInt1;
                if (paramInt1 >= paramInt2) {
                  break label2002;
                }
                paramInt4 = zzfe.zza(paramArrayOfByte, paramInt1, paramzzfg);
                paramInt7 = paramInt1;
                if (paramInt3 != paramzzfg.zzsd) {
                  break label2002;
                }
                paramInt1 = zzfe.zza(paramArrayOfByte, paramInt4, paramzzfg);
                paramInt4 = paramzzfg.zzsd;
                if (paramInt4 < 0) {
                  break label1096;
                }
                if (paramInt4 != 0) {
                  break;
                }
                localzzhe2.add("");
              }
              localzzhe2.add(new String(paramArrayOfByte, paramInt1, paramInt4, zzgy.UTF_8));
            }
            throw zzhh.zzgo();
          }
          throw zzhh.zzgo();
        }
        paramInt1 = zzfe.zza(paramArrayOfByte, i, paramzzfg);
        paramInt5 = paramzzfg.zzsd;
        if (paramInt5 >= 0)
        {
          if (paramInt5 == 0)
          {
            localzzhe2.add("");
          }
          else
          {
            paramInt4 = paramInt1 + paramInt5;
            if (!zzjx.zzf(paramArrayOfByte, paramInt1, paramInt4)) {
              break label1308;
            }
            localzzhe2.add(new String(paramArrayOfByte, paramInt1, paramInt5, zzgy.UTF_8));
            paramInt1 = paramInt4;
          }
          for (;;)
          {
            paramInt7 = paramInt1;
            if (paramInt1 >= paramInt2) {
              break label2002;
            }
            paramInt4 = zzfe.zza(paramArrayOfByte, paramInt1, paramzzfg);
            paramInt7 = paramInt1;
            if (paramInt3 != paramzzfg.zzsd) {
              break label2002;
            }
            paramInt4 = zzfe.zza(paramArrayOfByte, paramInt4, paramzzfg);
            paramInt5 = paramzzfg.zzsd;
            if (paramInt5 < 0) {
              break label1304;
            }
            if (paramInt5 == 0)
            {
              localzzhe2.add("");
              paramInt1 = paramInt4;
            }
            else
            {
              paramInt1 = paramInt4 + paramInt5;
              if (!zzjx.zzf(paramArrayOfByte, paramInt4, paramInt1)) {
                break;
              }
              localzzhe2.add(new String(paramArrayOfByte, paramInt4, paramInt5, zzgy.UTF_8));
            }
          }
          throw zzhh.zzgu();
          throw zzhh.zzgo();
          throw zzhh.zzgu();
        }
        throw zzhh.zzgo();
      }
      break;
    case 25: 
    case 42: 
      if (paramInt5 == 2) {
        return zzfe.zzg(paramArrayOfByte, i, localzzhe2, paramzzfg);
      }
      paramInt7 = i;
      if (paramInt5 == 0)
      {
        paramT = (zzfk)localzzhe2;
        paramInt4 = zzfe.zzb(paramArrayOfByte, i, paramzzfg);
        boolean bool;
        if (paramzzfg.zzse != 0L) {
          bool = true;
        } else {
          bool = false;
        }
        paramT.addBoolean(bool);
        for (;;)
        {
          paramInt1 = paramInt4;
          if (paramInt4 >= paramInt2) {
            break;
          }
          paramInt5 = zzfe.zza(paramArrayOfByte, paramInt4, paramzzfg);
          paramInt1 = paramInt4;
          if (paramInt3 != paramzzfg.zzsd) {
            break;
          }
          paramInt4 = zzfe.zzb(paramArrayOfByte, paramInt5, paramzzfg);
          if (paramzzfg.zzse != 0L) {
            bool = true;
          } else {
            bool = false;
          }
          paramT.addBoolean(bool);
        }
      }
      break;
    case 24: 
    case 31: 
    case 41: 
    case 45: 
      if (paramInt5 == 2) {
        return zzfe.zzc(paramArrayOfByte, i, localzzhe2, paramzzfg);
      }
      paramInt7 = i;
      if (paramInt5 == 5)
      {
        paramT = (zzgz)localzzhe2;
        paramT.zzbm(zzfe.zza(paramArrayOfByte, paramInt1));
        for (;;)
        {
          paramInt4 = i + 4;
          paramInt1 = paramInt4;
          if (paramInt4 >= paramInt2) {
            break;
          }
          i = zzfe.zza(paramArrayOfByte, paramInt4, paramzzfg);
          paramInt1 = paramInt4;
          if (paramInt3 != paramzzfg.zzsd) {
            break;
          }
          paramT.zzbm(zzfe.zza(paramArrayOfByte, i));
        }
      }
      break;
    case 23: 
    case 32: 
    case 40: 
    case 46: 
      if (paramInt5 == 2) {
        return zzfe.zzd(paramArrayOfByte, i, localzzhe2, paramzzfg);
      }
      paramInt7 = i;
      if (paramInt5 == 1)
      {
        paramT = (zzhv)localzzhe2;
        paramT.zzac(zzfe.zzb(paramArrayOfByte, paramInt1));
        for (;;)
        {
          paramInt4 = i + 8;
          paramInt1 = paramInt4;
          if (paramInt4 >= paramInt2) {
            break;
          }
          i = zzfe.zza(paramArrayOfByte, paramInt4, paramzzfg);
          paramInt1 = paramInt4;
          if (paramInt3 != paramzzfg.zzsd) {
            break;
          }
          paramT.zzac(zzfe.zzb(paramArrayOfByte, i));
        }
      }
      break;
    case 22: 
    case 29: 
    case 39: 
    case 43: 
      if (paramInt5 == 2)
      {
        paramInt1 = zzfe.zza(paramArrayOfByte, i, localzzhe2, paramzzfg);
      }
      else
      {
        paramInt7 = i;
        if (paramInt5 == 0) {
          paramInt1 = zzfe.zza(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localzzhe2, paramzzfg);
        }
      }
      break;
    case 20: 
    case 21: 
    case 37: 
    case 38: 
      if (paramInt5 == 2) {
        return zzfe.zzb(paramArrayOfByte, i, localzzhe2, paramzzfg);
      }
      paramInt7 = i;
      if (paramInt5 == 0)
      {
        paramT = (zzhv)localzzhe2;
        paramInt4 = zzfe.zzb(paramArrayOfByte, i, paramzzfg);
        paramT.zzac(paramzzfg.zzse);
        for (;;)
        {
          paramInt1 = paramInt4;
          if (paramInt4 >= paramInt2) {
            break;
          }
          paramInt5 = zzfe.zza(paramArrayOfByte, paramInt4, paramzzfg);
          paramInt1 = paramInt4;
          if (paramInt3 != paramzzfg.zzsd) {
            break;
          }
          paramInt4 = zzfe.zzb(paramArrayOfByte, paramInt5, paramzzfg);
          paramT.zzac(paramzzfg.zzse);
        }
      }
      break;
    case 19: 
    case 36: 
      if (paramInt5 == 2) {
        return zzfe.zze(paramArrayOfByte, i, localzzhe2, paramzzfg);
      }
      paramInt7 = i;
      if (paramInt5 == 5)
      {
        paramT = (zzgt)localzzhe2;
        paramT.zzu(zzfe.zzd(paramArrayOfByte, paramInt1));
        for (;;)
        {
          paramInt4 = i + 4;
          paramInt1 = paramInt4;
          if (paramInt4 >= paramInt2) {
            break;
          }
          i = zzfe.zza(paramArrayOfByte, paramInt4, paramzzfg);
          paramInt1 = paramInt4;
          if (paramInt3 != paramzzfg.zzsd) {
            break;
          }
          paramT.zzu(zzfe.zzd(paramArrayOfByte, i));
        }
      }
      break;
    case 18: 
    case 35: 
      label865:
      label869:
      label1096:
      label1304:
      label1308:
      if (paramInt5 == 2) {
        return zzfe.zzf(paramArrayOfByte, i, localzzhe2, paramzzfg);
      }
      paramInt7 = i;
      if (paramInt5 == 1)
      {
        paramT = (zzgg)localzzhe2;
        paramT.zzc(zzfe.zzc(paramArrayOfByte, paramInt1));
        for (;;)
        {
          paramInt4 = i + 8;
          paramInt1 = paramInt4;
          if (paramInt4 >= paramInt2) {
            break;
          }
          i = zzfe.zza(paramArrayOfByte, paramInt4, paramzzfg);
          paramInt1 = paramInt4;
          if (paramInt3 != paramzzfg.zzsd) {
            break;
          }
          paramT.zzc(zzfe.zzc(paramArrayOfByte, i));
        }
      }
      break;
    }
    label2002:
    paramInt1 = paramInt7;
    return paramInt1;
  }
  
  private final <K, V> int zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong, zzfg paramzzfg)
    throws IOException
  {
    Unsafe localUnsafe = zzzi;
    Object localObject1 = zzbo(paramInt3);
    Object localObject2 = localUnsafe.getObject(paramT, paramLong);
    Object localObject3 = localObject2;
    if (this.zzzz.zzn(localObject2))
    {
      localObject3 = this.zzzz.zzp(localObject1);
      this.zzzz.zzc(localObject3, localObject2);
      localUnsafe.putObject(paramT, paramLong, localObject3);
    }
    localObject2 = this.zzzz.zzq(localObject1);
    localObject1 = this.zzzz.zzl(localObject3);
    paramInt1 = zzfe.zza(paramArrayOfByte, paramInt1, paramzzfg);
    paramInt3 = paramzzfg.zzsd;
    if ((paramInt3 >= 0) && (paramInt3 <= paramInt2 - paramInt1))
    {
      int i = paramInt3 + paramInt1;
      paramT = ((zzhy)localObject2).zzzc;
      localObject3 = ((zzhy)localObject2).zzgl;
      while (paramInt1 < i)
      {
        int j = paramInt1 + 1;
        int k = paramArrayOfByte[paramInt1];
        paramInt3 = j;
        paramInt1 = k;
        if (k < 0)
        {
          paramInt3 = zzfe.zza(k, paramArrayOfByte, j, paramzzfg);
          paramInt1 = paramzzfg.zzsd;
        }
        j = paramInt1 >>> 3;
        k = paramInt1 & 0x7;
        if (j != 1)
        {
          if ((j == 2) && (k == ((zzhy)localObject2).zzzd.zzir()))
          {
            paramInt1 = zza(paramArrayOfByte, paramInt3, paramInt2, ((zzhy)localObject2).zzzd, ((zzhy)localObject2).zzgl.getClass(), paramzzfg);
            localObject3 = paramzzfg.zzsf;
          }
        }
        else if (k == ((zzhy)localObject2).zzzb.zzir())
        {
          paramInt1 = zza(paramArrayOfByte, paramInt3, paramInt2, ((zzhy)localObject2).zzzb, null, paramzzfg);
          paramT = paramzzfg.zzsf;
          continue;
        }
        paramInt1 = zzfe.zza(paramInt1, paramArrayOfByte, paramInt3, paramInt2, paramzzfg);
      }
      if (paramInt1 == i)
      {
        ((Map)localObject1).put(paramT, localObject3);
        return i;
      }
      throw zzhh.zzgt();
    }
    throw zzhh.zzgn();
  }
  
  private static int zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzkf paramzzkf, Class<?> paramClass, zzfg paramzzfg)
    throws IOException
  {
    switch (zzik.zzsg[paramzzkf.ordinal()])
    {
    default: 
      throw new RuntimeException("unsupported field type.");
    case 17: 
      paramInt1 = zzfe.zzd(paramArrayOfByte, paramInt1, paramzzfg);
      break;
    case 16: 
      paramInt1 = zzfe.zzb(paramArrayOfByte, paramInt1, paramzzfg);
      paramzzfg.zzsf = Long.valueOf(zzfy.zzr(paramzzfg.zzse));
      break;
    case 15: 
      paramInt1 = zzfe.zza(paramArrayOfByte, paramInt1, paramzzfg);
      paramzzfg.zzsf = Integer.valueOf(zzfy.zzav(paramzzfg.zzsd));
      break;
    case 14: 
      paramInt1 = zzfe.zza(zzis.zzhp().zzf(paramClass), paramArrayOfByte, paramInt1, paramInt2, paramzzfg);
      break;
    case 12: 
    case 13: 
      paramInt1 = zzfe.zzb(paramArrayOfByte, paramInt1, paramzzfg);
      paramzzfg.zzsf = Long.valueOf(paramzzfg.zzse);
      break;
    case 9: 
    case 10: 
    case 11: 
      paramInt1 = zzfe.zza(paramArrayOfByte, paramInt1, paramzzfg);
      paramzzfg.zzsf = Integer.valueOf(paramzzfg.zzsd);
      break;
    case 8: 
      paramzzfg.zzsf = Float.valueOf(zzfe.zzd(paramArrayOfByte, paramInt1));
      break;
    case 6: 
    case 7: 
      paramzzfg.zzsf = Long.valueOf(zzfe.zzb(paramArrayOfByte, paramInt1));
      break;
    case 4: 
    case 5: 
      paramzzfg.zzsf = Integer.valueOf(zzfe.zza(paramArrayOfByte, paramInt1));
      paramInt1 += 4;
      break;
    case 3: 
      paramzzfg.zzsf = Double.valueOf(zzfe.zzc(paramArrayOfByte, paramInt1));
      paramInt1 += 8;
      break;
    case 2: 
      paramInt1 = zzfe.zze(paramArrayOfByte, paramInt1, paramzzfg);
      break;
    }
    paramInt1 = zzfe.zzb(paramArrayOfByte, paramInt1, paramzzfg);
    boolean bool;
    if (paramzzfg.zzse != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    paramzzfg.zzsf = Boolean.valueOf(bool);
    return paramInt1;
  }
  
  static <T> zzil<T> zza(Class<T> paramClass, zzif paramzzif, zzip paramzzip, zzhr paramzzhr, zzjo<?, ?> paramzzjo, zzgk<?> paramzzgk, zzia paramzzia)
  {
    if ((paramzzif instanceof zziu))
    {
      zziu localzziu = (zziu)paramzzif;
      int i = localzziu.zzhj();
      j = zzgx.zzf.zzxj;
      int k = 0;
      boolean bool;
      if (i == j) {
        bool = true;
      } else {
        bool = false;
      }
      String str = localzziu.zzhq();
      int m = str.length();
      if (str.charAt(0) >= 55296) {
        for (i = 1;; i = n)
        {
          n = i + 1;
          j = n;
          if (str.charAt(i) < 55296) {
            break;
          }
        }
      }
      j = 1;
      i = j + 1;
      int i1 = str.charAt(j);
      j = i;
      int n = i1;
      if (i1 >= 55296)
      {
        i1 &= 0x1FFF;
        n = 13;
        for (;;)
        {
          j = i + 1;
          i = str.charAt(i);
          if (i < 55296) {
            break;
          }
          i1 |= (i & 0x1FFF) << n;
          n += 13;
          i = j;
        }
        n = i1 | i << n;
      }
      int i3;
      if (n == 0)
      {
        paramClass = zzzh;
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        i = 0;
        n = k;
        k = i2;
      }
      else
      {
        i = j + 1;
        n = str.charAt(j);
        j = n;
        i1 = i;
        if (n >= 55296)
        {
          j = n & 0x1FFF;
          n = 13;
          i1 = i;
          i = j;
          for (;;)
          {
            j = i1 + 1;
            i1 = str.charAt(i1);
            if (i1 < 55296) {
              break;
            }
            i |= (i1 & 0x1FFF) << n;
            n += 13;
            i1 = j;
          }
          i |= i1 << n;
          i1 = j;
          j = i;
        }
        n = i1 + 1;
        i = str.charAt(i1);
        i2 = i;
        i1 = n;
        if (i >= 55296)
        {
          i1 = i & 0x1FFF;
          i = 13;
          for (k = n;; k = n)
          {
            n = k + 1;
            k = str.charAt(k);
            if (k < 55296) {
              break;
            }
            i1 |= (k & 0x1FFF) << i;
            i += 13;
          }
          i2 = i1 | k << i;
          i1 = n;
        }
        i = i1 + 1;
        k = str.charAt(i1);
        n = k;
        i1 = i;
        if (k >= 55296)
        {
          i1 = k & 0x1FFF;
          n = 13;
          for (k = i;; k = i)
          {
            i = k + 1;
            k = str.charAt(k);
            if (k < 55296) {
              break;
            }
            i1 |= (k & 0x1FFF) << n;
            n += 13;
          }
          n = i1 | k << n;
          i1 = i;
        }
        i = i1 + 1;
        i5 = str.charAt(i1);
        i1 = i5;
        k = i;
        if (i5 >= 55296)
        {
          k = i5 & 0x1FFF;
          i1 = 13;
          for (i5 = i;; i5 = i)
          {
            i = i5 + 1;
            i5 = str.charAt(i5);
            if (i5 < 55296) {
              break;
            }
            k |= (i5 & 0x1FFF) << i1;
            i1 += 13;
          }
          i1 = k | i5 << i1;
          k = i;
        }
        i = k + 1;
        i3 = str.charAt(k);
        k = i3;
        i5 = i;
        if (i3 >= 55296)
        {
          i5 = i3 & 0x1FFF;
          k = 13;
          for (i3 = i;; i3 = i)
          {
            i = i3 + 1;
            i3 = str.charAt(i3);
            if (i3 < 55296) {
              break;
            }
            i5 |= (i3 & 0x1FFF) << k;
            k += 13;
          }
          k = i5 | i3 << k;
          i5 = i;
        }
        i = i5 + 1;
        i4 = str.charAt(i5);
        i5 = i4;
        i3 = i;
        if (i4 >= 55296)
        {
          i3 = i4 & 0x1FFF;
          i5 = 13;
          for (i4 = i;; i4 = i)
          {
            i = i4 + 1;
            i4 = str.charAt(i4);
            if (i4 < 55296) {
              break;
            }
            i3 |= (i4 & 0x1FFF) << i5;
            i5 += 13;
          }
          i5 = i3 | i4 << i5;
          i3 = i;
        }
        i = i3 + 1;
        i6 = str.charAt(i3);
        i4 = i6;
        i3 = i;
        if (i6 >= 55296)
        {
          i4 = i6 & 0x1FFF;
          i3 = 13;
          for (i6 = i;; i6 = i)
          {
            i = i6 + 1;
            i6 = str.charAt(i6);
            if (i6 < 55296) {
              break;
            }
            i4 |= (i6 & 0x1FFF) << i3;
            i3 += 13;
          }
          i4 |= i6 << i3;
          i3 = i;
        }
        i6 = i3 + 1;
        i7 = str.charAt(i3);
        i3 = i7;
        i = i6;
        if (i7 >= 55296)
        {
          i3 = i7 & 0x1FFF;
          i7 = i6;
          i = 13;
          i6 = i3;
          for (;;)
          {
            i3 = i7 + 1;
            i7 = str.charAt(i7);
            if (i7 < 55296) {
              break;
            }
            i6 |= (i7 & 0x1FFF) << i;
            i += 13;
            i7 = i3;
          }
          i6 |= i7 << i;
          i = i3;
          i3 = i6;
        }
        paramClass = new int[i3 + i5 + i4];
        i6 = (j << 1) + i2;
        i2 = j;
        j = i;
        i = i3;
        i4 = k;
        i3 = i1;
        k = n;
        i1 = i6;
        n = i2;
      }
      Unsafe localUnsafe = zzzi;
      Object[] arrayOfObject = localzziu.zzhr();
      Class localClass = localzziu.zzhl().getClass();
      int[] arrayOfInt = new int[i4 * 3];
      paramzzif = new Object[i4 << 1];
      int i8 = i + i5;
      int i5 = i1;
      int i2 = i;
      int i4 = j;
      i1 = i8;
      int i6 = 0;
      int i9 = 0;
      j = i2;
      i2 = i6;
      i6 = i3;
      int i7 = k;
      k = i4;
      int i10 = n;
      n = m;
      while (k < n)
      {
        m = k + 1;
        k = str.charAt(k);
        if (k >= 55296)
        {
          i4 = k & 0x1FFF;
          k = 13;
          for (;;)
          {
            i3 = m + 1;
            m = str.charAt(m);
            if (m < 55296) {
              break;
            }
            i4 |= (m & 0x1FFF) << k;
            k += 13;
            m = i3;
          }
          m = i4 | m << k;
        }
        else
        {
          i3 = m;
          m = k;
        }
        k = i3 + 1;
        int i11 = str.charAt(i3);
        if (i11 >= 55296)
        {
          i12 = i11 & 0x1FFF;
          i3 = 13;
          for (;;)
          {
            i4 = k + 1;
            i11 = str.charAt(k);
            k = i;
            if (i11 < 55296) {
              break;
            }
            i12 |= (i11 & 0x1FFF) << i3;
            i3 += 13;
            i = k;
            k = i4;
          }
          i11 = i12 | i11 << i3;
          i3 = i4;
        }
        else
        {
          i3 = k;
          k = i;
        }
        int i13 = i11 & 0xFF;
        int i12 = i2;
        if ((i11 & 0x400) != 0)
        {
          paramClass[i2] = i9;
          i12 = i2 + 1;
        }
        Object localObject;
        if (i13 >= 51)
        {
          i4 = i3 + 1;
          i3 = str.charAt(i3);
          i2 = i3;
          i = i4;
          if (i3 >= 55296)
          {
            i2 = i3 & 0x1FFF;
            i3 = 13;
            for (;;)
            {
              i = i4 + 1;
              i4 = str.charAt(i4);
              if (i4 < 55296) {
                break;
              }
              i2 |= (i4 & 0x1FFF) << i3;
              i3 += 13;
              i4 = i;
            }
            i2 |= i4 << i3;
          }
          i4 = i13 - 51;
          if ((i4 != 9) && (i4 != 17))
          {
            i3 = i5;
            if (i4 == 12)
            {
              i3 = i5;
              if (!bool)
              {
                paramzzif[((i9 / 3 << 1) + 1)] = arrayOfObject[i5];
                i3 = i5 + 1;
              }
            }
            i5 = i3;
          }
          else
          {
            paramzzif[((i9 / 3 << 1) + 1)] = arrayOfObject[i5];
            i5++;
          }
          i3 = i2 << 1;
          localObject = arrayOfObject[i3];
          if ((localObject instanceof Field))
          {
            localObject = (Field)localObject;
          }
          else
          {
            localObject = zza(localClass, (String)localObject);
            arrayOfObject[i3] = localObject;
          }
          i4 = (int)localUnsafe.objectFieldOffset((Field)localObject);
          i3++;
          localObject = arrayOfObject[i3];
          if ((localObject instanceof Field))
          {
            localObject = (Field)localObject;
          }
          else
          {
            localObject = zza(localClass, (String)localObject);
            arrayOfObject[i3] = localObject;
          }
          i2 = (int)localUnsafe.objectFieldOffset((Field)localObject);
          i3 = 0;
        }
        else
        {
          i2 = i5 + 1;
          localObject = zza(localClass, (String)arrayOfObject[i5]);
          if ((i13 != 9) && (i13 != 17))
          {
            if ((i13 != 27) && (i13 != 49))
            {
              if ((i13 != 12) && (i13 != 30) && (i13 != 44))
              {
                i = i2;
                i5 = j;
                if (i13 != 50) {
                  break label2121;
                }
                i = j + 1;
                paramClass[j] = i9;
                i4 = i9 / 3 << 1;
                i5 = i2 + 1;
                paramzzif[i4] = arrayOfObject[i2];
                if ((i11 & 0x800) != 0)
                {
                  j = i5 + 1;
                  paramzzif[(i4 + 1)] = arrayOfObject[i5];
                  i5 = i;
                  i = j;
                  break label2121;
                }
                j = i;
                i = i5;
              }
              else if (!bool)
              {
                i5 = i9 / 3;
                i = i2 + 1;
                paramzzif[((i5 << 1) + 1)] = arrayOfObject[i2];
              }
              else
              {
                i = i2;
                i5 = j;
                break label2121;
              }
            }
            else
            {
              i5 = i9 / 3;
              i = i2 + 1;
              paramzzif[((i5 << 1) + 1)] = arrayOfObject[i2];
            }
            break label2125;
          }
          else
          {
            paramzzif[((i9 / 3 << 1) + 1)] = ((Field)localObject).getType();
            i5 = j;
            i = i2;
          }
          label2121:
          j = i5;
          label2125:
          i14 = (int)localUnsafe.objectFieldOffset((Field)localObject);
          if (((i11 & 0x1000) == 4096) && (i13 <= 17))
          {
            i2 = i3 + 1;
            i4 = str.charAt(i3);
            i3 = i4;
            i5 = i2;
            if (i4 >= 55296)
            {
              i5 = i4 & 0x1FFF;
              i3 = 13;
              i4 = i2;
              i2 = i5;
              for (;;)
              {
                i5 = i4 + 1;
                i4 = str.charAt(i4);
                if (i4 < 55296) {
                  break;
                }
                i2 |= (i4 & 0x1FFF) << i3;
                i3 += 13;
                i4 = i5;
              }
              i3 = i2 | i4 << i3;
            }
            i2 = (i10 << 1) + i3 / 32;
            localObject = arrayOfObject[i2];
            if ((localObject instanceof Field))
            {
              localObject = (Field)localObject;
            }
            else
            {
              localObject = zza(localClass, (String)localObject);
              arrayOfObject[i2] = localObject;
            }
            i2 = (int)localUnsafe.objectFieldOffset((Field)localObject);
            i3 %= 32;
            i4 = i5;
          }
          else
          {
            i2 = 1048575;
            i5 = 0;
            i4 = i3;
            i3 = i5;
          }
          i5 = i1;
          if (i13 >= 18)
          {
            i5 = i1;
            if (i13 <= 49)
            {
              paramClass[i1] = i14;
              i5 = i1 + 1;
            }
          }
          i1 = i5;
          i5 = i;
          i = i4;
          i4 = i14;
        }
        int i15 = i9 + 1;
        arrayOfInt[i9] = m;
        int i14 = i15 + 1;
        if ((i11 & 0x200) != 0) {
          i9 = 536870912;
        } else {
          i9 = 0;
        }
        if ((i11 & 0x100) != 0) {
          m = 268435456;
        } else {
          m = 0;
        }
        arrayOfInt[i15] = (m | i9 | i13 << 20 | i4);
        arrayOfInt[i14] = (i3 << 20 | i2);
        i3 = i;
        i = k;
        i9 = i14 + 1;
        k = i3;
        i2 = i12;
      }
      return new zzil(arrayOfInt, paramzzif, i7, i6, localzziu.zzhl(), bool, false, paramClass, i, i8, paramzzip, paramzzhr, paramzzjo, paramzzgk, paramzzia);
    }
    ((zzjl)paramzzif).zzhj();
    int j = zzgx.zzf.zzxj;
    throw new NoSuchMethodError();
  }
  
  private final <K, V, UT, UB> UB zza(int paramInt1, int paramInt2, Map<K, V> paramMap, zzhd paramzzhd, UB paramUB, zzjo<UT, UB> paramzzjo)
  {
    zzhy localzzhy = this.zzzz.zzq(zzbo(paramInt1));
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!paramzzhd.zzg(((Integer)localEntry.getValue()).intValue()))
      {
        paramMap = paramUB;
        if (paramUB == null) {
          paramMap = paramzzjo.zzig();
        }
        paramUB = zzfm.zzaq(zzhz.zza(localzzhy, localEntry.getKey(), localEntry.getValue()));
        zzgf localzzgf = paramUB.zzex();
        try
        {
          zzhz.zza(localzzgf, localzzhy, localEntry.getKey(), localEntry.getValue());
          paramzzjo.zza(paramMap, paramInt2, paramUB.zzew());
          localIterator.remove();
          paramUB = paramMap;
        }
        catch (IOException paramMap)
        {
          throw new RuntimeException(paramMap);
        }
      }
    }
    return paramUB;
  }
  
  private final <UT, UB> UB zza(Object paramObject, int paramInt, UB paramUB, zzjo<UT, UB> paramzzjo)
  {
    int i = this.zzzj[paramInt];
    Object localObject = zzju.zzp(paramObject, zzbq(paramInt) & 0xFFFFF);
    if (localObject == null) {
      return paramUB;
    }
    paramObject = zzbp(paramInt);
    if (paramObject == null) {
      return paramUB;
    }
    return (UB)zza(paramInt, i, this.zzzz.zzl(localObject), (zzhd)paramObject, paramUB, paramzzjo);
  }
  
  private static Field zza(Class<?> paramClass, String paramString)
  {
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (localObject2 : paramClass.getDeclaredFields()) {
        if (paramString.equals(((Field)localObject2).getName())) {
          return (Field)localObject2;
        }
      }
      paramClass = paramClass.getName();
      Object localObject2 = Arrays.toString((Object[])???);
      ??? = new StringBuilder(String.valueOf(paramString).length() + 40 + paramClass.length() + String.valueOf(localObject2).length());
      ((StringBuilder)???).append("Field ");
      ((StringBuilder)???).append(paramString);
      ((StringBuilder)???).append(" for ");
      ((StringBuilder)???).append(paramClass);
      ((StringBuilder)???).append(" not found. Known fields are ");
      ((StringBuilder)???).append((String)localObject2);
      throw new RuntimeException(((StringBuilder)???).toString());
    }
  }
  
  private static void zza(int paramInt, Object paramObject, zzkl paramzzkl)
    throws IOException
  {
    if ((paramObject instanceof String))
    {
      paramzzkl.zza(paramInt, (String)paramObject);
      return;
    }
    paramzzkl.zza(paramInt, (zzfm)paramObject);
  }
  
  private static <UT, UB> void zza(zzjo<UT, UB> paramzzjo, T paramT, zzkl paramzzkl)
    throws IOException
  {
    paramzzjo.zza(paramzzjo.zzw(paramT), paramzzkl);
  }
  
  private final <K, V> void zza(zzkl paramzzkl, int paramInt1, Object paramObject, int paramInt2)
    throws IOException
  {
    if (paramObject != null) {
      paramzzkl.zza(paramInt1, this.zzzz.zzq(zzbo(paramInt2)), this.zzzz.zzm(paramObject));
    }
  }
  
  private final void zza(Object paramObject, int paramInt, zzix paramzzix)
    throws IOException
  {
    if (zzbs(paramInt))
    {
      zzju.zza(paramObject, paramInt & 0xFFFFF, paramzzix.zzed());
      return;
    }
    if (this.zzzp)
    {
      zzju.zza(paramObject, paramInt & 0xFFFFF, paramzzix.readString());
      return;
    }
    zzju.zza(paramObject, paramInt & 0xFFFFF, paramzzix.zzee());
  }
  
  private final void zza(T paramT1, T paramT2, int paramInt)
  {
    long l = zzbq(paramInt) & 0xFFFFF;
    if (!zza(paramT2, paramInt)) {
      return;
    }
    Object localObject = zzju.zzp(paramT1, l);
    paramT2 = zzju.zzp(paramT2, l);
    if ((localObject != null) && (paramT2 != null))
    {
      zzju.zza(paramT1, l, zzgy.zzb(localObject, paramT2));
      zzb(paramT1, paramInt);
      return;
    }
    if (paramT2 != null)
    {
      zzju.zza(paramT1, l, paramT2);
      zzb(paramT1, paramInt);
    }
  }
  
  private final boolean zza(T paramT, int paramInt)
  {
    int i = zzbr(paramInt);
    long l = i & 0xFFFFF;
    if (l == 1048575L)
    {
      paramInt = zzbq(paramInt);
      l = paramInt & 0xFFFFF;
      switch ((paramInt & 0xFF00000) >>> 20)
      {
      default: 
        throw new IllegalArgumentException();
      case 17: 
        return zzju.zzp(paramT, l) != null;
      case 16: 
        return zzju.zzl(paramT, l) != 0L;
      case 15: 
        return zzju.zzk(paramT, l) != 0;
      case 14: 
        return zzju.zzl(paramT, l) != 0L;
      case 13: 
        return zzju.zzk(paramT, l) != 0;
      case 12: 
        return zzju.zzk(paramT, l) != 0;
      case 11: 
        return zzju.zzk(paramT, l) != 0;
      case 10: 
        return !zzfm.zzsm.equals(zzju.zzp(paramT, l));
      case 9: 
        return zzju.zzp(paramT, l) != null;
      case 8: 
        paramT = zzju.zzp(paramT, l);
        if ((paramT instanceof String)) {
          return !((String)paramT).isEmpty();
        }
        if ((paramT instanceof zzfm)) {
          return !zzfm.zzsm.equals(paramT);
        }
        throw new IllegalArgumentException();
      case 7: 
        return zzju.zzm(paramT, l);
      case 6: 
        return zzju.zzk(paramT, l) != 0;
      case 5: 
        return zzju.zzl(paramT, l) != 0L;
      case 4: 
        return zzju.zzk(paramT, l) != 0;
      case 3: 
        return zzju.zzl(paramT, l) != 0L;
      case 2: 
        return zzju.zzl(paramT, l) != 0L;
      case 1: 
        return zzju.zzn(paramT, l) != 0.0F;
      }
      return zzju.zzo(paramT, l) != 0.0D;
    }
    return (zzju.zzk(paramT, l) & 1 << (i >>> 20)) != 0;
  }
  
  private final boolean zza(T paramT, int paramInt1, int paramInt2)
  {
    return zzju.zzk(paramT, zzbr(paramInt2) & 0xFFFFF) == paramInt1;
  }
  
  private final boolean zza(T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 == 1048575) {
      return zza(paramT, paramInt1);
    }
    return (paramInt3 & paramInt4) != 0;
  }
  
  private static boolean zza(Object paramObject, int paramInt, zziw paramzziw)
  {
    return paramzziw.zzu(zzju.zzp(paramObject, paramInt & 0xFFFFF));
  }
  
  private final void zzb(T paramT, int paramInt)
  {
    paramInt = zzbr(paramInt);
    long l = 0xFFFFF & paramInt;
    if (l == 1048575L) {
      return;
    }
    zzju.zzb(paramT, l, 1 << (paramInt >>> 20) | zzju.zzk(paramT, l));
  }
  
  private final void zzb(T paramT, int paramInt1, int paramInt2)
  {
    zzju.zzb(paramT, zzbr(paramInt2) & 0xFFFFF, paramInt1);
  }
  
  private final void zzb(T paramT, zzkl paramzzkl)
    throws IOException
  {
    if (this.zzzo)
    {
      localObject1 = this.zzzy.zzf(paramT);
      if (!((zzgn)localObject1).zztq.isEmpty())
      {
        localIterator = ((zzgn)localObject1).iterator();
        localObject1 = (Map.Entry)localIterator.next();
        break label51;
      }
    }
    Iterator localIterator = null;
    Object localObject1 = null;
    label51:
    int i = this.zzzj.length;
    Unsafe localUnsafe = zzzi;
    int j = 0;
    int k = 1048575;
    int m = 0;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (j >= i) {
        break;
      }
      int n = zzbq(j);
      localObject2 = this.zzzj;
      int i1 = localObject2[j];
      int i2 = (n & 0xFF00000) >>> 20;
      int i4;
      if ((!this.zzzq) && (i2 <= 17))
      {
        int i3 = localObject2[(j + 2)];
        i4 = i3 & 0xFFFFF;
        int i5 = k;
        if (i4 != k)
        {
          m = localUnsafe.getInt(paramT, i4);
          i5 = i4;
        }
        i4 = 1 << (i3 >>> 20);
        k = i5;
      }
      else
      {
        i4 = 0;
      }
      while ((localObject1 != null) && (this.zzzy.zza((Map.Entry)localObject1) <= i1))
      {
        this.zzzy.zza(paramzzkl, (Map.Entry)localObject1);
        if (localIterator.hasNext()) {
          localObject1 = (Map.Entry)localIterator.next();
        } else {
          localObject1 = null;
        }
      }
      long l = n & 0xFFFFF;
      switch (i2)
      {
      }
      for (;;)
      {
        break;
        if (zza(paramT, i1, j))
        {
          paramzzkl.zzb(i1, localUnsafe.getObject(paramT, l), zzbn(j));
          continue;
          if (zza(paramT, i1, j))
          {
            paramzzkl.zzb(i1, zzi(paramT, l));
            continue;
            if (zza(paramT, i1, j))
            {
              paramzzkl.zzj(i1, zzh(paramT, l));
              continue;
              if (zza(paramT, i1, j))
              {
                paramzzkl.zzj(i1, zzi(paramT, l));
                continue;
                if (zza(paramT, i1, j))
                {
                  paramzzkl.zzr(i1, zzh(paramT, l));
                  continue;
                  if (zza(paramT, i1, j))
                  {
                    paramzzkl.zzs(i1, zzh(paramT, l));
                    continue;
                    if (zza(paramT, i1, j))
                    {
                      paramzzkl.zzi(i1, zzh(paramT, l));
                      continue;
                      if (zza(paramT, i1, j))
                      {
                        paramzzkl.zza(i1, (zzfm)localUnsafe.getObject(paramT, l));
                        continue;
                        if (zza(paramT, i1, j))
                        {
                          paramzzkl.zza(i1, localUnsafe.getObject(paramT, l), zzbn(j));
                          continue;
                          if (zza(paramT, i1, j))
                          {
                            zza(i1, localUnsafe.getObject(paramT, l), paramzzkl);
                            continue;
                            if (zza(paramT, i1, j))
                            {
                              paramzzkl.zza(i1, zzj(paramT, l));
                              continue;
                              if (zza(paramT, i1, j))
                              {
                                paramzzkl.zzk(i1, zzh(paramT, l));
                                continue;
                                if (zza(paramT, i1, j))
                                {
                                  paramzzkl.zzc(i1, zzi(paramT, l));
                                  continue;
                                  if (zza(paramT, i1, j))
                                  {
                                    paramzzkl.zzh(i1, zzh(paramT, l));
                                    continue;
                                    if (zza(paramT, i1, j))
                                    {
                                      paramzzkl.zza(i1, zzi(paramT, l));
                                      continue;
                                      if (zza(paramT, i1, j))
                                      {
                                        paramzzkl.zzi(i1, zzi(paramT, l));
                                        continue;
                                        if (zza(paramT, i1, j))
                                        {
                                          paramzzkl.zza(i1, zzg(paramT, l));
                                          continue;
                                          if (zza(paramT, i1, j))
                                          {
                                            paramzzkl.zza(i1, zzf(paramT, l));
                                            continue;
                                            zza(paramzzkl, i1, localUnsafe.getObject(paramT, l), j);
                                            continue;
                                            zziy.zzb(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, zzbn(j));
                                            continue;
                                            zziy.zze(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zzj(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zzg(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zzl(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zzm(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zzi(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zzn(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zzk(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zzf(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zzh(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zzd(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zzc(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zzb(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zza(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, true);
                                            continue;
                                            zziy.zze(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            zziy.zzj(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            zziy.zzg(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            zziy.zzl(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            zziy.zzm(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            zziy.zzi(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            zziy.zzb(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl);
                                            continue;
                                            zziy.zza(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, zzbn(j));
                                            continue;
                                            zziy.zza(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl);
                                            continue;
                                            zziy.zzn(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            zziy.zzk(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            zziy.zzf(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            zziy.zzh(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            zziy.zzd(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            zziy.zzc(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            zziy.zzb(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            zziy.zza(this.zzzj[j], (List)localUnsafe.getObject(paramT, l), paramzzkl, false);
                                            continue;
                                            if ((i4 & m) != 0)
                                            {
                                              paramzzkl.zzb(i1, localUnsafe.getObject(paramT, l), zzbn(j));
                                              break;
                                              if ((i4 & m) != 0)
                                              {
                                                paramzzkl.zzb(i1, localUnsafe.getLong(paramT, l));
                                                break;
                                                if ((i4 & m) != 0)
                                                {
                                                  paramzzkl.zzj(i1, localUnsafe.getInt(paramT, l));
                                                  break;
                                                  if ((i4 & m) != 0)
                                                  {
                                                    paramzzkl.zzj(i1, localUnsafe.getLong(paramT, l));
                                                    break;
                                                    if ((i4 & m) != 0)
                                                    {
                                                      paramzzkl.zzr(i1, localUnsafe.getInt(paramT, l));
                                                      break;
                                                      if ((i4 & m) != 0)
                                                      {
                                                        paramzzkl.zzs(i1, localUnsafe.getInt(paramT, l));
                                                        break;
                                                        if ((i4 & m) != 0)
                                                        {
                                                          paramzzkl.zzi(i1, localUnsafe.getInt(paramT, l));
                                                          break;
                                                          if ((i4 & m) != 0)
                                                          {
                                                            paramzzkl.zza(i1, (zzfm)localUnsafe.getObject(paramT, l));
                                                            break;
                                                            if ((i4 & m) != 0)
                                                            {
                                                              paramzzkl.zza(i1, localUnsafe.getObject(paramT, l), zzbn(j));
                                                              break;
                                                              if ((i4 & m) != 0)
                                                              {
                                                                zza(i1, localUnsafe.getObject(paramT, l), paramzzkl);
                                                                break;
                                                                if ((i4 & m) != 0)
                                                                {
                                                                  paramzzkl.zza(i1, zzju.zzm(paramT, l));
                                                                  break;
                                                                  if ((i4 & m) != 0)
                                                                  {
                                                                    paramzzkl.zzk(i1, localUnsafe.getInt(paramT, l));
                                                                    break;
                                                                    if ((i4 & m) != 0)
                                                                    {
                                                                      paramzzkl.zzc(i1, localUnsafe.getLong(paramT, l));
                                                                      break;
                                                                      if ((i4 & m) != 0)
                                                                      {
                                                                        paramzzkl.zzh(i1, localUnsafe.getInt(paramT, l));
                                                                        break;
                                                                        if ((i4 & m) != 0)
                                                                        {
                                                                          paramzzkl.zza(i1, localUnsafe.getLong(paramT, l));
                                                                          break;
                                                                          if ((i4 & m) != 0)
                                                                          {
                                                                            paramzzkl.zzi(i1, localUnsafe.getLong(paramT, l));
                                                                            break;
                                                                            if ((i4 & m) != 0)
                                                                            {
                                                                              paramzzkl.zza(i1, zzju.zzn(paramT, l));
                                                                              break;
                                                                              if ((i4 & m) != 0) {
                                                                                paramzzkl.zza(i1, zzju.zzo(paramT, l));
                                                                              }
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      j += 3;
    }
    while (localObject2 != null)
    {
      this.zzzy.zza(paramzzkl, (Map.Entry)localObject2);
      if (localIterator.hasNext()) {
        localObject2 = (Map.Entry)localIterator.next();
      } else {
        localObject2 = null;
      }
    }
    zza(this.zzzx, paramT, paramzzkl);
  }
  
  private final void zzb(T paramT1, T paramT2, int paramInt)
  {
    int i = zzbq(paramInt);
    int j = this.zzzj[paramInt];
    long l = i & 0xFFFFF;
    if (!zza(paramT2, j, paramInt)) {
      return;
    }
    Object localObject = zzju.zzp(paramT1, l);
    paramT2 = zzju.zzp(paramT2, l);
    if ((localObject != null) && (paramT2 != null))
    {
      zzju.zza(paramT1, l, zzgy.zzb(localObject, paramT2));
      zzb(paramT1, j, paramInt);
      return;
    }
    if (paramT2 != null)
    {
      zzju.zza(paramT1, l, paramT2);
      zzb(paramT1, j, paramInt);
    }
  }
  
  private final zziw zzbn(int paramInt)
  {
    paramInt = paramInt / 3 << 1;
    zziw localzziw = (zziw)this.zzzk[paramInt];
    if (localzziw != null) {
      return localzziw;
    }
    localzziw = zzis.zzhp().zzf((Class)this.zzzk[(paramInt + 1)]);
    this.zzzk[paramInt] = localzziw;
    return localzziw;
  }
  
  private final Object zzbo(int paramInt)
  {
    return this.zzzk[(paramInt / 3 << 1)];
  }
  
  private final zzhd zzbp(int paramInt)
  {
    return (zzhd)this.zzzk[((paramInt / 3 << 1) + 1)];
  }
  
  private final int zzbq(int paramInt)
  {
    return this.zzzj[(paramInt + 1)];
  }
  
  private final int zzbr(int paramInt)
  {
    return this.zzzj[(paramInt + 2)];
  }
  
  private static boolean zzbs(int paramInt)
  {
    return (paramInt & 0x20000000) != 0;
  }
  
  private final int zzbt(int paramInt)
  {
    if ((paramInt >= this.zzzl) && (paramInt <= this.zzzm)) {
      return zzu(paramInt, 0);
    }
    return -1;
  }
  
  private final boolean zzc(T paramT1, T paramT2, int paramInt)
  {
    return zza(paramT1, paramInt) == zza(paramT2, paramInt);
  }
  
  private static List<?> zze(Object paramObject, long paramLong)
  {
    return (List)zzju.zzp(paramObject, paramLong);
  }
  
  private static <T> double zzf(T paramT, long paramLong)
  {
    return ((Double)zzju.zzp(paramT, paramLong)).doubleValue();
  }
  
  private static <T> float zzg(T paramT, long paramLong)
  {
    return ((Float)zzju.zzp(paramT, paramLong)).floatValue();
  }
  
  private static <T> int zzh(T paramT, long paramLong)
  {
    return ((Integer)zzju.zzp(paramT, paramLong)).intValue();
  }
  
  private static <T> long zzi(T paramT, long paramLong)
  {
    return ((Long)zzju.zzp(paramT, paramLong)).longValue();
  }
  
  private static <T> boolean zzj(T paramT, long paramLong)
  {
    return ((Boolean)zzju.zzp(paramT, paramLong)).booleanValue();
  }
  
  private final int zzt(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= this.zzzl) && (paramInt1 <= this.zzzm)) {
      return zzu(paramInt1, paramInt2);
    }
    return -1;
  }
  
  private static zzjr zzt(Object paramObject)
  {
    zzgx localzzgx = (zzgx)paramObject;
    zzjr localzzjr = localzzgx.zzws;
    paramObject = localzzjr;
    if (localzzjr == zzjr.zzih())
    {
      paramObject = zzjr.zzii();
      localzzgx.zzws = ((zzjr)paramObject);
    }
    return (zzjr)paramObject;
  }
  
  private final int zzu(int paramInt1, int paramInt2)
  {
    int i = this.zzzj.length / 3 - 1;
    while (paramInt2 <= i)
    {
      int j = i + paramInt2 >>> 1;
      int k = j * 3;
      int m = this.zzzj[k];
      if (paramInt1 == m) {
        return k;
      }
      if (paramInt1 < m) {
        i = j - 1;
      } else {
        paramInt2 = j + 1;
      }
    }
    return -1;
  }
  
  /* Error */
  public final boolean equals(T paramT1, T paramT2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/google/android/gms/internal/vision/zzil:zzzj	[I
    //   4: arraylength
    //   5: istore_3
    //   6: iconst_0
    //   7: istore 4
    //   9: iconst_1
    //   10: istore 5
    //   12: iload 4
    //   14: iload_3
    //   15: if_icmpge +973 -> 988
    //   18: aload_0
    //   19: iload 4
    //   21: invokespecial 593	com/google/android/gms/internal/vision/zzil:zzbq	(I)I
    //   24: istore 6
    //   26: iload 6
    //   28: ldc 117
    //   30: iand
    //   31: i2l
    //   32: lstore 7
    //   34: iload 6
    //   36: ldc_w 696
    //   39: iand
    //   40: bipush 20
    //   42: iushr
    //   43: tableswitch	default:+289->332, 0:+896->939, 1:+861->904, 2:+831->874, 3:+801->844, 4:+772->815, 5:+742->785, 6:+713->756, 7:+684->727, 8:+652->695, 9:+620->663, 10:+588->631, 11:+559->602, 12:+530->573, 13:+501->544, 14:+471->514, 15:+442->485, 16:+412->455, 17:+380->423, 18:+360->403, 19:+360->403, 20:+360->403, 21:+360->403, 22:+360->403, 23:+360->403, 24:+360->403, 25:+360->403, 26:+360->403, 27:+360->403, 28:+360->403, 29:+360->403, 30:+360->403, 31:+360->403, 32:+360->403, 33:+360->403, 34:+360->403, 35:+360->403, 36:+360->403, 37:+360->403, 38:+360->403, 39:+360->403, 40:+360->403, 41:+360->403, 42:+360->403, 43:+360->403, 44:+360->403, 45:+360->403, 46:+360->403, 47:+360->403, 48:+360->403, 49:+360->403, 50:+340->383, 51:+292->335, 52:+292->335, 53:+292->335, 54:+292->335, 55:+292->335, 56:+292->335, 57:+292->335, 58:+292->335, 59:+292->335, 60:+292->335, 61:+292->335, 62:+292->335, 63:+292->335, 64:+292->335, 65:+292->335, 66:+292->335, 67:+292->335, 68:+292->335
    //   332: goto +643 -> 975
    //   335: aload_0
    //   336: iload 4
    //   338: invokespecial 693	com/google/android/gms/internal/vision/zzil:zzbr	(I)I
    //   341: ldc 117
    //   343: iand
    //   344: i2l
    //   345: lstore 9
    //   347: aload_1
    //   348: lload 9
    //   350: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   353: aload_2
    //   354: lload 9
    //   356: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   359: if_icmpne +613 -> 972
    //   362: aload_1
    //   363: lload 7
    //   365: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   368: aload_2
    //   369: lload 7
    //   371: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   374: invokestatic 887	com/google/android/gms/internal/vision/zziy:zze	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   377: ifne +598 -> 975
    //   380: goto +592 -> 972
    //   383: aload_1
    //   384: lload 7
    //   386: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   389: aload_2
    //   390: lload 7
    //   392: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   395: invokestatic 887	com/google/android/gms/internal/vision/zziy:zze	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   398: istore 5
    //   400: goto +575 -> 975
    //   403: aload_1
    //   404: lload 7
    //   406: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   409: aload_2
    //   410: lload 7
    //   412: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   415: invokestatic 887	com/google/android/gms/internal/vision/zziy:zze	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   418: istore 5
    //   420: goto +555 -> 975
    //   423: aload_0
    //   424: aload_1
    //   425: aload_2
    //   426: iload 4
    //   428: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   431: ifeq +541 -> 972
    //   434: aload_1
    //   435: lload 7
    //   437: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   440: aload_2
    //   441: lload 7
    //   443: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   446: invokestatic 887	com/google/android/gms/internal/vision/zziy:zze	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   449: ifne +526 -> 975
    //   452: goto +520 -> 972
    //   455: aload_0
    //   456: aload_1
    //   457: aload_2
    //   458: iload 4
    //   460: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   463: ifeq +509 -> 972
    //   466: aload_1
    //   467: lload 7
    //   469: invokestatic 702	com/google/android/gms/internal/vision/zzju:zzl	(Ljava/lang/Object;J)J
    //   472: aload_2
    //   473: lload 7
    //   475: invokestatic 702	com/google/android/gms/internal/vision/zzju:zzl	(Ljava/lang/Object;J)J
    //   478: lcmp
    //   479: ifeq +496 -> 975
    //   482: goto +490 -> 972
    //   485: aload_0
    //   486: aload_1
    //   487: aload_2
    //   488: iload 4
    //   490: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   493: ifeq +479 -> 972
    //   496: aload_1
    //   497: lload 7
    //   499: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   502: aload_2
    //   503: lload 7
    //   505: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   508: if_icmpeq +467 -> 975
    //   511: goto +461 -> 972
    //   514: aload_0
    //   515: aload_1
    //   516: aload_2
    //   517: iload 4
    //   519: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   522: ifeq +450 -> 972
    //   525: aload_1
    //   526: lload 7
    //   528: invokestatic 702	com/google/android/gms/internal/vision/zzju:zzl	(Ljava/lang/Object;J)J
    //   531: aload_2
    //   532: lload 7
    //   534: invokestatic 702	com/google/android/gms/internal/vision/zzju:zzl	(Ljava/lang/Object;J)J
    //   537: lcmp
    //   538: ifeq +437 -> 975
    //   541: goto +431 -> 972
    //   544: aload_0
    //   545: aload_1
    //   546: aload_2
    //   547: iload 4
    //   549: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   552: ifeq +420 -> 972
    //   555: aload_1
    //   556: lload 7
    //   558: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   561: aload_2
    //   562: lload 7
    //   564: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   567: if_icmpeq +408 -> 975
    //   570: goto +402 -> 972
    //   573: aload_0
    //   574: aload_1
    //   575: aload_2
    //   576: iload 4
    //   578: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   581: ifeq +391 -> 972
    //   584: aload_1
    //   585: lload 7
    //   587: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   590: aload_2
    //   591: lload 7
    //   593: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   596: if_icmpeq +379 -> 975
    //   599: goto +373 -> 972
    //   602: aload_0
    //   603: aload_1
    //   604: aload_2
    //   605: iload 4
    //   607: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   610: ifeq +362 -> 972
    //   613: aload_1
    //   614: lload 7
    //   616: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   619: aload_2
    //   620: lload 7
    //   622: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   625: if_icmpeq +350 -> 975
    //   628: goto +344 -> 972
    //   631: aload_0
    //   632: aload_1
    //   633: aload_2
    //   634: iload 4
    //   636: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   639: ifeq +333 -> 972
    //   642: aload_1
    //   643: lload 7
    //   645: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   648: aload_2
    //   649: lload 7
    //   651: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   654: invokestatic 887	com/google/android/gms/internal/vision/zziy:zze	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   657: ifne +318 -> 975
    //   660: goto +312 -> 972
    //   663: aload_0
    //   664: aload_1
    //   665: aload_2
    //   666: iload 4
    //   668: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   671: ifeq +301 -> 972
    //   674: aload_1
    //   675: lload 7
    //   677: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   680: aload_2
    //   681: lload 7
    //   683: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   686: invokestatic 887	com/google/android/gms/internal/vision/zziy:zze	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   689: ifne +286 -> 975
    //   692: goto +280 -> 972
    //   695: aload_0
    //   696: aload_1
    //   697: aload_2
    //   698: iload 4
    //   700: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   703: ifeq +269 -> 972
    //   706: aload_1
    //   707: lload 7
    //   709: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   712: aload_2
    //   713: lload 7
    //   715: invokestatic 595	com/google/android/gms/internal/vision/zzju:zzp	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   718: invokestatic 887	com/google/android/gms/internal/vision/zziy:zze	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   721: ifne +254 -> 975
    //   724: goto +248 -> 972
    //   727: aload_0
    //   728: aload_1
    //   729: aload_2
    //   730: iload 4
    //   732: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   735: ifeq +237 -> 972
    //   738: aload_1
    //   739: lload 7
    //   741: invokestatic 712	com/google/android/gms/internal/vision/zzju:zzm	(Ljava/lang/Object;J)Z
    //   744: aload_2
    //   745: lload 7
    //   747: invokestatic 712	com/google/android/gms/internal/vision/zzju:zzm	(Ljava/lang/Object;J)Z
    //   750: if_icmpeq +225 -> 975
    //   753: goto +219 -> 972
    //   756: aload_0
    //   757: aload_1
    //   758: aload_2
    //   759: iload 4
    //   761: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   764: ifeq +208 -> 972
    //   767: aload_1
    //   768: lload 7
    //   770: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   773: aload_2
    //   774: lload 7
    //   776: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   779: if_icmpeq +196 -> 975
    //   782: goto +190 -> 972
    //   785: aload_0
    //   786: aload_1
    //   787: aload_2
    //   788: iload 4
    //   790: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   793: ifeq +179 -> 972
    //   796: aload_1
    //   797: lload 7
    //   799: invokestatic 702	com/google/android/gms/internal/vision/zzju:zzl	(Ljava/lang/Object;J)J
    //   802: aload_2
    //   803: lload 7
    //   805: invokestatic 702	com/google/android/gms/internal/vision/zzju:zzl	(Ljava/lang/Object;J)J
    //   808: lcmp
    //   809: ifeq +166 -> 975
    //   812: goto +160 -> 972
    //   815: aload_0
    //   816: aload_1
    //   817: aload_2
    //   818: iload 4
    //   820: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   823: ifeq +149 -> 972
    //   826: aload_1
    //   827: lload 7
    //   829: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   832: aload_2
    //   833: lload 7
    //   835: invokestatic 705	com/google/android/gms/internal/vision/zzju:zzk	(Ljava/lang/Object;J)I
    //   838: if_icmpeq +137 -> 975
    //   841: goto +131 -> 972
    //   844: aload_0
    //   845: aload_1
    //   846: aload_2
    //   847: iload 4
    //   849: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   852: ifeq +120 -> 972
    //   855: aload_1
    //   856: lload 7
    //   858: invokestatic 702	com/google/android/gms/internal/vision/zzju:zzl	(Ljava/lang/Object;J)J
    //   861: aload_2
    //   862: lload 7
    //   864: invokestatic 702	com/google/android/gms/internal/vision/zzju:zzl	(Ljava/lang/Object;J)J
    //   867: lcmp
    //   868: ifeq +107 -> 975
    //   871: goto +101 -> 972
    //   874: aload_0
    //   875: aload_1
    //   876: aload_2
    //   877: iload 4
    //   879: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   882: ifeq +90 -> 972
    //   885: aload_1
    //   886: lload 7
    //   888: invokestatic 702	com/google/android/gms/internal/vision/zzju:zzl	(Ljava/lang/Object;J)J
    //   891: aload_2
    //   892: lload 7
    //   894: invokestatic 702	com/google/android/gms/internal/vision/zzju:zzl	(Ljava/lang/Object;J)J
    //   897: lcmp
    //   898: ifeq +77 -> 975
    //   901: goto +71 -> 972
    //   904: aload_0
    //   905: aload_1
    //   906: aload_2
    //   907: iload 4
    //   909: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   912: ifeq +60 -> 972
    //   915: aload_1
    //   916: lload 7
    //   918: invokestatic 715	com/google/android/gms/internal/vision/zzju:zzn	(Ljava/lang/Object;J)F
    //   921: invokestatic 893	java/lang/Float:floatToIntBits	(F)I
    //   924: aload_2
    //   925: lload 7
    //   927: invokestatic 715	com/google/android/gms/internal/vision/zzju:zzn	(Ljava/lang/Object;J)F
    //   930: invokestatic 893	java/lang/Float:floatToIntBits	(F)I
    //   933: if_icmpeq +42 -> 975
    //   936: goto +36 -> 972
    //   939: aload_0
    //   940: aload_1
    //   941: aload_2
    //   942: iload 4
    //   944: invokespecial 889	com/google/android/gms/internal/vision/zzil:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   947: ifeq +25 -> 972
    //   950: aload_1
    //   951: lload 7
    //   953: invokestatic 719	com/google/android/gms/internal/vision/zzju:zzo	(Ljava/lang/Object;J)D
    //   956: invokestatic 897	java/lang/Double:doubleToLongBits	(D)J
    //   959: aload_2
    //   960: lload 7
    //   962: invokestatic 719	com/google/android/gms/internal/vision/zzju:zzo	(Ljava/lang/Object;J)D
    //   965: invokestatic 897	java/lang/Double:doubleToLongBits	(D)J
    //   968: lcmp
    //   969: ifeq +6 -> 975
    //   972: iconst_0
    //   973: istore 5
    //   975: iload 5
    //   977: ifne +5 -> 982
    //   980: iconst_0
    //   981: ireturn
    //   982: iinc 4 3
    //   985: goto -976 -> 9
    //   988: aload_0
    //   989: getfield 92	com/google/android/gms/internal/vision/zzil:zzzx	Lcom/google/android/gms/internal/vision/zzjo;
    //   992: aload_1
    //   993: invokevirtual 108	com/google/android/gms/internal/vision/zzjo:zzw	(Ljava/lang/Object;)Ljava/lang/Object;
    //   996: aload_0
    //   997: getfield 92	com/google/android/gms/internal/vision/zzil:zzzx	Lcom/google/android/gms/internal/vision/zzjo;
    //   1000: aload_2
    //   1001: invokevirtual 108	com/google/android/gms/internal/vision/zzjo:zzw	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1004: invokevirtual 898	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1007: ifne +5 -> 1012
    //   1010: iconst_0
    //   1011: ireturn
    //   1012: aload_0
    //   1013: getfield 78	com/google/android/gms/internal/vision/zzil:zzzo	Z
    //   1016: ifeq +23 -> 1039
    //   1019: aload_0
    //   1020: getfield 94	com/google/android/gms/internal/vision/zzil:zzzy	Lcom/google/android/gms/internal/vision/zzgk;
    //   1023: aload_1
    //   1024: invokevirtual 735	com/google/android/gms/internal/vision/zzgk:zzf	(Ljava/lang/Object;)Lcom/google/android/gms/internal/vision/zzgn;
    //   1027: aload_0
    //   1028: getfield 94	com/google/android/gms/internal/vision/zzil:zzzy	Lcom/google/android/gms/internal/vision/zzgk;
    //   1031: aload_2
    //   1032: invokevirtual 735	com/google/android/gms/internal/vision/zzgk:zzf	(Ljava/lang/Object;)Lcom/google/android/gms/internal/vision/zzgn;
    //   1035: invokevirtual 899	com/google/android/gms/internal/vision/zzgn:equals	(Ljava/lang/Object;)Z
    //   1038: ireturn
    //   1039: iconst_1
    //   1040: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1041	0	this	zzil
    //   0	1041	1	paramT1	T
    //   0	1041	2	paramT2	T
    //   5	11	3	i	int
    //   7	976	4	j	int
    //   10	966	5	bool	boolean
    //   24	16	6	k	int
    //   32	929	7	l1	long
    //   345	10	9	l2	long
  }
  
  public final int hashCode(T paramT)
  {
    int i = this.zzzj.length;
    int j = 0;
    for (int k = 0; j < i; k = i1)
    {
      int m = zzbq(j);
      int n = this.zzzj[j];
      long l = 0xFFFFF & m;
      i1 = 37;
      Object localObject;
      switch ((m & 0xFF00000) >>> 20)
      {
      default: 
        i1 = k;
        break;
      case 68: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        localObject = zzju.zzp(paramT, l);
        i1 = k * 53;
        k = localObject.hashCode();
        break;
      case 67: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgy.zzab(zzi(paramT, l));
        break;
      case 66: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzh(paramT, l);
        break;
      case 65: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgy.zzab(zzi(paramT, l));
        break;
      case 64: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzh(paramT, l);
        break;
      case 63: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzh(paramT, l);
        break;
      case 62: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzh(paramT, l);
        break;
      case 61: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzju.zzp(paramT, l).hashCode();
        break;
      case 60: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        localObject = zzju.zzp(paramT, l);
        i1 = k * 53;
        k = localObject.hashCode();
        break;
      case 59: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = ((String)zzju.zzp(paramT, l)).hashCode();
        break;
      case 58: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgy.zzm(zzj(paramT, l));
        break;
      case 57: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzh(paramT, l);
        break;
      case 56: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgy.zzab(zzi(paramT, l));
        break;
      case 55: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzh(paramT, l);
        break;
      case 54: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgy.zzab(zzi(paramT, l));
        break;
      case 53: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgy.zzab(zzi(paramT, l));
        break;
      case 52: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = Float.floatToIntBits(zzg(paramT, l));
        break;
      case 51: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgy.zzab(Double.doubleToLongBits(zzf(paramT, l)));
        break;
      case 50: 
        i1 = k * 53;
        k = zzju.zzp(paramT, l).hashCode();
        break;
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
        i1 = k * 53;
        k = zzju.zzp(paramT, l).hashCode();
        break;
      case 17: 
        localObject = zzju.zzp(paramT, l);
        if (localObject != null) {
          i1 = localObject.hashCode();
        }
        break;
      case 16: 
        i1 = k * 53;
        k = zzgy.zzab(zzju.zzl(paramT, l));
        break;
      case 15: 
        i1 = k * 53;
        k = zzju.zzk(paramT, l);
        break;
      case 14: 
        i1 = k * 53;
        k = zzgy.zzab(zzju.zzl(paramT, l));
        break;
      case 13: 
        i1 = k * 53;
        k = zzju.zzk(paramT, l);
        break;
      case 12: 
        i1 = k * 53;
        k = zzju.zzk(paramT, l);
        break;
      case 11: 
        i1 = k * 53;
        k = zzju.zzk(paramT, l);
        break;
      case 10: 
        i1 = k * 53;
        k = zzju.zzp(paramT, l).hashCode();
        break;
      case 9: 
        localObject = zzju.zzp(paramT, l);
        if (localObject != null) {
          i1 = localObject.hashCode();
        }
        i1 = k * 53 + i1;
        break;
      case 8: 
        i1 = k * 53;
        k = ((String)zzju.zzp(paramT, l)).hashCode();
        break;
      case 7: 
        i1 = k * 53;
        k = zzgy.zzm(zzju.zzm(paramT, l));
        break;
      case 6: 
        i1 = k * 53;
        k = zzju.zzk(paramT, l);
        break;
      case 5: 
        i1 = k * 53;
        k = zzgy.zzab(zzju.zzl(paramT, l));
        break;
      case 4: 
        i1 = k * 53;
        k = zzju.zzk(paramT, l);
        break;
      case 3: 
        i1 = k * 53;
        k = zzgy.zzab(zzju.zzl(paramT, l));
        break;
      case 2: 
        i1 = k * 53;
        k = zzgy.zzab(zzju.zzl(paramT, l));
        break;
      case 1: 
        i1 = k * 53;
        k = Float.floatToIntBits(zzju.zzn(paramT, l));
        break;
      }
      i1 = k * 53;
      k = zzgy.zzab(Double.doubleToLongBits(zzju.zzo(paramT, l)));
      i1 += k;
      label1421:
      j += 3;
    }
    k = k * 53 + this.zzzx.zzw(paramT).hashCode();
    int i1 = k;
    if (this.zzzo) {
      i1 = k * 53 + this.zzzy.zzf(paramT).hashCode();
    }
    return i1;
  }
  
  public final T newInstance()
  {
    return (T)this.zzzv.newInstance(this.zzzn);
  }
  
  final int zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, zzfg paramzzfg)
    throws IOException
  {
    Object localObject1 = paramT;
    Object localObject2 = paramArrayOfByte;
    int i = paramInt2;
    int j = paramInt3;
    Object localObject3 = paramzzfg;
    Unsafe localUnsafe = zzzi;
    int k = -1;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 1048575;
    Object localObject4;
    for (;;)
    {
      localObject4 = this;
      Object localObject5 = null;
      if (paramInt1 >= i) {
        break;
      }
      int i3 = paramInt1 + 1;
      paramInt1 = localObject2[paramInt1];
      if (paramInt1 < 0)
      {
        i3 = zzfe.zza(paramInt1, (byte[])localObject2, i3, (zzfg)localObject3);
        paramInt1 = ((zzfg)localObject3).zzsd;
      }
      n = paramInt1 >>> 3;
      int i4 = paramInt1 & 0x7;
      if (n > k) {
        i = ((zzil)localObject4).zzt(n, m / 3);
      } else {
        i = ((zzil)localObject4).zzbt(n);
      }
      label715:
      label733:
      label1115:
      label1124:
      label1154:
      label1169:
      label1183:
      label1199:
      label1203:
      label1222:
      Object localObject6;
      if (i == -1)
      {
        m = n;
        n = paramInt1;
        i = i1;
        i1 = j;
        k = 0;
        paramInt1 = i3;
        j = m;
      }
      else
      {
        localObject1 = ((zzil)localObject4).zzzj;
        int i5 = localObject1[(i + 1)];
        int i6 = (i5 & 0xFF00000) >>> 20;
        long l = i5 & 0xFFFFF;
        if (i6 <= 17)
        {
          j = localObject1[(i + 2)];
          i7 = 1 << (j >>> 20);
          k = j & 0xFFFFF;
          if (k != i2)
          {
            if (i2 != 1048575) {
              localUnsafe.putInt(paramT, i2, i1);
            }
            localObject1 = paramT;
            j = localUnsafe.getInt(localObject1, k);
            i2 = k;
          }
          else
          {
            localObject1 = paramT;
            j = i1;
          }
          switch (i6)
          {
          }
          for (;;)
          {
            break label1222;
            if (i4 == 3)
            {
              m = zzfe.zza(((zzil)localObject4).zzbn(i), paramArrayOfByte, i3, paramInt2, n << 3 | 0x4, paramzzfg);
              if ((j & i7) == 0) {
                localUnsafe.putObject(localObject1, l, ((zzfg)localObject3).zzsf);
              } else {
                localUnsafe.putObject(localObject1, l, zzgy.zzb(localUnsafe.getObject(localObject1, l), ((zzfg)localObject3).zzsf));
              }
              j |= i7;
              i1 = paramInt1;
              k = i2;
              paramInt1 = m;
              i2 = i1;
              break label1183;
              if (i4 == 0)
              {
                i1 = zzfe.zzb((byte[])localObject2, i3, (zzfg)localObject3);
                localUnsafe.putLong(paramT, l, zzfy.zzr(((zzfg)localObject3).zzse));
                j |= i7;
              }
              else
              {
                break label733;
                if (i4 == 0)
                {
                  i1 = zzfe.zza((byte[])localObject2, i3, (zzfg)localObject3);
                  localUnsafe.putInt(localObject1, l, zzfy.zzav(((zzfg)localObject3).zzsd));
                  break label715;
                  i1 = i;
                  k = paramInt1;
                  if (i4 == 0)
                  {
                    m = zzfe.zza((byte[])localObject2, i3, (zzfg)localObject3);
                    i3 = ((zzfg)localObject3).zzsd;
                    localObject4 = ((zzil)localObject4).zzbp(i1);
                    if ((localObject4 != null) && (!((zzhd)localObject4).zzg(i3)))
                    {
                      zzt(paramT).zzb(k, Long.valueOf(i3));
                      paramInt1 = m;
                      i = n;
                      m = i1;
                      n = k;
                      i1 = j;
                      k = i2;
                      break label1199;
                    }
                    localUnsafe.putInt(localObject1, l, i3);
                    i1 = m;
                    if (i4 == 2)
                    {
                      i1 = zzfe.zze((byte[])localObject2, i3, (zzfg)localObject3);
                      localUnsafe.putObject(localObject1, l, ((zzfg)localObject3).zzsf);
                      k = j | i7;
                      j = i2;
                      i2 = k;
                      break label1169;
                    }
                  }
                }
                continue;
                i1 = i;
                if (i4 == 2)
                {
                  i = zzfe.zza(((zzil)localObject4).zzbn(i1), (byte[])localObject2, i3, paramInt2, (zzfg)localObject3);
                  if ((j & i7) == 0) {
                    localUnsafe.putObject(localObject1, l, ((zzfg)localObject3).zzsf);
                  } else {
                    localUnsafe.putObject(localObject1, l, zzgy.zzb(localUnsafe.getObject(localObject1, l), ((zzfg)localObject3).zzsf));
                  }
                  k = paramInt1;
                  j |= i7;
                  paramInt1 = i;
                  i = n;
                  m = i1;
                  n = k;
                  i1 = j;
                  break label1203;
                }
                break label1124;
                if (i4 != 2) {
                  break label1124;
                }
                if ((0x20000000 & i5) == 0) {
                  i1 = zzfe.zzc((byte[])localObject2, i3, (zzfg)localObject3);
                } else {
                  i1 = zzfe.zzd((byte[])localObject2, i3, (zzfg)localObject3);
                }
                localUnsafe.putObject(localObject1, l, ((zzfg)localObject3).zzsf);
                break label1154;
                if (i4 != 0) {
                  break label1124;
                }
                i1 = zzfe.zzb((byte[])localObject2, i3, (zzfg)localObject3);
                if (((zzfg)localObject3).zzse != 0L) {
                  bool = true;
                } else {
                  bool = false;
                }
                zzju.zza(localObject1, l, bool);
                break label1154;
                if (i4 != 5) {
                  break label1124;
                }
                localUnsafe.putInt(localObject1, l, zzfe.zza((byte[])localObject2, i3));
                break label1115;
                if (i4 != 1) {
                  break label1124;
                }
                localUnsafe.putLong(paramT, l, zzfe.zzb((byte[])localObject2, i3));
                i1 = i3 + 8;
                break label1154;
                if (i4 != 0) {
                  break label1124;
                }
                i1 = zzfe.zza((byte[])localObject2, i3, (zzfg)localObject3);
                localUnsafe.putInt(localObject1, l, ((zzfg)localObject3).zzsd);
                break label1154;
                if (i4 != 0) {
                  break label1124;
                }
                i1 = zzfe.zzb((byte[])localObject2, i3, (zzfg)localObject3);
                localUnsafe.putLong(paramT, l, ((zzfg)localObject3).zzse);
                j |= i7;
              }
              k = i2;
              i2 = j;
              j = k;
              break label1169;
              if (i4 == 5)
              {
                zzju.zza(localObject1, l, zzfe.zzd((byte[])localObject2, i3));
                i1 = i3 + 4;
              }
              else
              {
                break label1222;
                if (i4 != 1) {
                  break label1222;
                }
                zzju.zza(localObject1, l, zzfe.zzc((byte[])localObject2, i3));
                i1 = i3 + 8;
              }
              k = j | i7;
              j = i2;
              i2 = k;
              k = j;
              j = i2;
              i2 = paramInt1;
              paramInt1 = i1;
              m = i;
              i = n;
              i1 = j;
              n = i2;
              i2 = k;
              i3 = paramInt2;
              j = paramInt3;
              k = i;
              i = i3;
              break;
            }
          }
          i1 = paramInt3;
          i7 = i3;
          i3 = paramInt1;
          k = i;
          m = n;
          paramInt1 = i7;
          n = i3;
          i = j;
          j = m;
        }
        else
        {
          j = i1;
          localObject1 = paramT;
          int i8;
          if (i6 == 27)
          {
            if (i4 == 2)
            {
              localObject6 = (zzhe)localUnsafe.getObject(localObject1, l);
              localObject5 = localObject6;
              if (!((zzhe)localObject6).zzdp())
              {
                i1 = ((List)localObject6).size();
                if (i1 == 0) {
                  i1 = 10;
                } else {
                  i1 <<= 1;
                }
                localObject5 = ((zzhe)localObject6).zzah(i1);
                localUnsafe.putObject(localObject1, l, localObject5);
              }
              k = zzfe.zza(((zzil)localObject4).zzbn(i), paramInt1, paramArrayOfByte, i3, paramInt2, (zzhe)localObject5, paramzzfg);
              i3 = paramInt3;
              i1 = paramInt1;
              m = i;
              i = paramInt2;
              paramInt1 = k;
              k = n;
              n = i1;
              i1 = j;
              j = i3;
              continue;
            }
          }
          else
          {
            i1 = i;
            if (i6 <= 49)
            {
              m = zza(paramT, paramArrayOfByte, i3, paramInt2, paramInt1, n, i4, i1, i5, i6, l, paramzzfg);
              k = m;
              if (m == i3)
              {
                i1 = m;
                break label1658;
              }
            }
            do
            {
              localObject1 = paramT;
              localObject2 = paramArrayOfByte;
              i = paramInt2;
              localObject3 = paramzzfg;
              i3 = paramInt3;
              i7 = paramInt1;
              paramInt1 = k;
              k = n;
              m = i1;
              n = i7;
              i1 = j;
              j = i3;
              break;
              i8 = i3;
              i7 = paramInt1;
              m = n;
              if (i6 != 50) {
                break label1619;
              }
              if (i4 != 2) {
                break label1582;
              }
              m = zza(paramT, paramArrayOfByte, i8, paramInt2, i1, l, paramzzfg);
              k = m;
            } while (m != i8);
            i1 = m;
            break label1658;
          }
          label1582:
          label1619:
          label1658:
          for (i1 = i3;; i1 = k)
          {
            m = n;
            i3 = paramInt3;
            k = i;
            n = paramInt1;
            paramInt1 = i1;
            i1 = i3;
            i = j;
            j = m;
            break;
            k = zza(paramT, paramArrayOfByte, i8, paramInt2, i7, m, i4, i5, i6, l, i1, paramzzfg);
            if (k != i8) {
              break label2969;
            }
          }
        }
      }
      boolean bool = true;
      if ((n == i1) && (i1 != 0))
      {
        paramArrayOfByte = this;
        paramInt3 = i;
        i = i2;
        i2 = paramInt3;
        paramInt3 = paramInt2;
        paramInt2 = i1;
        break label3043;
      }
      if (this.zzzo)
      {
        localObject3 = paramzzfg;
        if (((zzfg)localObject3).zzcu != zzgi.zzfm())
        {
          localObject2 = this.zzzn;
          localObject6 = this.zzzx;
          localObject1 = ((zzfg)localObject3).zzcu;
          m = j;
          localObject4 = ((zzgi)localObject1).zza((zzih)localObject2, m);
          if (localObject4 == null)
          {
            paramInt1 = zzfe.zza(n, paramArrayOfByte, paramInt1, paramInt2, zzt(paramT), paramzzfg);
            break label2924;
          }
          zzgx.zze localzze = (zzgx.zze)paramT;
          localzze.zzgl();
          localObject2 = localzze.zzwz;
          Object localObject7 = ((zzgx.zzg)localObject4).zzxq;
          if ((((zzgx.zzd)localObject7).zzwx) && (((zzgx.zzd)localObject7).zzwy))
          {
            switch (zzfh.zzsg[localObject7.zzww.ordinal()])
            {
            default: 
              paramT = String.valueOf(((zzgx.zzg)localObject4).zzxq.zzww);
              paramArrayOfByte = new StringBuilder(paramT.length() + 23);
              paramArrayOfByte.append("Type cannot be packed: ");
              paramArrayOfByte.append(paramT);
              throw new IllegalStateException(paramArrayOfByte.toString());
            case 14: 
              localObject5 = new zzgz();
              paramInt1 = zzfe.zza(paramArrayOfByte, paramInt1, (zzhe)localObject5, (zzfg)localObject3);
              localObject3 = localzze.zzws;
              localObject1 = localObject3;
              if (localObject3 == zzjr.zzih()) {
                localObject1 = null;
              }
              localObject1 = (zzjr)zziy.zza(m, (List)localObject5, ((zzgx.zzg)localObject4).zzxq.zzwv, localObject1, (zzjo)localObject6);
              if (localObject1 != null) {
                localzze.zzws = ((zzjr)localObject1);
              }
              ((zzgn)localObject2).zza(((zzgx.zzg)localObject4).zzxq, localObject5);
              break;
            case 13: 
              localObject1 = new zzhv();
              paramInt1 = zzfe.zzi(paramArrayOfByte, paramInt1, (zzhe)localObject1, (zzfg)localObject3);
              break;
            case 12: 
              localObject1 = new zzgz();
              paramInt1 = zzfe.zzh(paramArrayOfByte, paramInt1, (zzhe)localObject1, (zzfg)localObject3);
              break;
            case 11: 
              localObject1 = new zzfk();
              paramInt1 = zzfe.zzg(paramArrayOfByte, paramInt1, (zzhe)localObject1, (zzfg)localObject3);
              break;
            case 9: 
            case 10: 
              localObject1 = new zzgz();
              paramInt1 = zzfe.zzc(paramArrayOfByte, paramInt1, (zzhe)localObject1, (zzfg)localObject3);
              break;
            case 7: 
            case 8: 
              localObject1 = new zzhv();
              paramInt1 = zzfe.zzd(paramArrayOfByte, paramInt1, (zzhe)localObject1, (zzfg)localObject3);
              break;
            case 5: 
            case 6: 
              localObject1 = new zzgz();
              paramInt1 = zzfe.zza(paramArrayOfByte, paramInt1, (zzhe)localObject1, (zzfg)localObject3);
              break;
            case 3: 
            case 4: 
              localObject1 = new zzhv();
              paramInt1 = zzfe.zzb(paramArrayOfByte, paramInt1, (zzhe)localObject1, (zzfg)localObject3);
              break;
            case 2: 
              localObject1 = new zzgt();
              paramInt1 = zzfe.zze(paramArrayOfByte, paramInt1, (zzhe)localObject1, (zzfg)localObject3);
              break;
            case 1: 
              localObject1 = new zzgg();
              paramInt1 = zzfe.zzf(paramArrayOfByte, paramInt1, (zzhe)localObject1, (zzfg)localObject3);
            }
            localObject3 = localObject1;
            m = paramInt1;
          }
          else
          {
            localObject1 = paramArrayOfByte;
            localObject7 = ((zzgx.zzd)localObject7).zzww;
            if (localObject7 == zzkf.zzaco)
            {
              paramInt1 = zzfe.zza((byte[])localObject1, paramInt1, (zzfg)localObject3);
              if (((zzgx.zzg)localObject4).zzxq.zzwv.zzh(((zzfg)localObject3).zzsd) == null)
              {
                localObject2 = localzze.zzws;
                localObject1 = localObject2;
                if (localObject2 == zzjr.zzih())
                {
                  localObject1 = zzjr.zzii();
                  localzze.zzws = ((zzjr)localObject1);
                }
                zziy.zza(m, ((zzfg)localObject3).zzsd, localObject1, (zzjo)localObject6);
                break label2902;
              }
              localObject1 = Integer.valueOf(((zzfg)localObject3).zzsd);
            }
            else
            {
              switch (zzfh.zzsg[localObject7.ordinal()])
              {
              default: 
                localObject1 = localObject5;
              }
              for (;;)
              {
                break;
                paramInt1 = zzfe.zza(zzis.zzhp().zzf(((zzgx.zzg)localObject4).zzxp.getClass()), (byte[])localObject1, paramInt1, paramInt2, (zzfg)localObject3);
                localObject1 = ((zzfg)localObject3).zzsf;
                break;
                paramInt1 = zzfe.zza(zzis.zzhp().zzf(((zzgx.zzg)localObject4).zzxp.getClass()), paramArrayOfByte, paramInt1, paramInt2, m << 3 | 0x4, paramzzfg);
                localObject1 = ((zzfg)localObject3).zzsf;
                break;
                paramInt1 = zzfe.zzc((byte[])localObject1, paramInt1, (zzfg)localObject3);
                localObject1 = ((zzfg)localObject3).zzsf;
                break;
                paramInt1 = zzfe.zze((byte[])localObject1, paramInt1, (zzfg)localObject3);
                localObject1 = ((zzfg)localObject3).zzsf;
                break;
                throw new IllegalStateException("Shouldn't reach here.");
                paramInt1 = zzfe.zzb((byte[])localObject1, paramInt1, (zzfg)localObject3);
                localObject1 = Long.valueOf(zzfy.zzr(((zzfg)localObject3).zzse));
                continue;
                paramInt1 = zzfe.zza((byte[])localObject1, paramInt1, (zzfg)localObject3);
                localObject1 = Integer.valueOf(zzfy.zzav(((zzfg)localObject3).zzsd));
                continue;
                paramInt1 = zzfe.zzb((byte[])localObject1, paramInt1, (zzfg)localObject3);
                if (((zzfg)localObject3).zzse == 0L) {
                  bool = false;
                }
                localObject1 = Boolean.valueOf(bool);
                continue;
                localObject1 = Integer.valueOf(zzfe.zza((byte[])localObject1, paramInt1));
                break label2763;
                localObject1 = Long.valueOf(zzfe.zzb((byte[])localObject1, paramInt1));
                break label2780;
                paramInt1 = zzfe.zza((byte[])localObject1, paramInt1, (zzfg)localObject3);
                localObject1 = Integer.valueOf(((zzfg)localObject3).zzsd);
                continue;
                paramInt1 = zzfe.zzb((byte[])localObject1, paramInt1, (zzfg)localObject3);
                localObject1 = Long.valueOf(((zzfg)localObject3).zzse);
                continue;
                localObject1 = Float.valueOf(zzfe.zzd((byte[])localObject1, paramInt1));
                label2763:
                paramInt1 += 4;
                continue;
                localObject1 = Double.valueOf(zzfe.zzc((byte[])localObject1, paramInt1));
                label2780:
                paramInt1 += 8;
              }
            }
            localObject3 = ((zzgx.zzg)localObject4).zzxq;
            if (((zzgx.zzd)localObject3).zzwx)
            {
              ((zzgn)localObject2).zzb((zzgp)localObject3, localObject1);
              break label2902;
            }
            m = zzfh.zzsg[localObject3.zzww.ordinal()];
            if ((m != 17) && (m != 18))
            {
              localObject3 = localObject1;
              m = paramInt1;
            }
            else
            {
              localObject5 = ((zzgn)localObject2).zza(((zzgx.zzg)localObject4).zzxq);
              localObject3 = localObject1;
              m = paramInt1;
              if (localObject5 != null)
              {
                localObject3 = zzgy.zzb(localObject5, localObject1);
                m = paramInt1;
              }
            }
          }
          ((zzgn)localObject2).zza(((zzgx.zzg)localObject4).zzxq, localObject3);
          paramInt1 = m;
          label2902:
          break label2924;
        }
      }
      paramInt1 = zzfe.zza(n, paramArrayOfByte, paramInt1, paramInt2, zzt(paramT), paramzzfg);
      label2924:
      m = j;
      localObject1 = paramT;
      localObject2 = paramArrayOfByte;
      i3 = i;
      int i7 = k;
      i = paramInt2;
      j = i1;
      localObject3 = paramzzfg;
      k = m;
      m = i7;
      i1 = i3;
      continue;
      label2969:
      localObject1 = paramT;
      localObject2 = paramArrayOfByte;
      i = paramInt2;
      n = i7;
      i3 = i2;
      i2 = j;
      j = paramInt3;
      localObject3 = paramzzfg;
      paramInt1 = k;
      k = m;
      m = i1;
      i1 = i2;
      i2 = i3;
    }
    paramInt2 = j;
    paramInt3 = i;
    paramT = (T)localObject1;
    paramArrayOfByte = (byte[])localObject4;
    i = i2;
    i2 = i1;
    label3043:
    if (i != 1048575) {
      localUnsafe.putInt(paramT, i, i2);
    }
    i2 = paramArrayOfByte.zzzt;
    paramzzfg = null;
    while (i2 < paramArrayOfByte.zzzu)
    {
      paramzzfg = (zzjr)paramArrayOfByte.zza(paramT, paramArrayOfByte.zzzs[i2], paramzzfg, paramArrayOfByte.zzzx);
      i2++;
    }
    if (paramzzfg != null) {
      paramArrayOfByte.zzzx.zzg(paramT, paramzzfg);
    }
    if (paramInt2 == 0)
    {
      if (paramInt1 != paramInt3) {
        throw zzhh.zzgt();
      }
    }
    else {
      if ((paramInt1 > paramInt3) || (n != paramInt2)) {
        break label3156;
      }
    }
    return paramInt1;
    label3156:
    throw zzhh.zzgt();
  }
  
  public final void zza(T paramT, zzix paramzzix, zzgi paramzzgi)
    throws IOException
  {
    Objects.requireNonNull(paramzzgi);
    zzjo localzzjo = this.zzzx;
    zzgk localzzgk = this.zzzy;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    for (;;)
    {
      Object localObject4 = localObject2;
      try
      {
        int i = paramzzix.zzdv();
        localObject4 = localObject2;
        j = zzbt(i);
        Object localObject5;
        Object localObject6;
        boolean bool;
        if (j < 0)
        {
          if (i == Integer.MAX_VALUE) {
            return;
          }
          localObject4 = localObject2;
          if (!this.zzzo)
          {
            localObject5 = null;
          }
          else
          {
            localObject4 = localObject2;
            localObject5 = localzzgk.zza(paramzzgi, this.zzzn, i);
          }
          if (localObject5 != null)
          {
            localObject6 = localObject1;
            if (localObject1 == null)
            {
              localObject4 = localObject2;
              localObject6 = localzzgk.zzg(paramT);
            }
            localObject4 = localObject2;
            localObject2 = localzzgk.zza(paramzzix, localObject5, paramzzgi, (zzgn)localObject6, localObject2, localzzjo);
            localObject1 = localObject6;
            continue;
          }
          localObject4 = localObject2;
          localzzjo.zza(paramzzix);
          localObject6 = localObject2;
          if (localObject2 == null)
          {
            localObject4 = localObject2;
            localObject6 = localzzjo.zzx(paramT);
          }
          localObject4 = localObject6;
          bool = localzzjo.zza(localObject6, paramzzix);
          localObject2 = localObject6;
          if (bool) {
            continue;
          }
          return;
        }
        localObject4 = localObject2;
        int k = zzbq(j);
        switch ((0xFF00000 & k) >>> 20)
        {
        default: 
          localObject6 = localObject2;
          if (localObject2 == null)
          {
            localObject5 = localObject2;
            localObject4 = localObject2;
          }
          break;
        }
        try
        {
          localObject6 = localzzjo.zzig();
          break label4010;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, paramzzix.zzc(zzbn(j), paramzzgi));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Long.valueOf(paramzzix.zzek()));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Integer.valueOf(paramzzix.zzej()));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Long.valueOf(paramzzix.zzei()));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Integer.valueOf(paramzzix.zzeh()));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          int m = paramzzix.zzeg();
          localObject5 = localObject2;
          localObject4 = localObject2;
          localObject6 = zzbp(j);
          if (localObject6 != null)
          {
            localObject5 = localObject2;
            localObject4 = localObject2;
            if (!((zzhd)localObject6).zzg(m))
            {
              localObject5 = localObject2;
              localObject4 = localObject2;
              localObject2 = zziy.zza(i, m, localObject2, localzzjo);
              continue;
            }
          }
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Integer.valueOf(m));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Integer.valueOf(paramzzix.zzef()));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, paramzzix.zzee());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          if (zza(paramT, i, j))
          {
            l = k & 0xFFFFF;
            localObject5 = localObject2;
            localObject4 = localObject2;
            zzju.zza(paramT, l, zzgy.zzb(zzju.zzp(paramT, l), paramzzix.zza(zzbn(j), paramzzgi)));
          }
          else
          {
            localObject5 = localObject2;
            localObject4 = localObject2;
            zzju.zza(paramT, k & 0xFFFFF, paramzzix.zza(zzbn(j), paramzzgi));
            localObject5 = localObject2;
            localObject4 = localObject2;
            zzb(paramT, j);
          }
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zza(paramT, k, paramzzix);
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Boolean.valueOf(paramzzix.zzec()));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Integer.valueOf(paramzzix.zzeb()));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Long.valueOf(paramzzix.zzea()));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Integer.valueOf(paramzzix.zzdz()));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Long.valueOf(paramzzix.zzdx()));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Long.valueOf(paramzzix.zzdy()));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Float.valueOf(paramzzix.readFloat()));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, Double.valueOf(paramzzix.readDouble()));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, i, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          Object localObject7 = zzbo(j);
          localObject5 = localObject2;
          localObject4 = localObject2;
          long l = zzbq(j) & 0xFFFFF;
          localObject5 = localObject2;
          localObject4 = localObject2;
          Object localObject8 = zzju.zzp(paramT, l);
          if (localObject8 == null)
          {
            localObject5 = localObject2;
            localObject4 = localObject2;
            localObject6 = this.zzzz.zzp(localObject7);
            localObject5 = localObject2;
            localObject4 = localObject2;
            zzju.zza(paramT, l, localObject6);
          }
          else
          {
            localObject6 = localObject8;
            localObject5 = localObject2;
            localObject4 = localObject2;
            if (this.zzzz.zzn(localObject8))
            {
              localObject5 = localObject2;
              localObject4 = localObject2;
              localObject6 = this.zzzz.zzp(localObject7);
              localObject5 = localObject2;
              localObject4 = localObject2;
              this.zzzz.zzc(localObject6, localObject8);
              localObject5 = localObject2;
              localObject4 = localObject2;
              zzju.zza(paramT, l, localObject6);
            }
          }
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zza(this.zzzz.zzl(localObject6), this.zzzz.zzq(localObject7), paramzzgi);
          continue;
          l = k & 0xFFFFF;
          localObject5 = localObject2;
          localObject4 = localObject2;
          localObject6 = zzbn(j);
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzb(this.zzzw.zza(paramT, l), (zziw)localObject6, paramzzgi);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzp(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzo(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzn(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzm(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          localObject6 = this.zzzw.zza(paramT, k & 0xFFFFF);
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzl((List)localObject6);
          localObject5 = localObject2;
          localObject4 = localObject2;
          localObject2 = zziy.zza(i, (List)localObject6, zzbp(j), localObject2, localzzjo);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzk(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzh(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzg(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzf(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zze(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzc(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzd(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzb(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zza(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzp(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzo(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzn(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzm(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          localObject6 = this.zzzw.zza(paramT, k & 0xFFFFF);
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzl((List)localObject6);
          localObject5 = localObject2;
          localObject4 = localObject2;
          localObject2 = zziy.zza(i, (List)localObject6, zzbp(j), localObject2, localzzjo);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzk(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzj(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          localObject6 = zzbn(j);
          l = k & 0xFFFFF;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zza(this.zzzw.zza(paramT, l), (zziw)localObject6, paramzzgi);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          if (zzbs(k))
          {
            localObject5 = localObject2;
            localObject4 = localObject2;
            paramzzix.zzi(this.zzzw.zza(paramT, k & 0xFFFFF));
            continue;
          }
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.readStringList(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzh(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzg(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzf(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zze(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzc(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzd(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zzb(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          paramzzix.zza(this.zzzw.zza(paramT, k & 0xFFFFF));
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          if (zza(paramT, j))
          {
            l = k & 0xFFFFF;
            localObject5 = localObject2;
            localObject4 = localObject2;
            zzju.zza(paramT, l, zzgy.zzb(zzju.zzp(paramT, l), paramzzix.zzc(zzbn(j), paramzzgi)));
            continue;
          }
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, paramzzix.zzc(zzbn(j), paramzzgi));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, paramzzix.zzek());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zzb(paramT, k & 0xFFFFF, paramzzix.zzej());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, paramzzix.zzei());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zzb(paramT, k & 0xFFFFF, paramzzix.zzeh());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          m = paramzzix.zzeg();
          localObject5 = localObject2;
          localObject4 = localObject2;
          localObject6 = zzbp(j);
          if (localObject6 != null)
          {
            localObject5 = localObject2;
            localObject4 = localObject2;
            if (!((zzhd)localObject6).zzg(m))
            {
              localObject5 = localObject2;
              localObject4 = localObject2;
              localObject2 = zziy.zza(i, m, localObject2, localzzjo);
              continue;
            }
          }
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zzb(paramT, k & 0xFFFFF, m);
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zzb(paramT, k & 0xFFFFF, paramzzix.zzef());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, paramzzix.zzee());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          if (zza(paramT, j))
          {
            l = k & 0xFFFFF;
            localObject5 = localObject2;
            localObject4 = localObject2;
            zzju.zza(paramT, l, zzgy.zzb(zzju.zzp(paramT, l), paramzzix.zza(zzbn(j), paramzzgi)));
            continue;
          }
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, paramzzix.zza(zzbn(j), paramzzgi));
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zza(paramT, k, paramzzix);
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, paramzzix.zzec());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zzb(paramT, k & 0xFFFFF, paramzzix.zzeb());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, paramzzix.zzea());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zzb(paramT, k & 0xFFFFF, paramzzix.zzdz());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, paramzzix.zzdx());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, paramzzix.zzdy());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, paramzzix.readFloat());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzju.zza(paramT, k & 0xFFFFF, paramzzix.readDouble());
          localObject5 = localObject2;
          localObject4 = localObject2;
          zzb(paramT, j);
          continue;
          label4010:
          localObject5 = localObject6;
          localObject4 = localObject6;
          bool = localzzjo.zza(localObject6, paramzzix);
          localObject2 = localObject6;
          if (bool) {
            continue;
          }
          return;
        }
        catch (zzhg localzzhg)
        {
          localObject4 = localObject5;
          localzzjo.zza(paramzzix);
          localObject6 = localObject5;
          if (localObject5 == null)
          {
            localObject4 = localObject5;
            localObject6 = localzzjo.zzx(paramT);
          }
          localObject4 = localObject6;
          bool = localzzjo.zza(localObject6, paramzzix);
          Object localObject3 = localObject6;
        }
        if (bool) {
          continue;
        }
        return;
      }
      finally
      {
        for (int j = this.zzzt; j < this.zzzu; j++) {
          localObject4 = zza(paramT, this.zzzs[j], localObject4, localzzjo);
        }
        if (localObject4 != null) {
          localzzjo.zzg(paramT, localObject4);
        }
      }
    }
  }
  
  public final void zza(T paramT, zzkl paramzzkl)
    throws IOException
  {
    Object localObject1;
    Iterator localIterator;
    label73:
    int i;
    Object localObject2;
    int j;
    int k;
    if (paramzzkl.zzfk() == zzgx.zzf.zzxm)
    {
      zza(this.zzzx, paramT, paramzzkl);
      if (this.zzzo)
      {
        localObject1 = this.zzzy.zzf(paramT);
        if (!((zzgn)localObject1).zztq.isEmpty())
        {
          localIterator = ((zzgn)localObject1).descendingIterator();
          localObject1 = (Map.Entry)localIterator.next();
          break label73;
        }
      }
      localIterator = null;
      localObject1 = localIterator;
      i = this.zzzj.length - 3;
      localObject2 = localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        if (i < 0) {
          break;
        }
        j = zzbq(i);
        k = this.zzzj[i];
        while ((localObject2 != null) && (this.zzzy.zza((Map.Entry)localObject2) > k))
        {
          this.zzzy.zza(paramzzkl, (Map.Entry)localObject2);
          if (localIterator.hasNext()) {
            localObject2 = (Map.Entry)localIterator.next();
          } else {
            localObject2 = null;
          }
        }
        switch ((j & 0xFF00000) >>> 20)
        {
        default: 
          break;
        case 68: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzb(k, zzju.zzp(paramT, j & 0xFFFFF), zzbn(i));
          }
          break;
        case 67: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzb(k, zzi(paramT, j & 0xFFFFF));
          }
          break;
        case 66: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzj(k, zzh(paramT, j & 0xFFFFF));
          }
          break;
        case 65: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzj(k, zzi(paramT, j & 0xFFFFF));
          }
          break;
        case 64: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzr(k, zzh(paramT, j & 0xFFFFF));
          }
          break;
        case 63: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzs(k, zzh(paramT, j & 0xFFFFF));
          }
          break;
        case 62: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzi(k, zzh(paramT, j & 0xFFFFF));
          }
          break;
        case 61: 
          if (zza(paramT, k, i)) {
            paramzzkl.zza(k, (zzfm)zzju.zzp(paramT, j & 0xFFFFF));
          }
          break;
        case 60: 
          if (zza(paramT, k, i)) {
            paramzzkl.zza(k, zzju.zzp(paramT, j & 0xFFFFF), zzbn(i));
          }
          break;
        case 59: 
          if (zza(paramT, k, i)) {
            zza(k, zzju.zzp(paramT, j & 0xFFFFF), paramzzkl);
          }
          break;
        case 58: 
          if (zza(paramT, k, i)) {
            paramzzkl.zza(k, zzj(paramT, j & 0xFFFFF));
          }
          break;
        case 57: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzk(k, zzh(paramT, j & 0xFFFFF));
          }
          break;
        case 56: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzc(k, zzi(paramT, j & 0xFFFFF));
          }
          break;
        case 55: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzh(k, zzh(paramT, j & 0xFFFFF));
          }
          break;
        case 54: 
          if (zza(paramT, k, i)) {
            paramzzkl.zza(k, zzi(paramT, j & 0xFFFFF));
          }
          break;
        case 53: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzi(k, zzi(paramT, j & 0xFFFFF));
          }
          break;
        case 52: 
          if (zza(paramT, k, i)) {
            paramzzkl.zza(k, zzg(paramT, j & 0xFFFFF));
          }
          break;
        case 51: 
          if (zza(paramT, k, i)) {
            paramzzkl.zza(k, zzf(paramT, j & 0xFFFFF));
          }
          break;
        case 50: 
          zza(paramzzkl, k, zzju.zzp(paramT, j & 0xFFFFF), i);
          break;
        case 49: 
          zziy.zzb(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, zzbn(i));
          break;
        case 48: 
          zziy.zze(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 47: 
          zziy.zzj(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 46: 
          zziy.zzg(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 45: 
          zziy.zzl(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 44: 
          zziy.zzm(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 43: 
          zziy.zzi(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 42: 
          zziy.zzn(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 41: 
          zziy.zzk(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 40: 
          zziy.zzf(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 39: 
          zziy.zzh(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 38: 
          zziy.zzd(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 37: 
          zziy.zzc(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 36: 
          zziy.zzb(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 35: 
          zziy.zza(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, true);
          break;
        case 34: 
          zziy.zze(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 33: 
          zziy.zzj(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 32: 
          zziy.zzg(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 31: 
          zziy.zzl(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 30: 
          zziy.zzm(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 29: 
          zziy.zzi(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 28: 
          zziy.zzb(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl);
          break;
        case 27: 
          zziy.zza(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, zzbn(i));
          break;
        case 26: 
          zziy.zza(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl);
          break;
        case 25: 
          zziy.zzn(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 24: 
          zziy.zzk(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 23: 
          zziy.zzf(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 22: 
          zziy.zzh(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 21: 
          zziy.zzd(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 20: 
          zziy.zzc(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 19: 
          zziy.zzb(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 18: 
          zziy.zza(this.zzzj[i], (List)zzju.zzp(paramT, j & 0xFFFFF), paramzzkl, false);
          break;
        case 17: 
          if (zza(paramT, i)) {
            paramzzkl.zzb(k, zzju.zzp(paramT, j & 0xFFFFF), zzbn(i));
          }
          break;
        case 16: 
          if (zza(paramT, i)) {
            paramzzkl.zzb(k, zzju.zzl(paramT, j & 0xFFFFF));
          }
          break;
        case 15: 
          if (zza(paramT, i)) {
            paramzzkl.zzj(k, zzju.zzk(paramT, j & 0xFFFFF));
          }
          break;
        case 14: 
          if (zza(paramT, i)) {
            paramzzkl.zzj(k, zzju.zzl(paramT, j & 0xFFFFF));
          }
          break;
        case 13: 
          if (zza(paramT, i)) {
            paramzzkl.zzr(k, zzju.zzk(paramT, j & 0xFFFFF));
          }
          break;
        case 12: 
          if (zza(paramT, i)) {
            paramzzkl.zzs(k, zzju.zzk(paramT, j & 0xFFFFF));
          }
          break;
        case 11: 
          if (zza(paramT, i)) {
            paramzzkl.zzi(k, zzju.zzk(paramT, j & 0xFFFFF));
          }
          break;
        case 10: 
          if (zza(paramT, i)) {
            paramzzkl.zza(k, (zzfm)zzju.zzp(paramT, j & 0xFFFFF));
          }
          break;
        case 9: 
          if (zza(paramT, i)) {
            paramzzkl.zza(k, zzju.zzp(paramT, j & 0xFFFFF), zzbn(i));
          }
          break;
        case 8: 
          if (zza(paramT, i)) {
            zza(k, zzju.zzp(paramT, j & 0xFFFFF), paramzzkl);
          }
          break;
        case 7: 
          if (zza(paramT, i)) {
            paramzzkl.zza(k, zzju.zzm(paramT, j & 0xFFFFF));
          }
          break;
        case 6: 
          if (zza(paramT, i)) {
            paramzzkl.zzk(k, zzju.zzk(paramT, j & 0xFFFFF));
          }
          break;
        case 5: 
          if (zza(paramT, i)) {
            paramzzkl.zzc(k, zzju.zzl(paramT, j & 0xFFFFF));
          }
          break;
        case 4: 
          if (zza(paramT, i)) {
            paramzzkl.zzh(k, zzju.zzk(paramT, j & 0xFFFFF));
          }
          break;
        case 3: 
          if (zza(paramT, i)) {
            paramzzkl.zza(k, zzju.zzl(paramT, j & 0xFFFFF));
          }
          break;
        case 2: 
          if (zza(paramT, i)) {
            paramzzkl.zzi(k, zzju.zzl(paramT, j & 0xFFFFF));
          }
          break;
        case 1: 
          if (zza(paramT, i)) {
            paramzzkl.zza(k, zzju.zzn(paramT, j & 0xFFFFF));
          }
          break;
        case 0: 
          if (zza(paramT, i)) {
            paramzzkl.zza(k, zzju.zzo(paramT, j & 0xFFFFF));
          }
          break;
        }
        i -= 3;
      }
      while (localObject1 != null)
      {
        this.zzzy.zza(paramzzkl, (Map.Entry)localObject1);
        if (localIterator.hasNext()) {
          localObject1 = (Map.Entry)localIterator.next();
        } else {
          localObject1 = null;
        }
      }
      return;
    }
    if (this.zzzq)
    {
      if (this.zzzo)
      {
        localObject1 = this.zzzy.zzf(paramT);
        if (!((zzgn)localObject1).zztq.isEmpty())
        {
          localIterator = ((zzgn)localObject1).iterator();
          localObject1 = (Map.Entry)localIterator.next();
          break label2680;
        }
      }
      localIterator = null;
      localObject1 = localIterator;
      label2680:
      j = this.zzzj.length;
      for (i = 0;; i += 3)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        int m = zzbq(i);
        k = this.zzzj[i];
        while ((localObject1 != null) && (this.zzzy.zza((Map.Entry)localObject1) <= k))
        {
          this.zzzy.zza(paramzzkl, (Map.Entry)localObject1);
          if (localIterator.hasNext()) {
            localObject1 = (Map.Entry)localIterator.next();
          } else {
            localObject1 = null;
          }
        }
        switch ((m & 0xFF00000) >>> 20)
        {
        default: 
          break;
        case 68: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzb(k, zzju.zzp(paramT, m & 0xFFFFF), zzbn(i));
          }
          break;
        case 67: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzb(k, zzi(paramT, m & 0xFFFFF));
          }
          break;
        case 66: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzj(k, zzh(paramT, m & 0xFFFFF));
          }
          break;
        case 65: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzj(k, zzi(paramT, m & 0xFFFFF));
          }
          break;
        case 64: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzr(k, zzh(paramT, m & 0xFFFFF));
          }
          break;
        case 63: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzs(k, zzh(paramT, m & 0xFFFFF));
          }
          break;
        case 62: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzi(k, zzh(paramT, m & 0xFFFFF));
          }
          break;
        case 61: 
          if (zza(paramT, k, i)) {
            paramzzkl.zza(k, (zzfm)zzju.zzp(paramT, m & 0xFFFFF));
          }
          break;
        case 60: 
          if (zza(paramT, k, i)) {
            paramzzkl.zza(k, zzju.zzp(paramT, m & 0xFFFFF), zzbn(i));
          }
          break;
        case 59: 
          if (zza(paramT, k, i)) {
            zza(k, zzju.zzp(paramT, m & 0xFFFFF), paramzzkl);
          }
          break;
        case 58: 
          if (zza(paramT, k, i)) {
            paramzzkl.zza(k, zzj(paramT, m & 0xFFFFF));
          }
          break;
        case 57: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzk(k, zzh(paramT, m & 0xFFFFF));
          }
          break;
        case 56: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzc(k, zzi(paramT, m & 0xFFFFF));
          }
          break;
        case 55: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzh(k, zzh(paramT, m & 0xFFFFF));
          }
          break;
        case 54: 
          if (zza(paramT, k, i)) {
            paramzzkl.zza(k, zzi(paramT, m & 0xFFFFF));
          }
          break;
        case 53: 
          if (zza(paramT, k, i)) {
            paramzzkl.zzi(k, zzi(paramT, m & 0xFFFFF));
          }
          break;
        case 52: 
          if (zza(paramT, k, i)) {
            paramzzkl.zza(k, zzg(paramT, m & 0xFFFFF));
          }
          break;
        case 51: 
          if (zza(paramT, k, i)) {
            paramzzkl.zza(k, zzf(paramT, m & 0xFFFFF));
          }
          break;
        case 50: 
          zza(paramzzkl, k, zzju.zzp(paramT, m & 0xFFFFF), i);
          break;
        case 49: 
          zziy.zzb(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, zzbn(i));
          break;
        case 48: 
          zziy.zze(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 47: 
          zziy.zzj(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 46: 
          zziy.zzg(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 45: 
          zziy.zzl(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 44: 
          zziy.zzm(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 43: 
          zziy.zzi(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 42: 
          zziy.zzn(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 41: 
          zziy.zzk(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 40: 
          zziy.zzf(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 39: 
          zziy.zzh(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 38: 
          zziy.zzd(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 37: 
          zziy.zzc(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 36: 
          zziy.zzb(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 35: 
          zziy.zza(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, true);
          break;
        case 34: 
          zziy.zze(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 33: 
          zziy.zzj(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 32: 
          zziy.zzg(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 31: 
          zziy.zzl(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 30: 
          zziy.zzm(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 29: 
          zziy.zzi(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 28: 
          zziy.zzb(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl);
          break;
        case 27: 
          zziy.zza(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, zzbn(i));
          break;
        case 26: 
          zziy.zza(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl);
          break;
        case 25: 
          zziy.zzn(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 24: 
          zziy.zzk(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 23: 
          zziy.zzf(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 22: 
          zziy.zzh(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 21: 
          zziy.zzd(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 20: 
          zziy.zzc(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 19: 
          zziy.zzb(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 18: 
          zziy.zza(this.zzzj[i], (List)zzju.zzp(paramT, m & 0xFFFFF), paramzzkl, false);
          break;
        case 17: 
          if (zza(paramT, i)) {
            paramzzkl.zzb(k, zzju.zzp(paramT, m & 0xFFFFF), zzbn(i));
          }
          break;
        case 16: 
          if (zza(paramT, i)) {
            paramzzkl.zzb(k, zzju.zzl(paramT, m & 0xFFFFF));
          }
          break;
        case 15: 
          if (zza(paramT, i)) {
            paramzzkl.zzj(k, zzju.zzk(paramT, m & 0xFFFFF));
          }
          break;
        case 14: 
          if (zza(paramT, i)) {
            paramzzkl.zzj(k, zzju.zzl(paramT, m & 0xFFFFF));
          }
          break;
        case 13: 
          if (zza(paramT, i)) {
            paramzzkl.zzr(k, zzju.zzk(paramT, m & 0xFFFFF));
          }
          break;
        case 12: 
          if (zza(paramT, i)) {
            paramzzkl.zzs(k, zzju.zzk(paramT, m & 0xFFFFF));
          }
          break;
        case 11: 
          if (zza(paramT, i)) {
            paramzzkl.zzi(k, zzju.zzk(paramT, m & 0xFFFFF));
          }
          break;
        case 10: 
          if (zza(paramT, i)) {
            paramzzkl.zza(k, (zzfm)zzju.zzp(paramT, m & 0xFFFFF));
          }
          break;
        case 9: 
          if (zza(paramT, i)) {
            paramzzkl.zza(k, zzju.zzp(paramT, m & 0xFFFFF), zzbn(i));
          }
          break;
        case 8: 
          if (zza(paramT, i)) {
            zza(k, zzju.zzp(paramT, m & 0xFFFFF), paramzzkl);
          }
          break;
        case 7: 
          if (zza(paramT, i)) {
            paramzzkl.zza(k, zzju.zzm(paramT, m & 0xFFFFF));
          }
          break;
        case 6: 
          if (zza(paramT, i)) {
            paramzzkl.zzk(k, zzju.zzk(paramT, m & 0xFFFFF));
          }
          break;
        case 5: 
          if (zza(paramT, i)) {
            paramzzkl.zzc(k, zzju.zzl(paramT, m & 0xFFFFF));
          }
          break;
        case 4: 
          if (zza(paramT, i)) {
            paramzzkl.zzh(k, zzju.zzk(paramT, m & 0xFFFFF));
          }
          break;
        case 3: 
          if (zza(paramT, i)) {
            paramzzkl.zza(k, zzju.zzl(paramT, m & 0xFFFFF));
          }
          break;
        case 2: 
          if (zza(paramT, i)) {
            paramzzkl.zzi(k, zzju.zzl(paramT, m & 0xFFFFF));
          }
          break;
        case 1: 
          if (zza(paramT, i)) {
            paramzzkl.zza(k, zzju.zzn(paramT, m & 0xFFFFF));
          }
          break;
        case 0: 
          if (zza(paramT, i)) {
            paramzzkl.zza(k, zzju.zzo(paramT, m & 0xFFFFF));
          }
          break;
        }
      }
      while (localObject2 != null)
      {
        this.zzzy.zza(paramzzkl, (Map.Entry)localObject2);
        if (localIterator.hasNext()) {
          localObject2 = (Map.Entry)localIterator.next();
        } else {
          localObject2 = null;
        }
      }
      zza(this.zzzx, paramT, paramzzkl);
      return;
    }
    zzb(paramT, paramzzkl);
  }
  
  public final void zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzfg paramzzfg)
    throws IOException
  {
    zzil localzzil = this;
    T ? = paramT;
    byte[] arrayOfByte = paramArrayOfByte;
    int i = paramInt2;
    zzfg localzzfg = paramzzfg;
    if (localzzil.zzzq)
    {
      Object localObject1 = zzzi;
      int j = paramInt1;
      int k = -1;
      int m = 0;
      paramInt1 = 0;
      int n = 1048575;
      while (j < i)
      {
        int i1 = j + 1;
        int i2 = arrayOfByte[j];
        if (i2 < 0)
        {
          j = zzfe.zza(i2, arrayOfByte, i1, localzzfg);
          i2 = localzzfg.zzsd;
        }
        else
        {
          j = i1;
        }
        i1 = i2 >>> 3;
        int i3 = i2 & 0x7;
        if (i1 > k) {
          k = localzzil.zzt(i1, m / 3);
        } else {
          k = localzzil.zzbt(i1);
        }
        if (k == -1) {
          k = 0;
        }
        for (;;)
        {
          break;
          Object localObject2 = localzzil.zzzj;
          int i4 = localObject2[(k + 1)];
          int i5 = (i4 & 0xFF00000) >>> 20;
          long l1 = i4 & 0xFFFFF;
          int i6;
          Object localObject3;
          int i7;
          if (i5 <= 17)
          {
            m = localObject2[(k + 2)];
            i6 = 1 << (m >>> 20);
            m &= 0xFFFFF;
            if (m != n)
            {
              if (n != 1048575) {
                ((Unsafe)localObject1).putInt(?, n, paramInt1);
              }
              if (m != 1048575) {
                paramInt1 = ((Unsafe)localObject1).getInt(?, m);
              }
              n = m;
              m = paramInt1;
            }
            else
            {
              m = paramInt1;
            }
            switch (i5)
            {
            default: 
              break;
            case 16: 
              if (i3 == 0)
              {
                j = zzfe.zzb(arrayOfByte, j, localzzfg);
                long l2 = zzfy.zzr(localzzfg.zzse);
                ((Unsafe)localObject1).putLong(paramT, l1, l2);
                m |= i6;
                paramInt1 = k;
                k = j;
                j = m;
                break label1086;
              }
              break;
            case 15: 
              if (i3 == 0)
              {
                paramInt1 = zzfe.zza(arrayOfByte, j, localzzfg);
                ((Unsafe)localObject1).putInt(?, l1, zzfy.zzav(localzzfg.zzsd));
              }
              break;
            case 12: 
              if (i3 == 0)
              {
                paramInt1 = zzfe.zza(arrayOfByte, j, localzzfg);
                ((Unsafe)localObject1).putInt(?, l1, localzzfg.zzsd);
              }
              break;
            case 10: 
              if (i3 == 2)
              {
                paramInt1 = zzfe.zze(arrayOfByte, j, localzzfg);
                ((Unsafe)localObject1).putObject(?, l1, localzzfg.zzsf);
              }
              break;
            case 9: 
              localObject2 = localObject1;
              if (i3 == 2)
              {
                paramInt1 = zzfe.zza(localzzil.zzbn(k), arrayOfByte, j, i, localzzfg);
                localObject3 = ((Unsafe)localObject2).getObject(?, l1);
                if (localObject3 == null) {
                  ((Unsafe)localObject2).putObject(?, l1, localzzfg.zzsf);
                } else {
                  ((Unsafe)localObject2).putObject(?, l1, zzgy.zzb(localObject3, localzzfg.zzsf));
                }
              }
              break;
            case 8: 
              if (i3 == 2)
              {
                if ((i4 & 0x20000000) == 0) {
                  paramInt1 = zzfe.zzc(arrayOfByte, j, localzzfg);
                } else {
                  paramInt1 = zzfe.zzd(arrayOfByte, j, localzzfg);
                }
                ((Unsafe)localObject1).putObject(?, l1, localzzfg.zzsf);
              }
              break;
            case 7: 
              if (i3 == 0)
              {
                paramInt1 = zzfe.zzb(arrayOfByte, j, localzzfg);
                boolean bool;
                if (localzzfg.zzse != 0L) {
                  bool = true;
                } else {
                  bool = false;
                }
                zzju.zza(?, l1, bool);
              }
              break;
            case 6: 
            case 13: 
              if (i3 == 5)
              {
                ((Unsafe)localObject1).putInt(?, l1, zzfe.zza(arrayOfByte, j));
                paramInt1 = j + 4;
              }
              break;
            case 5: 
            case 14: 
              if (i3 == 1)
              {
                ((Unsafe)localObject1).putLong(paramT, l1, zzfe.zzb(arrayOfByte, j));
                paramInt1 = j + 8;
                break label921;
              }
              break;
            case 4: 
            case 11: 
              if (i3 != 0) {
                break;
              }
              paramInt1 = zzfe.zza(arrayOfByte, j, localzzfg);
              ((Unsafe)localObject1).putInt(?, l1, localzzfg.zzsd);
              break;
            case 2: 
            case 3: 
              i7 = n;
              localObject2 = localObject1;
              if (i3 != 0) {
                break;
              }
              n = zzfe.zzb(arrayOfByte, j, localzzfg);
              ((Unsafe)localObject2).putLong(paramT, l1, localzzfg.zzse);
              j = m | i6;
              localObject1 = localObject2;
              paramInt1 = k;
              k = n;
              n = i7;
              break;
            case 1: 
              paramInt1 = j;
              if (i3 != 5) {
                break;
              }
              zzju.zza(?, l1, zzfe.zzd(arrayOfByte, paramInt1));
              paramInt1 += 4;
              break;
            }
            paramInt1 = j;
            if (i3 == 1)
            {
              zzju.zza(?, l1, zzfe.zzc(arrayOfByte, paramInt1));
              paramInt1 += 8;
              label921:
              m |= i6;
              j = k;
              k = paramInt1;
              paramInt1 = j;
              j = m;
            }
            else
            {
              paramInt1 = m;
            }
          }
          else
          {
            i7 = i1;
            m = n;
            if (i5 != 27) {
              break label1106;
            }
            if (i3 != 2) {
              break label1103;
            }
            localObject3 = (zzhe)((Unsafe)localObject1).getObject(?, l1);
            localObject2 = localObject3;
            if (!((zzhe)localObject3).zzdp())
            {
              n = ((List)localObject3).size();
              if (n == 0) {
                n = 10;
              } else {
                n <<= 1;
              }
              localObject2 = ((zzhe)localObject3).zzah(n);
              ((Unsafe)localObject1).putObject(?, l1, localObject2);
            }
            i2 = zzfe.zza(localzzil.zzbn(k), i2, paramArrayOfByte, j, paramInt2, (zzhe)localObject2, paramzzfg);
            n = m;
            j = paramInt1;
            paramInt1 = k;
            k = i2;
          }
          label1086:
          m = k;
          k = i1;
          i1 = paramInt1;
          paramInt1 = j;
          break label1316;
          label1103:
          break label1224;
          label1106:
          i = k;
          if (i5 <= 49)
          {
            i6 = zza(paramT, paramArrayOfByte, j, paramInt2, i2, i7, i3, i, i4, i5, l1, paramzzfg);
            m = i6;
            if (i6 == j)
            {
              j = i6;
              break label1266;
            }
          }
          for (;;)
          {
            i1 = i;
            k = i7;
            break label1299;
            i6 = j;
            if (i5 == 50) {
              if (i3 == 2)
              {
                j = zza(paramT, paramArrayOfByte, i6, paramInt2, i, l1, paramzzfg);
                m = j;
                if (j == i6) {
                  break label1266;
                }
              }
            }
          }
          label1224:
          label1266:
          for (;;)
          {
            break label1269;
            j = zza(paramT, paramArrayOfByte, i6, paramInt2, i2, i7, i3, i4, i5, l1, i, paramzzfg);
            m = j;
            if (j != i6) {
              break;
            }
          }
        }
        label1269:
        m = zzfe.zza(i2, paramArrayOfByte, j, paramInt2, zzt(paramT), paramzzfg);
        j = i1;
        i1 = k;
        k = j;
        label1299:
        localzzil = this;
        ? = paramT;
        i = paramInt2;
        arrayOfByte = paramArrayOfByte;
        localzzfg = paramzzfg;
        label1316:
        j = m;
        m = i1;
      }
      if (n != 1048575) {
        ((Unsafe)localObject1).putInt(paramT, n, paramInt1);
      }
      if (j == paramInt2) {
        return;
      }
      throw zzhh.zzgt();
    }
    zza(paramT, paramArrayOfByte, paramInt1, paramInt2, 0, paramzzfg);
  }
  
  public final void zzd(T paramT1, T paramT2)
  {
    Objects.requireNonNull(paramT2);
    for (int i = 0; i < this.zzzj.length; i += 3)
    {
      int j = zzbq(i);
      long l = 0xFFFFF & j;
      int k = this.zzzj[i];
      switch ((j & 0xFF00000) >>> 20)
      {
      default: 
        break;
      case 68: 
        zzb(paramT1, paramT2, i);
        break;
      case 61: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
        if (zza(paramT2, k, i))
        {
          zzju.zza(paramT1, l, zzju.zzp(paramT2, l));
          zzb(paramT1, k, i);
        }
        break;
      case 60: 
        zzb(paramT1, paramT2, i);
        break;
      case 51: 
      case 52: 
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
        if (zza(paramT2, k, i))
        {
          zzju.zza(paramT1, l, zzju.zzp(paramT2, l));
          zzb(paramT1, k, i);
        }
        break;
      case 50: 
        zziy.zza(this.zzzz, paramT1, paramT2, l);
        break;
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
        this.zzzw.zza(paramT1, paramT2, l);
        break;
      case 17: 
        zza(paramT1, paramT2, i);
        break;
      case 16: 
        if (zza(paramT2, i))
        {
          zzju.zza(paramT1, l, zzju.zzl(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 15: 
        if (zza(paramT2, i))
        {
          zzju.zzb(paramT1, l, zzju.zzk(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 14: 
        if (zza(paramT2, i))
        {
          zzju.zza(paramT1, l, zzju.zzl(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 13: 
        if (zza(paramT2, i))
        {
          zzju.zzb(paramT1, l, zzju.zzk(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 12: 
        if (zza(paramT2, i))
        {
          zzju.zzb(paramT1, l, zzju.zzk(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 11: 
        if (zza(paramT2, i))
        {
          zzju.zzb(paramT1, l, zzju.zzk(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 10: 
        if (zza(paramT2, i))
        {
          zzju.zza(paramT1, l, zzju.zzp(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 9: 
        zza(paramT1, paramT2, i);
        break;
      case 8: 
        if (zza(paramT2, i))
        {
          zzju.zza(paramT1, l, zzju.zzp(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 7: 
        if (zza(paramT2, i))
        {
          zzju.zza(paramT1, l, zzju.zzm(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 6: 
        if (zza(paramT2, i))
        {
          zzju.zzb(paramT1, l, zzju.zzk(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 5: 
        if (zza(paramT2, i))
        {
          zzju.zza(paramT1, l, zzju.zzl(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 4: 
        if (zza(paramT2, i))
        {
          zzju.zzb(paramT1, l, zzju.zzk(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 3: 
        if (zza(paramT2, i))
        {
          zzju.zza(paramT1, l, zzju.zzl(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 2: 
        if (zza(paramT2, i))
        {
          zzju.zza(paramT1, l, zzju.zzl(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 1: 
        if (zza(paramT2, i))
        {
          zzju.zza(paramT1, l, zzju.zzn(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 0: 
        if (zza(paramT2, i))
        {
          zzju.zza(paramT1, l, zzju.zzo(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      }
    }
    zziy.zza(this.zzzx, paramT1, paramT2);
    if (this.zzzo) {
      zziy.zza(this.zzzy, paramT1, paramT2);
    }
  }
  
  public final void zzh(T paramT)
  {
    int j;
    for (int i = this.zzzt;; i++)
    {
      j = this.zzzu;
      if (i >= j) {
        break;
      }
      long l = zzbq(this.zzzs[i]) & 0xFFFFF;
      Object localObject = zzju.zzp(paramT, l);
      if (localObject != null) {
        zzju.zza(paramT, l, this.zzzz.zzo(localObject));
      }
    }
    int k = this.zzzs.length;
    for (i = j; i < k; i++) {
      this.zzzw.zzb(paramT, this.zzzs[i]);
    }
    this.zzzx.zzh(paramT);
    if (this.zzzo) {
      this.zzzy.zzh(paramT);
    }
  }
  
  public final int zzs(T paramT)
  {
    int n;
    long l;
    Object localObject2;
    int i2;
    if (this.zzzq)
    {
      localObject1 = zzzi;
      i = 0;
      for (j = 0; i < this.zzzj.length; j = m)
      {
        k = zzbq(i);
        m = (k & 0xFF00000) >>> 20;
        n = this.zzzj[i];
        l = k & 0xFFFFF;
        if ((m >= zzgs.zzvi.id()) && (m <= zzgs.zzvv.id())) {
          k = this.zzzj[(i + 2)] & 0xFFFFF;
        } else {
          k = 0;
        }
        switch (m)
        {
        default: 
          m = j;
          break;
        case 68: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzc(n, (zzih)zzju.zzp(paramT, l), zzbn(i));
          break;
        case 67: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzf(n, zzi(paramT, l));
          break;
        case 66: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzn(n, zzh(paramT, l));
          break;
        case 65: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzh(n, 0L);
          break;
        case 64: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzp(n, 0);
          break;
        case 63: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzq(n, zzh(paramT, l));
          break;
        case 62: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzm(n, zzh(paramT, l));
          break;
        case 61: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzc(n, (zzfm)zzju.zzp(paramT, l));
          break;
        case 60: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zziy.zzc(n, zzju.zzp(paramT, l), zzbn(i));
          break;
        case 59: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          localObject2 = zzju.zzp(paramT, l);
          if ((localObject2 instanceof zzfm)) {
            k = zzgf.zzc(n, (zzfm)localObject2);
          } else {
            k = zzgf.zzb(n, (String)localObject2);
          }
          break;
        case 58: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzb(n, true);
          break;
        case 57: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzo(n, 0);
          break;
        case 56: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzg(n, 0L);
          break;
        case 55: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzl(n, zzh(paramT, l));
          break;
        case 54: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zze(n, zzi(paramT, l));
          break;
        case 53: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzd(n, zzi(paramT, l));
          break;
        case 52: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzb(n, 0.0F);
          break;
        case 51: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzgf.zzb(n, 0.0D);
          break;
        case 50: 
          k = this.zzzz.zzb(n, zzju.zzp(paramT, l), zzbo(i));
          break;
        case 49: 
          k = zziy.zzd(n, zze(paramT, l), zzbn(i));
          break;
        case 48: 
          i1 = zziy.zzs((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzgf.zzbb(n);
          i2 = zzgf.zzbd(i1);
          m = i1;
          i1 = i2;
          break;
        case 47: 
          i1 = zziy.zzw((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzgf.zzbb(n);
          i2 = zzgf.zzbd(i1);
          m = i1;
          i1 = i2;
          break;
        case 46: 
          i1 = zziy.zzy((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzgf.zzbb(n);
          i2 = zzgf.zzbd(i1);
          m = i1;
          i1 = i2;
          break;
        case 45: 
          i1 = zziy.zzx((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzgf.zzbb(n);
          i2 = zzgf.zzbd(i1);
          m = i1;
          i1 = i2;
          break;
        case 44: 
          i1 = zziy.zzt((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzgf.zzbb(n);
          i2 = zzgf.zzbd(i1);
          m = i1;
          i1 = i2;
          break;
        case 43: 
          i1 = zziy.zzv((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzgf.zzbb(n);
          i2 = zzgf.zzbd(i1);
          m = i1;
          i1 = i2;
          break;
        case 42: 
          i1 = zziy.zzz((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzgf.zzbb(n);
          i2 = zzgf.zzbd(i1);
          m = i1;
          i1 = i2;
          break;
        case 41: 
          i1 = zziy.zzx((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzgf.zzbb(n);
          i2 = zzgf.zzbd(i1);
          m = i1;
          i1 = i2;
          break;
        case 40: 
          i1 = zziy.zzy((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzgf.zzbb(n);
          i2 = zzgf.zzbd(i1);
          m = i1;
          i1 = i2;
          break;
        case 39: 
          i1 = zziy.zzu((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzgf.zzbb(n);
          i2 = zzgf.zzbd(i1);
          m = i1;
          i1 = i2;
          break;
        case 38: 
          i1 = zziy.zzr((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzgf.zzbb(n);
          i2 = zzgf.zzbd(i1);
          m = i1;
          i1 = i2;
          break;
        case 37: 
          i1 = zziy.zzq((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzgf.zzbb(n);
          i2 = zzgf.zzbd(i1);
          m = i1;
          i1 = i2;
          break;
        case 36: 
          i1 = zziy.zzx((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzgf.zzbb(n);
          i2 = zzgf.zzbd(i1);
          m = i1;
          i1 = i2;
          break;
        case 35: 
          i2 = zziy.zzy((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i2 <= 0) {
            break label2777;
          }
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, k, i2);
          }
          k = zzgf.zzbb(n);
          i1 = zzgf.zzbd(i2);
          m = i2;
          k = k + i1 + m;
          break;
        case 34: 
          k = zziy.zzq(n, zze(paramT, l), false);
          break;
        case 33: 
          k = zziy.zzu(n, zze(paramT, l), false);
          break;
        case 32: 
          k = zziy.zzw(n, zze(paramT, l), false);
          break;
        case 31: 
          k = zziy.zzv(n, zze(paramT, l), false);
          break;
        case 30: 
          k = zziy.zzr(n, zze(paramT, l), false);
          break;
        case 29: 
          k = zziy.zzt(n, zze(paramT, l), false);
          break;
        case 28: 
          k = zziy.zzd(n, zze(paramT, l));
          break;
        case 27: 
          k = zziy.zzc(n, zze(paramT, l), zzbn(i));
          break;
        case 26: 
          k = zziy.zzc(n, zze(paramT, l));
          break;
        case 25: 
          k = zziy.zzx(n, zze(paramT, l), false);
          break;
        case 24: 
          k = zziy.zzv(n, zze(paramT, l), false);
          break;
        case 23: 
          k = zziy.zzw(n, zze(paramT, l), false);
          break;
        case 22: 
          k = zziy.zzs(n, zze(paramT, l), false);
          break;
        case 21: 
          k = zziy.zzp(n, zze(paramT, l), false);
          break;
        case 20: 
          k = zziy.zzo(n, zze(paramT, l), false);
          break;
        case 19: 
          k = zziy.zzv(n, zze(paramT, l), false);
          break;
        case 18: 
          k = zziy.zzw(n, zze(paramT, l), false);
        }
        for (;;)
        {
          m = j + k;
          break;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzgf.zzc(n, (zzih)zzju.zzp(paramT, l), zzbn(i));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzgf.zzf(n, zzju.zzl(paramT, l));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzgf.zzn(n, zzju.zzk(paramT, l));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzgf.zzh(n, 0L);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzgf.zzp(n, 0);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzgf.zzq(n, zzju.zzk(paramT, l));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzgf.zzm(n, zzju.zzk(paramT, l));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzgf.zzc(n, (zzfm)zzju.zzp(paramT, l));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zziy.zzc(n, zzju.zzp(paramT, l), zzbn(i));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          localObject2 = zzju.zzp(paramT, l);
          if ((localObject2 instanceof zzfm))
          {
            k = zzgf.zzc(n, (zzfm)localObject2);
          }
          else
          {
            k = zzgf.zzb(n, (String)localObject2);
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzgf.zzb(n, true);
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzgf.zzo(n, 0);
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzgf.zzg(n, 0L);
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzgf.zzl(n, zzju.zzk(paramT, l));
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzgf.zze(n, zzju.zzl(paramT, l));
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzgf.zzd(n, zzju.zzl(paramT, l));
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzgf.zzb(n, 0.0F);
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzgf.zzb(n, 0.0D);
          }
        }
        label2777:
        i += 3;
      }
      return j + zza(this.zzzx, paramT);
    }
    Object localObject1 = zzzi;
    int j = 0;
    int i = 0;
    int k = 1048575;
    for (int m = 0; j < this.zzzj.length; m = n)
    {
      int i3 = zzbq(j);
      localObject2 = this.zzzj;
      int i4 = localObject2[j];
      int i5 = (i3 & 0xFF00000) >>> 20;
      int i6;
      if (i5 <= 17)
      {
        i2 = localObject2[(j + 2)];
        n = i2 & 0xFFFFF;
        i6 = 1 << (i2 >>> 20);
        i1 = k;
        if (n != k)
        {
          m = ((Unsafe)localObject1).getInt(paramT, n);
          i1 = n;
        }
        k = i2;
        i2 = i1;
        i1 = k;
        n = m;
      }
      else
      {
        if ((this.zzzr) && (i5 >= zzgs.zzvi.id()) && (i5 <= zzgs.zzvv.id())) {
          i1 = this.zzzj[(j + 2)] & 0xFFFFF;
        } else {
          i1 = 0;
        }
        i6 = 0;
        n = m;
        i2 = k;
      }
      l = i3 & 0xFFFFF;
      switch (i5)
      {
      default: 
        k = i;
        break;
      case 68: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzc(i4, (zzih)((Unsafe)localObject1).getObject(paramT, l), zzbn(j));
        }
        break;
      case 67: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzf(i4, zzi(paramT, l));
        }
        break;
      case 66: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzn(i4, zzh(paramT, l));
        }
        break;
      case 65: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzh(i4, 0L);
        }
        break;
      case 64: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzp(i4, 0);
        }
        break;
      case 63: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzq(i4, zzh(paramT, l));
        }
        break;
      case 62: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzm(i4, zzh(paramT, l));
        }
        break;
      case 61: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzc(i4, (zzfm)((Unsafe)localObject1).getObject(paramT, l));
        }
        break;
      case 60: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zziy.zzc(i4, ((Unsafe)localObject1).getObject(paramT, l), zzbn(j));
        }
        break;
      case 59: 
        k = i;
        if (zza(paramT, i4, j))
        {
          localObject2 = ((Unsafe)localObject1).getObject(paramT, l);
          if ((localObject2 instanceof zzfm)) {
            k = zzgf.zzc(i4, (zzfm)localObject2);
          } else {
            k = zzgf.zzb(i4, (String)localObject2);
          }
        }
        break;
      case 58: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzb(i4, true);
        }
        break;
      case 57: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzo(i4, 0);
        }
        break;
      case 56: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzg(i4, 0L);
        }
        break;
      case 55: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzl(i4, zzh(paramT, l));
        }
        break;
      case 54: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zze(i4, zzi(paramT, l));
        }
        break;
      case 53: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzd(i4, zzi(paramT, l));
        }
        break;
      case 52: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzb(i4, 0.0F);
        }
        break;
      case 51: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzgf.zzb(i4, 0.0D);
        }
        break;
      case 50: 
        k = this.zzzz.zzb(i4, ((Unsafe)localObject1).getObject(paramT, l), zzbo(j));
        break;
      case 49: 
        k = zziy.zzd(i4, (List)((Unsafe)localObject1).getObject(paramT, l), zzbn(j));
        break;
      case 48: 
        m = zziy.zzs((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(m);
          k = m;
          m = i6;
        }
        break;
      case 47: 
        m = zziy.zzw((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(m);
          k = m;
          m = i6;
        }
        break;
      case 46: 
        m = zziy.zzy((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(m);
          k = m;
          m = i6;
        }
        break;
      case 45: 
        m = zziy.zzx((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(m);
          k = m;
          m = i6;
        }
        break;
      case 44: 
        m = zziy.zzt((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(m);
          k = m;
          m = i6;
        }
        break;
      case 43: 
        m = zziy.zzv((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(m);
          k = m;
          m = i6;
        }
        break;
      case 42: 
        m = zziy.zzz((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(m);
          k = m;
          m = i6;
        }
        break;
      case 41: 
        m = zziy.zzx((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(m);
          k = m;
          m = i6;
        }
        break;
      case 40: 
        m = zziy.zzy((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(m);
          k = m;
          m = i6;
        }
        break;
      case 39: 
        m = zziy.zzu((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(m);
          k = m;
          m = i6;
        }
        break;
      case 38: 
        m = zziy.zzr((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(m);
          k = m;
          m = i6;
        }
        break;
      case 37: 
        m = zziy.zzq((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(m);
          k = m;
          m = i6;
        }
        break;
      case 36: 
        m = zziy.zzx((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(m);
          k = m;
          m = i6;
        }
        break;
      case 35: 
        i6 = zziy.zzy((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (i6 > 0)
        {
          if (this.zzzr) {
            ((Unsafe)localObject1).putInt(paramT, i1, i6);
          }
          m = zzgf.zzbb(i4);
          i1 = zzgf.zzbd(i6);
          k = i6;
          k = m + i1 + k;
        }
        break;
      case 34: 
        k = zziy.zzq(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 33: 
        k = zziy.zzu(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 32: 
        k = zziy.zzw(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 31: 
        k = zziy.zzv(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 30: 
        k = zziy.zzr(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 29: 
        k = zziy.zzt(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 28: 
        k = zziy.zzd(i4, (List)((Unsafe)localObject1).getObject(paramT, l));
        break;
      case 27: 
        k = zziy.zzc(i4, (List)((Unsafe)localObject1).getObject(paramT, l), zzbn(j));
        break;
      case 26: 
        k = zziy.zzc(i4, (List)((Unsafe)localObject1).getObject(paramT, l));
        break;
      case 25: 
        k = zziy.zzx(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 24: 
        k = zziy.zzv(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 23: 
        k = zziy.zzw(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 22: 
        k = zziy.zzs(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 21: 
        k = zziy.zzp(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 20: 
        k = zziy.zzo(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 19: 
        k = zziy.zzv(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 18: 
        k = zziy.zzw(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        k = i + k;
      }
      for (;;)
      {
        break label5735;
        k = i;
        if ((n & i6) != 0)
        {
          k = zzgf.zzc(i4, (zzih)((Unsafe)localObject1).getObject(paramT, l), zzbn(j));
          break;
          k = i;
          if ((n & i6) != 0)
          {
            k = zzgf.zzf(i4, ((Unsafe)localObject1).getLong(paramT, l));
            break;
            k = i;
            if ((n & i6) != 0)
            {
              k = zzgf.zzn(i4, ((Unsafe)localObject1).getInt(paramT, l));
              break;
              k = i;
              if ((n & i6) != 0)
              {
                k = zzgf.zzh(i4, 0L);
                break;
                k = i;
                if ((n & i6) != 0)
                {
                  k = zzgf.zzp(i4, 0);
                  k = i + k;
                  continue;
                  k = i;
                  if ((n & i6) != 0)
                  {
                    k = zzgf.zzq(i4, ((Unsafe)localObject1).getInt(paramT, l));
                    break;
                    k = i;
                    if ((n & i6) != 0)
                    {
                      k = zzgf.zzm(i4, ((Unsafe)localObject1).getInt(paramT, l));
                      break;
                      k = i;
                      if ((n & i6) != 0)
                      {
                        k = zzgf.zzc(i4, (zzfm)((Unsafe)localObject1).getObject(paramT, l));
                        break;
                        k = i;
                        if ((n & i6) != 0)
                        {
                          k = zziy.zzc(i4, ((Unsafe)localObject1).getObject(paramT, l), zzbn(j));
                          break;
                          k = i;
                          if ((n & i6) != 0)
                          {
                            localObject2 = ((Unsafe)localObject1).getObject(paramT, l);
                            if ((localObject2 instanceof zzfm))
                            {
                              k = zzgf.zzc(i4, (zzfm)localObject2);
                              break;
                            }
                            k = zzgf.zzb(i4, (String)localObject2);
                            break;
                            k = i;
                            if ((n & i6) != 0)
                            {
                              k = zzgf.zzb(i4, true);
                              break;
                              k = i;
                              if ((n & i6) != 0)
                              {
                                k = i + zzgf.zzo(i4, 0);
                                continue;
                                k = i;
                                if ((n & i6) != 0)
                                {
                                  k = zzgf.zzg(i4, 0L);
                                  break label5681;
                                  k = i;
                                  if ((n & i6) != 0)
                                  {
                                    k = zzgf.zzl(i4, ((Unsafe)localObject1).getInt(paramT, l));
                                    break label5681;
                                    k = i;
                                    if ((n & i6) != 0)
                                    {
                                      k = zzgf.zze(i4, ((Unsafe)localObject1).getLong(paramT, l));
                                      break label5681;
                                      k = i;
                                      if ((n & i6) != 0)
                                      {
                                        k = zzgf.zzd(i4, ((Unsafe)localObject1).getLong(paramT, l));
                                        label5681:
                                        k = i + k;
                                      }
                                    }
                                  }
                                }
                                for (;;)
                                {
                                  break;
                                  k = i;
                                  if ((n & i6) != 0) {
                                    k = i + zzgf.zzb(i4, 0.0F);
                                  }
                                }
                                for (;;)
                                {
                                  break;
                                  k = i;
                                  if ((n & i6) != 0) {
                                    k = i + zzgf.zzb(i4, 0.0D);
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label5735:
      j += 3;
      i = k;
      k = i2;
    }
    j = 0;
    int i1 = i + zza(this.zzzx, paramT);
    k = i1;
    if (this.zzzo)
    {
      paramT = this.zzzy.zzf(paramT);
      m = 0;
      k = j;
      while (m < paramT.zztq.zzhy())
      {
        localObject1 = paramT.zztq.zzbv(m);
        k += zzgn.zzc((zzgp)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
        m++;
      }
      paramT = paramT.zztq.zzhz().iterator();
      while (paramT.hasNext())
      {
        localObject1 = (Map.Entry)paramT.next();
        k += zzgn.zzc((zzgp)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
      }
      k = i1 + k;
    }
    return k;
  }
  
  public final boolean zzu(T paramT)
  {
    int i = 1048575;
    int j = 0;
    for (int k = 0;; k++)
    {
      int m = this.zzzt;
      int n = 1;
      int i1 = 1;
      if (k >= m) {
        break;
      }
      int i2 = this.zzzs[k];
      int i3 = this.zzzj[i2];
      int i4 = zzbq(i2);
      int i5 = this.zzzj[(i2 + 2)];
      m = i5 & 0xFFFFF;
      i5 = 1 << (i5 >>> 20);
      if (m != i)
      {
        if (m != 1048575) {
          j = zzzi.getInt(paramT, m);
        }
        i = m;
      }
      if ((0x10000000 & i4) != 0) {
        m = 1;
      } else {
        m = 0;
      }
      if ((m != 0) && (!zza(paramT, i2, i, j, i5))) {
        return false;
      }
      m = (0xFF00000 & i4) >>> 20;
      if ((m != 9) && (m != 17))
      {
        Object localObject1;
        if (m != 27) {
          if ((m != 60) && (m != 68))
          {
            if (m != 49)
            {
              if (m != 50) {
                continue;
              }
              localObject1 = this.zzzz.zzm(zzju.zzp(paramT, i4 & 0xFFFFF));
              m = i1;
              if (!((Map)localObject1).isEmpty())
              {
                localObject2 = zzbo(i2);
                m = i1;
                if (this.zzzz.zzq(localObject2).zzzd.zziq() == zzki.zzade)
                {
                  localObject2 = null;
                  Iterator localIterator = ((Map)localObject1).values().iterator();
                  Object localObject3;
                  do
                  {
                    m = i1;
                    if (!localIterator.hasNext()) {
                      break;
                    }
                    localObject3 = localIterator.next();
                    localObject1 = localObject2;
                    if (localObject2 == null) {
                      localObject1 = zzis.zzhp().zzf(localObject3.getClass());
                    }
                    localObject2 = localObject1;
                  } while (((zziw)localObject1).zzu(localObject3));
                  m = 0;
                }
              }
              if (m != 0) {
                continue;
              }
              return false;
            }
          }
          else
          {
            if ((!zza(paramT, i3, i2)) || (zza(paramT, i4, zzbn(i2)))) {
              continue;
            }
            return false;
          }
        }
        Object localObject2 = (List)zzju.zzp(paramT, i4 & 0xFFFFF);
        m = n;
        if (!((List)localObject2).isEmpty())
        {
          localObject1 = zzbn(i2);
          for (i1 = 0;; i1++)
          {
            m = n;
            if (i1 >= ((List)localObject2).size()) {
              break;
            }
            if (!((zziw)localObject1).zzu(((List)localObject2).get(i1)))
            {
              m = 0;
              break;
            }
          }
        }
        if (m == 0) {
          return false;
        }
      }
      else if ((zza(paramT, i2, i, j, i5)) && (!zza(paramT, i4, zzbn(i2))))
      {
        return false;
      }
    }
    return (!this.zzzo) || (this.zzzy.zzf(paramT).isInitialized());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */