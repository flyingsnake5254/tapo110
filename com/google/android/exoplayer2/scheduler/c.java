package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

public final class c
{
  private final Context a;
  private final c b;
  private final Requirements c;
  private final Handler d;
  @Nullable
  private b e;
  private int f;
  @Nullable
  private d g;
  
  public c(Context paramContext, c paramc, Requirements paramRequirements)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramc;
    this.c = paramRequirements;
    this.d = o0.x();
  }
  
  private void e()
  {
    int i = this.c.b(this.a);
    if (this.f != i)
    {
      this.f = i;
      this.b.a(this, i);
    }
  }
  
  private void g()
  {
    if ((this.f & 0x3) == 0) {
      return;
    }
    e();
  }
  
  @RequiresApi(24)
  private void h()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)g.e((ConnectivityManager)this.a.getSystemService("connectivity"));
    d locald = new d(null);
    this.g = locald;
    localConnectivityManager.registerDefaultNetworkCallback(locald);
  }
  
  @RequiresApi(24)
  private void k()
  {
    ((ConnectivityManager)g.e((ConnectivityManager)this.a.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback)g.e(this.g));
    this.g = null;
  }
  
  public Requirements f()
  {
    return this.c;
  }
  
  public int i()
  {
    this.f = this.c.b(this.a);
    IntentFilter localIntentFilter = new IntentFilter();
    if (this.c.l()) {
      if (o0.a >= 24) {
        h();
      } else {
        localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      }
    }
    if (this.c.d())
    {
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
    }
    if (this.c.h()) {
      if (o0.a >= 23)
      {
        localIntentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
      }
      else
      {
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      }
    }
    if (this.c.n())
    {
      localIntentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
      localIntentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
    }
    b localb = new b(null);
    this.e = localb;
    this.a.registerReceiver(localb, localIntentFilter, null, this.d);
    return this.f;
  }
  
  public void j()
  {
    this.a.unregisterReceiver((BroadcastReceiver)g.e(this.e));
    this.e = null;
    if ((o0.a >= 24) && (this.g != null)) {
      k();
    }
  }
  
  private class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (!isInitialStickyBroadcast()) {
        c.a(c.this);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(c paramc, int paramInt);
  }
  
  @RequiresApi(24)
  private final class d
    extends ConnectivityManager.NetworkCallback
  {
    private boolean a;
    private boolean b;
    
    private d() {}
    
    private void e()
    {
      c.b(c.this).post(new a(this));
    }
    
    private void f()
    {
      c.b(c.this).post(new b(this));
    }
    
    public void onAvailable(Network paramNetwork)
    {
      e();
    }
    
    public void onBlockedStatusChanged(Network paramNetwork, boolean paramBoolean)
    {
      if (!paramBoolean) {
        f();
      }
    }
    
    public void onCapabilitiesChanged(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities)
    {
      boolean bool = paramNetworkCapabilities.hasCapability(16);
      if ((this.a) && (this.b == bool))
      {
        if (bool) {
          f();
        }
      }
      else
      {
        this.a = true;
        this.b = bool;
        e();
      }
    }
    
    public void onLost(Network paramNetwork)
    {
      e();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\scheduler\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */