package com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa;

import com.tplink.iot.devices.lightstrip.lightingeffect.common.KasaLightState;

public class b
{
  public static boolean a(KasaLightState paramKasaLightState1, KasaLightState paramKasaLightState2)
  {
    boolean bool = false;
    if ((paramKasaLightState1 == null) && (paramKasaLightState2 == null)) {
      return false;
    }
    if (paramKasaLightState1 == null) {
      return true;
    }
    if (paramKasaLightState2 == null) {
      return true;
    }
    if (new a().a(paramKasaLightState1, paramKasaLightState2) != 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\fromkasa\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */