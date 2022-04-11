package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter;

public final class LongConverter
  implements AttributeConverter<Long>
{
  public Long convert(Object paramObject)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof Integer)) {
        return new Long(((Integer)paramObject).intValue());
      }
      if ((paramObject instanceof Long)) {
        return (Long)paramObject;
      }
      if ((paramObject instanceof String)) {
        return Long.valueOf(Long.parseLong((String)paramObject));
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\converter\LongConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */