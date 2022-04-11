package com.tplink.iot.dailysummary.network.bean.common;

import java.util.List;

public class DeleteSummaryInfo
{
  private String date;
  private List<String> uuidList;
  
  public String getDate()
  {
    return this.date;
  }
  
  public List<String> getUuidList()
  {
    return this.uuidList;
  }
  
  public void setDate(String paramString)
  {
    this.date = paramString;
  }
  
  public void setUuidList(List<String> paramList)
  {
    this.uuidList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\common\DeleteSummaryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */