package com.tplink.iot.cloud.bean.cloudvideo.result;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TrialResult
{
  private long endTime;
  private long remainTime;
  private String status;
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public long getRemainTime()
  {
    return this.remainTime;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setRemainTime(long paramLong)
  {
    this.remainTime = paramLong;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TrialStatus
  {
    public static final String ACTIVE = "active";
    public static final String EXPIRED = "expired";
    public static final String PAUSED = "paused";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\result\TrialResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */