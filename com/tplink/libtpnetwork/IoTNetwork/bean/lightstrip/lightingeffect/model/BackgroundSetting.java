package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.LongAttributeValue;
import com.tplink.libtpnetwork.Utils.b0;
import java.util.List;

public class BackgroundSetting
{
  private ColorSequence colors;
  private LongAttributeValue fadeOff;
  
  public static BackgroundSettingBuilder builder()
  {
    return new BackgroundSettingBuilder(null);
  }
  
  public ColorSequence getColors()
  {
    return this.colors;
  }
  
  public LongAttributeValue getFadeOff()
  {
    return this.fadeOff;
  }
  
  public void setColors(ColorSequence paramColorSequence)
  {
    this.colors = paramColorSequence;
  }
  
  public void setFadeOff(LongAttributeValue paramLongAttributeValue)
  {
    this.fadeOff = paramLongAttributeValue;
  }
  
  public boolean validate(List<ColorHSBAttributeValue> paramList)
  {
    Object localObject = this.fadeOff;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localObject != null)
    {
      localObject = this.colors;
      bool2 = bool1;
      if (localObject != null) {
        if (b0.b(((ColorSequence)localObject).getSeq()))
        {
          bool2 = bool1;
        }
        else
        {
          bool2 = bool1;
          if (this.fadeOff.isValid())
          {
            bool2 = bool1;
            if (this.colors.isRegisteredIn(paramList)) {
              bool2 = true;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public static final class BackgroundSettingBuilder
  {
    private ColorSequence colors;
    private LongAttributeValue fadeOff;
    
    public static BackgroundSettingBuilder aBackgroundSetting()
    {
      return new BackgroundSettingBuilder();
    }
    
    public BackgroundSetting build()
    {
      BackgroundSetting localBackgroundSetting = new BackgroundSetting();
      localBackgroundSetting.setFadeOff(this.fadeOff);
      localBackgroundSetting.setColors(this.colors);
      return localBackgroundSetting;
    }
    
    public BackgroundSettingBuilder colors(ColorSequence paramColorSequence)
    {
      this.colors = paramColorSequence;
      return this;
    }
    
    public BackgroundSettingBuilder fadeOff(LongAttributeValue paramLongAttributeValue)
    {
      this.fadeOff = paramLongAttributeValue;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\BackgroundSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */