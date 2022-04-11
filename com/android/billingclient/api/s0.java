package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;
import java.util.concurrent.Future;

final class s0
  implements Runnable
{
  s0(d paramd, Future paramFuture, Runnable paramRunnable) {}
  
  public final void run()
  {
    if ((!this.c.isDone()) && (!this.c.isCancelled()))
    {
      this.c.cancel(true);
      zza.zzb("BillingClient", "Async task is taking too long, cancel it!");
      Runnable localRunnable = this.d;
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\s0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */