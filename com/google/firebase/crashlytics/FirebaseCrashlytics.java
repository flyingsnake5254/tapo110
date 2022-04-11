package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.ProviderProxyNativeComponent;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.unity.ResourceUnityVersionProvider;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class FirebaseCrashlytics
{
  static final int APP_EXCEPTION_CALLBACK_TIMEOUT_MS = 500;
  static final String FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN = "clx";
  static final String LEGACY_CRASH_ANALYTICS_ORIGIN = "crash";
  private final CrashlyticsCore core;
  
  private FirebaseCrashlytics(@NonNull CrashlyticsCore paramCrashlyticsCore)
  {
    this.core = paramCrashlyticsCore;
  }
  
  @NonNull
  public static FirebaseCrashlytics getInstance()
  {
    FirebaseCrashlytics localFirebaseCrashlytics = (FirebaseCrashlytics)FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
    Objects.requireNonNull(localFirebaseCrashlytics, "FirebaseCrashlytics component is not present.");
    return localFirebaseCrashlytics;
  }
  
  @Nullable
  static FirebaseCrashlytics init(@NonNull final FirebaseApp paramFirebaseApp, @NonNull FirebaseInstallationsApi paramFirebaseInstallationsApi, @NonNull final Provider<CrashlyticsNativeComponent> paramProvider, @NonNull Deferred<AnalyticsConnector> paramDeferred)
  {
    Context localContext = paramFirebaseApp.getApplicationContext();
    Object localObject1 = localContext.getPackageName();
    Logger localLogger = Logger.getLogger();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Initializing Firebase Crashlytics ");
    ((StringBuilder)localObject2).append(CrashlyticsCore.getVersion());
    ((StringBuilder)localObject2).append(" for ");
    ((StringBuilder)localObject2).append((String)localObject1);
    localLogger.i(((StringBuilder)localObject2).toString());
    localObject2 = new DataCollectionArbiter(paramFirebaseApp);
    paramFirebaseInstallationsApi = new IdManager(localContext, (String)localObject1, paramFirebaseInstallationsApi, (DataCollectionArbiter)localObject2);
    paramProvider = new ProviderProxyNativeComponent(paramProvider);
    localObject1 = new AnalyticsDeferredProxy(paramDeferred);
    paramDeferred = ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler");
    paramProvider = new CrashlyticsCore(paramFirebaseApp, paramFirebaseInstallationsApi, paramProvider, (DataCollectionArbiter)localObject2, ((AnalyticsDeferredProxy)localObject1).getDeferredBreadcrumbSource(), ((AnalyticsDeferredProxy)localObject1).getAnalyticsEventLogger(), paramDeferred);
    paramFirebaseApp = paramFirebaseApp.getOptions().getApplicationId();
    paramDeferred = CommonUtils.getMappingFileId(localContext);
    localLogger = Logger.getLogger();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Mapping file ID is: ");
    ((StringBuilder)localObject1).append(paramDeferred);
    localLogger.d(((StringBuilder)localObject1).toString());
    localObject1 = new ResourceUnityVersionProvider(localContext);
    try
    {
      paramDeferred = AppData.create(localContext, paramFirebaseInstallationsApi, paramFirebaseApp, paramDeferred, (UnityVersionProvider)localObject1);
      localLogger = Logger.getLogger();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Installer package name is: ");
      ((StringBuilder)localObject1).append(paramDeferred.installerPackageName);
      localLogger.v(((StringBuilder)localObject1).toString());
      localObject1 = ExecutorUtils.buildSingleThreadExecutorService("com.google.firebase.crashlytics.startup");
      paramFirebaseApp = SettingsController.create(localContext, paramFirebaseApp, paramFirebaseInstallationsApi, new HttpRequestFactory(), paramDeferred.versionCode, paramDeferred.versionName, (DataCollectionArbiter)localObject2);
      paramFirebaseApp.loadSettingsData((Executor)localObject1).continueWith((Executor)localObject1, new Continuation()
      {
        public Object then(@NonNull Task<Void> paramAnonymousTask)
          throws Exception
        {
          if (!paramAnonymousTask.isSuccessful()) {
            Logger.getLogger().e("Error fetching settings.", paramAnonymousTask.getException());
          }
          return null;
        }
      });
      Tasks.call((Executor)localObject1, new Callable()
      {
        public Void call()
          throws Exception
        {
          if (this.val$finishCoreInBackground) {
            paramProvider.doBackgroundInitializationAsync(paramFirebaseApp);
          }
          return null;
        }
      });
      return new FirebaseCrashlytics(paramProvider);
    }
    catch (PackageManager.NameNotFoundException paramFirebaseApp)
    {
      Logger.getLogger().e("Error retrieving app package info.", paramFirebaseApp);
    }
    return null;
  }
  
  @NonNull
  public Task<Boolean> checkForUnsentReports()
  {
    return this.core.checkForUnsentReports();
  }
  
  public void deleteUnsentReports()
  {
    this.core.deleteUnsentReports();
  }
  
  public boolean didCrashOnPreviousExecution()
  {
    return this.core.didCrashOnPreviousExecution();
  }
  
  public void log(@NonNull String paramString)
  {
    this.core.log(paramString);
  }
  
  public void recordException(@NonNull Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      Logger.getLogger().w("A null value was passed to recordException. Ignoring.");
      return;
    }
    this.core.logException(paramThrowable);
  }
  
  public void sendUnsentReports()
  {
    this.core.sendUnsentReports();
  }
  
  public void setCrashlyticsCollectionEnabled(@Nullable Boolean paramBoolean)
  {
    this.core.setCrashlyticsCollectionEnabled(paramBoolean);
  }
  
  public void setCrashlyticsCollectionEnabled(boolean paramBoolean)
  {
    this.core.setCrashlyticsCollectionEnabled(Boolean.valueOf(paramBoolean));
  }
  
  public void setCustomKey(@NonNull String paramString, double paramDouble)
  {
    this.core.setCustomKey(paramString, Double.toString(paramDouble));
  }
  
  public void setCustomKey(@NonNull String paramString, float paramFloat)
  {
    this.core.setCustomKey(paramString, Float.toString(paramFloat));
  }
  
  public void setCustomKey(@NonNull String paramString, int paramInt)
  {
    this.core.setCustomKey(paramString, Integer.toString(paramInt));
  }
  
  public void setCustomKey(@NonNull String paramString, long paramLong)
  {
    this.core.setCustomKey(paramString, Long.toString(paramLong));
  }
  
  public void setCustomKey(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.core.setCustomKey(paramString1, paramString2);
  }
  
  public void setCustomKey(@NonNull String paramString, boolean paramBoolean)
  {
    this.core.setCustomKey(paramString, Boolean.toString(paramBoolean));
  }
  
  public void setCustomKeys(@NonNull CustomKeysAndValues paramCustomKeysAndValues)
  {
    this.core.setCustomKeys(paramCustomKeysAndValues.keysAndValues);
  }
  
  public void setUserId(@NonNull String paramString)
  {
    this.core.setUserId(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\FirebaseCrashlytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */