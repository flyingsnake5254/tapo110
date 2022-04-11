package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzax
{
  final Map<String, zzaw> zza = new HashMap();
  final zzbj zzb = new zzbj();
  
  public zzax()
  {
    zza(new zzav());
    zza(new zzay());
    zza(new zzaz());
    zza(new zzbc());
    zza(new zzbh());
    zza(new zzbi());
    zza(new zzbk());
  }
  
  final void zza(zzaw paramzzaw)
  {
    Iterator localIterator = paramzzaw.zza.iterator();
    while (localIterator.hasNext())
    {
      String str = ((zzbl)localIterator.next()).zzb().toString();
      this.zza.put(str, paramzzaw);
    }
  }
  
  public final zzap zzb(zzg paramzzg, zzap paramzzap)
  {
    zzh.zzk(paramzzg);
    if ((paramzzap instanceof zzaq))
    {
      paramzzap = (zzaq)paramzzap;
      ArrayList localArrayList = paramzzap.zzg();
      String str = paramzzap.zzb();
      if (this.zza.containsKey(str)) {
        paramzzap = (zzaw)this.zza.get(str);
      } else {
        paramzzap = this.zzb;
      }
      return paramzzap.zza(str, paramzzg, localArrayList);
    }
    return paramzzap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */