package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.util.i;

final class e
  implements c
{
  private final Context c;
  final c.a d;
  boolean f;
  private boolean q;
  private final BroadcastReceiver x = new a();
  
  e(@NonNull Context paramContext, @NonNull c.a parama)
  {
    this.c = paramContext.getApplicationContext();
    this.d = parama;
  }
  
  private void i()
  {
    if (this.q) {
      return;
    }
    this.f = g(this.c);
    try
    {
      Context localContext = this.c;
      BroadcastReceiver localBroadcastReceiver = this.x;
      IntentFilter localIntentFilter = new android/content/IntentFilter;
      localIntentFilter.<init>("android.net.conn.CONNECTIVITY_CHANGE");
      localContext.registerReceiver(localBroadcastReceiver, localIntentFilter);
      this.q = true;
    }
    catch (SecurityException localSecurityException)
    {
      if (Log.isLoggable("ConnectivityMonitor", 5)) {
        Log.w("ConnectivityMonitor", "Failed to register", localSecurityException);
      }
    }
  }
  
  private void k()
  {
    if (!this.q) {
      return;
    }
    this.c.unregisterReceiver(this.x);
    this.q = false;
  }
  
  @SuppressLint({"MissingPermission"})
  boolean g(@NonNull Context paramContext)
  {
    paramContext = (ConnectivityManager)i.d((ConnectivityManager)paramContext.getSystemService("connectivity"));
    boolean bool = true;
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isConnected())) {
        bool = false;
      }
      return bool;
    }
    catch (RuntimeException paramContext)
    {
      if (Log.isLoggable("ConnectivityMonitor", 5)) {
        Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", paramContext);
      }
    }
    return true;
  }
  
  public void onDestroy() {}
  
  public void onStart()
  {
    i();
  }
  
  public void onStop()
  {
    k();
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(@NonNull Context paramContext, Intent paramIntent)
    {
      paramIntent = e.this;
      boolean bool = paramIntent.f;
      paramIntent.f = paramIntent.g(paramContext);
      if (bool != e.this.f)
      {
        if (Log.isLoggable("ConnectivityMonitor", 3))
        {
          paramContext = new StringBuilder();
          paramContext.append("connectivity changed, isConnected: ");
          paramContext.append(e.this.f);
          Log.d("ConnectivityMonitor", paramContext.toString());
        }
        paramContext = e.this;
        paramContext.d.a(paramContext.f);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\manager\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */