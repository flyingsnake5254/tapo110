package com.tplink.iot.view.ipcamera.onboardingv2;

import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RxAutoRefreshTimer
  implements LifecycleObserver
{
  private b c;
  private List<b> d = new ArrayList();
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void cancel()
  {
    b localb = this.c;
    if (localb != null)
    {
      localb.dispose();
      this.c = null;
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void schedule()
  {
    this.c = new b();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (b)localIterator.next();
      localObject = q.a0(b.a((b)localObject), b.b((b)localObject), TimeUnit.MILLISECONDS).G0(new y1((b)localObject));
      this.c.b((c)localObject);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void tearDown()
  {
    cancel();
    List localList = this.d;
    if (localList != null)
    {
      localList.clear();
      this.d = null;
    }
    this.c = null;
  }
  
  public static abstract interface a
  {
    public abstract void h();
  }
  
  public class b
  {
    private long a;
    private long b;
    private RxAutoRefreshTimer.a c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\RxAutoRefreshTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */