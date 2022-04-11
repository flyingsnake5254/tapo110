package com.google.firebase.messaging;

import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zzi;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class FcmExecutors
{
  private static Executor newCachedSingleThreadExecutor(String paramString)
  {
    return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("Firebase-Messaging-Trigger-Topics-Io"));
  }
  
  static ScheduledExecutorService newInitExecutor()
  {
    return new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Init"));
  }
  
  static ExecutorService newIntentHandleExecutor()
  {
    zzi.zza();
    Object localObject = new NamedThreadFactory("Firebase-Messaging-Intent-Handle");
    localObject = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), (ThreadFactory)localObject);
    ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    return Executors.unconfigurableExecutorService((ExecutorService)localObject);
  }
  
  static ExecutorService newNetworkIOExecutor()
  {
    return Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Network-Io"));
  }
  
  static ExecutorService newTaskExecutor()
  {
    return Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Task"));
  }
  
  static ScheduledExecutorService newTopicsSyncExecutor()
  {
    return new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io"));
  }
  
  static Executor newTopicsSyncTriggerExecutor()
  {
    return newCachedSingleThreadExecutor("Firebase-Messaging-Trigger-Topics-Io");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\FcmExecutors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */