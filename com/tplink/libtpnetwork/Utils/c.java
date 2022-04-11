package com.tplink.libtpnetwork.Utils;

import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.BrightnessPresetsBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.BrightnessPresetsBean.PresetBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.BulbPresetDefine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c
{
  public static List<Integer> a(BrightnessPresetsBean paramBrightnessPresetsBean)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramBrightnessPresetsBean != null) && (paramBrightnessPresetsBean.isSet()))
    {
      paramBrightnessPresetsBean = paramBrightnessPresetsBean.getPresets();
      if ((paramBrightnessPresetsBean != null) && (paramBrightnessPresetsBean.getBrightness() != null) && (!paramBrightnessPresetsBean.getBrightness().isEmpty())) {
        localArrayList.addAll(paramBrightnessPresetsBean.getBrightness());
      }
    }
    else
    {
      localArrayList.addAll(Arrays.asList(BulbPresetDefine.DEFAULT_BRIGHTNESS_PRESETS));
    }
    return localArrayList;
  }
  
  public static List<LightStateBean> b(BrightnessPresetsBean paramBrightnessPresetsBean)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramBrightnessPresetsBean != null) && (paramBrightnessPresetsBean.isSet()))
    {
      paramBrightnessPresetsBean = paramBrightnessPresetsBean.getPresets();
      if ((paramBrightnessPresetsBean != null) && (paramBrightnessPresetsBean.getStates() != null) && (!paramBrightnessPresetsBean.getStates().isEmpty())) {
        localArrayList.addAll(paramBrightnessPresetsBean.getStates());
      }
    }
    else
    {
      localArrayList.addAll(Arrays.asList(BulbPresetDefine.DEFAULT_LIGHT_STATE_PRESETS));
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */