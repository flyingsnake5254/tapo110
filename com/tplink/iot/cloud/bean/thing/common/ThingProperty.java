package com.tplink.iot.cloud.bean.thing.common;

import com.tplink.iot.cloud.enumerate.PropertyAccessMode;

public class ThingProperty
{
  private PropertyAccessMode accessMode = PropertyAccessMode.WRITE;
  private String dataType;
  private String id;
  private boolean required;
  private ThingPropertySpec specs;
  
  public PropertyAccessMode getAccessMode()
  {
    return this.accessMode;
  }
  
  public String getDataType()
  {
    return this.dataType;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public ThingPropertySpec getSpecs()
  {
    return this.specs;
  }
  
  public boolean isRequired()
  {
    return this.required;
  }
  
  public void setAccessMode(PropertyAccessMode paramPropertyAccessMode)
  {
    this.accessMode = paramPropertyAccessMode;
  }
  
  public void setDataType(String paramString)
  {
    this.dataType = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setRequired(boolean paramBoolean)
  {
    this.required = paramBoolean;
  }
  
  public void setSpecs(ThingPropertySpec paramThingPropertySpec)
  {
    this.specs = paramThingPropertySpec;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */