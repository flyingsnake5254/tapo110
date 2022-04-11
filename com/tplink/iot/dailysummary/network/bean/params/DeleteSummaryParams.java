package com.tplink.iot.dailysummary.network.bean.params;

import com.tplink.iot.dailysummary.network.bean.common.DeleteSummaryInfo;
import java.util.List;

public class DeleteSummaryParams
{
  private List<DeleteSummaryInfo> dateList;
  private String deviceId;
  
  public List<DeleteSummaryInfo> getDateList()
  {
    return this.dateList;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public void setDateList(List<DeleteSummaryInfo> paramList)
  {
    this.dateList = paramList;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\params\DeleteSummaryParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */