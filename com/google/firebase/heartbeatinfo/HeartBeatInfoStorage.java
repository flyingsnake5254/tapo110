package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class HeartBeatInfoStorage
{
  private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy z");
  private static final String GLOBAL = "fire-global";
  private static final int HEART_BEAT_COUNT_LIMIT = 200;
  private static final String HEART_BEAT_COUNT_TAG = "fire-count";
  private static final String PREFERENCES_NAME = "FirebaseAppHeartBeat";
  private static final String STORAGE_PREFERENCES_NAME = "FirebaseAppHeartBeatStorage";
  private static HeartBeatInfoStorage instance;
  private final SharedPreferences heartBeatSharedPreferences;
  private final SharedPreferences sharedPreferences;
  
  private HeartBeatInfoStorage(Context paramContext)
  {
    this.sharedPreferences = paramContext.getSharedPreferences("FirebaseAppHeartBeat", 0);
    this.heartBeatSharedPreferences = paramContext.getSharedPreferences("FirebaseAppHeartBeatStorage", 0);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.TESTS})
  @VisibleForTesting
  HeartBeatInfoStorage(SharedPreferences paramSharedPreferences1, SharedPreferences paramSharedPreferences2)
  {
    this.sharedPreferences = paramSharedPreferences1;
    this.heartBeatSharedPreferences = paramSharedPreferences2;
  }
  
  private void cleanUpStoredHeartBeats()
  {
    try
    {
      long l1 = this.sharedPreferences.getLong("fire-count", 0L);
      Object localObject1 = new java/util/ArrayList;
      ((ArrayList)localObject1).<init>();
      Object localObject3 = this.heartBeatSharedPreferences.getAll().entrySet().iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((ArrayList)localObject1).add(Long.valueOf(Long.parseLong((String)((Map.Entry)((Iterator)localObject3).next()).getKey())));
      }
      Collections.sort((List)localObject1);
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Long)((Iterator)localObject1).next();
        this.heartBeatSharedPreferences.edit().remove(String.valueOf(localObject3)).apply();
        localObject3 = this.sharedPreferences.edit();
        long l2 = l1 - 1L;
        ((SharedPreferences.Editor)localObject3).putLong("fire-count", l2).apply();
        l1 = l2;
        if (l2 <= 100L) {
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  static HeartBeatInfoStorage getInstance(Context paramContext)
  {
    try
    {
      if (instance == null)
      {
        HeartBeatInfoStorage localHeartBeatInfoStorage = new com/google/firebase/heartbeatinfo/HeartBeatInfoStorage;
        localHeartBeatInfoStorage.<init>(paramContext);
        instance = localHeartBeatInfoStorage;
      }
      paramContext = instance;
      return paramContext;
    }
    finally {}
  }
  
  static boolean isSameDateUtc(long paramLong1, long paramLong2)
  {
    Date localDate1 = new Date(paramLong1);
    Date localDate2 = new Date(paramLong2);
    SimpleDateFormat localSimpleDateFormat = FORMATTER;
    return localSimpleDateFormat.format(localDate1).equals(localSimpleDateFormat.format(localDate2)) ^ true;
  }
  
  void clearStoredHeartBeats()
  {
    try
    {
      this.heartBeatSharedPreferences.edit().clear().apply();
      this.sharedPreferences.edit().remove("fire-count").apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.TESTS})
  @VisibleForTesting
  int getHeartBeatCount()
  {
    return (int)this.sharedPreferences.getLong("fire-count", 0L);
  }
  
  long getLastGlobalHeartBeat()
  {
    try
    {
      long l = this.sharedPreferences.getLong("fire-global", -1L);
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  List<SdkHeartBeatResult> getStoredHeartBeats(boolean paramBoolean)
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      Iterator localIterator = this.heartBeatSharedPreferences.getAll().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        long l = Long.parseLong((String)localEntry.getKey());
        localArrayList.add(SdkHeartBeatResult.create((String)localEntry.getValue(), l));
      }
      Collections.sort(localArrayList);
      if (paramBoolean) {
        clearStoredHeartBeats();
      }
      return localArrayList;
    }
    finally {}
  }
  
  boolean shouldSendGlobalHeartBeat(long paramLong)
  {
    try
    {
      boolean bool = shouldSendSdkHeartBeat("fire-global", paramLong);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean shouldSendSdkHeartBeat(String paramString, long paramLong)
  {
    try
    {
      if (this.sharedPreferences.contains(paramString))
      {
        if (isSameDateUtc(this.sharedPreferences.getLong(paramString, -1L), paramLong))
        {
          this.sharedPreferences.edit().putLong(paramString, paramLong).apply();
          return true;
        }
        return false;
      }
      this.sharedPreferences.edit().putLong(paramString, paramLong).apply();
      return true;
    }
    finally {}
  }
  
  void storeHeartBeatInformation(String paramString, long paramLong)
  {
    try
    {
      long l = this.sharedPreferences.getLong("fire-count", 0L);
      this.heartBeatSharedPreferences.edit().putString(String.valueOf(paramLong), paramString).apply();
      paramString = this.sharedPreferences.edit();
      paramLong = l + 1L;
      paramString.putLong("fire-count", paramLong).apply();
      if (paramLong > 200L) {
        cleanUpStoredHeartBeats();
      }
      return;
    }
    finally {}
  }
  
  void updateGlobalHeartBeat(long paramLong)
  {
    try
    {
      this.sharedPreferences.edit().putLong("fire-global", paramLong).apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\heartbeatinfo\HeartBeatInfoStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */