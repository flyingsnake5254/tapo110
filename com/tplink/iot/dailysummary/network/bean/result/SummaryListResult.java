package com.tplink.iot.dailysummary.network.bean.result;

import java.util.List;

public class SummaryListResult
{
  private List<SummaryResult> dateList;
  private long page;
  private long pageSize;
  private long total;
  
  public List<SummaryResult> getDateList()
  {
    return this.dateList;
  }
  
  public long getPage()
  {
    return this.page;
  }
  
  public long getPageSize()
  {
    return this.pageSize;
  }
  
  public long getTotal()
  {
    return this.total;
  }
  
  public void setDateList(List<SummaryResult> paramList)
  {
    this.dateList = paramList;
  }
  
  public void setPage(long paramLong)
  {
    this.page = paramLong;
  }
  
  public void setPageSize(long paramLong)
  {
    this.pageSize = paramLong;
  }
  
  public void setTotal(long paramLong)
  {
    this.total = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SummaryListResult{total=");
    localStringBuilder.append(this.total);
    localStringBuilder.append(", page=");
    localStringBuilder.append(this.page);
    localStringBuilder.append(", pageSize=");
    localStringBuilder.append(this.pageSize);
    localStringBuilder.append(", dateList=");
    localStringBuilder.append(this.dateList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\result\SummaryListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */