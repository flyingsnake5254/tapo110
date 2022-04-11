package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public final class zzz
{
  final TreeMap<Integer, zzao> zza = new TreeMap();
  final TreeMap<Integer, zzao> zzb = new TreeMap();
  
  private static final int zzc(zzg paramzzg, zzao paramzzao, zzap paramzzap)
  {
    paramzzg = paramzzao.zza(paramzzg, Collections.singletonList(paramzzap));
    if ((paramzzg instanceof zzah)) {
      return zzh.zzg(paramzzg.zzd().doubleValue());
    }
    return -1;
  }
  
  public final void zza(String paramString1, int paramInt, zzao paramzzao, String paramString2)
  {
    if ("create".equals(paramString2))
    {
      paramString1 = this.zzb;
    }
    else
    {
      if (!"edit".equals(paramString2)) {
        break label73;
      }
      paramString1 = this.zza;
    }
    int i = paramInt;
    if (paramString1.containsKey(Integer.valueOf(paramInt))) {
      i = ((Integer)paramString1.lastKey()).intValue() + 1;
    }
    paramString1.put(Integer.valueOf(i), paramzzao);
    return;
    label73:
    paramString1 = String.valueOf(paramString2);
    if (paramString1.length() != 0) {
      paramString1 = "Unknown callback type: ".concat(paramString1);
    } else {
      paramString1 = new String("Unknown callback type: ");
    }
    throw new IllegalStateException(paramString1);
  }
  
  public final void zzb(zzg paramzzg, zzab paramzzab)
  {
    zzl localzzl = new zzl(paramzzab);
    Iterator localIterator = this.zza.keySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localObject = paramzzab.zzc().zzg();
      int i = zzc(paramzzg, (zzao)this.zza.get(localInteger), localzzl);
      if ((i == 2) || (i == -1)) {
        paramzzab.zzd((zzaa)localObject);
      }
    }
    paramzzab = this.zzb.keySet().iterator();
    while (paramzzab.hasNext())
    {
      localObject = (Integer)paramzzab.next();
      zzc(paramzzg, (zzao)this.zzb.get(localObject), localzzl);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */