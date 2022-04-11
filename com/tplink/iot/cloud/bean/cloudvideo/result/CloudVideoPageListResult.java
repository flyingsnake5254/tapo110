package com.tplink.iot.cloud.bean.cloudvideo.result;

import java.util.ArrayList;
import java.util.List;

public class CloudVideoPageListResult<T>
{
  private String deviceId;
  private List<T> index = new ArrayList();
  private int page;
  private int pageSize;
  private long total;
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public List<T> getIndex()
  {
    return this.index;
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
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setIndex(List<T> paramList)
  {
    this.index = paramList;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\result\CloudVideoPageListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */