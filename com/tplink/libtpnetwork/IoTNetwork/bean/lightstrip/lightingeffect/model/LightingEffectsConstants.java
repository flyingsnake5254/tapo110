package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

public class LightingEffectsConstants
{
  public static Integer ACTIVE;
  public static Integer DEFAULT_RANDOM_SEED;
  public static Integer DEFAULT_VERSION;
  public static Integer INACTIVE = Integer.valueOf(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    DEFAULT_VERSION = localInteger;
    DEFAULT_RANDOM_SEED = Integer.valueOf(24);
    ACTIVE = localInteger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\LightingEffectsConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */