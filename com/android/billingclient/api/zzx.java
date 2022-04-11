package com.android.billingclient.api;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zza;

final class zzx
  extends ResultReceiver
{
  public final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    g.a locala = g.b();
    locala.c(paramInt);
    locala.b(zza.zze(paramBundle, "BillingClient"));
    paramBundle = locala.a();
    this.c.a(paramBundle);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */