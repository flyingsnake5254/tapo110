package com.google.firebase.installations.remote;

import androidx.annotation.GuardedBy;
import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

class RequestLimiter
{
  private static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24L);
  private static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30L);
  @GuardedBy("this")
  private int attemptCount;
  @GuardedBy("this")
  private long nextRequestTime;
  private final Utils utils;
  
  RequestLimiter()
  {
    this.utils = Utils.getInstance();
  }
  
  RequestLimiter(Utils paramUtils)
  {
    this.utils = paramUtils;
  }
  
  private long getBackoffDuration(int paramInt)
  {
    try
    {
      if (!isRetryableError(paramInt))
      {
        l = MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
        return l;
      }
      double d = Math.min(Math.pow(2.0D, this.attemptCount) + this.utils.getRandomDelayForSyncPrevention(), MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS);
      long l = d;
      return l;
    }
    finally {}
  }
  
  private static boolean isRetryableError(int paramInt)
  {
    boolean bool;
    if ((paramInt != 429) && ((paramInt < 500) || (paramInt >= 600))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isSuccessfulOrRequiresNewFidCreation(int paramInt)
  {
    boolean bool;
    if (((paramInt < 200) || (paramInt >= 300)) && (paramInt != 401) && (paramInt != 404)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void resetBackoffStrategy()
  {
    try
    {
      this.attemptCount = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isRequestAllowed()
  {
    try
    {
      if (this.attemptCount != 0)
      {
        long l1 = this.utils.currentTimeInMillis();
        long l2 = this.nextRequestTime;
        if (l1 <= l2)
        {
          bool = false;
          break label40;
        }
      }
      boolean bool = true;
      label40:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setNextRequestTime(int paramInt)
  {
    try
    {
      if (isSuccessfulOrRequiresNewFidCreation(paramInt))
      {
        resetBackoffStrategy();
        return;
      }
      this.attemptCount += 1;
      long l = getBackoffDuration(paramInt);
      this.nextRequestTime = (this.utils.currentTimeInMillis() + l);
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\remote\RequestLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */