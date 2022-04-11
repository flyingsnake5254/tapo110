package com.tplink.iot.cloud.bean.thing.common;

import java.util.List;

public class ThingEvent
{
  private String description;
  private int expiresIn;
  private String id;
  private List<ThingProperty> uploadParams;
  
  public String getDescription()
  {
    return this.description;
  }
  
  public int getExpiresIn()
  {
    return this.expiresIn;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public List<ThingProperty> getUploadParams()
  {
    return this.uploadParams;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setExpiresIn(int paramInt)
  {
    this.expiresIn = paramInt;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setUploadParams(List<ThingProperty> paramList)
  {
    this.uploadParams = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */