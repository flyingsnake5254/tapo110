package com.google.firebase.messaging;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class FcmLifecycleCallbacks
  implements Application.ActivityLifecycleCallbacks
{
  private final Set<Intent> seenIntents = Collections.newSetFromMap(new WeakHashMap());
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    paramActivity = paramActivity.getIntent();
    if ((paramActivity != null) && (this.seenIntents.add(paramActivity)))
    {
      paramActivity = paramActivity.getExtras();
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getBundle("gcm.n.analytics_data");
        if (MessagingAnalytics.shouldUploadScionMetrics(paramActivity)) {
          MessagingAnalytics.logNotificationOpen(paramActivity);
        }
      }
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity.isFinishing()) {
      this.seenIntents.remove(paramActivity.getIntent());
    }
  }
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\FcmLifecycleCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */