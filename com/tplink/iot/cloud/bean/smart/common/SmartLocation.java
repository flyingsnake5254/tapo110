package com.tplink.iot.cloud.bean.smart.common;

import java.util.Objects;

public class SmartLocation
{
  private Integer latitude;
  private Integer longitude;
  private String region;
  private Integer timeDiff;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartLocation)paramObject;
      if ((!Objects.equals(this.region, ((SmartLocation)paramObject).region)) || (!Objects.equals(this.timeDiff, ((SmartLocation)paramObject).timeDiff)) || (!Objects.equals(this.longitude, ((SmartLocation)paramObject).longitude)) || (!Objects.equals(this.latitude, ((SmartLocation)paramObject).latitude))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public Integer getLatitude()
  {
    return this.latitude;
  }
  
  public Integer getLongitude()
  {
    return this.longitude;
  }
  
  public String getRegion()
  {
    return this.region;
  }
  
  public Integer getTimeDiff()
  {
    return this.timeDiff;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.region, this.timeDiff, this.longitude, this.latitude });
  }
  
  public void setLatitude(Integer paramInteger)
  {
    this.latitude = paramInteger;
  }
  
  public void setLongitude(Integer paramInteger)
  {
    this.longitude = paramInteger;
  }
  
  public void setRegion(String paramString)
  {
    this.region = paramString;
  }
  
  public void setTimeDiff(Integer paramInteger)
  {
    this.timeDiff = paramInteger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */