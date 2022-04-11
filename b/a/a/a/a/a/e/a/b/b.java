package b.a.a.a.a.a.e.a.b;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest.Builder;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.NonNull;
import io.reactivex.BackpressureStrategy;
import io.reactivex.h;
import io.reactivex.m0.d;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.v;

@TargetApi(23)
public class b
  implements b.a.a.a.a.a.e.a.a
{
  private ConnectivityManager.NetworkCallback a;
  private final g<b.a.a.a.a.a.a> b = d.n1().l1();
  private final BroadcastReceiver c = b();
  
  public q<b.a.a.a.a.a.a> a(final Context paramContext)
  {
    final ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    this.a = c(paramContext);
    g(paramContext);
    localConnectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).addCapability(13).build(), this.a);
    return this.b.Y0(BackpressureStrategy.LATEST).i(new a(localConnectivityManager, paramContext)).F(b.a.a.a.a.a.a.d(paramContext)).g().K();
  }
  
  @NonNull
  protected BroadcastReceiver b()
  {
    return new b();
  }
  
  protected ConnectivityManager.NetworkCallback c(final Context paramContext)
  {
    return new c(paramContext);
  }
  
  protected boolean d(Context paramContext)
  {
    String str = paramContext.getPackageName();
    paramContext = (PowerManager)paramContext.getSystemService("power");
    boolean bool = paramContext.isIgnoringBatteryOptimizations(str);
    if ((paramContext.isDeviceIdleMode()) && (!bool)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void e(String paramString, Exception paramException)
  {
    Log.e("ReactiveNetwork", paramString, paramException);
  }
  
  protected void f(b.a.a.a.a.a.a parama)
  {
    this.b.onNext(parama);
  }
  
  protected void g(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED");
    paramContext.registerReceiver(this.c, localIntentFilter);
  }
  
  protected void h(ConnectivityManager paramConnectivityManager)
  {
    try
    {
      paramConnectivityManager.unregisterNetworkCallback(this.a);
    }
    catch (Exception paramConnectivityManager)
    {
      e("could not unregister network callback", paramConnectivityManager);
    }
  }
  
  protected void i(Context paramContext)
  {
    try
    {
      paramContext.unregisterReceiver(this.c);
    }
    catch (Exception paramContext)
    {
      e("could not unregister receiver", paramContext);
    }
  }
  
  class a
    implements io.reactivex.g0.a
  {
    a(ConnectivityManager paramConnectivityManager, Context paramContext) {}
    
    public void run()
    {
      b.this.h(localConnectivityManager);
      b.this.i(paramContext);
    }
  }
  
  class b
    extends BroadcastReceiver
  {
    b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (b.this.d(paramContext)) {
        b.this.f(b.a.a.a.a.a.a.c());
      } else {
        b.this.f(b.a.a.a.a.a.a.d(paramContext));
      }
    }
  }
  
  class c
    extends ConnectivityManager.NetworkCallback
  {
    c(Context paramContext) {}
    
    public void onAvailable(Network paramNetwork)
    {
      b.this.f(b.a.a.a.a.a.a.d(paramContext));
    }
    
    public void onLost(Network paramNetwork)
    {
      b.this.f(b.a.a.a.a.a.a.d(paramContext));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\a\a\a\a\a\e\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */