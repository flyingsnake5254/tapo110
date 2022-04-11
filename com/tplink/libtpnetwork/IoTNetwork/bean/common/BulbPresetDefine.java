package com.tplink.libtpnetwork.IoTNetwork.bean.common;

import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;

public class BulbPresetDefine
{
  public static final Integer[] DEFAULT_BRIGHTNESS_PRESETS = { Integer.valueOf(100), Integer.valueOf(75), Integer.valueOf(50), Integer.valueOf(25), Integer.valueOf(5) };
  public static final LightStateBean[] DEFAULT_LIGHT_STATE_PRESETS = { new LightStateBean(0, 0, 2700, 100), new LightStateBean(240, 100, 0, 100), new LightStateBean(0, 100, 0, 100), new LightStateBean(120, 100, 0, 100), new LightStateBean(277, 86, 0, 100), new LightStateBean(60, 100, 0, 100), new LightStateBean(300, 100, 0, 100) };
  public static final LightStateBean[] LIGHT_EFFECT_L1_PRESETS = { new LightStateBean(0, 0, 2700, 100), new LightStateBean(321, 99, 0, 100), new LightStateBean(196, 99, 0, 100), new LightStateBean(6, 97, 0, 100), new LightStateBean(160, 100, 0, 100), new LightStateBean(274, 95, 0, 100), new LightStateBean(48, 100, 0, 100), new LightStateBean(242, 99, 0, 100) };
  public static final LightStateBean[] LIGHT_EFFECT_L2_PRESETS = { new LightStateBean(54, 6, 0, 100), new LightStateBean(19, 39, 0, 100), new LightStateBean(194, 52, 0, 100), new LightStateBean(324, 24, 0, 100), new LightStateBean(170, 34, 0, 100), new LightStateBean(276, 27, 0, 100), new LightStateBean(56, 46, 0, 100), new LightStateBean(221, 36, 0, 100) };
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\BulbPresetDefine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */