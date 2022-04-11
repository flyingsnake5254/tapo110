package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class WithinAppServiceConnection
  implements ServiceConnection
{
  @Nullable
  private WithinAppServiceBinder binder;
  @GuardedBy("this")
  private boolean connectionInProgress = false;
  private final Intent connectionIntent;
  private final Context context;
  private final Queue<BindRequest> intentQueue = new ArrayDeque();
  private final ScheduledExecutorService scheduledExecutorService;
  
  WithinAppServiceConnection(Context paramContext, String paramString)
  {
    this(paramContext, "com.google.firebase.MESSAGING_EVENT", new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
  }
  
  @VisibleForTesting
  WithinAppServiceConnection(Context paramContext, String paramString, ScheduledExecutorService paramScheduledExecutorService)
  {
    paramContext = paramContext.getApplicationContext();
    this.context = paramContext;
    this.connectionIntent = new Intent("com.google.firebase.MESSAGING_EVENT").setPackage(paramContext.getPackageName());
    this.scheduledExecutorService = paramScheduledExecutorService;
  }
  
  @GuardedBy("this")
  private void finishAllInQueue()
  {
    while (!this.intentQueue.isEmpty()) {
      ((BindRequest)this.intentQueue.poll()).finish();
    }
  }
  
  private void flushQueue()
  {
    try
    {
      if (Log.isLoggable("FirebaseMessaging", 3)) {
        Log.d("FirebaseMessaging", "flush queue called");
      }
      while (!this.intentQueue.isEmpty())
      {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
          Log.d("FirebaseMessaging", "found intent to be delivered");
        }
        Object localObject1 = this.binder;
        if ((localObject1 != null) && (((Binder)localObject1).isBinderAlive()))
        {
          if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
          }
          localObject1 = (BindRequest)this.intentQueue.poll();
          this.binder.send((BindRequest)localObject1);
        }
        else
        {
          startConnectionIfNeeded();
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  @GuardedBy("this")
  private void startConnectionIfNeeded()
  {
    if (Log.isLoggable("FirebaseMessaging", 3))
    {
      boolean bool = this.connectionInProgress;
      StringBuilder localStringBuilder = new StringBuilder(39);
      localStringBuilder.append("binder is dead. start connection? ");
      localStringBuilder.append(bool ^ true);
      Log.d("FirebaseMessaging", localStringBuilder.toString());
    }
    if (this.connectionInProgress) {
      return;
    }
    this.connectionInProgress = true;
    try
    {
      if (ConnectionTracker.getInstance().bindService(this.context, this.connectionIntent, this, 65)) {
        return;
      }
      Log.e("FirebaseMessaging", "binding to the service failed");
    }
    catch (SecurityException localSecurityException)
    {
      Log.e("FirebaseMessaging", "Exception while binding the service", localSecurityException);
    }
    this.connectionInProgress = false;
    finishAllInQueue();
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      int i;
      if (Log.isLoggable("FirebaseMessaging", 3))
      {
        paramComponentName = String.valueOf(paramComponentName);
        i = paramComponentName.length();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>(i + 20);
        localStringBuilder.append("onServiceConnected: ");
        localStringBuilder.append(paramComponentName);
        Log.d("FirebaseMessaging", localStringBuilder.toString());
      }
      this.connectionInProgress = false;
      if (!(paramIBinder instanceof WithinAppServiceBinder))
      {
        paramIBinder = String.valueOf(paramIBinder);
        i = paramIBinder.length();
        paramComponentName = new java/lang/StringBuilder;
        paramComponentName.<init>(i + 28);
        paramComponentName.append("Invalid service connection: ");
        paramComponentName.append(paramIBinder);
        Log.e("FirebaseMessaging", paramComponentName.toString());
        finishAllInQueue();
        return;
      }
      this.binder = ((WithinAppServiceBinder)paramIBinder);
      flushQueue();
      return;
    }
    finally {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (Log.isLoggable("FirebaseMessaging", 3))
    {
      paramComponentName = String.valueOf(paramComponentName);
      StringBuilder localStringBuilder = new StringBuilder(paramComponentName.length() + 23);
      localStringBuilder.append("onServiceDisconnected: ");
      localStringBuilder.append(paramComponentName);
      Log.d("FirebaseMessaging", localStringBuilder.toString());
    }
    flushQueue();
  }
  
  Task<Void> sendIntent(Intent paramIntent)
  {
    try
    {
      if (Log.isLoggable("FirebaseMessaging", 3)) {
        Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
      }
      BindRequest localBindRequest = new com/google/firebase/messaging/WithinAppServiceConnection$BindRequest;
      localBindRequest.<init>(paramIntent);
      localBindRequest.arrangeTimeout(this.scheduledExecutorService);
      this.intentQueue.add(localBindRequest);
      flushQueue();
      paramIntent = localBindRequest.getTask();
      return paramIntent;
    }
    finally {}
  }
  
  static class BindRequest
  {
    final Intent intent;
    private final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource();
    
    BindRequest(Intent paramIntent)
    {
      this.intent = paramIntent;
    }
    
    void arrangeTimeout(ScheduledExecutorService paramScheduledExecutorService)
    {
      ScheduledFuture localScheduledFuture = paramScheduledExecutorService.schedule(new WithinAppServiceConnection.BindRequest..Lambda.0(this), 9000L, TimeUnit.MILLISECONDS);
      getTask().addOnCompleteListener(paramScheduledExecutorService, new WithinAppServiceConnection.BindRequest..Lambda.1(localScheduledFuture));
    }
    
    void finish()
    {
      this.taskCompletionSource.trySetResult(null);
    }
    
    Task<Void> getTask()
    {
      return this.taskCompletionSource.getTask();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\WithinAppServiceConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */