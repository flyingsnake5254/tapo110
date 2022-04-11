package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.google.gson.k;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerAttributeValue;

public class CustomizationSettings
{
  private IntegerAttributeValue colors;
  private k initialValues;
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public IntegerAttributeValue getColors()
  {
    return this.colors;
  }
  
  public k getInitialValues()
  {
    return this.initialValues;
  }
  
  public boolean isValid()
  {
    IntegerAttributeValue localIntegerAttributeValue = this.colors;
    boolean bool;
    if ((localIntegerAttributeValue != null) && (!localIntegerAttributeValue.isValid())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void setColors(IntegerAttributeValue paramIntegerAttributeValue)
  {
    this.colors = paramIntegerAttributeValue;
  }
  
  public void setInitialValues(k paramk)
  {
    this.initialValues = paramk;
  }
  
  public static final class Builder
  {
    private IntegerAttributeValue colors;
    private k initialValues;
    
    public CustomizationSettings build()
    {
      CustomizationSettings localCustomizationSettings = new CustomizationSettings();
      localCustomizationSettings.setColors(this.colors);
      localCustomizationSettings.setInitialValues(this.initialValues);
      return localCustomizationSettings;
    }
    
    public Builder colors(IntegerAttributeValue paramIntegerAttributeValue)
    {
      this.colors = paramIntegerAttributeValue;
      return this;
    }
    
    public Builder initialValues(k paramk)
    {
      this.initialValues = paramk;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\CustomizationSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */