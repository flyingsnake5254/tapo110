package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter;

import com.tplink.libtpnetwork.Utils.b0;

public final class StringReplaceConverter
  implements AttributeConverter<String>
{
  private final String regex;
  private final String replacement;
  
  public StringReplaceConverter(String paramString1, String paramString2)
  {
    this.regex = paramString1;
    this.replacement = paramString2;
  }
  
  public String convert(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof String)))
    {
      paramObject = (String)paramObject;
      if ((b0.c((String)paramObject)) && (b0.c(this.regex)) && (b0.c(this.replacement))) {
        return ((String)paramObject).replaceAll(this.regex, this.replacement);
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\converter\StringReplaceConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */