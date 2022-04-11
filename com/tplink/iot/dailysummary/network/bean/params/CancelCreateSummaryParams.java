package com.tplink.iot.dailysummary.network.bean.params;

public class CancelCreateSummaryParams
{
  private String deviceId;
  private String eventId;
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getEventId()
  {
    return this.eventId;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setEventId(String paramString)
  {
    this.eventId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\params\CancelCreateSummaryParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */