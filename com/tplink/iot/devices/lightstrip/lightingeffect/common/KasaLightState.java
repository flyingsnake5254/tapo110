package com.tplink.iot.devices.lightstrip.lightingeffect.common;

import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.d;
import java.io.Serializable;

public class KasaLightState
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer brightness;
  private Integer colorTemperature;
  private Integer endIndex;
  private String hex;
  private Integer hue;
  private Integer index;
  private LightingEffectStateMeta lightingEffectState;
  private KasaLightMode mode;
  private Integer relayState;
  private d rgb;
  private Integer saturation;
  private Integer startIndex;
  private Integer transitionPeriod;
  
  public KasaLightState() {}
  
  private KasaLightState(b paramb)
  {
    setMode(b.a(paramb));
    setRelayState(b.b(paramb));
    setHue(b.f(paramb));
    setSaturation(b.g(paramb));
    setColorTemperature(b.h(paramb));
    setBrightness(b.i(paramb));
    setTransitionPeriod(b.j(paramb));
    setIndex(b.k(paramb));
    setStartIndex(b.l(paramb));
    setEndIndex(b.m(paramb));
    setHex(b.c(paramb));
    setRgb(b.d(paramb));
    setLightingEffectState(b.e(paramb));
  }
  
  public static b builder()
  {
    return new b(null);
  }
  
  public Integer getBrightness()
  {
    return this.brightness;
  }
  
  public Integer getColorTemperature()
  {
    return this.colorTemperature;
  }
  
  public Integer getEndIndex()
  {
    return this.endIndex;
  }
  
  public String getHex()
  {
    return this.hex;
  }
  
  public Integer getHue()
  {
    return this.hue;
  }
  
  public Integer getIndex()
  {
    return this.index;
  }
  
  public LightingEffectStateMeta getLightingEffectState()
  {
    return this.lightingEffectState;
  }
  
  public KasaLightMode getMode()
  {
    return this.mode;
  }
  
  public Integer getRelayState()
  {
    return this.relayState;
  }
  
  public d getRgb()
  {
    return this.rgb;
  }
  
  public Integer getSaturation()
  {
    return this.saturation;
  }
  
  public Integer getStartIndex()
  {
    return this.startIndex;
  }
  
  public Integer getTransitionPeriod()
  {
    return this.transitionPeriod;
  }
  
  public void merge(KasaLightState paramKasaLightState)
  {
    if (paramKasaLightState.getMode() != null) {
      setMode(paramKasaLightState.getMode());
    }
    if (paramKasaLightState.getRelayState() != null) {
      setRelayState(paramKasaLightState.getRelayState());
    }
    if (paramKasaLightState.getBrightness() != null) {
      setBrightness(paramKasaLightState.getBrightness());
    }
    if (paramKasaLightState.getHex() != null) {
      setHex(paramKasaLightState.getHex());
    }
    if (paramKasaLightState.getHue() != null) {
      setHue(paramKasaLightState.getHue());
    }
    if (paramKasaLightState.getSaturation() != null) {
      setSaturation(paramKasaLightState.getSaturation());
    }
    if (paramKasaLightState.getColorTemperature() != null) {
      setColorTemperature(paramKasaLightState.getColorTemperature());
    }
    if (paramKasaLightState.getLightingEffectState() != null)
    {
      LightingEffectStateMeta localLightingEffectStateMeta1 = getLightingEffectState();
      LightingEffectStateMeta localLightingEffectStateMeta2 = localLightingEffectStateMeta1;
      if (localLightingEffectStateMeta1 == null) {
        localLightingEffectStateMeta2 = new LightingEffectStateMeta();
      }
      localLightingEffectStateMeta2.merge(paramKasaLightState.getLightingEffectState());
      setLightingEffectState(localLightingEffectStateMeta2);
    }
  }
  
  public void setBrightness(Integer paramInteger)
  {
    this.brightness = paramInteger;
  }
  
  public void setColorTemperature(Integer paramInteger)
  {
    this.colorTemperature = paramInteger;
  }
  
  public void setEndIndex(Integer paramInteger)
  {
    this.endIndex = paramInteger;
  }
  
  public void setHex(String paramString)
  {
    this.hex = paramString;
  }
  
  public void setHue(Integer paramInteger)
  {
    this.hue = paramInteger;
  }
  
  public void setIndex(Integer paramInteger)
  {
    this.index = paramInteger;
  }
  
  public void setLightingEffectState(LightingEffectStateMeta paramLightingEffectStateMeta)
  {
    this.lightingEffectState = paramLightingEffectStateMeta;
  }
  
  public void setMode(KasaLightMode paramKasaLightMode)
  {
    this.mode = paramKasaLightMode;
  }
  
  public void setRelayState(Integer paramInteger)
  {
    this.relayState = paramInteger;
  }
  
  public void setRgb(d paramd)
  {
    this.rgb = paramd;
  }
  
  public void setSaturation(Integer paramInteger)
  {
    this.saturation = paramInteger;
  }
  
  public void setStartIndex(Integer paramInteger)
  {
    this.startIndex = paramInteger;
  }
  
  public void setTransitionPeriod(Integer paramInteger)
  {
    this.transitionPeriod = paramInteger;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LightState{mode=");
    localStringBuilder.append(this.mode);
    localStringBuilder.append(", relayState=");
    localStringBuilder.append(this.relayState);
    localStringBuilder.append(", hue=");
    localStringBuilder.append(this.hue);
    localStringBuilder.append(", saturation=");
    localStringBuilder.append(this.saturation);
    localStringBuilder.append(", colorTemperature=");
    localStringBuilder.append(this.colorTemperature);
    localStringBuilder.append(", brightness=");
    localStringBuilder.append(this.brightness);
    localStringBuilder.append(", index=");
    localStringBuilder.append(this.index);
    localStringBuilder.append(", startIndex=");
    localStringBuilder.append(this.startIndex);
    localStringBuilder.append(", endIndex=");
    localStringBuilder.append(this.endIndex);
    localStringBuilder.append(", lightingEffectState=");
    localStringBuilder.append(this.lightingEffectState);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static final class b
  {
    private KasaLightMode a;
    private Integer b;
    private Integer c;
    private Integer d;
    private Integer e;
    private Integer f;
    private Integer g;
    private Integer h;
    private Integer i;
    private Integer j;
    private String k;
    private d l;
    private LightingEffectStateMeta m;
    
    public b n(Integer paramInteger)
    {
      this.f = paramInteger;
      return this;
    }
    
    public KasaLightState o()
    {
      return new KasaLightState(this, null);
    }
    
    public b p(Integer paramInteger)
    {
      this.j = paramInteger;
      return this;
    }
    
    public b q(Integer paramInteger)
    {
      this.c = paramInteger;
      return this;
    }
    
    public b r(Integer paramInteger)
    {
      this.b = paramInteger;
      return this;
    }
    
    public b s(Integer paramInteger)
    {
      this.d = paramInteger;
      return this;
    }
    
    public b t(Integer paramInteger)
    {
      this.i = paramInteger;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\common\KasaLightState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */