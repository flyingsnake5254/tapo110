package com.tplink.iot.view.ipcamera.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class AutoRefreshTimer
  implements LifecycleObserver
{
  private Timer c;
  private b d;
  private a f;
  private final long q;
  private final long x;
  
  public AutoRefreshTimer(long paramLong1, long paramLong2, a parama)
  {
    this.q = paramLong1;
    this.x = paramLong2;
    this.f = parama;
  }
  
  public void a(LifecycleOwner paramLifecycleOwner)
  {
    paramLifecycleOwner.getLifecycle().addObserver(this);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void cancel()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      ((TimerTask)localObject).cancel();
      this.d = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.c = null;
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void schedule()
  {
    cancel();
    this.c = new Timer();
    b localb = new b(this.f);
    this.d = localb;
    this.c.schedule(localb, this.q, this.x);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void teardown()
  {
    this.f = null;
    cancel();
  }
  
  public static abstract interface a
  {
    public abstract void h();
  }
  
  private static class b
    extends TimerTask
  {
    @NonNull
    private final WeakReference<AutoRefreshTimer.a> c;
    
    b(@NonNull AutoRefreshTimer.a parama)
    {
      this.c = new WeakReference(parama);
    }
    
    public void run()
    {
      AutoRefreshTimer.a locala = (AutoRefreshTimer.a)this.c.get();
      if (locala != null) {
        locala.h();
      } else {
        cancel();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\base\AutoRefreshTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */