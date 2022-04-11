package com.tplink.iot.dailysummary.network.bean.result;

import com.tplink.iot.dailysummary.network.bean.common.Summary;
import java.util.List;

public class SummaryResult
{
  private String date;
  private List<Summary> summaryList;
  
  public String getDate()
  {
    return this.date;
  }
  
  public List<Summary> getSummaryList()
  {
    return this.summaryList;
  }
  
  public void setDate(String paramString)
  {
    this.date = paramString;
  }
  
  public void setSummaryList(List<Summary> paramList)
  {
    this.summaryList = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SummaryResult{date='");
    localStringBuilder.append(this.date);
    localStringBuilder.append('\'');
    localStringBuilder.append(", summaryList=");
    localStringBuilder.append(this.summaryList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\result\SummaryResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */