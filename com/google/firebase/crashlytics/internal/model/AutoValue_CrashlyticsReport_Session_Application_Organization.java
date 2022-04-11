package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Application_Organization
  extends CrashlyticsReport.Session.Application.Organization
{
  private final String clsId;
  
  private AutoValue_CrashlyticsReport_Session_Application_Organization(String paramString)
  {
    this.clsId = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Application.Organization))
    {
      paramObject = (CrashlyticsReport.Session.Application.Organization)paramObject;
      return this.clsId.equals(((CrashlyticsReport.Session.Application.Organization)paramObject).getClsId());
    }
    return false;
  }
  
  @NonNull
  public String getClsId()
  {
    return this.clsId;
  }
  
  public int hashCode()
  {
    return this.clsId.hashCode() ^ 0xF4243;
  }
  
  protected CrashlyticsReport.Session.Application.Organization.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Organization{clsId=");
    localStringBuilder.append(this.clsId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Application.Organization.Builder
  {
    private String clsId;
    
    Builder() {}
    
    private Builder(CrashlyticsReport.Session.Application.Organization paramOrganization)
    {
      this.clsId = paramOrganization.getClsId();
    }
    
    public CrashlyticsReport.Session.Application.Organization build()
    {
      Object localObject1 = this.clsId;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" clsId");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Application_Organization(this.clsId, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Session.Application.Organization.Builder setClsId(String paramString)
    {
      Objects.requireNonNull(paramString, "Null clsId");
      this.clsId = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Application_Organization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */