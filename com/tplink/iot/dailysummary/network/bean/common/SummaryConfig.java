package com.tplink.iot.dailysummary.network.bean.common;

public class SummaryConfig
{
  private boolean auto;
  private String deviceId;
  private boolean notify;
  private String strategy;
  private String timezone;
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getStrategy()
  {
    return this.strategy;
  }
  
  public String getTimezone()
  {
    return this.timezone;
  }
  
  public boolean isAuto()
  {
    return this.auto;
  }
  
  public boolean isNotify()
  {
    return this.notify;
  }
  
  public void setAuto(boolean paramBoolean)
  {
    this.auto = paramBoolean;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setNotify(boolean paramBoolean)
  {
    this.notify = paramBoolean;
  }
  
  public void setStrategy(String paramString)
  {
    this.strategy = paramString;
  }
  
  public void setTimezone(String paramString)
  {
    this.timezone = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SummaryConfig{auto=");
    localStringBuilder.append(this.auto);
    localStringBuilder.append(", strategy='");
    localStringBuilder.append(this.strategy);
    localStringBuilder.append('\'');
    localStringBuilder.append(", deviceId='");
    localStringBuilder.append(this.deviceId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", timezone='");
    localStringBuilder.append(this.timezone);
    localStringBuilder.append('\'');
    localStringBuilder.append(", notify=");
    localStringBuilder.append(this.notify);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\common\SummaryConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */