package com.tplink.iot.core;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.NotificationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.firebase.TapoFirebaseMessagingService;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCProtocolRepository;
import io.reactivex.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class p
  implements Application.ActivityLifecycleCallbacks
{
  private static final String c = p.class.getSimpleName();
  private static final c d = new a();
  private static List<Activity> f = Collections.synchronizedList(new LinkedList());
  private WeakReference<Activity> p0;
  private long p1 = -1L;
  private long p2 = -1L;
  private List<c> q = new ArrayList();
  private int x = 0;
  private int y = 0;
  private boolean z = false;
  
  private void a()
  {
    TapoFirebaseMessagingService.d();
    Object localObject = AppContext.c;
    if (localObject == null) {
      return;
    }
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)((Application)localObject).getSystemService("notification");
      if (localNotificationManager != null)
      {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23)
        {
          localObject = localNotificationManager.getActiveNotifications();
          if ((localObject != null) && (((i >= 29) && (localObject.length >= 25)) || (localObject.length >= 50)))
          {
            b.d.w.c.a.e("notification", "up to limit number, do clear all");
            localNotificationManager.cancelAll();
          }
        }
      }
    }
    catch (Exception localException)
    {
      b.d.w.c.a.e("notification", "checkNotificationsOutOfLimit--error");
    }
  }
  
  public static void b(Class<?> paramClass)
  {
    Object localObject = f;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = f.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Activity localActivity = (Activity)((Iterator)localObject).next();
        if (localActivity.getClass().equals(paramClass))
        {
          ((Iterator)localObject).remove();
          localActivity.finish();
        }
      }
    }
  }
  
  public static Activity c()
  {
    if (d.a().p0 != null) {
      return (Activity)d.a().p0.get();
    }
    return null;
  }
  
  public static boolean d()
  {
    return d.a().z;
  }
  
  private void e()
  {
    b.d.w.c.a.e(c, "App goto background!");
    this.z = false;
    long l = System.currentTimeMillis();
    this.p2 = l;
    com.tplink.iot.Utils.x0.b.b(l, this.p1);
    Iterator localIterator = this.q.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc != null) {
        localc.a();
      }
    }
  }
  
  private void f()
  {
    b.d.w.c.a.n(c, "App goto foreground!");
    this.p1 = System.currentTimeMillis();
    Iterator localIterator = this.q.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc != null) {
        localc.c();
      }
    }
    this.z = true;
    a();
  }
  
  private void g(Activity paramActivity)
  {
    List localList = f;
    if (localList != null) {
      localList.remove(paramActivity);
    }
  }
  
  private void h(Activity paramActivity)
  {
    List localList = f;
    if (localList != null) {
      localList.add(paramActivity);
    }
  }
  
  public static void i()
  {
    j(d);
  }
  
  public static void j(c paramc)
  {
    if ((paramc != null) && (!d.a().q.contains(paramc)))
    {
      d.a().q.add(paramc);
      if ((paramc instanceof b)) {
        ((b)paramc).b();
      }
    }
  }
  
  public static void k(Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(d.a());
  }
  
  public static void l()
  {
    m(d);
  }
  
  public static void m(c paramc)
  {
    if (paramc != null)
    {
      d.a().q.remove(paramc);
      if ((paramc instanceof b)) {
        ((b)paramc).e();
      }
    }
  }
  
  public static void n(Application paramApplication)
  {
    paramApplication.unregisterActivityLifecycleCallbacks(d.a());
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramActivity instanceof BaseActivity))
    {
      Iterator localIterator = this.q.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if ((localc instanceof b)) {
          ((b)localc).d((BaseActivity)paramActivity, paramBundle);
        }
      }
    }
    FragmentStateReceiver.i(paramActivity);
    h(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if ((paramActivity instanceof BaseActivity))
    {
      Iterator localIterator = this.q.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if ((localc instanceof b)) {
          ((b)localc).f((BaseActivity)paramActivity);
        }
      }
    }
    FragmentStateReceiver.m(paramActivity);
    g(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    this.p0 = new WeakReference(paramActivity);
    if (this.x <= 0) {
      f();
    }
    int i = this.y;
    if (i < 0) {
      this.y = (i + 1);
    } else {
      this.x += 1;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (paramActivity.isChangingConfigurations())
    {
      this.y -= 1;
    }
    else
    {
      int i = this.x - 1;
      this.x = i;
      if (i <= 0) {
        e();
      }
    }
  }
  
  static final class a
    implements p.c
  {
    public void a() {}
    
    public void c()
    {
      ((TCProtocolRepository)b.d.b.f.b.a(b.d.s.a.a.f(), TCProtocolRepository.class)).e().L0(io.reactivex.l0.a.c()).F0();
    }
  }
  
  public static abstract interface b
    extends p.c
  {
    public abstract void b();
    
    public abstract void d(BaseActivity paramBaseActivity, Bundle paramBundle);
    
    public abstract void e();
    
    public abstract void f(BaseActivity paramBaseActivity);
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void c();
  }
  
  private static class d
  {
    private static final p a = new p(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\core\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */