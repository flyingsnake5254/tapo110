package b.d.n.j;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Stack;

public class a
{
  private static a a;
  private Stack<Activity> b = new Stack();
  private Application.ActivityLifecycleCallbacks c = new a();
  
  public static a b()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          a locala = new b/d/n/j/a;
          locala.<init>();
          a = locala;
        }
      }
      finally {}
    }
    return a;
  }
  
  public WeakReference<Activity> c()
  {
    if (this.b.size() != 0) {
      return new WeakReference((Activity)this.b.peek());
    }
    return new WeakReference(null);
  }
  
  public void d(Application paramApplication)
  {
    if (paramApplication != null) {
      paramApplication.registerActivityLifecycleCallbacks(this.c);
    }
  }
  
  class a
    implements Application.ActivityLifecycleCallbacks
  {
    a() {}
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      a.a(a.this).push(paramActivity);
    }
    
    public void onActivityDestroyed(Activity paramActivity)
    {
      a.a(a.this).remove(paramActivity);
    }
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity) {}
    
    public void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */