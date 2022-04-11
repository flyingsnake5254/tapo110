package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.annotations.Encodable.Ignore;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage
  extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
{
  private final long baseAddress;
  private final String name;
  private final long size;
  private final String uuid;
  
  private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long paramLong1, long paramLong2, String paramString1, @Nullable String paramString2)
  {
    this.baseAddress = paramLong1;
    this.size = paramLong2;
    this.name = paramString1;
    this.uuid = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Application.Execution.BinaryImage))
    {
      paramObject = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)paramObject;
      if ((this.baseAddress == ((CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)paramObject).getBaseAddress()) && (this.size == ((CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)paramObject).getSize()) && (this.name.equals(((CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)paramObject).getName())))
      {
        String str = this.uuid;
        if (str == null ? ((CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)paramObject).getUuid() == null : str.equals(((CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)paramObject).getUuid())) {}
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
  public long getBaseAddress()
  {
    return this.baseAddress;
  }
  
  @NonNull
  public String getName()
  {
    return this.name;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  @Encodable.Ignore
  @Nullable
  public String getUuid()
  {
    return this.uuid;
  }
  
  public int hashCode()
  {
    long l = this.baseAddress;
    int i = (int)(l ^ l >>> 32);
    l = this.size;
    int j = (int)(l >>> 32 ^ l);
    int k = this.name.hashCode();
    String str = this.uuid;
    int m;
    if (str == null) {
      m = 0;
    } else {
      m = str.hashCode();
    }
    return m ^ (((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BinaryImage{baseAddress=");
    localStringBuilder.append(this.baseAddress);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", uuid=");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
  {
    private Long baseAddress;
    private String name;
    private Long size;
    private String uuid;
    
    public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage build()
    {
      Object localObject1 = this.baseAddress;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" baseAddress");
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = localObject2;
      if (this.size == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" size");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.name == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" name");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(this.baseAddress.longValue(), this.size.longValue(), this.name, this.uuid, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setBaseAddress(long paramLong)
    {
      this.baseAddress = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setName(String paramString)
    {
      Objects.requireNonNull(paramString, "Null name");
      this.name = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setSize(long paramLong)
    {
      this.size = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setUuid(@Nullable String paramString)
    {
      this.uuid = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */