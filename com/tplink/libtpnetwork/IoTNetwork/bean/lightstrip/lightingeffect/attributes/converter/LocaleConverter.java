package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter;

import java.util.Locale;

public final class LocaleConverter
  implements AttributeConverter<Locale>
{
  public Locale convert(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof String)))
    {
      paramObject = ((String)paramObject).replaceAll("-", "_").split("_");
      int i = paramObject.length;
      if (i == 2) {
        return new Locale(paramObject[0], paramObject[1]);
      }
      if (i == 1) {
        return new Locale(paramObject[0]);
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\converter\LocaleConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */