package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.google.gson.q.b;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import java.util.List;

public abstract class AbstractLightingEffect
{
  private String animationType;
  private List<ColorHSBAttributeValue> colorRegistry;
  private Long createdOn;
  private CustomizationSettings customization;
  @b(ExpansionStrategy.ExpansionStrategyDeserializer.class)
  private ExpansionStrategy expansionStrategy;
  private String id;
  private LightingEffectMeta meta;
  private List<Segment> segments;
  private LightingEffectSettings settings;
  @b(Type.TypeDeserializer.class)
  private Type type;
  private Long updatedOn;
  private Integer version = LightingEffectsConstants.DEFAULT_VERSION;
  
  public String getAnimationType()
  {
    return this.animationType;
  }
  
  public List<ColorHSBAttributeValue> getColorRegistry()
  {
    return this.colorRegistry;
  }
  
  public Long getCreatedOn()
  {
    return this.createdOn;
  }
  
  public CustomizationSettings getCustomization()
  {
    return this.customization;
  }
  
  public ExpansionStrategy getExpansionStrategy()
  {
    return this.expansionStrategy;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public LightingEffectMeta getMeta()
  {
    return this.meta;
  }
  
  public List<Segment> getSegments()
  {
    return this.segments;
  }
  
  public LightingEffectSettings getSettings()
  {
    return this.settings;
  }
  
  public Type getType()
  {
    return this.type;
  }
  
  public Long getUpdatedOn()
  {
    return this.updatedOn;
  }
  
  public Integer getVersion()
  {
    return this.version;
  }
  
  public void setAnimationType(String paramString)
  {
    this.animationType = paramString;
  }
  
  public void setColorRegistry(List<ColorHSBAttributeValue> paramList)
  {
    this.colorRegistry = paramList;
  }
  
  public void setCreatedOn(Long paramLong)
  {
    this.createdOn = paramLong;
  }
  
  public void setCustomization(CustomizationSettings paramCustomizationSettings)
  {
    this.customization = paramCustomizationSettings;
  }
  
  public void setExpansionStrategy(ExpansionStrategy paramExpansionStrategy)
  {
    this.expansionStrategy = paramExpansionStrategy;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setMeta(LightingEffectMeta paramLightingEffectMeta)
  {
    this.meta = paramLightingEffectMeta;
  }
  
  public void setSegments(List<Segment> paramList)
  {
    this.segments = paramList;
  }
  
  public void setSettings(LightingEffectSettings paramLightingEffectSettings)
  {
    this.settings = paramLightingEffectSettings;
  }
  
  public void setType(Type paramType)
  {
    this.type = paramType;
  }
  
  public void setUpdatedOn(Long paramLong)
  {
    this.updatedOn = paramLong;
  }
  
  public void setVersion(Integer paramInteger)
  {
    this.version = paramInteger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\AbstractLightingEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */