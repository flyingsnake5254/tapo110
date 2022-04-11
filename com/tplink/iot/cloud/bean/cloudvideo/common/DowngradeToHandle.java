package com.tplink.iot.cloud.bean.cloudvideo.common;

public class DowngradeToHandle
{
  private long downgradeTimestamp;
  private int newDeviceNum;
  private String subscriptionId;
  
  public long getDowngradeTimestamp()
  {
    return this.downgradeTimestamp;
  }
  
  public int getNewDeviceNum()
  {
    return this.newDeviceNum;
  }
  
  public String getSubscriptionId()
  {
    return this.subscriptionId;
  }
  
  public void setDowngradeTimestamp(long paramLong)
  {
    this.downgradeTimestamp = paramLong;
  }
  
  public void setNewDeviceNum(int paramInt)
  {
    this.newDeviceNum = paramInt;
  }
  
  public void setSubscriptionId(String paramString)
  {
    this.subscriptionId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\common\DowngradeToHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */