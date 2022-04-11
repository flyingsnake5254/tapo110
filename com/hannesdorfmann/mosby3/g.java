package com.hannesdorfmann.mosby3;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.hannesdorfmann.mosby3.k.a;
import com.hannesdorfmann.mosby3.k.b;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public final class g
{
  public static boolean a = false;
  private static final Map<Activity, String> b = new ArrayMap();
  private static final Map<String, c> c = new ArrayMap();
  static final Application.ActivityLifecycleCallbacks d = new a();
  
  @NonNull
  public static Activity c(@NonNull Context paramContext)
  {
    Objects.requireNonNull(paramContext, "context == null");
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    while ((localContext instanceof ContextWrapper))
    {
      if ((localContext instanceof Activity)) {
        return (Activity)localContext;
      }
      localContext = ((ContextWrapper)localContext).getBaseContext();
    }
    throw new IllegalStateException("Could not find the surrounding Activity");
  }
  
  @MainThread
  @Nullable
  static c d(@NonNull Activity paramActivity)
  {
    Objects.requireNonNull(paramActivity, "Activity is null");
    paramActivity = (String)b.get(paramActivity);
    if (paramActivity == null) {
      return null;
    }
    return (c)c.get(paramActivity);
  }
  
  @MainThread
  @NonNull
  static c e(@NonNull Activity paramActivity)
  {
    Objects.requireNonNull(paramActivity, "Activity is null");
    Map localMap = b;
    Object localObject1 = (String)localMap.get(paramActivity);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = UUID.randomUUID().toString();
      localMap.put(paramActivity, localObject1);
      localObject2 = localObject1;
      if (localMap.size() == 1)
      {
        paramActivity.getApplication().registerActivityLifecycleCallbacks(d);
        localObject2 = localObject1;
        if (a)
        {
          Log.d("PresenterManager", "Registering ActivityLifecycleCallbacks");
          localObject2 = localObject1;
        }
      }
    }
    localMap = c;
    localObject1 = (c)localMap.get(localObject2);
    paramActivity = (Activity)localObject1;
    if (localObject1 == null)
    {
      paramActivity = new c();
      localMap.put(localObject2, paramActivity);
    }
    return paramActivity;
  }
  
  @Nullable
  public static <P> P f(@NonNull Activity paramActivity, @NonNull String paramString)
  {
    Objects.requireNonNull(paramActivity, "Activity is null");
    Objects.requireNonNull(paramString, "View id is null");
    paramActivity = d(paramActivity);
    if (paramActivity == null) {
      paramActivity = null;
    } else {
      paramActivity = paramActivity.b(paramString);
    }
    return paramActivity;
  }
  
  public static void g(@NonNull Activity paramActivity, @NonNull String paramString, @NonNull a<? extends b> parama)
  {
    Objects.requireNonNull(paramActivity, "Activity is null");
    e(paramActivity).c(paramString, parama);
  }
  
  public static void h(@NonNull Activity paramActivity, @NonNull String paramString)
  {
    Objects.requireNonNull(paramActivity, "Activity is null");
    paramActivity = d(paramActivity);
    if (paramActivity != null) {
      paramActivity.d(paramString);
    }
  }
  
  static final class a
    implements Application.ActivityLifecycleCallbacks
  {
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("com.hannesdorfmann.mosby3.MosbyPresenterManagerActivityId");
        if (paramBundle != null) {
          g.a().put(paramActivity, paramBundle);
        }
      }
    }
    
    public void onActivityDestroyed(Activity paramActivity)
    {
      if (!paramActivity.isChangingConfigurations())
      {
        String str = (String)g.a().get(paramActivity);
        if (str != null)
        {
          c localc = (c)g.b().get(str);
          if (localc != null)
          {
            localc.a();
            g.b().remove(str);
          }
          if (g.b().isEmpty())
          {
            paramActivity.getApplication().unregisterActivityLifecycleCallbacks(g.d);
            if (g.a) {
              Log.d("PresenterManager", "Unregistering ActivityLifecycleCallbacks");
            }
          }
        }
      }
      g.a().remove(paramActivity);
    }
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
    {
      paramActivity = (String)g.a().get(paramActivity);
      if (paramActivity != null) {
        paramBundle.putString("com.hannesdorfmann.mosby3.MosbyPresenterManagerActivityId", paramActivity);
      }
    }
    
    public void onActivityStarted(Activity paramActivity) {}
    
    public void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */