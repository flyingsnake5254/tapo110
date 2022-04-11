package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter;

import b.d.w.c.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter
  implements AttributeConverter<Date>
{
  protected String format;
  protected Locale locale;
  
  public DateConverter(String paramString)
  {
    this.format = paramString;
  }
  
  public DateConverter(String paramString, Locale paramLocale)
  {
    this.format = paramString;
    this.locale = paramLocale;
  }
  
  public Date convert(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof String)))
    {
      Object localObject;
      if (this.locale == null) {
        localObject = new SimpleDateFormat(this.format);
      } else {
        localObject = new SimpleDateFormat(this.format, this.locale);
      }
      paramObject = (String)paramObject;
      try
      {
        localObject = ((SimpleDateFormat)localObject).parse((String)paramObject);
        return (Date)localObject;
      }
      catch (ParseException localParseException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parse exception on ");
        ((StringBuilder)localObject).append((String)paramObject);
        ((StringBuilder)localObject).append(" with format : ");
        ((StringBuilder)localObject).append(this.format);
        a.g(localParseException, ((StringBuilder)localObject).toString(), new Object[] { localParseException });
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\converter\DateConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */