package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class zzai
  implements zzap, zzal
{
  protected final String zzd;
  protected final Map<String, zzap> zze = new HashMap();
  
  public zzai(String paramString)
  {
    this.zzd = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzai)) {
      return false;
    }
    zzai localzzai = (zzai)paramObject;
    paramObject = this.zzd;
    if (paramObject != null) {
      return ((String)paramObject).equals(localzzai.zzd);
    }
    return false;
  }
  
  public final int hashCode()
  {
    String str = this.zzd;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  public abstract zzap zza(zzg paramzzg, List<zzap> paramList);
  
  public final zzap zzbK(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    if ("toString".equals(paramString)) {
      return new zzat(this.zzd);
    }
    return zzaj.zza(this, new zzat(paramString), paramzzg, paramList);
  }
  
  public final String zzc()
  {
    return this.zzd;
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
    return zzaj.zzb(this.zze);
  }
  
  public final String zzg()
  {
    return this.zzd;
  }
  
  public final boolean zzj(String paramString)
  {
    return this.zze.containsKey(paramString);
  }
  
  public final zzap zzk(String paramString)
  {
    if (this.zze.containsKey(paramString)) {
      return (zzap)this.zze.get(paramString);
    }
    return zzap.zzf;
  }
  
  public final void zzm(String paramString, zzap paramzzap)
  {
    if (paramzzap == null)
    {
      this.zze.remove(paramString);
      return;
    }
    this.zze.put(paramString, paramzzap);
  }
  
  public zzap zzt()
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */