package b.a.a.a.a.a.e.a.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest.Builder;
import android.util.Log;
import io.reactivex.g;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;

@TargetApi(21)
public class a
  implements b.a.a.a.a.a.e.a.a
{
  private ConnectivityManager.NetworkCallback a;
  
  private ConnectivityManager.NetworkCallback f(final r<b.a.a.a.a.a.a> paramr, final Context paramContext)
  {
    return new c(paramr, paramContext);
  }
  
  private void h(ConnectivityManager paramConnectivityManager)
  {
    try
    {
      paramConnectivityManager.unregisterNetworkCallback(this.a);
    }
    catch (Exception paramConnectivityManager)
    {
      g("could not unregister network callback", paramConnectivityManager);
    }
  }
  
  public q<b.a.a.a.a.a.a> a(final Context paramContext)
  {
    final ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    return q.m(new b(paramContext, localConnectivityManager)).A(new a(localConnectivityManager)).E0(b.a.a.a.a.a.a.d(paramContext)).w();
  }
  
  public void g(String paramString, Exception paramException)
  {
    Log.e("ReactiveNetwork", paramString, paramException);
  }
  
  class a
    implements io.reactivex.g0.a
  {
    a(ConnectivityManager paramConnectivityManager) {}
    
    public void run()
    {
      a.b(a.this, localConnectivityManager);
    }
  }
  
  class b
    implements s<b.a.a.a.a.a.a>
  {
    b(Context paramContext, ConnectivityManager paramConnectivityManager) {}
    
    public void subscribe(r<b.a.a.a.a.a.a> paramr)
      throws Exception
    {
      a locala = a.this;
      a.d(locala, a.e(locala, paramr, paramContext));
      paramr = new NetworkRequest.Builder().build();
      localConnectivityManager.registerNetworkCallback(paramr, a.c(a.this));
    }
  }
  
  class c
    extends ConnectivityManager.NetworkCallback
  {
    c(r paramr, Context paramContext) {}
    
    public void onAvailable(Network paramNetwork)
    {
      paramr.onNext(b.a.a.a.a.a.a.d(paramContext));
    }
    
    public void onLost(Network paramNetwork)
    {
      paramr.onNext(b.a.a.a.a.a.a.d(paramContext));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\a\a\a\a\a\e\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */