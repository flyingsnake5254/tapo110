package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzdw
  extends zzdt
{
  zzdw(zzed paramzzed, Bundle paramBundle, Activity paramActivity)
  {
    super(paramzzed.zza, true);
  }
  
  final void zza()
    throws RemoteException
  {
    Bundle localBundle2;
    if (this.zza != null)
    {
      Bundle localBundle1 = new Bundle();
      localBundle2 = localBundle1;
      if (this.zza.containsKey("com.google.app_measurement.screen_service"))
      {
        Object localObject = this.zza.get("com.google.app_measurement.screen_service");
        localBundle2 = localBundle1;
        if ((localObject instanceof Bundle))
        {
          localBundle1.putBundle("com.google.app_measurement.screen_service", (Bundle)localObject);
          localBundle2 = localBundle1;
        }
      }
    }
    else
    {
      localBundle2 = null;
    }
    ((zzcc)Preconditions.checkNotNull(zzee.zzP(this.zzc.zza))).onActivityCreated(ObjectWrapper.wrap(this.zzb), localBundle2, this.zzi);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzdw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */