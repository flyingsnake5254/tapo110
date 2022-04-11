package com.tplink.iot.cloud.bean.share.result;

import java.util.List;

public class ShareDeviceListResult
{
  private List<ShareDeviceResult> data;
  private int page;
  private int pageSize;
  private int total;
  
  public List<ShareDeviceResult> getData()
  {
    return this.data;
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
  
  public void setData(List<ShareDeviceResult> paramList)
  {
    this.data = paramList;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\result\ShareDeviceListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */