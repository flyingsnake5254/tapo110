package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
public abstract class EnhancedIntentService
  extends Service
{
  private Binder binder;
  @VisibleForTesting
  final ExecutorService executor = FcmExecutors.newIntentHandleExecutor();
  private int lastStartId;
  private final Object lock = new Object();
  private int runningTasks = 0;
  
  private void finishTask(Intent arg1)
  {
    if (??? != null) {
      WakeLockHolder.completeWakefulIntent(???);
    }
    synchronized (this.lock)
    {
      int i = this.runningTasks - 1;
      this.runningTasks = i;
      if (i == 0) {
        stopSelfResultHook(this.lastStartId);
      }
      return;
    }
  }
  
  @MainThread
  private Task<Void> processIntent(Intent paramIntent)
  {
    if (handleIntentOnMainThread(paramIntent)) {
      return Tasks.forResult(null);
    }
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    this.executor.execute(new EnhancedIntentService..Lambda.0(this, paramIntent, localTaskCompletionSource));
    return localTaskCompletionSource.getTask();
  }
  
  @NonNull
  protected Intent getStartCommandIntent(@NonNull Intent paramIntent)
  {
    return paramIntent;
  }
  
  public abstract void handleIntent(@NonNull Intent paramIntent);
  
  public boolean handleIntentOnMainThread(@NonNull Intent paramIntent)
  {
    return false;
  }
  
  @NonNull
  public final IBinder onBind(@NonNull Intent paramIntent)
  {
    try
    {
      if (Log.isLoggable("EnhancedIntentService", 3)) {
        Log.d("EnhancedIntentService", "Service received bind request");
      }
      if (this.binder == null)
      {
        paramIntent = new com/google/firebase/messaging/WithinAppServiceBinder;
        WithinAppServiceBinder.IntentHandler local1 = new com/google/firebase/messaging/EnhancedIntentService$1;
        local1.<init>(this);
        paramIntent.<init>(local1);
        this.binder = paramIntent;
      }
      paramIntent = this.binder;
      return paramIntent;
    }
    finally {}
  }
  
  @CallSuper
  public void onDestroy()
  {
    this.executor.shutdown();
    super.onDestroy();
  }
  
  public final int onStartCommand(@NonNull Intent paramIntent, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      this.lastStartId = paramInt2;
      this.runningTasks += 1;
      ??? = getStartCommandIntent(paramIntent);
      if (??? == null)
      {
        finishTask(paramIntent);
        return 2;
      }
      ??? = processIntent((Intent)???);
      if (((Task)???).isComplete())
      {
        finishTask(paramIntent);
        return 2;
      }
      ((Task)???).addOnCompleteListener(EnhancedIntentService..Lambda.1.$instance, new EnhancedIntentService..Lambda.2(this, paramIntent));
      return 3;
    }
  }
  
  boolean stopSelfResultHook(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\EnhancedIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */