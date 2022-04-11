package com.tplink.iot.dailysummary.network.bean.result;

import java.util.List;

public class RecentSummaryListResult
{
  private List<SummaryResult> dateList;
  
  public List<SummaryResult> getDateList()
  {
    return this.dateList;
  }
  
  public void setDateList(List<SummaryResult> paramList)
  {
    this.dateList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\result\RecentSummaryListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */