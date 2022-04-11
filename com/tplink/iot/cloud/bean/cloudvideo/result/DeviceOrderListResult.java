package com.tplink.iot.cloud.bean.cloudvideo.result;

import java.util.ArrayList;
import java.util.List;

public class DeviceOrderListResult<T>
{
  private List<T> deviceList = new ArrayList();
  private int page;
  private int pageSize;
  private long total;
  
  public List<T> getDeviceList()
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
  
  public long getTotal()
  {
    return this.total;
  }
  
  public void setDeviceList(List<T> paramList)
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
  
  public void setTotal(long paramLong)
  {
    this.total = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\result\DeviceOrderListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */