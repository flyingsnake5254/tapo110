package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter;

public final class IntegerConverter
  implements AttributeConverter<Integer>
{
  public Integer convert(Object paramObject)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof Integer)) {
        return (Integer)paramObject;
      }
      if ((paramObject instanceof String)) {
        return Integer.valueOf(Integer.parseInt((String)paramObject));
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\converter\IntegerConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */