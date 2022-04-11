package com.tplink.iot.cloud.bean.common;

import java.util.ArrayList;
import java.util.List;

public class PageListResult<T>
{
  private List<T> data = new ArrayList();
  private int page;
  private int pageSize;
  private long total;
  
  public List<T> getData()
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
  
  public long getTotal()
  {
    return this.total;
  }
  
  public void setData(List<T> paramList)
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
  
  public void setTotal(long paramLong)
  {
    this.total = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\common\PageListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */