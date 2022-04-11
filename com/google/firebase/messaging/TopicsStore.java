package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

final class TopicsStore
{
  @GuardedBy("TopicsStore.class")
  private static WeakReference<TopicsStore> topicsStoreWeakReference;
  private final SharedPreferences sharedPreferences;
  private final Executor syncExecutor;
  private SharedPreferencesQueue topicOperationsQueue;
  
  private TopicsStore(SharedPreferences paramSharedPreferences, Executor paramExecutor)
  {
    this.syncExecutor = paramExecutor;
    this.sharedPreferences = paramSharedPreferences;
  }
  
  @WorkerThread
  public static TopicsStore getInstance(Context paramContext, Executor paramExecutor)
  {
    try
    {
      Object localObject = topicsStoreWeakReference;
      if (localObject != null) {
        localObject = (TopicsStore)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      if (localObject == null)
      {
        localObject = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
        paramContext = new com/google/firebase/messaging/TopicsStore;
        paramContext.<init>((SharedPreferences)localObject, paramExecutor);
        paramContext.initStore();
        paramExecutor = new java/lang/ref/WeakReference;
        paramExecutor.<init>(paramContext);
        topicsStoreWeakReference = paramExecutor;
        return paramContext;
      }
      return (TopicsStore)localObject;
    }
    finally {}
  }
  
  @WorkerThread
  private void initStore()
  {
    try
    {
      this.topicOperationsQueue = SharedPreferencesQueue.createInstance(this.sharedPreferences, "topic_operation_queue", ",", this.syncExecutor);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean addTopicOperation(TopicOperation paramTopicOperation)
  {
    try
    {
      boolean bool = this.topicOperationsQueue.add(paramTopicOperation.serialize());
      return bool;
    }
    finally
    {
      paramTopicOperation = finally;
      throw paramTopicOperation;
    }
  }
  
  @Nullable
  TopicOperation getNextTopicOperation()
  {
    try
    {
      TopicOperation localTopicOperation = TopicOperation.from(this.topicOperationsQueue.peek());
      return localTopicOperation;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean removeTopicOperation(TopicOperation paramTopicOperation)
  {
    try
    {
      boolean bool = this.topicOperationsQueue.remove(paramTopicOperation.serialize());
      return bool;
    }
    finally
    {
      paramTopicOperation = finally;
      throw paramTopicOperation;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\TopicsStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */