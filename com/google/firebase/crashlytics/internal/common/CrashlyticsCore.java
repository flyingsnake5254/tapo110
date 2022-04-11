package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.log.LogFileManager.DirectoryProvider;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.persistence.FileStoreImpl;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CrashlyticsCore
{
  static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
  static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
  static final String CRASH_MARKER_FILE_NAME = "crash_marker";
  static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
  private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
  static final int MAX_STACK_SIZE = 1024;
  private static final String MISSING_BUILD_ID_MSG = "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.";
  static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
  private final AnalyticsEventLogger analyticsEventLogger;
  private final FirebaseApp app;
  private final CrashlyticsBackgroundWorker backgroundWorker;
  private final BreadcrumbSource breadcrumbSource;
  private final Context context;
  private CrashlyticsController controller;
  private final ExecutorService crashHandlerExecutor;
  private CrashlyticsFileMarker crashMarker;
  private final DataCollectionArbiter dataCollectionArbiter;
  private boolean didCrashOnPreviousExecution;
  private final IdManager idManager;
  private CrashlyticsFileMarker initializationMarker;
  private final CrashlyticsNativeComponent nativeComponent;
  private final long startTime;
  
  public CrashlyticsCore(FirebaseApp paramFirebaseApp, IdManager paramIdManager, CrashlyticsNativeComponent paramCrashlyticsNativeComponent, DataCollectionArbiter paramDataCollectionArbiter, BreadcrumbSource paramBreadcrumbSource, AnalyticsEventLogger paramAnalyticsEventLogger, ExecutorService paramExecutorService)
  {
    this.app = paramFirebaseApp;
    this.dataCollectionArbiter = paramDataCollectionArbiter;
    this.context = paramFirebaseApp.getApplicationContext();
    this.idManager = paramIdManager;
    this.nativeComponent = paramCrashlyticsNativeComponent;
    this.breadcrumbSource = paramBreadcrumbSource;
    this.analyticsEventLogger = paramAnalyticsEventLogger;
    this.crashHandlerExecutor = paramExecutorService;
    this.backgroundWorker = new CrashlyticsBackgroundWorker(paramExecutorService);
    this.startTime = System.currentTimeMillis();
  }
  
  private void checkForPreviousCrash()
  {
    Object localObject = this.backgroundWorker.submit(new Callable()
    {
      public Boolean call()
        throws Exception
      {
        return Boolean.valueOf(CrashlyticsCore.this.controller.didCrashOnPreviousExecution());
      }
    });
    try
    {
      localObject = (Boolean)Utils.awaitEvenIfOnMainThread((Task)localObject);
      this.didCrashOnPreviousExecution = Boolean.TRUE.equals(localObject);
      return;
    }
    catch (Exception localException)
    {
      this.didCrashOnPreviousExecution = false;
    }
  }
  
  /* Error */
  private Task<Void> doBackgroundInitialization(SettingsDataProvider paramSettingsDataProvider)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 152	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:markInitializationStarted	()V
    //   4: aload_0
    //   5: getfield 87	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:breadcrumbSource	Lcom/google/firebase/crashlytics/internal/breadcrumbs/BreadcrumbSource;
    //   8: astore_2
    //   9: new 154	com/google/firebase/crashlytics/internal/common/b
    //   12: astore_3
    //   13: aload_3
    //   14: aload_0
    //   15: invokespecial 155	com/google/firebase/crashlytics/internal/common/b:<init>	(Lcom/google/firebase/crashlytics/internal/common/CrashlyticsCore;)V
    //   18: aload_2
    //   19: aload_3
    //   20: invokeinterface 161 2 0
    //   25: aload_1
    //   26: invokeinterface 167 1 0
    //   31: invokeinterface 173 1 0
    //   36: getfield 178	com/google/firebase/crashlytics/internal/settings/model/FeaturesSettingsData:collectReports	Z
    //   39: ifne +32 -> 71
    //   42: invokestatic 184	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   45: ldc -70
    //   47: invokevirtual 190	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   50: new 192	java/lang/RuntimeException
    //   53: astore_1
    //   54: aload_1
    //   55: ldc -70
    //   57: invokespecial 194	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   60: aload_1
    //   61: invokestatic 200	com/google/android/gms/tasks/Tasks:forException	(Ljava/lang/Exception;)Lcom/google/android/gms/tasks/Task;
    //   64: astore_1
    //   65: aload_0
    //   66: invokevirtual 203	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:markInitializationComplete	()V
    //   69: aload_1
    //   70: areturn
    //   71: aload_0
    //   72: getfield 121	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:controller	Lcom/google/firebase/crashlytics/internal/common/CrashlyticsController;
    //   75: invokevirtual 209	com/google/firebase/crashlytics/internal/common/CrashlyticsController:finalizeSessions	()Z
    //   78: ifne +11 -> 89
    //   81: invokestatic 184	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   84: ldc -45
    //   86: invokevirtual 214	com/google/firebase/crashlytics/internal/Logger:w	(Ljava/lang/String;)V
    //   89: aload_0
    //   90: getfield 121	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:controller	Lcom/google/firebase/crashlytics/internal/common/CrashlyticsController;
    //   93: aload_1
    //   94: invokeinterface 218 1 0
    //   99: invokevirtual 222	com/google/firebase/crashlytics/internal/common/CrashlyticsController:submitAllReports	(Lcom/google/android/gms/tasks/Task;)Lcom/google/android/gms/tasks/Task;
    //   102: astore_1
    //   103: aload_0
    //   104: invokevirtual 203	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:markInitializationComplete	()V
    //   107: aload_1
    //   108: areturn
    //   109: astore_1
    //   110: goto +24 -> 134
    //   113: astore_1
    //   114: invokestatic 184	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   117: ldc -32
    //   119: aload_1
    //   120: invokevirtual 228	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: aload_1
    //   124: invokestatic 200	com/google/android/gms/tasks/Tasks:forException	(Ljava/lang/Exception;)Lcom/google/android/gms/tasks/Task;
    //   127: astore_1
    //   128: aload_0
    //   129: invokevirtual 203	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:markInitializationComplete	()V
    //   132: aload_1
    //   133: areturn
    //   134: aload_0
    //   135: invokevirtual 203	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:markInitializationComplete	()V
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	CrashlyticsCore
    //   0	140	1	paramSettingsDataProvider	SettingsDataProvider
    //   8	11	2	localBreadcrumbSource	BreadcrumbSource
    //   12	8	3	localb	b
    // Exception table:
    //   from	to	target	type
    //   4	65	109	finally
    //   71	89	109	finally
    //   89	103	109	finally
    //   114	128	109	finally
    //   4	65	113	java/lang/Exception
    //   71	89	113	java/lang/Exception
    //   89	103	113	java/lang/Exception
  }
  
  private void finishInitSynchronously(final SettingsDataProvider paramSettingsDataProvider)
  {
    paramSettingsDataProvider = new Runnable()
    {
      public void run()
      {
        CrashlyticsCore.this.doBackgroundInitialization(paramSettingsDataProvider);
      }
    };
    paramSettingsDataProvider = this.crashHandlerExecutor.submit(paramSettingsDataProvider);
    Logger.getLogger().d("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
    try
    {
      paramSettingsDataProvider.get(4L, TimeUnit.SECONDS);
    }
    catch (TimeoutException paramSettingsDataProvider)
    {
      Logger.getLogger().e("Crashlytics timed out during initialization.", paramSettingsDataProvider);
    }
    catch (ExecutionException paramSettingsDataProvider)
    {
      Logger.getLogger().e("Crashlytics encountered a problem during initialization.", paramSettingsDataProvider);
    }
    catch (InterruptedException paramSettingsDataProvider)
    {
      Logger.getLogger().e("Crashlytics was interrupted during initialization.", paramSettingsDataProvider);
    }
  }
  
  public static String getVersion()
  {
    return "18.1.0";
  }
  
  static boolean isBuildIdValid(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Logger.getLogger().v("Configured not to require a build ID.");
      return true;
    }
    if (!TextUtils.isEmpty(paramString)) {
      return true;
    }
    Log.e("FirebaseCrashlytics", ".");
    Log.e("FirebaseCrashlytics", ".     |  | ");
    Log.e("FirebaseCrashlytics", ".     |  |");
    Log.e("FirebaseCrashlytics", ".     |  |");
    Log.e("FirebaseCrashlytics", ".   \\ |  | /");
    Log.e("FirebaseCrashlytics", ".    \\    /");
    Log.e("FirebaseCrashlytics", ".     \\  /");
    Log.e("FirebaseCrashlytics", ".      \\/");
    Log.e("FirebaseCrashlytics", ".");
    Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
    Log.e("FirebaseCrashlytics", ".");
    Log.e("FirebaseCrashlytics", ".      /\\");
    Log.e("FirebaseCrashlytics", ".     /  \\");
    Log.e("FirebaseCrashlytics", ".    /    \\");
    Log.e("FirebaseCrashlytics", ".   / |  | \\");
    Log.e("FirebaseCrashlytics", ".     |  |");
    Log.e("FirebaseCrashlytics", ".     |  |");
    Log.e("FirebaseCrashlytics", ".     |  |");
    Log.e("FirebaseCrashlytics", ".");
    return false;
  }
  
  @NonNull
  public Task<Boolean> checkForUnsentReports()
  {
    return this.controller.checkForUnsentReports();
  }
  
  public Task<Void> deleteUnsentReports()
  {
    return this.controller.deleteUnsentReports();
  }
  
  public boolean didCrashOnPreviousExecution()
  {
    return this.didCrashOnPreviousExecution;
  }
  
  boolean didPreviousInitializationFail()
  {
    return this.initializationMarker.isPresent();
  }
  
  public Task<Void> doBackgroundInitializationAsync(final SettingsDataProvider paramSettingsDataProvider)
  {
    Utils.callTask(this.crashHandlerExecutor, new Callable()
    {
      public Task<Void> call()
        throws Exception
      {
        return CrashlyticsCore.this.doBackgroundInitialization(paramSettingsDataProvider);
      }
    });
  }
  
  CrashlyticsController getController()
  {
    return this.controller;
  }
  
  public void log(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.startTime;
    this.controller.writeToLog(l1 - l2, paramString);
  }
  
  public void logException(@NonNull Throwable paramThrowable)
  {
    this.controller.writeNonFatalException(Thread.currentThread(), paramThrowable);
  }
  
  void markInitializationComplete()
  {
    this.backgroundWorker.submit(new Callable()
    {
      public Boolean call()
        throws Exception
      {
        try
        {
          boolean bool = CrashlyticsCore.this.initializationMarker.remove();
          if (!bool) {
            Logger.getLogger().w("Initialization marker file was not properly removed.");
          }
          return Boolean.valueOf(bool);
        }
        catch (Exception localException)
        {
          Logger.getLogger().e("Problem encountered deleting Crashlytics initialization marker.", localException);
        }
        return Boolean.FALSE;
      }
    });
  }
  
  void markInitializationStarted()
  {
    this.backgroundWorker.checkRunningOnThread();
    this.initializationMarker.create();
    Logger.getLogger().v("Initialization marker file was created.");
  }
  
  public boolean onPreExecute(AppData paramAppData, SettingsDataProvider paramSettingsDataProvider)
  {
    boolean bool = CommonUtils.getBooleanResourceValue(this.context, "com.crashlytics.RequireBuildId", true);
    if (isBuildIdValid(paramAppData.buildId, bool)) {
      try
      {
        FileStoreImpl localFileStoreImpl = new com/google/firebase/crashlytics/internal/persistence/FileStoreImpl;
        localFileStoreImpl.<init>(this.context);
        Object localObject1 = new com/google/firebase/crashlytics/internal/common/CrashlyticsFileMarker;
        ((CrashlyticsFileMarker)localObject1).<init>("crash_marker", localFileStoreImpl);
        this.crashMarker = ((CrashlyticsFileMarker)localObject1);
        localObject1 = new com/google/firebase/crashlytics/internal/common/CrashlyticsFileMarker;
        ((CrashlyticsFileMarker)localObject1).<init>("initialization_marker", localFileStoreImpl);
        this.initializationMarker = ((CrashlyticsFileMarker)localObject1);
        UserMetadata localUserMetadata = new com/google/firebase/crashlytics/internal/common/UserMetadata;
        localUserMetadata.<init>();
        localObject1 = new com/google/firebase/crashlytics/internal/common/CrashlyticsCore$LogFileDirectoryProvider;
        ((LogFileDirectoryProvider)localObject1).<init>(localFileStoreImpl);
        LogFileManager localLogFileManager = new com/google/firebase/crashlytics/internal/log/LogFileManager;
        localLogFileManager.<init>(this.context, (LogFileManager.DirectoryProvider)localObject1);
        Object localObject2 = new com/google/firebase/crashlytics/internal/stacktrace/MiddleOutFallbackStrategy;
        Object localObject3 = new com/google/firebase/crashlytics/internal/stacktrace/RemoveRepeatsStrategy;
        ((RemoveRepeatsStrategy)localObject3).<init>(10);
        ((MiddleOutFallbackStrategy)localObject2).<init>(1024, new StackTraceTrimmingStrategy[] { localObject3 });
        localObject2 = SessionReportingCoordinator.create(this.context, this.idManager, localFileStoreImpl, paramAppData, localLogFileManager, localUserMetadata, (StackTraceTrimmingStrategy)localObject2, paramSettingsDataProvider);
        localObject3 = new com/google/firebase/crashlytics/internal/common/CrashlyticsController;
        ((CrashlyticsController)localObject3).<init>(this.context, this.backgroundWorker, this.idManager, this.dataCollectionArbiter, localFileStoreImpl, this.crashMarker, paramAppData, localUserMetadata, localLogFileManager, (LogFileManager.DirectoryProvider)localObject1, (SessionReportingCoordinator)localObject2, this.nativeComponent, this.analyticsEventLogger);
        this.controller = ((CrashlyticsController)localObject3);
        bool = didPreviousInitializationFail();
        checkForPreviousCrash();
        this.controller.enableExceptionHandling(Thread.getDefaultUncaughtExceptionHandler(), paramSettingsDataProvider);
        if ((bool) && (CommonUtils.canTryConnection(this.context)))
        {
          Logger.getLogger().d("Crashlytics did not finish previous background initialization. Initializing synchronously.");
          finishInitSynchronously(paramSettingsDataProvider);
          return false;
        }
        Logger.getLogger().d("Successfully configured exception handler.");
        return true;
      }
      catch (Exception paramAppData)
      {
        Logger.getLogger().e("Crashlytics was not started due to an exception during initialization", paramAppData);
        this.controller = null;
        return false;
      }
    }
    throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
  }
  
  public Task<Void> sendUnsentReports()
  {
    return this.controller.sendUnsentReports();
  }
  
  public void setCrashlyticsCollectionEnabled(@Nullable Boolean paramBoolean)
  {
    this.dataCollectionArbiter.setCrashlyticsDataCollectionEnabled(paramBoolean);
  }
  
  public void setCustomKey(String paramString1, String paramString2)
  {
    this.controller.setCustomKey(paramString1, paramString2);
  }
  
  public void setCustomKeys(Map<String, String> paramMap)
  {
    this.controller.setCustomKeys(paramMap);
  }
  
  public void setUserId(String paramString)
  {
    this.controller.setUserId(paramString);
  }
  
  private static final class LogFileDirectoryProvider
    implements LogFileManager.DirectoryProvider
  {
    private static final String LOG_FILES_DIR = "log-files";
    private final FileStore rootFileStore;
    
    public LogFileDirectoryProvider(FileStore paramFileStore)
    {
      this.rootFileStore = paramFileStore;
    }
    
    public File getLogFileDir()
    {
      File localFile = new File(this.rootFileStore.getFilesDir(), "log-files");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return localFile;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\CrashlyticsCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */