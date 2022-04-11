package com.tplink.iot.cloud.bean.thing.common;

public class ThingRealTimeInfo
{
  private Integer curLoadNum;
  private String loadLevel;
  private Integer maxLoadNum;
  private Integer rssi;
  private int signalLevel;
  private Integer totalMemory;
  private Integer usedMemory;
  
  public Integer getCurLoadNum()
  {
    return this.curLoadNum;
  }
  
  public String getLoadLevel()
  {
    return this.loadLevel;
  }
  
  public Integer getMaxLoadNum()
  {
    return this.maxLoadNum;
  }
  
  public Integer getRssi()
  {
    return this.rssi;
  }
  
  public int getSignalLevel()
  {
    return this.signalLevel;
  }
  
  public Integer getTotalMemory()
  {
    return this.totalMemory;
  }
  
  public Integer getUsedMemory()
  {
    return this.usedMemory;
  }
  
  public void setCurLoadNum(Integer paramInteger)
  {
    this.curLoadNum = paramInteger;
  }
  
  public void setLoadLevel(String paramString)
  {
    this.loadLevel = paramString;
  }
  
  public void setMaxLoadNum(Integer paramInteger)
  {
    this.maxLoadNum = paramInteger;
  }
  
  public void setRssi(Integer paramInteger)
  {
    this.rssi = paramInteger;
  }
  
  public void setSignalLevel(int paramInt)
  {
    this.signalLevel = paramInt;
  }
  
  public void setTotalMemory(Integer paramInteger)
  {
    this.totalMemory = paramInteger;
  }
  
  public void setUsedMemory(Integer paramInteger)
  {
    this.usedMemory = paramInteger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingRealTimeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */