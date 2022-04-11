package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

final class SharedPreferencesQueue
{
  @GuardedBy("internalQueue")
  private boolean bulkOperation = false;
  @GuardedBy("internalQueue")
  private final ArrayDeque<String> internalQueue = new ArrayDeque();
  private final String itemSeparator;
  private final String queueName;
  private final SharedPreferences sharedPreferences;
  private final Executor syncExecutor;
  
  private SharedPreferencesQueue(SharedPreferences paramSharedPreferences, String paramString1, String paramString2, Executor paramExecutor)
  {
    this.sharedPreferences = paramSharedPreferences;
    this.queueName = "topic_operation_queue";
    this.itemSeparator = ",";
    this.syncExecutor = paramExecutor;
  }
  
  @GuardedBy("internalQueue")
  private boolean checkAndSyncState(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean)
    {
      bool = paramBoolean;
      if (!this.bulkOperation)
      {
        syncStateAsync();
        bool = true;
      }
    }
    return bool;
  }
  
  @WorkerThread
  static SharedPreferencesQueue createInstance(SharedPreferences paramSharedPreferences, String paramString1, String paramString2, Executor paramExecutor)
  {
    paramSharedPreferences = new SharedPreferencesQueue(paramSharedPreferences, "topic_operation_queue", ",", paramExecutor);
    paramSharedPreferences.initQueue();
    return paramSharedPreferences;
  }
  
  @WorkerThread
  private void initQueue()
  {
    synchronized (this.internalQueue)
    {
      this.internalQueue.clear();
      String str = this.sharedPreferences.getString(this.queueName, "");
      if ((!TextUtils.isEmpty(str)) && (str.contains(this.itemSeparator)))
      {
        String[] arrayOfString = str.split(this.itemSeparator, -1);
        int i = arrayOfString.length;
        int j = 0;
        int k = j;
        if (i == 0) {
          Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
        }
        for (k = j; k < i; k++)
        {
          str = arrayOfString[k];
          if (!TextUtils.isEmpty(str)) {
            this.internalQueue.add(str);
          }
        }
        return;
      }
      return;
    }
  }
  
  @WorkerThread
  private void syncState()
  {
    synchronized (this.internalQueue)
    {
      this.sharedPreferences.edit().putString(this.queueName, serialize()).commit();
      return;
    }
  }
  
  private void syncStateAsync()
  {
    this.syncExecutor.execute(new SharedPreferencesQueue..Lambda.0(this));
  }
  
  public boolean add(@NonNull String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.contains(this.itemSeparator))) {
      synchronized (this.internalQueue)
      {
        boolean bool = this.internalQueue.add(paramString);
        checkAndSyncState(bool);
        return bool;
      }
    }
    return false;
  }
  
  @Nullable
  public String peek()
  {
    synchronized (this.internalQueue)
    {
      String str = (String)this.internalQueue.peek();
      return str;
    }
  }
  
  public boolean remove(@Nullable Object paramObject)
  {
    synchronized (this.internalQueue)
    {
      boolean bool = this.internalQueue.remove(paramObject);
      checkAndSyncState(bool);
      return bool;
    }
  }
  
  @GuardedBy("internalQueue")
  @NonNull
  public String serialize()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.internalQueue.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      localStringBuilder.append(this.itemSeparator);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\SharedPreferencesQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */