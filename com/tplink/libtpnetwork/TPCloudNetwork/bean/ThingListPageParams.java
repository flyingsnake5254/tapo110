package com.tplink.libtpnetwork.TPCloudNetwork.bean;

public class ThingListPageParams
{
  private int page;
  private int pageSize;
  
  public ThingListPageParams(int paramInt1, int paramInt2)
  {
    this.page = paramInt1;
    this.pageSize = paramInt2;
  }
  
  public int getPage()
  {
    return this.page;
  }
  
  public int getPageSize()
  {
    return this.pageSize;
  }
  
  public void setPage(int paramInt)
  {
    this.page = paramInt;
  }
  
  public void setPageSize(int paramInt)
  {
    this.pageSize = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\bean\ThingListPageParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */