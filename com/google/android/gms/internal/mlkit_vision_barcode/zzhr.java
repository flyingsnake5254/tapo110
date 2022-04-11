package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzhr<T>
  implements zzib<T>
{
  private final zzhk zza;
  private final zzit<?, ?> zzb;
  private final boolean zzc;
  private final zzfr<?> zzd;
  
  private zzhr(zzit<?, ?> paramzzit, zzfr<?> paramzzfr, zzhk paramzzhk)
  {
    this.zzb = paramzzit;
    this.zzc = paramzzfr.zza(paramzzhk);
    this.zzd = paramzzfr;
    this.zza = paramzzhk;
  }
  
  static <T> zzhr<T> zza(zzit<?, ?> paramzzit, zzfr<?> paramzzfr, zzhk paramzzhk)
  {
    return new zzhr(paramzzit, paramzzfr, paramzzhk);
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
  
  public final void zza(T paramT, zzjn paramzzjn)
    throws IOException
  {
    Iterator localIterator = this.zzd.zza(paramT).zzd();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localObject = (zzfu)localEntry.getKey();
      if ((((zzfu)localObject).zzc() == zzjk.zzi) && (!((zzfu)localObject).zzd()) && (!((zzfu)localObject).zze()))
      {
        if ((localEntry instanceof zzgr)) {
          paramzzjn.zza(((zzfu)localObject).zza(), ((zzgr)localEntry).zza().zzc());
        } else {
          paramzzjn.zza(((zzfu)localObject).zza(), localEntry.getValue());
        }
      }
      else {
        throw new IllegalStateException("Found invalid MessageSet item.");
      }
    }
    Object localObject = this.zzb;
    ((zzit)localObject).zzb(((zzit)localObject).zza(paramT), paramzzjn);
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
    zzit localzzit = this.zzb;
    int i = localzzit.zzc(localzzit.zza(paramT)) + 0;
    int j = i;
    if (this.zzc) {
      j = i + this.zzd.zza(paramT).zzg();
    }
    return j;
  }
  
  public final void zzb(T paramT1, T paramT2)
  {
    zzid.zza(this.zzb, paramT1, paramT2);
    if (this.zzc) {
      zzid.zza(this.zzd, paramT1, paramT2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzhr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */