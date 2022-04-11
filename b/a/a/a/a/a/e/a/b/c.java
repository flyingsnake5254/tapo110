package b.a.a.a.a.a.e.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.util.Log;
import io.reactivex.e0.d;
import io.reactivex.g;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.w;
import io.reactivex.w.c;

public class c
  implements b.a.a.a.a.a.e.a.a
{
  private io.reactivex.e0.c c(final io.reactivex.g0.a parama)
  {
    return d.c(new b(parama));
  }
  
  public q<b.a.a.a.a.a.a> a(final Context paramContext)
  {
    final IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    return q.m(new a(paramContext, localIntentFilter)).n(b.a.a.a.a.a.a.c());
  }
  
  public void d(String paramString, Exception paramException)
  {
    Log.e("ReactiveNetwork", paramString, paramException);
  }
  
  protected void e(Context paramContext, BroadcastReceiver paramBroadcastReceiver)
  {
    try
    {
      paramContext.unregisterReceiver(paramBroadcastReceiver);
    }
    catch (Exception paramContext)
    {
      d("receiver was already unregistered", paramContext);
    }
  }
  
  class a
    implements s<b.a.a.a.a.a.a>
  {
    a(Context paramContext, IntentFilter paramIntentFilter) {}
    
    public void subscribe(final r<b.a.a.a.a.a.a> paramr)
      throws Exception
    {
      final a locala = new a(paramr);
      paramContext.registerReceiver(locala, localIntentFilter);
      paramr.a(c.b(c.this, new b(locala)));
    }
    
    class a
      extends BroadcastReceiver
    {
      a(r paramr) {}
      
      public void onReceive(Context paramContext, Intent paramIntent)
      {
        paramr.onNext(b.a.a.a.a.a.a.d(paramContext));
      }
    }
    
    class b
      implements io.reactivex.g0.a
    {
      b(BroadcastReceiver paramBroadcastReceiver) {}
      
      public void run()
      {
        c.a locala = c.a.this;
        locala.c.e(locala.a, locala);
      }
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b(io.reactivex.g0.a parama) {}
    
    public void run()
      throws Exception
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        parama.run();
      }
      else
      {
        final w.c localc = io.reactivex.d0.b.a.a().b();
        localc.b(new a(localc));
      }
    }
    
    class a
      implements Runnable
    {
      a(w.c paramc) {}
      
      public void run()
      {
        try
        {
          c.b.this.a.run();
        }
        catch (Exception localException)
        {
          c.this.d("Could not unregister receiver in UI Thread", localException);
        }
        localc.dispose();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\a\a\a\a\a\e\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */