package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Application
  extends CrashlyticsReport.Session.Application
{
  private final String developmentPlatform;
  private final String developmentPlatformVersion;
  private final String displayVersion;
  private final String identifier;
  private final String installationUuid;
  private final CrashlyticsReport.Session.Application.Organization organization;
  private final String version;
  
  private AutoValue_CrashlyticsReport_Session_Application(String paramString1, String paramString2, @Nullable String paramString3, @Nullable CrashlyticsReport.Session.Application.Organization paramOrganization, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6)
  {
    this.identifier = paramString1;
    this.version = paramString2;
    this.displayVersion = paramString3;
    this.organization = paramOrganization;
    this.installationUuid = paramString4;
    this.developmentPlatform = paramString5;
    this.developmentPlatformVersion = paramString6;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Application))
    {
      paramObject = (CrashlyticsReport.Session.Application)paramObject;
      if ((this.identifier.equals(((CrashlyticsReport.Session.Application)paramObject).getIdentifier())) && (this.version.equals(((CrashlyticsReport.Session.Application)paramObject).getVersion())))
      {
        Object localObject = this.displayVersion;
        if (localObject == null ? ((CrashlyticsReport.Session.Application)paramObject).getDisplayVersion() == null : ((String)localObject).equals(((CrashlyticsReport.Session.Application)paramObject).getDisplayVersion()))
        {
          localObject = this.organization;
          if (localObject == null ? ((CrashlyticsReport.Session.Application)paramObject).getOrganization() == null : localObject.equals(((CrashlyticsReport.Session.Application)paramObject).getOrganization()))
          {
            localObject = this.installationUuid;
            if (localObject == null ? ((CrashlyticsReport.Session.Application)paramObject).getInstallationUuid() == null : ((String)localObject).equals(((CrashlyticsReport.Session.Application)paramObject).getInstallationUuid()))
            {
              localObject = this.developmentPlatform;
              if (localObject == null ? ((CrashlyticsReport.Session.Application)paramObject).getDevelopmentPlatform() == null : ((String)localObject).equals(((CrashlyticsReport.Session.Application)paramObject).getDevelopmentPlatform()))
              {
                localObject = this.developmentPlatformVersion;
                if (localObject == null ? ((CrashlyticsReport.Session.Application)paramObject).getDevelopmentPlatformVersion() == null : ((String)localObject).equals(((CrashlyticsReport.Session.Application)paramObject).getDevelopmentPlatformVersion())) {
                  break label204;
                }
              }
            }
          }
        }
      }
      bool = false;
      label204:
      return bool;
    }
    return false;
  }
  
  @Nullable
  public String getDevelopmentPlatform()
  {
    return this.developmentPlatform;
  }
  
  @Nullable
  public String getDevelopmentPlatformVersion()
  {
    return this.developmentPlatformVersion;
  }
  
  @Nullable
  public String getDisplayVersion()
  {
    return this.displayVersion;
  }
  
  @NonNull
  public String getIdentifier()
  {
    return this.identifier;
  }
  
  @Nullable
  public String getInstallationUuid()
  {
    return this.installationUuid;
  }
  
  @Nullable
  public CrashlyticsReport.Session.Application.Organization getOrganization()
  {
    return this.organization;
  }
  
  @NonNull
  public String getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    int i = this.identifier.hashCode();
    int j = this.version.hashCode();
    Object localObject = this.displayVersion;
    int k = 0;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((String)localObject).hashCode();
    }
    localObject = this.organization;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = localObject.hashCode();
    }
    localObject = this.installationUuid;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((String)localObject).hashCode();
    }
    localObject = this.developmentPlatform;
    int i2;
    if (localObject == null) {
      i2 = 0;
    } else {
      i2 = ((String)localObject).hashCode();
    }
    localObject = this.developmentPlatformVersion;
    if (localObject != null) {
      k = ((String)localObject).hashCode();
    }
    return ((((((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ i2) * 1000003 ^ k;
  }
  
  protected CrashlyticsReport.Session.Application.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Application{identifier=");
    localStringBuilder.append(this.identifier);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", displayVersion=");
    localStringBuilder.append(this.displayVersion);
    localStringBuilder.append(", organization=");
    localStringBuilder.append(this.organization);
    localStringBuilder.append(", installationUuid=");
    localStringBuilder.append(this.installationUuid);
    localStringBuilder.append(", developmentPlatform=");
    localStringBuilder.append(this.developmentPlatform);
    localStringBuilder.append(", developmentPlatformVersion=");
    localStringBuilder.append(this.developmentPlatformVersion);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Application.Builder
  {
    private String developmentPlatform;
    private String developmentPlatformVersion;
    private String displayVersion;
    private String identifier;
    private String installationUuid;
    private CrashlyticsReport.Session.Application.Organization organization;
    private String version;
    
    Builder() {}
    
    private Builder(CrashlyticsReport.Session.Application paramApplication)
    {
      this.identifier = paramApplication.getIdentifier();
      this.version = paramApplication.getVersion();
      this.displayVersion = paramApplication.getDisplayVersion();
      this.organization = paramApplication.getOrganization();
      this.installationUuid = paramApplication.getInstallationUuid();
      this.developmentPlatform = paramApplication.getDevelopmentPlatform();
      this.developmentPlatformVersion = paramApplication.getDevelopmentPlatformVersion();
    }
    
    public CrashlyticsReport.Session.Application build()
    {
      Object localObject1 = this.identifier;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" identifier");
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
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Application(this.identifier, this.version, this.displayVersion, this.organization, this.installationUuid, this.developmentPlatform, this.developmentPlatformVersion, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.Application.Builder setDevelopmentPlatform(@Nullable String paramString)
    {
      this.developmentPlatform = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Application.Builder setDevelopmentPlatformVersion(@Nullable String paramString)
    {
      this.developmentPlatformVersion = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Application.Builder setDisplayVersion(String paramString)
    {
      this.displayVersion = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Application.Builder setIdentifier(String paramString)
    {
      Objects.requireNonNull(paramString, "Null identifier");
      this.identifier = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Application.Builder setInstallationUuid(String paramString)
    {
      this.installationUuid = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Application.Builder setOrganization(CrashlyticsReport.Session.Application.Organization paramOrganization)
    {
      this.organization = paramOrganization;
      return this;
    }
    
    public CrashlyticsReport.Session.Application.Builder setVersion(String paramString)
    {
      Objects.requireNonNull(paramString, "Null version");
      this.version = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Application.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */