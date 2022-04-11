package com.google.firebase.heartbeatinfo;

import java.util.Objects;

final class AutoValue_SdkHeartBeatResult
  extends SdkHeartBeatResult
{
  private final long millis;
  private final String sdkName;
  
  AutoValue_SdkHeartBeatResult(String paramString, long paramLong)
  {
    Objects.requireNonNull(paramString, "Null sdkName");
    this.sdkName = paramString;
    this.millis = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof SdkHeartBeatResult))
    {
      paramObject = (SdkHeartBeatResult)paramObject;
      if ((!this.sdkName.equals(((SdkHeartBeatResult)paramObject).getSdkName())) || (this.millis != ((SdkHeartBeatResult)paramObject).getMillis())) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public long getMillis()
  {
    return this.millis;
  }
  
  public String getSdkName()
  {
    return this.sdkName;
  }
  
  public int hashCode()
  {
    int i = this.sdkName.hashCode();
    long l = this.millis;
    return (i ^ 0xF4243) * 1000003 ^ (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SdkHeartBeatResult{sdkName=");
    localStringBuilder.append(this.sdkName);
    localStringBuilder.append(", millis=");
    localStringBuilder.append(this.millis);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\heartbeatinfo\AutoValue_SdkHeartBeatResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */