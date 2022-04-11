package com.tplink.iot.Utils.x0;

import android.text.TextUtils;
import com.google.gson.f;
import com.google.gson.k;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean.BrightnessBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;

public class c
{
  public static void a(String paramString, f paramf)
  {
    h.g("bulb_setting", "change_preset", paramString, new l[] { new l("preset", paramf) });
  }
  
  public static void b(String paramString, DefaultStatesBean paramDefaultStatesBean)
  {
    if (paramDefaultStatesBean == null) {
      return;
    }
    Object localObject1 = null;
    k localk = new k();
    Object localObject2;
    if (paramDefaultStatesBean.getBrightness() != null)
    {
      localObject2 = paramDefaultStatesBean.getBrightness();
      paramDefaultStatesBean = ((DefaultStatesBean.BrightnessBean)localObject2).getType();
      localObject1 = paramDefaultStatesBean;
      if (TextUtils.equals(paramDefaultStatesBean, "custom"))
      {
        localk.l("brightness", Integer.valueOf(((DefaultStatesBean.BrightnessBean)localObject2).getValue()));
        localObject1 = paramDefaultStatesBean;
      }
    }
    else if (!TextUtils.isEmpty(paramDefaultStatesBean.getType()))
    {
      localObject2 = paramDefaultStatesBean.getType();
      paramDefaultStatesBean = paramDefaultStatesBean.getLightState();
      localObject1 = localObject2;
      if (TextUtils.equals((CharSequence)localObject2, "custom"))
      {
        localObject1 = localObject2;
        if (paramDefaultStatesBean != null)
        {
          localk.l("brightness", Integer.valueOf(paramDefaultStatesBean.getBrightness()));
          localk.l("color_temperature", Integer.valueOf(paramDefaultStatesBean.getColorTemp()));
          localk.l("hue", Integer.valueOf(paramDefaultStatesBean.getHue()));
          localk.l("saturation", Integer.valueOf(paramDefaultStatesBean.getSaturation()));
          localObject1 = localObject2;
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      if (TextUtils.equals((CharSequence)localObject1, "custom")) {
        h.g("bulb_setting", "default_state", paramString, new l[] { new l("type", "custom"), new l("state_info", localk) });
      } else {
        h.g("bulb_setting", "default_state", paramString, new l[] { new l("type", "last_states") });
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */