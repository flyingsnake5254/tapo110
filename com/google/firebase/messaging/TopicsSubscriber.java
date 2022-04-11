package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class TopicsSubscriber
{
  private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8L);
  private final Context context;
  private final FirebaseInstallationsApi firebaseInstallationsApi;
  private final FirebaseMessaging firebaseMessaging;
  private final Metadata metadata;
  @GuardedBy("pendingOperations")
  private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> pendingOperations = new ArrayMap();
  private final GmsRpc rpc;
  private final TopicsStore store;
  private final ScheduledExecutorService syncExecutor;
  @GuardedBy("this")
  private boolean syncScheduledOrRunning = false;
  
  private TopicsSubscriber(FirebaseMessaging paramFirebaseMessaging, FirebaseInstallationsApi paramFirebaseInstallationsApi, Metadata paramMetadata, TopicsStore paramTopicsStore, GmsRpc paramGmsRpc, Context paramContext, @NonNull ScheduledExecutorService paramScheduledExecutorService)
  {
    this.firebaseMessaging = paramFirebaseMessaging;
    this.firebaseInstallationsApi = paramFirebaseInstallationsApi;
    this.metadata = paramMetadata;
    this.store = paramTopicsStore;
    this.rpc = paramGmsRpc;
    this.context = paramContext;
    this.syncExecutor = paramScheduledExecutorService;
  }
  
  private void addToPendingOperations(TopicOperation paramTopicOperation, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    synchronized (this.pendingOperations)
    {
      String str = paramTopicOperation.serialize();
      if (this.pendingOperations.containsKey(str))
      {
        paramTopicOperation = (ArrayDeque)this.pendingOperations.get(str);
      }
      else
      {
        paramTopicOperation = new java/util/ArrayDeque;
        paramTopicOperation.<init>();
        this.pendingOperations.put(str, paramTopicOperation);
      }
      paramTopicOperation.add(paramTaskCompletionSource);
      return;
    }
  }
  
  @WorkerThread
  private static <T> T awaitTask(Task<T> paramTask)
    throws IOException
  {
    try
    {
      try
      {
        paramTask = Tasks.await(paramTask, 30L, TimeUnit.SECONDS);
        return paramTask;
      }
      catch (TimeoutException paramTask) {}catch (InterruptedException paramTask) {}
      throw new IOException("SERVICE_NOT_AVAILABLE", paramTask);
    }
    catch (ExecutionException localExecutionException)
    {
      paramTask = localExecutionException.getCause();
      if (!(paramTask instanceof IOException))
      {
        if ((paramTask instanceof RuntimeException)) {
          throw ((RuntimeException)paramTask);
        }
        throw new IOException(localExecutionException);
      }
      throw ((IOException)paramTask);
    }
  }
  
  @WorkerThread
  private void blockingSubscribeToTopic(String paramString)
    throws IOException
  {
    String str = (String)awaitTask(this.firebaseInstallationsApi.getId());
    awaitTask(this.rpc.subscribeToTopic(str, this.firebaseMessaging.blockingGetToken(), paramString));
  }
  
  @WorkerThread
  private void blockingUnsubscribeFromTopic(String paramString)
    throws IOException
  {
    String str = (String)awaitTask(this.firebaseInstallationsApi.getId());
    awaitTask(this.rpc.unsubscribeFromTopic(str, this.firebaseMessaging.blockingGetToken(), paramString));
  }
  
  @VisibleForTesting
  static Task<TopicsSubscriber> createInstance(FirebaseMessaging paramFirebaseMessaging, FirebaseInstallationsApi paramFirebaseInstallationsApi, Metadata paramMetadata, GmsRpc paramGmsRpc, Context paramContext, @NonNull ScheduledExecutorService paramScheduledExecutorService)
  {
    return Tasks.call(paramScheduledExecutorService, new TopicsSubscriber..Lambda.0(paramContext, paramScheduledExecutorService, paramFirebaseMessaging, paramFirebaseInstallationsApi, paramMetadata, paramGmsRpc));
  }
  
  static boolean isDebugLogEnabled()
  {
    boolean bool1 = Log.isLoggable("FirebaseMessaging", 3);
    boolean bool2 = false;
    if (!bool1)
    {
      if (Build.VERSION.SDK_INT != 23) {
        return bool2;
      }
      if (!Log.isLoggable("FirebaseMessaging", 3)) {
        return false;
      }
    }
    bool2 = true;
    return bool2;
  }
  
  private void markCompletePendingOperation(TopicOperation paramTopicOperation)
  {
    synchronized (this.pendingOperations)
    {
      String str = paramTopicOperation.serialize();
      if (!this.pendingOperations.containsKey(str)) {
        return;
      }
      ArrayDeque localArrayDeque = (ArrayDeque)this.pendingOperations.get(str);
      paramTopicOperation = (TaskCompletionSource)localArrayDeque.poll();
      if (paramTopicOperation != null) {
        paramTopicOperation.setResult(null);
      }
      if (localArrayDeque.isEmpty()) {
        this.pendingOperations.remove(str);
      }
      return;
    }
  }
  
  private void startSync()
  {
    if (!isSyncScheduledOrRunning()) {
      syncWithDelaySecondsInternal(0L);
    }
  }
  
  boolean hasPendingOperation()
  {
    return this.store.getNextTopicOperation() != null;
  }
  
  boolean isSyncScheduledOrRunning()
  {
    try
    {
      boolean bool = this.syncScheduledOrRunning;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @WorkerThread
  boolean performTopicOperation(TopicOperation paramTopicOperation)
    throws IOException
  {
    try
    {
      localObject = paramTopicOperation.getOperation();
      int i = ((String)localObject).hashCode();
      if (i != 83)
      {
        if ((i == 85) && (((String)localObject).equals("U")))
        {
          i = 1;
          break label56;
        }
      }
      else if (((String)localObject).equals("S"))
      {
        i = 0;
        break label56;
      }
      i = -1;
      label56:
      if (i != 0)
      {
        if (i != 1)
        {
          if (isDebugLogEnabled())
          {
            paramTopicOperation = String.valueOf(paramTopicOperation);
            i = paramTopicOperation.length();
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>(i + 24);
            ((StringBuilder)localObject).append("Unknown topic operation");
            ((StringBuilder)localObject).append(paramTopicOperation);
            ((StringBuilder)localObject).append(".");
            Log.d("FirebaseMessaging", ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          blockingUnsubscribeFromTopic(paramTopicOperation.getTopic());
          if (isDebugLogEnabled())
          {
            paramTopicOperation = paramTopicOperation.getTopic();
            i = String.valueOf(paramTopicOperation).length();
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>(i + 35);
            ((StringBuilder)localObject).append("Unsubscribe from topic: ");
            ((StringBuilder)localObject).append(paramTopicOperation);
            ((StringBuilder)localObject).append(" succeeded.");
            Log.d("FirebaseMessaging", ((StringBuilder)localObject).toString());
          }
        }
      }
      else
      {
        blockingSubscribeToTopic(paramTopicOperation.getTopic());
        if (isDebugLogEnabled())
        {
          paramTopicOperation = paramTopicOperation.getTopic();
          i = String.valueOf(paramTopicOperation).length();
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>(i + 31);
          ((StringBuilder)localObject).append("Subscribe to topic: ");
          ((StringBuilder)localObject).append(paramTopicOperation);
          ((StringBuilder)localObject).append(" succeeded.");
          Log.d("FirebaseMessaging", ((StringBuilder)localObject).toString());
        }
      }
      return true;
    }
    catch (IOException paramTopicOperation)
    {
      if ((!"SERVICE_NOT_AVAILABLE".equals(paramTopicOperation.getMessage())) && (!"INTERNAL_SERVER_ERROR".equals(paramTopicOperation.getMessage())))
      {
        if (paramTopicOperation.getMessage() == null)
        {
          Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
          return false;
        }
        throw paramTopicOperation;
      }
      paramTopicOperation = paramTopicOperation.getMessage();
      Object localObject = new StringBuilder(String.valueOf(paramTopicOperation).length() + 53);
      ((StringBuilder)localObject).append("Topic operation failed: ");
      ((StringBuilder)localObject).append(paramTopicOperation);
      ((StringBuilder)localObject).append(". Will retry Topic operation.");
      Log.e("FirebaseMessaging", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  void scheduleSyncTaskWithDelaySeconds(Runnable paramRunnable, long paramLong)
  {
    this.syncExecutor.schedule(paramRunnable, paramLong, TimeUnit.SECONDS);
  }
  
  @VisibleForTesting
  Task<Void> scheduleTopicOperation(TopicOperation paramTopicOperation)
  {
    this.store.addTopicOperation(paramTopicOperation);
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    addToPendingOperations(paramTopicOperation, localTaskCompletionSource);
    return localTaskCompletionSource.getTask();
  }
  
  void setSyncScheduledOrRunning(boolean paramBoolean)
  {
    try
    {
      this.syncScheduledOrRunning = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void startTopicsSyncIfNecessary()
  {
    if (hasPendingOperation()) {
      startSync();
    }
  }
  
  Task<Void> subscribeToTopic(String paramString)
  {
    paramString = scheduleTopicOperation(TopicOperation.subscribe(paramString));
    startTopicsSyncIfNecessary();
    return paramString;
  }
  
  @WorkerThread
  boolean syncTopics()
    throws IOException
  {
    for (;;)
    {
      try
      {
        TopicOperation localTopicOperation = this.store.getNextTopicOperation();
        if (localTopicOperation == null)
        {
          if (isDebugLogEnabled()) {
            Log.d("FirebaseMessaging", "topic sync succeeded");
          }
          return true;
        }
        if (!performTopicOperation(localTopicOperation)) {
          return false;
        }
        this.store.removeTopicOperation(localTopicOperation);
        markCompletePendingOperation(localTopicOperation);
      }
      finally {}
    }
  }
  
  void syncWithDelaySecondsInternal(long paramLong)
  {
    long l = Math.min(Math.max(30L, paramLong + paramLong), MAX_DELAY_SEC);
    scheduleSyncTaskWithDelaySeconds(new TopicsSyncTask(this, this.context, this.metadata, l), paramLong);
    setSyncScheduledOrRunning(true);
  }
  
  Task<Void> unsubscribeFromTopic(String paramString)
  {
    paramString = scheduleTopicOperation(TopicOperation.unsubscribe(paramString));
    startTopicsSyncIfNecessary();
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\TopicsSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */