package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import sun.misc.Unsafe;

final class zzds<T>
  implements zzef<T>
{
  private static final Unsafe zzmh = ;
  private final int[] zzmi;
  private final Object[] zzmj;
  private final int zzmk;
  private final int zzml;
  private final int zzmm;
  private final zzdo zzmn;
  private final boolean zzmo;
  private final boolean zzmp;
  private final boolean zzmq;
  private final boolean zzmr;
  private final int[] zzms;
  private final int[] zzmt;
  private final int[] zzmu;
  private final zzdw zzmv;
  private final zzcy zzmw;
  private final zzex<?, ?> zzmx;
  private final zzbu<?> zzmy;
  private final zzdj zzmz;
  
  private zzds(int[] paramArrayOfInt1, Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3, zzdo paramzzdo, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, zzdw paramzzdw, zzcy paramzzcy, zzex<?, ?> paramzzex, zzbu<?> paramzzbu, zzdj paramzzdj)
  {
    this.zzmi = paramArrayOfInt1;
    this.zzmj = paramArrayOfObject;
    this.zzmk = paramInt1;
    this.zzml = paramInt2;
    this.zzmm = paramInt3;
    this.zzmp = (paramzzdo instanceof zzcg);
    this.zzmq = paramBoolean1;
    if ((paramzzbu != null) && (paramzzbu.zze(paramzzdo))) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.zzmo = paramBoolean1;
    this.zzmr = false;
    this.zzms = paramArrayOfInt2;
    this.zzmt = paramArrayOfInt3;
    this.zzmu = paramArrayOfInt4;
    this.zzmv = paramzzdw;
    this.zzmw = paramzzcy;
    this.zzmx = paramzzex;
    this.zzmy = paramzzbu;
    this.zzmn = paramzzdo;
    this.zzmz = paramzzdj;
  }
  
  private static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Object paramObject, zzay paramzzay)
    throws IOException
  {
    return zzax.zza(paramInt1, paramArrayOfByte, paramInt2, paramInt3, zzn(paramObject), paramzzay);
  }
  
  private static int zza(zzef<?> paramzzef, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzcn<?> paramzzcn, zzay paramzzay)
    throws IOException
  {
    int i;
    for (paramInt2 = zza(paramzzef, paramArrayOfByte, paramInt2, paramInt3, paramzzay);; paramInt2 = zza(paramzzef, paramArrayOfByte, i, paramInt3, paramzzay))
    {
      paramzzcn.add(paramzzay.zzff);
      if (paramInt2 >= paramInt3) {
        break;
      }
      i = zzax.zza(paramArrayOfByte, paramInt2, paramzzay);
      if (paramInt1 != paramzzay.zzfd) {
        break;
      }
    }
    return paramInt2;
  }
  
  private static int zza(zzef paramzzef, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, zzay paramzzay)
    throws IOException
  {
    paramzzef = (zzds)paramzzef;
    Object localObject = paramzzef.newInstance();
    paramInt1 = paramzzef.zza(localObject, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramzzay);
    paramzzef.zzc(localObject);
    paramzzay.zzff = localObject;
    return paramInt1;
  }
  
  private static int zza(zzef paramzzef, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzay paramzzay)
    throws IOException
  {
    int i = paramInt1 + 1;
    int j = paramArrayOfByte[paramInt1];
    paramInt1 = i;
    int k = j;
    if (j < 0)
    {
      paramInt1 = zzax.zza(j, paramArrayOfByte, i, paramzzay);
      k = paramzzay.zzfd;
    }
    if ((k >= 0) && (k <= paramInt2 - paramInt1))
    {
      Object localObject = paramzzef.newInstance();
      paramInt2 = k + paramInt1;
      paramzzef.zza(localObject, paramArrayOfByte, paramInt1, paramInt2, paramzzay);
      paramzzef.zzc(localObject);
      paramzzay.zzff = localObject;
      return paramInt2;
    }
    throw zzco.zzbl();
  }
  
  private static <UT, UB> int zza(zzex<UT, UB> paramzzex, T paramT)
  {
    return paramzzex.zzm(paramzzex.zzq(paramT));
  }
  
  private final int zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong, int paramInt8, zzay paramzzay)
    throws IOException
  {
    Unsafe localUnsafe = zzmh;
    long l1 = this.zzmi[(paramInt8 + 2)] & 0xFFFFF;
    long l2;
    switch (paramInt7)
    {
    default: 
      break;
    case 68: 
      if (paramInt5 != 3) {
        return paramInt1;
      }
      paramInt1 = zza(zzad(paramInt8), paramArrayOfByte, paramInt1, paramInt2, paramInt3 & 0xFFFFFFF8 | 0x4, paramzzay);
      if (localUnsafe.getInt(paramT, l1) == paramInt4) {
        paramArrayOfByte = localUnsafe.getObject(paramT, paramLong);
      } else {
        paramArrayOfByte = null;
      }
      paramzzay = paramzzay.zzff;
      if (paramArrayOfByte == null) {
        paramArrayOfByte = paramzzay;
      } else {
        paramArrayOfByte = zzci.zza(paramArrayOfByte, paramzzay);
      }
      break;
    case 67: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzax.zzb(paramArrayOfByte, paramInt1, paramzzay);
      l2 = zzbk.zza(paramzzay.zzfe);
      break;
    case 66: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
      paramInt2 = zzbk.zzm(paramzzay.zzfd);
      break;
    case 63: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
      paramInt2 = paramzzay.zzfd;
      paramArrayOfByte = zzaf(paramInt8);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.zzb(paramInt2) == null))
      {
        zzn(paramT).zzb(paramInt3, Long.valueOf(paramInt2));
        return paramInt1;
      }
      localUnsafe.putObject(paramT, paramLong, Integer.valueOf(paramInt2));
      break;
    case 61: 
      if (paramInt5 != 2) {
        return paramInt1;
      }
      paramInt1 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
      paramInt2 = paramzzay.zzfd;
      if (paramInt2 == 0) {
        paramArrayOfByte = zzbb.zzfi;
      } else {
        localUnsafe.putObject(paramT, paramLong, zzbb.zzb(paramArrayOfByte, paramInt1, paramInt2));
      }
    case 60: 
    case 59: 
      for (;;)
      {
        paramInt1 += paramInt2;
        break label742;
        if (paramInt5 != 2) {
          return paramInt1;
        }
        paramInt1 = zza(zzad(paramInt8), paramArrayOfByte, paramInt1, paramInt2, paramzzay);
        if (localUnsafe.getInt(paramT, l1) == paramInt4) {
          paramArrayOfByte = localUnsafe.getObject(paramT, paramLong);
        } else {
          paramArrayOfByte = null;
        }
        paramzzay = paramzzay.zzff;
        if (paramArrayOfByte == null)
        {
          paramArrayOfByte = paramzzay;
          break;
        }
        paramArrayOfByte = zzci.zza(paramArrayOfByte, paramzzay);
        break;
        if (paramInt5 != 2) {
          return paramInt1;
        }
        paramInt1 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
        paramInt2 = paramzzay.zzfd;
        if (paramInt2 == 0)
        {
          paramArrayOfByte = "";
          break;
        }
        if (((paramInt6 & 0x20000000) != 0) && (!zzff.zze(paramArrayOfByte, paramInt1, paramInt1 + paramInt2))) {
          throw zzco.zzbp();
        }
        localUnsafe.putObject(paramT, paramLong, new String(paramArrayOfByte, paramInt1, paramInt2, zzci.UTF_8));
      }
    case 58: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzax.zzb(paramArrayOfByte, paramInt1, paramzzay);
      boolean bool;
      if (paramzzay.zzfe != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      paramArrayOfByte = Boolean.valueOf(bool);
      break;
    case 57: 
    case 64: 
      if (paramInt5 != 5) {
        return paramInt1;
      }
      paramArrayOfByte = Integer.valueOf(zzax.zzc(paramArrayOfByte, paramInt1));
      break;
    case 56: 
    case 65: 
      if (paramInt5 != 1) {
        return paramInt1;
      }
      paramArrayOfByte = Long.valueOf(zzax.zzd(paramArrayOfByte, paramInt1));
      break;
    case 55: 
    case 62: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
      paramInt2 = paramzzay.zzfd;
      paramArrayOfByte = Integer.valueOf(paramInt2);
      break;
    case 53: 
    case 54: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzax.zzb(paramArrayOfByte, paramInt1, paramzzay);
      l2 = paramzzay.zzfe;
      paramArrayOfByte = Long.valueOf(l2);
      localUnsafe.putObject(paramT, paramLong, paramArrayOfByte);
      break;
    case 52: 
      if (paramInt5 != 5) {
        return paramInt1;
      }
      paramArrayOfByte = Float.valueOf(zzax.zzf(paramArrayOfByte, paramInt1));
      localUnsafe.putObject(paramT, paramLong, paramArrayOfByte);
      paramInt1 += 4;
      break;
    }
    if (paramInt5 == 1)
    {
      paramArrayOfByte = Double.valueOf(zzax.zze(paramArrayOfByte, paramInt1));
      localUnsafe.putObject(paramT, paramLong, paramArrayOfByte);
      paramInt1 += 8;
      label742:
      localUnsafe.putInt(paramT, l1, paramInt4);
    }
    return paramInt1;
  }
  
  private final int zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, int paramInt7, long paramLong2, zzay paramzzay)
    throws IOException
  {
    int i = paramInt1;
    Unsafe localUnsafe = zzmh;
    Object localObject1 = (zzcn)localUnsafe.getObject(paramT, paramLong2);
    Object localObject2 = localObject1;
    if (!((zzcn)localObject1).zzu())
    {
      int j = ((List)localObject1).size();
      if (j == 0) {
        j = 10;
      } else {
        j <<= 1;
      }
      localObject2 = ((zzcn)localObject1).zzi(j);
      localUnsafe.putObject(paramT, paramLong2, localObject2);
    }
    switch (paramInt7)
    {
    default: 
      paramInt7 = i;
      break;
    case 49: 
      paramInt7 = i;
      if (paramInt5 != 3) {
        break label2214;
      }
      paramT = zzad(paramInt6);
      paramInt4 = paramInt3 & 0xFFFFFFF8 | 0x4;
      for (paramInt1 = zza(paramT, paramArrayOfByte, paramInt1, paramInt2, paramInt4, paramzzay);; paramInt1 = zza(paramT, paramArrayOfByte, paramInt5, paramInt2, paramInt4, paramzzay))
      {
        ((List)localObject2).add(paramzzay.zzff);
        paramInt7 = paramInt1;
        if (paramInt1 >= paramInt2) {
          break;
        }
        paramInt5 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
        paramInt7 = paramInt1;
        if (paramInt3 != paramzzay.zzfd) {
          break;
        }
      }
    case 34: 
    case 48: 
      if (paramInt5 == 2)
      {
        paramT = (zzdc)localObject2;
        paramInt1 = zzax.zza(paramArrayOfByte, i, paramzzay);
        paramInt2 = paramzzay.zzfd + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzax.zzb(paramArrayOfByte, paramInt1, paramzzay);
          paramT.zzm(zzbk.zza(paramzzay.zzfe));
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzco.zzbl();
      }
      paramInt7 = i;
      if (paramInt5 != 0) {
        break label2214;
      }
      paramT = (zzdc)localObject2;
      for (;;)
      {
        paramInt4 = zzax.zzb(paramArrayOfByte, i, paramzzay);
        paramT.zzm(zzbk.zza(paramzzay.zzfe));
        paramInt1 = paramInt4;
        if (paramInt4 >= paramInt2) {
          break;
        }
        i = zzax.zza(paramArrayOfByte, paramInt4, paramzzay);
        paramInt1 = paramInt4;
        if (paramInt3 != paramzzay.zzfd) {
          break;
        }
      }
    case 33: 
    case 47: 
      if (paramInt5 == 2)
      {
        paramT = (zzch)localObject2;
        paramInt1 = zzax.zza(paramArrayOfByte, i, paramzzay);
        paramInt2 = paramzzay.zzfd + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
          paramT.zzac(zzbk.zzm(paramzzay.zzfd));
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzco.zzbl();
      }
      paramInt7 = i;
      if (paramInt5 != 0) {
        break label2214;
      }
      paramT = (zzch)localObject2;
      for (;;)
      {
        paramInt4 = zzax.zza(paramArrayOfByte, i, paramzzay);
        paramT.zzac(zzbk.zzm(paramzzay.zzfd));
        paramInt1 = paramInt4;
        if (paramInt4 >= paramInt2) {
          break;
        }
        i = zzax.zza(paramArrayOfByte, paramInt4, paramzzay);
        paramInt1 = paramInt4;
        if (paramInt3 != paramzzay.zzfd) {
          break;
        }
      }
    case 30: 
    case 44: 
      if (paramInt5 == 2)
      {
        paramInt1 = zzax.zza(paramArrayOfByte, i, (zzcn)localObject2, paramzzay);
      }
      else
      {
        paramInt7 = i;
        if (paramInt5 != 0) {
          break label2214;
        }
        paramInt1 = zzax.zza(paramInt3, paramArrayOfByte, paramInt1, paramInt2, (zzcn)localObject2, paramzzay);
      }
      paramzzay = (zzcg)paramT;
      paramArrayOfByte = paramzzay.zzjp;
      paramT = paramArrayOfByte;
      if (paramArrayOfByte == zzey.zzea()) {
        paramT = null;
      }
      paramT = (zzey)zzeh.zza(paramInt4, (List)localObject2, zzaf(paramInt6), paramT, this.zzmx);
      paramInt2 = paramInt1;
      if (paramT != null)
      {
        paramzzay.zzjp = paramT;
        paramInt2 = paramInt1;
      }
    case 28: 
    case 27: 
    case 26: 
    case 25: 
    case 42: 
      boolean bool;
      do
      {
        return paramInt2;
        paramInt7 = i;
        if (paramInt5 != 2) {
          break label2214;
        }
        paramInt5 = zzax.zza(paramArrayOfByte, i, paramzzay);
        paramInt6 = paramzzay.zzfd;
        paramInt4 = paramInt5;
        paramInt1 = paramInt6;
        paramT = (T)localObject2;
        if (paramInt6 == 0) {}
        for (paramInt4 = paramInt5;; paramInt4 = paramInt5)
        {
          ((List)localObject2).add(zzbb.zzfi);
          do
          {
            paramT.add(zzbb.zzb(paramArrayOfByte, paramInt4, paramInt1));
            paramInt4 += paramInt1;
            localObject2 = paramT;
            paramInt1 = paramInt4;
            if (paramInt4 >= paramInt2) {
              break;
            }
            paramInt5 = zzax.zza(paramArrayOfByte, paramInt4, paramzzay);
            paramInt1 = paramInt4;
            if (paramInt3 != paramzzay.zzfd) {
              break;
            }
            paramInt5 = zzax.zza(paramArrayOfByte, paramInt5, paramzzay);
            paramInt6 = paramzzay.zzfd;
            paramInt4 = paramInt5;
            paramInt1 = paramInt6;
            paramT = (T)localObject2;
          } while (paramInt6 != 0);
        }
        paramInt7 = i;
        if (paramInt5 != 2) {
          break label2214;
        }
        return zza(zzad(paramInt6), paramInt3, paramArrayOfByte, paramInt1, paramInt2, (zzcn)localObject2, paramzzay);
        paramInt7 = i;
        if (paramInt5 != 2) {
          break label2214;
        }
        paramInt1 = zzax.zza(paramArrayOfByte, i, paramzzay);
        if ((paramLong1 & 0x20000000) == 0L)
        {
          paramInt4 = paramzzay.zzfd;
          if (paramInt4 == 0)
          {
            paramT = (T)localObject2;
            paramT.add("");
          }
          else
          {
            localObject1 = new String(paramArrayOfByte, paramInt1, paramInt4, zzci.UTF_8);
            paramT = (T)localObject2;
          }
          for (localObject2 = localObject1;; localObject2 = new String(paramArrayOfByte, paramInt1, paramInt4, zzci.UTF_8))
          {
            paramT.add(localObject2);
            paramInt1 += paramInt4;
            paramInt7 = paramInt1;
            if (paramInt1 >= paramInt2) {
              break label2214;
            }
            paramInt4 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
            paramInt7 = paramInt1;
            if (paramInt3 != paramzzay.zzfd) {
              break label2214;
            }
            paramInt1 = zzax.zza(paramArrayOfByte, paramInt4, paramzzay);
            paramInt4 = paramzzay.zzfd;
            if (paramInt4 == 0) {
              break;
            }
          }
        }
        paramInt5 = paramzzay.zzfd;
        if (paramInt5 == 0)
        {
          ((List)localObject2).add("");
        }
        else
        {
          paramInt4 = paramInt1 + paramInt5;
          if (!zzff.zze(paramArrayOfByte, paramInt1, paramInt4)) {
            break label1255;
          }
          paramT = new String(paramArrayOfByte, paramInt1, paramInt5, zzci.UTF_8);
        }
        for (paramInt1 = paramInt4;; paramInt1 = paramInt4)
        {
          ((List)localObject2).add(paramT);
          paramInt7 = paramInt1;
          if (paramInt1 >= paramInt2) {
            break label2214;
          }
          paramInt4 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
          paramInt7 = paramInt1;
          if (paramInt3 != paramzzay.zzfd) {
            break label2214;
          }
          paramInt1 = zzax.zza(paramArrayOfByte, paramInt4, paramzzay);
          paramInt5 = paramzzay.zzfd;
          if (paramInt5 == 0) {
            break;
          }
          paramInt4 = paramInt1 + paramInt5;
          if (!zzff.zze(paramArrayOfByte, paramInt1, paramInt4)) {
            break label1251;
          }
          paramT = new String(paramArrayOfByte, paramInt1, paramInt5, zzci.UTF_8);
        }
        throw zzco.zzbp();
        throw zzco.zzbp();
        if (paramInt5 != 2) {
          break;
        }
        paramT = (zzaz)localObject2;
        paramInt2 = zzax.zza(paramArrayOfByte, i, paramzzay);
        paramInt1 = paramzzay.zzfd + paramInt2;
        while (paramInt2 < paramInt1)
        {
          paramInt2 = zzax.zzb(paramArrayOfByte, paramInt2, paramzzay);
          if (paramzzay.zzfe != 0L) {
            bool = true;
          } else {
            bool = false;
          }
          paramT.addBoolean(bool);
        }
      } while (paramInt2 == paramInt1);
      throw zzco.zzbl();
      paramInt7 = i;
      if (paramInt5 != 0) {
        break label2214;
      }
      paramT = (zzaz)localObject2;
      paramInt4 = zzax.zzb(paramArrayOfByte, i, paramzzay);
      paramInt1 = paramInt4;
      if (paramzzay.zzfe != 0L) {}
      for (paramInt1 = paramInt4;; paramInt1 = paramInt4)
      {
        bool = true;
        do
        {
          bool = false;
          paramT.addBoolean(bool);
          paramInt7 = paramInt1;
          if (paramInt1 >= paramInt2) {
            break;
          }
          paramInt4 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
          paramInt7 = paramInt1;
          if (paramInt3 != paramzzay.zzfd) {
            break;
          }
          paramInt4 = zzax.zzb(paramArrayOfByte, paramInt4, paramzzay);
          paramInt1 = paramInt4;
        } while (paramzzay.zzfe == 0L);
      }
    case 24: 
    case 31: 
    case 41: 
    case 45: 
      if (paramInt5 == 2)
      {
        paramT = (zzch)localObject2;
        paramInt1 = zzax.zza(paramArrayOfByte, i, paramzzay);
        paramInt2 = paramzzay.zzfd + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramT.zzac(zzax.zzc(paramArrayOfByte, paramInt1));
          paramInt1 += 4;
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzco.zzbl();
      }
      paramInt7 = i;
      if (paramInt5 != 5) {
        break label2214;
      }
      paramT = (zzch)localObject2;
      paramT.zzac(zzax.zzc(paramArrayOfByte, paramInt1));
      for (;;)
      {
        paramInt4 = i + 4;
        paramInt1 = paramInt4;
        if (paramInt4 >= paramInt2) {
          break;
        }
        i = zzax.zza(paramArrayOfByte, paramInt4, paramzzay);
        paramInt1 = paramInt4;
        if (paramInt3 != paramzzay.zzfd) {
          break;
        }
        paramT.zzac(zzax.zzc(paramArrayOfByte, i));
      }
    case 23: 
    case 32: 
    case 40: 
    case 46: 
      if (paramInt5 == 2)
      {
        paramT = (zzdc)localObject2;
        paramInt1 = zzax.zza(paramArrayOfByte, i, paramzzay);
        paramInt2 = paramzzay.zzfd + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramT.zzm(zzax.zzd(paramArrayOfByte, paramInt1));
          paramInt1 += 8;
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzco.zzbl();
      }
      paramInt7 = i;
      if (paramInt5 != 1) {
        break label2214;
      }
      paramT = (zzdc)localObject2;
      paramT.zzm(zzax.zzd(paramArrayOfByte, paramInt1));
      for (;;)
      {
        paramInt4 = i + 8;
        paramInt1 = paramInt4;
        if (paramInt4 >= paramInt2) {
          break;
        }
        i = zzax.zza(paramArrayOfByte, paramInt4, paramzzay);
        paramInt1 = paramInt4;
        if (paramInt3 != paramzzay.zzfd) {
          break;
        }
        paramT.zzm(zzax.zzd(paramArrayOfByte, i));
      }
    case 22: 
    case 29: 
    case 39: 
    case 43: 
      if (paramInt5 == 2)
      {
        paramInt1 = zzax.zza(paramArrayOfByte, i, (zzcn)localObject2, paramzzay);
      }
      else
      {
        paramInt7 = i;
        if (paramInt5 == 0) {
          paramInt1 = zzax.zza(paramInt3, paramArrayOfByte, paramInt1, paramInt2, (zzcn)localObject2, paramzzay);
        }
      }
      break;
    case 20: 
    case 21: 
    case 37: 
    case 38: 
      if (paramInt5 == 2)
      {
        paramT = (zzdc)localObject2;
        paramInt1 = zzax.zza(paramArrayOfByte, i, paramzzay);
        paramInt2 = paramzzay.zzfd + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzax.zzb(paramArrayOfByte, paramInt1, paramzzay);
          paramT.zzm(paramzzay.zzfe);
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzco.zzbl();
      }
      paramInt7 = i;
      if (paramInt5 != 0) {
        break label2214;
      }
      paramT = (zzdc)localObject2;
      for (;;)
      {
        paramInt4 = zzax.zzb(paramArrayOfByte, i, paramzzay);
        paramT.zzm(paramzzay.zzfe);
        paramInt1 = paramInt4;
        if (paramInt4 >= paramInt2) {
          break;
        }
        i = zzax.zza(paramArrayOfByte, paramInt4, paramzzay);
        paramInt1 = paramInt4;
        if (paramInt3 != paramzzay.zzfd) {
          break;
        }
      }
    case 19: 
    case 36: 
      label1251:
      label1255:
      if (paramInt5 == 2)
      {
        paramT = (zzce)localObject2;
        paramInt1 = zzax.zza(paramArrayOfByte, i, paramzzay);
        paramInt2 = paramzzay.zzfd + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramT.zzc(zzax.zzf(paramArrayOfByte, paramInt1));
          paramInt1 += 4;
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzco.zzbl();
      }
      paramInt7 = i;
      if (paramInt5 != 5) {
        break label2214;
      }
      paramT = (zzce)localObject2;
      paramT.zzc(zzax.zzf(paramArrayOfByte, paramInt1));
      for (;;)
      {
        paramInt4 = i + 4;
        paramInt1 = paramInt4;
        if (paramInt4 >= paramInt2) {
          break;
        }
        i = zzax.zza(paramArrayOfByte, paramInt4, paramzzay);
        paramInt1 = paramInt4;
        if (paramInt3 != paramzzay.zzfd) {
          break;
        }
        paramT.zzc(zzax.zzf(paramArrayOfByte, i));
      }
    }
    if (paramInt5 == 2)
    {
      paramT = (zzbq)localObject2;
      paramInt1 = zzax.zza(paramArrayOfByte, i, paramzzay);
      paramInt2 = paramzzay.zzfd + paramInt1;
      while (paramInt1 < paramInt2)
      {
        paramT.zzc(zzax.zze(paramArrayOfByte, paramInt1));
        paramInt1 += 8;
      }
      if (paramInt1 != paramInt2) {
        throw zzco.zzbl();
      }
    }
    else
    {
      paramInt7 = i;
      if (paramInt5 == 1)
      {
        paramT = (zzbq)localObject2;
        paramT.zzc(zzax.zze(paramArrayOfByte, paramInt1));
        for (;;)
        {
          paramInt4 = i + 8;
          paramInt1 = paramInt4;
          if (paramInt4 >= paramInt2) {
            break;
          }
          i = zzax.zza(paramArrayOfByte, paramInt4, paramzzay);
          paramInt1 = paramInt4;
          if (paramInt3 != paramzzay.zzfd) {
            break;
          }
          paramT.zzc(zzax.zze(paramArrayOfByte, i));
        }
      }
      label2214:
      paramInt1 = paramInt7;
    }
    return paramInt1;
  }
  
  private final <K, V> int zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, zzay paramzzay)
    throws IOException
  {
    Unsafe localUnsafe = zzmh;
    Object localObject1 = zzae(paramInt3);
    Object localObject2 = localUnsafe.getObject(paramT, paramLong);
    Object localObject3 = localObject2;
    if (this.zzmz.zzi(localObject2))
    {
      localObject3 = this.zzmz.zzk(localObject1);
      this.zzmz.zzb(localObject3, localObject2);
      localUnsafe.putObject(paramT, paramLong, localObject3);
    }
    localObject2 = this.zzmz.zzl(localObject1);
    localObject1 = this.zzmz.zzg(localObject3);
    paramInt1 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
    paramInt3 = paramzzay.zzfd;
    if ((paramInt3 >= 0) && (paramInt3 <= paramInt2 - paramInt1))
    {
      int i = paramInt3 + paramInt1;
      localObject3 = ((zzdh)localObject2).zzmc;
      paramT = ((zzdh)localObject2).zzdu;
      while (paramInt1 < i)
      {
        paramInt4 = paramInt1 + 1;
        int j = paramArrayOfByte[paramInt1];
        paramInt3 = paramInt4;
        paramInt1 = j;
        if (j < 0)
        {
          paramInt3 = zzax.zza(j, paramArrayOfByte, paramInt4, paramzzay);
          paramInt1 = paramzzay.zzfd;
        }
        j = paramInt1 >>> 3;
        paramInt4 = paramInt1 & 0x7;
        if (j != 1)
        {
          if ((j == 2) && (paramInt4 == ((zzdh)localObject2).zzmd.zzel()))
          {
            paramInt1 = zza(paramArrayOfByte, paramInt3, paramInt2, ((zzdh)localObject2).zzmd, ((zzdh)localObject2).zzdu.getClass(), paramzzay);
            paramT = paramzzay.zzff;
          }
        }
        else if (paramInt4 == ((zzdh)localObject2).zzmb.zzel())
        {
          paramInt1 = zza(paramArrayOfByte, paramInt3, paramInt2, ((zzdh)localObject2).zzmb, null, paramzzay);
          localObject3 = paramzzay.zzff;
          continue;
        }
        paramInt1 = zzax.zza(paramInt1, paramArrayOfByte, paramInt3, paramInt2, paramzzay);
      }
      if (paramInt1 == i)
      {
        ((Map)localObject1).put(localObject3, paramT);
        return i;
      }
      throw zzco.zzbo();
    }
    throw zzco.zzbl();
  }
  
  private final int zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, zzay paramzzay)
    throws IOException
  {
    Object localObject1 = this;
    T ? = paramT;
    int i = paramInt2;
    int j = paramInt3;
    Object localObject2 = paramzzay;
    Object localObject3 = zzmh;
    int k = 0;
    int m = 0;
    int n = -1;
    for (;;)
    {
      Object localObject4 = paramArrayOfByte;
      if (paramInt1 >= i) {
        break;
      }
      j = paramInt1 + 1;
      paramInt1 = localObject4[paramInt1];
      if (paramInt1 < 0)
      {
        j = zzax.zza(paramInt1, (byte[])localObject4, j, (zzay)localObject2);
        paramInt1 = ((zzay)localObject2).zzfd;
      }
      int i1 = paramInt1 >>> 3;
      int i2 = paramInt1 & 0x7;
      int i3 = ((zzds)localObject1).zzai(i1);
      if (i3 != -1)
      {
        localObject2 = ((zzds)localObject1).zzmi;
        int i4 = localObject2[(i3 + 1)];
        int i5 = (i4 & 0xFF00000) >>> 20;
        long l = i4 & 0xFFFFF;
        int i6;
        if (i5 <= 17)
        {
          k = localObject2[(i3 + 2)];
          i6 = 1 << (k >>> 20);
          i7 = k & 0xFFFFF;
          i = m;
          k = n;
          if (i7 != n)
          {
            if (n != -1) {
              ((Unsafe)localObject3).putInt(?, n, m);
            }
            i = ((Unsafe)localObject3).getInt(?, i7);
            k = i7;
          }
          switch (i5)
          {
          }
          for (;;)
          {
            break label1153;
            if (i2 == 3)
            {
              n = zza(((zzds)localObject1).zzad(i3), paramArrayOfByte, j, paramInt2, i1 << 3 | 0x4, paramzzay);
              localObject2 = paramzzay;
              if ((i & i6) == 0) {
                localObject2 = ((zzay)localObject2).zzff;
              } else {
                localObject2 = zzci.zza(((Unsafe)localObject3).getObject(?, l), ((zzay)localObject2).zzff);
              }
              ((Unsafe)localObject3).putObject(?, l, localObject2);
              i |= i6;
            }
            else
            {
              break label466;
              if (i2 == 0)
              {
                j = zzax.zzb(paramArrayOfByte, j, paramzzay);
                ((Unsafe)localObject3).putLong(paramT, l, zzbk.zza(paramzzay.zzfe));
                m = i | i6;
                n = paramInt1;
                localObject2 = paramzzay;
                paramInt1 = j;
                i = paramInt2;
                j = k;
                break label1134;
              }
              label466:
              continue;
              localObject2 = paramzzay;
              if (i2 != 0) {
                continue;
              }
              m = zzax.zza(paramArrayOfByte, j, (zzay)localObject2);
              ((Unsafe)localObject3).putInt(?, l, zzbk.zzm(((zzay)localObject2).zzfd));
              break label639;
              localObject2 = paramzzay;
              if (i2 != 0) {
                continue;
              }
              n = zzax.zza(paramArrayOfByte, j, (zzay)localObject2);
              m = ((zzay)localObject2).zzfd;
              localObject2 = ((zzds)localObject1).zzaf(i3);
              if ((localObject2 != null) && (((zzck)localObject2).zzb(m) == null))
              {
                zzn(paramT).zzb(paramInt1, Long.valueOf(m));
              }
              else
              {
                ((Unsafe)localObject3).putInt(?, l, m);
                i |= i6;
              }
            }
            m = i;
            break label654;
            localObject2 = paramzzay;
            if (i2 == 2)
            {
              m = zzax.zze(paramArrayOfByte, j, (zzay)localObject2);
              ((Unsafe)localObject3).putObject(?, l, ((zzay)localObject2).zzff);
              label639:
              j = i | i6;
              n = m;
              m = j;
              label654:
              i = paramInt2;
              j = paramInt1;
              localObject2 = paramzzay;
              paramInt1 = n;
              n = j;
              j = k;
              break label1134;
              localObject2 = paramzzay;
              if (i2 == 2)
              {
                m = zza(((zzds)localObject1).zzad(i3), paramArrayOfByte, j, paramInt2, (zzay)localObject2);
                if ((i & i6) == 0) {
                  localObject2 = ((zzay)localObject2).zzff;
                } else {
                  localObject2 = zzci.zza(((Unsafe)localObject3).getObject(?, l), ((zzay)localObject2).zzff);
                }
              }
              else
              {
                break label947;
                localObject2 = paramzzay;
                localObject4 = paramArrayOfByte;
                if (i2 != 2) {
                  break label947;
                }
                if ((i4 & 0x20000000) == 0) {
                  m = zzax.zzc((byte[])localObject4, j, (zzay)localObject2);
                } else {
                  m = zzax.zzd((byte[])localObject4, j, (zzay)localObject2);
                }
                localObject2 = ((zzay)localObject2).zzff;
              }
              ((Unsafe)localObject3).putObject(?, l, localObject2);
              break label895;
              localObject2 = paramzzay;
              if (i2 == 0)
              {
                m = zzax.zzb(paramArrayOfByte, j, (zzay)localObject2);
                boolean bool;
                if (((zzay)localObject2).zzfe != 0L) {
                  bool = true;
                } else {
                  bool = false;
                }
                zzfd.zza(?, l, bool);
                if (i2 == 5)
                {
                  ((Unsafe)localObject3).putInt(?, l, zzax.zzc(paramArrayOfByte, j));
                  m = j + 4;
                  label895:
                  n = i | i6;
                  j = k;
                  i = paramInt2;
                  k = n;
                  break label1120;
                  if (i2 == 1)
                  {
                    ((Unsafe)localObject3).putLong(paramT, l, zzax.zzd(paramArrayOfByte, j));
                    m = j + 8;
                    break label1101;
                  }
                }
              }
              label947:
              break label1153;
              localObject2 = paramzzay;
              if (i2 == 0)
              {
                m = zzax.zza(paramArrayOfByte, j, (zzay)localObject2);
                ((Unsafe)localObject3).putInt(?, l, ((zzay)localObject2).zzfd);
                if (i2 == 0)
                {
                  i7 = zzax.zzb(paramArrayOfByte, j, paramzzay);
                  ((Unsafe)localObject3).putLong(paramT, l, paramzzay.zzfe);
                  m = i | i6;
                  j = k;
                  i = paramInt2;
                  n = paramInt1;
                  localObject2 = paramzzay;
                  paramInt1 = i7;
                  k = m;
                  break label1130;
                  m = j;
                  if (i2 == 5)
                  {
                    zzfd.zza(?, l, zzax.zzf(paramArrayOfByte, m));
                    m += 4;
                    break label1101;
                    m = j;
                    if (i2 == 1)
                    {
                      zzfd.zza(?, l, zzax.zze(paramArrayOfByte, m));
                      m += 8;
                      label1101:
                      n = i | i6;
                      i = paramInt2;
                      j = k;
                      k = n;
                      label1120:
                      localObject2 = paramzzay;
                      n = paramInt1;
                      paramInt1 = m;
                      label1130:
                      m = k;
                      label1134:
                      i7 = paramInt3;
                      k = n;
                      n = j;
                      j = i7;
                      break;
                    }
                  }
                }
              }
            }
          }
          label1153:
          m = k;
          k = j;
          break label1505;
        }
        i = n;
        if (i5 == 27)
        {
          if (i2 == 2)
          {
            localObject4 = (zzcn)((Unsafe)localObject3).getObject(?, l);
            localObject2 = localObject4;
            if (!((zzcn)localObject4).zzu())
            {
              n = ((List)localObject4).size();
              if (n == 0) {
                n = 10;
              } else {
                n <<= 1;
              }
              localObject2 = ((zzcn)localObject4).zzi(n);
              ((Unsafe)localObject3).putObject(?, l, localObject2);
            }
            localObject4 = ((zzds)localObject1).zzad(i3);
            k = paramInt1;
            paramInt1 = zza((zzef)localObject4, k, paramArrayOfByte, j, paramInt2, (zzcn)localObject2, paramzzay);
            j = paramInt3;
            n = i;
            break label1576;
          }
        }
        else
        {
          if (i5 <= 49)
          {
            i7 = zza(paramT, paramArrayOfByte, j, paramInt2, paramInt1, i1, i2, i3, i4, i5, l, paramzzay);
            k = i7;
            if (i7 == j)
            {
              k = i7;
              break label1490;
            }
          }
          label1448:
          do
          {
            do
            {
              localObject1 = this;
              ? = paramT;
              i6 = paramInt1;
              i7 = paramInt2;
              j = paramInt3;
              localObject2 = paramzzay;
              n = i;
              paramInt1 = k;
              k = i6;
              i = i7;
              break;
              i7 = j;
              if (i5 != 50) {
                break label1448;
              }
              if (i2 != 2) {
                break label1493;
              }
              j = zza(paramT, paramArrayOfByte, i7, paramInt2, i3, i1, l, paramzzay);
              k = j;
            } while (j != i7);
            k = j;
            break label1490;
            j = zza(paramT, paramArrayOfByte, i7, paramInt2, paramInt1, i1, i2, i4, i5, l, i3, paramzzay);
            k = j;
          } while (j != i7);
          k = j;
          label1490:
          break label1497;
        }
      }
      label1493:
      k = j;
      label1497:
      i = m;
      m = n;
      label1505:
      n = paramInt3;
      if ((paramInt1 == n) && (n != 0))
      {
        paramInt3 = k;
        k = m;
        m = i;
        break label1601;
      }
      int i7 = zza(paramInt1, paramArrayOfByte, k, paramInt2, paramT, paramzzay);
      localObject1 = this;
      ? = paramT;
      j = n;
      n = m;
      m = i;
      k = paramInt1;
      paramInt1 = i7;
      label1576:
      i = paramInt2;
      localObject2 = paramzzay;
    }
    paramInt3 = paramInt1;
    paramInt1 = k;
    k = n;
    n = j;
    label1601:
    if (k != -1) {
      ((Unsafe)localObject3).putInt(paramT, k, m);
    }
    paramArrayOfByte = paramT;
    paramzzay = this.zzmt;
    if (paramzzay != null)
    {
      k = paramzzay.length;
      paramT = null;
      for (m = 0; m < k; m++)
      {
        j = paramzzay[m];
        localObject1 = this.zzmx;
        i = this.zzmi[j];
        localObject2 = zzfd.zzo(paramArrayOfByte, zzag(j) & 0xFFFFF);
        if (localObject2 != null)
        {
          localObject3 = zzaf(j);
          if (localObject3 != null) {
            paramT = zza(j, i, this.zzmz.zzg(localObject2), (zzck)localObject3, paramT, (zzex)localObject1);
          }
        }
        paramT = (zzey)paramT;
      }
      if (paramT != null) {
        this.zzmx.zzf(paramArrayOfByte, paramT);
      }
    }
    if (n == 0)
    {
      if (paramInt3 != paramInt2) {
        throw zzco.zzbo();
      }
    }
    else {
      if ((paramInt3 > paramInt2) || (paramInt1 != n)) {
        break label1797;
      }
    }
    return paramInt3;
    label1797:
    throw zzco.zzbo();
  }
  
  private static int zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzfl paramzzfl, Class<?> paramClass, zzay paramzzay)
    throws IOException
  {
    long l;
    switch (zzdt.zzgq[paramzzfl.ordinal()])
    {
    default: 
      throw new RuntimeException("unsupported field type.");
    case 17: 
      paramInt1 = zzax.zzd(paramArrayOfByte, paramInt1, paramzzay);
      break;
    case 16: 
      paramInt1 = zzax.zzb(paramArrayOfByte, paramInt1, paramzzay);
      l = zzbk.zza(paramzzay.zzfe);
      break;
    case 15: 
      paramInt1 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
      paramInt2 = zzbk.zzm(paramzzay.zzfd);
      break;
    case 14: 
      paramInt1 = zza(zzea.zzcm().zze(paramClass), paramArrayOfByte, paramInt1, paramInt2, paramzzay);
      break;
    case 12: 
    case 13: 
      paramInt1 = zzax.zzb(paramArrayOfByte, paramInt1, paramzzay);
      l = paramzzay.zzfe;
      paramArrayOfByte = Long.valueOf(l);
      break;
    case 9: 
    case 10: 
    case 11: 
      paramInt1 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
      paramInt2 = paramzzay.zzfd;
    }
    label260:
    label281:
    boolean bool;
    for (paramArrayOfByte = Integer.valueOf(paramInt2);; paramArrayOfByte = Boolean.valueOf(bool))
    {
      paramzzay.zzff = paramArrayOfByte;
      break;
      paramArrayOfByte = Float.valueOf(zzax.zzf(paramArrayOfByte, paramInt1));
      break label260;
      paramArrayOfByte = Long.valueOf(zzax.zzd(paramArrayOfByte, paramInt1));
      break label281;
      paramArrayOfByte = Integer.valueOf(zzax.zzc(paramArrayOfByte, paramInt1));
      paramzzay.zzff = paramArrayOfByte;
      paramInt1 += 4;
      break;
      paramArrayOfByte = Double.valueOf(zzax.zze(paramArrayOfByte, paramInt1));
      paramzzay.zzff = paramArrayOfByte;
      paramInt1 += 8;
      break;
      paramInt1 = zzax.zze(paramArrayOfByte, paramInt1, paramzzay);
      break;
      paramInt1 = zzax.zzb(paramArrayOfByte, paramInt1, paramzzay);
      if (paramzzay.zzfe != 0L) {
        bool = true;
      } else {
        bool = false;
      }
    }
    return paramInt1;
  }
  
  static <T> zzds<T> zza(Class<T> paramClass, zzdm paramzzdm, zzdw paramzzdw, zzcy paramzzcy, zzex<?, ?> paramzzex, zzbu<?> paramzzbu, zzdj paramzzdj)
  {
    if ((paramzzdm instanceof zzec))
    {
      zzec localzzec = (zzec)paramzzdm;
      boolean bool;
      if (localzzec.zzcf() == zzcg.zzg.zzkm) {
        bool = true;
      } else {
        bool = false;
      }
      int i;
      int j;
      int k;
      if (localzzec.getFieldCount() == 0)
      {
        i = 0;
        j = 0;
        k = 0;
      }
      else
      {
        j = localzzec.zzcp();
        k = localzzec.zzcq();
        i = localzzec.zzcu();
      }
      int[] arrayOfInt = new int[i << 2];
      Object[] arrayOfObject = new Object[i << 1];
      if (localzzec.zzcr() > 0) {
        paramClass = new int[localzzec.zzcr()];
      } else {
        paramClass = null;
      }
      if (localzzec.zzcs() > 0) {
        paramzzdm = new int[localzzec.zzcs()];
      } else {
        paramzzdm = null;
      }
      zzed localzzed = localzzec.zzco();
      if (localzzed.next())
      {
        int m = localzzed.zzcx();
        int n = 0;
        int i1 = 0;
        int i5;
        for (i = 0;; i = i5)
        {
          int i2;
          if ((m < localzzec.zzcv()) && (n < m - j << 2)) {
            for (i2 = 0;; i2++)
            {
              i3 = m;
              i4 = i1;
              i5 = i;
              if (i2 >= 4) {
                break;
              }
              arrayOfInt[(n + i2)] = -1;
            }
          }
          if (localzzed.zzda())
          {
            i4 = (int)zzfd.zza(localzzed.zzdb());
            i5 = (int)zzfd.zza(localzzed.zzdc());
            m = 0;
          }
          else
          {
            i4 = (int)zzfd.zza(localzzed.zzdd());
            if (localzzed.zzde())
            {
              i5 = (int)zzfd.zza(localzzed.zzdf());
              m = localzzed.zzdg();
            }
            else
            {
              m = 0;
              i5 = 0;
            }
          }
          arrayOfInt[n] = localzzed.zzcx();
          int i6 = n + 1;
          if (localzzed.zzdi()) {
            i3 = 536870912;
          } else {
            i3 = 0;
          }
          if (localzzed.zzdh()) {
            i2 = 268435456;
          } else {
            i2 = 0;
          }
          arrayOfInt[i6] = (i3 | i2 | localzzed.zzcy() << 20 | i4);
          arrayOfInt[(n + 2)] = (m << 20 | i5);
          if (localzzed.zzdl() != null)
          {
            m = n / 4 << 1;
            arrayOfObject[m] = localzzed.zzdl();
            if (localzzed.zzdj() != null) {
              arrayOfObject[(m + 1)] = localzzed.zzdj();
            } else if (localzzed.zzdk() != null) {
              arrayOfObject[(m + 1)] = localzzed.zzdk();
            }
          }
          else if (localzzed.zzdj() != null)
          {
            arrayOfObject[((n / 4 << 1) + 1)] = localzzed.zzdj();
          }
          else if (localzzed.zzdk() != null)
          {
            arrayOfObject[((n / 4 << 1) + 1)] = localzzed.zzdk();
          }
          int i4 = localzzed.zzcy();
          if (i4 == zzcb.zziw.ordinal())
          {
            paramClass[i1] = n;
            m = i1 + 1;
            i5 = i;
          }
          else
          {
            m = i1;
            i5 = i;
            if (i4 >= 18)
            {
              m = i1;
              i5 = i;
              if (i4 <= 49)
              {
                arrayOfInt[i6] &= 0xFFFFF;
                i5 = i + 1;
                m = i1;
              }
            }
          }
          if (!localzzed.next()) {
            break;
          }
          int i3 = localzzed.zzcx();
          i4 = m;
          n += 4;
          m = i3;
          i1 = i4;
        }
      }
      return new zzds(arrayOfInt, arrayOfObject, j, k, localzzec.zzcv(), localzzec.zzch(), bool, false, localzzec.zzct(), paramClass, paramzzdm, paramzzdw, paramzzcy, paramzzex, paramzzbu, paramzzdj);
    }
    ((zzes)paramzzdm).zzcf();
    throw new NoSuchMethodError();
  }
  
  private final <K, V, UT, UB> UB zza(int paramInt1, int paramInt2, Map<K, V> paramMap, zzck<?> paramzzck, UB paramUB, zzex<UT, UB> paramzzex)
  {
    zzdh localzzdh = this.zzmz.zzl(zzae(paramInt1));
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramzzck.zzb(((Integer)localEntry.getValue()).intValue()) == null)
      {
        paramMap = paramUB;
        if (paramUB == null) {
          paramMap = paramzzex.zzdz();
        }
        zzbg localzzbg = zzbb.zzk(zzdg.zza(localzzdh, localEntry.getKey(), localEntry.getValue()));
        paramUB = localzzbg.zzae();
        try
        {
          zzdg.zza(paramUB, localzzdh, localEntry.getKey(), localEntry.getValue());
          paramzzex.zza(paramMap, paramInt2, localzzbg.zzad());
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
  
  private static void zza(int paramInt, Object paramObject, zzfr paramzzfr)
    throws IOException
  {
    if ((paramObject instanceof String))
    {
      paramzzfr.zza(paramInt, (String)paramObject);
      return;
    }
    paramzzfr.zza(paramInt, (zzbb)paramObject);
  }
  
  private static <UT, UB> void zza(zzex<UT, UB> paramzzex, T paramT, zzfr paramzzfr)
    throws IOException
  {
    paramzzex.zza(paramzzex.zzq(paramT), paramzzfr);
  }
  
  private final <K, V> void zza(zzfr paramzzfr, int paramInt1, Object paramObject, int paramInt2)
    throws IOException
  {
    if (paramObject != null) {
      paramzzfr.zza(paramInt1, this.zzmz.zzl(zzae(paramInt2)), this.zzmz.zzh(paramObject));
    }
  }
  
  private final void zza(T paramT1, T paramT2, int paramInt)
  {
    long l = zzag(paramInt) & 0xFFFFF;
    if (!zza(paramT2, paramInt)) {
      return;
    }
    Object localObject = zzfd.zzo(paramT1, l);
    paramT2 = zzfd.zzo(paramT2, l);
    if ((localObject != null) && (paramT2 != null))
    {
      zzfd.zza(paramT1, l, zzci.zza(localObject, paramT2));
      zzb(paramT1, paramInt);
      return;
    }
    if (paramT2 != null)
    {
      zzfd.zza(paramT1, l, paramT2);
      zzb(paramT1, paramInt);
    }
  }
  
  private final boolean zza(T paramT, int paramInt)
  {
    if (this.zzmq)
    {
      paramInt = zzag(paramInt);
      long l = paramInt & 0xFFFFF;
      switch ((paramInt & 0xFF00000) >>> 20)
      {
      default: 
        throw new IllegalArgumentException();
      case 17: 
        return zzfd.zzo(paramT, l) != null;
      case 16: 
        return zzfd.zzk(paramT, l) != 0L;
      case 15: 
        return zzfd.zzj(paramT, l) != 0;
      case 14: 
        return zzfd.zzk(paramT, l) != 0L;
      case 13: 
        return zzfd.zzj(paramT, l) != 0;
      case 12: 
        return zzfd.zzj(paramT, l) != 0;
      case 11: 
        return zzfd.zzj(paramT, l) != 0;
      case 10: 
        return !zzbb.zzfi.equals(zzfd.zzo(paramT, l));
      case 9: 
        return zzfd.zzo(paramT, l) != null;
      case 8: 
        paramT = zzfd.zzo(paramT, l);
        if ((paramT instanceof String)) {
          return !((String)paramT).isEmpty();
        }
        if ((paramT instanceof zzbb)) {
          return !zzbb.zzfi.equals(paramT);
        }
        throw new IllegalArgumentException();
      case 7: 
        return zzfd.zzl(paramT, l);
      case 6: 
        return zzfd.zzj(paramT, l) != 0;
      case 5: 
        return zzfd.zzk(paramT, l) != 0L;
      case 4: 
        return zzfd.zzj(paramT, l) != 0;
      case 3: 
        return zzfd.zzk(paramT, l) != 0L;
      case 2: 
        return zzfd.zzk(paramT, l) != 0L;
      case 1: 
        return zzfd.zzm(paramT, l) != 0.0F;
      }
      return zzfd.zzn(paramT, l) != 0.0D;
    }
    paramInt = zzah(paramInt);
    return (zzfd.zzj(paramT, paramInt & 0xFFFFF) & 1 << (paramInt >>> 20)) != 0;
  }
  
  private final boolean zza(T paramT, int paramInt1, int paramInt2)
  {
    return zzfd.zzj(paramT, zzah(paramInt2) & 0xFFFFF) == paramInt1;
  }
  
  private final boolean zza(T paramT, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.zzmq) {
      return zza(paramT, paramInt1);
    }
    return (paramInt2 & paramInt3) != 0;
  }
  
  private static boolean zza(Object paramObject, int paramInt, zzef paramzzef)
  {
    return paramzzef.zzo(zzfd.zzo(paramObject, paramInt & 0xFFFFF));
  }
  
  private final zzef zzad(int paramInt)
  {
    paramInt = paramInt / 4 << 1;
    zzef localzzef = (zzef)this.zzmj[paramInt];
    if (localzzef != null) {
      return localzzef;
    }
    localzzef = zzea.zzcm().zze((Class)this.zzmj[(paramInt + 1)]);
    this.zzmj[paramInt] = localzzef;
    return localzzef;
  }
  
  private final Object zzae(int paramInt)
  {
    return this.zzmj[(paramInt / 4 << 1)];
  }
  
  private final zzck<?> zzaf(int paramInt)
  {
    return (zzck)this.zzmj[((paramInt / 4 << 1) + 1)];
  }
  
  private final int zzag(int paramInt)
  {
    return this.zzmi[(paramInt + 1)];
  }
  
  private final int zzah(int paramInt)
  {
    return this.zzmi[(paramInt + 2)];
  }
  
  private final int zzai(int paramInt)
  {
    int i = this.zzmk;
    if (paramInt >= i)
    {
      int j = this.zzmm;
      if (paramInt < j)
      {
        i = paramInt - i << 2;
        if (this.zzmi[i] == paramInt) {
          return i;
        }
        return -1;
      }
      if (paramInt <= this.zzml)
      {
        i = j - i;
        j = this.zzmi.length / 4 - 1;
        while (i <= j)
        {
          int k = j + i >>> 1;
          int m = k << 2;
          int n = this.zzmi[m];
          if (paramInt == n) {
            return m;
          }
          if (paramInt < n) {
            j = k - 1;
          } else {
            i = k + 1;
          }
        }
      }
    }
    return -1;
  }
  
  private final void zzb(T paramT, int paramInt)
  {
    if (this.zzmq) {
      return;
    }
    paramInt = zzah(paramInt);
    long l = paramInt & 0xFFFFF;
    zzfd.zza(paramT, l, zzfd.zzj(paramT, l) | 1 << (paramInt >>> 20));
  }
  
  private final void zzb(T paramT, int paramInt1, int paramInt2)
  {
    zzfd.zza(paramT, zzah(paramInt2) & 0xFFFFF, paramInt1);
  }
  
  private final void zzb(T paramT, zzfr paramzzfr)
    throws IOException
  {
    if (this.zzmo)
    {
      localObject1 = this.zzmy.zza(paramT);
      if (!((zzby)localObject1).isEmpty())
      {
        localIterator = ((zzby)localObject1).iterator();
        localObject1 = (Map.Entry)localIterator.next();
        break label48;
      }
    }
    Iterator localIterator = null;
    Object localObject1 = null;
    label48:
    int i = -1;
    int j = this.zzmi.length;
    Unsafe localUnsafe = zzmh;
    int k = 0;
    int m = 0;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (k >= j) {
        break;
      }
      int n = zzag(k);
      localObject2 = this.zzmi;
      int i1 = localObject2[k];
      int i2 = (0xFF00000 & n) >>> 20;
      int i4;
      int i5;
      if ((!this.zzmq) && (i2 <= 17))
      {
        int i3 = localObject2[(k + 2)];
        i4 = i3 & 0xFFFFF;
        i5 = i;
        if (i4 != i)
        {
          m = localUnsafe.getInt(paramT, i4);
          i5 = i4;
        }
        i4 = 1 << (i3 >>> 20);
        i = i5;
      }
      else
      {
        i4 = 0;
      }
      for (;;)
      {
        i5 = k;
        if ((localObject1 == null) || (this.zzmy.zza((Map.Entry)localObject1) > i1)) {
          break;
        }
        this.zzmy.zza(paramzzfr, (Map.Entry)localObject1);
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
        if (zza(paramT, i1, i5))
        {
          paramzzfr.zzb(i1, localUnsafe.getObject(paramT, l), zzad(i5));
          continue;
          if (zza(paramT, i1, i5))
          {
            paramzzfr.zzb(i1, zzh(paramT, l));
            continue;
            if (zza(paramT, i1, i5))
            {
              paramzzfr.zze(i1, zzg(paramT, l));
              continue;
              if (zza(paramT, i1, i5))
              {
                paramzzfr.zzj(i1, zzh(paramT, l));
                continue;
                if (zza(paramT, i1, i5))
                {
                  paramzzfr.zzm(i1, zzg(paramT, l));
                  continue;
                  if (zza(paramT, i1, i5))
                  {
                    paramzzfr.zzn(i1, zzg(paramT, l));
                    continue;
                    if (zza(paramT, i1, i5))
                    {
                      paramzzfr.zzd(i1, zzg(paramT, l));
                      continue;
                      if (zza(paramT, i1, i5))
                      {
                        paramzzfr.zza(i1, (zzbb)localUnsafe.getObject(paramT, l));
                        continue;
                        if (zza(paramT, i1, i5))
                        {
                          paramzzfr.zza(i1, localUnsafe.getObject(paramT, l), zzad(i5));
                          continue;
                          if (zza(paramT, i1, i5))
                          {
                            zza(i1, localUnsafe.getObject(paramT, l), paramzzfr);
                            continue;
                            if (zza(paramT, i1, i5))
                            {
                              paramzzfr.zzb(i1, zzi(paramT, l));
                              continue;
                              if (zza(paramT, i1, i5))
                              {
                                paramzzfr.zzf(i1, zzg(paramT, l));
                                continue;
                                if (zza(paramT, i1, i5))
                                {
                                  paramzzfr.zzc(i1, zzh(paramT, l));
                                  continue;
                                  if (zza(paramT, i1, i5))
                                  {
                                    paramzzfr.zzc(i1, zzg(paramT, l));
                                    continue;
                                    if (zza(paramT, i1, i5))
                                    {
                                      paramzzfr.zza(i1, zzh(paramT, l));
                                      continue;
                                      if (zza(paramT, i1, i5))
                                      {
                                        paramzzfr.zzi(i1, zzh(paramT, l));
                                        continue;
                                        if (zza(paramT, i1, i5))
                                        {
                                          paramzzfr.zza(i1, zzf(paramT, l));
                                          continue;
                                          if (zza(paramT, i1, i5))
                                          {
                                            paramzzfr.zza(i1, zze(paramT, l));
                                            continue;
                                            zza(paramzzfr, i1, localUnsafe.getObject(paramT, l), i5);
                                            continue;
                                            zzeh.zzb(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, zzad(i5));
                                            continue;
                                            zzeh.zze(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zzj(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zzg(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zzl(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zzm(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zzi(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zzn(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zzk(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zzf(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zzh(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zzd(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zzc(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zzb(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zza(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, true);
                                            continue;
                                            zzeh.zze(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            zzeh.zzj(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            zzeh.zzg(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            zzeh.zzl(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            zzeh.zzm(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            zzeh.zzi(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            zzeh.zzb(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr);
                                            continue;
                                            zzeh.zza(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, zzad(i5));
                                            continue;
                                            zzeh.zza(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr);
                                            continue;
                                            zzeh.zzn(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            zzeh.zzk(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            zzeh.zzf(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            zzeh.zzh(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            zzeh.zzd(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            zzeh.zzc(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            zzeh.zzb(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            zzeh.zza(this.zzmi[i5], (List)localUnsafe.getObject(paramT, l), paramzzfr, false);
                                            break;
                                            if ((i4 & m) != 0)
                                            {
                                              paramzzfr.zzb(i1, localUnsafe.getObject(paramT, l), zzad(i5));
                                              break;
                                              if ((i4 & m) != 0)
                                              {
                                                paramzzfr.zzb(i1, localUnsafe.getLong(paramT, l));
                                                break;
                                                if ((i4 & m) != 0)
                                                {
                                                  paramzzfr.zze(i1, localUnsafe.getInt(paramT, l));
                                                  break;
                                                  if ((i4 & m) != 0)
                                                  {
                                                    paramzzfr.zzj(i1, localUnsafe.getLong(paramT, l));
                                                    break;
                                                    if ((i4 & m) != 0)
                                                    {
                                                      paramzzfr.zzm(i1, localUnsafe.getInt(paramT, l));
                                                      break;
                                                      if ((i4 & m) != 0)
                                                      {
                                                        paramzzfr.zzn(i1, localUnsafe.getInt(paramT, l));
                                                        break;
                                                        if ((i4 & m) != 0)
                                                        {
                                                          paramzzfr.zzd(i1, localUnsafe.getInt(paramT, l));
                                                          break;
                                                          if ((i4 & m) != 0)
                                                          {
                                                            paramzzfr.zza(i1, (zzbb)localUnsafe.getObject(paramT, l));
                                                            break;
                                                            if ((i4 & m) != 0)
                                                            {
                                                              paramzzfr.zza(i1, localUnsafe.getObject(paramT, l), zzad(i5));
                                                              break;
                                                              if ((i4 & m) != 0)
                                                              {
                                                                zza(i1, localUnsafe.getObject(paramT, l), paramzzfr);
                                                                break;
                                                                if ((i4 & m) != 0)
                                                                {
                                                                  paramzzfr.zzb(i1, zzfd.zzl(paramT, l));
                                                                  break;
                                                                  if ((i4 & m) != 0)
                                                                  {
                                                                    paramzzfr.zzf(i1, localUnsafe.getInt(paramT, l));
                                                                    break;
                                                                    if ((i4 & m) != 0)
                                                                    {
                                                                      paramzzfr.zzc(i1, localUnsafe.getLong(paramT, l));
                                                                      break;
                                                                      if ((i4 & m) != 0)
                                                                      {
                                                                        paramzzfr.zzc(i1, localUnsafe.getInt(paramT, l));
                                                                        break;
                                                                        if ((i4 & m) != 0)
                                                                        {
                                                                          paramzzfr.zza(i1, localUnsafe.getLong(paramT, l));
                                                                          break;
                                                                          if ((i4 & m) != 0)
                                                                          {
                                                                            paramzzfr.zzi(i1, localUnsafe.getLong(paramT, l));
                                                                            break;
                                                                            if ((i4 & m) != 0)
                                                                            {
                                                                              paramzzfr.zza(i1, zzfd.zzm(paramT, l));
                                                                              break;
                                                                              if ((i4 & m) != 0) {
                                                                                paramzzfr.zza(i1, zzfd.zzn(paramT, l));
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
      k = i5 + 4;
    }
    while (localObject2 != null)
    {
      this.zzmy.zza(paramzzfr, (Map.Entry)localObject2);
      if (localIterator.hasNext()) {
        localObject2 = (Map.Entry)localIterator.next();
      } else {
        localObject2 = null;
      }
    }
    zza(this.zzmx, paramT, paramzzfr);
  }
  
  private final void zzb(T paramT1, T paramT2, int paramInt)
  {
    int i = zzag(paramInt);
    int j = this.zzmi[paramInt];
    long l = i & 0xFFFFF;
    if (!zza(paramT2, j, paramInt)) {
      return;
    }
    Object localObject = zzfd.zzo(paramT1, l);
    paramT2 = zzfd.zzo(paramT2, l);
    if ((localObject != null) && (paramT2 != null))
    {
      zzfd.zza(paramT1, l, zzci.zza(localObject, paramT2));
      zzb(paramT1, j, paramInt);
      return;
    }
    if (paramT2 != null)
    {
      zzfd.zza(paramT1, l, paramT2);
      zzb(paramT1, j, paramInt);
    }
  }
  
  private final boolean zzc(T paramT1, T paramT2, int paramInt)
  {
    return zza(paramT1, paramInt) == zza(paramT2, paramInt);
  }
  
  private static <E> List<E> zzd(Object paramObject, long paramLong)
  {
    return (List)zzfd.zzo(paramObject, paramLong);
  }
  
  private static <T> double zze(T paramT, long paramLong)
  {
    return ((Double)zzfd.zzo(paramT, paramLong)).doubleValue();
  }
  
  private static <T> float zzf(T paramT, long paramLong)
  {
    return ((Float)zzfd.zzo(paramT, paramLong)).floatValue();
  }
  
  private static <T> int zzg(T paramT, long paramLong)
  {
    return ((Integer)zzfd.zzo(paramT, paramLong)).intValue();
  }
  
  private static <T> long zzh(T paramT, long paramLong)
  {
    return ((Long)zzfd.zzo(paramT, paramLong)).longValue();
  }
  
  private static <T> boolean zzi(T paramT, long paramLong)
  {
    return ((Boolean)zzfd.zzo(paramT, paramLong)).booleanValue();
  }
  
  private static zzey zzn(Object paramObject)
  {
    zzcg localzzcg = (zzcg)paramObject;
    zzey localzzey = localzzcg.zzjp;
    paramObject = localzzey;
    if (localzzey == zzey.zzea())
    {
      paramObject = zzey.zzeb();
      localzzcg.zzjp = ((zzey)paramObject);
    }
    return (zzey)paramObject;
  }
  
  public final boolean equals(T paramT1, T paramT2)
  {
    int i = this.zzmi.length;
    for (int j = 0;; j += 4)
    {
      boolean bool = true;
      if (j >= i) {
        break;
      }
      int k = zzag(j);
      long l1 = k & 0xFFFFF;
      switch ((k & 0xFF00000) >>> 20)
      {
      default: 
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
      case 60: 
      case 61: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
      case 68: 
        long l2 = zzah(j) & 0xFFFFF;
        if (zzfd.zzj(paramT1, l2) != zzfd.zzj(paramT2, l2)) {
          break;
        }
        if (zzeh.zzd(zzfd.zzo(paramT1, l1), zzfd.zzo(paramT2, l1))) {
          break label943;
        }
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
      case 50: 
        bool = zzeh.zzd(zzfd.zzo(paramT1, l1), zzfd.zzo(paramT2, l1));
        break;
      case 17: 
        if (!zzc(paramT1, paramT2, j)) {
          break;
        }
        if (zzeh.zzd(zzfd.zzo(paramT1, l1), zzfd.zzo(paramT2, l1))) {
          break label943;
        }
      case 16: 
        if ((goto 940) || (!zzc(paramT1, paramT2, j))) {
          break;
        }
        if (zzfd.zzk(paramT1, l1) == zzfd.zzk(paramT2, l1)) {
          break label943;
        }
        break;
      case 15: 
        if (!zzc(paramT1, paramT2, j)) {
          break;
        }
        if (zzfd.zzj(paramT1, l1) == zzfd.zzj(paramT2, l1)) {
          break label943;
        }
      case 14: 
        if ((goto 940) || (!zzc(paramT1, paramT2, j))) {
          break;
        }
        if (zzfd.zzk(paramT1, l1) == zzfd.zzk(paramT2, l1)) {
          break label943;
        }
        break;
      case 13: 
        if (!zzc(paramT1, paramT2, j)) {
          break;
        }
        if (zzfd.zzj(paramT1, l1) == zzfd.zzj(paramT2, l1)) {
          break label943;
        }
      case 12: 
        if ((goto 940) || (!zzc(paramT1, paramT2, j))) {
          break;
        }
        if (zzfd.zzj(paramT1, l1) == zzfd.zzj(paramT2, l1)) {
          break label943;
        }
        break;
      case 11: 
        if (!zzc(paramT1, paramT2, j)) {
          break;
        }
        if (zzfd.zzj(paramT1, l1) == zzfd.zzj(paramT2, l1)) {
          break label943;
        }
      case 10: 
        if ((goto 940) || (!zzc(paramT1, paramT2, j))) {
          break;
        }
        if (zzeh.zzd(zzfd.zzo(paramT1, l1), zzfd.zzo(paramT2, l1))) {
          break label943;
        }
        break;
      case 9: 
        if (!zzc(paramT1, paramT2, j)) {
          break;
        }
        if (zzeh.zzd(zzfd.zzo(paramT1, l1), zzfd.zzo(paramT2, l1))) {
          break label943;
        }
      case 8: 
        if ((goto 940) || (!zzc(paramT1, paramT2, j))) {
          break;
        }
        if (zzeh.zzd(zzfd.zzo(paramT1, l1), zzfd.zzo(paramT2, l1))) {
          break label943;
        }
        break;
      case 7: 
        if (!zzc(paramT1, paramT2, j)) {
          break;
        }
        if (zzfd.zzl(paramT1, l1) == zzfd.zzl(paramT2, l1)) {
          break label943;
        }
      case 6: 
        if ((goto 940) || (!zzc(paramT1, paramT2, j))) {
          break;
        }
        if (zzfd.zzj(paramT1, l1) == zzfd.zzj(paramT2, l1)) {
          break label943;
        }
        break;
      case 5: 
        if (!zzc(paramT1, paramT2, j)) {
          break;
        }
        if (zzfd.zzk(paramT1, l1) == zzfd.zzk(paramT2, l1)) {
          break label943;
        }
      case 4: 
        if ((goto 940) || (!zzc(paramT1, paramT2, j))) {
          break;
        }
        if (zzfd.zzj(paramT1, l1) == zzfd.zzj(paramT2, l1)) {
          break label943;
        }
        break;
      case 3: 
        if (!zzc(paramT1, paramT2, j)) {
          break;
        }
        if (zzfd.zzk(paramT1, l1) == zzfd.zzk(paramT2, l1)) {
          break label943;
        }
      case 2: 
        if ((goto 940) || (!zzc(paramT1, paramT2, j))) {
          break;
        }
        if (zzfd.zzk(paramT1, l1) == zzfd.zzk(paramT2, l1)) {
          break label943;
        }
        break;
      case 1: 
        if (!zzc(paramT1, paramT2, j)) {
          break;
        }
        if (zzfd.zzj(paramT1, l1) == zzfd.zzj(paramT2, l1)) {
          break label943;
        }
        break;
      }
      if ((!zzc(paramT1, paramT2, j)) || (zzfd.zzk(paramT1, l1) != zzfd.zzk(paramT2, l1))) {
        bool = false;
      }
      label943:
      if (!bool) {
        return false;
      }
    }
    if (!this.zzmx.zzq(paramT1).equals(this.zzmx.zzq(paramT2))) {
      return false;
    }
    if (this.zzmo) {
      return this.zzmy.zza(paramT1).equals(this.zzmy.zza(paramT2));
    }
    return true;
  }
  
  public final int hashCode(T paramT)
  {
    int i = this.zzmi.length;
    int j = 0;
    for (int k = 0; j < i; k = i1)
    {
      int m = zzag(j);
      int n = this.zzmi[j];
      long l = 0xFFFFF & m;
      i1 = 37;
      Object localObject;
      boolean bool;
      float f;
      switch ((m & 0xFF00000) >>> 20)
      {
      default: 
        i1 = k;
        break;
      case 68: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        break;
      case 67: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        break;
      case 66: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        break;
      case 65: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        break;
      case 64: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        break;
      case 63: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        break;
      case 62: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        break;
      case 61: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        break;
      case 60: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        localObject = zzfd.zzo(paramT, l);
        i1 = k * 53;
        break;
      case 59: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        break;
      case 58: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        i1 = k * 53;
        bool = zzi(paramT, l);
        break;
      case 57: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        break;
      case 56: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        break;
      case 55: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        i1 = k * 53;
        k = zzg(paramT, l);
        break;
      case 54: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        break;
      case 53: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        i1 = k * 53;
        l = zzh(paramT, l);
        break;
      case 52: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        i1 = k * 53;
        f = zzf(paramT, l);
        break;
      case 51: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label985;
        }
        i1 = k * 53;
        d = zze(paramT, l);
        break;
      case 17: 
        localObject = zzfd.zzo(paramT, l);
        if (localObject == null) {}
        break;
      case 10: 
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
      case 50: 
        i1 = k * 53;
        localObject = zzfd.zzo(paramT, l);
        k = localObject.hashCode();
        break;
      case 9: 
        localObject = zzfd.zzo(paramT, l);
        if (localObject != null) {
          i1 = localObject.hashCode();
        }
        i1 = k * 53 + i1;
        break;
      case 8: 
        i1 = k * 53;
        k = ((String)zzfd.zzo(paramT, l)).hashCode();
        break;
      case 7: 
        i1 = k * 53;
        bool = zzfd.zzl(paramT, l);
        k = zzci.zzc(bool);
        break;
      case 4: 
      case 6: 
      case 11: 
      case 12: 
      case 13: 
      case 15: 
        i1 = k * 53;
        k = zzfd.zzj(paramT, l);
        break;
      case 2: 
      case 3: 
      case 5: 
      case 14: 
      case 16: 
        i1 = k * 53;
        l = zzfd.zzk(paramT, l);
        break;
      case 1: 
        i1 = k * 53;
        f = zzfd.zzm(paramT, l);
        k = Float.floatToIntBits(f);
        break;
      }
      i1 = k * 53;
      double d = zzfd.zzn(paramT, l);
      l = Double.doubleToLongBits(d);
      k = zzci.zzl(l);
      i1 += k;
      label985:
      j += 4;
    }
    k = k * 53 + this.zzmx.zzq(paramT).hashCode();
    int i1 = k;
    if (this.zzmo) {
      i1 = k * 53 + this.zzmy.zza(paramT).hashCode();
    }
    return i1;
  }
  
  public final T newInstance()
  {
    return (T)this.zzmv.newInstance(this.zzmn);
  }
  
  public final void zza(T paramT, zzfr paramzzfr)
    throws IOException
  {
    Object localObject1;
    Iterator localIterator;
    label70:
    int i;
    Object localObject2;
    int j;
    int k;
    long l;
    boolean bool;
    float f;
    double d;
    if (paramzzfr.zzaj() == zzcg.zzg.zzkp)
    {
      zza(this.zzmx, paramT, paramzzfr);
      if (this.zzmo)
      {
        localObject1 = this.zzmy.zza(paramT);
        if (!((zzby)localObject1).isEmpty())
        {
          localIterator = ((zzby)localObject1).descendingIterator();
          localObject1 = (Map.Entry)localIterator.next();
          break label70;
        }
      }
      localIterator = null;
      localObject1 = localIterator;
      for (i = this.zzmi.length - 4;; i -= 4)
      {
        localObject2 = localObject1;
        if (i < 0) {
          break;
        }
        j = zzag(i);
        k = this.zzmi[i];
        while ((localObject1 != null) && (this.zzmy.zza((Map.Entry)localObject1) > k))
        {
          this.zzmy.zza(paramzzfr, (Map.Entry)localObject1);
          if (localIterator.hasNext()) {
            localObject1 = (Map.Entry)localIterator.next();
          } else {
            localObject1 = null;
          }
        }
        switch ((j & 0xFF00000) >>> 20)
        {
        default: 
          break;
        case 68: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          break;
        case 67: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          l = zzh(paramT, j & 0xFFFFF);
          break;
        case 66: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          j = zzg(paramT, j & 0xFFFFF);
          break;
        case 65: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          l = zzh(paramT, j & 0xFFFFF);
          break;
        case 64: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          j = zzg(paramT, j & 0xFFFFF);
          break;
        case 63: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          j = zzg(paramT, j & 0xFFFFF);
          break;
        case 62: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          j = zzg(paramT, j & 0xFFFFF);
          break;
        case 61: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          break;
        case 60: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          break;
        case 59: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          break;
        case 58: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          bool = zzi(paramT, j & 0xFFFFF);
          break;
        case 57: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          j = zzg(paramT, j & 0xFFFFF);
          break;
        case 56: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          l = zzh(paramT, j & 0xFFFFF);
          break;
        case 55: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          j = zzg(paramT, j & 0xFFFFF);
          break;
        case 54: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          l = zzh(paramT, j & 0xFFFFF);
          break;
        case 53: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          l = zzh(paramT, j & 0xFFFFF);
          break;
        case 52: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          f = zzf(paramT, j & 0xFFFFF);
          break;
        case 51: 
          if (!zza(paramT, k, i)) {
            continue;
          }
          d = zze(paramT, j & 0xFFFFF);
          break;
        case 50: 
          zza(paramzzfr, k, zzfd.zzo(paramT, j & 0xFFFFF), i);
          break;
        case 49: 
          zzeh.zzb(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, zzad(i));
          break;
        case 48: 
          zzeh.zze(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 47: 
          zzeh.zzj(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 46: 
          zzeh.zzg(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 45: 
          zzeh.zzl(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 44: 
          zzeh.zzm(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 43: 
          zzeh.zzi(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 42: 
          zzeh.zzn(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 41: 
          zzeh.zzk(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 40: 
          zzeh.zzf(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 39: 
          zzeh.zzh(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 38: 
          zzeh.zzd(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 37: 
          zzeh.zzc(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 36: 
          zzeh.zzb(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 35: 
          zzeh.zza(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 34: 
          zzeh.zze(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 33: 
          zzeh.zzj(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 32: 
          zzeh.zzg(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 31: 
          zzeh.zzl(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 30: 
          zzeh.zzm(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 29: 
          zzeh.zzi(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 28: 
          zzeh.zzb(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr);
          break;
        case 27: 
          zzeh.zza(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, zzad(i));
          break;
        case 26: 
          zzeh.zza(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr);
          break;
        case 25: 
          zzeh.zzn(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 24: 
          zzeh.zzk(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 23: 
          zzeh.zzf(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 22: 
          zzeh.zzh(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 21: 
          zzeh.zzd(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 20: 
          zzeh.zzc(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 19: 
          zzeh.zzb(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 18: 
          zzeh.zza(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 17: 
          if (!zza(paramT, i)) {
            continue;
          }
          paramzzfr.zzb(k, zzfd.zzo(paramT, j & 0xFFFFF), zzad(i));
          break;
        case 16: 
          if (!zza(paramT, i)) {
            continue;
          }
          l = zzfd.zzk(paramT, j & 0xFFFFF);
          paramzzfr.zzb(k, l);
          break;
        case 15: 
          if (!zza(paramT, i)) {
            continue;
          }
          j = zzfd.zzj(paramT, j & 0xFFFFF);
          paramzzfr.zze(k, j);
          break;
        case 14: 
          if (!zza(paramT, i)) {
            continue;
          }
          l = zzfd.zzk(paramT, j & 0xFFFFF);
          paramzzfr.zzj(k, l);
          break;
        case 13: 
          if (!zza(paramT, i)) {
            continue;
          }
          j = zzfd.zzj(paramT, j & 0xFFFFF);
          paramzzfr.zzm(k, j);
          break;
        case 12: 
          if (!zza(paramT, i)) {
            continue;
          }
          j = zzfd.zzj(paramT, j & 0xFFFFF);
          paramzzfr.zzn(k, j);
          break;
        case 11: 
          if (!zza(paramT, i)) {
            continue;
          }
          j = zzfd.zzj(paramT, j & 0xFFFFF);
          paramzzfr.zzd(k, j);
          break;
        case 10: 
          if (!zza(paramT, i)) {
            continue;
          }
          paramzzfr.zza(k, (zzbb)zzfd.zzo(paramT, j & 0xFFFFF));
          break;
        case 9: 
          if (!zza(paramT, i)) {
            continue;
          }
          paramzzfr.zza(k, zzfd.zzo(paramT, j & 0xFFFFF), zzad(i));
          break;
        case 8: 
          if (!zza(paramT, i)) {
            continue;
          }
          zza(k, zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr);
          break;
        case 7: 
          if (!zza(paramT, i)) {
            continue;
          }
          bool = zzfd.zzl(paramT, j & 0xFFFFF);
          paramzzfr.zzb(k, bool);
          break;
        case 6: 
          if (!zza(paramT, i)) {
            continue;
          }
          j = zzfd.zzj(paramT, j & 0xFFFFF);
          paramzzfr.zzf(k, j);
          break;
        case 5: 
          if (!zza(paramT, i)) {
            continue;
          }
          l = zzfd.zzk(paramT, j & 0xFFFFF);
          paramzzfr.zzc(k, l);
          break;
        case 4: 
          if (!zza(paramT, i)) {
            continue;
          }
          j = zzfd.zzj(paramT, j & 0xFFFFF);
          paramzzfr.zzc(k, j);
          break;
        case 3: 
          if (!zza(paramT, i)) {
            continue;
          }
          l = zzfd.zzk(paramT, j & 0xFFFFF);
          paramzzfr.zza(k, l);
          break;
        case 2: 
          if (!zza(paramT, i)) {
            continue;
          }
          l = zzfd.zzk(paramT, j & 0xFFFFF);
          paramzzfr.zzi(k, l);
          break;
        case 1: 
          if (!zza(paramT, i)) {
            continue;
          }
          f = zzfd.zzm(paramT, j & 0xFFFFF);
          paramzzfr.zza(k, f);
          break;
        }
        if (zza(paramT, i))
        {
          d = zzfd.zzn(paramT, j & 0xFFFFF);
          paramzzfr.zza(k, d);
        }
      }
      while (localObject2 != null)
      {
        this.zzmy.zza(paramzzfr, (Map.Entry)localObject2);
        if (localIterator.hasNext()) {
          localObject2 = (Map.Entry)localIterator.next();
        } else {
          localObject2 = null;
        }
      }
      return;
    }
    if (this.zzmq)
    {
      if (this.zzmo)
      {
        localObject1 = this.zzmy.zza(paramT);
        if (!((zzby)localObject1).isEmpty())
        {
          localIterator = ((zzby)localObject1).iterator();
          localObject1 = (Map.Entry)localIterator.next();
          break label2560;
        }
      }
      localIterator = null;
      localObject1 = localIterator;
      label2560:
      k = this.zzmi.length;
      i = 0;
      localObject2 = localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= k) {
          break;
        }
        j = zzag(i);
        int m = this.zzmi[i];
        while ((localObject2 != null) && (this.zzmy.zza((Map.Entry)localObject2) <= m))
        {
          this.zzmy.zza(paramzzfr, (Map.Entry)localObject2);
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
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          break;
        case 67: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          l = zzh(paramT, j & 0xFFFFF);
          break;
        case 66: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          j = zzg(paramT, j & 0xFFFFF);
          break;
        case 65: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          l = zzh(paramT, j & 0xFFFFF);
          break;
        case 64: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          j = zzg(paramT, j & 0xFFFFF);
          break;
        case 63: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          j = zzg(paramT, j & 0xFFFFF);
          break;
        case 62: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          j = zzg(paramT, j & 0xFFFFF);
          break;
        case 61: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          break;
        case 60: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          break;
        case 59: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          break;
        case 58: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          bool = zzi(paramT, j & 0xFFFFF);
          break;
        case 57: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          j = zzg(paramT, j & 0xFFFFF);
          break;
        case 56: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          l = zzh(paramT, j & 0xFFFFF);
          break;
        case 55: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          j = zzg(paramT, j & 0xFFFFF);
          break;
        case 54: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          l = zzh(paramT, j & 0xFFFFF);
          break;
        case 53: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          l = zzh(paramT, j & 0xFFFFF);
          break;
        case 52: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          f = zzf(paramT, j & 0xFFFFF);
          break;
        case 51: 
          if (!zza(paramT, m, i)) {
            break label4951;
          }
          d = zze(paramT, j & 0xFFFFF);
          break;
        case 50: 
          zza(paramzzfr, m, zzfd.zzo(paramT, j & 0xFFFFF), i);
          break;
        case 49: 
          zzeh.zzb(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, zzad(i));
          break;
        case 48: 
          zzeh.zze(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 47: 
          zzeh.zzj(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 46: 
          zzeh.zzg(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 45: 
          zzeh.zzl(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 44: 
          zzeh.zzm(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 43: 
          zzeh.zzi(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 42: 
          zzeh.zzn(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 41: 
          zzeh.zzk(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 40: 
          zzeh.zzf(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 39: 
          zzeh.zzh(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 38: 
          zzeh.zzd(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 37: 
          zzeh.zzc(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 36: 
          zzeh.zzb(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 35: 
          zzeh.zza(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, true);
          break;
        case 34: 
          zzeh.zze(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 33: 
          zzeh.zzj(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 32: 
          zzeh.zzg(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 31: 
          zzeh.zzl(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 30: 
          zzeh.zzm(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 29: 
          zzeh.zzi(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 28: 
          zzeh.zzb(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr);
          break;
        case 27: 
          zzeh.zza(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, zzad(i));
          break;
        case 26: 
          zzeh.zza(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr);
          break;
        case 25: 
          zzeh.zzn(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 24: 
          zzeh.zzk(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 23: 
          zzeh.zzf(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 22: 
          zzeh.zzh(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 21: 
          zzeh.zzd(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 20: 
          zzeh.zzc(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 19: 
          zzeh.zzb(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 18: 
          zzeh.zza(this.zzmi[i], (List)zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr, false);
          break;
        case 17: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          paramzzfr.zzb(m, zzfd.zzo(paramT, j & 0xFFFFF), zzad(i));
          break;
        case 16: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          l = zzfd.zzk(paramT, j & 0xFFFFF);
          paramzzfr.zzb(m, l);
          break;
        case 15: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          j = zzfd.zzj(paramT, j & 0xFFFFF);
          paramzzfr.zze(m, j);
          break;
        case 14: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          l = zzfd.zzk(paramT, j & 0xFFFFF);
          paramzzfr.zzj(m, l);
          break;
        case 13: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          j = zzfd.zzj(paramT, j & 0xFFFFF);
          paramzzfr.zzm(m, j);
          break;
        case 12: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          j = zzfd.zzj(paramT, j & 0xFFFFF);
          paramzzfr.zzn(m, j);
          break;
        case 11: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          j = zzfd.zzj(paramT, j & 0xFFFFF);
          paramzzfr.zzd(m, j);
          break;
        case 10: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          paramzzfr.zza(m, (zzbb)zzfd.zzo(paramT, j & 0xFFFFF));
          break;
        case 9: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          paramzzfr.zza(m, zzfd.zzo(paramT, j & 0xFFFFF), zzad(i));
          break;
        case 8: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          zza(m, zzfd.zzo(paramT, j & 0xFFFFF), paramzzfr);
          break;
        case 7: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          bool = zzfd.zzl(paramT, j & 0xFFFFF);
          paramzzfr.zzb(m, bool);
          break;
        case 6: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          j = zzfd.zzj(paramT, j & 0xFFFFF);
          paramzzfr.zzf(m, j);
          break;
        case 5: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          l = zzfd.zzk(paramT, j & 0xFFFFF);
          paramzzfr.zzc(m, l);
          break;
        case 4: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          j = zzfd.zzj(paramT, j & 0xFFFFF);
          paramzzfr.zzc(m, j);
          break;
        case 3: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          l = zzfd.zzk(paramT, j & 0xFFFFF);
          paramzzfr.zza(m, l);
          break;
        case 2: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          l = zzfd.zzk(paramT, j & 0xFFFFF);
          paramzzfr.zzi(m, l);
          break;
        case 1: 
          if (!zza(paramT, i)) {
            break label4951;
          }
          f = zzfd.zzm(paramT, j & 0xFFFFF);
          paramzzfr.zza(m, f);
          break;
        }
        if (zza(paramT, i))
        {
          d = zzfd.zzn(paramT, j & 0xFFFFF);
          paramzzfr.zza(m, d);
        }
        label4951:
        i += 4;
      }
      while (localObject1 != null)
      {
        this.zzmy.zza(paramzzfr, (Map.Entry)localObject1);
        if (localIterator.hasNext()) {
          localObject1 = (Map.Entry)localIterator.next();
        } else {
          localObject1 = null;
        }
      }
      zza(this.zzmx, paramT, paramzzfr);
      return;
    }
    zzb(paramT, paramzzfr);
  }
  
  public final void zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzay paramzzay)
    throws IOException
  {
    if (this.zzmq)
    {
      Unsafe localUnsafe = zzmh;
      int i;
      label307:
      label902:
      label905:
      label918:
      for (;;)
      {
        Object localObject1 = this;
        T ? = paramT;
        i = paramInt2;
        Object localObject2 = paramArrayOfByte;
        Object localObject3 = paramzzay;
        if (paramInt1 >= i) {
          break;
        }
        int j = paramInt1 + 1;
        int k = localObject2[paramInt1];
        if (k < 0)
        {
          j = zzax.zza(k, (byte[])localObject2, j, (zzay)localObject3);
          k = ((zzay)localObject3).zzfd;
        }
        int m = k >>> 3;
        int n = k & 0x7;
        int i1 = ((zzds)localObject1).zzai(m);
        if (i1 >= 0)
        {
          paramInt1 = localObject1.zzmi[(i1 + 1)];
          int i2 = (0xFF00000 & paramInt1) >>> 20;
          long l1 = 0xFFFFF & paramInt1;
          if (i2 <= 17)
          {
            boolean bool = true;
            long l2;
            switch (i2)
            {
            default: 
              break;
            case 16: 
              if (n != 0) {
                break label902;
              }
              paramInt1 = zzax.zzb((byte[])localObject2, j, (zzay)localObject3);
              l2 = zzbk.zza(((zzay)localObject3).zzfe);
              break;
            case 15: 
              if (n != 0) {
                break label902;
              }
              paramInt1 = zzax.zza((byte[])localObject2, j, (zzay)localObject3);
              j = zzbk.zzm(((zzay)localObject3).zzfd);
              break;
            case 12: 
              if (n != 0) {
                break label902;
              }
              break;
            case 10: 
              if (n != 2) {
                break label902;
              }
              paramInt1 = zzax.zze((byte[])localObject2, j, (zzay)localObject3);
            case 9: 
            case 8: 
              for (;;)
              {
                for (localObject3 = ((zzay)localObject3).zzff;; localObject3 = zzci.zza(localObject1, ((zzay)localObject3).zzff))
                {
                  localUnsafe.putObject(?, l1, localObject3);
                  break;
                  if (n != 2) {
                    break label902;
                  }
                  paramInt1 = zza(((zzds)localObject1).zzad(i1), (byte[])localObject2, j, i, (zzay)localObject3);
                  localObject1 = localUnsafe.getObject(?, l1);
                  if (localObject1 == null) {
                    break label307;
                  }
                }
                if (n != 2) {
                  break label902;
                }
                if ((0x20000000 & paramInt1) == 0) {
                  paramInt1 = zzax.zzc((byte[])localObject2, j, (zzay)localObject3);
                } else {
                  paramInt1 = zzax.zzd((byte[])localObject2, j, (zzay)localObject3);
                }
              }
            case 7: 
              if (n != 0) {
                break label902;
              }
              paramInt1 = zzax.zzb((byte[])localObject2, j, (zzay)localObject3);
              if (((zzay)localObject3).zzfe == 0L) {
                bool = false;
              }
              zzfd.zza(?, l1, bool);
              break;
            case 6: 
            case 13: 
              if (n != 5) {
                break label902;
              }
              localUnsafe.putInt(?, l1, zzax.zzc((byte[])localObject2, j));
              break;
            case 5: 
            case 14: 
              if (n != 1) {
                break label902;
              }
              localUnsafe.putLong(paramT, l1, zzax.zzd((byte[])localObject2, j));
              break;
            case 4: 
            case 11: 
              if (n != 0) {
                break label902;
              }
              paramInt1 = zzax.zza((byte[])localObject2, j, (zzay)localObject3);
              j = ((zzay)localObject3).zzfd;
              localUnsafe.putInt(?, l1, j);
              break;
            case 2: 
            case 3: 
              if (n != 0) {
                break label902;
              }
              paramInt1 = zzax.zzb((byte[])localObject2, j, (zzay)localObject3);
              l2 = ((zzay)localObject3).zzfe;
              localUnsafe.putLong(paramT, l1, l2);
              break;
            case 1: 
              if (n != 5) {
                break label902;
              }
              zzfd.zza(?, l1, zzax.zzf((byte[])localObject2, j));
              paramInt1 = j + 4;
              break;
            case 0: 
              if (n != 1) {
                break label902;
              }
              zzfd.zza(?, l1, zzax.zze((byte[])localObject2, j));
              paramInt1 = j + 8;
              break;
            }
          }
          if (i2 == 27)
          {
            if (n == 2)
            {
              localObject2 = (zzcn)localUnsafe.getObject(?, l1);
              localObject3 = localObject2;
              if (!((zzcn)localObject2).zzu())
              {
                paramInt1 = ((List)localObject2).size();
                if (paramInt1 == 0) {
                  paramInt1 = 10;
                } else {
                  paramInt1 <<= 1;
                }
                localObject3 = ((zzcn)localObject2).zzi(paramInt1);
                localUnsafe.putObject(?, l1, localObject3);
              }
              paramInt1 = zza(((zzds)localObject1).zzad(i1), k, paramArrayOfByte, j, paramInt2, (zzcn)localObject3, paramzzay);
            }
          }
          else
          {
            if (i2 <= 49)
            {
              i = zza(paramT, paramArrayOfByte, j, paramInt2, k, m, n, i1, paramInt1, i2, l1, paramzzay);
              paramInt1 = i;
              if (i != j) {
                break label918;
              }
              paramInt1 = i;
            }
            else
            {
              i = j;
              if (i2 == 50)
              {
                if (n != 2) {
                  break label902;
                }
                j = zza(paramT, paramArrayOfByte, i, paramInt2, i1, m, l1, paramzzay);
                paramInt1 = j;
                if (j != i) {
                  break label918;
                }
                paramInt1 = j;
              }
              else
              {
                j = zza(paramT, paramArrayOfByte, i, paramInt2, k, m, n, paramInt1, i2, l1, i1, paramzzay);
                paramInt1 = j;
                if (j != i) {
                  break label918;
                }
                paramInt1 = j;
              }
            }
            break label905;
          }
        }
        paramInt1 = j;
        paramInt1 = zza(k, paramArrayOfByte, paramInt1, paramInt2, paramT, paramzzay);
      }
      if (paramInt1 == i) {
        return;
      }
      throw zzco.zzbo();
    }
    zza(paramT, paramArrayOfByte, paramInt1, paramInt2, 0, paramzzay);
  }
  
  public final void zzc(T paramT)
  {
    int[] arrayOfInt = this.zzmt;
    int i = 0;
    int j;
    int k;
    if (arrayOfInt != null)
    {
      j = arrayOfInt.length;
      for (k = 0; k < j; k++)
      {
        long l = zzag(arrayOfInt[k]) & 0xFFFFF;
        Object localObject = zzfd.zzo(paramT, l);
        if (localObject != null) {
          zzfd.zza(paramT, l, this.zzmz.zzj(localObject));
        }
      }
    }
    arrayOfInt = this.zzmu;
    if (arrayOfInt != null)
    {
      j = arrayOfInt.length;
      for (k = i; k < j; k++)
      {
        i = arrayOfInt[k];
        this.zzmw.zza(paramT, i);
      }
    }
    this.zzmx.zzc(paramT);
    if (this.zzmo) {
      this.zzmy.zzc(paramT);
    }
  }
  
  /* Error */
  public final void zzc(T paramT1, T paramT2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 950	java/util/Objects:requireNonNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: iconst_0
    //   6: istore_3
    //   7: iload_3
    //   8: aload_0
    //   9: getfield 56	com/google/android/gms/internal/clearcut/zzds:zzmi	[I
    //   12: arraylength
    //   13: if_icmpge +699 -> 712
    //   16: aload_0
    //   17: iload_3
    //   18: invokespecial 466	com/google/android/gms/internal/clearcut/zzds:zzag	(I)I
    //   21: istore 4
    //   23: ldc -79
    //   25: iload 4
    //   27: iand
    //   28: i2l
    //   29: lstore 5
    //   31: aload_0
    //   32: getfield 56	com/google/android/gms/internal/clearcut/zzds:zzmi	[I
    //   35: iload_3
    //   36: iaload
    //   37: istore 7
    //   39: iload 4
    //   41: ldc_w 436
    //   44: iand
    //   45: bipush 20
    //   47: iushr
    //   48: tableswitch	default:+292->340, 0:+631->679, 1:+607->655, 2:+583->631, 3:+571->619, 4:+547->595, 5:+535->583, 6:+523->571, 7:+499->547, 8:+475->523, 9:+465->513, 10:+453->501, 11:+441->489, 12:+429->477, 13:+417->465, 14:+405->453, 15:+393->441, 16:+381->429, 17:+465->513, 18:+367->415, 19:+367->415, 20:+367->415, 21:+367->415, 22:+367->415, 23:+367->415, 24:+367->415, 25:+367->415, 26:+367->415, 27:+367->415, 28:+367->415, 29:+367->415, 30:+367->415, 31:+367->415, 32:+367->415, 33:+367->415, 34:+367->415, 35:+367->415, 36:+367->415, 37:+367->415, 38:+367->415, 39:+367->415, 40:+367->415, 41:+367->415, 42:+367->415, 43:+367->415, 44:+367->415, 45:+367->415, 46:+367->415, 47:+367->415, 48:+367->415, 49:+367->415, 50:+353->401, 51:+319->367, 52:+319->367, 53:+319->367, 54:+319->367, 55:+319->367, 56:+319->367, 57:+319->367, 58:+319->367, 59:+319->367, 60:+309->357, 61:+295->343, 62:+295->343, 63:+295->343, 64:+295->343, 65:+295->343, 66:+295->343, 67:+295->343, 68:+309->357
    //   340: goto +366 -> 706
    //   343: aload_0
    //   344: aload_2
    //   345: iload 7
    //   347: iload_3
    //   348: invokespecial 764	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;II)Z
    //   351: ifeq +355 -> 706
    //   354: goto +24 -> 378
    //   357: aload_0
    //   358: aload_1
    //   359: aload_2
    //   360: iload_3
    //   361: invokespecial 952	com/google/android/gms/internal/clearcut/zzds:zzb	(Ljava/lang/Object;Ljava/lang/Object;I)V
    //   364: goto +342 -> 706
    //   367: aload_0
    //   368: aload_2
    //   369: iload 7
    //   371: iload_3
    //   372: invokespecial 764	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;II)Z
    //   375: ifeq +331 -> 706
    //   378: aload_1
    //   379: lload 5
    //   381: aload_2
    //   382: lload 5
    //   384: invokestatic 469	com/google/android/gms/internal/clearcut/zzfd:zzo	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   387: invokestatic 702	com/google/android/gms/internal/clearcut/zzfd:zza	(Ljava/lang/Object;JLjava/lang/Object;)V
    //   390: aload_0
    //   391: aload_1
    //   392: iload 7
    //   394: iload_3
    //   395: invokespecial 863	com/google/android/gms/internal/clearcut/zzds:zzb	(Ljava/lang/Object;II)V
    //   398: goto +308 -> 706
    //   401: aload_0
    //   402: getfield 98	com/google/android/gms/internal/clearcut/zzds:zzmz	Lcom/google/android/gms/internal/clearcut/zzdj;
    //   405: aload_1
    //   406: aload_2
    //   407: lload 5
    //   409: invokestatic 955	com/google/android/gms/internal/clearcut/zzeh:zza	(Lcom/google/android/gms/internal/clearcut/zzdj;Ljava/lang/Object;Ljava/lang/Object;J)V
    //   412: goto +294 -> 706
    //   415: aload_0
    //   416: getfield 90	com/google/android/gms/internal/clearcut/zzds:zzmw	Lcom/google/android/gms/internal/clearcut/zzcy;
    //   419: aload_1
    //   420: aload_2
    //   421: lload 5
    //   423: invokevirtual 958	com/google/android/gms/internal/clearcut/zzcy:zza	(Ljava/lang/Object;Ljava/lang/Object;J)V
    //   426: goto +280 -> 706
    //   429: aload_0
    //   430: aload_2
    //   431: iload_3
    //   432: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   435: ifeq +271 -> 706
    //   438: goto +202 -> 640
    //   441: aload_0
    //   442: aload_2
    //   443: iload_3
    //   444: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   447: ifeq +259 -> 706
    //   450: goto +36 -> 486
    //   453: aload_0
    //   454: aload_2
    //   455: iload_3
    //   456: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   459: ifeq +247 -> 706
    //   462: goto +178 -> 640
    //   465: aload_0
    //   466: aload_2
    //   467: iload_3
    //   468: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   471: ifeq +235 -> 706
    //   474: goto +12 -> 486
    //   477: aload_0
    //   478: aload_2
    //   479: iload_3
    //   480: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   483: ifeq +223 -> 706
    //   486: goto +118 -> 604
    //   489: aload_0
    //   490: aload_2
    //   491: iload_3
    //   492: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   495: ifeq +211 -> 706
    //   498: goto +106 -> 604
    //   501: aload_0
    //   502: aload_2
    //   503: iload_3
    //   504: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   507: ifeq +199 -> 706
    //   510: goto +22 -> 532
    //   513: aload_0
    //   514: aload_1
    //   515: aload_2
    //   516: iload_3
    //   517: invokespecial 960	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;Ljava/lang/Object;I)V
    //   520: goto +186 -> 706
    //   523: aload_0
    //   524: aload_2
    //   525: iload_3
    //   526: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   529: ifeq +177 -> 706
    //   532: aload_1
    //   533: lload 5
    //   535: aload_2
    //   536: lload 5
    //   538: invokestatic 469	com/google/android/gms/internal/clearcut/zzfd:zzo	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   541: invokestatic 702	com/google/android/gms/internal/clearcut/zzfd:zza	(Ljava/lang/Object;JLjava/lang/Object;)V
    //   544: goto +156 -> 700
    //   547: aload_0
    //   548: aload_2
    //   549: iload_3
    //   550: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   553: ifeq +153 -> 706
    //   556: aload_1
    //   557: lload 5
    //   559: aload_2
    //   560: lload 5
    //   562: invokestatic 724	com/google/android/gms/internal/clearcut/zzfd:zzl	(Ljava/lang/Object;J)Z
    //   565: invokestatic 449	com/google/android/gms/internal/clearcut/zzfd:zza	(Ljava/lang/Object;JZ)V
    //   568: goto +132 -> 700
    //   571: aload_0
    //   572: aload_2
    //   573: iload_3
    //   574: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   577: ifeq +129 -> 706
    //   580: goto +24 -> 604
    //   583: aload_0
    //   584: aload_2
    //   585: iload_3
    //   586: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   589: ifeq +117 -> 706
    //   592: goto +48 -> 640
    //   595: aload_0
    //   596: aload_2
    //   597: iload_3
    //   598: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   601: ifeq +105 -> 706
    //   604: aload_1
    //   605: lload 5
    //   607: aload_2
    //   608: lload 5
    //   610: invokestatic 715	com/google/android/gms/internal/clearcut/zzfd:zzj	(Ljava/lang/Object;J)I
    //   613: invokestatic 746	com/google/android/gms/internal/clearcut/zzfd:zza	(Ljava/lang/Object;JI)V
    //   616: goto +84 -> 700
    //   619: aload_0
    //   620: aload_2
    //   621: iload_3
    //   622: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   625: ifeq +81 -> 706
    //   628: goto +12 -> 640
    //   631: aload_0
    //   632: aload_2
    //   633: iload_3
    //   634: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   637: ifeq +69 -> 706
    //   640: aload_1
    //   641: lload 5
    //   643: aload_2
    //   644: lload 5
    //   646: invokestatic 712	com/google/android/gms/internal/clearcut/zzfd:zzk	(Ljava/lang/Object;J)J
    //   649: invokestatic 962	com/google/android/gms/internal/clearcut/zzfd:zza	(Ljava/lang/Object;JJ)V
    //   652: goto +48 -> 700
    //   655: aload_0
    //   656: aload_2
    //   657: iload_3
    //   658: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   661: ifeq +45 -> 706
    //   664: aload_1
    //   665: lload 5
    //   667: aload_2
    //   668: lload 5
    //   670: invokestatic 727	com/google/android/gms/internal/clearcut/zzfd:zzm	(Ljava/lang/Object;J)F
    //   673: invokestatic 452	com/google/android/gms/internal/clearcut/zzfd:zza	(Ljava/lang/Object;JF)V
    //   676: goto +24 -> 700
    //   679: aload_0
    //   680: aload_2
    //   681: iload_3
    //   682: invokespecial 700	com/google/android/gms/internal/clearcut/zzds:zza	(Ljava/lang/Object;I)Z
    //   685: ifeq +21 -> 706
    //   688: aload_1
    //   689: lload 5
    //   691: aload_2
    //   692: lload 5
    //   694: invokestatic 730	com/google/android/gms/internal/clearcut/zzfd:zzn	(Ljava/lang/Object;J)D
    //   697: invokestatic 455	com/google/android/gms/internal/clearcut/zzfd:zza	(Ljava/lang/Object;JD)V
    //   700: aload_0
    //   701: aload_1
    //   702: iload_3
    //   703: invokespecial 705	com/google/android/gms/internal/clearcut/zzds:zzb	(Ljava/lang/Object;I)V
    //   706: iinc 3 4
    //   709: goto -702 -> 7
    //   712: aload_0
    //   713: getfield 70	com/google/android/gms/internal/clearcut/zzds:zzmq	Z
    //   716: ifne +28 -> 744
    //   719: aload_0
    //   720: getfield 92	com/google/android/gms/internal/clearcut/zzds:zzmx	Lcom/google/android/gms/internal/clearcut/zzex;
    //   723: aload_1
    //   724: aload_2
    //   725: invokestatic 965	com/google/android/gms/internal/clearcut/zzeh:zza	(Lcom/google/android/gms/internal/clearcut/zzex;Ljava/lang/Object;Ljava/lang/Object;)V
    //   728: aload_0
    //   729: getfield 78	com/google/android/gms/internal/clearcut/zzds:zzmo	Z
    //   732: ifeq +12 -> 744
    //   735: aload_0
    //   736: getfield 94	com/google/android/gms/internal/clearcut/zzds:zzmy	Lcom/google/android/gms/internal/clearcut/zzbu;
    //   739: aload_1
    //   740: aload_2
    //   741: invokestatic 968	com/google/android/gms/internal/clearcut/zzeh:zza	(Lcom/google/android/gms/internal/clearcut/zzbu;Ljava/lang/Object;Ljava/lang/Object;)V
    //   744: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	745	0	this	zzds
    //   0	745	1	paramT1	T
    //   0	745	2	paramT2	T
    //   6	701	3	i	int
    //   21	24	4	j	int
    //   29	664	5	l	long
    //   37	356	7	k	int
  }
  
  public final int zzm(T paramT)
  {
    int k;
    int n;
    long l;
    Object localObject1;
    Object localObject2;
    if (this.zzmq)
    {
      localUnsafe = zzmh;
      i = 0;
      for (j = 0; i < this.zzmi.length; j = m)
      {
        k = zzag(i);
        m = (k & 0xFF00000) >>> 20;
        n = this.zzmi[i];
        l = k & 0xFFFFF;
        if ((m >= zzcb.zzih.id()) && (m <= zzcb.zziu.id())) {
          k = this.zzmi[(i + 2)] & 0xFFFFF;
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
            break label2256;
          }
          break;
        case 67: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          l = zzh(paramT, l);
          break;
        case 66: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          m = zzg(paramT, l);
          break;
        case 65: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          break;
        case 64: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          break;
        case 63: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          m = zzg(paramT, l);
          break;
        case 62: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          m = zzg(paramT, l);
          break;
        case 61: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          break;
        case 60: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          break;
        case 59: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          localObject1 = zzfd.zzo(paramT, l);
          localObject2 = localObject1;
          if ((localObject1 instanceof zzbb)) {
            localObject2 = localObject1;
          }
          break;
        case 58: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          break;
        case 57: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          break;
        case 56: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          break;
        case 55: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          m = zzg(paramT, l);
          break;
        case 54: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          l = zzh(paramT, l);
          break;
        case 53: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          l = zzh(paramT, l);
          break;
        case 52: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          break;
        case 51: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2256;
          }
          break;
        case 50: 
          m = this.zzmz.zzb(n, zzfd.zzo(paramT, l), zzae(i));
          break;
        case 49: 
          m = zzeh.zzd(n, zzd(paramT, l), zzad(i));
          break;
        case 48: 
          i1 = zzeh.zzc((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr) {
            m = i1;
          }
          break;
        case 47: 
          i1 = zzeh.zzg((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr) {
            m = i1;
          }
          break;
        case 46: 
          i1 = zzeh.zzi((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr) {
            m = i1;
          }
          break;
        case 45: 
          i1 = zzeh.zzh((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr) {
            m = i1;
          }
          break;
        case 44: 
          i1 = zzeh.zzd((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr) {
            m = i1;
          }
          break;
        case 43: 
          i1 = zzeh.zzf((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr) {
            m = i1;
          }
          break;
        case 42: 
          i1 = zzeh.zzj((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr) {
            m = i1;
          }
          break;
        case 41: 
          i1 = zzeh.zzh((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr) {
            m = i1;
          }
          break;
        case 40: 
          i1 = zzeh.zzi((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr) {
            m = i1;
          }
          break;
        case 39: 
          i1 = zzeh.zze((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr) {
            m = i1;
          }
          break;
        case 38: 
          i1 = zzeh.zzb((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr) {
            m = i1;
          }
          break;
        case 37: 
          i1 = zzeh.zza((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr) {
            m = i1;
          }
          break;
        case 36: 
          i1 = zzeh.zzh((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr) {
            m = i1;
          }
          break;
        case 35: 
          i1 = zzeh.zzi((List)localUnsafe.getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2256;
          }
          m = i1;
          if (this.zzmr)
          {
            m = i1;
            localUnsafe.putInt(paramT, k, m);
          }
          m = zzbn.zzr(n) + zzbn.zzt(m) + m;
          break;
        case 34: 
          m = zzeh.zzq(n, zzd(paramT, l), false);
          break;
        case 33: 
          m = zzeh.zzu(n, zzd(paramT, l), false);
          break;
        case 30: 
          m = zzeh.zzr(n, zzd(paramT, l), false);
          break;
        case 29: 
          m = zzeh.zzt(n, zzd(paramT, l), false);
          break;
        case 28: 
          m = zzeh.zzd(n, zzd(paramT, l));
          break;
        case 27: 
          m = zzeh.zzc(n, zzd(paramT, l), zzad(i));
          break;
        case 26: 
          m = zzeh.zzc(n, zzd(paramT, l));
          break;
        case 25: 
          m = zzeh.zzx(n, zzd(paramT, l), false);
          break;
        case 22: 
          m = zzeh.zzs(n, zzd(paramT, l), false);
          break;
        case 21: 
          m = zzeh.zzp(n, zzd(paramT, l), false);
          break;
        case 20: 
          m = zzeh.zzo(n, zzd(paramT, l), false);
          break;
        case 19: 
        case 24: 
        case 31: 
          m = zzeh.zzv(n, zzd(paramT, l), false);
          break;
        case 18: 
        case 23: 
        case 32: 
          m = zzeh.zzw(n, zzd(paramT, l), false);
        }
        for (;;)
        {
          m = j + m;
          break;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          m = zzbn.zzc(n, (zzdo)zzfd.zzo(paramT, l), zzad(i));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          l = zzfd.zzk(paramT, l);
          m = zzbn.zzf(n, l);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          m = zzfd.zzj(paramT, l);
          m = zzbn.zzi(n, m);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          m = zzbn.zzh(n, 0L);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          m = zzbn.zzk(n, 0);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          m = zzfd.zzj(paramT, l);
          m = zzbn.zzl(n, m);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          m = zzfd.zzj(paramT, l);
          m = zzbn.zzh(n, m);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          for (localObject2 = zzfd.zzo(paramT, l);; localObject2 = localObject1)
          {
            m = zzbn.zzc(n, (zzbb)localObject2);
            break;
            m = j;
            if (!zza(paramT, i)) {
              break label2256;
            }
            m = zzeh.zzc(n, zzfd.zzo(paramT, l), zzad(i));
            break;
            m = j;
            if (!zza(paramT, i)) {
              break label2256;
            }
            localObject1 = zzfd.zzo(paramT, l);
            localObject2 = localObject1;
            if (!(localObject1 instanceof zzbb)) {
              break label2022;
            }
          }
          label2022:
          m = zzbn.zzb(n, (String)localObject2);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          m = zzbn.zzc(n, true);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          m = zzbn.zzj(n, 0);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          m = zzbn.zzg(n, 0L);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          m = zzfd.zzj(paramT, l);
          m = zzbn.zzg(n, m);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          l = zzfd.zzk(paramT, l);
          m = zzbn.zze(n, l);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          l = zzfd.zzk(paramT, l);
          m = zzbn.zzd(n, l);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          m = zzbn.zzb(n, 0.0F);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          m = zzbn.zzb(n, 0.0D);
        }
        label2256:
        i += 4;
      }
      return j + zza(this.zzmx, paramT);
    }
    Unsafe localUnsafe = zzmh;
    int j = -1;
    int i1 = 0;
    int i = 0;
    for (int m = 0; i1 < this.zzmi.length; m = n)
    {
      int i2 = zzag(i1);
      localObject2 = this.zzmi;
      int i3 = localObject2[i1];
      int i4 = (i2 & 0xFF00000) >>> 20;
      int i6;
      if (i4 <= 17)
      {
        n = localObject2[(i1 + 2)];
        int i5 = n & 0xFFFFF;
        i6 = 1 << (n >>> 20);
        k = j;
        if (i5 != j)
        {
          m = localUnsafe.getInt(paramT, i5);
          k = i5;
        }
        j = k;
        k = n;
        n = m;
      }
      else
      {
        if ((this.zzmr) && (i4 >= zzcb.zzih.id()) && (i4 <= zzcb.zziu.id())) {
          k = this.zzmi[(i1 + 2)] & 0xFFFFF;
        } else {
          k = 0;
        }
        i6 = 0;
        n = m;
      }
      l = i2 & 0xFFFFF;
      switch (i4)
      {
      default: 
        m = i;
        break;
      case 68: 
        m = i;
        if (!zza(paramT, i3, i1)) {}
        break;
      case 67: 
        m = i;
        if (zza(paramT, i3, i1)) {
          l = zzh(paramT, l);
        }
        break;
      case 66: 
        m = i;
        if (zza(paramT, i3, i1)) {
          m = zzg(paramT, l);
        }
        break;
      case 65: 
        m = i;
        if (!zza(paramT, i3, i1)) {}
        break;
      case 64: 
        m = i;
        if (!zza(paramT, i3, i1)) {}
        break;
      case 63: 
        m = i;
        if (zza(paramT, i3, i1)) {
          m = zzg(paramT, l);
        }
        break;
      case 62: 
        m = i;
        if (zza(paramT, i3, i1)) {
          m = zzg(paramT, l);
        }
        break;
      case 61: 
        m = i;
        if (!zza(paramT, i3, i1)) {}
        break;
      case 60: 
        m = i;
        if (!zza(paramT, i3, i1)) {}
        break;
      case 59: 
        m = i;
        if (zza(paramT, i3, i1))
        {
          localObject1 = localUnsafe.getObject(paramT, l);
          localObject2 = localObject1;
          if (!(localObject1 instanceof zzbb)) {
            break label4482;
          }
          localObject2 = localObject1;
        }
        break;
      case 58: 
        m = i;
        if (!zza(paramT, i3, i1)) {}
        break;
      case 57: 
        m = i;
        if (zza(paramT, i3, i1)) {
          m = zzbn.zzj(i3, 0);
        }
        break;
      case 56: 
        m = i;
        if (zza(paramT, i3, i1)) {
          m = zzbn.zzg(i3, 0L);
        }
        break;
      case 55: 
        m = i;
        if (zza(paramT, i3, i1)) {
          m = zzbn.zzg(i3, zzg(paramT, l));
        }
        break;
      case 54: 
        m = i;
        if (zza(paramT, i3, i1)) {
          m = zzbn.zze(i3, zzh(paramT, l));
        }
        break;
      case 53: 
        m = i;
        if (zza(paramT, i3, i1)) {
          m = zzbn.zzd(i3, zzh(paramT, l));
        }
        break;
      case 52: 
        m = i;
        if (zza(paramT, i3, i1)) {
          m = zzbn.zzb(i3, 0.0F);
        }
        break;
      case 51: 
        m = i;
        if (zza(paramT, i3, i1)) {
          m = zzbn.zzb(i3, 0.0D);
        }
        break;
      case 50: 
        m = this.zzmz.zzb(i3, localUnsafe.getObject(paramT, l), zzae(i1));
        break;
      case 49: 
        m = zzeh.zzd(i3, (List)localUnsafe.getObject(paramT, l), zzad(i1));
        break;
      case 48: 
        i6 = zzeh.zzc((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr) {
            m = i6;
          }
        }
        break;
      case 47: 
        i6 = zzeh.zzg((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr) {
            m = i6;
          }
        }
        break;
      case 46: 
        i6 = zzeh.zzi((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr) {
            m = i6;
          }
        }
        break;
      case 45: 
        i6 = zzeh.zzh((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr) {
            m = i6;
          }
        }
        break;
      case 44: 
        i6 = zzeh.zzd((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr) {
            m = i6;
          }
        }
        break;
      case 43: 
        i6 = zzeh.zzf((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr) {
            m = i6;
          }
        }
        break;
      case 42: 
        i6 = zzeh.zzj((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr) {
            m = i6;
          }
        }
        break;
      case 41: 
        i6 = zzeh.zzh((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr) {
            m = i6;
          }
        }
        break;
      case 40: 
        i6 = zzeh.zzi((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr) {
            m = i6;
          }
        }
        break;
      case 39: 
        i6 = zzeh.zze((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr) {
            m = i6;
          }
        }
        break;
      case 38: 
        i6 = zzeh.zzb((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr) {
            m = i6;
          }
        }
        break;
      case 37: 
        i6 = zzeh.zza((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr) {
            m = i6;
          }
        }
        break;
      case 36: 
        i6 = zzeh.zzh((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr) {
            m = i6;
          }
        }
        break;
      case 35: 
        i6 = zzeh.zzi((List)localUnsafe.getObject(paramT, l));
        m = i;
        if (i6 > 0)
        {
          m = i6;
          if (this.zzmr)
          {
            m = i6;
            localUnsafe.putInt(paramT, k, m);
          }
          m = zzbn.zzr(i3) + zzbn.zzt(m) + m;
        }
        break;
      case 34: 
        m = zzeh.zzq(i3, (List)localUnsafe.getObject(paramT, l), false);
        break;
      case 33: 
        m = zzeh.zzu(i3, (List)localUnsafe.getObject(paramT, l), false);
        break;
      case 30: 
        m = zzeh.zzr(i3, (List)localUnsafe.getObject(paramT, l), false);
        break;
      case 29: 
        m = zzeh.zzt(i3, (List)localUnsafe.getObject(paramT, l), false);
        break;
      case 28: 
        m = zzeh.zzd(i3, (List)localUnsafe.getObject(paramT, l));
        break;
      case 27: 
        m = zzeh.zzc(i3, (List)localUnsafe.getObject(paramT, l), zzad(i1));
        break;
      case 26: 
        m = zzeh.zzc(i3, (List)localUnsafe.getObject(paramT, l));
        break;
      case 25: 
        m = zzeh.zzx(i3, (List)localUnsafe.getObject(paramT, l), false);
        break;
      case 22: 
        m = zzeh.zzs(i3, (List)localUnsafe.getObject(paramT, l), false);
        break;
      case 21: 
        m = zzeh.zzp(i3, (List)localUnsafe.getObject(paramT, l), false);
        break;
      case 20: 
        m = zzeh.zzo(i3, (List)localUnsafe.getObject(paramT, l), false);
        break;
      case 19: 
      case 24: 
      case 31: 
        m = zzeh.zzv(i3, (List)localUnsafe.getObject(paramT, l), false);
        break;
      case 18: 
      case 23: 
      case 32: 
        m = zzeh.zzw(i3, (List)localUnsafe.getObject(paramT, l), false);
        m = i + m;
      }
      for (;;)
      {
        label4156:
        break label4700;
        m = i;
        if ((n & i6) != 0)
        {
          m = zzbn.zzc(i3, (zzdo)localUnsafe.getObject(paramT, l), zzad(i1));
          break;
          m = i;
          if ((n & i6) != 0)
          {
            l = localUnsafe.getLong(paramT, l);
            m = zzbn.zzf(i3, l);
            break;
            m = i;
            if ((n & i6) != 0)
            {
              m = localUnsafe.getInt(paramT, l);
              m = zzbn.zzi(i3, m);
              break;
              m = i;
              if ((n & i6) != 0)
              {
                m = zzbn.zzh(i3, 0L);
                break;
                m = i;
                if ((n & i6) != 0)
                {
                  m = zzbn.zzk(i3, 0);
                  m = i + m;
                  continue;
                  m = i;
                  if ((n & i6) != 0)
                  {
                    m = localUnsafe.getInt(paramT, l);
                    m = zzbn.zzl(i3, m);
                    break;
                    m = i;
                    if ((n & i6) != 0)
                    {
                      m = localUnsafe.getInt(paramT, l);
                      m = zzbn.zzh(i3, m);
                      break;
                      m = i;
                      if ((n & i6) != 0)
                      {
                        for (localObject2 = localUnsafe.getObject(paramT, l);; localObject2 = localObject1)
                        {
                          m = zzbn.zzc(i3, (zzbb)localObject2);
                          break;
                          m = i;
                          if ((n & i6) == 0) {
                            break label4156;
                          }
                          m = zzeh.zzc(i3, localUnsafe.getObject(paramT, l), zzad(i1));
                          break;
                          m = i;
                          if ((n & i6) == 0) {
                            break label4156;
                          }
                          localObject1 = localUnsafe.getObject(paramT, l);
                          localObject2 = localObject1;
                          if (!(localObject1 instanceof zzbb)) {
                            break label4482;
                          }
                        }
                        label4482:
                        m = zzbn.zzb(i3, (String)localObject2);
                        break;
                        m = i;
                        if ((n & i6) != 0)
                        {
                          m = zzbn.zzc(i3, true);
                          break;
                          m = i;
                          if ((n & i6) != 0)
                          {
                            m = i + zzbn.zzj(i3, 0);
                            continue;
                            m = i;
                            if ((n & i6) != 0)
                            {
                              m = zzbn.zzg(i3, 0L);
                              break label4646;
                              m = i;
                              if ((n & i6) != 0)
                              {
                                m = zzbn.zzg(i3, localUnsafe.getInt(paramT, l));
                                break label4646;
                                m = i;
                                if ((n & i6) != 0)
                                {
                                  m = zzbn.zze(i3, localUnsafe.getLong(paramT, l));
                                  break label4646;
                                  m = i;
                                  if ((n & i6) != 0)
                                  {
                                    m = zzbn.zzd(i3, localUnsafe.getLong(paramT, l));
                                    label4646:
                                    m = i + m;
                                  }
                                }
                              }
                            }
                            for (;;)
                            {
                              break;
                              m = i;
                              if ((n & i6) != 0) {
                                m = i + zzbn.zzb(i3, 0.0F);
                              }
                            }
                            for (;;)
                            {
                              break;
                              m = i;
                              if ((n & i6) != 0) {
                                m = i + zzbn.zzb(i3, 0.0D);
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
      label4700:
      i1 += 4;
      i = m;
    }
    i += zza(this.zzmx, paramT);
    m = i;
    if (this.zzmo) {
      m = i + this.zzmy.zza(paramT).zzas();
    }
    return m;
  }
  
  public final boolean zzo(T paramT)
  {
    int[] arrayOfInt = this.zzms;
    if ((arrayOfInt != null) && (arrayOfInt.length != 0))
    {
      int i = -1;
      int j = arrayOfInt.length;
      int k = 0;
      int m = 0;
      while (k < j)
      {
        int n = arrayOfInt[k];
        int i1 = zzai(n);
        int i2 = zzag(i1);
        int i3;
        if (!this.zzmq)
        {
          i3 = this.zzmi[(i1 + 2)];
          i4 = i3 & 0xFFFFF;
          i3 = 1 << (i3 >>> 20);
          if (i4 != i)
          {
            m = zzmh.getInt(paramT, i4);
            i = i4;
          }
        }
        else
        {
          i3 = 0;
        }
        if ((0x10000000 & i2) != 0) {
          i4 = 1;
        } else {
          i4 = 0;
        }
        if ((i4 != 0) && (!zza(paramT, i1, m, i3))) {
          return false;
        }
        int i4 = (0xFF00000 & i2) >>> 20;
        if ((i4 != 9) && (i4 != 17))
        {
          Object localObject2;
          if (i4 != 27) {
            if ((i4 != 60) && (i4 != 68))
            {
              if (i4 != 49)
              {
                if (i4 != 50) {
                  break label525;
                }
                localObject1 = this.zzmz.zzh(zzfd.zzo(paramT, i2 & 0xFFFFF));
                if (!((Map)localObject1).isEmpty())
                {
                  localObject2 = zzae(i1);
                  if (this.zzmz.zzl(localObject2).zzmd.zzek() == zzfq.zzrf)
                  {
                    localObject2 = null;
                    Iterator localIterator = ((Map)localObject1).values().iterator();
                    while (localIterator.hasNext())
                    {
                      Object localObject3 = localIterator.next();
                      localObject1 = localObject2;
                      if (localObject2 == null) {
                        localObject1 = zzea.zzcm().zze(localObject3.getClass());
                      }
                      localObject2 = localObject1;
                      if (!((zzef)localObject1).zzo(localObject3))
                      {
                        i3 = 0;
                        break label369;
                      }
                    }
                  }
                }
                i3 = 1;
                label369:
                if (i3 != 0) {
                  break label525;
                }
                return false;
              }
            }
            else
            {
              if ((!zza(paramT, n, i1)) || (zza(paramT, i2, zzad(i1)))) {
                break label525;
              }
              return false;
            }
          }
          Object localObject1 = (List)zzfd.zzo(paramT, i2 & 0xFFFFF);
          if (!((List)localObject1).isEmpty())
          {
            localObject2 = zzad(i1);
            for (i3 = 0; i3 < ((List)localObject1).size(); i3++) {
              if (!((zzef)localObject2).zzo(((List)localObject1).get(i3)))
              {
                i3 = 0;
                break label487;
              }
            }
          }
          i3 = 1;
          label487:
          if (i3 == 0) {
            return false;
          }
        }
        else if ((zza(paramT, i1, m, i3)) && (!zza(paramT, i2, zzad(i1))))
        {
          return false;
        }
        label525:
        k++;
      }
      if ((this.zzmo) && (!this.zzmy.zza(paramT).isInitialized())) {
        return false;
      }
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */