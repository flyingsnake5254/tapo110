package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzff;
import com.google.android.gms.measurement.internal.zzff.zza;

public final class AppMeasurementReceiver
  extends WakefulBroadcastReceiver
  implements zzff.zza
{
  private zzff zza;
  
  @NonNull
  public BroadcastReceiver.PendingResult doGoAsync()
  {
    return goAsync();
  }
  
  @MainThread
  public void doStartService(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    WakefulBroadcastReceiver.startWakefulService(paramContext, paramIntent);
  }
  
  @MainThread
  public void onReceive(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    if (this.zza == null) {
      this.zza = new zzff(this);
    }
    this.zza.zza(paramContext, paramIntent);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\AppMeasurementReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */