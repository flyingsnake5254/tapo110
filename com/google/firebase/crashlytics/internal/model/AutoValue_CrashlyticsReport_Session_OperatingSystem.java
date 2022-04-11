package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_OperatingSystem
  extends CrashlyticsReport.Session.OperatingSystem
{
  private final String buildVersion;
  private final boolean jailbroken;
  private final int platform;
  private final String version;
  
  private AutoValue_CrashlyticsReport_Session_OperatingSystem(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.platform = paramInt;
    this.version = paramString1;
    this.buildVersion = paramString2;
    this.jailbroken = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.OperatingSystem))
    {
      paramObject = (CrashlyticsReport.Session.OperatingSystem)paramObject;
      if ((this.platform != ((CrashlyticsReport.Session.OperatingSystem)paramObject).getPlatform()) || (!this.version.equals(((CrashlyticsReport.Session.OperatingSystem)paramObject).getVersion())) || (!this.buildVersion.equals(((CrashlyticsReport.Session.OperatingSystem)paramObject).getBuildVersion())) || (this.jailbroken != ((CrashlyticsReport.Session.OperatingSystem)paramObject).isJailbroken())) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @NonNull
  public String getBuildVersion()
  {
    return this.buildVersion;
  }
  
  public int getPlatform()
  {
    return this.platform;
  }
  
  @NonNull
  public String getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    int i = this.platform;
    int j = this.version.hashCode();
    int k = this.buildVersion.hashCode();
    int m;
    if (this.jailbroken) {
      m = 1231;
    } else {
      m = 1237;
    }
    return (((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m;
  }
  
  public boolean isJailbroken()
  {
    return this.jailbroken;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OperatingSystem{platform=");
    localStringBuilder.append(this.platform);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", buildVersion=");
    localStringBuilder.append(this.buildVersion);
    localStringBuilder.append(", jailbroken=");
    localStringBuilder.append(this.jailbroken);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.OperatingSystem.Builder
  {
    private String buildVersion;
    private Boolean jailbroken;
    private Integer platform;
    private String version;
    
    public CrashlyticsReport.Session.OperatingSystem build()
    {
      Object localObject1 = this.platform;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" platform");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.version == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" version");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.buildVersion == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" buildVersion");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.jailbroken == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" jailbroken");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_OperatingSystem(this.platform.intValue(), this.version, this.buildVersion, this.jailbroken.booleanValue(), null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.OperatingSystem.Builder setBuildVersion(String paramString)
    {
      Objects.requireNonNull(paramString, "Null buildVersion");
      this.buildVersion = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.OperatingSystem.Builder setJailbroken(boolean paramBoolean)
    {
      this.jailbroken = Boolean.valueOf(paramBoolean);
      return this;
    }
    
    public CrashlyticsReport.Session.OperatingSystem.Builder setPlatform(int paramInt)
    {
      this.platform = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.OperatingSystem.Builder setVersion(String paramString)
    {
      Objects.requireNonNull(paramString, "Null version");
      this.version = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_OperatingSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */