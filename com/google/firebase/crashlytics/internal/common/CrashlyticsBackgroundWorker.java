package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

class CrashlyticsBackgroundWorker
{
  private final Executor executor;
  private final ThreadLocal<Boolean> isExecutorThread = new ThreadLocal();
  private Task<Void> tail = Tasks.forResult(null);
  private final Object tailLock = new Object();
  
  public CrashlyticsBackgroundWorker(Executor paramExecutor)
  {
    this.executor = paramExecutor;
    paramExecutor.execute(new Runnable()
    {
      public void run()
      {
        CrashlyticsBackgroundWorker.this.isExecutorThread.set(Boolean.TRUE);
      }
    });
  }
  
  private <T> Task<Void> ignoreResult(Task<T> paramTask)
  {
    paramTask.continueWith(this.executor, new Continuation()
    {
      public Void then(@NonNull Task<T> paramAnonymousTask)
        throws Exception
      {
        return null;
      }
    });
  }
  
  private boolean isRunningOnThread()
  {
    return Boolean.TRUE.equals(this.isExecutorThread.get());
  }
  
  private <T> Continuation<Void, T> newContinuation(final Callable<T> paramCallable)
  {
    new Continuation()
    {
      public T then(@NonNull Task<Void> paramAnonymousTask)
        throws Exception
      {
        return (T)paramCallable.call();
      }
    };
  }
  
  public void checkRunningOnThread()
  {
    if (isRunningOnThread()) {
      return;
    }
    throw new IllegalStateException("Not running on background worker thread as intended.");
  }
  
  public Executor getExecutor()
  {
    return this.executor;
  }
  
  Task<Void> submit(final Runnable paramRunnable)
  {
    submit(new Callable()
    {
      public Void call()
        throws Exception
      {
        paramRunnable.run();
        return null;
      }
    });
  }
  
  public <T> Task<T> submit(Callable<T> paramCallable)
  {
    synchronized (this.tailLock)
    {
      paramCallable = this.tail.continueWith(this.executor, newContinuation(paramCallable));
      this.tail = ignoreResult(paramCallable);
      return paramCallable;
    }
  }
  
  public <T> Task<T> submitTask(Callable<Task<T>> paramCallable)
  {
    synchronized (this.tailLock)
    {
      paramCallable = this.tail.continueWithTask(this.executor, newContinuation(paramCallable));
      this.tail = ignoreResult(paramCallable);
      return paramCallable;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\CrashlyticsBackgroundWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */