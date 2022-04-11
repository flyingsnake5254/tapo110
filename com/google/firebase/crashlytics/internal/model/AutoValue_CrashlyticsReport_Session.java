package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.annotations.Encodable.Ignore;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session
  extends CrashlyticsReport.Session
{
  private final CrashlyticsReport.Session.Application app;
  private final boolean crashed;
  private final CrashlyticsReport.Session.Device device;
  private final Long endedAt;
  private final ImmutableList<CrashlyticsReport.Session.Event> events;
  private final String generator;
  private final int generatorType;
  private final String identifier;
  private final CrashlyticsReport.Session.OperatingSystem os;
  private final long startedAt;
  private final CrashlyticsReport.Session.User user;
  
  private AutoValue_CrashlyticsReport_Session(String paramString1, String paramString2, long paramLong, @Nullable Long paramLong1, boolean paramBoolean, CrashlyticsReport.Session.Application paramApplication, @Nullable CrashlyticsReport.Session.User paramUser, @Nullable CrashlyticsReport.Session.OperatingSystem paramOperatingSystem, @Nullable CrashlyticsReport.Session.Device paramDevice, @Nullable ImmutableList<CrashlyticsReport.Session.Event> paramImmutableList, int paramInt)
  {
    this.generator = paramString1;
    this.identifier = paramString2;
    this.startedAt = paramLong;
    this.endedAt = paramLong1;
    this.crashed = paramBoolean;
    this.app = paramApplication;
    this.user = paramUser;
    this.os = paramOperatingSystem;
    this.device = paramDevice;
    this.events = paramImmutableList;
    this.generatorType = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session))
    {
      paramObject = (CrashlyticsReport.Session)paramObject;
      if ((this.generator.equals(((CrashlyticsReport.Session)paramObject).getGenerator())) && (this.identifier.equals(((CrashlyticsReport.Session)paramObject).getIdentifier())) && (this.startedAt == ((CrashlyticsReport.Session)paramObject).getStartedAt()))
      {
        Object localObject = this.endedAt;
        if ((localObject == null ? ((CrashlyticsReport.Session)paramObject).getEndedAt() == null : ((Long)localObject).equals(((CrashlyticsReport.Session)paramObject).getEndedAt())) && (this.crashed == ((CrashlyticsReport.Session)paramObject).isCrashed()) && (this.app.equals(((CrashlyticsReport.Session)paramObject).getApp())))
        {
          localObject = this.user;
          if (localObject == null ? ((CrashlyticsReport.Session)paramObject).getUser() == null : localObject.equals(((CrashlyticsReport.Session)paramObject).getUser()))
          {
            localObject = this.os;
            if (localObject == null ? ((CrashlyticsReport.Session)paramObject).getOs() == null : localObject.equals(((CrashlyticsReport.Session)paramObject).getOs()))
            {
              localObject = this.device;
              if (localObject == null ? ((CrashlyticsReport.Session)paramObject).getDevice() == null : localObject.equals(((CrashlyticsReport.Session)paramObject).getDevice()))
              {
                localObject = this.events;
                if ((localObject == null ? ((CrashlyticsReport.Session)paramObject).getEvents() == null : ((ImmutableList)localObject).equals(((CrashlyticsReport.Session)paramObject).getEvents())) && (this.generatorType == ((CrashlyticsReport.Session)paramObject).getGeneratorType())) {
                  break label252;
                }
              }
            }
          }
        }
      }
      bool = false;
      label252:
      return bool;
    }
    return false;
  }
  
  @NonNull
  public CrashlyticsReport.Session.Application getApp()
  {
    return this.app;
  }
  
  @Nullable
  public CrashlyticsReport.Session.Device getDevice()
  {
    return this.device;
  }
  
  @Nullable
  public Long getEndedAt()
  {
    return this.endedAt;
  }
  
  @Nullable
  public ImmutableList<CrashlyticsReport.Session.Event> getEvents()
  {
    return this.events;
  }
  
  @NonNull
  public String getGenerator()
  {
    return this.generator;
  }
  
  public int getGeneratorType()
  {
    return this.generatorType;
  }
  
  @Encodable.Ignore
  @NonNull
  public String getIdentifier()
  {
    return this.identifier;
  }
  
  @Nullable
  public CrashlyticsReport.Session.OperatingSystem getOs()
  {
    return this.os;
  }
  
  public long getStartedAt()
  {
    return this.startedAt;
  }
  
  @Nullable
  public CrashlyticsReport.Session.User getUser()
  {
    return this.user;
  }
  
  public int hashCode()
  {
    int i = this.generator.hashCode();
    int j = this.identifier.hashCode();
    long l = this.startedAt;
    int k = (int)(l ^ l >>> 32);
    Object localObject = this.endedAt;
    int m = 0;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = ((Long)localObject).hashCode();
    }
    int i1;
    if (this.crashed) {
      i1 = 1231;
    } else {
      i1 = 1237;
    }
    int i2 = this.app.hashCode();
    localObject = this.user;
    int i3;
    if (localObject == null) {
      i3 = 0;
    } else {
      i3 = localObject.hashCode();
    }
    localObject = this.os;
    int i4;
    if (localObject == null) {
      i4 = 0;
    } else {
      i4 = localObject.hashCode();
    }
    localObject = this.device;
    int i5;
    if (localObject == null) {
      i5 = 0;
    } else {
      i5 = localObject.hashCode();
    }
    localObject = this.events;
    if (localObject != null) {
      m = ((ImmutableList)localObject).hashCode();
    }
    return ((((((((((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ i2) * 1000003 ^ i3) * 1000003 ^ i4) * 1000003 ^ i5) * 1000003 ^ m) * 1000003 ^ this.generatorType;
  }
  
  public boolean isCrashed()
  {
    return this.crashed;
  }
  
  public CrashlyticsReport.Session.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Session{generator=");
    localStringBuilder.append(this.generator);
    localStringBuilder.append(", identifier=");
    localStringBuilder.append(this.identifier);
    localStringBuilder.append(", startedAt=");
    localStringBuilder.append(this.startedAt);
    localStringBuilder.append(", endedAt=");
    localStringBuilder.append(this.endedAt);
    localStringBuilder.append(", crashed=");
    localStringBuilder.append(this.crashed);
    localStringBuilder.append(", app=");
    localStringBuilder.append(this.app);
    localStringBuilder.append(", user=");
    localStringBuilder.append(this.user);
    localStringBuilder.append(", os=");
    localStringBuilder.append(this.os);
    localStringBuilder.append(", device=");
    localStringBuilder.append(this.device);
    localStringBuilder.append(", events=");
    localStringBuilder.append(this.events);
    localStringBuilder.append(", generatorType=");
    localStringBuilder.append(this.generatorType);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Builder
  {
    private CrashlyticsReport.Session.Application app;
    private Boolean crashed;
    private CrashlyticsReport.Session.Device device;
    private Long endedAt;
    private ImmutableList<CrashlyticsReport.Session.Event> events;
    private String generator;
    private Integer generatorType;
    private String identifier;
    private CrashlyticsReport.Session.OperatingSystem os;
    private Long startedAt;
    private CrashlyticsReport.Session.User user;
    
    Builder() {}
    
    private Builder(CrashlyticsReport.Session paramSession)
    {
      this.generator = paramSession.getGenerator();
      this.identifier = paramSession.getIdentifier();
      this.startedAt = Long.valueOf(paramSession.getStartedAt());
      this.endedAt = paramSession.getEndedAt();
      this.crashed = Boolean.valueOf(paramSession.isCrashed());
      this.app = paramSession.getApp();
      this.user = paramSession.getUser();
      this.os = paramSession.getOs();
      this.device = paramSession.getDevice();
      this.events = paramSession.getEvents();
      this.generatorType = Integer.valueOf(paramSession.getGeneratorType());
    }
    
    public CrashlyticsReport.Session build()
    {
      Object localObject1 = this.generator;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" generator");
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = localObject2;
      if (this.identifier == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" identifier");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.startedAt == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" startedAt");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      Object localObject3 = localObject2;
      if (this.crashed == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" crashed");
        localObject3 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = localObject3;
      if (this.app == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(" app");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.generatorType == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" generatorType");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session(this.generator, this.identifier, this.startedAt.longValue(), this.endedAt, this.crashed.booleanValue(), this.app, this.user, this.os, this.device, this.events, this.generatorType.intValue(), null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Session.Builder setApp(CrashlyticsReport.Session.Application paramApplication)
    {
      Objects.requireNonNull(paramApplication, "Null app");
      this.app = paramApplication;
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setCrashed(boolean paramBoolean)
    {
      this.crashed = Boolean.valueOf(paramBoolean);
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setDevice(CrashlyticsReport.Session.Device paramDevice)
    {
      this.device = paramDevice;
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setEndedAt(Long paramLong)
    {
      this.endedAt = paramLong;
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setEvents(ImmutableList<CrashlyticsReport.Session.Event> paramImmutableList)
    {
      this.events = paramImmutableList;
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setGenerator(String paramString)
    {
      Objects.requireNonNull(paramString, "Null generator");
      this.generator = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setGeneratorType(int paramInt)
    {
      this.generatorType = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setIdentifier(String paramString)
    {
      Objects.requireNonNull(paramString, "Null identifier");
      this.identifier = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setOs(CrashlyticsReport.Session.OperatingSystem paramOperatingSystem)
    {
      this.os = paramOperatingSystem;
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setStartedAt(long paramLong)
    {
      this.startedAt = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setUser(CrashlyticsReport.Session.User paramUser)
    {
      this.user = paramUser;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */