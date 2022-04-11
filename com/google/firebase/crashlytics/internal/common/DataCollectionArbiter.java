package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;

public class DataCollectionArbiter
{
  private static final String FIREBASE_CRASHLYTICS_COLLECTION_ENABLED = "firebase_crashlytics_collection_enabled";
  @Nullable
  private Boolean crashlyticsDataCollectionEnabled;
  TaskCompletionSource<Void> dataCollectionEnabledTask;
  private final TaskCompletionSource<Void> dataCollectionExplicitlyApproved;
  private final FirebaseApp firebaseApp;
  private boolean setInManifest;
  private final SharedPreferences sharedPreferences;
  private final Object taskLock;
  boolean taskResolved;
  
  public DataCollectionArbiter(FirebaseApp paramFirebaseApp)
  {
    Object localObject = new Object();
    this.taskLock = localObject;
    this.dataCollectionEnabledTask = new TaskCompletionSource();
    this.taskResolved = false;
    this.setInManifest = false;
    this.dataCollectionExplicitlyApproved = new TaskCompletionSource();
    Context localContext = paramFirebaseApp.getApplicationContext();
    this.firebaseApp = paramFirebaseApp;
    this.sharedPreferences = CommonUtils.getSharedPrefs(localContext);
    Boolean localBoolean = getDataCollectionValueFromSharedPreferences();
    paramFirebaseApp = localBoolean;
    if (localBoolean == null) {
      paramFirebaseApp = getDataCollectionValueFromManifest(localContext);
    }
    this.crashlyticsDataCollectionEnabled = paramFirebaseApp;
    try
    {
      if (isAutomaticDataCollectionEnabled())
      {
        this.dataCollectionEnabledTask.trySetResult(null);
        this.taskResolved = true;
      }
      return;
    }
    finally {}
  }
  
  @Nullable
  private Boolean getDataCollectionValueFromManifest(Context paramContext)
  {
    paramContext = readCrashlyticsDataCollectionEnabledFromManifest(paramContext);
    if (paramContext == null)
    {
      this.setInManifest = false;
      return null;
    }
    this.setInManifest = true;
    return Boolean.valueOf(Boolean.TRUE.equals(paramContext));
  }
  
  @Nullable
  private Boolean getDataCollectionValueFromSharedPreferences()
  {
    if (this.sharedPreferences.contains("firebase_crashlytics_collection_enabled"))
    {
      this.setInManifest = false;
      return Boolean.valueOf(this.sharedPreferences.getBoolean("firebase_crashlytics_collection_enabled", true));
    }
    return null;
  }
  
  private void logDataCollectionState(boolean paramBoolean)
  {
    String str1;
    if (paramBoolean) {
      str1 = "ENABLED";
    } else {
      str1 = "DISABLED";
    }
    String str2;
    if (this.crashlyticsDataCollectionEnabled == null) {
      str2 = "global Firebase setting";
    } else if (this.setInManifest) {
      str2 = "firebase_crashlytics_collection_enabled manifest flag";
    } else {
      str2 = "API";
    }
    Logger.getLogger().d(String.format("Crashlytics automatic data collection %s by %s.", new Object[] { str1, str2 }));
  }
  
  @Nullable
  private static Boolean readCrashlyticsDataCollectionEnabledFromManifest(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getPackageManager();
      if (localObject != null)
      {
        localObject = ((PackageManager)localObject).getApplicationInfo(paramContext.getPackageName(), 128);
        if (localObject != null)
        {
          paramContext = ((ApplicationInfo)localObject).metaData;
          if ((paramContext != null) && (paramContext.containsKey("firebase_crashlytics_collection_enabled")))
          {
            boolean bool = ((ApplicationInfo)localObject).metaData.getBoolean("firebase_crashlytics_collection_enabled");
            return Boolean.valueOf(bool);
          }
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Logger.getLogger().e("Could not read data collection permission from manifest", paramContext);
    }
    return null;
  }
  
  @SuppressLint({"ApplySharedPref"})
  private static void storeDataCollectionValueInSharedPreferences(SharedPreferences paramSharedPreferences, Boolean paramBoolean)
  {
    paramSharedPreferences = paramSharedPreferences.edit();
    if (paramBoolean != null) {
      paramSharedPreferences.putBoolean("firebase_crashlytics_collection_enabled", paramBoolean.booleanValue());
    } else {
      paramSharedPreferences.remove("firebase_crashlytics_collection_enabled");
    }
    paramSharedPreferences.commit();
  }
  
  public void grantDataCollectionPermission(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.dataCollectionExplicitlyApproved.trySetResult(null);
      return;
    }
    throw new IllegalStateException("An invalid data collection token was used.");
  }
  
  public boolean isAutomaticDataCollectionEnabled()
  {
    try
    {
      Boolean localBoolean = this.crashlyticsDataCollectionEnabled;
      boolean bool;
      if (localBoolean != null) {
        bool = localBoolean.booleanValue();
      } else {
        bool = this.firebaseApp.isDataCollectionDefaultEnabled();
      }
      logDataCollectionState(bool);
      return bool;
    }
    finally {}
  }
  
  public void setCrashlyticsDataCollectionEnabled(@Nullable Boolean arg1)
  {
    if (??? != null) {
      try
      {
        this.setInManifest = false;
      }
      finally
      {
        break label125;
      }
    }
    Object localObject1;
    if (??? != null) {
      localObject1 = ???;
    } else {
      localObject1 = getDataCollectionValueFromManifest(this.firebaseApp.getApplicationContext());
    }
    this.crashlyticsDataCollectionEnabled = ((Boolean)localObject1);
    storeDataCollectionValueInSharedPreferences(this.sharedPreferences, ???);
    synchronized (this.taskLock)
    {
      if (isAutomaticDataCollectionEnabled())
      {
        if (!this.taskResolved)
        {
          this.dataCollectionEnabledTask.trySetResult(null);
          this.taskResolved = true;
        }
      }
      else if (this.taskResolved)
      {
        localObject1 = new com/google/android/gms/tasks/TaskCompletionSource;
        ((TaskCompletionSource)localObject1).<init>();
        this.dataCollectionEnabledTask = ((TaskCompletionSource)localObject1);
        this.taskResolved = false;
      }
      return;
    }
    label125:
    throw ???;
  }
  
  public Task<Void> waitForAutomaticDataCollectionEnabled()
  {
    synchronized (this.taskLock)
    {
      Task localTask = this.dataCollectionEnabledTask.getTask();
      return localTask;
    }
  }
  
  public Task<Void> waitForDataCollectionPermission()
  {
    return Utils.race(this.dataCollectionExplicitlyApproved.getTask(), waitForAutomaticDataCollectionEnabled());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\DataCollectionArbiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */