package com.tplink.iot.devicecommon.feature;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.widget.businessview.ThingNextEventView;
import com.tplink.iot.widget.businessview.ThingNextEventView.d;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;

public final class NextEventFeature
  implements LifecycleObserver
{
  public static final a c = new a(null);
  private c d;
  private b f;
  private final LifecycleOwner q;
  private final ThingNextEventView x;
  
  private NextEventFeature(LifecycleOwner paramLifecycleOwner, ThingNextEventView paramThingNextEventView)
  {
    this.q = paramLifecycleOwner;
    this.x = paramThingNextEventView;
    paramLifecycleOwner.getLifecycle().addObserver(this);
  }
  
  private final void d(String paramString)
  {
    b.d.w.c.a.n("NextEventFeature", paramString);
  }
  
  private final void e()
  {
    d("nextEventEndTaskRefreshStrategy");
    q.e0(1L, 3L, 0L, 2L, TimeUnit.SECONDS, io.reactivex.l0.a.c()).E(new c(this)).F0();
  }
  
  private final void g()
  {
    h();
    this.d = q.e0(1L, 2L, 0L, 3L, TimeUnit.SECONDS, io.reactivex.l0.a.c()).G0(new f(this));
    d("startNextEventRefreshTimer");
  }
  
  private final void h()
  {
    d("stopNextEventRefreshTimer");
    c localc = this.d;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public final void f(b paramb)
  {
    j.e(paramb, "helper");
    this.f = paramb;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreate: ");
    Lifecycle localLifecycle = this.q.getLifecycle();
    j.d(localLifecycle, "owner.lifecycle");
    ((StringBuilder)localObject).append(localLifecycle.getCurrentState());
    d(((StringBuilder)localObject).toString());
    localObject = this.x;
    if (localObject != null) {
      ((ThingNextEventView)localObject).setOnNextEventCallback(new d(this));
    }
    localObject = this.f;
    if (localObject != null)
    {
      localObject = ((b)localObject).b();
      if (localObject != null) {
        ((LiveData)localObject).observe(this.q, new e(this));
      }
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy()
  {
    d("onDestroy");
    ThingNextEventView localThingNextEventView = this.x;
    if (localThingNextEventView != null) {
      localThingNextEventView.e();
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause()
  {
    d("onPause");
    h();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume()
  {
    d("onResume");
    g();
  }
  
  public static final class a
  {
    public final NextEventFeature a(LifecycleOwner paramLifecycleOwner, ThingNextEventView paramThingNextEventView)
    {
      j.e(paramLifecycleOwner, "owner");
      return new NextEventFeature(paramLifecycleOwner, paramThingNextEventView, null);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract LiveData<NextEvent> b();
    
    public abstract void c();
    
    public abstract String d();
  }
  
  static final class c<T>
    implements g<Long>
  {
    c(NextEventFeature paramNextEventFeature) {}
    
    public final void a(Long paramLong)
    {
      paramLong = NextEventFeature.a(this.c);
      if (paramLong != null) {
        paramLong.c();
      }
      paramLong = NextEventFeature.a(this.c);
      if (paramLong != null) {
        paramLong.a();
      }
    }
  }
  
  static final class d
    implements ThingNextEventView.d
  {
    d(NextEventFeature paramNextEventFeature) {}
    
    public final void a()
    {
      NextEventFeature.c(this.a);
    }
  }
  
  static final class e<T>
    implements Observer<NextEvent>
  {
    e(NextEventFeature paramNextEventFeature) {}
    
    public final void a(NextEvent paramNextEvent)
    {
      ThingNextEventView localThingNextEventView = NextEventFeature.b(this.a);
      if (localThingNextEventView != null)
      {
        Object localObject = NextEventFeature.a(this.a);
        if (localObject != null) {
          localObject = ((NextEventFeature.b)localObject).d();
        } else {
          localObject = null;
        }
        localThingNextEventView.r(paramNextEvent, (String)localObject);
      }
    }
  }
  
  static final class f<T>
    implements g<Long>
  {
    f(NextEventFeature paramNextEventFeature) {}
    
    public final void a(Long paramLong)
    {
      paramLong = NextEventFeature.a(this.c);
      if (paramLong != null) {
        paramLong.c();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\feature\NextEventFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */