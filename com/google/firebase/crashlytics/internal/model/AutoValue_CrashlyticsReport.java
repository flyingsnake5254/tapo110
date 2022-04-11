package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

final class AutoValue_CrashlyticsReport
  extends CrashlyticsReport
{
  private final String buildVersion;
  private final String displayVersion;
  private final String gmpAppId;
  private final String installationUuid;
  private final CrashlyticsReport.FilesPayload ndkPayload;
  private final int platform;
  private final String sdkVersion;
  private final CrashlyticsReport.Session session;
  
  private AutoValue_CrashlyticsReport(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, @Nullable CrashlyticsReport.Session paramSession, @Nullable CrashlyticsReport.FilesPayload paramFilesPayload)
  {
    this.sdkVersion = paramString1;
    this.gmpAppId = paramString2;
    this.platform = paramInt;
    this.installationUuid = paramString3;
    this.buildVersion = paramString4;
    this.displayVersion = paramString5;
    this.session = paramSession;
    this.ndkPayload = paramFilesPayload;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport))
    {
      paramObject = (CrashlyticsReport)paramObject;
      if ((this.sdkVersion.equals(((CrashlyticsReport)paramObject).getSdkVersion())) && (this.gmpAppId.equals(((CrashlyticsReport)paramObject).getGmpAppId())) && (this.platform == ((CrashlyticsReport)paramObject).getPlatform()) && (this.installationUuid.equals(((CrashlyticsReport)paramObject).getInstallationUuid())) && (this.buildVersion.equals(((CrashlyticsReport)paramObject).getBuildVersion())) && (this.displayVersion.equals(((CrashlyticsReport)paramObject).getDisplayVersion())))
      {
        Object localObject = this.session;
        if (localObject == null ? ((CrashlyticsReport)paramObject).getSession() == null : localObject.equals(((CrashlyticsReport)paramObject).getSession()))
        {
          localObject = this.ndkPayload;
          if (localObject == null ? ((CrashlyticsReport)paramObject).getNdkPayload() == null : localObject.equals(((CrashlyticsReport)paramObject).getNdkPayload())) {
            break label167;
          }
        }
      }
      bool = false;
      label167:
      return bool;
    }
    return false;
  }
  
  @NonNull
  public String getBuildVersion()
  {
    return this.buildVersion;
  }
  
  @NonNull
  public String getDisplayVersion()
  {
    return this.displayVersion;
  }
  
  @NonNull
  public String getGmpAppId()
  {
    return this.gmpAppId;
  }
  
  @NonNull
  public String getInstallationUuid()
  {
    return this.installationUuid;
  }
  
  @Nullable
  public CrashlyticsReport.FilesPayload getNdkPayload()
  {
    return this.ndkPayload;
  }
  
  public int getPlatform()
  {
    return this.platform;
  }
  
  @NonNull
  public String getSdkVersion()
  {
    return this.sdkVersion;
  }
  
  @Nullable
  public CrashlyticsReport.Session getSession()
  {
    return this.session;
  }
  
  public int hashCode()
  {
    int i = this.sdkVersion.hashCode();
    int j = this.gmpAppId.hashCode();
    int k = this.platform;
    int m = this.installationUuid.hashCode();
    int n = this.buildVersion.hashCode();
    int i1 = this.displayVersion.hashCode();
    Object localObject = this.session;
    int i2 = 0;
    int i3;
    if (localObject == null) {
      i3 = 0;
    } else {
      i3 = localObject.hashCode();
    }
    localObject = this.ndkPayload;
    if (localObject != null) {
      i2 = localObject.hashCode();
    }
    return (((((((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ i3) * 1000003 ^ i2;
  }
  
  protected CrashlyticsReport.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CrashlyticsReport{sdkVersion=");
    localStringBuilder.append(this.sdkVersion);
    localStringBuilder.append(", gmpAppId=");
    localStringBuilder.append(this.gmpAppId);
    localStringBuilder.append(", platform=");
    localStringBuilder.append(this.platform);
    localStringBuilder.append(", installationUuid=");
    localStringBuilder.append(this.installationUuid);
    localStringBuilder.append(", buildVersion=");
    localStringBuilder.append(this.buildVersion);
    localStringBuilder.append(", displayVersion=");
    localStringBuilder.append(this.displayVersion);
    localStringBuilder.append(", session=");
    localStringBuilder.append(this.session);
    localStringBuilder.append(", ndkPayload=");
    localStringBuilder.append(this.ndkPayload);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Builder
  {
    private String buildVersion;
    private String displayVersion;
    private String gmpAppId;
    private String installationUuid;
    private CrashlyticsReport.FilesPayload ndkPayload;
    private Integer platform;
    private String sdkVersion;
    private CrashlyticsReport.Session session;
    
    Builder() {}
    
    private Builder(CrashlyticsReport paramCrashlyticsReport)
    {
      this.sdkVersion = paramCrashlyticsReport.getSdkVersion();
      this.gmpAppId = paramCrashlyticsReport.getGmpAppId();
      this.platform = Integer.valueOf(paramCrashlyticsReport.getPlatform());
      this.installationUuid = paramCrashlyticsReport.getInstallationUuid();
      this.buildVersion = paramCrashlyticsReport.getBuildVersion();
      this.displayVersion = paramCrashlyticsReport.getDisplayVersion();
      this.session = paramCrashlyticsReport.getSession();
      this.ndkPayload = paramCrashlyticsReport.getNdkPayload();
    }
    
    public CrashlyticsReport build()
    {
      Object localObject1 = this.sdkVersion;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" sdkVersion");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.gmpAppId == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" gmpAppId");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.platform == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" platform");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.installationUuid == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" installationUuid");
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
      if (this.displayVersion == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" displayVersion");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport(this.sdkVersion, this.gmpAppId, this.platform.intValue(), this.installationUuid, this.buildVersion, this.displayVersion, this.session, this.ndkPayload, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Builder setBuildVersion(String paramString)
    {
      Objects.requireNonNull(paramString, "Null buildVersion");
      this.buildVersion = paramString;
      return this;
    }
    
    public CrashlyticsReport.Builder setDisplayVersion(String paramString)
    {
      Objects.requireNonNull(paramString, "Null displayVersion");
      this.displayVersion = paramString;
      return this;
    }
    
    public CrashlyticsReport.Builder setGmpAppId(String paramString)
    {
      Objects.requireNonNull(paramString, "Null gmpAppId");
      this.gmpAppId = paramString;
      return this;
    }
    
    public CrashlyticsReport.Builder setInstallationUuid(String paramString)
    {
      Objects.requireNonNull(paramString, "Null installationUuid");
      this.installationUuid = paramString;
      return this;
    }
    
    public CrashlyticsReport.Builder setNdkPayload(CrashlyticsReport.FilesPayload paramFilesPayload)
    {
      this.ndkPayload = paramFilesPayload;
      return this;
    }
    
    public CrashlyticsReport.Builder setPlatform(int paramInt)
    {
      this.platform = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Builder setSdkVersion(String paramString)
    {
      Objects.requireNonNull(paramString, "Null sdkVersion");
      this.sdkVersion = paramString;
      return this;
    }
    
    public CrashlyticsReport.Builder setSession(CrashlyticsReport.Session paramSession)
    {
      this.session = paramSession;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */