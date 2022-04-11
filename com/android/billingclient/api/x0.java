package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

final class x0
  implements Runnable
{
  x0(d paramd, Exception paramException, i parami, String paramString) {}
  
  public final void run()
  {
    String str = String.valueOf(this.c);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 30);
    localStringBuilder.append("Error consuming purchase; ex: ");
    localStringBuilder.append(str);
    zza.zzb("BillingClient", localStringBuilder.toString());
    this.d.a(y.q, this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\x0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */