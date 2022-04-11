package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class HeartBeatResult
{
  public static HeartBeatResult create(String paramString, long paramLong, HeartBeatInfo.HeartBeat paramHeartBeat)
  {
    return new AutoValue_HeartBeatResult(paramString, paramLong, paramHeartBeat);
  }
  
  public abstract HeartBeatInfo.HeartBeat getHeartBeat();
  
  public abstract long getMillis();
  
  public abstract String getSdkName();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\heartbeatinfo\HeartBeatResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */