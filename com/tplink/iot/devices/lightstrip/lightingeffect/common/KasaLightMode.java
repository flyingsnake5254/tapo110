package com.tplink.iot.devices.lightstrip.lightingeffect.common;

public enum KasaLightMode
{
  private String value;
  
  static
  {
    KasaLightMode localKasaLightMode1 = new KasaLightMode("NORMAL", 0, "normal");
    NORMAL = localKasaLightMode1;
    KasaLightMode localKasaLightMode2 = new KasaLightMode("CIRCADIAN", 1, "circadian");
    CIRCADIAN = localKasaLightMode2;
    KasaLightMode localKasaLightMode3 = new KasaLightMode("LAST_STATUS", 2, "last_status");
    LAST_STATUS = localKasaLightMode3;
    KasaLightMode localKasaLightMode4 = new KasaLightMode("INSTANT_ON_OFF", 3, "instant_on_off");
    INSTANT_ON_OFF = localKasaLightMode4;
    KasaLightMode localKasaLightMode5 = new KasaLightMode("GENTLE_ON_OFF", 4, "gentle_on_off");
    GENTLE_ON_OFF = localKasaLightMode5;
    KasaLightMode localKasaLightMode6 = new KasaLightMode("NONE", 5, "none");
    NONE = localKasaLightMode6;
    KasaLightMode localKasaLightMode7 = new KasaLightMode("LIGHTING_EFFECT", 6, "lighting_effect");
    LIGHTING_EFFECT = localKasaLightMode7;
    KasaLightMode localKasaLightMode8 = new KasaLightMode("CUSTOMIZE_PRESET", 7, "customize_preset");
    CUSTOMIZE_PRESET = localKasaLightMode8;
    $VALUES = new KasaLightMode[] { localKasaLightMode1, localKasaLightMode2, localKasaLightMode3, localKasaLightMode4, localKasaLightMode5, localKasaLightMode6, localKasaLightMode7, localKasaLightMode8 };
  }
  
  private KasaLightMode(String paramString)
  {
    this.value = paramString;
  }
  
  public static KasaLightMode fromValue(String paramString)
  {
    for (KasaLightMode localKasaLightMode : ) {
      if (localKasaLightMode.getValue().equalsIgnoreCase(paramString)) {
        return localKasaLightMode;
      }
    }
    return null;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\common\KasaLightMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */