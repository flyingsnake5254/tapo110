package com.google.firebase.crashlytics.internal.persistence;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class CrashlyticsReportPersistence
{
  private static final String EVENT_COUNTER_FORMAT = "%010d";
  private static final int EVENT_COUNTER_WIDTH = 10;
  private static final FilenameFilter EVENT_FILE_FILTER = f.c;
  private static final String EVENT_FILE_NAME_PREFIX = "event";
  private static final int EVENT_NAME_LENGTH;
  private static final Comparator<? super File> LATEST_SESSION_ID_FIRST_COMPARATOR;
  private static final int MAX_OPEN_SESSIONS = 8;
  private static final String NATIVE_REPORTS_DIRECTORY = "native-reports";
  private static final String NORMAL_EVENT_SUFFIX = "";
  private static final String OPEN_SESSIONS_DIRECTORY_NAME = "sessions";
  private static final String PRIORITY_EVENT_SUFFIX = "_";
  private static final String PRIORITY_REPORTS_DIRECTORY = "priority-reports";
  private static final String REPORTS_DIRECTORY = "reports";
  private static final String REPORT_FILE_NAME = "report";
  private static final CrashlyticsReportJsonTransform TRANSFORM;
  private static final String USER_FILE_NAME = "user";
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private static final String WORKING_DIRECTORY_NAME = "report-persistence";
  @NonNull
  private final AtomicInteger eventCounter = new AtomicInteger(0);
  @NonNull
  private final File nativeReportsDirectory;
  @NonNull
  private final File openSessionsDirectory;
  @NonNull
  private final File priorityReportsDirectory;
  @NonNull
  private final File reportsDirectory;
  @NonNull
  private final SettingsDataProvider settingsDataProvider;
  
  static
  {
    EVENT_NAME_LENGTH = 15;
    TRANSFORM = new CrashlyticsReportJsonTransform();
    LATEST_SESSION_ID_FIRST_COMPARATOR = a.c;
  }
  
  public CrashlyticsReportPersistence(@NonNull File paramFile, @NonNull SettingsDataProvider paramSettingsDataProvider)
  {
    paramFile = new File(paramFile, "report-persistence");
    this.openSessionsDirectory = new File(paramFile, "sessions");
    this.priorityReportsDirectory = new File(paramFile, "priority-reports");
    this.reportsDirectory = new File(paramFile, "reports");
    this.nativeReportsDirectory = new File(paramFile, "native-reports");
    this.settingsDataProvider = paramSettingsDataProvider;
  }
  
  @NonNull
  private List<File> capAndGetOpenSessions(@Nullable String paramString)
  {
    paramString = new d(paramString);
    paramString = getFilesInDirectory(this.openSessionsDirectory, paramString);
    Collections.sort(paramString, LATEST_SESSION_ID_FIRST_COMPARATOR);
    if (paramString.size() <= 8) {
      return paramString;
    }
    Iterator localIterator = paramString.subList(8, paramString.size()).iterator();
    while (localIterator.hasNext()) {
      recursiveDelete((File)localIterator.next());
    }
    return paramString.subList(0, 8);
  }
  
  private static int capFilesCount(List<File> paramList, int paramInt)
  {
    int i = paramList.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      File localFile = (File)paramList.next();
      if (i <= paramInt) {
        return i;
      }
      recursiveDelete(localFile);
      i--;
    }
    return i;
  }
  
  private void capFinalizedReports()
  {
    int i = this.settingsDataProvider.getSettings().getSessionData().maxCompleteSessionsCount;
    Object localObject = getAllFinalizedReportFiles();
    int j = ((List)localObject).size();
    if (j <= i) {
      return;
    }
    localObject = ((List)localObject).subList(i, j).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((File)((Iterator)localObject).next()).delete();
    }
  }
  
  @NonNull
  private static List<File> combineReportFiles(@NonNull List<File>... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramVarArgs.length;
    int j = 0;
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += paramVarArgs[k].size();
      k++;
    }
    localArrayList.ensureCapacity(m);
    m = paramVarArgs.length;
    for (k = j; k < m; k++) {
      localArrayList.addAll(paramVarArgs[k]);
    }
    return localArrayList;
  }
  
  @NonNull
  private static String generateEventFilename(int paramInt, boolean paramBoolean)
  {
    String str1 = String.format(Locale.US, "%010d", new Object[] { Integer.valueOf(paramInt) });
    String str2;
    if (paramBoolean) {
      str2 = "_";
    } else {
      str2 = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("event");
    localStringBuilder.append(str1);
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  @NonNull
  private static List<File> getAllFilesInDirectory(@NonNull File paramFile)
  {
    return getFilesInDirectory(paramFile, null);
  }
  
  @NonNull
  private List<File> getAllFinalizedReportFiles()
  {
    return sortAndCombineReportFiles(new List[] { combineReportFiles(new List[] { getAllFilesInDirectory(this.priorityReportsDirectory), getAllFilesInDirectory(this.nativeReportsDirectory) }), getAllFilesInDirectory(this.reportsDirectory) });
  }
  
  @NonNull
  private static String getEventNameWithoutPriority(@NonNull String paramString)
  {
    return paramString.substring(0, EVENT_NAME_LENGTH);
  }
  
  @NonNull
  private static List<File> getFilesInDirectory(@NonNull File paramFile, @Nullable FileFilter paramFileFilter)
  {
    if (!paramFile.isDirectory()) {
      return Collections.emptyList();
    }
    if (paramFileFilter == null) {
      paramFile = paramFile.listFiles();
    } else {
      paramFile = paramFile.listFiles(paramFileFilter);
    }
    if (paramFile != null) {
      paramFile = Arrays.asList(paramFile);
    } else {
      paramFile = Collections.emptyList();
    }
    return paramFile;
  }
  
  @NonNull
  private static List<File> getFilesInDirectory(@NonNull File paramFile, @Nullable FilenameFilter paramFilenameFilter)
  {
    if (!paramFile.isDirectory()) {
      return Collections.emptyList();
    }
    if (paramFilenameFilter == null) {
      paramFile = paramFile.listFiles();
    } else {
      paramFile = paramFile.listFiles(paramFilenameFilter);
    }
    if (paramFile != null) {
      paramFile = Arrays.asList(paramFile);
    } else {
      paramFile = Collections.emptyList();
    }
    return paramFile;
  }
  
  @NonNull
  private File getSessionDirectoryById(@NonNull String paramString)
  {
    return new File(this.openSessionsDirectory, paramString);
  }
  
  private static boolean isHighPriorityEventFile(@NonNull String paramString)
  {
    boolean bool;
    if ((paramString.startsWith("event")) && (paramString.endsWith("_"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean isNormalPriorityEventFile(@NonNull File paramFile, @NonNull String paramString)
  {
    boolean bool;
    if ((paramString.startsWith("event")) && (!paramString.endsWith("_"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean makeDirectory(@NonNull File paramFile)
  {
    boolean bool;
    if ((!paramFile.exists()) && (!paramFile.mkdirs())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static int oldestEventFileFirst(@NonNull File paramFile1, @NonNull File paramFile2)
  {
    return getEventNameWithoutPriority(paramFile1.getName()).compareTo(getEventNameWithoutPriority(paramFile2.getName()));
  }
  
  @NonNull
  private static File prepareDirectory(@NonNull File paramFile)
    throws IOException
  {
    if (makeDirectory(paramFile)) {
      return paramFile;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Could not create directory ");
    localStringBuilder.append(paramFile);
    throw new IOException(localStringBuilder.toString());
  }
  
  /* Error */
  @NonNull
  private static String readTextFile(@NonNull File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: sipush 8192
    //   3: newarray <illegal type>
    //   5: astore_1
    //   6: new 352	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 353	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_2
    //   14: new 355	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 357	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore_0
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 361	java/io/FileInputStream:read	([B)I
    //   28: istore_3
    //   29: iload_3
    //   30: ifle +13 -> 43
    //   33: aload_2
    //   34: aload_1
    //   35: iconst_0
    //   36: iload_3
    //   37: invokevirtual 365	java/io/ByteArrayOutputStream:write	([BII)V
    //   40: goto -17 -> 23
    //   43: new 241	java/lang/String
    //   46: dup
    //   47: aload_2
    //   48: invokevirtual 369	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   51: getstatic 75	com/google/firebase/crashlytics/internal/persistence/CrashlyticsReportPersistence:UTF_8	Ljava/nio/charset/Charset;
    //   54: invokespecial 372	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   57: astore_2
    //   58: aload_0
    //   59: invokevirtual 375	java/io/FileInputStream:close	()V
    //   62: aload_2
    //   63: areturn
    //   64: astore_2
    //   65: aload_0
    //   66: invokevirtual 375	java/io/FileInputStream:close	()V
    //   69: goto +9 -> 78
    //   72: astore_0
    //   73: aload_2
    //   74: aload_0
    //   75: invokevirtual 381	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramFile	File
    //   5	30	1	arrayOfByte	byte[]
    //   13	50	2	localObject1	Object
    //   64	15	2	localObject2	Object
    //   28	9	3	i	int
    // Exception table:
    //   from	to	target	type
    //   23	29	64	finally
    //   33	40	64	finally
    //   43	58	64	finally
    //   65	69	72	finally
  }
  
  private static void recursiveDelete(@Nullable File paramFile)
  {
    if (paramFile == null) {
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++) {
        recursiveDelete(arrayOfFile[j]);
      }
    }
    paramFile.delete();
  }
  
  @NonNull
  private static List<File> sortAndCombineReportFiles(@NonNull List<File>... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      Collections.sort(paramVarArgs[j], LATEST_SESSION_ID_FIRST_COMPARATOR);
    }
    return combineReportFiles(paramVarArgs);
  }
  
  private static void synthesizeNativeReportFile(@NonNull File paramFile1, @NonNull File paramFile2, @NonNull CrashlyticsReport.FilesPayload paramFilesPayload, @NonNull String paramString)
  {
    try
    {
      CrashlyticsReportJsonTransform localCrashlyticsReportJsonTransform = TRANSFORM;
      CrashlyticsReport localCrashlyticsReport = localCrashlyticsReportJsonTransform.reportFromJson(readTextFile(paramFile1)).withNdkPayload(paramFilesPayload);
      paramFilesPayload = new java/io/File;
      paramFilesPayload.<init>(prepareDirectory(paramFile2), paramString);
      writeTextFile(paramFilesPayload, localCrashlyticsReportJsonTransform.reportToJson(localCrashlyticsReport));
    }
    catch (IOException paramFile2)
    {
      paramFilesPayload = Logger.getLogger();
      paramString = new StringBuilder();
      paramString.append("Could not synthesize final native report file for ");
      paramString.append(paramFile1);
      paramFilesPayload.w(paramString.toString(), paramFile2);
    }
  }
  
  private void synthesizeReport(@NonNull File paramFile, long paramLong)
  {
    Object localObject1 = getFilesInDirectory(paramFile, EVENT_FILE_FILTER);
    if (((List)localObject1).isEmpty())
    {
      localObject1 = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Session ");
      localStringBuilder.append(paramFile.getName());
      localStringBuilder.append(" has no events.");
      ((Logger)localObject1).v(localStringBuilder.toString());
      return;
    }
    Collections.sort((List)localObject1);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = ((List)localObject1).iterator();
    boolean bool1 = false;
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label213;
      }
      File localFile = (File)((Iterator)localObject3).next();
      try
      {
        localArrayList.add(TRANSFORM.eventFromJson(readTextFile(localFile)));
        if (!bool1)
        {
          boolean bool2 = isHighPriorityEventFile(localFile.getName());
          if (!bool2) {
            break;
          }
        }
        bool1 = true;
      }
      catch (IOException localIOException1)
      {
        Logger localLogger = Logger.getLogger();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Could not add event to report for ");
        ((StringBuilder)localObject1).append(localFile);
        localLogger.w(((StringBuilder)localObject1).toString(), localIOException1);
      }
    }
    label213:
    if (localArrayList.isEmpty())
    {
      localObject1 = Logger.getLogger();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Could not parse event files for session ");
      ((StringBuilder)localObject2).append(paramFile.getName());
      ((Logger)localObject1).w(((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject2 = null;
    localObject3 = new File(paramFile, "user");
    localObject1 = localObject2;
    if (((File)localObject3).isFile()) {
      try
      {
        localObject1 = readTextFile((File)localObject3);
      }
      catch (IOException localIOException2)
      {
        localObject3 = Logger.getLogger();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Could not read user ID file in ");
        ((StringBuilder)localObject1).append(paramFile.getName());
        ((Logger)localObject3).w(((StringBuilder)localObject1).toString(), localIOException2);
        localObject1 = localObject2;
      }
    }
    localObject2 = new File(paramFile, "report");
    if (bool1) {
      paramFile = this.priorityReportsDirectory;
    } else {
      paramFile = this.reportsDirectory;
    }
    synthesizeReportFile((File)localObject2, paramFile, localArrayList, paramLong, bool1, (String)localObject1);
  }
  
  private static void synthesizeReportFile(@NonNull File paramFile1, @NonNull File paramFile2, @NonNull List<CrashlyticsReport.Session.Event> paramList, long paramLong, boolean paramBoolean, @Nullable String paramString)
  {
    try
    {
      CrashlyticsReportJsonTransform localCrashlyticsReportJsonTransform = TRANSFORM;
      paramList = localCrashlyticsReportJsonTransform.reportFromJson(readTextFile(paramFile1)).withSessionEndFields(paramLong, paramBoolean, paramString).withEvents(ImmutableList.from(paramList));
      CrashlyticsReport.Session localSession = paramList.getSession();
      if (localSession == null) {
        return;
      }
      paramString = new java/io/File;
      paramString.<init>(prepareDirectory(paramFile2), localSession.getIdentifier());
      writeTextFile(paramString, localCrashlyticsReportJsonTransform.reportToJson(paramList));
    }
    catch (IOException paramString)
    {
      paramFile2 = Logger.getLogger();
      paramList = new StringBuilder();
      paramList.append("Could not synthesize final report file for ");
      paramList.append(paramFile1);
      paramFile2.w(paramList.toString(), paramString);
    }
  }
  
  private static int trimEvents(@NonNull File paramFile, int paramInt)
  {
    paramFile = getFilesInDirectory(paramFile, b.c);
    Collections.sort(paramFile, e.c);
    return capFilesCount(paramFile, paramInt);
  }
  
  /* Error */
  private static void writeTextFile(File paramFile, String paramString)
    throws IOException
  {
    // Byte code:
    //   0: new 499	java/io/OutputStreamWriter
    //   3: dup
    //   4: new 501	java/io/FileOutputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 502	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: getstatic 75	com/google/firebase/crashlytics/internal/persistence/CrashlyticsReportPersistence:UTF_8	Ljava/nio/charset/Charset;
    //   15: invokespecial 505	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   18: astore_0
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 507	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: invokevirtual 508	java/io/OutputStreamWriter:close	()V
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: invokevirtual 508	java/io/OutputStreamWriter:close	()V
    //   34: goto +9 -> 43
    //   37: astore_0
    //   38: aload_1
    //   39: aload_0
    //   40: invokevirtual 381	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	paramFile	File
    //   0	45	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   19	24	29	finally
    //   30	34	37	finally
  }
  
  public void deleteAllReports()
  {
    Iterator localIterator = getAllFinalizedReportFiles().iterator();
    while (localIterator.hasNext()) {
      ((File)localIterator.next()).delete();
    }
  }
  
  public void deleteFinalizedReport(String paramString)
  {
    paramString = new c(paramString);
    paramString = combineReportFiles(new List[] { getFilesInDirectory(this.priorityReportsDirectory, paramString), getFilesInDirectory(this.nativeReportsDirectory, paramString), getFilesInDirectory(this.reportsDirectory, paramString) }).iterator();
    while (paramString.hasNext()) {
      ((File)paramString.next()).delete();
    }
  }
  
  public void finalizeReports(@Nullable String paramString, long paramLong)
  {
    Iterator localIterator = capAndGetOpenSessions(paramString).iterator();
    while (localIterator.hasNext())
    {
      paramString = (File)localIterator.next();
      Logger localLogger = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Finalizing report for session ");
      localStringBuilder.append(paramString.getName());
      localLogger.v(localStringBuilder.toString());
      synthesizeReport(paramString, paramLong);
      recursiveDelete(paramString);
    }
    capFinalizedReports();
  }
  
  public void finalizeSessionWithNativeEvent(@NonNull String paramString, @NonNull CrashlyticsReport.FilesPayload paramFilesPayload)
  {
    synthesizeNativeReportFile(new File(getSessionDirectoryById(paramString), "report"), this.nativeReportsDirectory, paramFilesPayload, paramString);
  }
  
  public boolean hasFinalizedReports()
  {
    return getAllFinalizedReportFiles().isEmpty() ^ true;
  }
  
  @NonNull
  public List<String> listSortedOpenSessionIds()
  {
    Object localObject = getAllFilesInDirectory(this.openSessionsDirectory);
    Collections.sort((List)localObject, LATEST_SESSION_ID_FIRST_COMPARATOR);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((File)((Iterator)localObject).next()).getName());
    }
    return localArrayList;
  }
  
  @NonNull
  public List<CrashlyticsReportWithSessionId> loadFinalizedReports()
  {
    Object localObject = getAllFinalizedReportFiles();
    ArrayList localArrayList = new ArrayList();
    localArrayList.ensureCapacity(((List)localObject).size());
    Iterator localIterator = getAllFinalizedReportFiles().iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      try
      {
        localArrayList.add(CrashlyticsReportWithSessionId.create(TRANSFORM.reportFromJson(readTextFile(localFile)), localFile.getName()));
      }
      catch (IOException localIOException)
      {
        localObject = Logger.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not load report file ");
        localStringBuilder.append(localFile);
        localStringBuilder.append("; deleting");
        ((Logger)localObject).w(localStringBuilder.toString(), localIOException);
        localFile.delete();
      }
    }
    return localArrayList;
  }
  
  public void persistEvent(@NonNull CrashlyticsReport.Session.Event paramEvent, @NonNull String paramString)
  {
    persistEvent(paramEvent, paramString, false);
  }
  
  public void persistEvent(@NonNull CrashlyticsReport.Session.Event paramEvent, @NonNull String paramString, boolean paramBoolean)
  {
    int i = this.settingsDataProvider.getSettings().getSessionData().maxCustomExceptionEvents;
    File localFile = getSessionDirectoryById(paramString);
    paramEvent = TRANSFORM.eventToJson(paramEvent);
    String str = generateEventFilename(this.eventCounter.getAndIncrement(), paramBoolean);
    try
    {
      localObject = new java/io/File;
      ((File)localObject).<init>(localFile, str);
      writeTextFile((File)localObject, paramEvent);
    }
    catch (IOException localIOException)
    {
      Object localObject = Logger.getLogger();
      paramEvent = new StringBuilder();
      paramEvent.append("Could not persist event for session ");
      paramEvent.append(paramString);
      ((Logger)localObject).w(paramEvent.toString(), localIOException);
    }
    trimEvents(localFile, i);
  }
  
  public void persistReport(@NonNull CrashlyticsReport paramCrashlyticsReport)
  {
    Object localObject1 = paramCrashlyticsReport.getSession();
    if (localObject1 == null)
    {
      Logger.getLogger().d("Could not get session for report");
      return;
    }
    localObject1 = ((CrashlyticsReport.Session)localObject1).getIdentifier();
    try
    {
      localObject2 = prepareDirectory(getSessionDirectoryById((String)localObject1));
      paramCrashlyticsReport = TRANSFORM.reportToJson(paramCrashlyticsReport);
      localObject3 = new java/io/File;
      ((File)localObject3).<init>((File)localObject2, "report");
      writeTextFile((File)localObject3, paramCrashlyticsReport);
    }
    catch (IOException paramCrashlyticsReport)
    {
      Object localObject3 = Logger.getLogger();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Could not persist report for session ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((Logger)localObject3).d(((StringBuilder)localObject2).toString(), paramCrashlyticsReport);
    }
  }
  
  public void persistUserIdForSession(@NonNull String paramString1, @NonNull String paramString2)
  {
    Object localObject1 = getSessionDirectoryById(paramString2);
    try
    {
      localObject2 = new java/io/File;
      ((File)localObject2).<init>((File)localObject1, "user");
      writeTextFile((File)localObject2, paramString1);
    }
    catch (IOException paramString1)
    {
      Object localObject2 = Logger.getLogger();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Could not persist user ID for session ");
      ((StringBuilder)localObject1).append(paramString2);
      ((Logger)localObject2).w(((StringBuilder)localObject1).toString(), paramString1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\persistence\CrashlyticsReportPersistence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */