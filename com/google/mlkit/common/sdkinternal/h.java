package com.google.mlkit.common.sdkinternal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

@KeepForSdk
public class h
{
  private static final Object a = new Object();
  @GuardedBy("lock")
  private static h b;
  private Handler c;
  
  private h(Looper paramLooper)
  {
    this.c = new zzb(paramLooper);
  }
  
  @KeepForSdk
  public static h a()
  {
    synchronized (a)
    {
      if (b == null)
      {
        localObject2 = new android/os/HandlerThread;
        ((HandlerThread)localObject2).<init>("MLHandler", 9);
        ((HandlerThread)localObject2).start();
        Looper localLooper = ((HandlerThread)localObject2).getLooper();
        localObject2 = new com/google/mlkit/common/sdkinternal/h;
        ((h)localObject2).<init>(localLooper);
        b = (h)localObject2;
      }
      Object localObject2 = b;
      return (h)localObject2;
    }
  }
  
  @KeepForSdk
  public static Executor d()
  {
    return a.c;
  }
  
  @KeepForSdk
  public <ResultT> Task<ResultT> b(Callable<ResultT> paramCallable)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    c(new s(paramCallable, localTaskCompletionSource));
    return localTaskCompletionSource.getTask();
  }
  
  @KeepForSdk
  public void c(Runnable paramRunnable)
  {
    d().execute(paramRunnable);
  }
  
  static enum a
    implements Executor
  {
    static
    {
      a locala = new a("INSTANCE", 0);
      c = locala;
      d = new a[] { locala };
    }
    
    public final void execute(@NonNull Runnable paramRunnable)
    {
      h.e(h.a()).post(paramRunnable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */