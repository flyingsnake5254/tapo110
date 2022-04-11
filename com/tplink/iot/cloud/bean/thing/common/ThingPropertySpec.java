package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.f;
import java.util.List;

public class ThingPropertySpec
{
  private String itemType;
  private double max;
  private double min;
  private double step;
  private String unit;
  private List<String> values;
  private f whiteList;
  
  public String getItemType()
  {
    return this.itemType;
  }
  
  public double getMax()
  {
    return this.max;
  }
  
  public double getMin()
  {
    return this.min;
  }
  
  public double getStep()
  {
    return this.step;
  }
  
  public String getUnit()
  {
    return this.unit;
  }
  
  public List<String> getValues()
  {
    return this.values;
  }
  
  public f getWhiteList()
  {
    return this.whiteList;
  }
  
  public void setItemType(String paramString)
  {
    this.itemType = paramString;
  }
  
  public void setMax(double paramDouble)
  {
    this.max = paramDouble;
  }
  
  public void setMin(double paramDouble)
  {
    this.min = paramDouble;
  }
  
  public void setStep(double paramDouble)
  {
    this.step = paramDouble;
  }
  
  public void setUnit(String paramString)
  {
    this.unit = paramString;
  }
  
  public void setValues(List<String> paramList)
  {
    this.values = paramList;
  }
  
  public void setWhiteList(f paramf)
  {
    this.whiteList = paramf;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingPropertySpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */