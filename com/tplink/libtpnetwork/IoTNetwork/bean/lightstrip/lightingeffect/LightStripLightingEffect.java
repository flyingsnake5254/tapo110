package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect;

import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizationSettings;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ExpansionStrategy;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectSettings;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Segment;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Type;
import java.util.List;

public class LightStripLightingEffect
  extends AbstractLightingEffect
{
  private Integer index;
  private Boolean modifySubsetBrightnessValues = Boolean.FALSE;
  private Integer onOff;
  private Integer segmentLength;
  private String sourceType;
  
  public LightStripLightingEffect() {}
  
  private LightStripLightingEffect(Builder paramBuilder)
  {
    setId(paramBuilder.id);
    setType(paramBuilder.type);
    setExpansionStrategy(paramBuilder.expansionStrategy);
    setMeta(paramBuilder.meta);
    setColorRegistry(paramBuilder.colorRegistry);
    setSettings(paramBuilder.settings);
    setSegments(paramBuilder.segments);
    setCustomization(paramBuilder.customization);
    setAnimationType(paramBuilder.animationType);
    setVersion(paramBuilder.version);
    setCreatedOn(paramBuilder.createdOn);
    setUpdatedOn(paramBuilder.updatedOn);
    setOnOff(paramBuilder.onOff);
    setIndex(paramBuilder.index);
    setSourceType(paramBuilder.sourceType);
    setSegmentLength(paramBuilder.segmentLength);
    setModifySubsetBrightnessValues(paramBuilder.modifySubsetBrightnessValues);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public Integer getIndex()
  {
    return this.index;
  }
  
  public Boolean getModifySubsetBrightnessValues()
  {
    return this.modifySubsetBrightnessValues;
  }
  
  public Integer getOnOff()
  {
    return this.onOff;
  }
  
  public Integer getSegmentLength()
  {
    return this.segmentLength;
  }
  
  public String getSourceType()
  {
    return this.sourceType;
  }
  
  public void setIndex(Integer paramInteger)
  {
    this.index = paramInteger;
  }
  
  public void setModifySubsetBrightnessValues(Boolean paramBoolean)
  {
    this.modifySubsetBrightnessValues = paramBoolean;
  }
  
  public void setOnOff(Integer paramInteger)
  {
    this.onOff = paramInteger;
  }
  
  public void setSegmentLength(Integer paramInteger)
  {
    this.segmentLength = paramInteger;
  }
  
  public void setSourceType(String paramString)
  {
    this.sourceType = paramString;
  }
  
  public static final class Builder
  {
    private String animationType;
    private List<ColorHSBAttributeValue> colorRegistry;
    private Long createdOn;
    private CustomizationSettings customization;
    private ExpansionStrategy expansionStrategy;
    private String id;
    private Integer index;
    private LightingEffectMeta meta;
    private Boolean modifySubsetBrightnessValues;
    private Integer onOff;
    private Integer segmentLength;
    private List<Segment> segments;
    private LightingEffectSettings settings;
    private String sourceType;
    private Type type;
    private Long updatedOn;
    private Integer version;
    
    public Builder animationType(String paramString)
    {
      this.animationType = paramString;
      return this;
    }
    
    public LightStripLightingEffect build()
    {
      return new LightStripLightingEffect(this, null);
    }
    
    public Builder colorRegistry(List<ColorHSBAttributeValue> paramList)
    {
      this.colorRegistry = paramList;
      return this;
    }
    
    public Builder createdOn(Long paramLong)
    {
      this.createdOn = paramLong;
      return this;
    }
    
    public Builder customization(CustomizationSettings paramCustomizationSettings)
    {
      this.customization = paramCustomizationSettings;
      return this;
    }
    
    public Builder expansionStrategy(ExpansionStrategy paramExpansionStrategy)
    {
      this.expansionStrategy = paramExpansionStrategy;
      return this;
    }
    
    public Builder id(String paramString)
    {
      this.id = paramString;
      return this;
    }
    
    public Builder index(Integer paramInteger)
    {
      this.index = paramInteger;
      return this;
    }
    
    public Builder meta(LightingEffectMeta paramLightingEffectMeta)
    {
      this.meta = paramLightingEffectMeta;
      return this;
    }
    
    public Builder modifySubsetBrightnessValues(Boolean paramBoolean)
    {
      this.modifySubsetBrightnessValues = paramBoolean;
      return this;
    }
    
    public Builder onOff(Integer paramInteger)
    {
      this.onOff = paramInteger;
      return this;
    }
    
    public Builder segmentLength(Integer paramInteger)
    {
      this.segmentLength = paramInteger;
      return this;
    }
    
    public Builder segments(List<Segment> paramList)
    {
      this.segments = paramList;
      return this;
    }
    
    public Builder settings(LightingEffectSettings paramLightingEffectSettings)
    {
      this.settings = paramLightingEffectSettings;
      return this;
    }
    
    public Builder sourceType(String paramString)
    {
      this.sourceType = paramString;
      return this;
    }
    
    public Builder type(Type paramType)
    {
      this.type = paramType;
      return this;
    }
    
    public Builder updatedOn(Long paramLong)
    {
      this.updatedOn = paramLong;
      return this;
    }
    
    public Builder version(Integer paramInteger)
    {
      this.version = paramInteger;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\LightStripLightingEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */