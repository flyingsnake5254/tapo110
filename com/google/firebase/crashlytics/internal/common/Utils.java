package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Utils
{
  private static final ExecutorService TASK_CONTINUATION_EXECUTOR_SERVICE = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");
  
  public static <T> T awaitEvenIfOnMainThread(Task<T> paramTask)
    throws InterruptedException, TimeoutException
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramTask.continueWith(TASK_CONTINUATION_EXECUTOR_SERVICE, new e(localCountDownLatch));
    if (Looper.getMainLooper() == Looper.myLooper()) {
      localCountDownLatch.await(4L, TimeUnit.SECONDS);
    } else {
      localCountDownLatch.await();
    }
    if (paramTask.isSuccessful()) {
      return (T)paramTask.getResult();
    }
    if (!paramTask.isCanceled())
    {
      if (paramTask.isComplete()) {
        throw new IllegalStateException(paramTask.getException());
      }
      throw new TimeoutException();
    }
    throw new CancellationException("Task is already canceled");
  }
  
  public static <T> Task<T> callTask(Executor paramExecutor, Callable<Task<T>> paramCallable)
  {
    final TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramExecutor.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          Task localTask = (Task)Utils.this.call();
          Continuation local1 = new com/google/firebase/crashlytics/internal/common/Utils$2$1;
          local1.<init>(this);
          localTask.continueWith(local1);
        }
        catch (Exception localException)
        {
          localTaskCompletionSource.setException(localException);
        }
      }
    });
    return localTaskCompletionSource.getTask();
  }
  
  public static <T> Task<T> race(Task<T> paramTask1, Task<T> paramTask2)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    Continuation local1 = new Continuation()
    {
      public Void then(@NonNull Task<T> paramAnonymousTask)
        throws Exception
      {
        if (paramAnonymousTask.isSuccessful()) {
          Utils.this.trySetResult(paramAnonymousTask.getResult());
        } else {
          Utils.this.trySetException(paramAnonymousTask.getException());
        }
        return null;
      }
    };
    paramTask1.continueWith(local1);
    paramTask2.continueWith(local1);
    return localTaskCompletionSource.getTask();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */