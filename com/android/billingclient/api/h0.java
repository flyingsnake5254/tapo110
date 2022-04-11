package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.play_billing.zza;

final class h0
  extends BroadcastReceiver
{
  private final k a;
  private boolean b;
  
  public final void a(Context paramContext, IntentFilter paramIntentFilter)
  {
    if (!this.b)
    {
      paramContext.registerReceiver(i0.d(this.c), paramIntentFilter);
      this.b = true;
    }
  }
  
  public final void b(Context paramContext)
  {
    if (this.b)
    {
      paramContext.unregisterReceiver(i0.d(this.c));
      this.b = false;
      return;
    }
    zza.zzb("BillingBroadcastManager", "Receiver is not registered.");
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = zza.zzc(paramIntent, "BillingBroadcastManager");
    paramIntent = zza.zzf(paramIntent.getExtras());
    this.a.a(paramContext, paramIntent);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */