package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;

public class SessionReportingCoordinator
  implements CrashlyticsLifecycleEvents
{
  private static final int EVENT_THREAD_IMPORTANCE = 4;
  private static final String EVENT_TYPE_CRASH = "crash";
  private static final String EVENT_TYPE_LOGGED = "error";
  private static final int MAX_CHAINED_EXCEPTION_DEPTH = 8;
  private final CrashlyticsReportDataCapture dataCapture;
  private final LogFileManager logFileManager;
  private final UserMetadata reportMetadata;
  private final CrashlyticsReportPersistence reportPersistence;
  private final DataTransportCrashlyticsReportSender reportsSender;
  
  SessionReportingCoordinator(CrashlyticsReportDataCapture paramCrashlyticsReportDataCapture, CrashlyticsReportPersistence paramCrashlyticsReportPersistence, DataTransportCrashlyticsReportSender paramDataTransportCrashlyticsReportSender, LogFileManager paramLogFileManager, UserMetadata paramUserMetadata)
  {
    this.dataCapture = paramCrashlyticsReportDataCapture;
    this.reportPersistence = paramCrashlyticsReportPersistence;
    this.reportsSender = paramDataTransportCrashlyticsReportSender;
    this.logFileManager = paramLogFileManager;
    this.reportMetadata = paramUserMetadata;
  }
  
  public static SessionReportingCoordinator create(Context paramContext, IdManager paramIdManager, FileStore paramFileStore, AppData paramAppData, LogFileManager paramLogFileManager, UserMetadata paramUserMetadata, StackTraceTrimmingStrategy paramStackTraceTrimmingStrategy, SettingsDataProvider paramSettingsDataProvider)
  {
    paramFileStore = new File(paramFileStore.getFilesDirPath());
    return new SessionReportingCoordinator(new CrashlyticsReportDataCapture(paramContext, paramIdManager, paramAppData, paramStackTraceTrimmingStrategy), new CrashlyticsReportPersistence(paramFileStore, paramSettingsDataProvider), DataTransportCrashlyticsReportSender.create(paramContext), paramLogFileManager, paramUserMetadata);
  }
  
  @NonNull
  private static List<CrashlyticsReport.CustomAttribute> getSortedCustomAttributes(@NonNull Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.ensureCapacity(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList.add(CrashlyticsReport.CustomAttribute.builder().setKey((String)localEntry.getKey()).setValue((String)localEntry.getValue()).build());
    }
    Collections.sort(localArrayList, d.c);
    return localArrayList;
  }
  
  private boolean onReportSendComplete(@NonNull Task<CrashlyticsReportWithSessionId> paramTask)
  {
    if (paramTask.isSuccessful())
    {
      CrashlyticsReportWithSessionId localCrashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId)paramTask.getResult();
      paramTask = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Crashlytics report successfully enqueued to DataTransport: ");
      localStringBuilder.append(localCrashlyticsReportWithSessionId.getSessionId());
      paramTask.d(localStringBuilder.toString());
      this.reportPersistence.deleteFinalizedReport(localCrashlyticsReportWithSessionId.getSessionId());
      return true;
    }
    Logger.getLogger().w("Crashlytics report could not be enqueued to DataTransport", paramTask.getException());
    return false;
  }
  
  private void persistEvent(@NonNull Throwable paramThrowable, @NonNull Thread paramThread, @NonNull String paramString1, @NonNull String paramString2, long paramLong, boolean paramBoolean)
  {
    boolean bool = paramString2.equals("crash");
    paramThrowable = this.dataCapture.captureEventData(paramThrowable, paramThread, paramString2, paramLong, 4, 8, paramBoolean);
    paramThread = paramThrowable.toBuilder();
    paramString2 = this.logFileManager.getLogString();
    if (paramString2 != null) {
      paramThread.setLog(CrashlyticsReport.Session.Event.Log.builder().setContent(paramString2).build());
    } else {
      Logger.getLogger().v("No log data to include with this event.");
    }
    paramString2 = getSortedCustomAttributes(this.reportMetadata.getCustomKeys());
    if (!paramString2.isEmpty()) {
      paramThread.setApp(paramThrowable.getApp().toBuilder().setCustomAttributes(ImmutableList.from(paramString2)).build());
    }
    this.reportPersistence.persistEvent(paramThread.build(), paramString1, bool);
  }
  
  public void finalizeSessionWithNativeEvent(@NonNull String paramString, @NonNull List<NativeSessionFile> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CrashlyticsReport.FilesPayload.File localFile = ((NativeSessionFile)paramList.next()).asFilePayload();
      if (localFile != null) {
        localArrayList.add(localFile);
      }
    }
    this.reportPersistence.finalizeSessionWithNativeEvent(paramString, CrashlyticsReport.FilesPayload.builder().setFiles(ImmutableList.from(localArrayList)).build());
  }
  
  public void finalizeSessions(long paramLong, @Nullable String paramString)
  {
    this.reportPersistence.finalizeReports(paramString, paramLong);
  }
  
  public boolean hasReportsToSend()
  {
    return this.reportPersistence.hasFinalizedReports();
  }
  
  @NonNull
  public List<String> listSortedOpenSessionIds()
  {
    return this.reportPersistence.listSortedOpenSessionIds();
  }
  
  public void onBeginSession(@NonNull String paramString, long paramLong)
  {
    paramString = this.dataCapture.captureReportData(paramString, paramLong);
    this.reportPersistence.persistReport(paramString);
  }
  
  public void onCustomKey(String paramString1, String paramString2)
  {
    this.reportMetadata.setCustomKey(paramString1, paramString2);
  }
  
  public void onLog(long paramLong, String paramString)
  {
    this.logFileManager.writeToLog(paramLong, paramString);
  }
  
  public void onUserId(String paramString)
  {
    this.reportMetadata.setUserId(paramString);
  }
  
  public void persistFatalEvent(@NonNull Throwable paramThrowable, @NonNull Thread paramThread, @NonNull String paramString, long paramLong)
  {
    Logger localLogger = Logger.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Persisting fatal event for session ");
    localStringBuilder.append(paramString);
    localLogger.v(localStringBuilder.toString());
    persistEvent(paramThrowable, paramThread, paramString, "crash", paramLong, true);
  }
  
  public void persistNonFatalEvent(@NonNull Throwable paramThrowable, @NonNull Thread paramThread, @NonNull String paramString, long paramLong)
  {
    Logger localLogger = Logger.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Persisting non-fatal event for session ");
    localStringBuilder.append(paramString);
    localLogger.v(localStringBuilder.toString());
    persistEvent(paramThrowable, paramThread, paramString, "error", paramLong, false);
  }
  
  public void persistUserId(@NonNull String paramString)
  {
    String str = this.reportMetadata.getUserId();
    if (str == null)
    {
      Logger.getLogger().v("Could not persist user ID; no user ID available");
      return;
    }
    this.reportPersistence.persistUserIdForSession(str, paramString);
  }
  
  public void removeAllReports()
  {
    this.reportPersistence.deleteAllReports();
  }
  
  public Task<Void> sendReports(@NonNull Executor paramExecutor)
  {
    Object localObject = this.reportPersistence.loadFinalizedReports();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CrashlyticsReportWithSessionId localCrashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId)((Iterator)localObject).next();
      localArrayList.add(this.reportsSender.sendReport(localCrashlyticsReportWithSessionId).continueWith(paramExecutor, new c(this)));
    }
    return Tasks.whenAll(localArrayList);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\SessionReportingCoordinator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */