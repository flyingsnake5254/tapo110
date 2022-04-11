package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

@AutoValue
public abstract class CrashlyticsReportWithSessionId
{
  @NonNull
  public static CrashlyticsReportWithSessionId create(CrashlyticsReport paramCrashlyticsReport, String paramString)
  {
    return new AutoValue_CrashlyticsReportWithSessionId(paramCrashlyticsReport, paramString);
  }
  
  public abstract CrashlyticsReport getReport();
  
  public abstract String getSessionId();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\CrashlyticsReportWithSessionId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */