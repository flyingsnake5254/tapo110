package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ExecutorUtils
{
  private static final long DEFAULT_TERMINATION_TIMEOUT = 2L;
  
  private static void addDelayedShutdownHook(String paramString, ExecutorService paramExecutorService)
  {
    addDelayedShutdownHook(paramString, paramExecutorService, 2L, TimeUnit.SECONDS);
  }
  
  private static void addDelayedShutdownHook(String paramString, final ExecutorService paramExecutorService, final long paramLong, TimeUnit paramTimeUnit)
  {
    Runtime localRuntime = Runtime.getRuntime();
    paramTimeUnit = new BackgroundPriorityRunnable()
    {
      public void onRun()
      {
        try
        {
          Logger localLogger = Logger.getLogger();
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("Executing shutdown hook for ");
          localStringBuilder.append(ExecutorUtils.this);
          localLogger.d(localStringBuilder.toString());
          paramExecutorService.shutdown();
          if (!paramExecutorService.awaitTermination(paramLong, this.val$timeUnit))
          {
            localLogger = Logger.getLogger();
            localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            localStringBuilder.append(ExecutorUtils.this);
            localStringBuilder.append(" did not shut down in the allocated time. Requesting immediate shutdown.");
            localLogger.d(localStringBuilder.toString());
            paramExecutorService.shutdownNow();
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          Logger.getLogger().d(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[] { ExecutorUtils.this }));
          paramExecutorService.shutdownNow();
        }
      }
    };
    paramExecutorService = new StringBuilder();
    paramExecutorService.append("Crashlytics Shutdown Hook for ");
    paramExecutorService.append(paramString);
    localRuntime.addShutdownHook(new Thread(paramTimeUnit, paramExecutorService.toString()));
  }
  
  public static ExecutorService buildSingleThreadExecutorService(String paramString)
  {
    ExecutorService localExecutorService = newSingleThreadExecutor(getNamedThreadFactory(paramString), new ThreadPoolExecutor.DiscardPolicy());
    addDelayedShutdownHook(paramString, localExecutorService);
    return localExecutorService;
  }
  
  public static ScheduledExecutorService buildSingleThreadScheduledExecutorService(String paramString)
  {
    ScheduledExecutorService localScheduledExecutorService = Executors.newSingleThreadScheduledExecutor(getNamedThreadFactory(paramString));
    addDelayedShutdownHook(paramString, localScheduledExecutorService);
    return localScheduledExecutorService;
  }
  
  public static ThreadFactory getNamedThreadFactory(String paramString)
  {
    new ThreadFactory()
    {
      public Thread newThread(final Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = Executors.defaultThreadFactory().newThread(new BackgroundPriorityRunnable()
        {
          public void onRun()
          {
            paramAnonymousRunnable.run();
          }
        });
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ExecutorUtils.this);
        localStringBuilder.append(this.val$count.getAndIncrement());
        paramAnonymousRunnable.setName(localStringBuilder.toString());
        return paramAnonymousRunnable;
      }
    };
  }
  
  private static ExecutorService newSingleThreadExecutor(ThreadFactory paramThreadFactory, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    return Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), paramThreadFactory, paramRejectedExecutionHandler));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\ExecutorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */