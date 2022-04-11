package com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa;

public enum LightingEffectType
{
  private final String value;
  
  static
  {
    LightingEffectType localLightingEffectType1 = new LightingEffectType("PREDEFINED", 0, "predefined");
    PREDEFINED = localLightingEffectType1;
    LightingEffectType localLightingEffectType2 = new LightingEffectType("CUSTOM", 1, "custom");
    CUSTOM = localLightingEffectType2;
    LightingEffectType localLightingEffectType3 = new LightingEffectType("UNKNOWN", 2, "unknown");
    UNKNOWN = localLightingEffectType3;
    $VALUES = new LightingEffectType[] { localLightingEffectType1, localLightingEffectType2, localLightingEffectType3 };
  }
  
  private LightingEffectType(String paramString)
  {
    this.value = paramString;
  }
  
  public final String getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\fromkasa\LightingEffectType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */