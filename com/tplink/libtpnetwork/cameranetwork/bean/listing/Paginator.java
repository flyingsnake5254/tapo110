package com.tplink.libtpnetwork.cameranetwork.bean.listing;

public class Paginator
{
  private Long endingBefore;
  private Long from;
  private Long pageSize;
  private Long startingAfter;
  private Long to;
  private Long total;
  
  public static Paginator getDefault()
  {
    Paginator localPaginator = new Paginator();
    localPaginator.setFrom(Long.valueOf(0L));
    localPaginator.setPageSize(Long.valueOf(20L));
    return localPaginator;
  }
  
  public Long getEndingBefore()
  {
    return this.endingBefore;
  }
  
  public Long getFrom()
  {
    return this.from;
  }
  
  public Long getPageSize()
  {
    return this.pageSize;
  }
  
  public Long getStartingAfter()
  {
    return this.startingAfter;
  }
  
  public Long getTo()
  {
    return this.to;
  }
  
  public Long getTotal()
  {
    return this.total;
  }
  
  public void setEndingBefore(Long paramLong)
  {
    this.endingBefore = paramLong;
  }
  
  public void setFrom(Long paramLong)
  {
    this.from = paramLong;
  }
  
  public void setPageSize(Long paramLong)
  {
    this.pageSize = paramLong;
  }
  
  public void setStartingAfter(Long paramLong)
  {
    this.startingAfter = paramLong;
  }
  
  public void setTo(Long paramLong)
  {
    this.to = paramLong;
  }
  
  public void setTotal(Long paramLong)
  {
    this.total = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\listing\Paginator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */