package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Event
  extends CrashlyticsReport.Session.Event
{
  private final CrashlyticsReport.Session.Event.Application app;
  private final CrashlyticsReport.Session.Event.Device device;
  private final CrashlyticsReport.Session.Event.Log log;
  private final long timestamp;
  private final String type;
  
  private AutoValue_CrashlyticsReport_Session_Event(long paramLong, String paramString, CrashlyticsReport.Session.Event.Application paramApplication, CrashlyticsReport.Session.Event.Device paramDevice, @Nullable CrashlyticsReport.Session.Event.Log paramLog)
  {
    this.timestamp = paramLong;
    this.type = paramString;
    this.app = paramApplication;
    this.device = paramDevice;
    this.log = paramLog;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event))
    {
      CrashlyticsReport.Session.Event localEvent = (CrashlyticsReport.Session.Event)paramObject;
      if ((this.timestamp == localEvent.getTimestamp()) && (this.type.equals(localEvent.getType())) && (this.app.equals(localEvent.getApp())) && (this.device.equals(localEvent.getDevice())))
      {
        paramObject = this.log;
        if (paramObject == null ? localEvent.getLog() == null : paramObject.equals(localEvent.getLog())) {}
      }
      else
      {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @NonNull
  public CrashlyticsReport.Session.Event.Application getApp()
  {
    return this.app;
  }
  
  @NonNull
  public CrashlyticsReport.Session.Event.Device getDevice()
  {
    return this.device;
  }
  
  @Nullable
  public CrashlyticsReport.Session.Event.Log getLog()
  {
    return this.log;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  @NonNull
  public String getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    long l = this.timestamp;
    int i = (int)(l ^ l >>> 32);
    int j = this.type.hashCode();
    int k = this.app.hashCode();
    int m = this.device.hashCode();
    CrashlyticsReport.Session.Event.Log localLog = this.log;
    int n;
    if (localLog == null) {
      n = 0;
    } else {
      n = localLog.hashCode();
    }
    return n ^ ((((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m) * 1000003;
  }
  
  public CrashlyticsReport.Session.Event.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Event{timestamp=");
    localStringBuilder.append(this.timestamp);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", app=");
    localStringBuilder.append(this.app);
    localStringBuilder.append(", device=");
    localStringBuilder.append(this.device);
    localStringBuilder.append(", log=");
    localStringBuilder.append(this.log);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Builder
  {
    private CrashlyticsReport.Session.Event.Application app;
    private CrashlyticsReport.Session.Event.Device device;
    private CrashlyticsReport.Session.Event.Log log;
    private Long timestamp;
    private String type;
    
    Builder() {}
    
    private Builder(CrashlyticsReport.Session.Event paramEvent)
    {
      this.timestamp = Long.valueOf(paramEvent.getTimestamp());
      this.type = paramEvent.getType();
      this.app = paramEvent.getApp();
      this.device = paramEvent.getDevice();
      this.log = paramEvent.getLog();
    }
    
    public CrashlyticsReport.Session.Event build()
    {
      Object localObject1 = this.timestamp;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" timestamp");
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = localObject2;
      if (this.type == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" type");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.app == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" app");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.device == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" device");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event(this.timestamp.longValue(), this.type, this.app, this.device, this.log, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.Event.Builder setApp(CrashlyticsReport.Session.Event.Application paramApplication)
    {
      Objects.requireNonNull(paramApplication, "Null app");
      this.app = paramApplication;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Builder setDevice(CrashlyticsReport.Session.Event.Device paramDevice)
    {
      Objects.requireNonNull(paramDevice, "Null device");
      this.device = paramDevice;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Builder setLog(CrashlyticsReport.Session.Event.Log paramLog)
    {
      this.log = paramLog;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Builder setTimestamp(long paramLong)
    {
      this.timestamp = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Builder setType(String paramString)
    {
      Objects.requireNonNull(paramString, "Null type");
      this.type = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */