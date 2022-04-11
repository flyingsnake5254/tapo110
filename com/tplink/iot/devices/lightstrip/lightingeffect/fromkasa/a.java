package com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa;

import com.tplink.iot.devices.lightstrip.lightingeffect.common.KasaLightState;
import java.util.Comparator;

public class a
  implements Comparator<KasaLightState>
{
  public int a(KasaLightState paramKasaLightState1, KasaLightState paramKasaLightState2)
  {
    org.apache.commons.lang.builder.a locala = new org.apache.commons.lang.builder.a();
    locala.g(paramKasaLightState1.getBrightness(), paramKasaLightState2.getBrightness()).g(paramKasaLightState1.getColorTemperature(), paramKasaLightState2.getColorTemperature()).g(paramKasaLightState1.getHue(), paramKasaLightState2.getHue()).g(paramKasaLightState1.getSaturation(), paramKasaLightState2.getSaturation());
    return locala.t();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\fromkasa\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */