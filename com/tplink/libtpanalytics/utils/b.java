package com.tplink.libtpanalytics.utils;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.util.Stack;

public class b
{
  private static b a;
  private b b;
  private c c;
  private Stack<Activity> d = new Stack();
  private Application.ActivityLifecycleCallbacks e = new a();
  
  public static b f()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          b localb = new com/tplink/libtpanalytics/utils/b;
          localb.<init>();
          a = localb;
        }
      }
      finally {}
    }
    return a;
  }
  
  public void d()
  {
    this.b = null;
    this.c = null;
  }
  
  public void e(b paramb, c paramc)
  {
    this.b = paramb;
    this.c = paramc;
  }
  
  public String g()
  {
    if (this.d.size() != 0) {
      return ((Activity)this.d.peek()).getClass().getSimpleName();
    }
    return "";
  }
  
  public void h(Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(this.e);
  }
  
  class a
    implements Application.ActivityLifecycleCallbacks
  {
    private int c = 0;
    
    a() {}
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      FragmentStateMonitor.h().m(paramActivity);
      b.a(b.this).push(paramActivity);
      if (b.a(b.this).size() > 1) {
        paramActivity = ((Activity)b.a(b.this).get(b.a(b.this).size() - 2)).getClass().getSimpleName();
      } else {
        paramActivity = "";
      }
      if (b.b(b.this) != null) {
        b.b(b.this).a(paramActivity);
      }
    }
    
    public void onActivityDestroyed(Activity paramActivity)
    {
      FragmentStateMonitor.h().o(paramActivity);
      if (b.a(b.this).indexOf(paramActivity) == b.a(b.this).size() - 1)
      {
        String str = ((Activity)b.a(b.this).peek()).getClass().getSimpleName();
        b.a(b.this).remove(paramActivity);
        if (b.b(b.this) != null) {
          b.b(b.this).a(str);
        }
      }
      else
      {
        b.a(b.this).remove(paramActivity);
      }
    }
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity)
    {
      int i = this.c + 1;
      this.c = i;
      if ((i == 1) && (b.c(b.this) != null)) {
        b.c(b.this).a();
      }
    }
    
    public void onActivityStopped(Activity paramActivity)
    {
      int i = this.c - 1;
      this.c = i;
      if ((i == 0) && (b.c(b.this) != null)) {
        b.c(b.this).b();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */