package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzc;

final class v
  implements ServiceConnection
{
  private final Object c;
  private boolean d;
  private e f;
  
  private final void f(g paramg)
  {
    d.s(this.q, new s(this, paramg));
  }
  
  final void a()
  {
    synchronized (this.c)
    {
      this.f = null;
      this.d = true;
      return;
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    zza.zza("BillingClient", "Billing service connected.");
    d.v(this.q, zzc.zzo(paramIBinder));
    if (d.J(this.q, new t(this), 30000L, new u(this)) == null) {
      f(d.K(this.q));
    }
  }
  
  public final void onServiceDisconnected(ComponentName arg1)
  {
    zza.zzb("BillingClient", "Billing service disconnected.");
    d.v(this.q, null);
    d.w(this.q, 0);
    synchronized (this.c)
    {
      e locale = this.f;
      if (locale != null) {
        locale.b();
      }
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */