package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

final class zzll<T>
  implements zzlt<T>
{
  private static final int[] zza = new int[0];
  private static final Unsafe zzb = zzmr.zzq();
  private final int[] zzc;
  private final Object[] zzd;
  private final int zze;
  private final int zzf;
  private final zzli zzg;
  private final boolean zzh;
  private final boolean zzi;
  private final int[] zzj;
  private final int zzk;
  private final int zzl;
  private final zzkw zzm;
  private final zzmh<?, ?> zzn;
  private final zzjq<?> zzo;
  private final zzln zzp;
  private final zzld zzq;
  
  private zzll(int[] paramArrayOfInt1, Object[] paramArrayOfObject, int paramInt1, int paramInt2, zzli paramzzli, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt2, int paramInt3, int paramInt4, zzln paramzzln, zzkw paramzzkw, zzmh<?, ?> paramzzmh, zzjq<?> paramzzjq, zzld paramzzld)
  {
    this.zzc = paramArrayOfInt1;
    this.zzd = paramArrayOfObject;
    this.zze = paramInt1;
    this.zzf = paramInt2;
    this.zzi = paramBoolean1;
    paramBoolean2 = false;
    paramBoolean1 = paramBoolean2;
    if (paramzzjq != null)
    {
      paramBoolean1 = paramBoolean2;
      if (paramzzjq.zza(paramzzli)) {
        paramBoolean1 = true;
      }
    }
    this.zzh = paramBoolean1;
    this.zzj = paramArrayOfInt2;
    this.zzk = paramInt3;
    this.zzl = paramInt4;
    this.zzp = paramzzln;
    this.zzm = paramzzkw;
    this.zzn = paramzzmh;
    this.zzo = paramzzjq;
    this.zzg = paramzzli;
    this.zzq = paramzzld;
  }
  
  private final int zzA(int paramInt)
  {
    return this.zzc[(paramInt + 1)];
  }
  
  private final int zzB(int paramInt)
  {
    return this.zzc[(paramInt + 2)];
  }
  
  private static int zzC(int paramInt)
  {
    return paramInt >>> 20 & 0xFF;
  }
  
  private static <T> double zzD(T paramT, long paramLong)
  {
    return ((Double)zzmr.zzn(paramT, paramLong)).doubleValue();
  }
  
  private static <T> float zzE(T paramT, long paramLong)
  {
    return ((Float)zzmr.zzn(paramT, paramLong)).floatValue();
  }
  
  private static <T> int zzF(T paramT, long paramLong)
  {
    return ((Integer)zzmr.zzn(paramT, paramLong)).intValue();
  }
  
  private static <T> long zzG(T paramT, long paramLong)
  {
    return ((Long)zzmr.zzn(paramT, paramLong)).longValue();
  }
  
  private static <T> boolean zzH(T paramT, long paramLong)
  {
    return ((Boolean)zzmr.zzn(paramT, paramLong)).booleanValue();
  }
  
  private final boolean zzI(T paramT1, T paramT2, int paramInt)
  {
    return zzK(paramT1, paramInt) == zzK(paramT2, paramInt);
  }
  
  private final boolean zzJ(T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 == 1048575) {
      return zzK(paramT, paramInt1);
    }
    return (paramInt3 & paramInt4) != 0;
  }
  
  private final boolean zzK(T paramT, int paramInt)
  {
    int i = zzB(paramInt);
    long l = i & 0xFFFFF;
    if (l == 1048575L)
    {
      paramInt = zzA(paramInt);
      l = paramInt & 0xFFFFF;
      switch (zzC(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 17: 
        return zzmr.zzn(paramT, l) != null;
      case 16: 
        return zzmr.zzf(paramT, l) != 0L;
      case 15: 
        return zzmr.zzd(paramT, l) != 0;
      case 14: 
        return zzmr.zzf(paramT, l) != 0L;
      case 13: 
        return zzmr.zzd(paramT, l) != 0;
      case 12: 
        return zzmr.zzd(paramT, l) != 0;
      case 11: 
        return zzmr.zzd(paramT, l) != 0;
      case 10: 
        return !zzjd.zzb.equals(zzmr.zzn(paramT, l));
      case 9: 
        return zzmr.zzn(paramT, l) != null;
      case 8: 
        paramT = zzmr.zzn(paramT, l);
        if ((paramT instanceof String)) {
          return !((String)paramT).isEmpty();
        }
        if ((paramT instanceof zzjd)) {
          return !zzjd.zzb.equals(paramT);
        }
        throw new IllegalArgumentException();
      case 7: 
        return zzmr.zzh(paramT, l);
      case 6: 
        return zzmr.zzd(paramT, l) != 0;
      case 5: 
        return zzmr.zzf(paramT, l) != 0L;
      case 4: 
        return zzmr.zzd(paramT, l) != 0;
      case 3: 
        return zzmr.zzf(paramT, l) != 0L;
      case 2: 
        return zzmr.zzf(paramT, l) != 0L;
      case 1: 
        return zzmr.zzj(paramT, l) != 0.0F;
      }
      return zzmr.zzl(paramT, l) != 0.0D;
    }
    return (zzmr.zzd(paramT, l) & 1 << (i >>> 20)) != 0;
  }
  
  private final void zzL(T paramT, int paramInt)
  {
    paramInt = zzB(paramInt);
    long l = 0xFFFFF & paramInt;
    if (l == 1048575L) {
      return;
    }
    zzmr.zze(paramT, l, 1 << (paramInt >>> 20) | zzmr.zzd(paramT, l));
  }
  
  private final boolean zzM(T paramT, int paramInt1, int paramInt2)
  {
    return zzmr.zzd(paramT, zzB(paramInt2) & 0xFFFFF) == paramInt1;
  }
  
  private final void zzN(T paramT, int paramInt1, int paramInt2)
  {
    zzmr.zze(paramT, zzB(paramInt2) & 0xFFFFF, paramInt1);
  }
  
  private final int zzO(int paramInt)
  {
    if ((paramInt >= this.zze) && (paramInt <= this.zzf)) {
      return zzQ(paramInt, 0);
    }
    return -1;
  }
  
  private final int zzP(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= this.zze) && (paramInt1 <= this.zzf)) {
      return zzQ(paramInt1, paramInt2);
    }
    return -1;
  }
  
  private final int zzQ(int paramInt1, int paramInt2)
  {
    int i = this.zzc.length / 3 - 1;
    while (paramInt2 <= i)
    {
      int j = i + paramInt2 >>> 1;
      int k = j * 3;
      int m = this.zzc[k];
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
  
  private final void zzR(T paramT, zzjl paramzzjl)
    throws IOException
  {
    if (!this.zzh)
    {
      int i = this.zzc.length;
      Object localObject = zzb;
      int j = 0;
      int k = 0;
      int m = 1048575;
      while (j < i)
      {
        int n = zzA(j);
        int i1 = this.zzc[j];
        int i2 = zzC(n);
        int i4;
        int i5;
        if (i2 <= 17)
        {
          int i3 = this.zzc[(j + 2)];
          i4 = i3 & 0xFFFFF;
          i5 = k;
          k = m;
          if (i4 != m)
          {
            i5 = ((Unsafe)localObject).getInt(paramT, i4);
            k = i4;
          }
          i4 = 1 << (i3 >>> 20);
          m = k;
        }
        else
        {
          i4 = 0;
          i5 = k;
        }
        long l = n & 0xFFFFF;
        switch (i2)
        {
        }
        for (;;)
        {
          break;
          if (zzM(paramT, i1, j))
          {
            paramzzjl.zzs(i1, ((Unsafe)localObject).getObject(paramT, l), zzv(j));
            continue;
            if (zzM(paramT, i1, j))
            {
              paramzzjl.zzq(i1, zzG(paramT, l));
              continue;
              if (zzM(paramT, i1, j))
              {
                paramzzjl.zzp(i1, zzF(paramT, l));
                continue;
                if (zzM(paramT, i1, j))
                {
                  paramzzjl.zzd(i1, zzG(paramT, l));
                  continue;
                  if (zzM(paramT, i1, j))
                  {
                    paramzzjl.zzb(i1, zzF(paramT, l));
                    continue;
                    if (zzM(paramT, i1, j))
                    {
                      paramzzjl.zzg(i1, zzF(paramT, l));
                      continue;
                      if (zzM(paramT, i1, j))
                      {
                        paramzzjl.zzo(i1, zzF(paramT, l));
                        continue;
                        if (zzM(paramT, i1, j))
                        {
                          paramzzjl.zzn(i1, (zzjd)((Unsafe)localObject).getObject(paramT, l));
                          continue;
                          if (zzM(paramT, i1, j))
                          {
                            paramzzjl.zzr(i1, ((Unsafe)localObject).getObject(paramT, l), zzv(j));
                            continue;
                            if (zzM(paramT, i1, j))
                            {
                              zzT(i1, ((Unsafe)localObject).getObject(paramT, l), paramzzjl);
                              continue;
                              if (zzM(paramT, i1, j))
                              {
                                paramzzjl.zzl(i1, zzH(paramT, l));
                                continue;
                                if (zzM(paramT, i1, j))
                                {
                                  paramzzjl.zzk(i1, zzF(paramT, l));
                                  continue;
                                  if (zzM(paramT, i1, j))
                                  {
                                    paramzzjl.zzj(i1, zzG(paramT, l));
                                    continue;
                                    if (zzM(paramT, i1, j))
                                    {
                                      paramzzjl.zzi(i1, zzF(paramT, l));
                                      continue;
                                      if (zzM(paramT, i1, j))
                                      {
                                        paramzzjl.zzh(i1, zzG(paramT, l));
                                        continue;
                                        if (zzM(paramT, i1, j))
                                        {
                                          paramzzjl.zzc(i1, zzG(paramT, l));
                                          continue;
                                          if (zzM(paramT, i1, j))
                                          {
                                            paramzzjl.zze(i1, zzE(paramT, l));
                                            continue;
                                            if (zzM(paramT, i1, j))
                                            {
                                              paramzzjl.zzf(i1, zzD(paramT, l));
                                              continue;
                                              zzS(paramzzjl, i1, ((Unsafe)localObject).getObject(paramT, l), j);
                                              continue;
                                              zzlv.zzaa(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, zzv(j));
                                              continue;
                                              zzlv.zzN(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzS(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzP(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzU(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzV(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzR(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzW(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzT(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzO(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzQ(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzM(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzL(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzK(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzJ(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, true);
                                              continue;
                                              zzlv.zzN(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              continue;
                                              zzlv.zzS(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              continue;
                                              zzlv.zzP(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              continue;
                                              zzlv.zzU(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              continue;
                                              zzlv.zzV(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              continue;
                                              zzlv.zzR(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              continue;
                                              zzlv.zzY(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl);
                                              continue;
                                              zzlv.zzZ(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, zzv(j));
                                              continue;
                                              zzlv.zzX(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl);
                                              continue;
                                              zzlv.zzW(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              break;
                                              zzlv.zzT(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              break;
                                              zzlv.zzO(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              break;
                                              zzlv.zzQ(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              break;
                                              zzlv.zzM(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              break;
                                              zzlv.zzL(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              break;
                                              zzlv.zzK(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              break;
                                              zzlv.zzJ(this.zzc[j], (List)((Unsafe)localObject).getObject(paramT, l), paramzzjl, false);
                                              break;
                                              if ((i5 & i4) != 0)
                                              {
                                                paramzzjl.zzs(i1, ((Unsafe)localObject).getObject(paramT, l), zzv(j));
                                                break;
                                                if ((i5 & i4) != 0)
                                                {
                                                  paramzzjl.zzq(i1, ((Unsafe)localObject).getLong(paramT, l));
                                                  break;
                                                  if ((i5 & i4) != 0)
                                                  {
                                                    paramzzjl.zzp(i1, ((Unsafe)localObject).getInt(paramT, l));
                                                    break;
                                                    if ((i5 & i4) != 0)
                                                    {
                                                      paramzzjl.zzd(i1, ((Unsafe)localObject).getLong(paramT, l));
                                                      break;
                                                      if ((i5 & i4) != 0)
                                                      {
                                                        paramzzjl.zzb(i1, ((Unsafe)localObject).getInt(paramT, l));
                                                        break;
                                                        if ((i5 & i4) != 0)
                                                        {
                                                          paramzzjl.zzg(i1, ((Unsafe)localObject).getInt(paramT, l));
                                                          break;
                                                          if ((i5 & i4) != 0)
                                                          {
                                                            paramzzjl.zzo(i1, ((Unsafe)localObject).getInt(paramT, l));
                                                            break;
                                                            if ((i5 & i4) != 0)
                                                            {
                                                              paramzzjl.zzn(i1, (zzjd)((Unsafe)localObject).getObject(paramT, l));
                                                              break;
                                                              if ((i5 & i4) != 0)
                                                              {
                                                                paramzzjl.zzr(i1, ((Unsafe)localObject).getObject(paramT, l), zzv(j));
                                                                break;
                                                                if ((i5 & i4) != 0)
                                                                {
                                                                  zzT(i1, ((Unsafe)localObject).getObject(paramT, l), paramzzjl);
                                                                  break;
                                                                  if ((i5 & i4) != 0)
                                                                  {
                                                                    paramzzjl.zzl(i1, zzmr.zzh(paramT, l));
                                                                    break;
                                                                    if ((i5 & i4) != 0)
                                                                    {
                                                                      paramzzjl.zzk(i1, ((Unsafe)localObject).getInt(paramT, l));
                                                                      break;
                                                                      if ((i5 & i4) != 0)
                                                                      {
                                                                        paramzzjl.zzj(i1, ((Unsafe)localObject).getLong(paramT, l));
                                                                        break;
                                                                        if ((i5 & i4) != 0)
                                                                        {
                                                                          paramzzjl.zzi(i1, ((Unsafe)localObject).getInt(paramT, l));
                                                                          break;
                                                                          if ((i5 & i4) != 0)
                                                                          {
                                                                            paramzzjl.zzh(i1, ((Unsafe)localObject).getLong(paramT, l));
                                                                            break;
                                                                            if ((i5 & i4) != 0)
                                                                            {
                                                                              paramzzjl.zzc(i1, ((Unsafe)localObject).getLong(paramT, l));
                                                                              break;
                                                                              if ((i5 & i4) != 0)
                                                                              {
                                                                                paramzzjl.zze(i1, zzmr.zzj(paramT, l));
                                                                                break;
                                                                                if ((i5 & i4) != 0) {
                                                                                  paramzzjl.zzf(i1, zzmr.zzl(paramT, l));
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
        k = i5;
      }
      localObject = this.zzn;
      ((zzmh)localObject).zzi(((zzmh)localObject).zzd(paramT), paramzzjl);
      return;
    }
    this.zzo.zzb(paramT);
    throw null;
  }
  
  private final <K, V> void zzS(zzjl paramzzjl, int paramInt1, Object paramObject, int paramInt2)
    throws IOException
  {
    if (paramObject == null) {
      return;
    }
    paramzzjl = (zzlb)zzw(paramInt2);
    throw null;
  }
  
  private static final void zzT(int paramInt, Object paramObject, zzjl paramzzjl)
    throws IOException
  {
    if ((paramObject instanceof String))
    {
      paramzzjl.zzm(paramInt, (String)paramObject);
      return;
    }
    paramzzjl.zzn(paramInt, (zzjd)paramObject);
  }
  
  static zzmi zzf(Object paramObject)
  {
    zzkd localzzkd = (zzkd)paramObject;
    zzmi localzzmi = localzzkd.zzc;
    paramObject = localzzmi;
    if (localzzmi == zzmi.zza())
    {
      paramObject = zzmi.zzb();
      localzzkd.zzc = ((zzmi)paramObject);
    }
    return (zzmi)paramObject;
  }
  
  static <T> zzll<T> zzk(Class<T> paramClass, zzlf paramzzlf, zzln paramzzln, zzkw paramzzkw, zzmh<?, ?> paramzzmh, zzjq<?> paramzzjq, zzld paramzzld)
  {
    if ((paramzzlf instanceof zzls)) {
      return zzl((zzls)paramzzlf, paramzzln, paramzzkw, paramzzmh, paramzzjq, paramzzld);
    }
    paramClass = (zzme)paramzzlf;
    throw null;
  }
  
  static <T> zzll<T> zzl(zzls paramzzls, zzln paramzzln, zzkw paramzzkw, zzmh<?, ?> paramzzmh, zzjq<?> paramzzjq, zzld paramzzld)
  {
    boolean bool;
    if (paramzzls.zzc() == 2) {
      bool = true;
    } else {
      bool = false;
    }
    String str = paramzzls.zzd();
    int i = str.length();
    if (str.charAt(0) >= 55296) {
      for (j = 1;; j = k)
      {
        k = j + 1;
        m = k;
        if (str.charAt(j) < 55296) {
          break;
        }
      }
    }
    int m = 1;
    int k = m + 1;
    int n = str.charAt(m);
    int j = k;
    m = n;
    if (n >= 55296)
    {
      j = n & 0x1FFF;
      m = 13;
      for (n = k;; n = k)
      {
        k = n + 1;
        n = str.charAt(n);
        if (n < 55296) {
          break;
        }
        j |= (n & 0x1FFF) << m;
        m += 13;
      }
      m = j | n << m;
      j = k;
    }
    int[] arrayOfInt1;
    int i1;
    int i4;
    int i5;
    if (m == 0)
    {
      arrayOfInt1 = zza;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      n = 0;
      i4 = 0;
      m = 0;
      i5 = 0;
    }
    else
    {
      n = j + 1;
      m = str.charAt(j);
      k = m;
      j = n;
      if (m >= 55296)
      {
        j = m & 0x1FFF;
        m = 13;
        for (;;)
        {
          k = n + 1;
          n = str.charAt(n);
          if (n < 55296) {
            break;
          }
          j |= (n & 0x1FFF) << m;
          m += 13;
          n = k;
        }
        m = j | n << m;
        j = k;
        k = m;
      }
      m = j + 1;
      n = str.charAt(j);
      i3 = n;
      j = m;
      if (n >= 55296)
      {
        n &= 0x1FFF;
        j = 13;
        for (i5 = m;; i5 = m)
        {
          m = i5 + 1;
          i5 = str.charAt(i5);
          if (i5 < 55296) {
            break;
          }
          n |= (i5 & 0x1FFF) << j;
          j += 13;
        }
        i3 = n | i5 << j;
        j = m;
      }
      n = j + 1;
      i5 = str.charAt(j);
      j = i5;
      m = n;
      if (i5 >= 55296)
      {
        j = i5 & 0x1FFF;
        m = 13;
        i5 = n;
        n = j;
        for (;;)
        {
          j = i5 + 1;
          i5 = str.charAt(i5);
          if (i5 < 55296) {
            break;
          }
          n |= (i5 & 0x1FFF) << m;
          m += 13;
          i5 = j;
        }
        n |= i5 << m;
        m = j;
        j = n;
      }
      i5 = m + 1;
      i2 = str.charAt(m);
      m = i2;
      n = i5;
      if (i2 >= 55296)
      {
        m = i2 & 0x1FFF;
        n = 13;
        i2 = i5;
        i5 = m;
        for (;;)
        {
          m = i2 + 1;
          i2 = str.charAt(i2);
          if (i2 < 55296) {
            break;
          }
          i5 |= (i2 & 0x1FFF) << n;
          n += 13;
          i2 = m;
        }
        i5 |= i2 << n;
        n = m;
        m = i5;
      }
      i5 = n + 1;
      i2 = str.charAt(n);
      n = i2;
      i4 = i5;
      if (i2 >= 55296)
      {
        i2 &= 0x1FFF;
        n = 13;
        for (i4 = i5;; i4 = i5)
        {
          i5 = i4 + 1;
          i4 = str.charAt(i4);
          if (i4 < 55296) {
            break;
          }
          i2 |= (i4 & 0x1FFF) << n;
          n += 13;
        }
        n = i2 | i4 << n;
        i4 = i5;
      }
      i2 = i4 + 1;
      i1 = str.charAt(i4);
      i5 = i1;
      i4 = i2;
      if (i1 >= 55296)
      {
        i4 = i1 & 0x1FFF;
        i5 = 13;
        for (i1 = i2;; i1 = i2)
        {
          i2 = i1 + 1;
          i1 = str.charAt(i1);
          if (i1 < 55296) {
            break;
          }
          i4 |= (i1 & 0x1FFF) << i5;
          i5 += 13;
        }
        i5 = i4 | i1 << i5;
        i4 = i2;
      }
      i2 = i4 + 1;
      i6 = str.charAt(i4);
      i1 = i6;
      i4 = i2;
      if (i6 >= 55296)
      {
        i1 = i6 & 0x1FFF;
        i4 = 13;
        for (i6 = i2;; i6 = i2)
        {
          i2 = i6 + 1;
          i6 = str.charAt(i6);
          if (i6 < 55296) {
            break;
          }
          i1 |= (i6 & 0x1FFF) << i4;
          i4 += 13;
        }
        i1 |= i6 << i4;
        i4 = i2;
      }
      i6 = i4 + 1;
      i7 = str.charAt(i4);
      i2 = i7;
      i4 = i6;
      if (i7 >= 55296)
      {
        i2 = i7 & 0x1FFF;
        i4 = 13;
        i7 = i6;
        i6 = i2;
        for (;;)
        {
          i2 = i7 + 1;
          i7 = str.charAt(i7);
          if (i7 < 55296) {
            break;
          }
          i6 |= (i7 & 0x1FFF) << i4;
          i4 += 13;
          i7 = i2;
        }
        i6 |= i7 << i4;
        i4 = i2;
        i2 = i6;
      }
      arrayOfInt1 = new int[i2 + i5 + i1];
      i6 = k + k + i3;
      i1 = k;
      k = i4;
      i4 = m;
      i3 = i5;
      i5 = i6;
      m = i2;
      i2 = j;
      j = k;
    }
    Unsafe localUnsafe = zzb;
    Object[] arrayOfObject1 = paramzzls.zze();
    Class localClass = paramzzls.zzb().getClass();
    int[] arrayOfInt2 = new int[n * 3];
    Object[] arrayOfObject2 = new Object[n + n];
    int i8 = m + i3;
    k = m;
    n = i8;
    int i9 = 0;
    int i3 = 0;
    int i6 = m;
    m = i4;
    int i7 = i2;
    int i2 = j;
    j = i;
    while (i2 < j)
    {
      int i10 = i2 + 1;
      i = str.charAt(i2);
      if (i >= 55296)
      {
        i &= 0x1FFF;
        i2 = 13;
        for (;;)
        {
          i4 = i10 + 1;
          i10 = str.charAt(i10);
          if (i10 < 55296) {
            break;
          }
          i |= (i10 & 0x1FFF) << i2;
          i2 += 13;
          i10 = i4;
        }
        i |= i10 << i2;
      }
      else
      {
        i4 = i10;
      }
      i2 = i4 + 1;
      int i11 = str.charAt(i4);
      if (i11 >= 55296)
      {
        i10 = i11 & 0x1FFF;
        i11 = i2;
        i2 = 13;
        for (;;)
        {
          i4 = i11 + 1;
          i11 = str.charAt(i11);
          if (i11 < 55296) {
            break;
          }
          i10 |= (i11 & 0x1FFF) << i2;
          i2 += 13;
          i11 = i4;
        }
        i11 = i10 | i11 << i2;
        i2 = i4;
      }
      int i12 = i11 & 0xFF;
      i10 = i3;
      if ((i11 & 0x400) != 0)
      {
        arrayOfInt1[i3] = i9;
        i10 = i3 + 1;
      }
      int i13;
      label1723:
      Object localObject;
      int i14;
      int i15;
      if (i12 >= 51)
      {
        i4 = i2 + 1;
        i3 = str.charAt(i2);
        if (i3 >= 55296)
        {
          i3 &= 0x1FFF;
          i2 = 13;
          i13 = i4;
          i4 = i3;
          for (;;)
          {
            i3 = i13 + 1;
            i13 = str.charAt(i13);
            if (i13 < 55296) {
              break;
            }
            i4 |= (i13 & 0x1FFF) << i2;
            i2 += 13;
            i13 = i3;
          }
          i4 |= i13 << i2;
          i2 = i3;
          i3 = i4;
        }
        else
        {
          i2 = i4;
        }
        i13 = i12 - 51;
        i4 = i2;
        if ((i13 != 9) && (i13 != 17))
        {
          i2 = i5;
          if (i13 != 12) {
            break label1723;
          }
          i2 = i5;
          if (bool) {
            break label1723;
          }
          i13 = i9 / 3;
          i2 = i5 + 1;
          arrayOfObject2[(i13 + i13 + 1)] = arrayOfObject1[i5];
          i5 = i2;
        }
        else
        {
          i13 = i9 / 3;
          i2 = i5 + 1;
          arrayOfObject2[(i13 + i13 + 1)] = arrayOfObject1[i5];
          i5 = i2;
        }
        i2 = i5;
        i5 = i3 + i3;
        localObject = arrayOfObject1[i5];
        if ((localObject instanceof Field))
        {
          localObject = (Field)localObject;
        }
        else
        {
          localObject = zzn(localClass, (String)localObject);
          arrayOfObject1[i5] = localObject;
        }
        i14 = (int)localUnsafe.objectFieldOffset((Field)localObject);
        i5++;
        localObject = arrayOfObject1[i5];
        if ((localObject instanceof Field))
        {
          localObject = (Field)localObject;
        }
        else
        {
          localObject = zzn(localClass, (String)localObject);
          arrayOfObject1[i5] = localObject;
        }
        i3 = (int)localUnsafe.objectFieldOffset((Field)localObject);
        i15 = 0;
        i5 = i2;
        i13 = n;
        n = i4;
      }
      else
      {
        i13 = m;
        i4 = i5 + 1;
        localObject = zzn(localClass, (String)arrayOfObject1[i5]);
        if ((i12 != 9) && (i12 != 17))
        {
          if ((i12 != 27) && (i12 != 49))
          {
            if ((i12 != 12) && (i12 != 30) && (i12 != 44))
            {
              i5 = i4;
              m = k;
              if (i12 == 50)
              {
                m = k + 1;
                arrayOfInt1[k] = i9;
                k = i9 / 3;
                i3 = k + k;
                i5 = i4 + 1;
                arrayOfObject2[i3] = arrayOfObject1[i4];
                if ((i11 & 0x800) == 0) {
                  break label2037;
                }
                k = i5 + 1;
                arrayOfObject2[(i3 + 1)] = arrayOfObject1[i5];
                i5 = k;
              }
            }
            label2037:
            do
            {
              k = m;
              break;
              k = m;
              m = i5;
              break label2150;
              i5 = i4;
              m = k;
            } while (bool);
            i5 = i9 / 3;
            m = i4 + 1;
            arrayOfObject2[(i5 + i5 + 1)] = arrayOfObject1[i4];
          }
          else
          {
            i5 = i9 / 3;
            m = i4 + 1;
            arrayOfObject2[(i5 + i5 + 1)] = arrayOfObject1[i4];
          }
        }
        else
        {
          m = i9 / 3;
          arrayOfObject2[(m + m + 1)] = ((Field)localObject).getType();
          i5 = i4;
          m = i5;
        }
        label2150:
        i14 = (int)localUnsafe.objectFieldOffset((Field)localObject);
        if (((i11 & 0x1000) == 4096) && (i12 <= 17))
        {
          i5 = i2 + 1;
          i2 = str.charAt(i2);
          if (i2 >= 55296)
          {
            i4 = i2 & 0x1FFF;
            i2 = 13;
            for (i3 = i5;; i3 = i5)
            {
              i5 = i3 + 1;
              i3 = str.charAt(i3);
              if (i3 < 55296) {
                break;
              }
              i4 |= (i3 & 0x1FFF) << i2;
              i2 += 13;
            }
            i2 = i4 | i3 << i2;
          }
          i4 = i1 + i1 + i2 / 32;
          localObject = arrayOfObject1[i4];
          if ((localObject instanceof Field))
          {
            localObject = (Field)localObject;
          }
          else
          {
            localObject = zzn(localClass, (String)localObject);
            arrayOfObject1[i4] = localObject;
          }
          i3 = (int)localUnsafe.objectFieldOffset((Field)localObject);
          i4 = i2 % 32;
          i2 = i3;
        }
        else
        {
          i5 = i2;
          i2 = 1048575;
          i4 = 0;
        }
        i3 = n;
        if (i12 >= 18)
        {
          i3 = n;
          if (i12 <= 49)
          {
            arrayOfInt1[n] = i14;
            i3 = n + 1;
          }
        }
        i15 = m;
        m = i13;
        n = i5;
        i13 = i3;
        i5 = i15;
        i15 = i4;
        i3 = i2;
      }
      int i16 = i9 + 1;
      arrayOfInt2[i9] = i;
      i = i16 + 1;
      if ((i11 & 0x200) != 0) {
        i2 = 536870912;
      } else {
        i2 = 0;
      }
      if ((i11 & 0x100) != 0) {
        i4 = 268435456;
      } else {
        i4 = 0;
      }
      arrayOfInt2[i16] = (i4 | i2 | i12 << 20 | i14);
      i9 = i + 1;
      arrayOfInt2[i] = (i15 << 20 | i3);
      i2 = n;
      i3 = i10;
      n = i13;
    }
    return new zzll(arrayOfInt2, arrayOfObject2, i7, m, paramzzls.zzb(), bool, false, arrayOfInt1, i6, i8, paramzzln, paramzzkw, paramzzmh, paramzzjq, paramzzld, null);
  }
  
  private static Field zzn(Class<?> paramClass, String paramString)
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
  
  private final void zzo(T paramT1, T paramT2, int paramInt)
  {
    long l = zzA(paramInt) & 0xFFFFF;
    if (!zzK(paramT2, paramInt)) {
      return;
    }
    Object localObject = zzmr.zzn(paramT1, l);
    paramT2 = zzmr.zzn(paramT2, l);
    if ((localObject != null) && (paramT2 != null))
    {
      zzmr.zzo(paramT1, l, zzkl.zzi(localObject, paramT2));
      zzL(paramT1, paramInt);
      return;
    }
    if (paramT2 != null)
    {
      zzmr.zzo(paramT1, l, paramT2);
      zzL(paramT1, paramInt);
    }
  }
  
  private final void zzp(T paramT1, T paramT2, int paramInt)
  {
    int i = zzA(paramInt);
    int j = this.zzc[paramInt];
    long l = i & 0xFFFFF;
    if (!zzM(paramT2, j, paramInt)) {
      return;
    }
    Object localObject;
    if (zzM(paramT1, j, paramInt)) {
      localObject = zzmr.zzn(paramT1, l);
    } else {
      localObject = null;
    }
    paramT2 = zzmr.zzn(paramT2, l);
    if ((localObject != null) && (paramT2 != null))
    {
      zzmr.zzo(paramT1, l, zzkl.zzi(localObject, paramT2));
      zzN(paramT1, j, paramInt);
      return;
    }
    if (paramT2 != null)
    {
      zzmr.zzo(paramT1, l, paramT2);
      zzN(paramT1, j, paramInt);
    }
  }
  
  private final int zzq(T paramT)
  {
    Object localObject1 = zzb;
    int i = 0;
    int j = 0;
    int k = 0;
    int i6;
    for (int m = 1048575; i < this.zzc.length; m = i6)
    {
      int n = zzA(i);
      int i1 = this.zzc[i];
      int i2 = zzC(n);
      int i3;
      int i4;
      int i5;
      if (i2 <= 17)
      {
        i3 = this.zzc[(i + 2)];
        i4 = i3 & 0xFFFFF;
        i5 = 1 << (i3 >>> 20);
        i6 = m;
        i3 = i5;
        if (i4 != m)
        {
          k = ((Unsafe)localObject1).getInt(paramT, i4);
          i6 = i4;
          i3 = i5;
        }
      }
      else
      {
        i3 = 0;
        i6 = m;
      }
      long l = n & 0xFFFFF;
      Object localObject2;
      switch (i2)
      {
      default: 
        m = j;
        break;
      case 68: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        m = zzjk.zzE(i1, (zzli)((Unsafe)localObject1).getObject(paramT, l), zzv(i));
        break;
      case 67: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        l = zzG(paramT, l);
        i3 = zzjk.zzw(i1 << 3);
        m = zzjk.zzx(l >> 63 ^ l + l);
        break;
      case 66: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        m = zzF(paramT, l);
        i3 = zzjk.zzw(i1 << 3);
        m = zzjk.zzw(m >> 31 ^ m + m);
        break;
      case 65: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        m = zzjk.zzw(i1 << 3);
        break;
      case 64: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        m = zzjk.zzw(i1 << 3);
        break;
      case 63: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        m = zzF(paramT, l);
        i3 = zzjk.zzw(i1 << 3);
        m = zzjk.zzv(m);
        break;
      case 62: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        m = zzF(paramT, l);
        i3 = zzjk.zzw(i1 << 3);
        m = zzjk.zzw(m);
        break;
      case 61: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        localObject2 = (zzjd)((Unsafe)localObject1).getObject(paramT, l);
        i3 = zzjk.zzw(i1 << 3);
        m = ((zzjd)localObject2).zzc();
        i5 = zzjk.zzw(m);
        break;
      case 60: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        m = zzlv.zzw(i1, ((Unsafe)localObject1).getObject(paramT, l), zzv(i));
        break;
      case 59: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        localObject2 = ((Unsafe)localObject1).getObject(paramT, l);
        if ((localObject2 instanceof zzjd))
        {
          localObject2 = (zzjd)localObject2;
          i3 = zzjk.zzw(i1 << 3);
          m = ((zzjd)localObject2).zzc();
          i5 = zzjk.zzw(m);
        }
        else
        {
          localObject2 = (String)localObject2;
          i3 = zzjk.zzw(i1 << 3);
          m = zzjk.zzy((String)localObject2);
        }
        break;
      case 58: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        m = zzjk.zzw(i1 << 3);
        break;
      case 57: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        m = zzjk.zzw(i1 << 3);
        break;
      case 56: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        m = zzjk.zzw(i1 << 3);
        break;
      case 55: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        m = zzF(paramT, l);
        i3 = zzjk.zzw(i1 << 3);
        m = zzjk.zzv(m);
        break;
      case 54: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        l = zzG(paramT, l);
        m = zzjk.zzw(i1 << 3);
        i3 = zzjk.zzx(l);
        break;
      case 53: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        l = zzG(paramT, l);
        m = zzjk.zzw(i1 << 3);
        i3 = zzjk.zzx(l);
        break;
      case 52: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        m = zzjk.zzw(i1 << 3);
        break;
      case 51: 
        m = j;
        if (!zzM(paramT, i1, i)) {
          break label2973;
        }
        m = zzjk.zzw(i1 << 3);
        break;
      case 50: 
        zzld.zza(i1, ((Unsafe)localObject1).getObject(paramT, l), zzw(i));
        m = j;
        break;
      case 49: 
        m = zzlv.zzz(i1, (List)((Unsafe)localObject1).getObject(paramT, l), zzv(i));
        break;
      case 48: 
        i3 = zzlv.zzf((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i3 <= 0) {
          break label2973;
        }
        i4 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i3);
        m = i3;
        i3 = i4;
        break;
      case 47: 
        i3 = zzlv.zzn((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i3 <= 0) {
          break label2973;
        }
        i4 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i3);
        m = i3;
        i3 = i4;
        break;
      case 46: 
        i3 = zzlv.zzr((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i3 <= 0) {
          break label2973;
        }
        i4 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i3);
        m = i3;
        i3 = i4;
        break;
      case 45: 
        i3 = zzlv.zzp((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i3 <= 0) {
          break label2973;
        }
        i4 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i3);
        m = i3;
        i3 = i4;
        break;
      case 44: 
        i3 = zzlv.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i3 <= 0) {
          break label2973;
        }
        i4 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i3);
        m = i3;
        i3 = i4;
        break;
      case 43: 
        i3 = zzlv.zzl((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i3 <= 0) {
          break label2973;
        }
        i4 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i3);
        m = i3;
        i3 = i4;
        break;
      case 42: 
        i3 = zzlv.zzt((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i3 <= 0) {
          break label2973;
        }
        i4 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i3);
        m = i3;
        i3 = i4;
        break;
      case 41: 
        i3 = zzlv.zzp((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i3 <= 0) {
          break label2973;
        }
        i4 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i3);
        m = i3;
        i3 = i4;
        break;
      case 40: 
        i3 = zzlv.zzr((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i3 <= 0) {
          break label2973;
        }
        i4 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i3);
        m = i3;
        i3 = i4;
        break;
      case 39: 
        i3 = zzlv.zzj((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i3 <= 0) {
          break label2973;
        }
        i4 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i3);
        m = i3;
        i3 = i4;
        break;
      case 38: 
        i3 = zzlv.zzd((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i3 <= 0) {
          break label2973;
        }
        i4 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i3);
        m = i3;
        i3 = i4;
        break;
      case 37: 
        i3 = zzlv.zzb((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i3 <= 0) {
          break label2973;
        }
        i4 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i3);
        m = i3;
        i3 = i4;
        break;
      case 36: 
        i3 = zzlv.zzp((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i3 <= 0) {
          break label2973;
        }
        i4 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i3);
        m = i3;
        i3 = i4;
        break;
      case 35: 
        i4 = zzlv.zzr((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i4 <= 0) {
          break label2973;
        }
        i3 = zzjk.zzu(i1);
        i5 = zzjk.zzw(i4);
        m = i4;
        i3 += i5;
        break;
      case 34: 
        m = zzlv.zzg(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 33: 
        m = zzlv.zzo(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 32: 
        m = zzlv.zzs(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 31: 
        m = zzlv.zzq(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 30: 
        m = zzlv.zzi(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 29: 
        m = zzlv.zzm(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 28: 
        m = zzlv.zzy(i1, (List)((Unsafe)localObject1).getObject(paramT, l));
        break;
      case 27: 
        m = zzlv.zzx(i1, (List)((Unsafe)localObject1).getObject(paramT, l), zzv(i));
        break;
      case 26: 
        m = zzlv.zzv(i1, (List)((Unsafe)localObject1).getObject(paramT, l));
        break;
      case 25: 
        m = zzlv.zzu(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 24: 
        m = zzlv.zzq(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 23: 
        m = zzlv.zzs(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 22: 
        m = zzlv.zzk(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 21: 
        m = zzlv.zze(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 20: 
        m = zzlv.zzc(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 19: 
        m = zzlv.zzq(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 18: 
        m = zzlv.zzs(i1, (List)((Unsafe)localObject1).getObject(paramT, l), false);
      }
      for (;;)
      {
        m = j + m;
        break;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        m = zzjk.zzE(i1, (zzli)((Unsafe)localObject1).getObject(paramT, l), zzv(i));
        continue;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        l = ((Unsafe)localObject1).getLong(paramT, l);
        i3 = zzjk.zzw(i1 << 3);
        m = zzjk.zzx(l >> 63 ^ l + l);
        break label2815;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        m = ((Unsafe)localObject1).getInt(paramT, l);
        i3 = zzjk.zzw(i1 << 3);
        m = zzjk.zzw(m >> 31 ^ m + m);
        break label2815;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        m = zzjk.zzw(i1 << 3);
        break label2967;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        m = zzjk.zzw(i1 << 3);
        break label2940;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        m = ((Unsafe)localObject1).getInt(paramT, l);
        i3 = zzjk.zzw(i1 << 3);
        m = zzjk.zzv(m);
        break label2815;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        m = ((Unsafe)localObject1).getInt(paramT, l);
        i3 = zzjk.zzw(i1 << 3);
        m = zzjk.zzw(m);
        break label2815;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        localObject2 = (zzjd)((Unsafe)localObject1).getObject(paramT, l);
        i3 = zzjk.zzw(i1 << 3);
        m = ((zzjd)localObject2).zzc();
        for (i5 = zzjk.zzw(m);; i5 = zzjk.zzw(m))
        {
          m = i3 + (i5 + m);
          break label2822;
          m = j;
          if ((k & i3) == 0) {
            break label2973;
          }
          m = zzlv.zzw(i1, ((Unsafe)localObject1).getObject(paramT, l), zzv(i));
          break;
          m = j;
          if ((k & i3) == 0) {
            break label2973;
          }
          localObject2 = ((Unsafe)localObject1).getObject(paramT, l);
          if (!(localObject2 instanceof zzjd)) {
            break label2677;
          }
          localObject2 = (zzjd)localObject2;
          i3 = zzjk.zzw(i1 << 3);
          m = ((zzjd)localObject2).zzc();
        }
        label2677:
        localObject2 = (String)localObject2;
        i3 = zzjk.zzw(i1 << 3);
        m = zzjk.zzy((String)localObject2);
        break label2815;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        m = zzjk.zzw(i1 << 3);
        m++;
        continue;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        m = zzjk.zzw(i1 << 3);
        break label2940;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        m = zzjk.zzw(i1 << 3);
        break label2967;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        m = ((Unsafe)localObject1).getInt(paramT, l);
        i3 = zzjk.zzw(i1 << 3);
        m = zzjk.zzv(m);
        label2815:
        m = i3 + m;
        label2822:
        m = j + m;
        break;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        l = ((Unsafe)localObject1).getLong(paramT, l);
        m = zzjk.zzw(i1 << 3);
        i3 = zzjk.zzx(l);
        break label2909;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        l = ((Unsafe)localObject1).getLong(paramT, l);
        m = zzjk.zzw(i1 << 3);
        i3 = zzjk.zzx(l);
        label2909:
        m += i3;
        continue;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        m = zzjk.zzw(i1 << 3);
        label2940:
        m += 4;
        continue;
        m = j;
        if ((k & i3) == 0) {
          break;
        }
        m = zzjk.zzw(i1 << 3);
        label2967:
        m += 8;
      }
      label2973:
      i += 3;
      j = m;
    }
    localObject1 = this.zzn;
    m = ((zzmh)localObject1).zzh(((zzmh)localObject1).zzd(paramT));
    if (!this.zzh) {
      return j + m;
    }
    this.zzo.zzb(paramT);
    throw null;
  }
  
  private final int zzr(T paramT)
  {
    Object localObject1 = zzb;
    int i = 0;
    int m;
    for (int j = 0; i < this.zzc.length; j = m)
    {
      int k = zzA(i);
      m = zzC(k);
      int n = this.zzc[i];
      long l = k & 0xFFFFF;
      if ((m >= zzjv.zzJ.zza()) && (m <= zzjv.zzW.zza())) {
        k = this.zzc[(i + 2)];
      }
      Object localObject2;
      int i1;
      switch (m)
      {
      default: 
        m = j;
        break;
      case 68: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        m = zzjk.zzE(n, (zzli)zzmr.zzn(paramT, l), zzv(i));
        break;
      case 67: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        l = zzG(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzx(l >> 63 ^ l + l);
        break;
      case 66: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        m = zzF(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzw(m >> 31 ^ m + m);
        break;
      case 65: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        m = zzjk.zzw(n << 3);
        break;
      case 64: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        m = zzjk.zzw(n << 3);
        break;
      case 63: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        m = zzF(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzv(m);
        break;
      case 62: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        m = zzF(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzw(m);
        break;
      case 61: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        localObject2 = (zzjd)zzmr.zzn(paramT, l);
        k = zzjk.zzw(n << 3);
        m = ((zzjd)localObject2).zzc();
        n = zzjk.zzw(m);
        break;
      case 60: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        m = zzlv.zzw(n, zzmr.zzn(paramT, l), zzv(i));
        break;
      case 59: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        localObject2 = zzmr.zzn(paramT, l);
        if ((localObject2 instanceof zzjd))
        {
          localObject2 = (zzjd)localObject2;
          k = zzjk.zzw(n << 3);
          m = ((zzjd)localObject2).zzc();
          n = zzjk.zzw(m);
        }
        else
        {
          localObject2 = (String)localObject2;
          k = zzjk.zzw(n << 3);
          m = zzjk.zzy((String)localObject2);
        }
        break;
      case 58: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        m = zzjk.zzw(n << 3);
        break;
      case 57: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        m = zzjk.zzw(n << 3);
        break;
      case 56: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        m = zzjk.zzw(n << 3);
        break;
      case 55: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        m = zzF(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzv(m);
        break;
      case 54: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        l = zzG(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzx(l);
        break;
      case 53: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        l = zzG(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzx(l);
        break;
      case 52: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        m = zzjk.zzw(n << 3);
        break;
      case 51: 
        m = j;
        if (!zzM(paramT, n, i)) {
          break label2908;
        }
        m = zzjk.zzw(n << 3);
        break;
      case 50: 
        zzld.zza(n, zzmr.zzn(paramT, l), zzw(i));
        m = j;
        break;
      case 49: 
        m = zzlv.zzz(n, (List)zzmr.zzn(paramT, l), zzv(i));
        break;
      case 48: 
        k = zzlv.zzf((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (k <= 0) {
          break label2908;
        }
        i1 = zzjk.zzu(n);
        n = zzjk.zzw(k);
        m = k;
        k = i1;
        break;
      case 47: 
        k = zzlv.zzn((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (k <= 0) {
          break label2908;
        }
        i1 = zzjk.zzu(n);
        n = zzjk.zzw(k);
        m = k;
        k = i1;
        break;
      case 46: 
        k = zzlv.zzr((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (k <= 0) {
          break label2908;
        }
        i1 = zzjk.zzu(n);
        n = zzjk.zzw(k);
        m = k;
        k = i1;
        break;
      case 45: 
        k = zzlv.zzp((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (k <= 0) {
          break label2908;
        }
        i1 = zzjk.zzu(n);
        n = zzjk.zzw(k);
        m = k;
        k = i1;
        break;
      case 44: 
        k = zzlv.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (k <= 0) {
          break label2908;
        }
        i1 = zzjk.zzu(n);
        n = zzjk.zzw(k);
        m = k;
        k = i1;
        break;
      case 43: 
        k = zzlv.zzl((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (k <= 0) {
          break label2908;
        }
        i1 = zzjk.zzu(n);
        n = zzjk.zzw(k);
        m = k;
        k = i1;
        break;
      case 42: 
        k = zzlv.zzt((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (k <= 0) {
          break label2908;
        }
        i1 = zzjk.zzu(n);
        n = zzjk.zzw(k);
        m = k;
        k = i1;
        break;
      case 41: 
        k = zzlv.zzp((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (k <= 0) {
          break label2908;
        }
        i1 = zzjk.zzu(n);
        n = zzjk.zzw(k);
        m = k;
        k = i1;
        break;
      case 40: 
        k = zzlv.zzr((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (k <= 0) {
          break label2908;
        }
        i1 = zzjk.zzu(n);
        n = zzjk.zzw(k);
        m = k;
        k = i1;
        break;
      case 39: 
        k = zzlv.zzj((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (k <= 0) {
          break label2908;
        }
        i1 = zzjk.zzu(n);
        n = zzjk.zzw(k);
        m = k;
        k = i1;
        break;
      case 38: 
        k = zzlv.zzd((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (k <= 0) {
          break label2908;
        }
        i1 = zzjk.zzu(n);
        n = zzjk.zzw(k);
        m = k;
        k = i1;
        break;
      case 37: 
        k = zzlv.zzb((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (k <= 0) {
          break label2908;
        }
        i1 = zzjk.zzu(n);
        n = zzjk.zzw(k);
        m = k;
        k = i1;
        break;
      case 36: 
        k = zzlv.zzp((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (k <= 0) {
          break label2908;
        }
        i1 = zzjk.zzu(n);
        n = zzjk.zzw(k);
        m = k;
        k = i1;
        break;
      case 35: 
        i1 = zzlv.zzr((List)((Unsafe)localObject1).getObject(paramT, l));
        m = j;
        if (i1 <= 0) {
          break label2908;
        }
        k = zzjk.zzu(n);
        n = zzjk.zzw(i1);
        m = i1;
        k += n;
        break;
      case 34: 
        m = zzlv.zzg(n, (List)zzmr.zzn(paramT, l), false);
        break;
      case 33: 
        m = zzlv.zzo(n, (List)zzmr.zzn(paramT, l), false);
        break;
      case 32: 
        m = zzlv.zzs(n, (List)zzmr.zzn(paramT, l), false);
        break;
      case 31: 
        m = zzlv.zzq(n, (List)zzmr.zzn(paramT, l), false);
        break;
      case 30: 
        m = zzlv.zzi(n, (List)zzmr.zzn(paramT, l), false);
        break;
      case 29: 
        m = zzlv.zzm(n, (List)zzmr.zzn(paramT, l), false);
        break;
      case 28: 
        m = zzlv.zzy(n, (List)zzmr.zzn(paramT, l));
        break;
      case 27: 
        m = zzlv.zzx(n, (List)zzmr.zzn(paramT, l), zzv(i));
        break;
      case 26: 
        m = zzlv.zzv(n, (List)zzmr.zzn(paramT, l));
        break;
      case 25: 
        m = zzlv.zzu(n, (List)zzmr.zzn(paramT, l), false);
        break;
      case 24: 
        m = zzlv.zzq(n, (List)zzmr.zzn(paramT, l), false);
        break;
      case 23: 
        m = zzlv.zzs(n, (List)zzmr.zzn(paramT, l), false);
        break;
      case 22: 
        m = zzlv.zzk(n, (List)zzmr.zzn(paramT, l), false);
        break;
      case 21: 
        m = zzlv.zze(n, (List)zzmr.zzn(paramT, l), false);
        break;
      case 20: 
        m = zzlv.zzc(n, (List)zzmr.zzn(paramT, l), false);
        break;
      case 19: 
        m = zzlv.zzq(n, (List)zzmr.zzn(paramT, l), false);
        break;
      case 18: 
        m = zzlv.zzs(n, (List)zzmr.zzn(paramT, l), false);
      }
      for (;;)
      {
        m = j + m;
        break;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        m = zzjk.zzE(n, (zzli)zzmr.zzn(paramT, l), zzv(i));
        continue;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        l = zzmr.zzf(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzx(l >> 63 ^ l + l);
        break label2745;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        m = zzmr.zzd(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzw(m >> 31 ^ m + m);
        break label2745;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        m = zzjk.zzw(n << 3);
        break label2902;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        m = zzjk.zzw(n << 3);
        break label2874;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        m = zzmr.zzd(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzv(m);
        break label2745;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        m = zzmr.zzd(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzw(m);
        break label2745;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        localObject2 = (zzjd)zzmr.zzn(paramT, l);
        k = zzjk.zzw(n << 3);
        m = ((zzjd)localObject2).zzc();
        for (n = zzjk.zzw(m);; n = zzjk.zzw(m))
        {
          m = k + (n + m);
          break label2752;
          m = j;
          if (!zzK(paramT, i)) {
            break label2908;
          }
          m = zzlv.zzw(n, zzmr.zzn(paramT, l), zzv(i));
          break;
          m = j;
          if (!zzK(paramT, i)) {
            break label2908;
          }
          localObject2 = zzmr.zzn(paramT, l);
          if (!(localObject2 instanceof zzjd)) {
            break label2604;
          }
          localObject2 = (zzjd)localObject2;
          k = zzjk.zzw(n << 3);
          m = ((zzjd)localObject2).zzc();
        }
        label2604:
        localObject2 = (String)localObject2;
        k = zzjk.zzw(n << 3);
        m = zzjk.zzy((String)localObject2);
        break label2745;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        m = zzjk.zzw(n << 3);
        m++;
        continue;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        m = zzjk.zzw(n << 3);
        break label2874;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        m = zzjk.zzw(n << 3);
        break label2902;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        m = zzmr.zzd(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzv(m);
        label2745:
        m = k + m;
        label2752:
        m = j + m;
        break;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        l = zzmr.zzf(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzx(l);
        break label2839;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        l = zzmr.zzf(paramT, l);
        k = zzjk.zzw(n << 3);
        m = zzjk.zzx(l);
        label2839:
        m = j + (k + m);
        break;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        m = zzjk.zzw(n << 3);
        label2874:
        m += 4;
        continue;
        m = j;
        if (!zzK(paramT, i)) {
          break;
        }
        m = zzjk.zzw(n << 3);
        label2902:
        m += 8;
      }
      label2908:
      i += 3;
    }
    localObject1 = this.zzn;
    return j + ((zzmh)localObject1).zzh(((zzmh)localObject1).zzd(paramT));
  }
  
  private final int zzs(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, int paramInt7, long paramLong2, zzir paramzzir)
    throws IOException
  {
    int i = paramInt1;
    Unsafe localUnsafe = zzb;
    zzkk localzzkk1 = (zzkk)localUnsafe.getObject(paramT, paramLong2);
    zzkk localzzkk2 = localzzkk1;
    if (!localzzkk1.zza())
    {
      int j = localzzkk1.size();
      if (j == 0) {
        j = 10;
      } else {
        j += j;
      }
      localzzkk2 = localzzkk1.zze(j);
      localUnsafe.putObject(paramT, paramLong2, localzzkk2);
    }
    switch (paramInt7)
    {
    default: 
      paramInt7 = i;
      if (paramInt5 != 3) {
        break label2367;
      }
      paramT = zzv(paramInt6);
      paramInt4 = paramInt3 & 0xFFFFFFF8 | 0x4;
      paramInt1 = zzis.zzj(paramT, paramArrayOfByte, paramInt1, paramInt2, paramInt4, paramzzir);
      localzzkk2.add(paramzzir.zzc);
      break;
    case 34: 
    case 48: 
      if (paramInt5 == 2)
      {
        paramT = (zzkx)localzzkk2;
        paramInt1 = zzis.zza(paramArrayOfByte, i, paramzzir);
        paramInt2 = paramzzir.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzis.zzc(paramArrayOfByte, paramInt1, paramzzir);
          paramT.zzg(zzjg.zzc(paramzzir.zzb));
        }
        if (paramInt1 == paramInt2) {
          break;
        }
        throw zzkn.zza();
      }
      paramInt7 = i;
      if (paramInt5 != 0) {
        break label2367;
      }
      paramT = (zzkx)localzzkk2;
      paramInt1 = zzis.zzc(paramArrayOfByte, i, paramzzir);
      paramT.zzg(zzjg.zzc(paramzzir.zzb));
      while (paramInt1 < paramInt2)
      {
        paramInt4 = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
        if (paramInt3 != paramzzir.zza) {
          break;
        }
        paramInt1 = zzis.zzc(paramArrayOfByte, paramInt4, paramzzir);
        paramT.zzg(zzjg.zzc(paramzzir.zzb));
      }
      return paramInt1;
    case 33: 
    case 47: 
      if (paramInt5 == 2)
      {
        paramT = (zzke)localzzkk2;
        paramInt1 = zzis.zza(paramArrayOfByte, i, paramzzir);
        paramInt2 = paramzzir.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
          paramT.zzh(zzjg.zzb(paramzzir.zza));
        }
        if (paramInt1 == paramInt2) {
          break;
        }
        throw zzkn.zza();
      }
      paramInt7 = i;
      if (paramInt5 != 0) {
        break label2367;
      }
      paramT = (zzke)localzzkk2;
      paramInt1 = zzis.zza(paramArrayOfByte, i, paramzzir);
      paramT.zzh(zzjg.zzb(paramzzir.zza));
      while (paramInt1 < paramInt2)
      {
        paramInt4 = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
        if (paramInt3 != paramzzir.zza) {
          break;
        }
        paramInt1 = zzis.zza(paramArrayOfByte, paramInt4, paramzzir);
        paramT.zzh(zzjg.zzb(paramzzir.zza));
      }
      return paramInt1;
    case 30: 
    case 44: 
      if (paramInt5 == 2)
      {
        paramInt1 = zzis.zzl(paramArrayOfByte, i, localzzkk2, paramzzir);
      }
      else
      {
        paramInt7 = i;
        if (paramInt5 != 0) {
          break label2367;
        }
        paramInt1 = zzis.zzk(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localzzkk2, paramzzir);
      }
      paramzzir = (zzkd)paramT;
      paramArrayOfByte = paramzzir.zzc;
      paramT = paramArrayOfByte;
      if (paramArrayOfByte == zzmi.zza()) {
        paramT = null;
      }
      paramT = zzlv.zzG(paramInt4, localzzkk2, zzx(paramInt6), paramT, this.zzn);
      if (paramT != null)
      {
        paramzzir.zzc = ((zzmi)paramT);
        return paramInt1;
      }
    case 28: 
      paramInt7 = i;
      if (paramInt5 != 2) {
        break label2367;
      }
      paramInt1 = zzis.zza(paramArrayOfByte, i, paramzzir);
      paramInt4 = paramzzir.zza;
      if (paramInt4 >= 0)
      {
        if (paramInt4 <= paramArrayOfByte.length - paramInt1)
        {
          if (paramInt4 == 0) {
            localzzkk2.add(zzjd.zzb);
          } else {
            localzzkk2.add(zzjd.zzj(paramArrayOfByte, paramInt1, paramInt4));
          }
          for (;;)
          {
            paramInt1 += paramInt4;
            for (;;)
            {
              if (paramInt1 >= paramInt2) {
                break label888;
              }
              paramInt4 = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
              if (paramInt3 != paramzzir.zza) {
                break label888;
              }
              paramInt1 = zzis.zza(paramArrayOfByte, paramInt4, paramzzir);
              paramInt4 = paramzzir.zza;
              if (paramInt4 < 0) {
                break label884;
              }
              if (paramInt4 > paramArrayOfByte.length - paramInt1) {
                break label880;
              }
              if (paramInt4 != 0) {
                break;
              }
              localzzkk2.add(zzjd.zzb);
            }
            localzzkk2.add(zzjd.zzj(paramArrayOfByte, paramInt1, paramInt4));
          }
          throw zzkn.zza();
          throw zzkn.zzb();
          return paramInt1;
        }
        throw zzkn.zza();
      }
      throw zzkn.zzb();
    case 27: 
      if (paramInt5 != 2)
      {
        paramInt7 = i;
        break label2367;
      }
      return zzis.zzm(zzv(paramInt6), paramInt3, paramArrayOfByte, paramInt1, paramInt2, localzzkk2, paramzzir);
    case 26: 
      paramInt7 = i;
      if (paramInt5 != 2) {
        break label2367;
      }
      if ((paramLong1 & 0x20000000) == 0L)
      {
        paramInt1 = zzis.zza(paramArrayOfByte, i, paramzzir);
        paramInt4 = paramzzir.zza;
        if (paramInt4 >= 0)
        {
          if (paramInt4 == 0) {
            localzzkk2.add("");
          } else {
            localzzkk2.add(new String(paramArrayOfByte, paramInt1, paramInt4, zzkl.zza));
          }
          for (;;)
          {
            paramInt1 += paramInt4;
            for (;;)
            {
              paramInt7 = paramInt1;
              if (paramInt1 >= paramInt2) {
                break label2367;
              }
              paramInt4 = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
              paramInt7 = paramInt1;
              if (paramInt3 != paramzzir.zza) {
                break label2367;
              }
              paramInt1 = zzis.zza(paramArrayOfByte, paramInt4, paramzzir);
              paramInt4 = paramzzir.zza;
              if (paramInt4 < 0) {
                break label1115;
              }
              if (paramInt4 != 0) {
                break;
              }
              localzzkk2.add("");
            }
            localzzkk2.add(new String(paramArrayOfByte, paramInt1, paramInt4, zzkl.zza));
          }
          throw zzkn.zzb();
        }
        throw zzkn.zzb();
      }
      paramInt4 = zzis.zza(paramArrayOfByte, i, paramzzir);
      paramInt5 = paramzzir.zza;
      if (paramInt5 >= 0)
      {
        if (paramInt5 == 0)
        {
          localzzkk2.add("");
          paramInt1 = paramInt4;
        }
        else
        {
          paramInt1 = paramInt4 + paramInt5;
          if (!zzmw.zzb(paramArrayOfByte, paramInt4, paramInt1)) {
            break label1331;
          }
          localzzkk2.add(new String(paramArrayOfByte, paramInt4, paramInt5, zzkl.zza));
        }
        for (;;)
        {
          paramInt7 = paramInt1;
          if (paramInt1 >= paramInt2) {
            break label2367;
          }
          paramInt4 = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
          paramInt7 = paramInt1;
          if (paramInt3 != paramzzir.zza) {
            break label2367;
          }
          paramInt4 = zzis.zza(paramArrayOfByte, paramInt4, paramzzir);
          paramInt5 = paramzzir.zza;
          if (paramInt5 < 0) {
            break label1327;
          }
          if (paramInt5 == 0)
          {
            localzzkk2.add("");
            paramInt1 = paramInt4;
          }
          else
          {
            paramInt1 = paramInt4 + paramInt5;
            if (!zzmw.zzb(paramArrayOfByte, paramInt4, paramInt1)) {
              break;
            }
            localzzkk2.add(new String(paramArrayOfByte, paramInt4, paramInt5, zzkl.zza));
          }
        }
        throw zzkn.zzf();
        throw zzkn.zzb();
        throw zzkn.zzf();
      }
      throw zzkn.zzb();
    case 25: 
    case 42: 
      boolean bool;
      if (paramInt5 == 2)
      {
        paramT = (zzit)localzzkk2;
        paramInt1 = zzis.zza(paramArrayOfByte, i, paramzzir);
        paramInt2 = paramzzir.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzis.zzc(paramArrayOfByte, paramInt1, paramzzir);
          if (paramzzir.zzb != 0L) {
            bool = true;
          } else {
            bool = false;
          }
          paramT.zzd(bool);
        }
        if (paramInt1 == paramInt2) {
          break;
        }
        throw zzkn.zza();
      }
      paramInt7 = i;
      if (paramInt5 != 0) {
        break label2367;
      }
      paramT = (zzit)localzzkk2;
      paramInt1 = zzis.zzc(paramArrayOfByte, i, paramzzir);
      if (paramzzir.zzb != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      paramT.zzd(bool);
      while (paramInt1 < paramInt2)
      {
        paramInt4 = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
        if (paramInt3 != paramzzir.zza) {
          break;
        }
        paramInt1 = zzis.zzc(paramArrayOfByte, paramInt4, paramzzir);
        if (paramzzir.zzb != 0L) {
          bool = true;
        } else {
          bool = false;
        }
        paramT.zzd(bool);
      }
      return paramInt1;
    case 24: 
    case 31: 
    case 41: 
    case 45: 
      if (paramInt5 == 2)
      {
        paramT = (zzke)localzzkk2;
        paramInt1 = zzis.zza(paramArrayOfByte, i, paramzzir);
        paramInt2 = paramzzir.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramT.zzh(zzis.zzd(paramArrayOfByte, paramInt1));
          paramInt1 += 4;
        }
        if (paramInt1 == paramInt2) {
          break;
        }
        throw zzkn.zza();
      }
      paramInt7 = i;
      if (paramInt5 != 5) {
        break label2367;
      }
      paramT = (zzke)localzzkk2;
      paramT.zzh(zzis.zzd(paramArrayOfByte, paramInt1));
      for (;;)
      {
        paramInt1 = i + 4;
        if (paramInt1 >= paramInt2) {
          break;
        }
        i = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
        if (paramInt3 != paramzzir.zza) {
          break;
        }
        paramT.zzh(zzis.zzd(paramArrayOfByte, i));
      }
      return paramInt1;
    case 23: 
    case 32: 
    case 40: 
    case 46: 
      if (paramInt5 == 2)
      {
        paramT = (zzkx)localzzkk2;
        paramInt1 = zzis.zza(paramArrayOfByte, i, paramzzir);
        paramInt2 = paramzzir.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramT.zzg(zzis.zze(paramArrayOfByte, paramInt1));
          paramInt1 += 8;
        }
        if (paramInt1 == paramInt2) {
          break;
        }
        throw zzkn.zza();
      }
      paramInt7 = i;
      if (paramInt5 != 1) {
        break label2367;
      }
      paramT = (zzkx)localzzkk2;
      paramT.zzg(zzis.zze(paramArrayOfByte, paramInt1));
      for (;;)
      {
        paramInt1 = i + 8;
        if (paramInt1 >= paramInt2) {
          break;
        }
        i = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
        if (paramInt3 != paramzzir.zza) {
          break;
        }
        paramT.zzg(zzis.zze(paramArrayOfByte, i));
      }
      return paramInt1;
    case 22: 
    case 29: 
    case 39: 
    case 43: 
      if (paramInt5 == 2)
      {
        paramInt1 = zzis.zzl(paramArrayOfByte, i, localzzkk2, paramzzir);
        break;
      }
      if (paramInt5 != 0)
      {
        paramInt7 = i;
        break label2367;
      }
      return zzis.zzk(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localzzkk2, paramzzir);
    case 20: 
    case 21: 
    case 37: 
    case 38: 
      if (paramInt5 == 2)
      {
        paramT = (zzkx)localzzkk2;
        paramInt1 = zzis.zza(paramArrayOfByte, i, paramzzir);
        paramInt2 = paramzzir.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzis.zzc(paramArrayOfByte, paramInt1, paramzzir);
          paramT.zzg(paramzzir.zzb);
        }
        if (paramInt1 == paramInt2) {
          break;
        }
        throw zzkn.zza();
      }
      paramInt7 = i;
      if (paramInt5 != 0) {
        break label2367;
      }
      paramT = (zzkx)localzzkk2;
      paramInt1 = zzis.zzc(paramArrayOfByte, i, paramzzir);
      paramT.zzg(paramzzir.zzb);
      while (paramInt1 < paramInt2)
      {
        paramInt4 = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
        if (paramInt3 != paramzzir.zza) {
          break;
        }
        paramInt1 = zzis.zzc(paramArrayOfByte, paramInt4, paramzzir);
        paramT.zzg(paramzzir.zzb);
      }
      return paramInt1;
    case 19: 
    case 36: 
      label880:
      label884:
      label888:
      label1115:
      label1327:
      label1331:
      if (paramInt5 == 2)
      {
        paramT = (zzjw)localzzkk2;
        paramInt1 = zzis.zza(paramArrayOfByte, i, paramzzir);
        paramInt2 = paramzzir.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramT.zzd(Float.intBitsToFloat(zzis.zzd(paramArrayOfByte, paramInt1)));
          paramInt1 += 4;
        }
        if (paramInt1 == paramInt2) {
          break;
        }
        throw zzkn.zza();
      }
      paramInt7 = i;
      if (paramInt5 != 5) {
        break label2367;
      }
      paramT = (zzjw)localzzkk2;
      paramT.zzd(Float.intBitsToFloat(zzis.zzd(paramArrayOfByte, paramInt1)));
      for (;;)
      {
        paramInt1 = i + 4;
        if (paramInt1 >= paramInt2) {
          break;
        }
        i = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
        if (paramInt3 != paramzzir.zza) {
          break;
        }
        paramT.zzd(Float.intBitsToFloat(zzis.zzd(paramArrayOfByte, i)));
      }
      return paramInt1;
    }
    if (paramInt5 == 2)
    {
      paramT = (zzjm)localzzkk2;
      paramInt1 = zzis.zza(paramArrayOfByte, i, paramzzir);
      paramInt2 = paramzzir.zza + paramInt1;
      while (paramInt1 < paramInt2)
      {
        paramT.zzd(Double.longBitsToDouble(zzis.zze(paramArrayOfByte, paramInt1)));
        paramInt1 += 8;
      }
      if (paramInt1 != paramInt2) {
        throw zzkn.zza();
      }
    }
    else
    {
      paramInt7 = i;
      if (paramInt5 == 1)
      {
        paramT = (zzjm)localzzkk2;
        paramT.zzd(Double.longBitsToDouble(zzis.zze(paramArrayOfByte, paramInt1)));
        for (;;)
        {
          paramInt1 = i + 8;
          if (paramInt1 >= paramInt2) {
            break;
          }
          i = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
          if (paramInt3 != paramzzir.zza) {
            break;
          }
          paramT.zzd(Double.longBitsToDouble(zzis.zze(paramArrayOfByte, i)));
        }
        return paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramInt5 = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
          if (paramInt3 != paramzzir.zza) {
            break;
          }
          paramInt1 = zzis.zzj(paramT, paramArrayOfByte, paramInt5, paramInt2, paramInt4, paramzzir);
          localzzkk2.add(paramzzir.zzc);
        }
        return paramInt1;
      }
      label2367:
      paramInt1 = paramInt7;
    }
    return paramInt1;
  }
  
  private final <K, V> int zzt(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong, zzir paramzzir)
    throws IOException
  {
    Unsafe localUnsafe = zzb;
    paramzzir = zzw(paramInt3);
    paramArrayOfByte = localUnsafe.getObject(paramT, paramLong);
    if (!((zzlc)paramArrayOfByte).zze())
    {
      zzlc localzzlc = zzlc.zza().zzc();
      zzld.zzb(localzzlc, paramArrayOfByte);
      localUnsafe.putObject(paramT, paramLong, localzzlc);
    }
    paramT = (zzlb)paramzzir;
    throw null;
  }
  
  private final int zzu(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong, int paramInt8, zzir paramzzir)
    throws IOException
  {
    Unsafe localUnsafe = zzb;
    long l = this.zzc[(paramInt8 + 2)] & 0xFFFFF;
    switch (paramInt7)
    {
    default: 
      break;
    case 68: 
      if (paramInt5 == 3)
      {
        paramInt1 = zzis.zzj(zzv(paramInt8), paramArrayOfByte, paramInt1, paramInt2, paramInt3 & 0xFFFFFFF8 | 0x4, paramzzir);
        if (localUnsafe.getInt(paramT, l) == paramInt4) {
          paramArrayOfByte = localUnsafe.getObject(paramT, paramLong);
        } else {
          paramArrayOfByte = null;
        }
        if (paramArrayOfByte == null) {
          localUnsafe.putObject(paramT, paramLong, paramzzir.zzc);
        } else {
          localUnsafe.putObject(paramT, paramLong, zzkl.zzi(paramArrayOfByte, paramzzir.zzc));
        }
        localUnsafe.putInt(paramT, l, paramInt4);
      }
      break;
    case 67: 
      if (paramInt5 == 0)
      {
        paramInt1 = zzis.zzc(paramArrayOfByte, paramInt1, paramzzir);
        localUnsafe.putObject(paramT, paramLong, Long.valueOf(zzjg.zzc(paramzzir.zzb)));
        localUnsafe.putInt(paramT, l, paramInt4);
        return paramInt1;
      }
      break;
    case 66: 
      if (paramInt5 == 0)
      {
        paramInt1 = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
        localUnsafe.putObject(paramT, paramLong, Integer.valueOf(zzjg.zzb(paramzzir.zza)));
        localUnsafe.putInt(paramT, l, paramInt4);
        return paramInt1;
      }
      break;
    case 63: 
      if (paramInt5 == 0)
      {
        paramInt1 = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
        paramInt2 = paramzzir.zza;
        paramArrayOfByte = zzx(paramInt8);
        if ((paramArrayOfByte != null) && (!paramArrayOfByte.zza(paramInt2)))
        {
          zzf(paramT).zzh(paramInt3, Long.valueOf(paramInt2));
        }
        else
        {
          localUnsafe.putObject(paramT, paramLong, Integer.valueOf(paramInt2));
          localUnsafe.putInt(paramT, l, paramInt4);
        }
      }
      break;
    case 61: 
      if (paramInt5 == 2)
      {
        paramInt1 = zzis.zzh(paramArrayOfByte, paramInt1, paramzzir);
        localUnsafe.putObject(paramT, paramLong, paramzzir.zzc);
        localUnsafe.putInt(paramT, l, paramInt4);
        return paramInt1;
      }
      break;
    case 60: 
      if (paramInt5 == 2)
      {
        paramInt1 = zzis.zzi(zzv(paramInt8), paramArrayOfByte, paramInt1, paramInt2, paramzzir);
        if (localUnsafe.getInt(paramT, l) == paramInt4) {
          paramArrayOfByte = localUnsafe.getObject(paramT, paramLong);
        } else {
          paramArrayOfByte = null;
        }
        if (paramArrayOfByte == null) {
          localUnsafe.putObject(paramT, paramLong, paramzzir.zzc);
        } else {
          localUnsafe.putObject(paramT, paramLong, zzkl.zzi(paramArrayOfByte, paramzzir.zzc));
        }
        localUnsafe.putInt(paramT, l, paramInt4);
      }
      break;
    case 59: 
      if (paramInt5 == 2)
      {
        paramInt1 = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
        paramInt2 = paramzzir.zza;
        if (paramInt2 == 0)
        {
          localUnsafe.putObject(paramT, paramLong, "");
        }
        else
        {
          if (((paramInt6 & 0x20000000) != 0) && (!zzmw.zzb(paramArrayOfByte, paramInt1, paramInt1 + paramInt2))) {
            throw zzkn.zzf();
          }
          localUnsafe.putObject(paramT, paramLong, new String(paramArrayOfByte, paramInt1, paramInt2, zzkl.zza));
          paramInt1 += paramInt2;
        }
        localUnsafe.putInt(paramT, l, paramInt4);
      }
      break;
    case 58: 
      if (paramInt5 == 0)
      {
        paramInt1 = zzis.zzc(paramArrayOfByte, paramInt1, paramzzir);
        boolean bool;
        if (paramzzir.zzb != 0L) {
          bool = true;
        } else {
          bool = false;
        }
        localUnsafe.putObject(paramT, paramLong, Boolean.valueOf(bool));
        localUnsafe.putInt(paramT, l, paramInt4);
        return paramInt1;
      }
      break;
    case 57: 
    case 64: 
      if (paramInt5 == 5)
      {
        localUnsafe.putObject(paramT, paramLong, Integer.valueOf(zzis.zzd(paramArrayOfByte, paramInt1)));
        localUnsafe.putInt(paramT, l, paramInt4);
        return paramInt1 + 4;
      }
      break;
    case 56: 
    case 65: 
      if (paramInt5 == 1)
      {
        localUnsafe.putObject(paramT, paramLong, Long.valueOf(zzis.zze(paramArrayOfByte, paramInt1)));
        localUnsafe.putInt(paramT, l, paramInt4);
        return paramInt1 + 8;
      }
      break;
    case 55: 
    case 62: 
      if (paramInt5 == 0)
      {
        paramInt1 = zzis.zza(paramArrayOfByte, paramInt1, paramzzir);
        localUnsafe.putObject(paramT, paramLong, Integer.valueOf(paramzzir.zza));
        localUnsafe.putInt(paramT, l, paramInt4);
        return paramInt1;
      }
      break;
    case 53: 
    case 54: 
      if (paramInt5 == 0)
      {
        paramInt1 = zzis.zzc(paramArrayOfByte, paramInt1, paramzzir);
        localUnsafe.putObject(paramT, paramLong, Long.valueOf(paramzzir.zzb));
        localUnsafe.putInt(paramT, l, paramInt4);
        return paramInt1;
      }
      break;
    case 52: 
      if (paramInt5 == 5)
      {
        localUnsafe.putObject(paramT, paramLong, Float.valueOf(Float.intBitsToFloat(zzis.zzd(paramArrayOfByte, paramInt1))));
        localUnsafe.putInt(paramT, l, paramInt4);
        return paramInt1 + 4;
      }
      break;
    case 51: 
      if (paramInt5 == 1)
      {
        localUnsafe.putObject(paramT, paramLong, Double.valueOf(Double.longBitsToDouble(zzis.zze(paramArrayOfByte, paramInt1))));
        localUnsafe.putInt(paramT, l, paramInt4);
        return paramInt1 + 8;
      }
      break;
    }
    return paramInt1;
  }
  
  private final zzlt zzv(int paramInt)
  {
    paramInt /= 3;
    paramInt += paramInt;
    zzlt localzzlt = (zzlt)this.zzd[paramInt];
    if (localzzlt != null) {
      return localzzlt;
    }
    localzzlt = zzlq.zza().zzb((Class)this.zzd[(paramInt + 1)]);
    this.zzd[paramInt] = localzzlt;
    return localzzlt;
  }
  
  private final Object zzw(int paramInt)
  {
    paramInt /= 3;
    return this.zzd[(paramInt + paramInt)];
  }
  
  private final zzkh zzx(int paramInt)
  {
    paramInt /= 3;
    return (zzkh)this.zzd[(paramInt + paramInt + 1)];
  }
  
  private final int zzy(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzir paramzzir)
    throws IOException
  {
    int i = paramInt2;
    Object localObject1 = zzb;
    int j = paramInt1;
    int k = -1;
    int m = 0;
    paramInt1 = 0;
    int n = 1048575;
    for (;;)
    {
      Object localObject2 = this;
      T ? = paramT;
      Object localObject3 = paramArrayOfByte;
      Object localObject4 = paramzzir;
      if (j >= i) {
        break;
      }
      i = j + 1;
      int i1 = localObject3[j];
      if (i1 < 0)
      {
        j = zzis.zzb(i1, (byte[])localObject3, i, (zzir)localObject4);
        i1 = ((zzir)localObject4).zza;
      }
      else
      {
        j = i;
      }
      i = i1 >>> 3;
      int i2 = i1 & 0x7;
      if (i > k) {
        k = ((zzll)localObject2).zzP(i, m / 3);
      } else {
        k = ((zzll)localObject2).zzO(i);
      }
      if (k == -1)
      {
        m = 0;
        k = j;
        j = m;
      }
      else
      {
        int i3 = localObject2.zzc[(k + 1)];
        int i4 = zzC(i3);
        long l = i3 & 0xFFFFF;
        if (i4 <= 17)
        {
          m = localObject2.zzc[(k + 2)];
          boolean bool = true;
          i5 = 1 << (m >>> 20);
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
          switch (i4)
          {
          default: 
            break;
          case 16: 
            if (i2 == 0)
            {
              paramInt1 = zzis.zzc((byte[])localObject3, j, (zzir)localObject4);
              ((Unsafe)localObject1).putLong(paramT, l, zzjg.zzc(((zzir)localObject4).zzb));
            }
            break;
          case 15: 
            if (i2 == 0)
            {
              paramInt1 = zzis.zza((byte[])localObject3, j, (zzir)localObject4);
              ((Unsafe)localObject1).putInt(?, l, zzjg.zzb(((zzir)localObject4).zza));
            }
            break;
          case 12: 
            if (i2 == 0)
            {
              paramInt1 = zzis.zza((byte[])localObject3, j, (zzir)localObject4);
              ((Unsafe)localObject1).putInt(?, l, ((zzir)localObject4).zza);
            }
            break;
          case 10: 
            if (i2 == 2)
            {
              paramInt1 = zzis.zzh((byte[])localObject3, j, (zzir)localObject4);
              ((Unsafe)localObject1).putObject(?, l, ((zzir)localObject4).zzc);
            }
            break;
          case 9: 
            if (i2 == 2)
            {
              paramInt1 = zzis.zzi(((zzll)localObject2).zzv(k), (byte[])localObject3, j, paramInt2, (zzir)localObject4);
              localObject2 = ((Unsafe)localObject1).getObject(?, l);
              if (localObject2 == null) {
                ((Unsafe)localObject1).putObject(?, l, ((zzir)localObject4).zzc);
              } else {
                ((Unsafe)localObject1).putObject(?, l, zzkl.zzi(localObject2, ((zzir)localObject4).zzc));
              }
            }
            break;
          case 8: 
            if (i2 == 2)
            {
              if ((i3 & 0x20000000) == 0) {
                paramInt1 = zzis.zzf((byte[])localObject3, j, (zzir)localObject4);
              } else {
                paramInt1 = zzis.zzg((byte[])localObject3, j, (zzir)localObject4);
              }
              ((Unsafe)localObject1).putObject(?, l, ((zzir)localObject4).zzc);
            }
            break;
          case 7: 
            if (i2 == 0)
            {
              paramInt1 = zzis.zzc((byte[])localObject3, j, (zzir)localObject4);
              if (((zzir)localObject4).zzb == 0L) {
                bool = false;
              }
              zzmr.zzi(?, l, bool);
            }
            break;
          case 6: 
          case 13: 
            if (i2 == 5)
            {
              ((Unsafe)localObject1).putInt(?, l, zzis.zzd((byte[])localObject3, j));
              paramInt1 = j + 4;
              i5 = m | i5;
              m = i;
              i = paramInt2;
              i1 = k;
              j = paramInt1;
              k = m;
              m = i1;
              paramInt1 = i5;
            }
            break;
          case 5: 
          case 14: 
            if (i2 == 1)
            {
              ((Unsafe)localObject1).putLong(paramT, l, zzis.zze((byte[])localObject3, j));
              paramInt1 = j + 8;
            }
            break;
          case 4: 
          case 11: 
            if (i2 == 0)
            {
              paramInt1 = zzis.zza((byte[])localObject3, j, (zzir)localObject4);
              ((Unsafe)localObject1).putInt(?, l, ((zzir)localObject4).zza);
            }
            break;
          case 2: 
          case 3: 
            if (i2 == 0)
            {
              paramInt1 = zzis.zzc((byte[])localObject3, j, (zzir)localObject4);
              ((Unsafe)localObject1).putLong(paramT, l, ((zzir)localObject4).zzb);
              i1 = m | i5;
              j = paramInt1;
              m = k;
              paramInt1 = i1;
            }
            break;
          case 1: 
            if (i2 == 5)
            {
              zzmr.zzk(?, l, Float.intBitsToFloat(zzis.zzd((byte[])localObject3, j)));
              paramInt1 = j + 4;
            }
            break;
          case 0: 
            if (i2 == 1)
            {
              zzmr.zzm(?, l, Double.longBitsToDouble(zzis.zze((byte[])localObject3, j)));
              paramInt1 = j + 8;
              m |= i5;
              j = paramInt1;
              paramInt1 = m;
              m = k;
              break label1084;
            }
            paramInt1 = j;
            j = k;
            k = paramInt1;
            paramInt1 = m;
            break;
          }
        }
        int i5 = i;
        m = k;
        localObject4 = localObject1;
        label1084:
        int i6;
        if (i4 == 27)
        {
          if (i2 == 2)
          {
            localObject3 = (zzkk)((Unsafe)localObject4).getObject(?, l);
            localObject1 = localObject3;
            if (!((zzkk)localObject3).zza())
            {
              k = ((List)localObject3).size();
              if (k == 0) {
                k = 10;
              } else {
                k += k;
              }
              localObject1 = ((zzkk)localObject3).zze(k);
              ((Unsafe)localObject4).putObject(?, l, localObject1);
            }
            j = zzis.zzm(((zzll)localObject2).zzv(m), i1, paramArrayOfByte, j, paramInt2, (zzkk)localObject1, paramzzir);
            localObject1 = localObject4;
            k = i;
            i = paramInt2;
            continue;
          }
        }
        else if (i4 <= 49)
        {
          i6 = zzs(paramT, paramArrayOfByte, j, paramInt2, i1, i5, i2, m, i3, i4, l, paramzzir);
          m = i6;
          if (i6 != j) {
            j = i6;
          }
        }
        for (;;)
        {
          m = k;
          k = i5;
          break label1303;
          label1231:
          do
          {
            do
            {
              j = m;
              break;
              i6 = j;
              if (i4 != 50) {
                break label1231;
              }
              if (i2 != 2) {
                break;
              }
              j = zzt(paramT, paramArrayOfByte, i6, paramInt2, m, l, paramzzir);
              m = j;
            } while (j == i6);
            break;
            m = k;
            k = j;
            j = m;
            break label1273;
            j = zzu(paramT, paramArrayOfByte, i6, paramInt2, i1, i5, i2, i3, i4, l, m, paramzzir);
            m = j;
          } while (j == i6);
        }
      }
      label1273:
      i1 = zzis.zzn(i1, paramArrayOfByte, k, paramInt2, zzf(paramT), paramzzir);
      k = i;
      m = j;
      j = i1;
      label1303:
      i = paramInt2;
    }
    if (n != 1048575) {
      ((Unsafe)localObject1).putInt(paramT, n, paramInt1);
    }
    if (j == paramInt2) {
      return j;
    }
    throw zzkn.zze();
  }
  
  private static boolean zzz(Object paramObject, int paramInt, zzlt paramzzlt)
  {
    return paramzzlt.zzj(zzmr.zzn(paramObject, paramInt & 0xFFFFF));
  }
  
  public final T zza()
  {
    return (T)((zzkd)this.zzg).zzl(4, null, null);
  }
  
  /* Error */
  public final boolean zzb(T paramT1, T paramT2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/google/android/gms/internal/measurement/zzll:zzc	[I
    //   4: arraylength
    //   5: istore_3
    //   6: iconst_0
    //   7: istore 4
    //   9: iload 4
    //   11: iload_3
    //   12: if_icmpge +972 -> 984
    //   15: aload_0
    //   16: iload 4
    //   18: invokespecial 159	com/google/android/gms/internal/measurement/zzll:zzA	(I)I
    //   21: istore 5
    //   23: iload 5
    //   25: ldc -104
    //   27: iand
    //   28: i2l
    //   29: lstore 6
    //   31: iload 5
    //   33: invokestatic 161	com/google/android/gms/internal/measurement/zzll:zzC	(I)I
    //   36: tableswitch	default:+292->328, 0:+904->940, 1:+869->905, 2:+839->875, 3:+809->845, 4:+780->816, 5:+750->786, 6:+721->757, 7:+692->728, 8:+660->696, 9:+628->664, 10:+596->632, 11:+567->603, 12:+538->574, 13:+509->545, 14:+479->515, 15:+450->486, 16:+420->456, 17:+388->424, 18:+363->399, 19:+363->399, 20:+363->399, 21:+363->399, 22:+363->399, 23:+363->399, 24:+363->399, 25:+363->399, 26:+363->399, 27:+363->399, 28:+363->399, 29:+363->399, 30:+363->399, 31:+363->399, 32:+363->399, 33:+363->399, 34:+363->399, 35:+363->399, 36:+363->399, 37:+363->399, 38:+363->399, 39:+363->399, 40:+363->399, 41:+363->399, 42:+363->399, 43:+363->399, 44:+363->399, 45:+363->399, 46:+363->399, 47:+363->399, 48:+363->399, 49:+363->399, 50:+343->379, 51:+295->331, 52:+295->331, 53:+295->331, 54:+295->331, 55:+295->331, 56:+295->331, 57:+295->331, 58:+295->331, 59:+295->331, 60:+295->331, 61:+295->331, 62:+295->331, 63:+295->331, 64:+295->331, 65:+295->331, 66:+295->331, 67:+295->331, 68:+295->331
    //   328: goto +650 -> 978
    //   331: aload_0
    //   332: iload 4
    //   334: invokespecial 155	com/google/android/gms/internal/measurement/zzll:zzB	(I)I
    //   337: ldc -104
    //   339: iand
    //   340: i2l
    //   341: lstore 8
    //   343: aload_1
    //   344: lload 8
    //   346: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   349: aload_2
    //   350: lload 8
    //   352: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   355: if_icmpne +621 -> 976
    //   358: aload_1
    //   359: lload 6
    //   361: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   364: aload_2
    //   365: lload 6
    //   367: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   370: invokestatic 816	com/google/android/gms/internal/measurement/zzlv:zzD	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   373: ifne +605 -> 978
    //   376: goto +600 -> 976
    //   379: aload_1
    //   380: lload 6
    //   382: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   385: aload_2
    //   386: lload 6
    //   388: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   391: invokestatic 816	com/google/android/gms/internal/measurement/zzlv:zzD	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   394: istore 10
    //   396: goto +20 -> 416
    //   399: aload_1
    //   400: lload 6
    //   402: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   405: aload_2
    //   406: lload 6
    //   408: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   411: invokestatic 816	com/google/android/gms/internal/measurement/zzlv:zzD	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   414: istore 10
    //   416: iload 10
    //   418: ifne +560 -> 978
    //   421: goto +555 -> 976
    //   424: aload_0
    //   425: aload_1
    //   426: aload_2
    //   427: iload 4
    //   429: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   432: ifeq +544 -> 976
    //   435: aload_1
    //   436: lload 6
    //   438: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   441: aload_2
    //   442: lload 6
    //   444: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   447: invokestatic 816	com/google/android/gms/internal/measurement/zzlv:zzD	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   450: ifeq +526 -> 976
    //   453: goto +525 -> 978
    //   456: aload_0
    //   457: aload_1
    //   458: aload_2
    //   459: iload 4
    //   461: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   464: ifeq +512 -> 976
    //   467: aload_1
    //   468: lload 6
    //   470: invokestatic 166	com/google/android/gms/internal/measurement/zzmr:zzf	(Ljava/lang/Object;J)J
    //   473: aload_2
    //   474: lload 6
    //   476: invokestatic 166	com/google/android/gms/internal/measurement/zzmr:zzf	(Ljava/lang/Object;J)J
    //   479: lcmp
    //   480: ifne +496 -> 976
    //   483: goto +495 -> 978
    //   486: aload_0
    //   487: aload_1
    //   488: aload_2
    //   489: iload 4
    //   491: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   494: ifeq +482 -> 976
    //   497: aload_1
    //   498: lload 6
    //   500: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   503: aload_2
    //   504: lload 6
    //   506: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   509: if_icmpne +467 -> 976
    //   512: goto +466 -> 978
    //   515: aload_0
    //   516: aload_1
    //   517: aload_2
    //   518: iload 4
    //   520: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   523: ifeq +453 -> 976
    //   526: aload_1
    //   527: lload 6
    //   529: invokestatic 166	com/google/android/gms/internal/measurement/zzmr:zzf	(Ljava/lang/Object;J)J
    //   532: aload_2
    //   533: lload 6
    //   535: invokestatic 166	com/google/android/gms/internal/measurement/zzmr:zzf	(Ljava/lang/Object;J)J
    //   538: lcmp
    //   539: ifne +437 -> 976
    //   542: goto +436 -> 978
    //   545: aload_0
    //   546: aload_1
    //   547: aload_2
    //   548: iload 4
    //   550: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   553: ifeq +423 -> 976
    //   556: aload_1
    //   557: lload 6
    //   559: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   562: aload_2
    //   563: lload 6
    //   565: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   568: if_icmpne +408 -> 976
    //   571: goto +407 -> 978
    //   574: aload_0
    //   575: aload_1
    //   576: aload_2
    //   577: iload 4
    //   579: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   582: ifeq +394 -> 976
    //   585: aload_1
    //   586: lload 6
    //   588: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   591: aload_2
    //   592: lload 6
    //   594: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   597: if_icmpne +379 -> 976
    //   600: goto +378 -> 978
    //   603: aload_0
    //   604: aload_1
    //   605: aload_2
    //   606: iload 4
    //   608: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   611: ifeq +365 -> 976
    //   614: aload_1
    //   615: lload 6
    //   617: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   620: aload_2
    //   621: lload 6
    //   623: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   626: if_icmpne +350 -> 976
    //   629: goto +349 -> 978
    //   632: aload_0
    //   633: aload_1
    //   634: aload_2
    //   635: iload 4
    //   637: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   640: ifeq +336 -> 976
    //   643: aload_1
    //   644: lload 6
    //   646: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   649: aload_2
    //   650: lload 6
    //   652: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   655: invokestatic 816	com/google/android/gms/internal/measurement/zzlv:zzD	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   658: ifeq +318 -> 976
    //   661: goto +317 -> 978
    //   664: aload_0
    //   665: aload_1
    //   666: aload_2
    //   667: iload 4
    //   669: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   672: ifeq +304 -> 976
    //   675: aload_1
    //   676: lload 6
    //   678: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   681: aload_2
    //   682: lload 6
    //   684: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   687: invokestatic 816	com/google/android/gms/internal/measurement/zzlv:zzD	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   690: ifeq +286 -> 976
    //   693: goto +285 -> 978
    //   696: aload_0
    //   697: aload_1
    //   698: aload_2
    //   699: iload 4
    //   701: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   704: ifeq +272 -> 976
    //   707: aload_1
    //   708: lload 6
    //   710: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   713: aload_2
    //   714: lload 6
    //   716: invokestatic 99	com/google/android/gms/internal/measurement/zzmr:zzn	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   719: invokestatic 816	com/google/android/gms/internal/measurement/zzlv:zzD	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   722: ifeq +254 -> 976
    //   725: goto +253 -> 978
    //   728: aload_0
    //   729: aload_1
    //   730: aload_2
    //   731: iload 4
    //   733: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   736: ifeq +240 -> 976
    //   739: aload_1
    //   740: lload 6
    //   742: invokestatic 184	com/google/android/gms/internal/measurement/zzmr:zzh	(Ljava/lang/Object;J)Z
    //   745: aload_2
    //   746: lload 6
    //   748: invokestatic 184	com/google/android/gms/internal/measurement/zzmr:zzh	(Ljava/lang/Object;J)Z
    //   751: if_icmpne +225 -> 976
    //   754: goto +224 -> 978
    //   757: aload_0
    //   758: aload_1
    //   759: aload_2
    //   760: iload 4
    //   762: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   765: ifeq +211 -> 976
    //   768: aload_1
    //   769: lload 6
    //   771: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   774: aload_2
    //   775: lload 6
    //   777: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   780: if_icmpne +196 -> 976
    //   783: goto +195 -> 978
    //   786: aload_0
    //   787: aload_1
    //   788: aload_2
    //   789: iload 4
    //   791: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   794: ifeq +182 -> 976
    //   797: aload_1
    //   798: lload 6
    //   800: invokestatic 166	com/google/android/gms/internal/measurement/zzmr:zzf	(Ljava/lang/Object;J)J
    //   803: aload_2
    //   804: lload 6
    //   806: invokestatic 166	com/google/android/gms/internal/measurement/zzmr:zzf	(Ljava/lang/Object;J)J
    //   809: lcmp
    //   810: ifne +166 -> 976
    //   813: goto +165 -> 978
    //   816: aload_0
    //   817: aload_1
    //   818: aload_2
    //   819: iload 4
    //   821: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   824: ifeq +152 -> 976
    //   827: aload_1
    //   828: lload 6
    //   830: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   833: aload_2
    //   834: lload 6
    //   836: invokestatic 168	com/google/android/gms/internal/measurement/zzmr:zzd	(Ljava/lang/Object;J)I
    //   839: if_icmpne +137 -> 976
    //   842: goto +136 -> 978
    //   845: aload_0
    //   846: aload_1
    //   847: aload_2
    //   848: iload 4
    //   850: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   853: ifeq +123 -> 976
    //   856: aload_1
    //   857: lload 6
    //   859: invokestatic 166	com/google/android/gms/internal/measurement/zzmr:zzf	(Ljava/lang/Object;J)J
    //   862: aload_2
    //   863: lload 6
    //   865: invokestatic 166	com/google/android/gms/internal/measurement/zzmr:zzf	(Ljava/lang/Object;J)J
    //   868: lcmp
    //   869: ifne +107 -> 976
    //   872: goto +106 -> 978
    //   875: aload_0
    //   876: aload_1
    //   877: aload_2
    //   878: iload 4
    //   880: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   883: ifeq +93 -> 976
    //   886: aload_1
    //   887: lload 6
    //   889: invokestatic 166	com/google/android/gms/internal/measurement/zzmr:zzf	(Ljava/lang/Object;J)J
    //   892: aload_2
    //   893: lload 6
    //   895: invokestatic 166	com/google/android/gms/internal/measurement/zzmr:zzf	(Ljava/lang/Object;J)J
    //   898: lcmp
    //   899: ifne +77 -> 976
    //   902: goto +76 -> 978
    //   905: aload_0
    //   906: aload_1
    //   907: aload_2
    //   908: iload 4
    //   910: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   913: ifeq +63 -> 976
    //   916: aload_1
    //   917: lload 6
    //   919: invokestatic 186	com/google/android/gms/internal/measurement/zzmr:zzj	(Ljava/lang/Object;J)F
    //   922: invokestatic 822	java/lang/Float:floatToIntBits	(F)I
    //   925: aload_2
    //   926: lload 6
    //   928: invokestatic 186	com/google/android/gms/internal/measurement/zzmr:zzj	(Ljava/lang/Object;J)F
    //   931: invokestatic 822	java/lang/Float:floatToIntBits	(F)I
    //   934: if_icmpne +42 -> 976
    //   937: goto +41 -> 978
    //   940: aload_0
    //   941: aload_1
    //   942: aload_2
    //   943: iload 4
    //   945: invokespecial 818	com/google/android/gms/internal/measurement/zzll:zzI	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   948: ifeq +28 -> 976
    //   951: aload_1
    //   952: lload 6
    //   954: invokestatic 188	com/google/android/gms/internal/measurement/zzmr:zzl	(Ljava/lang/Object;J)D
    //   957: invokestatic 826	java/lang/Double:doubleToLongBits	(D)J
    //   960: aload_2
    //   961: lload 6
    //   963: invokestatic 188	com/google/android/gms/internal/measurement/zzmr:zzl	(Ljava/lang/Object;J)D
    //   966: invokestatic 826	java/lang/Double:doubleToLongBits	(D)J
    //   969: lcmp
    //   970: ifne +6 -> 976
    //   973: goto +5 -> 978
    //   976: iconst_0
    //   977: ireturn
    //   978: iinc 4 3
    //   981: goto -972 -> 9
    //   984: aload_0
    //   985: getfield 82	com/google/android/gms/internal/measurement/zzll:zzn	Lcom/google/android/gms/internal/measurement/zzmh;
    //   988: aload_1
    //   989: invokevirtual 346	com/google/android/gms/internal/measurement/zzmh:zzd	(Ljava/lang/Object;)Ljava/lang/Object;
    //   992: aload_0
    //   993: getfield 82	com/google/android/gms/internal/measurement/zzll:zzn	Lcom/google/android/gms/internal/measurement/zzmh;
    //   996: aload_2
    //   997: invokevirtual 346	com/google/android/gms/internal/measurement/zzmh:zzd	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1000: invokevirtual 827	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1003: ifne +5 -> 1008
    //   1006: iconst_0
    //   1007: ireturn
    //   1008: aload_0
    //   1009: getfield 70	com/google/android/gms/internal/measurement/zzll:zzh	Z
    //   1012: ifne +5 -> 1017
    //   1015: iconst_1
    //   1016: ireturn
    //   1017: aload_0
    //   1018: getfield 84	com/google/android/gms/internal/measurement/zzll:zzo	Lcom/google/android/gms/internal/measurement/zzjq;
    //   1021: aload_1
    //   1022: invokevirtual 351	com/google/android/gms/internal/measurement/zzjq:zzb	(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzju;
    //   1025: pop
    //   1026: aload_0
    //   1027: getfield 84	com/google/android/gms/internal/measurement/zzll:zzo	Lcom/google/android/gms/internal/measurement/zzjq;
    //   1030: aload_2
    //   1031: invokevirtual 351	com/google/android/gms/internal/measurement/zzjq:zzb	(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzju;
    //   1034: pop
    //   1035: aconst_null
    //   1036: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1037	0	this	zzll
    //   0	1037	1	paramT1	T
    //   0	1037	2	paramT2	T
    //   5	8	3	i	int
    //   7	972	4	j	int
    //   21	11	5	k	int
    //   29	933	6	l1	long
    //   341	10	8	l2	long
    //   394	23	10	bool	boolean
  }
  
  public final int zzc(T paramT)
  {
    int i = this.zzc.length;
    int j = 0;
    for (int k = 0; j < i; k = m)
    {
      m = zzA(j);
      int n = this.zzc[j];
      long l = 0xFFFFF & m;
      int i1 = zzC(m);
      m = 37;
      Object localObject;
      switch (i1)
      {
      default: 
        m = k;
        break;
      case 68: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzmr.zzn(paramT, l).hashCode();
        break;
      case 67: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzkl.zze(zzG(paramT, l));
        break;
      case 66: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzF(paramT, l);
        break;
      case 65: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzkl.zze(zzG(paramT, l));
        break;
      case 64: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzF(paramT, l);
        break;
      case 63: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzF(paramT, l);
        break;
      case 62: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzF(paramT, l);
        break;
      case 61: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzmr.zzn(paramT, l).hashCode();
        break;
      case 60: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzmr.zzn(paramT, l).hashCode();
        break;
      case 59: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = ((String)zzmr.zzn(paramT, l)).hashCode();
        break;
      case 58: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzkl.zzf(zzH(paramT, l));
        break;
      case 57: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzF(paramT, l);
        break;
      case 56: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzkl.zze(zzG(paramT, l));
        break;
      case 55: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzF(paramT, l);
        break;
      case 54: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzkl.zze(zzG(paramT, l));
        break;
      case 53: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzkl.zze(zzG(paramT, l));
        break;
      case 52: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = Float.floatToIntBits(zzE(paramT, l));
        break;
      case 51: 
        m = k;
        if (!zzM(paramT, n, j)) {
          break label1413;
        }
        m = k * 53;
        k = zzkl.zze(Double.doubleToLongBits(zzD(paramT, l)));
        break;
      case 50: 
        m = k * 53;
        k = zzmr.zzn(paramT, l).hashCode();
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
        m = k * 53;
        k = zzmr.zzn(paramT, l).hashCode();
        break;
      case 17: 
        localObject = zzmr.zzn(paramT, l);
        if (localObject != null) {
          m = localObject.hashCode();
        }
        break;
      case 16: 
        m = k * 53;
        k = zzkl.zze(zzmr.zzf(paramT, l));
        break;
      case 15: 
        m = k * 53;
        k = zzmr.zzd(paramT, l);
        break;
      case 14: 
        m = k * 53;
        k = zzkl.zze(zzmr.zzf(paramT, l));
        break;
      case 13: 
        m = k * 53;
        k = zzmr.zzd(paramT, l);
        break;
      case 12: 
        m = k * 53;
        k = zzmr.zzd(paramT, l);
        break;
      case 11: 
        m = k * 53;
        k = zzmr.zzd(paramT, l);
        break;
      case 10: 
        m = k * 53;
        k = zzmr.zzn(paramT, l).hashCode();
        break;
      case 9: 
        localObject = zzmr.zzn(paramT, l);
        if (localObject != null) {
          m = localObject.hashCode();
        }
        m = k * 53 + m;
        break;
      case 8: 
        m = k * 53;
        k = ((String)zzmr.zzn(paramT, l)).hashCode();
        break;
      case 7: 
        m = k * 53;
        k = zzkl.zzf(zzmr.zzh(paramT, l));
        break;
      case 6: 
        m = k * 53;
        k = zzmr.zzd(paramT, l);
        break;
      case 5: 
        m = k * 53;
        k = zzkl.zze(zzmr.zzf(paramT, l));
        break;
      case 4: 
        m = k * 53;
        k = zzmr.zzd(paramT, l);
        break;
      case 3: 
        m = k * 53;
        k = zzkl.zze(zzmr.zzf(paramT, l));
        break;
      case 2: 
        m = k * 53;
        k = zzkl.zze(zzmr.zzf(paramT, l));
        break;
      case 1: 
        m = k * 53;
        k = Float.floatToIntBits(zzmr.zzj(paramT, l));
        break;
      }
      m = k * 53;
      k = zzkl.zze(Double.doubleToLongBits(zzmr.zzl(paramT, l)));
      m += k;
      label1413:
      j += 3;
    }
    int m = this.zzn.zzd(paramT).hashCode();
    if (!this.zzh) {
      return k * 53 + m;
    }
    this.zzo.zzb(paramT);
    throw null;
  }
  
  public final void zzd(T paramT1, T paramT2)
  {
    Objects.requireNonNull(paramT2);
    for (int i = 0; i < this.zzc.length; i += 3)
    {
      int j = zzA(i);
      long l = 0xFFFFF & j;
      int k = this.zzc[i];
      switch (zzC(j))
      {
      default: 
        break;
      case 68: 
        zzp(paramT1, paramT2, i);
        break;
      case 61: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
        if (zzM(paramT2, k, i))
        {
          zzmr.zzo(paramT1, l, zzmr.zzn(paramT2, l));
          zzN(paramT1, k, i);
        }
        break;
      case 60: 
        zzp(paramT1, paramT2, i);
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
        if (zzM(paramT2, k, i))
        {
          zzmr.zzo(paramT1, l, zzmr.zzn(paramT2, l));
          zzN(paramT1, k, i);
        }
        break;
      case 50: 
        zzlv.zzI(this.zzq, paramT1, paramT2, l);
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
        this.zzm.zzb(paramT1, paramT2, l);
        break;
      case 17: 
        zzo(paramT1, paramT2, i);
        break;
      case 16: 
        if (zzK(paramT2, i))
        {
          zzmr.zzg(paramT1, l, zzmr.zzf(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 15: 
        if (zzK(paramT2, i))
        {
          zzmr.zze(paramT1, l, zzmr.zzd(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 14: 
        if (zzK(paramT2, i))
        {
          zzmr.zzg(paramT1, l, zzmr.zzf(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 13: 
        if (zzK(paramT2, i))
        {
          zzmr.zze(paramT1, l, zzmr.zzd(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 12: 
        if (zzK(paramT2, i))
        {
          zzmr.zze(paramT1, l, zzmr.zzd(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 11: 
        if (zzK(paramT2, i))
        {
          zzmr.zze(paramT1, l, zzmr.zzd(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 10: 
        if (zzK(paramT2, i))
        {
          zzmr.zzo(paramT1, l, zzmr.zzn(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 9: 
        zzo(paramT1, paramT2, i);
        break;
      case 8: 
        if (zzK(paramT2, i))
        {
          zzmr.zzo(paramT1, l, zzmr.zzn(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 7: 
        if (zzK(paramT2, i))
        {
          zzmr.zzi(paramT1, l, zzmr.zzh(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 6: 
        if (zzK(paramT2, i))
        {
          zzmr.zze(paramT1, l, zzmr.zzd(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 5: 
        if (zzK(paramT2, i))
        {
          zzmr.zzg(paramT1, l, zzmr.zzf(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 4: 
        if (zzK(paramT2, i))
        {
          zzmr.zze(paramT1, l, zzmr.zzd(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 3: 
        if (zzK(paramT2, i))
        {
          zzmr.zzg(paramT1, l, zzmr.zzf(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 2: 
        if (zzK(paramT2, i))
        {
          zzmr.zzg(paramT1, l, zzmr.zzf(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 1: 
        if (zzK(paramT2, i))
        {
          zzmr.zzk(paramT1, l, zzmr.zzj(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      case 0: 
        if (zzK(paramT2, i))
        {
          zzmr.zzm(paramT1, l, zzmr.zzl(paramT2, l));
          zzL(paramT1, i);
        }
        break;
      }
    }
    zzlv.zzF(this.zzn, paramT1, paramT2);
    if (this.zzh) {
      zzlv.zzE(this.zzo, paramT1, paramT2);
    }
  }
  
  public final int zze(T paramT)
  {
    int i;
    if (this.zzi) {
      i = zzr(paramT);
    } else {
      i = zzq(paramT);
    }
    return i;
  }
  
  final int zzg(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, zzir paramzzir)
    throws IOException
  {
    Object localObject1 = paramT;
    int i = paramInt2;
    int j = paramInt3;
    Object localObject2 = paramzzir;
    Unsafe localUnsafe = zzb;
    int k = paramInt1;
    int m = 0;
    int n = -1;
    int i1 = 0;
    paramInt1 = 0;
    int i2 = 1048575;
    Object localObject4;
    for (;;)
    {
      Object localObject3 = paramArrayOfByte;
      localObject4 = this;
      if (k >= i) {
        break;
      }
      i3 = k + 1;
      k = localObject3[k];
      if (k < 0)
      {
        i3 = zzis.zzb(k, (byte[])localObject3, i3, (zzir)localObject2);
        k = ((zzir)localObject2).zza;
      }
      int i4 = k >>> 3;
      int i5 = k & 0x7;
      if (i4 > n) {
        m = ((zzll)localObject4).zzP(i4, i1 / 3);
      } else {
        m = ((zzll)localObject4).zzO(i4);
      }
      if (m == -1)
      {
        m = paramInt1;
        paramInt1 = j;
        j = 0;
      }
      else
      {
        n = localObject4.zzc[(m + 1)];
        i1 = zzC(n);
        long l = n & 0xFFFFF;
        if (i1 <= 17)
        {
          j = localObject4.zzc[(m + 2)];
          i6 = 1 << (j >>> 20);
          j &= 0xFFFFF;
          if (j != i2)
          {
            if (i2 != 1048575) {
              localUnsafe.putInt(localObject1, i2, paramInt1);
            }
            paramInt1 = localUnsafe.getInt(localObject1, j);
            i2 = j;
            j = paramInt1;
          }
          else
          {
            j = paramInt1;
          }
          switch (i1)
          {
          default: 
            if (i5 != 3) {
              break;
            }
            paramInt1 = zzis.zzj(((zzll)localObject4).zzv(m), paramArrayOfByte, i3, paramInt2, i4 << 3 | 0x4, paramzzir);
            if ((j & i6) != 0) {
              break label1020;
            }
            localUnsafe.putObject(localObject1, l, ((zzir)localObject2).zzc);
            break;
          case 16: 
            if (i5 == 0)
            {
              paramInt1 = zzis.zzc(paramArrayOfByte, i3, (zzir)localObject2);
              localUnsafe.putLong(paramT, l, zzjg.zzc(((zzir)localObject2).zzb));
            }
            break;
          case 15: 
            if (i5 == 0)
            {
              paramInt1 = zzis.zza(paramArrayOfByte, i3, (zzir)localObject2);
              localUnsafe.putInt(localObject1, l, zzjg.zzb(((zzir)localObject2).zza));
            }
            break;
          case 12: 
            i1 = m;
            n = k;
            if (i5 == 0)
            {
              paramInt1 = zzis.zza(paramArrayOfByte, i3, (zzir)localObject2);
              i3 = ((zzir)localObject2).zza;
              localObject4 = ((zzll)localObject4).zzx(i1);
              if ((localObject4 != null) && (!((zzkh)localObject4).zza(i3)))
              {
                zzf(paramT).zzh(n, Long.valueOf(i3));
                m = n;
                k = paramInt1;
                paramInt1 = j;
                break label1220;
              }
              localUnsafe.putInt(localObject1, l, i3);
            }
            break;
          case 10: 
            if (i5 == 2)
            {
              paramInt1 = zzis.zzh(paramArrayOfByte, i3, (zzir)localObject2);
              localUnsafe.putObject(localObject1, l, ((zzir)localObject2).zzc);
            }
            break;
          case 9: 
            if (i5 == 2)
            {
              paramInt1 = zzis.zzi(((zzll)localObject4).zzv(m), paramArrayOfByte, i3, i, (zzir)localObject2);
              if ((j & i6) == 0) {
                localUnsafe.putObject(localObject1, l, ((zzir)localObject2).zzc);
              } else {
                localUnsafe.putObject(localObject1, l, zzkl.zzi(localUnsafe.getObject(localObject1, l), ((zzir)localObject2).zzc));
              }
            }
            break;
          case 8: 
            localObject4 = paramArrayOfByte;
            if (i5 == 2)
            {
              if ((n & 0x20000000) == 0) {
                paramInt1 = zzis.zzf((byte[])localObject4, i3, (zzir)localObject2);
              } else {
                paramInt1 = zzis.zzg((byte[])localObject4, i3, (zzir)localObject2);
              }
              localUnsafe.putObject(localObject1, l, ((zzir)localObject2).zzc);
            }
            break;
          case 7: 
            if (i5 == 0)
            {
              paramInt1 = zzis.zzc(paramArrayOfByte, i3, (zzir)localObject2);
              boolean bool;
              if (((zzir)localObject2).zzb != 0L) {
                bool = true;
              } else {
                bool = false;
              }
              zzmr.zzi(localObject1, l, bool);
            }
            break;
          case 6: 
          case 13: 
            if (i5 == 5)
            {
              localUnsafe.putInt(localObject1, l, zzis.zzd(paramArrayOfByte, i3));
              paramInt1 = i3 + 4;
            }
            break;
          case 5: 
          case 14: 
            if (i5 == 1)
            {
              localUnsafe.putLong(paramT, l, zzis.zze(paramArrayOfByte, i3));
              paramInt1 = i3 + 8;
              break label984;
            }
            break;
          case 4: 
          case 11: 
            if (i5 != 0) {
              break;
            }
            paramInt1 = zzis.zza(paramArrayOfByte, i3, (zzir)localObject2);
            localUnsafe.putInt(localObject1, l, ((zzir)localObject2).zza);
            break;
          case 2: 
          case 3: 
            if (i5 != 0) {
              break;
            }
            paramInt1 = zzis.zzc(paramArrayOfByte, i3, (zzir)localObject2);
            localUnsafe.putLong(paramT, l, ((zzir)localObject2).zzb);
            j |= i6;
            i3 = i2;
            i2 = j;
            break;
          case 1: 
            paramInt1 = i3;
            if (i5 != 5) {
              break;
            }
            zzmr.zzk(localObject1, l, Float.intBitsToFloat(zzis.zzd(paramArrayOfByte, paramInt1)));
            paramInt1 += 4;
            break;
          }
          paramInt1 = i3;
          if (i5 == 1)
          {
            zzmr.zzm(localObject1, l, Double.longBitsToDouble(zzis.zze(paramArrayOfByte, paramInt1)));
            paramInt1 += 8;
            label984:
            j |= i6;
            i3 = i2;
            for (i2 = j;; i2 = j)
            {
              i1 = m;
              m = k;
              k = paramInt1;
              paramInt1 = i2;
              i2 = i3;
              break;
              label1020:
              localUnsafe.putObject(localObject1, l, zzkl.zzi(localUnsafe.getObject(localObject1, l), ((zzir)localObject2).zzc));
              j |= i6;
              i3 = i2;
              i = paramInt2;
            }
          }
          paramInt1 = paramInt3;
          i = j;
          j = m;
          m = i;
        }
        else
        {
          if (i1 == 27)
          {
            if (i5 == 2)
            {
              zzkk localzzkk = (zzkk)localUnsafe.getObject(localObject1, l);
              localObject3 = localzzkk;
              if (!localzzkk.zza())
              {
                j = localzzkk.size();
                if (j == 0) {
                  j = 10;
                } else {
                  j += j;
                }
                localObject3 = localzzkk.zze(j);
                localUnsafe.putObject(localObject1, l, localObject3);
              }
              localObject4 = ((zzll)localObject4).zzv(m);
              i3 = zzis.zzm((zzlt)localObject4, k, paramArrayOfByte, i3, paramInt2, (zzkk)localObject3, paramzzir);
              i = paramInt2;
              i1 = m;
              m = k;
              k = i3;
              label1220:
              n = i4;
              j = paramInt3;
              continue;
            }
          }
          else if (i1 <= 49)
          {
            i = zzs(paramT, paramArrayOfByte, i3, paramInt2, k, i4, i5, m, n, i1, l, paramzzir);
            j = i;
            if (i != i3) {
              i3 = i;
            }
          }
          for (;;)
          {
            localObject1 = paramT;
            n = i4;
            i = paramInt2;
            j = paramInt3;
            localObject2 = paramzzir;
            i1 = m;
            m = k;
            k = i3;
            break;
            label1396:
            do
            {
              do
              {
                i3 = j;
                break;
                i = i3;
                j = m;
                if (i1 != 50) {
                  break label1396;
                }
                if (i5 != 2) {
                  break;
                }
                i3 = zzt(paramT, paramArrayOfByte, i, paramInt2, j, l, paramzzir);
                j = i3;
              } while (i3 == i);
              break;
              i = paramInt1;
              paramInt1 = paramInt3;
              j = m;
              m = i;
              break label1438;
              i3 = zzu(paramT, paramArrayOfByte, i, paramInt2, k, i4, i5, n, i1, l, j, paramzzir);
              j = i3;
            } while (i3 == i);
          }
        }
      }
      label1438:
      n = i4;
      if ((k == paramInt1) && (paramInt1 != 0))
      {
        paramzzir = this;
        paramArrayOfByte = paramT;
        paramInt3 = k;
        j = m;
        k = i3;
        m = paramInt3;
        i3 = j;
        paramInt3 = paramInt1;
        paramT = paramzzir;
        break label1631;
      }
      if (this.zzh)
      {
        localObject1 = paramzzir;
        if (((zzir)localObject1).zzd != zzjp.zza())
        {
          localObject2 = this.zzg;
          if (((zzir)localObject1).zzd.zzc((zzli)localObject2, n) == null)
          {
            i3 = zzis.zzn(k, paramArrayOfByte, i3, paramInt2, zzf(paramT), paramzzir);
            break label1578;
          }
          paramT = (zzka)paramT;
          throw null;
        }
      }
      i3 = zzis.zzn(k, paramArrayOfByte, i3, paramInt2, zzf(paramT), paramzzir);
      label1578:
      i = paramInt2;
      int i6 = k;
      localObject2 = paramzzir;
      localObject1 = paramT;
      i1 = j;
      i4 = m;
      j = paramInt1;
      k = i3;
      m = i6;
      paramInt1 = i4;
    }
    paramInt3 = j;
    paramArrayOfByte = (byte[])localObject1;
    paramT = (T)localObject4;
    int i3 = paramInt1;
    label1631:
    if (i2 != 1048575) {
      localUnsafe.putInt(paramArrayOfByte, i2, i3);
    }
    paramInt1 = paramT.zzk;
    while (paramInt1 < paramT.zzl)
    {
      i2 = paramT.zzj[paramInt1];
      i3 = paramT.zzc[i2];
      paramzzir = zzmr.zzn(paramArrayOfByte, paramT.zzA(i2) & 0xFFFFF);
      if ((paramzzir == null) || (paramT.zzx(i2) == null))
      {
        paramInt1++;
      }
      else
      {
        paramArrayOfByte = (zzlc)paramzzir;
        paramT = (zzlb)paramT.zzw(i2);
        throw null;
      }
    }
    if (paramInt3 == 0)
    {
      if (k != paramInt2) {
        throw zzkn.zze();
      }
    }
    else {
      if ((k > paramInt2) || (m != paramInt3)) {
        break label1772;
      }
    }
    return k;
    label1772:
    throw zzkn.zze();
  }
  
  public final void zzh(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzir paramzzir)
    throws IOException
  {
    if (this.zzi)
    {
      zzy(paramT, paramArrayOfByte, paramInt1, paramInt2, paramzzir);
      return;
    }
    zzg(paramT, paramArrayOfByte, paramInt1, paramInt2, 0, paramzzir);
  }
  
  public final void zzi(T paramT)
  {
    int j;
    for (int i = this.zzk;; i++)
    {
      j = this.zzl;
      if (i >= j) {
        break;
      }
      long l = zzA(this.zzj[i]) & 0xFFFFF;
      Object localObject = zzmr.zzn(paramT, l);
      if (localObject != null)
      {
        ((zzlc)localObject).zzd();
        zzmr.zzo(paramT, l, localObject);
      }
    }
    int k = this.zzj.length;
    for (i = j; i < k; i++) {
      this.zzm.zza(paramT, this.zzj[i]);
    }
    this.zzn.zze(paramT);
    if (this.zzh) {
      this.zzo.zzc(paramT);
    }
  }
  
  public final boolean zzj(T paramT)
  {
    int i = 1048575;
    int j = 0;
    for (int k = 0; k < this.zzk; k++)
    {
      int m = this.zzj[k];
      int n = this.zzc[m];
      int i1 = zzA(m);
      int i2 = this.zzc[(m + 2)];
      int i3 = i2 & 0xFFFFF;
      i2 = 1 << (i2 >>> 20);
      if (i3 != i)
      {
        if (i3 != 1048575) {
          j = zzb.getInt(paramT, i3);
        }
        i = i3;
      }
      if (((0x10000000 & i1) != 0) && (!zzJ(paramT, m, i, j, i2))) {
        return false;
      }
      i3 = zzC(i1);
      List localList;
      zzlt localzzlt;
      if ((i3 != 9) && (i3 != 17))
      {
        if (i3 != 27) {
          if ((i3 != 60) && (i3 != 68))
          {
            if (i3 != 49)
            {
              if ((i3 != 50) || (((zzlc)zzmr.zzn(paramT, i1 & 0xFFFFF)).isEmpty())) {
                continue;
              }
              paramT = (zzlb)zzw(m);
              throw null;
            }
          }
          else
          {
            if ((!zzM(paramT, n, m)) || (zzz(paramT, i1, zzv(m)))) {
              continue;
            }
            return false;
          }
        }
        localList = (List)zzmr.zzn(paramT, i1 & 0xFFFFF);
        if (!localList.isEmpty())
        {
          localzzlt = zzv(m);
          i3 = 0;
        }
      }
      else
      {
        while (i3 < localList.size())
        {
          if (!localzzlt.zzj(localList.get(i3))) {
            return false;
          }
          i3++;
          continue;
          if ((zzJ(paramT, m, i, j, i2)) && (!zzz(paramT, i1, zzv(m)))) {
            return false;
          }
        }
      }
    }
    if (!this.zzh) {
      return true;
    }
    this.zzo.zzb(paramT);
    throw null;
  }
  
  public final void zzm(T paramT, zzjl paramzzjl)
    throws IOException
  {
    if (this.zzi)
    {
      if (!this.zzh)
      {
        int i = this.zzc.length;
        for (int j = 0; j < i; j += 3)
        {
          int k = zzA(j);
          int m = this.zzc[j];
          switch (zzC(k))
          {
          default: 
            break;
          case 68: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzs(m, zzmr.zzn(paramT, k & 0xFFFFF), zzv(j));
            }
            break;
          case 67: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzq(m, zzG(paramT, k & 0xFFFFF));
            }
            break;
          case 66: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzp(m, zzF(paramT, k & 0xFFFFF));
            }
            break;
          case 65: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzd(m, zzG(paramT, k & 0xFFFFF));
            }
            break;
          case 64: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzb(m, zzF(paramT, k & 0xFFFFF));
            }
            break;
          case 63: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzg(m, zzF(paramT, k & 0xFFFFF));
            }
            break;
          case 62: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzo(m, zzF(paramT, k & 0xFFFFF));
            }
            break;
          case 61: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzn(m, (zzjd)zzmr.zzn(paramT, k & 0xFFFFF));
            }
            break;
          case 60: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzr(m, zzmr.zzn(paramT, k & 0xFFFFF), zzv(j));
            }
            break;
          case 59: 
            if (zzM(paramT, m, j)) {
              zzT(m, zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl);
            }
            break;
          case 58: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzl(m, zzH(paramT, k & 0xFFFFF));
            }
            break;
          case 57: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzk(m, zzF(paramT, k & 0xFFFFF));
            }
            break;
          case 56: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzj(m, zzG(paramT, k & 0xFFFFF));
            }
            break;
          case 55: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzi(m, zzF(paramT, k & 0xFFFFF));
            }
            break;
          case 54: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzh(m, zzG(paramT, k & 0xFFFFF));
            }
            break;
          case 53: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzc(m, zzG(paramT, k & 0xFFFFF));
            }
            break;
          case 52: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zze(m, zzE(paramT, k & 0xFFFFF));
            }
            break;
          case 51: 
            if (zzM(paramT, m, j)) {
              paramzzjl.zzf(m, zzD(paramT, k & 0xFFFFF));
            }
            break;
          case 50: 
            zzS(paramzzjl, m, zzmr.zzn(paramT, k & 0xFFFFF), j);
            break;
          case 49: 
            zzlv.zzaa(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, zzv(j));
            break;
          case 48: 
            zzlv.zzN(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 47: 
            zzlv.zzS(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 46: 
            zzlv.zzP(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 45: 
            zzlv.zzU(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 44: 
            zzlv.zzV(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 43: 
            zzlv.zzR(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 42: 
            zzlv.zzW(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 41: 
            zzlv.zzT(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 40: 
            zzlv.zzO(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 39: 
            zzlv.zzQ(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 38: 
            zzlv.zzM(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 37: 
            zzlv.zzL(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 36: 
            zzlv.zzK(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 35: 
            zzlv.zzJ(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, true);
            break;
          case 34: 
            zzlv.zzN(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 33: 
            zzlv.zzS(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 32: 
            zzlv.zzP(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 31: 
            zzlv.zzU(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 30: 
            zzlv.zzV(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 29: 
            zzlv.zzR(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 28: 
            zzlv.zzY(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl);
            break;
          case 27: 
            zzlv.zzZ(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, zzv(j));
            break;
          case 26: 
            zzlv.zzX(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl);
            break;
          case 25: 
            zzlv.zzW(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 24: 
            zzlv.zzT(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 23: 
            zzlv.zzO(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 22: 
            zzlv.zzQ(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 21: 
            zzlv.zzM(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 20: 
            zzlv.zzL(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 19: 
            zzlv.zzK(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 18: 
            zzlv.zzJ(this.zzc[j], (List)zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl, false);
            break;
          case 17: 
            if (zzK(paramT, j)) {
              paramzzjl.zzs(m, zzmr.zzn(paramT, k & 0xFFFFF), zzv(j));
            }
            break;
          case 16: 
            if (zzK(paramT, j)) {
              paramzzjl.zzq(m, zzmr.zzf(paramT, k & 0xFFFFF));
            }
            break;
          case 15: 
            if (zzK(paramT, j)) {
              paramzzjl.zzp(m, zzmr.zzd(paramT, k & 0xFFFFF));
            }
            break;
          case 14: 
            if (zzK(paramT, j)) {
              paramzzjl.zzd(m, zzmr.zzf(paramT, k & 0xFFFFF));
            }
            break;
          case 13: 
            if (zzK(paramT, j)) {
              paramzzjl.zzb(m, zzmr.zzd(paramT, k & 0xFFFFF));
            }
            break;
          case 12: 
            if (zzK(paramT, j)) {
              paramzzjl.zzg(m, zzmr.zzd(paramT, k & 0xFFFFF));
            }
            break;
          case 11: 
            if (zzK(paramT, j)) {
              paramzzjl.zzo(m, zzmr.zzd(paramT, k & 0xFFFFF));
            }
            break;
          case 10: 
            if (zzK(paramT, j)) {
              paramzzjl.zzn(m, (zzjd)zzmr.zzn(paramT, k & 0xFFFFF));
            }
            break;
          case 9: 
            if (zzK(paramT, j)) {
              paramzzjl.zzr(m, zzmr.zzn(paramT, k & 0xFFFFF), zzv(j));
            }
            break;
          case 8: 
            if (zzK(paramT, j)) {
              zzT(m, zzmr.zzn(paramT, k & 0xFFFFF), paramzzjl);
            }
            break;
          case 7: 
            if (zzK(paramT, j)) {
              paramzzjl.zzl(m, zzmr.zzh(paramT, k & 0xFFFFF));
            }
            break;
          case 6: 
            if (zzK(paramT, j)) {
              paramzzjl.zzk(m, zzmr.zzd(paramT, k & 0xFFFFF));
            }
            break;
          case 5: 
            if (zzK(paramT, j)) {
              paramzzjl.zzj(m, zzmr.zzf(paramT, k & 0xFFFFF));
            }
            break;
          case 4: 
            if (zzK(paramT, j)) {
              paramzzjl.zzi(m, zzmr.zzd(paramT, k & 0xFFFFF));
            }
            break;
          case 3: 
            if (zzK(paramT, j)) {
              paramzzjl.zzh(m, zzmr.zzf(paramT, k & 0xFFFFF));
            }
            break;
          case 2: 
            if (zzK(paramT, j)) {
              paramzzjl.zzc(m, zzmr.zzf(paramT, k & 0xFFFFF));
            }
            break;
          case 1: 
            if (zzK(paramT, j)) {
              paramzzjl.zze(m, zzmr.zzj(paramT, k & 0xFFFFF));
            }
            break;
          case 0: 
            if (zzK(paramT, j)) {
              paramzzjl.zzf(m, zzmr.zzl(paramT, k & 0xFFFFF));
            }
            break;
          }
        }
        zzmh localzzmh = this.zzn;
        localzzmh.zzi(localzzmh.zzd(paramT), paramzzjl);
        return;
      }
      this.zzo.zzb(paramT);
      throw null;
    }
    zzR(paramT, paramzzjl);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */