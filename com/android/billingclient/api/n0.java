package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

final class n0
  implements Runnable
{
  n0(p0 paramp0, Exception paramException) {}
  
  public final void run()
  {
    String str = String.valueOf(this.c);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 32);
    localStringBuilder.append("Error acknowledge purchase; ex: ");
    localStringBuilder.append(str);
    zza.zzb("BillingClient", localStringBuilder.toString());
    this.d.d.a(y.q);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\n0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */