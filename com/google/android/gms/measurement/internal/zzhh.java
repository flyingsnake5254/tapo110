package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class zzhh
  implements Runnable
{
  zzhh(zzhw paramzzhw, Bundle paramBundle) {}
  
  public final void run()
  {
    zzhw localzzhw = this.zzb;
    Bundle localBundle = this.zza;
    localzzhw.zzg();
    localzzhw.zzb();
    Preconditions.checkNotNull(localBundle);
    Preconditions.checkNotEmpty(localBundle.getString("name"));
    Object localObject;
    if (localzzhw.zzs.zzF()) {
      if (localzzhw.zzs.zzc().zzn(null, zzea.zzax)) {
        localObject = new zzkq(localBundle.getString("name"), 0L, null, "");
      } else {
        localObject = new zzkq(localBundle.getString("name"), 0L, null, null);
      }
    }
    try
    {
      zzas localzzas = localzzhw.zzs.zzl().zzV(localBundle.getString("app_id"), localBundle.getString("expired_event_name"), localBundle.getBundle("expired_event_params"), localBundle.getString("origin"), localBundle.getLong("creation_timestamp"), true, false);
      localObject = new zzaa(localBundle.getString("app_id"), localBundle.getString("origin"), (zzkq)localObject, localBundle.getLong("creation_timestamp"), localBundle.getBoolean("active"), localBundle.getString("trigger_event_name"), null, localBundle.getLong("trigger_timeout"), null, localBundle.getLong("time_to_live"), localzzas);
      localzzhw.zzs.zzy().zzm((zzaa)localObject);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    localzzhw.zzs.zzau().zzk().zza("Conditional property not cleared since app measurement is disabled");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzhh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */