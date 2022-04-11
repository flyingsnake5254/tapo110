package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

final class zzeu
  extends BroadcastReceiver
{
  @VisibleForTesting
  static final String zza = zzeu.class.getName();
  private final zzkn zzb;
  private boolean zzc;
  private boolean zzd;
  
  zzeu(zzkn paramzzkn)
  {
    Preconditions.checkNotNull(paramzzkn);
    this.zzb = paramzzkn;
  }
  
  @MainThread
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    this.zzb.zzr();
    paramContext = paramIntent.getAction();
    this.zzb.zzau().zzk().zzb("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      boolean bool = this.zzb.zzh().zzb();
      if (this.zzd != bool)
      {
        this.zzd = bool;
        this.zzb.zzav().zzh(new zzet(this, bool));
      }
      return;
    }
    this.zzb.zzau().zze().zzb("NetworkBroadcastReceiver received unknown action", paramContext);
  }
  
  @WorkerThread
  public final void zza()
  {
    this.zzb.zzr();
    this.zzb.zzav().zzg();
    if (this.zzc) {
      return;
    }
    this.zzb.zzax().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    this.zzd = this.zzb.zzh().zzb();
    this.zzb.zzau().zzk().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
    this.zzc = true;
  }
  
  @WorkerThread
  public final void zzb()
  {
    this.zzb.zzr();
    this.zzb.zzav().zzg();
    this.zzb.zzav().zzg();
    if (this.zzc)
    {
      this.zzb.zzau().zzk().zza("Unregistering connectivity change receiver");
      this.zzc = false;
      this.zzd = false;
      Context localContext = this.zzb.zzax();
      try
      {
        localContext.unregisterReceiver(this);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.zzb.zzau().zzb().zzb("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzeu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */