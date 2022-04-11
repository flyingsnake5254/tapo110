package androidx.arch.core.executor;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DefaultTaskExecutor
  extends TaskExecutor
{
  private final ExecutorService mDiskIO = Executors.newFixedThreadPool(4, new ThreadFactory()
  {
    private static final String THREAD_NAME_STEM = "arch_disk_io_%d";
    private final AtomicInteger mThreadId = new AtomicInteger(0);
    
    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      paramAnonymousRunnable = new Thread(paramAnonymousRunnable);
      paramAnonymousRunnable.setName(String.format("arch_disk_io_%d", new Object[] { Integer.valueOf(this.mThreadId.getAndIncrement()) }));
      return paramAnonymousRunnable;
    }
  });
  private final Object mLock = new Object();
  @Nullable
  private volatile Handler mMainHandler;
  
  private static Handler createAsync(@NonNull Looper paramLooper)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      return Handler.createAsync(paramLooper);
    }
    if (i >= 16) {}
    try
    {
      Handler localHandler = (Handler)Handler.class.getDeclaredConstructor(new Class[] { Looper.class, Handler.Callback.class, Boolean.TYPE }).newInstance(new Object[] { paramLooper, null, Boolean.TRUE });
      return localHandler;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      return new Handler(paramLooper);
      return new Handler(paramLooper);
    }
    catch (IllegalAccessException|InstantiationException|NoSuchMethodException localIllegalAccessException)
    {
      for (;;) {}
    }
  }
  
  public void executeOnDiskIO(Runnable paramRunnable)
  {
    this.mDiskIO.execute(paramRunnable);
  }
  
  public boolean isMainThread()
  {
    boolean bool;
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void postToMainThread(Runnable paramRunnable)
  {
    if (this.mMainHandler == null) {
      synchronized (this.mLock)
      {
        if (this.mMainHandler == null) {
          this.mMainHandler = createAsync(Looper.getMainLooper());
        }
      }
    }
    this.mMainHandler.post(paramRunnable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\arch\core\executor\DefaultTaskExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */