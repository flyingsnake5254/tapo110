package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SdkHeartBeatResult
  implements Comparable<SdkHeartBeatResult>
{
  public static SdkHeartBeatResult create(String paramString, long paramLong)
  {
    return new AutoValue_SdkHeartBeatResult(paramString, paramLong);
  }
  
  public int compareTo(SdkHeartBeatResult paramSdkHeartBeatResult)
  {
    int i;
    if (getMillis() < paramSdkHeartBeatResult.getMillis()) {
      i = -1;
    } else {
      i = 1;
    }
    return i;
  }
  
  public abstract long getMillis();
  
  public abstract String getSdkName();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\heartbeatinfo\SdkHeartBeatResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */