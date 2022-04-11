package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzab
{
  private zzaa zza;
  private zzaa zzb;
  private final List<zzaa> zzc;
  
  public zzab()
  {
    this.zza = new zzaa("", 0L, null);
    this.zzb = new zzaa("", 0L, null);
    this.zzc = new ArrayList();
  }
  
  public zzab(zzaa paramzzaa)
  {
    this.zza = paramzzaa;
    this.zzb = paramzzaa.zzg();
    this.zzc = new ArrayList();
  }
  
  public final zzaa zza()
  {
    return this.zza;
  }
  
  public final void zzb(zzaa paramzzaa)
  {
    this.zza = paramzzaa;
    this.zzb = paramzzaa.zzg();
    this.zzc.clear();
  }
  
  public final zzaa zzc()
  {
    return this.zzb;
  }
  
  public final void zzd(zzaa paramzzaa)
  {
    this.zzb = paramzzaa;
  }
  
  public final void zze(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    this.zzc.add(new zzaa(paramString, paramLong, paramMap));
  }
  
  public final List<zzaa> zzf()
  {
    return this.zzc;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */