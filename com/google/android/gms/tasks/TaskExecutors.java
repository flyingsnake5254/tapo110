package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public final class TaskExecutors
{
  public static final Executor MAIN_THREAD = new zza();
  static final Executor zzw = new zzt();
  
  private static final class zza
    implements Executor
  {
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    
    public final void execute(@NonNull Runnable paramRunnable)
    {
      this.mHandler.post(paramRunnable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\tasks\TaskExecutors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */