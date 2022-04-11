package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import java.util.List;

public class PredefinedEffect
  extends AbstractLightingEffect
{
  private Integer active = LightingEffectsConstants.INACTIVE;
  private String customId;
  
  public static PredefinedEffectBuilder builder()
  {
    return new PredefinedEffectBuilder(null);
  }
  
  public Integer getActive()
  {
    return this.active;
  }
  
  public String getCustomId()
  {
    return this.customId;
  }
  
  public void setActive(Integer paramInteger)
  {
    this.active = paramInteger;
  }
  
  public void setCustomId(String paramString)
  {
    this.customId = paramString;
  }
  
  public static final class PredefinedEffectBuilder
  {
    private Integer active;
    private String animationType;
    private List<ColorHSBAttributeValue> colorRegistry;
    private Long createdOn;
    private String customId;
    private CustomizationSettings customization;
    private ExpansionStrategy expansionStrategy;
    private String id;
    private LightingEffectMeta meta;
    private List<Segment> segments;
    private LightingEffectSettings settings;
    private Type type;
    private Long updatedOn;
    private Integer version;
    
    public PredefinedEffectBuilder active(Integer paramInteger)
    {
      this.active = paramInteger;
      return this;
    }
    
    public PredefinedEffectBuilder animationType(String paramString)
    {
      this.animationType = paramString;
      return this;
    }
    
    public PredefinedEffect build()
    {
      PredefinedEffect localPredefinedEffect = new PredefinedEffect();
      localPredefinedEffect.setCustomId(this.customId);
      localPredefinedEffect.setId(this.id);
      localPredefinedEffect.setType(this.type);
      localPredefinedEffect.setExpansionStrategy(this.expansionStrategy);
      localPredefinedEffect.setMeta(this.meta);
      localPredefinedEffect.setColorRegistry(this.colorRegistry);
      localPredefinedEffect.setSettings(this.settings);
      localPredefinedEffect.setSegments(this.segments);
      localPredefinedEffect.setCustomization(this.customization);
      localPredefinedEffect.setAnimationType(this.animationType);
      Integer localInteger = this.version;
      if (localInteger == null) {
        localPredefinedEffect.setVersion(LightingEffectsConstants.DEFAULT_VERSION);
      } else {
        localPredefinedEffect.setVersion(localInteger);
      }
      localInteger = this.active;
      if (localInteger == null) {
        localPredefinedEffect.setActive(LightingEffectsConstants.INACTIVE);
      } else {
        localPredefinedEffect.setActive(localInteger);
      }
      localPredefinedEffect.setCreatedOn(this.createdOn);
      localPredefinedEffect.setUpdatedOn(this.updatedOn);
      return localPredefinedEffect;
    }
    
    public PredefinedEffectBuilder colorRegistry(List<ColorHSBAttributeValue> paramList)
    {
      this.colorRegistry = paramList;
      return this;
    }
    
    public PredefinedEffectBuilder createdOn(Long paramLong)
    {
      this.createdOn = paramLong;
      return this;
    }
    
    public PredefinedEffectBuilder customId(String paramString)
    {
      this.customId = paramString;
      return this;
    }
    
    public PredefinedEffectBuilder customization(CustomizationSettings paramCustomizationSettings)
    {
      this.customization = paramCustomizationSettings;
      return this;
    }
    
    public PredefinedEffectBuilder expansionStrategy(ExpansionStrategy paramExpansionStrategy)
    {
      this.expansionStrategy = paramExpansionStrategy;
      return this;
    }
    
    public PredefinedEffectBuilder id(String paramString)
    {
      this.id = paramString;
      return this;
    }
    
    public PredefinedEffectBuilder meta(LightingEffectMeta paramLightingEffectMeta)
    {
      this.meta = paramLightingEffectMeta;
      return this;
    }
    
    public PredefinedEffectBuilder segments(List<Segment> paramList)
    {
      this.segments = paramList;
      return this;
    }
    
    public PredefinedEffectBuilder settings(LightingEffectSettings paramLightingEffectSettings)
    {
      this.settings = paramLightingEffectSettings;
      return this;
    }
    
    public PredefinedEffectBuilder type(Type paramType)
    {
      this.type = paramType;
      return this;
    }
    
    public PredefinedEffectBuilder updatedOn(Long paramLong)
    {
      this.updatedOn = paramLong;
      return this;
    }
    
    public PredefinedEffectBuilder version(Integer paramInteger)
    {
      this.version = paramInteger;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\PredefinedEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */