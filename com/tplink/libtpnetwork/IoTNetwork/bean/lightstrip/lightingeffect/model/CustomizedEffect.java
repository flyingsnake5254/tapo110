package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.google.gson.k;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import java.util.List;

public class CustomizedEffect
  extends AbstractLightingEffect
{
  private Long accountId;
  private String predefinedEffectId;
  private k templateInput;
  
  public static CustomizedEffectBuilder builder()
  {
    return new CustomizedEffectBuilder(null);
  }
  
  public Long getAccountId()
  {
    return this.accountId;
  }
  
  public String getPredefinedEffectId()
  {
    return this.predefinedEffectId;
  }
  
  public k getTemplateInput()
  {
    return this.templateInput;
  }
  
  public void setAccountId(Long paramLong)
  {
    this.accountId = paramLong;
  }
  
  public void setPredefinedEffectId(String paramString)
  {
    this.predefinedEffectId = paramString;
  }
  
  public void setTemplateInput(k paramk)
  {
    this.templateInput = paramk;
  }
  
  public static final class CustomizedEffectBuilder
  {
    private Long accountId;
    private String animationType;
    private List<ColorHSBAttributeValue> colorRegistry;
    private Long createdOn;
    private CustomizationSettings customization;
    private ExpansionStrategy expansionStrategy;
    private String id;
    private LightingEffectMeta meta;
    private String predefinedEffectId;
    private List<Segment> segments;
    private LightingEffectSettings settings;
    private k templateInput;
    private Type type;
    private Long updatedOn;
    private Integer version;
    
    public CustomizedEffectBuilder accountId(Long paramLong)
    {
      this.accountId = paramLong;
      return this;
    }
    
    public CustomizedEffectBuilder animationType(String paramString)
    {
      this.animationType = paramString;
      return this;
    }
    
    public CustomizedEffect build()
    {
      CustomizedEffect localCustomizedEffect = new CustomizedEffect();
      localCustomizedEffect.setPredefinedEffectId(this.predefinedEffectId);
      localCustomizedEffect.setAccountId(this.accountId);
      localCustomizedEffect.setId(this.id);
      localCustomizedEffect.setType(this.type);
      localCustomizedEffect.setExpansionStrategy(this.expansionStrategy);
      localCustomizedEffect.setMeta(this.meta);
      localCustomizedEffect.setColorRegistry(this.colorRegistry);
      localCustomizedEffect.setSettings(this.settings);
      localCustomizedEffect.setSegments(this.segments);
      localCustomizedEffect.setCustomization(this.customization);
      localCustomizedEffect.setAnimationType(this.animationType);
      Integer localInteger = this.version;
      if (localInteger == null) {
        localCustomizedEffect.setVersion(LightingEffectsConstants.DEFAULT_VERSION);
      } else {
        localCustomizedEffect.setVersion(localInteger);
      }
      localCustomizedEffect.setTemplateInput(this.templateInput);
      localCustomizedEffect.setCreatedOn(this.createdOn);
      localCustomizedEffect.setUpdatedOn(this.updatedOn);
      return localCustomizedEffect;
    }
    
    public CustomizedEffectBuilder colorRegistry(List<ColorHSBAttributeValue> paramList)
    {
      this.colorRegistry = paramList;
      return this;
    }
    
    public CustomizedEffectBuilder createdOn(Long paramLong)
    {
      this.createdOn = paramLong;
      return this;
    }
    
    public CustomizedEffectBuilder customization(CustomizationSettings paramCustomizationSettings)
    {
      this.customization = paramCustomizationSettings;
      return this;
    }
    
    public CustomizedEffectBuilder expansionStrategy(ExpansionStrategy paramExpansionStrategy)
    {
      this.expansionStrategy = paramExpansionStrategy;
      return this;
    }
    
    public CustomizedEffectBuilder id(String paramString)
    {
      this.id = paramString;
      return this;
    }
    
    public CustomizedEffectBuilder meta(LightingEffectMeta paramLightingEffectMeta)
    {
      this.meta = paramLightingEffectMeta;
      return this;
    }
    
    public CustomizedEffectBuilder predefinedEffectId(String paramString)
    {
      this.predefinedEffectId = paramString;
      return this;
    }
    
    public CustomizedEffectBuilder segments(List<Segment> paramList)
    {
      this.segments = paramList;
      return this;
    }
    
    public CustomizedEffectBuilder settings(LightingEffectSettings paramLightingEffectSettings)
    {
      this.settings = paramLightingEffectSettings;
      return this;
    }
    
    public CustomizedEffectBuilder templateInput(k paramk)
    {
      this.templateInput = paramk;
      return this;
    }
    
    public CustomizedEffectBuilder type(Type paramType)
    {
      this.type = paramType;
      return this;
    }
    
    public CustomizedEffectBuilder updatedOn(Long paramLong)
    {
      this.updatedOn = paramLong;
      return this;
    }
    
    public CustomizedEffectBuilder version(Integer paramInteger)
    {
      this.version = paramInteger;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\CustomizedEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */