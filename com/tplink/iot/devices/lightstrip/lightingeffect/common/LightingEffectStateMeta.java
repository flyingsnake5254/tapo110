package com.tplink.iot.devices.lightstrip.lightingeffect.common;

import java.io.Serializable;
import java.util.List;

public class LightingEffectStateMeta
  implements Serializable
{
  private String animationType;
  private List<Integer> colorList;
  private String id;
  private String imageUrl;
  private String name;
  private Integer onOff;
  private String type;
  
  public String getAnimationType()
  {
    return this.animationType;
  }
  
  public List<Integer> getColorList()
  {
    return this.colorList;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getImageUrl()
  {
    return this.imageUrl;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Integer getOnOff()
  {
    return this.onOff;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public boolean isOn()
  {
    Integer localInteger = this.onOff;
    boolean bool = true;
    if ((localInteger == null) || (localInteger.intValue() < 1)) {
      bool = false;
    }
    return bool;
  }
  
  public void merge(LightingEffectStateMeta paramLightingEffectStateMeta)
  {
    if (paramLightingEffectStateMeta.getName() != null) {
      setName(paramLightingEffectStateMeta.getName());
    }
    if (paramLightingEffectStateMeta.getId() != null) {
      setId(paramLightingEffectStateMeta.getId());
    }
    if (paramLightingEffectStateMeta.getType() != null) {
      setType(paramLightingEffectStateMeta.getType());
    }
    if (paramLightingEffectStateMeta.getAnimationType() != null) {
      setAnimationType(paramLightingEffectStateMeta.getAnimationType());
    }
    if (paramLightingEffectStateMeta.getOnOff() != null) {
      setOnOff(paramLightingEffectStateMeta.getOnOff());
    }
    if (paramLightingEffectStateMeta.getImageUrl() != null) {
      setImageUrl(paramLightingEffectStateMeta.getImageUrl());
    }
    if (paramLightingEffectStateMeta.getColorList() != null) {
      setColorList(paramLightingEffectStateMeta.getColorList());
    }
  }
  
  public void setAnimationType(String paramString)
  {
    this.animationType = paramString;
  }
  
  public void setColorList(List<Integer> paramList)
  {
    this.colorList = paramList;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setImageUrl(String paramString)
  {
    this.imageUrl = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setOnOff(Integer paramInteger)
  {
    this.onOff = paramInteger;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LightingEffectStateMeta{name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type='");
    localStringBuilder.append(this.type);
    localStringBuilder.append('\'');
    localStringBuilder.append(", animationType='");
    localStringBuilder.append(this.animationType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", onOff=");
    localStringBuilder.append(this.onOff);
    localStringBuilder.append(", imageUrl='");
    localStringBuilder.append(this.imageUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", colorList=");
    localStringBuilder.append(this.colorList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\common\LightingEffectStateMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */