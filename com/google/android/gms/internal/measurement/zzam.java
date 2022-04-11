package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzam
  implements zzap, zzal
{
  final Map<String, zzap> zza = new HashMap();
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzam)) {
      return false;
    }
    paramObject = (zzam)paramObject;
    return this.zza.equals(((zzam)paramObject).zza);
  }
  
  public final int hashCode()
  {
    return this.zza.hashCode();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    if (!this.zza.isEmpty())
    {
      Iterator localIterator = this.zza.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(String.format("%s: %s,", new Object[] { str, this.zza.get(str) }));
      }
      localStringBuilder.deleteCharAt(localStringBuilder.lastIndexOf(","));
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final List<String> zzb()
  {
    return new ArrayList(this.zza.keySet());
  }
  
  public zzap zzbK(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    if ("toString".equals(paramString)) {
      return new zzat(toString());
    }
    return zzaj.zza(this, new zzat(paramString), paramzzg, paramList);
  }
  
  public final String zzc()
  {
    return "[object Object]";
  }
  
  public final Double zzd()
  {
    return Double.valueOf(NaN.0D);
  }
  
  public final Boolean zze()
  {
    return Boolean.TRUE;
  }
  
  public final Iterator<zzap> zzf()
  {
    return zzaj.zzb(this.zza);
  }
  
  public final boolean zzj(String paramString)
  {
    return this.zza.containsKey(paramString);
  }
  
  public final zzap zzk(String paramString)
  {
    if (this.zza.containsKey(paramString)) {
      return (zzap)this.zza.get(paramString);
    }
    return zzap.zzf;
  }
  
  public final void zzm(String paramString, zzap paramzzap)
  {
    if (paramzzap == null)
    {
      this.zza.remove(paramString);
      return;
    }
    this.zza.put(paramString, paramzzap);
  }
  
  public final zzap zzt()
  {
    zzam localzzam = new zzam();
    Iterator localIterator = this.zza.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof zzal)) {
        localzzam.zza.put((String)localEntry.getKey(), (zzap)localEntry.getValue());
      } else {
        localzzam.zza.put((String)localEntry.getKey(), ((zzap)localEntry.getValue()).zzt());
      }
    }
    return localzzam;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */