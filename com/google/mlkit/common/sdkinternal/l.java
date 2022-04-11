package com.google.mlkit.common.sdkinternal;

import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
public abstract class l
{
  private final AtomicInteger a = new AtomicInteger(0);
  @KeepForSdk
  protected final n b = new n();
  private boolean c;
  
  @KeepForSdk
  public <T> Task<T> a(Executor paramExecutor, Callable<T> paramCallable, CancellationToken paramCancellationToken)
  {
    boolean bool;
    if (this.a.get() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    paramExecutor = new w(this, paramExecutor);
    z localz = new z(this, paramCancellationToken, paramCallable);
    if (paramCancellationToken == null) {
      return Tasks.call(paramExecutor, localz);
    }
    if (paramCancellationToken.isCancellationRequested()) {
      return Tasks.forCanceled();
    }
    CancellationTokenSource localCancellationTokenSource = new CancellationTokenSource();
    paramCallable = new TaskCompletionSource(localCancellationTokenSource.getToken());
    paramExecutor.execute(new y(paramCancellationToken, localCancellationTokenSource, localz, paramCallable));
    return paramCallable.getTask();
  }
  
  @VisibleForTesting
  @WorkerThread
  @KeepForSdk
  public abstract void b()
    throws MlKitException;
  
  @KeepForSdk
  public void c()
  {
    this.a.incrementAndGet();
  }
  
  @WorkerThread
  @KeepForSdk
  protected abstract void d();
  
  @KeepForSdk
  public void e(Executor paramExecutor)
  {
    boolean bool;
    if (this.a.get() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    this.b.a(paramExecutor, new x(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */