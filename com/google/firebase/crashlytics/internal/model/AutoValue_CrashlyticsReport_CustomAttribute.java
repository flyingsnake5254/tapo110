package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_CustomAttribute
  extends CrashlyticsReport.CustomAttribute
{
  private final String key;
  private final String value;
  
  private AutoValue_CrashlyticsReport_CustomAttribute(String paramString1, String paramString2)
  {
    this.key = paramString1;
    this.value = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.CustomAttribute))
    {
      paramObject = (CrashlyticsReport.CustomAttribute)paramObject;
      if ((!this.key.equals(((CrashlyticsReport.CustomAttribute)paramObject).getKey())) || (!this.value.equals(((CrashlyticsReport.CustomAttribute)paramObject).getValue()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @NonNull
  public String getKey()
  {
    return this.key;
  }
  
  @NonNull
  public String getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return (this.key.hashCode() ^ 0xF4243) * 1000003 ^ this.value.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CustomAttribute{key=");
    localStringBuilder.append(this.key);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.CustomAttribute.Builder
  {
    private String key;
    private String value;
    
    public CrashlyticsReport.CustomAttribute build()
    {
      Object localObject1 = this.key;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" key");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.value == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" value");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_CustomAttribute(this.key, this.value, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.CustomAttribute.Builder setKey(String paramString)
    {
      Objects.requireNonNull(paramString, "Null key");
      this.key = paramString;
      return this;
    }
    
    public CrashlyticsReport.CustomAttribute.Builder setValue(String paramString)
    {
      Objects.requireNonNull(paramString, "Null value");
      this.value = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_CustomAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */