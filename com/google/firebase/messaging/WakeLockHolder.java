package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

final class WakeLockHolder
{
  private static final long WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(1L);
  private static final Object syncObject = new Object();
  @GuardedBy("WakeLockHolder.syncObject")
  private static WakeLock wakeLock;
  
  @GuardedBy("WakeLockHolder.syncObject")
  private static void checkAndInitWakeLock(Context paramContext)
  {
    if (wakeLock == null)
    {
      paramContext = new WakeLock(paramContext, 1, "wake:com.google.firebase.iid.WakeLockHolder");
      wakeLock = paramContext;
      paramContext.setReferenceCounted(true);
    }
  }
  
  static void completeWakefulIntent(@NonNull Intent paramIntent)
  {
    synchronized (syncObject)
    {
      if ((wakeLock != null) && (isWakefulIntent(paramIntent)))
      {
        setAsWakefulIntent(paramIntent, false);
        wakeLock.release();
      }
      return;
    }
  }
  
  @VisibleForTesting
  static boolean isWakefulIntent(@NonNull Intent paramIntent)
  {
    return paramIntent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
  }
  
  private static void setAsWakefulIntent(@NonNull Intent paramIntent, boolean paramBoolean)
  {
    paramIntent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", paramBoolean);
  }
  
  static ComponentName startWakefulService(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    synchronized (syncObject)
    {
      checkAndInitWakeLock(paramContext);
      boolean bool = isWakefulIntent(paramIntent);
      setAsWakefulIntent(paramIntent, true);
      paramContext = paramContext.startService(paramIntent);
      if (paramContext == null) {
        return null;
      }
      if (!bool) {
        wakeLock.acquire(WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
      }
      return paramContext;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\WakeLockHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */