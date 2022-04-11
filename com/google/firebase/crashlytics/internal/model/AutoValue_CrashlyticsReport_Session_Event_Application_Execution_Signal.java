package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal
  extends CrashlyticsReport.Session.Event.Application.Execution.Signal
{
  private final long address;
  private final String code;
  private final String name;
  
  private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(String paramString1, String paramString2, long paramLong)
  {
    this.name = paramString1;
    this.code = paramString2;
    this.address = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Application.Execution.Signal))
    {
      paramObject = (CrashlyticsReport.Session.Event.Application.Execution.Signal)paramObject;
      if ((!this.name.equals(((CrashlyticsReport.Session.Event.Application.Execution.Signal)paramObject).getName())) || (!this.code.equals(((CrashlyticsReport.Session.Event.Application.Execution.Signal)paramObject).getCode())) || (this.address != ((CrashlyticsReport.Session.Event.Application.Execution.Signal)paramObject).getAddress())) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @NonNull
  public long getAddress()
  {
    return this.address;
  }
  
  @NonNull
  public String getCode()
  {
    return this.code;
  }
  
  @NonNull
  public String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    int i = this.name.hashCode();
    int j = this.code.hashCode();
    long l = this.address;
    return ((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Signal{name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", code=");
    localStringBuilder.append(this.code);
    localStringBuilder.append(", address=");
    localStringBuilder.append(this.address);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
  {
    private Long address;
    private String code;
    private String name;
    
    public CrashlyticsReport.Session.Event.Application.Execution.Signal build()
    {
      Object localObject1 = this.name;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" name");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.code == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" code");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.address == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" address");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(this.name, this.code, this.address.longValue(), null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setAddress(long paramLong)
    {
      this.address = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setCode(String paramString)
    {
      Objects.requireNonNull(paramString, "Null code");
      this.code = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setName(String paramString)
    {
      Objects.requireNonNull(paramString, "Null name");
      this.name = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */