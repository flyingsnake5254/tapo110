package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.d;
import com.google.android.datatransport.e;
import com.google.android.datatransport.f;
import com.google.android.datatransport.h.r;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

public class DataTransportCrashlyticsReportSender
{
  private static final String CRASHLYTICS_API_KEY = mergeStrings("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
  private static final String CRASHLYTICS_ENDPOINT;
  private static final String CRASHLYTICS_TRANSPORT_NAME = "FIREBASE_CRASHLYTICS_REPORT";
  private static final d<CrashlyticsReport, byte[]> DEFAULT_TRANSFORM = a.a;
  private static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
  private final e<CrashlyticsReport> transport;
  private final d<CrashlyticsReport, byte[]> transportTransform;
  
  static
  {
    CRASHLYTICS_ENDPOINT = mergeStrings("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
  }
  
  DataTransportCrashlyticsReportSender(e<CrashlyticsReport> parame, d<CrashlyticsReport, byte[]> paramd)
  {
    this.transport = parame;
    this.transportTransform = paramd;
  }
  
  public static DataTransportCrashlyticsReportSender create(Context paramContext)
  {
    r.f(paramContext);
    f localf = r.c().g(new com.google.android.datatransport.cct.c(CRASHLYTICS_ENDPOINT, CRASHLYTICS_API_KEY));
    com.google.android.datatransport.b localb = com.google.android.datatransport.b.b("json");
    paramContext = DEFAULT_TRANSFORM;
    return new DataTransportCrashlyticsReportSender(localf.b("FIREBASE_CRASHLYTICS_REPORT", CrashlyticsReport.class, localb, paramContext), paramContext);
  }
  
  private static String mergeStrings(String paramString1, String paramString2)
  {
    int i = paramString1.length() - paramString2.length();
    if ((i >= 0) && (i <= 1))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString1.length() + paramString2.length());
      for (i = 0; i < paramString1.length(); i++)
      {
        localStringBuilder.append(paramString1.charAt(i));
        if (paramString2.length() > i) {
          localStringBuilder.append(paramString2.charAt(i));
        }
      }
      return localStringBuilder.toString();
    }
    throw new IllegalArgumentException("Invalid input received");
  }
  
  @NonNull
  public Task<CrashlyticsReportWithSessionId> sendReport(@NonNull CrashlyticsReportWithSessionId paramCrashlyticsReportWithSessionId)
  {
    CrashlyticsReport localCrashlyticsReport = paramCrashlyticsReportWithSessionId.getReport();
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    this.transport.a(com.google.android.datatransport.c.f(localCrashlyticsReport), new b(localTaskCompletionSource, paramCrashlyticsReportWithSessionId));
    return localTaskCompletionSource.getTask();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\send\DataTransportCrashlyticsReportSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */