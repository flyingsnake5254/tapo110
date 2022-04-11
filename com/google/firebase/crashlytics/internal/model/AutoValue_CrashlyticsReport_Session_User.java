package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_User
  extends CrashlyticsReport.Session.User
{
  private final String identifier;
  
  private AutoValue_CrashlyticsReport_Session_User(String paramString)
  {
    this.identifier = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.User))
    {
      paramObject = (CrashlyticsReport.Session.User)paramObject;
      return this.identifier.equals(((CrashlyticsReport.Session.User)paramObject).getIdentifier());
    }
    return false;
  }
  
  @NonNull
  public String getIdentifier()
  {
    return this.identifier;
  }
  
  public int hashCode()
  {
    return this.identifier.hashCode() ^ 0xF4243;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("User{identifier=");
    localStringBuilder.append(this.identifier);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.User.Builder
  {
    private String identifier;
    
    public CrashlyticsReport.Session.User build()
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
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_User(this.identifier, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Session.User.Builder setIdentifier(String paramString)
    {
      Objects.requireNonNull(paramString, "Null identifier");
      this.identifier = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */