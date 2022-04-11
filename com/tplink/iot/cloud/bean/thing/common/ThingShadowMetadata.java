package com.tplink.iot.cloud.bean.thing.common;

import java.util.Map;

public class ThingShadowMetadata
{
  private Map<String, TimestampMetaData> desired;
  private Map<String, TimestampMetaData> reported;
  
  public Map<String, TimestampMetaData> getDesired()
  {
    return this.desired;
  }
  
  public Map<String, TimestampMetaData> getReported()
  {
    return this.reported;
  }
  
  public void setDesired(Map<String, TimestampMetaData> paramMap)
  {
    this.desired = paramMap;
  }
  
  public void setReported(Map<String, TimestampMetaData> paramMap)
  {
    this.reported = paramMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingShadowMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */