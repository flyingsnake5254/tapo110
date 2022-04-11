package com.tplink.iot.cloud.bean.cloudvideo.result;

import java.util.ArrayList;
import java.util.List;

public class OrderPageListResult<T>
{
  private List<T> orderList = new ArrayList();
  private int page;
  private int pageSize;
  private long total;
  
  public List<T> getOrderList()
  {
    return this.orderList;
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
  
  public void setOrderList(List<T> paramList)
  {
    this.orderList = paramList;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\result\OrderPageListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */