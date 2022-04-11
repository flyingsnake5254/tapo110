package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public final class zzv
  extends zzai
{
  final Map<String, zzai> zza = new HashMap();
  private final zzj zzb;
  
  public zzv(zzj paramzzj)
  {
    super("require");
    this.zzb = paramzzj;
  }
  
  public final zzap zza(zzg paramzzg, List<zzap> paramList)
  {
    zzh.zza("require", 1, paramList);
    paramList = paramzzg.zza((zzap)paramList.get(0)).zzc();
    if (this.zza.containsKey(paramList)) {
      return (zzap)this.zza.get(paramList);
    }
    paramzzg = this.zzb;
    if (paramzzg.zza.containsKey(paramList))
    {
      paramzzg = (Callable)paramzzg.zza.get(paramList);
      try
      {
        paramzzg = (zzap)paramzzg.call();
      }
      catch (Exception paramzzg)
      {
        paramzzg = String.valueOf(paramList);
        if (paramzzg.length() != 0) {
          paramzzg = "Failed to create API implementation: ".concat(paramzzg);
        } else {
          paramzzg = new String("Failed to create API implementation: ");
        }
        throw new IllegalStateException(paramzzg);
      }
    }
    else
    {
      paramzzg = zzap.zzf;
    }
    if ((paramzzg instanceof zzai)) {
      this.zza.put(paramList, (zzai)paramzzg);
    }
    return paramzzg;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */