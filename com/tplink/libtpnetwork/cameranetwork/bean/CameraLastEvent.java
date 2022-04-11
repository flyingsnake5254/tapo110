package com.tplink.libtpnetwork.cameranetwork.bean;

import android.text.TextUtils;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.cameranetwork.model.LastAlarmInfo;
import java.io.Serializable;

public class CameraLastEvent
  implements Serializable
{
  @c("alarm_time")
  private long alarmTime;
  @c("alarm_type")
  private String alarmType;
  
  public CameraLastEvent() {}
  
  public CameraLastEvent(LastAlarmInfo paramLastAlarmInfo)
  {
    this.alarmType = paramLastAlarmInfo.getAlarmType();
    this.alarmTime = getLongValue(paramLastAlarmInfo.getAlarmTime());
  }
  
  private long getLongValue(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    long l1 = 0L;
    if (bool) {
      return 0L;
    }
    try
    {
      long l2 = Long.valueOf(paramString).longValue();
      l1 = l2;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return l1;
  }
  
  public CameraLastEvent clone()
  {
    CameraLastEvent localCameraLastEvent = new CameraLastEvent();
    localCameraLastEvent.alarmType = this.alarmType;
    localCameraLastEvent.alarmTime = this.alarmTime;
    return localCameraLastEvent;
  }
  
  public long getAlarmTime()
  {
    return this.alarmTime;
  }
  
  public String getAlarmType()
  {
    return this.alarmType;
  }
  
  public void setAlarmTime(long paramLong)
  {
    this.alarmTime = paramLong;
  }
  
  public void setAlarmType(String paramString)
  {
    this.alarmType = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\CameraLastEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */