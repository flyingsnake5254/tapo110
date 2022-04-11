package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.google.gson.q.b;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.LongAttributeValue;

public class LightingEffectSettings
{
  private BackgroundSetting background;
  private ColorHSBAttributeValue color;
  private ColorSequence colorSequence;
  private LongAttributeValue delay;
  @b(Direction.DirectionDeserializer.class)
  private Direction direction;
  @Deprecated
  private LongAttributeValue period;
  private IntegerAttributeValue randomSeed;
  private String repeat;
  private Integer spread;
  private LongAttributeValue transition;
  
  public static LightingEffectSettingsBuilder builder()
  {
    return new LightingEffectSettingsBuilder(null);
  }
  
  public BackgroundSetting getBackground()
  {
    return this.background;
  }
  
  public ColorHSBAttributeValue getColor()
  {
    return this.color;
  }
  
  public ColorSequence getColorSequence()
  {
    return this.colorSequence;
  }
  
  public LongAttributeValue getDelay()
  {
    return this.delay;
  }
  
  public Direction getDirection()
  {
    return this.direction;
  }
  
  @Deprecated
  public LongAttributeValue getPeriod()
  {
    return this.period;
  }
  
  public IntegerAttributeValue getRandomSeed()
  {
    return this.randomSeed;
  }
  
  public String getRepeat()
  {
    return this.repeat;
  }
  
  public Integer getSpread()
  {
    return this.spread;
  }
  
  public LongAttributeValue getTransition()
  {
    return this.transition;
  }
  
  public void setBackground(BackgroundSetting paramBackgroundSetting)
  {
    this.background = paramBackgroundSetting;
  }
  
  public void setColor(ColorHSBAttributeValue paramColorHSBAttributeValue)
  {
    this.color = paramColorHSBAttributeValue;
  }
  
  public void setColorSequence(ColorSequence paramColorSequence)
  {
    this.colorSequence = paramColorSequence;
  }
  
  public void setDelay(LongAttributeValue paramLongAttributeValue)
  {
    this.delay = paramLongAttributeValue;
  }
  
  public void setDirection(Direction paramDirection)
  {
    this.direction = paramDirection;
  }
  
  @Deprecated
  public void setPeriod(LongAttributeValue paramLongAttributeValue)
  {
    this.period = paramLongAttributeValue;
  }
  
  public void setRandomSeed(IntegerAttributeValue paramIntegerAttributeValue)
  {
    this.randomSeed = paramIntegerAttributeValue;
  }
  
  public void setRepeat(String paramString)
  {
    this.repeat = paramString;
  }
  
  public void setSpread(Integer paramInteger)
  {
    this.spread = paramInteger;
  }
  
  public void setTransition(LongAttributeValue paramLongAttributeValue)
  {
    this.transition = paramLongAttributeValue;
  }
  
  public static final class LightingEffectSettingsBuilder
  {
    private BackgroundSetting background;
    private ColorHSBAttributeValue color;
    private ColorSequence colorSequence;
    private LongAttributeValue delay;
    private Direction direction;
    @Deprecated
    private LongAttributeValue period;
    private IntegerAttributeValue randomSeed;
    private String repeat;
    private Integer spread;
    private LongAttributeValue transition;
    
    public LightingEffectSettingsBuilder background(BackgroundSetting paramBackgroundSetting)
    {
      this.background = paramBackgroundSetting;
      return this;
    }
    
    public LightingEffectSettings build()
    {
      LightingEffectSettings localLightingEffectSettings = new LightingEffectSettings();
      localLightingEffectSettings.setTransition(this.transition);
      localLightingEffectSettings.setDelay(this.delay);
      localLightingEffectSettings.setPeriod(this.period);
      localLightingEffectSettings.setColor(this.color);
      localLightingEffectSettings.setRandomSeed(this.randomSeed);
      localLightingEffectSettings.setBackground(this.background);
      localLightingEffectSettings.setColorSequence(this.colorSequence);
      localLightingEffectSettings.setSpread(this.spread);
      localLightingEffectSettings.setRepeat(this.repeat);
      localLightingEffectSettings.setDirection(this.direction);
      return localLightingEffectSettings;
    }
    
    public LightingEffectSettingsBuilder color(ColorHSBAttributeValue paramColorHSBAttributeValue)
    {
      this.color = paramColorHSBAttributeValue;
      return this;
    }
    
    public LightingEffectSettingsBuilder colorSequence(ColorSequence paramColorSequence)
    {
      this.colorSequence = paramColorSequence;
      return this;
    }
    
    public LightingEffectSettingsBuilder delay(LongAttributeValue paramLongAttributeValue)
    {
      this.delay = paramLongAttributeValue;
      return this;
    }
    
    public LightingEffectSettingsBuilder direction(Direction paramDirection)
    {
      this.direction = paramDirection;
      return this;
    }
    
    @Deprecated
    public LightingEffectSettingsBuilder period(LongAttributeValue paramLongAttributeValue)
    {
      this.period = paramLongAttributeValue;
      return this;
    }
    
    public LightingEffectSettingsBuilder randomSeed(IntegerAttributeValue paramIntegerAttributeValue)
    {
      this.randomSeed = paramIntegerAttributeValue;
      return this;
    }
    
    public LightingEffectSettingsBuilder repeat(String paramString)
    {
      this.repeat = paramString;
      return this;
    }
    
    public LightingEffectSettingsBuilder spread(Integer paramInteger)
    {
      this.spread = paramInteger;
      return this;
    }
    
    public LightingEffectSettingsBuilder transition(LongAttributeValue paramLongAttributeValue)
    {
      this.transition = paramLongAttributeValue;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\LightingEffectSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */