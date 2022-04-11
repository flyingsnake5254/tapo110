package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;

final class AutoValue_CrashlyticsReportWithSessionId
  extends CrashlyticsReportWithSessionId
{
  private final CrashlyticsReport report;
  private final String sessionId;
  
  AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReport paramCrashlyticsReport, String paramString)
  {
    Objects.requireNonNull(paramCrashlyticsReport, "Null report");
    this.report = paramCrashlyticsReport;
    Objects.requireNonNull(paramString, "Null sessionId");
    this.sessionId = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReportWithSessionId))
    {
      paramObject = (CrashlyticsReportWithSessionId)paramObject;
      if ((!this.report.equals(((CrashlyticsReportWithSessionId)paramObject).getReport())) || (!this.sessionId.equals(((CrashlyticsReportWithSessionId)paramObject).getSessionId()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public CrashlyticsReport getReport()
  {
    return this.report;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public int hashCode()
  {
    return (this.report.hashCode() ^ 0xF4243) * 1000003 ^ this.sessionId.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CrashlyticsReportWithSessionId{report=");
    localStringBuilder.append(this.report);
    localStringBuilder.append(", sessionId=");
    localStringBuilder.append(this.sessionId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\AutoValue_CrashlyticsReportWithSessionId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */