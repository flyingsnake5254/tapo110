package com.tplink.iot.cloud.bean.share.result;

import java.util.List;

public class DeviceShareActionHandleListResult
{
  private List<DeviceShareActionHandleResult> failList;
  private List<DeviceShareActionHandleResult> handleList;
  
  public List<DeviceShareActionHandleResult> getFailList()
  {
    return this.failList;
  }
  
  public List<DeviceShareActionHandleResult> getHandleList()
  {
    return this.handleList;
  }
  
  public void setFailList(List<DeviceShareActionHandleResult> paramList)
  {
    this.failList = paramList;
  }
  
  public void setHandleList(List<DeviceShareActionHandleResult> paramList)
  {
    this.handleList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\result\DeviceShareActionHandleListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */