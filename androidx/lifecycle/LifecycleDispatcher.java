package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.atomic.AtomicBoolean;

class LifecycleDispatcher
{
  private static AtomicBoolean sInitialized = new AtomicBoolean(false);
  
  static void init(Context paramContext)
  {
    if (sInitialized.getAndSet(true)) {
      return;
    }
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
  }
  
  @VisibleForTesting
  static class DispatcherActivityCallback
    extends EmptyActivityLifecycleCallbacks
  {
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      ReportFragment.injectIfNeededIn(paramActivity);
    }
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\LifecycleDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */