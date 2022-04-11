package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.log.LogFileManager.DirectoryProvider;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsController
{
  static final FilenameFilter APP_EXCEPTION_MARKER_FILTER = a.c;
  static final String APP_EXCEPTION_MARKER_PREFIX = ".ae";
  static final String FIREBASE_APPLICATION_EXCEPTION = "_ae";
  static final String FIREBASE_CRASH_TYPE = "fatal";
  static final int FIREBASE_CRASH_TYPE_FATAL = 1;
  static final String FIREBASE_TIMESTAMP = "timestamp";
  private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
  static final String NATIVE_SESSION_DIR = "native-sessions";
  private final AnalyticsEventLogger analyticsEventLogger;
  private final AppData appData;
  private final CrashlyticsBackgroundWorker backgroundWorker;
  final AtomicBoolean checkForUnsentReportsCalled = new AtomicBoolean(false);
  private final Context context;
  private CrashlyticsUncaughtExceptionHandler crashHandler;
  private final CrashlyticsFileMarker crashMarker;
  private final DataCollectionArbiter dataCollectionArbiter;
  private final FileStore fileStore;
  private final IdManager idManager;
  private final LogFileManager.DirectoryProvider logFileDirectoryProvider;
  private final LogFileManager logFileManager;
  private final CrashlyticsNativeComponent nativeComponent;
  final TaskCompletionSource<Boolean> reportActionProvided = new TaskCompletionSource();
  private final SessionReportingCoordinator reportingCoordinator;
  private final String unityVersion;
  final TaskCompletionSource<Boolean> unsentReportsAvailable = new TaskCompletionSource();
  final TaskCompletionSource<Void> unsentReportsHandled = new TaskCompletionSource();
  private final UserMetadata userMetadata;
  
  CrashlyticsController(Context paramContext, CrashlyticsBackgroundWorker paramCrashlyticsBackgroundWorker, IdManager paramIdManager, DataCollectionArbiter paramDataCollectionArbiter, FileStore paramFileStore, CrashlyticsFileMarker paramCrashlyticsFileMarker, AppData paramAppData, UserMetadata paramUserMetadata, LogFileManager paramLogFileManager, LogFileManager.DirectoryProvider paramDirectoryProvider, SessionReportingCoordinator paramSessionReportingCoordinator, CrashlyticsNativeComponent paramCrashlyticsNativeComponent, AnalyticsEventLogger paramAnalyticsEventLogger)
  {
    this.context = paramContext;
    this.backgroundWorker = paramCrashlyticsBackgroundWorker;
    this.idManager = paramIdManager;
    this.dataCollectionArbiter = paramDataCollectionArbiter;
    this.fileStore = paramFileStore;
    this.crashMarker = paramCrashlyticsFileMarker;
    this.appData = paramAppData;
    this.userMetadata = paramUserMetadata;
    this.logFileManager = paramLogFileManager;
    this.logFileDirectoryProvider = paramDirectoryProvider;
    this.nativeComponent = paramCrashlyticsNativeComponent;
    this.unityVersion = paramAppData.unityVersionProvider.getUnityVersion();
    this.analyticsEventLogger = paramAnalyticsEventLogger;
    this.reportingCoordinator = paramSessionReportingCoordinator;
  }
  
  private void cacheKeyData(final Map<String, String> paramMap)
  {
    this.backgroundWorker.submit(new Callable()
    {
      public Void call()
        throws Exception
      {
        String str = CrashlyticsController.this.getCurrentSessionId();
        new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeKeyData(str, paramMap);
        return null;
      }
    });
  }
  
  private void cacheUserData(final UserMetadata paramUserMetadata)
  {
    this.backgroundWorker.submit(new Callable()
    {
      public Void call()
        throws Exception
      {
        String str = CrashlyticsController.this.getCurrentSessionId();
        if (str == null)
        {
          Logger.getLogger().d("Tried to cache user data while no session was open.");
          return null;
        }
        CrashlyticsController.this.reportingCoordinator.persistUserId(str);
        new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeUserData(str, paramUserMetadata);
        return null;
      }
    });
  }
  
  private static void deleteFiles(File[] paramArrayOfFile)
  {
    if (paramArrayOfFile == null) {
      return;
    }
    int i = paramArrayOfFile.length;
    for (int j = 0; j < i; j++) {
      paramArrayOfFile[j].delete();
    }
  }
  
  private void doCloseSessions(boolean paramBoolean)
  {
    List localList = this.reportingCoordinator.listSortedOpenSessionIds();
    if (localList.size() <= paramBoolean)
    {
      Logger.getLogger().v("No open sessions to be closed.");
      return;
    }
    String str = (String)localList.get(paramBoolean);
    if (this.nativeComponent.hasCrashDataForSession(str))
    {
      finalizePreviousNativeSession(str);
      if (!this.nativeComponent.finalizeSession(str))
      {
        localObject = Logger.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not finalize native session: ");
        localStringBuilder.append(str);
        ((Logger)localObject).w(localStringBuilder.toString());
      }
    }
    Object localObject = null;
    if (paramBoolean) {
      localObject = (String)localList.get(0);
    }
    this.reportingCoordinator.finalizeSessions(getCurrentTimestampSeconds(), (String)localObject);
  }
  
  private void doOpenSession()
  {
    long l = getCurrentTimestampSeconds();
    String str = new CLSUUID(this.idManager).toString();
    Logger localLogger = Logger.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Opening a new session with ID ");
    localStringBuilder.append(str);
    localLogger.d(localStringBuilder.toString());
    this.nativeComponent.openSession(str);
    writeBeginSession(str, l);
    writeSessionApp(str);
    writeSessionOS(str);
    writeSessionDevice(str);
    this.logFileManager.setCurrentSession(str);
    this.reportingCoordinator.onBeginSession(str, l);
  }
  
  private void doWriteAppExceptionMarker(long paramLong)
  {
    try
    {
      File localFile1 = new java/io/File;
      File localFile2 = getFilesDir();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append(".ae");
      localStringBuilder.append(paramLong);
      localFile1.<init>(localFile2, localStringBuilder.toString());
      localFile1.createNewFile();
    }
    catch (IOException localIOException)
    {
      Logger.getLogger().w("Could not create app exception marker file.", localIOException);
    }
  }
  
  private static File[] ensureFileArrayNotNull(File[] paramArrayOfFile)
  {
    File[] arrayOfFile = paramArrayOfFile;
    if (paramArrayOfFile == null) {
      arrayOfFile = new File[0];
    }
    return arrayOfFile;
  }
  
  private void finalizePreviousNativeSession(String paramString)
  {
    Object localObject1 = Logger.getLogger();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Finalizing native report for session ");
    ((StringBuilder)localObject2).append(paramString);
    ((Logger)localObject1).v(((StringBuilder)localObject2).toString());
    Object localObject3 = this.nativeComponent.getSessionFileProvider(paramString);
    localObject1 = ((NativeSessionFileProvider)localObject3).getMinidumpFile();
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      long l = ((File)localObject1).lastModified();
      localObject2 = new LogFileManager(this.context, this.logFileDirectoryProvider, paramString);
      localObject1 = new File(getNativeSessionFilesDir(), paramString);
      if (!((File)localObject1).mkdirs())
      {
        Logger.getLogger().w("Couldn't create directory to store native session files, aborting.");
        return;
      }
      doWriteAppExceptionMarker(l);
      localObject3 = getNativeSessionFiles((NativeSessionFileProvider)localObject3, paramString, getFilesDir(), ((LogFileManager)localObject2).getBytesForLog());
      NativeSessionFileGzipper.processNativeSessions((File)localObject1, (List)localObject3);
      this.reportingCoordinator.finalizeSessionWithNativeEvent(paramString, (List)localObject3);
      ((LogFileManager)localObject2).clearLog();
      return;
    }
    localObject1 = Logger.getLogger();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("No minidump data found for session ");
    ((StringBuilder)localObject2).append(paramString);
    ((Logger)localObject1).w(((StringBuilder)localObject2).toString());
  }
  
  private static boolean firebaseCrashExists()
  {
    try
    {
      Class.forName("com.google.firebase.crash.FirebaseCrash");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  private Context getContext()
  {
    return this.context;
  }
  
  @Nullable
  private String getCurrentSessionId()
  {
    Object localObject = this.reportingCoordinator.listSortedOpenSessionIds();
    if (!((List)localObject).isEmpty()) {
      localObject = (String)((List)localObject).get(0);
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  private static long getCurrentTimestampSeconds()
  {
    return getTimestampSeconds(new Date());
  }
  
  @NonNull
  static List<NativeSessionFile> getNativeSessionFiles(NativeSessionFileProvider paramNativeSessionFileProvider, String paramString, File paramFile, byte[] paramArrayOfByte)
  {
    Object localObject = new MetaDataStore(paramFile);
    paramFile = ((MetaDataStore)localObject).getUserDataFileForSession(paramString);
    localObject = ((MetaDataStore)localObject).getKeysFileForSession(paramString);
    paramString = new ArrayList();
    paramString.add(new BytesBackedNativeSessionFile("logs_file", "logs", paramArrayOfByte));
    paramString.add(new FileBackedNativeSessionFile("crash_meta_file", "metadata", paramNativeSessionFileProvider.getMetadataFile()));
    paramString.add(new FileBackedNativeSessionFile("session_meta_file", "session", paramNativeSessionFileProvider.getSessionFile()));
    paramString.add(new FileBackedNativeSessionFile("app_meta_file", "app", paramNativeSessionFileProvider.getAppFile()));
    paramString.add(new FileBackedNativeSessionFile("device_meta_file", "device", paramNativeSessionFileProvider.getDeviceFile()));
    paramString.add(new FileBackedNativeSessionFile("os_meta_file", "os", paramNativeSessionFileProvider.getOsFile()));
    paramString.add(new FileBackedNativeSessionFile("minidump_file", "minidump", paramNativeSessionFileProvider.getMinidumpFile()));
    paramString.add(new FileBackedNativeSessionFile("user_meta_file", "user", paramFile));
    paramString.add(new FileBackedNativeSessionFile("keys_file", "keys", (File)localObject));
    return paramString;
  }
  
  private static long getTimestampSeconds(Date paramDate)
  {
    return paramDate.getTime() / 1000L;
  }
  
  private static File[] listFilesMatching(File paramFile, FilenameFilter paramFilenameFilter)
  {
    return ensureFileArrayNotNull(paramFile.listFiles(paramFilenameFilter));
  }
  
  private File[] listFilesMatching(FilenameFilter paramFilenameFilter)
  {
    return listFilesMatching(getFilesDir(), paramFilenameFilter);
  }
  
  private Task<Void> logAnalyticsAppExceptionEvent(final long paramLong)
  {
    if (firebaseCrashExists())
    {
      Logger.getLogger().w("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
      return Tasks.forResult(null);
    }
    Logger.getLogger().d("Logging app exception event to Firebase Analytics");
    Tasks.call(new ScheduledThreadPoolExecutor(1), new Callable()
    {
      public Void call()
        throws Exception
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("fatal", 1);
        localBundle.putLong("timestamp", paramLong);
        CrashlyticsController.this.analyticsEventLogger.logEvent("_ae", localBundle);
        return null;
      }
    });
  }
  
  private Task<Void> logAnalyticsAppExceptionEvents()
  {
    ArrayList localArrayList = new ArrayList();
    for (File localFile : listAppExceptionMarkerFiles())
    {
      try
      {
        localArrayList.add(logAnalyticsAppExceptionEvent(Long.parseLong(localFile.getName().substring(3))));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Logger localLogger = Logger.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not parse app exception timestamp from file ");
        localStringBuilder.append(localFile.getName());
        localLogger.w(localStringBuilder.toString());
      }
      localFile.delete();
    }
    return Tasks.whenAll(localArrayList);
  }
  
  private Task<Boolean> waitForReportAction()
  {
    if (this.dataCollectionArbiter.isAutomaticDataCollectionEnabled())
    {
      Logger.getLogger().d("Automatic data collection is enabled. Allowing upload.");
      this.unsentReportsAvailable.trySetResult(Boolean.FALSE);
      return Tasks.forResult(Boolean.TRUE);
    }
    Logger.getLogger().d("Automatic data collection is disabled.");
    Logger.getLogger().v("Notifying that unsent reports are available.");
    this.unsentReportsAvailable.trySetResult(Boolean.TRUE);
    Task localTask = this.dataCollectionArbiter.waitForAutomaticDataCollectionEnabled().onSuccessTask(new SuccessContinuation()
    {
      @NonNull
      public Task<Boolean> then(@Nullable Void paramAnonymousVoid)
        throws Exception
      {
        return Tasks.forResult(Boolean.TRUE);
      }
    });
    Logger.getLogger().d("Waiting for send/deleteUnsentReports to be called.");
    return Utils.race(localTask, this.reportActionProvided.getTask());
  }
  
  private void writeBeginSession(String paramString, long paramLong)
  {
    String str = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[] { CrashlyticsCore.getVersion() });
    this.nativeComponent.writeBeginSession(paramString, str, paramLong);
  }
  
  private void writeSessionApp(String paramString)
  {
    String str1 = this.idManager.getAppIdentifier();
    Object localObject = this.appData;
    String str2 = ((AppData)localObject).versionCode;
    String str3 = ((AppData)localObject).versionName;
    localObject = this.idManager.getCrashlyticsInstallId();
    int i = DeliveryMechanism.determineFrom(this.appData.installerPackageName).getId();
    this.nativeComponent.writeSessionApp(paramString, str1, str2, str3, (String)localObject, i, this.unityVersion);
  }
  
  private void writeSessionDevice(String paramString)
  {
    Object localObject1 = getContext();
    Object localObject2 = new StatFs(Environment.getDataDirectory().getPath());
    int i = CommonUtils.getCpuArchitectureInt();
    String str = Build.MODEL;
    int j = Runtime.getRuntime().availableProcessors();
    long l1 = CommonUtils.getTotalRamInBytes();
    long l2 = ((StatFs)localObject2).getBlockCount();
    long l3 = ((StatFs)localObject2).getBlockSize();
    boolean bool = CommonUtils.isEmulator((Context)localObject1);
    int k = CommonUtils.getDeviceState((Context)localObject1);
    localObject2 = Build.MANUFACTURER;
    localObject1 = Build.PRODUCT;
    this.nativeComponent.writeSessionDevice(paramString, i, str, j, l1, l3 * l2, bool, k, (String)localObject2, (String)localObject1);
  }
  
  private void writeSessionOS(String paramString)
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = Build.VERSION.CODENAME;
    boolean bool = CommonUtils.isRooted(getContext());
    this.nativeComponent.writeSessionOs(paramString, str1, str2, bool);
  }
  
  @NonNull
  Task<Boolean> checkForUnsentReports()
  {
    if (!this.checkForUnsentReportsCalled.compareAndSet(false, true))
    {
      Logger.getLogger().w("checkForUnsentReports should only be called once per execution.");
      return Tasks.forResult(Boolean.FALSE);
    }
    return this.unsentReportsAvailable.getTask();
  }
  
  Task<Void> deleteUnsentReports()
  {
    this.reportActionProvided.trySetResult(Boolean.FALSE);
    return this.unsentReportsHandled.getTask();
  }
  
  boolean didCrashOnPreviousExecution()
  {
    boolean bool1 = this.crashMarker.isPresent();
    boolean bool2 = true;
    if (!bool1)
    {
      String str = getCurrentSessionId();
      if ((str == null) || (!this.nativeComponent.hasCrashDataForSession(str))) {
        bool2 = false;
      }
      return bool2;
    }
    Logger.getLogger().v("Found previous crash marker.");
    this.crashMarker.remove();
    return true;
  }
  
  void doCloseSessions()
  {
    doCloseSessions(false);
  }
  
  void enableExceptionHandling(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, SettingsDataProvider paramSettingsDataProvider)
  {
    openSession();
    paramUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new CrashlyticsUncaughtExceptionHandler.CrashListener()
    {
      public void onUncaughtException(@NonNull SettingsDataProvider paramAnonymousSettingsDataProvider, @NonNull Thread paramAnonymousThread, @NonNull Throwable paramAnonymousThrowable)
      {
        CrashlyticsController.this.handleUncaughtException(paramAnonymousSettingsDataProvider, paramAnonymousThread, paramAnonymousThrowable);
      }
    }, paramSettingsDataProvider, paramUncaughtExceptionHandler);
    this.crashHandler = paramUncaughtExceptionHandler;
    Thread.setDefaultUncaughtExceptionHandler(paramUncaughtExceptionHandler);
  }
  
  boolean finalizeSessions()
  {
    this.backgroundWorker.checkRunningOnThread();
    if (isHandlingException())
    {
      Logger.getLogger().w("Skipping session finalization because a crash has already occurred.");
      return false;
    }
    Logger.getLogger().v("Finalizing previously open sessions.");
    try
    {
      doCloseSessions(true);
      Logger.getLogger().v("Closed all previously open sessions.");
      return true;
    }
    catch (Exception localException)
    {
      Logger.getLogger().e("Unable to finalize previously open sessions.", localException);
    }
    return false;
  }
  
  File getFilesDir()
  {
    return this.fileStore.getFilesDir();
  }
  
  File getNativeSessionFilesDir()
  {
    return new File(getFilesDir(), "native-sessions");
  }
  
  UserMetadata getUserMetadata()
  {
    return this.userMetadata;
  }
  
  void handleUncaughtException(@NonNull SettingsDataProvider paramSettingsDataProvider, @NonNull Thread paramThread, @NonNull Throwable paramThrowable)
  {
    try
    {
      Object localObject1 = Logger.getLogger();
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((StringBuilder)localObject2).append("Handling uncaught exception \"");
      ((StringBuilder)localObject2).append(paramThrowable);
      ((StringBuilder)localObject2).append("\" from thread ");
      ((StringBuilder)localObject2).append(paramThread.getName());
      ((Logger)localObject1).d(((StringBuilder)localObject2).toString());
      Date localDate = new java/util/Date;
      localDate.<init>();
      localObject1 = this.backgroundWorker;
      localObject2 = new com/google/firebase/crashlytics/internal/common/CrashlyticsController$2;
      ((2)localObject2).<init>(this, localDate, paramThrowable, paramThread, paramSettingsDataProvider);
      paramSettingsDataProvider = ((CrashlyticsBackgroundWorker)localObject1).submitTask((Callable)localObject2);
      try
      {
        Utils.awaitEvenIfOnMainThread(paramSettingsDataProvider);
      }
      catch (Exception paramSettingsDataProvider)
      {
        Logger.getLogger().e("Error handling uncaught exception", paramSettingsDataProvider);
      }
      return;
    }
    finally {}
  }
  
  boolean isHandlingException()
  {
    CrashlyticsUncaughtExceptionHandler localCrashlyticsUncaughtExceptionHandler = this.crashHandler;
    boolean bool;
    if ((localCrashlyticsUncaughtExceptionHandler != null) && (localCrashlyticsUncaughtExceptionHandler.isHandlingException())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  File[] listAppExceptionMarkerFiles()
  {
    return listFilesMatching(APP_EXCEPTION_MARKER_FILTER);
  }
  
  File[] listNativeSessionFileDirectories()
  {
    return ensureFileArrayNotNull(getNativeSessionFilesDir().listFiles());
  }
  
  void openSession()
  {
    this.backgroundWorker.submit(new Callable()
    {
      public Void call()
        throws Exception
      {
        CrashlyticsController.this.doOpenSession();
        return null;
      }
    });
  }
  
  Task<Void> sendUnsentReports()
  {
    this.reportActionProvided.trySetResult(Boolean.TRUE);
    return this.unsentReportsHandled.getTask();
  }
  
  void setCustomKey(String paramString1, String paramString2)
  {
    try
    {
      this.userMetadata.setCustomKey(paramString1, paramString2);
      cacheKeyData(this.userMetadata.getCustomKeys());
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString2 = this.context;
      if ((paramString2 != null) && (CommonUtils.isAppDebuggable(paramString2))) {
        throw paramString1;
      }
      Logger.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
    }
  }
  
  void setCustomKeys(Map<String, String> paramMap)
  {
    this.userMetadata.setCustomKeys(paramMap);
    cacheKeyData(this.userMetadata.getCustomKeys());
  }
  
  void setUserId(String paramString)
  {
    this.userMetadata.setUserId(paramString);
    cacheUserData(this.userMetadata);
  }
  
  Task<Void> submitAllReports(final Task<AppSettingsData> paramTask)
  {
    if (!this.reportingCoordinator.hasReportsToSend())
    {
      Logger.getLogger().v("No crash reports are available to be sent.");
      this.unsentReportsAvailable.trySetResult(Boolean.FALSE);
      return Tasks.forResult(null);
    }
    Logger.getLogger().v("Crash reports are available to be sent.");
    waitForReportAction().onSuccessTask(new SuccessContinuation()
    {
      @NonNull
      public Task<Void> then(@Nullable final Boolean paramAnonymousBoolean)
        throws Exception
      {
        CrashlyticsController.this.backgroundWorker.submitTask(new Callable()
        {
          public Task<Void> call()
            throws Exception
          {
            if (!paramAnonymousBoolean.booleanValue())
            {
              Logger.getLogger().v("Deleting cached crash reports...");
              CrashlyticsController.deleteFiles(CrashlyticsController.this.listAppExceptionMarkerFiles());
              CrashlyticsController.this.reportingCoordinator.removeAllReports();
              CrashlyticsController.this.unsentReportsHandled.trySetResult(null);
              return Tasks.forResult(null);
            }
            Logger.getLogger().d("Sending cached crash reports...");
            boolean bool = paramAnonymousBoolean.booleanValue();
            CrashlyticsController.this.dataCollectionArbiter.grantDataCollectionPermission(bool);
            final Executor localExecutor = CrashlyticsController.this.backgroundWorker.getExecutor();
            CrashlyticsController.4.this.val$appSettingsDataTask.onSuccessTask(localExecutor, new SuccessContinuation()
            {
              @NonNull
              public Task<Void> then(@Nullable AppSettingsData paramAnonymous3AppSettingsData)
                throws Exception
              {
                if (paramAnonymous3AppSettingsData == null)
                {
                  Logger.getLogger().w("Received null app settings at app startup. Cannot send cached reports");
                  return Tasks.forResult(null);
                }
                CrashlyticsController.this.logAnalyticsAppExceptionEvents();
                CrashlyticsController.this.reportingCoordinator.sendReports(localExecutor);
                CrashlyticsController.this.unsentReportsHandled.trySetResult(null);
                return Tasks.forResult(null);
              }
            });
          }
        });
      }
    });
  }
  
  void writeNonFatalException(@NonNull final Thread paramThread, @NonNull final Throwable paramThrowable)
  {
    final Date localDate = new Date();
    this.backgroundWorker.submit(new Runnable()
    {
      public void run()
      {
        if (!CrashlyticsController.this.isHandlingException())
        {
          long l = CrashlyticsController.getTimestampSeconds(localDate);
          String str = CrashlyticsController.this.getCurrentSessionId();
          if (str == null)
          {
            Logger.getLogger().w("Tried to write a non-fatal exception while no session was open.");
            return;
          }
          CrashlyticsController.this.reportingCoordinator.persistNonFatalEvent(paramThrowable, paramThread, str, l);
        }
      }
    });
  }
  
  void writeToLog(final long paramLong, String paramString)
  {
    this.backgroundWorker.submit(new Callable()
    {
      public Void call()
        throws Exception
      {
        if (!CrashlyticsController.this.isHandlingException()) {
          CrashlyticsController.this.logFileManager.writeToLog(paramLong, this.val$msg);
        }
        return null;
      }
    });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\CrashlyticsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */