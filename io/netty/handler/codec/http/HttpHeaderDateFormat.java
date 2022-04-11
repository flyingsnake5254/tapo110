package io.netty.handler.codec.http;

import io.netty.util.concurrent.FastThreadLocal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Deprecated
public final class HttpHeaderDateFormat
  extends SimpleDateFormat
{
  private static final FastThreadLocal<HttpHeaderDateFormat> dateFormatThreadLocal = new FastThreadLocal()
  {
    protected HttpHeaderDateFormat initialValue()
    {
      return new HttpHeaderDateFormat(null);
    }
  };
  private static final long serialVersionUID = -925286159755905325L;
  private final SimpleDateFormat format1 = new HttpHeaderDateFormatObsolete1();
  private final SimpleDateFormat format2 = new HttpHeaderDateFormatObsolete2();
  
  private HttpHeaderDateFormat()
  {
    super("E, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
    setTimeZone(TimeZone.getTimeZone("GMT"));
  }
  
  public static HttpHeaderDateFormat get()
  {
    return (HttpHeaderDateFormat)dateFormatThreadLocal.get();
  }
  
  public Date parse(String paramString, ParsePosition paramParsePosition)
  {
    Object localObject1 = super.parse(paramString, paramParsePosition);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.format1.parse(paramString, paramParsePosition);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.format2.parse(paramString, paramParsePosition);
    }
    return (Date)localObject1;
  }
  
  private static final class HttpHeaderDateFormatObsolete1
    extends SimpleDateFormat
  {
    private static final long serialVersionUID = -3178072504225114298L;
    
    HttpHeaderDateFormatObsolete1()
    {
      super(Locale.ENGLISH);
      setTimeZone(TimeZone.getTimeZone("GMT"));
    }
  }
  
  private static final class HttpHeaderDateFormatObsolete2
    extends SimpleDateFormat
  {
    private static final long serialVersionUID = 3010674519968303714L;
    
    HttpHeaderDateFormatObsolete2()
    {
      super(Locale.ENGLISH);
      setTimeZone(TimeZone.getTimeZone("GMT"));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpHeaderDateFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */