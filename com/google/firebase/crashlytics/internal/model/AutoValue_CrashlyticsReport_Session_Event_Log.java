package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Event_Log
  extends CrashlyticsReport.Session.Event.Log
{
  private final String content;
  
  private AutoValue_CrashlyticsReport_Session_Event_Log(String paramString)
  {
    this.content = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Log))
    {
      paramObject = (CrashlyticsReport.Session.Event.Log)paramObject;
      return this.content.equals(((CrashlyticsReport.Session.Event.Log)paramObject).getContent());
    }
    return false;
  }
  
  @NonNull
  public String getContent()
  {
    return this.content;
  }
  
  public int hashCode()
  {
    return this.content.hashCode() ^ 0xF4243;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Log{content=");
    localStringBuilder.append(this.content);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Log.Builder
  {
    private String content;
    
    public CrashlyticsReport.Session.Event.Log build()
    {
      Object localObject1 = this.content;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" content");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Log(this.content, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Session.Event.Log.Builder setContent(String paramString)
    {
      Objects.requireNonNull(paramString, "Null content");
      this.content = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */