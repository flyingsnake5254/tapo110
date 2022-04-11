package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzfy<T>
  implements zzgi<T>
{
  private final zzfv zza;
  private final zzha<?, ?> zzb;
  private final boolean zzc;
  private final zzea<?> zzd;
  
  private zzfy(zzha<?, ?> paramzzha, zzea<?> paramzzea, zzfv paramzzfv)
  {
    this.zzb = paramzzha;
    this.zzc = paramzzea.zza(paramzzfv);
    this.zzd = paramzzea;
    this.zza = paramzzfv;
  }
  
  static <T> zzfy<T> zza(zzha<?, ?> paramzzha, zzea<?> paramzzea, zzfv paramzzfv)
  {
    return new zzfy(paramzzha, paramzzea, paramzzfv);
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
  
  public final void zza(T paramT, zzhu paramzzhu)
    throws IOException
  {
    Iterator localIterator = this.zzd.zza(paramT).zzd();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      zzeh localzzeh = (zzeh)((Map.Entry)localObject).getKey();
      if ((localzzeh.zzc() == zzhv.zzi) && (!localzzeh.zzd()) && (!localzzeh.zze()))
      {
        if ((localObject instanceof zzey)) {
          paramzzhu.zza(localzzeh.zza(), ((zzey)localObject).zza().zzc());
        } else {
          paramzzhu.zza(localzzeh.zza(), ((Map.Entry)localObject).getValue());
        }
      }
      else {
        throw new IllegalStateException("Found invalid MessageSet item.");
      }
    }
    Object localObject = this.zzb;
    ((zzha)localObject).zzb(((zzha)localObject).zza(paramT), paramzzhu);
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
  
  public final void zzb(T paramT)
  {
    this.zzb.zzb(paramT);
    this.zzd.zzc(paramT);
  }
  
  public final void zzb(T paramT1, T paramT2)
  {
    zzgk.zza(this.zzb, paramT1, paramT2);
    if (this.zzc) {
      zzgk.zza(this.zzd, paramT1, paramT2);
    }
  }
  
  public final boolean zzc(T paramT)
  {
    return this.zzd.zza(paramT).zzf();
  }
  
  public final int zzd(T paramT)
  {
    zzha localzzha = this.zzb;
    int i = localzzha.zzc(localzzha.zza(paramT)) + 0;
    int j = i;
    if (this.zzc) {
      j = i + this.zzd.zza(paramT).zzg();
    }
    return j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */