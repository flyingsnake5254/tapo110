package com.tplink.iot.dailysummary.network.bean.params;

public class CreateSummaryParams
{
  private String date;
  private String deviceId;
  
  public String getDate()
  {
    return this.date;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public void setDate(String paramString)
  {
    this.date = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\params\CreateSummaryParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */