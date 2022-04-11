package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzbr;

final class zzfc
  implements Runnable
{
  zzfc(zzfd paramzzfd, zzbr paramzzbr, ServiceConnection paramServiceConnection) {}
  
  public final void run()
  {
    Object localObject1 = this.zzc;
    zzfe localzzfe = ((zzfd)localObject1).zza;
    localObject1 = zzfd.zza((zzfd)localObject1);
    Object localObject2 = this.zza;
    ServiceConnection localServiceConnection = this.zzb;
    localzzfe.zza.zzav().zzg();
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putString("package_name", (String)localObject1);
    localObject1 = null;
    try
    {
      localObject2 = ((zzbr)localObject2).zzd((Bundle)localObject3);
      if (localObject2 == null) {
        localzzfe.zza.zzau().zzb().zza("Install Referrer Service returned a null response");
      } else {
        localObject1 = localObject2;
      }
    }
    catch (Exception localException)
    {
      localzzfe.zza.zzau().zzb().zzb("Exception occurred while retrieving the Install Referrer", localException.getMessage());
    }
    localzzfe.zza.zzav().zzg();
    if (localObject1 != null)
    {
      long l1 = ((Bundle)localObject1).getLong("install_begin_timestamp_seconds", 0L) * 1000L;
      if (l1 == 0L)
      {
        localzzfe.zza.zzau().zze().zza("Service response is missing Install Referrer install timestamp");
      }
      else
      {
        String str = ((Bundle)localObject1).getString("install_referrer");
        if ((str != null) && (!str.isEmpty()))
        {
          localzzfe.zza.zzau().zzk().zzb("InstallReferrer API result", str);
          localObject3 = localzzfe.zza.zzl();
          if (str.length() != 0) {
            str = "?".concat(str);
          } else {
            str = new String("?");
          }
          localObject3 = ((zzku)localObject3).zzi(Uri.parse(str));
          if (localObject3 == null)
          {
            localzzfe.zza.zzau().zzb().zza("No campaign params defined in Install Referrer result");
          }
          else
          {
            str = ((Bundle)localObject3).getString("medium");
            if ((str != null) && (!"(not set)".equalsIgnoreCase(str)) && (!"organic".equalsIgnoreCase(str)))
            {
              long l2 = ((Bundle)localObject1).getLong("referrer_click_timestamp_seconds", 0L) * 1000L;
              if (l2 == 0L) {
                localzzfe.zza.zzau().zzb().zza("Install Referrer is missing click timestamp for ad campaign");
              } else {
                ((Bundle)localObject3).putLong("click_timestamp", l2);
              }
            }
            else if (l1 == localzzfe.zza.zzd().zzd.zza())
            {
              localzzfe.zza.zzau().zzk().zza("Install Referrer campaign has already been logged");
            }
            else if (localzzfe.zza.zzF())
            {
              localzzfe.zza.zzd().zzd.zzb(l1);
              localzzfe.zza.zzau().zzk().zzb("Logging Install Referrer campaign from sdk with ", "referrer API");
              ((Bundle)localObject3).putString("_cis", "referrer API");
              localzzfe.zza.zzk().zzs("auto", "_cmp", (Bundle)localObject3);
            }
          }
        }
        else
        {
          localzzfe.zza.zzau().zzb().zza("No referrer defined in Install Referrer response");
        }
      }
    }
    ConnectionTracker.getInstance().unbindService(localzzfe.zza.zzax(), localServiceConnection);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */