package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzgo<T>
  implements zzgy<T>
{
  private final zzgh zza;
  private final zzhq<?, ?> zzb;
  private final boolean zzc;
  private final zzeq<?> zzd;
  
  private zzgo(zzhq<?, ?> paramzzhq, zzeq<?> paramzzeq, zzgh paramzzgh)
  {
    this.zzb = paramzzhq;
    this.zzc = paramzzeq.zza(paramzzgh);
    this.zzd = paramzzeq;
    this.zza = paramzzgh;
  }
  
  static <T> zzgo<T> zza(zzhq<?, ?> paramzzhq, zzeq<?> paramzzeq, zzgh paramzzgh)
  {
    return new zzgo(paramzzhq, paramzzeq, paramzzgh);
  }
  
  public final int zza(T paramT)
  {
    int i = this.zzb.zza(paramT).hashCode();
    int j = i;
    if (this.zzc) {
      j = i * 53 + this.zzd.zza(paramT).hashCode();
    }
    return j;
  }
  
  public final void zza(T paramT, zzik paramzzik)
    throws IOException
  {
    Iterator localIterator = this.zzd.zza(paramT).zzd();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      zzet localzzet = (zzet)((Map.Entry)localObject).getKey();
      if ((localzzet.zzc() == zzih.zzi) && (!localzzet.zzd()) && (!localzzet.zze()))
      {
        if ((localObject instanceof zzfo)) {
          paramzzik.zza(localzzet.zza(), ((zzfo)localObject).zza().zzc());
        } else {
          paramzzik.zza(localzzet.zza(), ((Map.Entry)localObject).getValue());
        }
      }
      else {
        throw new IllegalStateException("Found invalid MessageSet item.");
      }
    }
    Object localObject = this.zzb;
    ((zzhq)localObject).zzb(((zzhq)localObject).zza(paramT), paramzzik);
  }
  
  public final boolean zza(T paramT1, T paramT2)
  {
    if (!this.zzb.zza(paramT1).equals(this.zzb.zza(paramT2))) {
      return false;
    }
    if (this.zzc) {
      return this.zzd.zza(paramT1).equals(this.zzd.zza(paramT2));
    }
    return true;
  }
  
  public final int zzb(T paramT)
  {
    zzhq localzzhq = this.zzb;
    int i = localzzhq.zzc(localzzhq.zza(paramT)) + 0;
    int j = i;
    if (this.zzc) {
      j = i + this.zzd.zza(paramT).zzg();
    }
    return j;
  }
  
  public final void zzb(T paramT1, T paramT2)
  {
    zzha.zza(this.zzb, paramT1, paramT2);
    if (this.zzc) {
      zzha.zza(this.zzd, paramT1, paramT2);
    }
  }
  
  public final void zzc(T paramT)
  {
    this.zzb.zzb(paramT);
    this.zzd.zzc(paramT);
  }
  
  public final boolean zzd(T paramT)
  {
    return this.zzd.zza(paramT).zzf();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzgo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */