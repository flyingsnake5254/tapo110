package com.tplink.iot.cloud.bean.cloudvideo.common;

import java.util.List;

public class DowngradeHandled
{
  private long deviceRemovalTime;
  private int newDeviceNum;
  private List<RemovedDevice> removedDeviceList;
  private String subscriptionId;
  
  public long getDeviceRemovalTime()
  {
    return this.deviceRemovalTime;
  }
  
  public int getNewDeviceNum()
  {
    return this.newDeviceNum;
  }
  
  public List<RemovedDevice> getRemovedDeviceList()
  {
    return this.removedDeviceList;
  }
  
  public String getSubscriptionId()
  {
    return this.subscriptionId;
  }
  
  public void setDeviceRemovalTime(long paramLong)
  {
    this.deviceRemovalTime = paramLong;
  }
  
  public void setNewDeviceNum(int paramInt)
  {
    this.newDeviceNum = paramInt;
  }
  
  public void setRemovedDeviceList(List<RemovedDevice> paramList)
  {
    this.removedDeviceList = paramList;
  }
  
  public void setSubscriptionId(String paramString)
  {
    this.subscriptionId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\common\DowngradeHandled.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */