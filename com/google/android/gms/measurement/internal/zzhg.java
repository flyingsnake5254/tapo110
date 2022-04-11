package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class zzhg
  implements Runnable
{
  zzhg(zzhw paramzzhw, Bundle paramBundle) {}
  
  public final void run()
  {
    zzhw localzzhw = this.zzb;
    Object localObject1 = this.zza;
    localzzhw.zzg();
    localzzhw.zzb();
    Preconditions.checkNotNull(localObject1);
    Object localObject2 = ((Bundle)localObject1).getString("name");
    String str = ((Bundle)localObject1).getString("origin");
    Preconditions.checkNotEmpty((String)localObject2);
    Preconditions.checkNotEmpty(str);
    Preconditions.checkNotNull(((Bundle)localObject1).get("value"));
    if (!localzzhw.zzs.zzF())
    {
      localzzhw.zzs.zzau().zzk().zza("Conditional property not set since app measurement is disabled");
      return;
    }
    zzkq localzzkq = new zzkq((String)localObject2, ((Bundle)localObject1).getLong("triggered_timestamp"), ((Bundle)localObject1).get("value"), str);
    try
    {
      zzas localzzas1 = localzzhw.zzs.zzl().zzV(((Bundle)localObject1).getString("app_id"), ((Bundle)localObject1).getString("triggered_event_name"), ((Bundle)localObject1).getBundle("triggered_event_params"), str, 0L, true, false);
      zzas localzzas2 = localzzhw.zzs.zzl().zzV(((Bundle)localObject1).getString("app_id"), ((Bundle)localObject1).getString("timed_out_event_name"), ((Bundle)localObject1).getBundle("timed_out_event_params"), str, 0L, true, false);
      localObject2 = localzzhw.zzs.zzl().zzV(((Bundle)localObject1).getString("app_id"), ((Bundle)localObject1).getString("expired_event_name"), ((Bundle)localObject1).getBundle("expired_event_params"), str, 0L, true, false);
      localObject1 = new zzaa(((Bundle)localObject1).getString("app_id"), str, localzzkq, ((Bundle)localObject1).getLong("creation_timestamp"), false, ((Bundle)localObject1).getString("trigger_event_name"), localzzas2, ((Bundle)localObject1).getLong("trigger_timeout"), localzzas1, ((Bundle)localObject1).getLong("time_to_live"), (zzas)localObject2);
      localzzhw.zzs.zzy().zzm((zzaa)localObject1);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzhg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */