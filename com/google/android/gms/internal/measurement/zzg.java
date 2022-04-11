package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzg
{
  public final zzg zza;
  final zzax zzb;
  final Map<String, zzap> zzc = new HashMap();
  final Map<String, Boolean> zzd = new HashMap();
  
  public zzg(zzg paramzzg, zzax paramzzax)
  {
    this.zza = paramzzg;
    this.zzb = paramzzax;
  }
  
  public final zzap zza(zzap paramzzap)
  {
    return this.zzb.zzb(this, paramzzap);
  }
  
  public final zzap zzb(zzae paramzzae)
  {
    Object localObject = zzap.zzf;
    Iterator localIterator = paramzzae.zzg();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      zzap localzzap = this.zzb.zzb(this, paramzzae.zzl(i));
      localObject = localzzap;
      if ((localzzap instanceof zzag)) {
        localObject = localzzap;
      }
    }
    return (zzap)localObject;
  }
  
  public final zzg zzc()
  {
    return new zzg(this, this.zzb);
  }
  
  public final boolean zzd(String paramString)
  {
    if (this.zzc.containsKey(paramString)) {
      return true;
    }
    zzg localzzg = this.zza;
    if (localzzg != null) {
      return localzzg.zzd(paramString);
    }
    return false;
  }
  
  public final void zze(String paramString, zzap paramzzap)
  {
    if (!this.zzc.containsKey(paramString))
    {
      zzg localzzg = this.zza;
      if ((localzzg != null) && (localzzg.zzd(paramString)))
      {
        this.zza.zze(paramString, paramzzap);
        return;
      }
    }
    if (this.zzd.containsKey(paramString)) {
      return;
    }
    if (paramzzap == null)
    {
      this.zzc.remove(paramString);
      return;
    }
    this.zzc.put(paramString, paramzzap);
  }
  
  public final void zzf(String paramString, zzap paramzzap)
  {
    if (this.zzd.containsKey(paramString)) {
      return;
    }
    if (paramzzap == null)
    {
      this.zzc.remove(paramString);
      return;
    }
    this.zzc.put(paramString, paramzzap);
  }
  
  public final void zzg(String paramString, zzap paramzzap)
  {
    zzf(paramString, paramzzap);
    this.zzd.put(paramString, Boolean.TRUE);
  }
  
  public final zzap zzh(String paramString)
  {
    if (this.zzc.containsKey(paramString)) {
      return (zzap)this.zzc.get(paramString);
    }
    zzg localzzg = this.zza;
    if (localzzg != null) {
      return localzzg.zzh(paramString);
    }
    throw new IllegalArgumentException(String.format("%s is not defined", new Object[] { paramString }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */