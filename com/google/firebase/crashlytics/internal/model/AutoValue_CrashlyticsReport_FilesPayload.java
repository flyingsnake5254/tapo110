package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_FilesPayload
  extends CrashlyticsReport.FilesPayload
{
  private final ImmutableList<CrashlyticsReport.FilesPayload.File> files;
  private final String orgId;
  
  private AutoValue_CrashlyticsReport_FilesPayload(ImmutableList<CrashlyticsReport.FilesPayload.File> paramImmutableList, @Nullable String paramString)
  {
    this.files = paramImmutableList;
    this.orgId = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.FilesPayload))
    {
      paramObject = (CrashlyticsReport.FilesPayload)paramObject;
      if (this.files.equals(((CrashlyticsReport.FilesPayload)paramObject).getFiles()))
      {
        String str = this.orgId;
        if (str == null ? ((CrashlyticsReport.FilesPayload)paramObject).getOrgId() == null : str.equals(((CrashlyticsReport.FilesPayload)paramObject).getOrgId())) {}
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
  public ImmutableList<CrashlyticsReport.FilesPayload.File> getFiles()
  {
    return this.files;
  }
  
  @Nullable
  public String getOrgId()
  {
    return this.orgId;
  }
  
  public int hashCode()
  {
    int i = this.files.hashCode();
    String str = this.orgId;
    int j;
    if (str == null) {
      j = 0;
    } else {
      j = str.hashCode();
    }
    return (i ^ 0xF4243) * 1000003 ^ j;
  }
  
  CrashlyticsReport.FilesPayload.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilesPayload{files=");
    localStringBuilder.append(this.files);
    localStringBuilder.append(", orgId=");
    localStringBuilder.append(this.orgId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.FilesPayload.Builder
  {
    private ImmutableList<CrashlyticsReport.FilesPayload.File> files;
    private String orgId;
    
    Builder() {}
    
    private Builder(CrashlyticsReport.FilesPayload paramFilesPayload)
    {
      this.files = paramFilesPayload.getFiles();
      this.orgId = paramFilesPayload.getOrgId();
    }
    
    public CrashlyticsReport.FilesPayload build()
    {
      Object localObject1 = this.files;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" files");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_FilesPayload(this.files, this.orgId, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.FilesPayload.Builder setFiles(ImmutableList<CrashlyticsReport.FilesPayload.File> paramImmutableList)
    {
      Objects.requireNonNull(paramImmutableList, "Null files");
      this.files = paramImmutableList;
      return this;
    }
    
    public CrashlyticsReport.FilesPayload.Builder setOrgId(String paramString)
    {
      this.orgId = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_FilesPayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */