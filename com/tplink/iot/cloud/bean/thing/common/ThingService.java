package com.tplink.iot.cloud.bean.thing.common;

import java.util.ArrayList;
import java.util.List;

public class ThingService
{
  private String id;
  private List<ThingProperty> inputParams = new ArrayList();
  private List<ThingProperty> outputParams = new ArrayList();
  
  public String getId()
  {
    return this.id;
  }
  
  public List<ThingProperty> getInputParams()
  {
    return this.inputParams;
  }
  
  public List<ThingProperty> getOutputParams()
  {
    return this.outputParams;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setInputParams(List<ThingProperty> paramList)
  {
    this.inputParams = paramList;
  }
  
  public void setOutputParams(List<ThingProperty> paramList)
  {
    this.outputParams = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */