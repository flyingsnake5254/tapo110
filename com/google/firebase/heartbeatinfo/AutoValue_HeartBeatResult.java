package com.google.firebase.heartbeatinfo;

import java.util.Objects;

final class AutoValue_HeartBeatResult
  extends HeartBeatResult
{
  private final HeartBeatInfo.HeartBeat heartBeat;
  private final long millis;
  private final String sdkName;
  
  AutoValue_HeartBeatResult(String paramString, long paramLong, HeartBeatInfo.HeartBeat paramHeartBeat)
  {
    Objects.requireNonNull(paramString, "Null sdkName");
    this.sdkName = paramString;
    this.millis = paramLong;
    Objects.requireNonNull(paramHeartBeat, "Null heartBeat");
    this.heartBeat = paramHeartBeat;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof HeartBeatResult))
    {
      paramObject = (HeartBeatResult)paramObject;
      if ((!this.sdkName.equals(((HeartBeatResult)paramObject).getSdkName())) || (this.millis != ((HeartBeatResult)paramObject).getMillis()) || (!this.heartBeat.equals(((HeartBeatResult)paramObject).getHeartBeat()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public HeartBeatInfo.HeartBeat getHeartBeat()
  {
    return this.heartBeat;
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
    return ((i ^ 0xF4243) * 1000003 ^ (int)(l ^ l >>> 32)) * 1000003 ^ this.heartBeat.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HeartBeatResult{sdkName=");
    localStringBuilder.append(this.sdkName);
    localStringBuilder.append(", millis=");
    localStringBuilder.append(this.millis);
    localStringBuilder.append(", heartBeat=");
    localStringBuilder.append(this.heartBeat);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\heartbeatinfo\AutoValue_HeartBeatResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */