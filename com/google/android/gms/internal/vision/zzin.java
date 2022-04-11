package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzin<T>
  implements zziw<T>
{
  private final zzih zzzn;
  private final boolean zzzo;
  private final zzjo<?, ?> zzzx;
  private final zzgk<?> zzzy;
  
  private zzin(zzjo<?, ?> paramzzjo, zzgk<?> paramzzgk, zzih paramzzih)
  {
    this.zzzx = paramzzjo;
    this.zzzo = paramzzgk.zze(paramzzih);
    this.zzzy = paramzzgk;
    this.zzzn = paramzzih;
  }
  
  static <T> zzin<T> zza(zzjo<?, ?> paramzzjo, zzgk<?> paramzzgk, zzih paramzzih)
  {
    return new zzin(paramzzjo, paramzzgk, paramzzih);
  }
  
  public final boolean equals(T paramT1, T paramT2)
  {
    if (!this.zzzx.zzw(paramT1).equals(this.zzzx.zzw(paramT2))) {
      return false;
    }
    if (this.zzzo) {
      return this.zzzy.zzf(paramT1).equals(this.zzzy.zzf(paramT2));
    }
    return true;
  }
  
  public final int hashCode(T paramT)
  {
    int i = this.zzzx.zzw(paramT).hashCode();
    int j = i;
    if (this.zzzo) {
      j = i * 53 + this.zzzy.zzf(paramT).hashCode();
    }
    return j;
  }
  
  public final T newInstance()
  {
    return this.zzzn.zzgk().zzgc();
  }
  
  public final void zza(T paramT, zzix paramzzix, zzgi paramzzgi)
    throws IOException
  {
    zzjo localzzjo = this.zzzx;
    zzgk localzzgk = this.zzzy;
    Object localObject1 = localzzjo.zzx(paramT);
    zzgn localzzgn = localzzgk.zzg(paramT);
    try
    {
      boolean bool;
      label241:
      do
      {
        int i = paramzzix.zzdv();
        if (i == Integer.MAX_VALUE) {
          return;
        }
        i = paramzzix.getTag();
        Object localObject2;
        if (i != 11)
        {
          if ((i & 0x7) == 2)
          {
            localObject2 = localzzgk.zza(paramzzgi, this.zzzn, i >>> 3);
            if (localObject2 != null)
            {
              localzzgk.zza(paramzzix, localObject2, paramzzgi, localzzgn);
            }
            else
            {
              bool = localzzjo.zza(localObject1, paramzzix);
              continue;
            }
          }
          else
          {
            bool = paramzzix.zzdw();
            continue;
          }
        }
        else
        {
          i = 0;
          Object localObject3 = null;
          localObject2 = null;
          do
          {
            for (;;)
            {
              if (paramzzix.zzdv() == Integer.MAX_VALUE) {
                break label241;
              }
              int j = paramzzix.getTag();
              if (j == 16)
              {
                i = paramzzix.zzef();
                localObject3 = localzzgk.zza(paramzzgi, this.zzzn, i);
              }
              else
              {
                if (j != 26) {
                  break;
                }
                if (localObject3 != null) {
                  localzzgk.zza(paramzzix, localObject3, paramzzgi, localzzgn);
                } else {
                  localObject2 = paramzzix.zzee();
                }
              }
            }
          } while (paramzzix.zzdw());
          if (paramzzix.getTag() != 12) {
            break;
          }
          if (localObject2 != null) {
            if (localObject3 != null) {
              localzzgk.zza((zzfm)localObject2, localObject3, paramzzgi, localzzgn);
            } else {
              localzzjo.zza(localObject1, i, (zzfm)localObject2);
            }
          }
        }
        bool = true;
      } while (bool);
      return;
      throw zzhh.zzgr();
    }
    finally
    {
      localzzjo.zzg(paramT, localObject1);
    }
  }
  
  public final void zza(T paramT, zzkl paramzzkl)
    throws IOException
  {
    Object localObject = this.zzzy.zzf(paramT).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      zzgp localzzgp = (zzgp)localEntry.getKey();
      if ((localzzgp.zzfu() == zzki.zzade) && (!localzzgp.zzfv()) && (!localzzgp.zzfw()))
      {
        if ((localEntry instanceof zzhk)) {
          paramzzkl.zza(localzzgp.zzah(), ((zzhk)localEntry).zzgx().zzdl());
        } else {
          paramzzkl.zza(localzzgp.zzah(), localEntry.getValue());
        }
      }
      else {
        throw new IllegalStateException("Found invalid MessageSet item.");
      }
    }
    localObject = this.zzzx;
    ((zzjo)localObject).zzc(((zzjo)localObject).zzw(paramT), paramzzkl);
  }
  
  public final void zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzfg paramzzfg)
    throws IOException
  {
    Object localObject1 = (zzgx)paramT;
    Object localObject2 = ((zzgx)localObject1).zzws;
    Object localObject3 = localObject2;
    if (localObject2 == zzjr.zzih())
    {
      localObject3 = zzjr.zzii();
      ((zzgx)localObject1).zzws = ((zzjr)localObject3);
    }
    localObject1 = ((zzgx.zze)paramT).zzgl();
    paramT = null;
    while (paramInt1 < paramInt2)
    {
      paramInt1 = zzfe.zza(paramArrayOfByte, paramInt1, paramzzfg);
      int i = paramzzfg.zzsd;
      if (i != 11)
      {
        if ((i & 0x7) == 2)
        {
          paramT = (zzgx.zzg)this.zzzy.zza(paramzzfg.zzcu, this.zzzn, i >>> 3);
          if (paramT != null)
          {
            paramInt1 = zzfe.zza(zzis.zzhp().zzf(paramT.zzxp.getClass()), paramArrayOfByte, paramInt1, paramInt2, paramzzfg);
            ((zzgn)localObject1).zza(paramT.zzxq, paramzzfg.zzsf);
          }
          else
          {
            paramInt1 = zzfe.zza(i, paramArrayOfByte, paramInt1, paramInt2, (zzjr)localObject3, paramzzfg);
          }
        }
        else
        {
          paramInt1 = zzfe.zza(i, paramArrayOfByte, paramInt1, paramInt2, paramzzfg);
        }
      }
      else
      {
        int j = 0;
        localObject2 = null;
        for (;;)
        {
          i = paramInt1;
          if (paramInt1 >= paramInt2) {
            break;
          }
          paramInt1 = zzfe.zza(paramArrayOfByte, paramInt1, paramzzfg);
          int k = paramzzfg.zzsd;
          int m = k >>> 3;
          i = k & 0x7;
          if (m != 2)
          {
            if (m == 3)
            {
              if (paramT != null)
              {
                paramInt1 = zzfe.zza(zzis.zzhp().zzf(paramT.zzxp.getClass()), paramArrayOfByte, paramInt1, paramInt2, paramzzfg);
                ((zzgn)localObject1).zza(paramT.zzxq, paramzzfg.zzsf);
                continue;
              }
              if (i == 2)
              {
                paramInt1 = zzfe.zze(paramArrayOfByte, paramInt1, paramzzfg);
                localObject2 = (zzfm)paramzzfg.zzsf;
              }
            }
          }
          else if (i == 0)
          {
            paramInt1 = zzfe.zza(paramArrayOfByte, paramInt1, paramzzfg);
            j = paramzzfg.zzsd;
            paramT = (zzgx.zzg)this.zzzy.zza(paramzzfg.zzcu, this.zzzn, j);
            continue;
          }
          i = paramInt1;
          if (k == 12) {
            break;
          }
          paramInt1 = zzfe.zza(k, paramArrayOfByte, paramInt1, paramInt2, paramzzfg);
        }
        if (localObject2 != null) {
          ((zzjr)localObject3).zzb(j << 3 | 0x2, localObject2);
        }
        paramInt1 = i;
      }
    }
    if (paramInt1 == paramInt2) {
      return;
    }
    throw zzhh.zzgt();
  }
  
  public final void zzd(T paramT1, T paramT2)
  {
    zziy.zza(this.zzzx, paramT1, paramT2);
    if (this.zzzo) {
      zziy.zza(this.zzzy, paramT1, paramT2);
    }
  }
  
  public final void zzh(T paramT)
  {
    this.zzzx.zzh(paramT);
    this.zzzy.zzh(paramT);
  }
  
  public final int zzs(T paramT)
  {
    zzjo localzzjo = this.zzzx;
    int i = localzzjo.zzy(localzzjo.zzw(paramT)) + 0;
    int j = i;
    if (this.zzzo) {
      j = i + this.zzzy.zzf(paramT).zzfp();
    }
    return j;
  }
  
  public final boolean zzu(T paramT)
  {
    return this.zzzy.zzf(paramT).isInitialized();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */