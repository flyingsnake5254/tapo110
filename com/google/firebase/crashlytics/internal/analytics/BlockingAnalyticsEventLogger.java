package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BlockingAnalyticsEventLogger
  implements AnalyticsEventReceiver, AnalyticsEventLogger
{
  static final String APP_EXCEPTION_EVENT_NAME = "_ae";
  private final CrashlyticsOriginAnalyticsEventLogger baseAnalyticsEventLogger;
  private boolean callbackReceived = false;
  private CountDownLatch eventLatch;
  private final Object latchLock = new Object();
  private final TimeUnit timeUnit;
  private final int timeout;
  
  public BlockingAnalyticsEventLogger(@NonNull CrashlyticsOriginAnalyticsEventLogger paramCrashlyticsOriginAnalyticsEventLogger, int paramInt, TimeUnit paramTimeUnit)
  {
    this.baseAnalyticsEventLogger = paramCrashlyticsOriginAnalyticsEventLogger;
    this.timeout = paramInt;
    this.timeUnit = paramTimeUnit;
  }
  
  boolean isCallbackReceived()
  {
    return this.callbackReceived;
  }
  
  public void logEvent(@NonNull String paramString, @Nullable Bundle paramBundle)
  {
    synchronized (this.latchLock)
    {
      Object localObject2 = Logger.getLogger();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Logging event ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" to Firebase Analytics with params ");
      localStringBuilder.append(paramBundle);
      ((Logger)localObject2).v(localStringBuilder.toString());
      localObject2 = new java/util/concurrent/CountDownLatch;
      ((CountDownLatch)localObject2).<init>(1);
      this.eventLatch = ((CountDownLatch)localObject2);
      this.callbackReceived = false;
      this.baseAnalyticsEventLogger.logEvent(paramString, paramBundle);
      Logger.getLogger().v("Awaiting app exception callback from Analytics...");
      try
      {
        if (this.eventLatch.await(this.timeout, this.timeUnit))
        {
          this.callbackReceived = true;
          Logger.getLogger().v("App exception callback received from Analytics listener.");
        }
        else
        {
          Logger.getLogger().w("Timeout exceeded while awaiting app exception callback from Analytics listener.");
        }
      }
      catch (InterruptedException paramString)
      {
        Logger.getLogger().e("Interrupted while awaiting app exception callback from Analytics listener.");
      }
      this.eventLatch = null;
      return;
    }
  }
  
  public void onEvent(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    paramBundle = this.eventLatch;
    if (paramBundle == null) {
      return;
    }
    if ("_ae".equals(paramString)) {
      paramBundle.countDown();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\analytics\BlockingAnalyticsEventLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */