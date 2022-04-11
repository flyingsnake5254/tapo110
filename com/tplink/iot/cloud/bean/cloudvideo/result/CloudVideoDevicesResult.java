package com.tplink.iot.cloud.bean.cloudvideo.result;

import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideoDevice;
import java.util.List;

public class CloudVideoDevicesResult
{
  private List<CloudVideoDevice> deviceList;
  private int page;
  private int pageSize;
  private int total;
  
  public List<CloudVideoDevice> getDeviceList()
  {
    return this.deviceList;
  }
  
  public int getPage()
  {
    return this.page;
  }
  
  public int getPageSize()
  {
    return this.pageSize;
  }
  
  public int getTotal()
  {
    return this.total;
  }
  
  public void setDeviceList(List<CloudVideoDevice> paramList)
  {
    this.deviceList = paramList;
  }
  
  public void setPage(int paramInt)
  {
    this.page = paramInt;
  }
  
  public void setPageSize(int paramInt)
  {
    this.pageSize = paramInt;
  }
  
  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\result\CloudVideoDevicesResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */