package com.tplink.iot.cloud.bean.thing.common;

public class ThingShadowMessage
  extends ThingShadow
{
  private ThingShadowMetadata metadata;
  private int timestamp;
  
  public ThingShadowMetadata getMetadata()
  {
    return this.metadata;
  }
  
  public int getTimestamp()
  {
    return this.timestamp;
  }
  
  public void setMetadata(ThingShadowMetadata paramThingShadowMetadata)
  {
    this.metadata = paramThingShadowMetadata;
  }
  
  public void setTimestamp(int paramInt)
  {
    this.timestamp = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingShadowMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */