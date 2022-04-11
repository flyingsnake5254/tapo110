package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter;

public final class StringConverter
  implements AttributeConverter<String>
{
  public String convert(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {
      return (String)paramObject;
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\converter\StringConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */