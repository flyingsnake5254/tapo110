package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public final class BackgroundDetector
  implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
{
  private static final BackgroundDetector zzat = new BackgroundDetector();
  private final AtomicBoolean zzau = new AtomicBoolean();
  private final AtomicBoolean zzav = new AtomicBoolean();
  @GuardedBy("sInstance")
  private final ArrayList<BackgroundStateChangeListener> zzaw = new ArrayList();
  @GuardedBy("sInstance")
  private boolean zzax = false;
  
  @KeepForSdk
  public static BackgroundDetector getInstance()
  {
    return zzat;
  }
  
  @KeepForSdk
  public static void initialize(Application paramApplication)
  {
    synchronized (zzat)
    {
      if (!???.zzax)
      {
        paramApplication.registerActivityLifecycleCallbacks(???);
        paramApplication.registerComponentCallbacks(???);
        ???.zzax = true;
      }
      return;
    }
  }
  
  private final void onBackgroundStateChanged(boolean paramBoolean)
  {
    synchronized (zzat)
    {
      ArrayList localArrayList = this.zzaw;
      int i = localArrayList.size();
      int j = 0;
      while (j < i)
      {
        Object localObject2 = localArrayList.get(j);
        j++;
        ((BackgroundStateChangeListener)localObject2).onBackgroundStateChanged(paramBoolean);
      }
      return;
    }
  }
  
  @KeepForSdk
  public final void addListener(BackgroundStateChangeListener paramBackgroundStateChangeListener)
  {
    synchronized (zzat)
    {
      this.zzaw.add(paramBackgroundStateChangeListener);
      return;
    }
  }
  
  @KeepForSdk
  public final boolean isInBackground()
  {
    return this.zzau.get();
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = this.zzau.compareAndSet(true, false);
    this.zzav.set(true);
    if (bool) {
      onBackgroundStateChanged(false);
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    boolean bool = this.zzau.compareAndSet(true, false);
    this.zzav.set(true);
    if (bool) {
      onBackgroundStateChanged(false);
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt)
  {
    if ((paramInt == 20) && (this.zzau.compareAndSet(false, true)))
    {
      this.zzav.set(true);
      onBackgroundStateChanged(true);
    }
  }
  
  @TargetApi(16)
  @KeepForSdk
  public final boolean readCurrentStateIfPossible(boolean paramBoolean)
  {
    if (!this.zzav.get()) {
      if (PlatformVersion.isAtLeastJellyBean())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
        if ((!this.zzav.getAndSet(true)) && (localRunningAppProcessInfo.importance > 100)) {
          this.zzau.set(true);
        }
      }
      else
      {
        return paramBoolean;
      }
    }
    return isInBackground();
  }
  
  @KeepForSdk
  public static abstract interface BackgroundStateChangeListener
  {
    @KeepForSdk
    public abstract void onBackgroundStateChanged(boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\BackgroundDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */