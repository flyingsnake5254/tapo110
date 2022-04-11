package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

final class w0
  implements Runnable
{
  w0(d paramd, int paramInt, i parami, g paramg, String paramString) {}
  
  public final void run()
  {
    int i = this.c;
    StringBuilder localStringBuilder = new StringBuilder(63);
    localStringBuilder.append("Error consuming purchase with token. Response code: ");
    localStringBuilder.append(i);
    zza.zzb("BillingClient", localStringBuilder.toString());
    this.d.a(this.f, this.q);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\w0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */