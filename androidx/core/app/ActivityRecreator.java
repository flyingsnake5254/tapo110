package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
final class ActivityRecreator
{
  private static final String LOG_TAG = "ActivityRecreator";
  protected static final Class<?> activityThreadClass;
  private static final Handler mainHandler = new Handler(Looper.getMainLooper());
  protected static final Field mainThreadField;
  protected static final Method performStopActivity2ParamsMethod;
  protected static final Method performStopActivity3ParamsMethod;
  protected static final Method requestRelaunchActivityMethod;
  protected static final Field tokenField;
  
  static
  {
    Class localClass = getActivityThreadClass();
    activityThreadClass = localClass;
    mainThreadField = getMainThreadField();
    tokenField = getTokenField();
    performStopActivity3ParamsMethod = getPerformStopActivity3Params(localClass);
    performStopActivity2ParamsMethod = getPerformStopActivity2Params(localClass);
    requestRelaunchActivityMethod = getRequestRelaunchActivityMethod(localClass);
  }
  
  private static Class<?> getActivityThreadClass()
  {
    try
    {
      Class localClass = Class.forName("android.app.ActivityThread");
      return localClass;
    }
    finally {}
    return null;
  }
  
  private static Field getMainThreadField()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mMainThread");
      localField.setAccessible(true);
      return localField;
    }
    finally {}
    return null;
  }
  
  private static Method getPerformStopActivity2Params(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod("performStopActivity", new Class[] { IBinder.class, Boolean.TYPE });
      paramClass.setAccessible(true);
      return paramClass;
    }
    finally {}
    return null;
  }
  
  private static Method getPerformStopActivity3Params(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod("performStopActivity", new Class[] { IBinder.class, Boolean.TYPE, String.class });
      paramClass.setAccessible(true);
      return paramClass;
    }
    finally {}
    return null;
  }
  
  private static Method getRequestRelaunchActivityMethod(Class<?> paramClass)
  {
    if ((needsRelaunchCall()) && (paramClass != null)) {}
    try
    {
      Class localClass1 = Integer.TYPE;
      Class localClass2 = Boolean.TYPE;
      paramClass = paramClass.getDeclaredMethod("requestRelaunchActivity", new Class[] { IBinder.class, List.class, List.class, localClass1, localClass2, Configuration.class, Configuration.class, localClass2, localClass2 });
      paramClass.setAccessible(true);
      return paramClass;
    }
    finally
    {
      for (;;) {}
    }
    return null;
  }
  
  private static Field getTokenField()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mToken");
      localField.setAccessible(true);
      return localField;
    }
    finally {}
    return null;
  }
  
  private static boolean needsRelaunchCall()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool;
    if ((i != 26) && (i != 27)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected static boolean queueOnStopIfNecessary(Object paramObject, int paramInt, Activity paramActivity)
  {
    try
    {
      Object localObject = tokenField.get(paramActivity);
      if ((localObject == paramObject) && (paramActivity.hashCode() == paramInt))
      {
        paramObject = mainThreadField.get(paramActivity);
        Handler localHandler = mainHandler;
        paramActivity = new androidx/core/app/ActivityRecreator$3;
        paramActivity.<init>(paramObject, localObject);
        return true;
      }
      return false;
    }
    finally
    {
      Log.e("ActivityRecreator", "Exception while fetching field values", (Throwable)paramObject);
    }
    return false;
  }
  
  static boolean recreate(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramActivity.recreate();
      return true;
    }
    if ((needsRelaunchCall()) && (requestRelaunchActivityMethod == null)) {
      return false;
    }
    if ((performStopActivity2ParamsMethod == null) && (performStopActivity3ParamsMethod == null)) {
      return false;
    }
    try
    {
      Object localObject1 = tokenField.get(paramActivity);
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = mainThreadField.get(paramActivity);
      if (localObject2 == null) {
        return false;
      }
      Application localApplication = paramActivity.getApplication();
      LifecycleCheckCallbacks localLifecycleCheckCallbacks = new androidx/core/app/ActivityRecreator$LifecycleCheckCallbacks;
      localLifecycleCheckCallbacks.<init>(paramActivity);
      localApplication.registerActivityLifecycleCallbacks(localLifecycleCheckCallbacks);
      Object localObject4 = mainHandler;
      Object localObject5 = new androidx/core/app/ActivityRecreator$1;
      ((1)localObject5).<init>(localLifecycleCheckCallbacks, localObject1);
      ((Handler)localObject4).post((Runnable)localObject5);
      try
      {
        if (needsRelaunchCall())
        {
          paramActivity = requestRelaunchActivityMethod;
          localObject5 = Boolean.FALSE;
          paramActivity.invoke(localObject2, new Object[] { localObject1, null, null, Integer.valueOf(0), localObject5, null, null, localObject5, localObject5 });
        }
        else
        {
          paramActivity.recreate();
        }
        paramActivity = new androidx/core/app/ActivityRecreator$2;
        paramActivity.<init>(localApplication, localLifecycleCheckCallbacks);
        ((Handler)localObject4).post(paramActivity);
        return true;
      }
      finally
      {
        paramActivity = mainHandler;
        localObject4 = new androidx/core/app/ActivityRecreator$2;
        ((2)localObject4).<init>(localApplication, localLifecycleCheckCallbacks);
        paramActivity.post((Runnable)localObject4);
      }
      return false;
    }
    finally {}
  }
  
  private static final class LifecycleCheckCallbacks
    implements Application.ActivityLifecycleCallbacks
  {
    Object currentlyRecreatingToken;
    private Activity mActivity;
    private boolean mDestroyed = false;
    private final int mRecreatingHashCode;
    private boolean mStarted = false;
    private boolean mStopQueued = false;
    
    LifecycleCheckCallbacks(@NonNull Activity paramActivity)
    {
      this.mActivity = paramActivity;
      this.mRecreatingHashCode = paramActivity.hashCode();
    }
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity)
    {
      if (this.mActivity == paramActivity)
      {
        this.mActivity = null;
        this.mDestroyed = true;
      }
    }
    
    public void onActivityPaused(Activity paramActivity)
    {
      if ((this.mDestroyed) && (!this.mStopQueued) && (!this.mStarted) && (ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, paramActivity)))
      {
        this.mStopQueued = true;
        this.currentlyRecreatingToken = null;
      }
    }
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity)
    {
      if (this.mActivity == paramActivity) {
        this.mStarted = true;
      }
    }
    
    public void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\app\ActivityRecreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */