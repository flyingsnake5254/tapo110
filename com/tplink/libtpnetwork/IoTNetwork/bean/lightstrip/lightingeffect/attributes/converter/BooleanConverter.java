package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter;

public final class BooleanConverter
  implements AttributeConverter<Boolean>
{
  public Boolean convert(Object paramObject)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof Boolean)) {
        return (Boolean)paramObject;
      }
      if ((paramObject instanceof String)) {
        return Boolean.valueOf(Boolean.parseBoolean((String)paramObject));
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\converter\BooleanConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */