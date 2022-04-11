package com.google.firebase.analytics;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zza
  extends ThreadPoolExecutor
{
  zza(FirebaseAnalytics paramFirebaseAnalytics, int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue)
  {
    super(0, 1, 30L, paramTimeUnit, paramBlockingQueue);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\analytics\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */