package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

public final class zzt
  extends zzai
{
  private final zzr zza;
  
  public zzt(zzr paramzzr)
  {
    super("internal.logger");
    this.zza = paramzzr;
    this.zze.put("log", new zzs(this, false, true));
    this.zze.put("silent", new zzp(this, "silent"));
    ((zzai)this.zze.get("silent")).zzm("log", new zzs(this, true, true));
    this.zze.put("unmonitored", new zzq(this, "unmonitored"));
    ((zzai)this.zze.get("unmonitored")).zzm("log", new zzs(this, false, false));
  }
  
  public final zzap zza(zzg paramzzg, List<zzap> paramList)
  {
    return zzap.zzf;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */