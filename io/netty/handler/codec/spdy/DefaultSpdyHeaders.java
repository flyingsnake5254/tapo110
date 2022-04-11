package io.netty.handler.codec.spdy;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.DefaultHeaders.NameValidator;
import io.netty.handler.codec.HeadersUtils;
import io.netty.handler.codec.ValueConverter;
import io.netty.util.AsciiString;
import io.netty.util.HashingStrategy;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class DefaultSpdyHeaders
  extends DefaultHeaders<CharSequence, CharSequence, SpdyHeaders>
  implements SpdyHeaders
{
  private static final DefaultHeaders.NameValidator<CharSequence> SpdyNameValidator = new DefaultHeaders.NameValidator()
  {
    public void validateName(CharSequence paramAnonymousCharSequence)
    {
      SpdyCodecUtil.validateHeaderName(paramAnonymousCharSequence);
    }
  };
  
  public DefaultSpdyHeaders()
  {
    this(true);
  }
  
  public DefaultSpdyHeaders(boolean paramBoolean)
  {
    super(localHashingStrategy, (ValueConverter)localObject, localNameValidator);
  }
  
  public boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return contains(paramCharSequence1, paramCharSequence2, false);
  }
  
  public boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    HashingStrategy localHashingStrategy;
    if (paramBoolean) {
      localHashingStrategy = AsciiString.CASE_INSENSITIVE_HASHER;
    } else {
      localHashingStrategy = AsciiString.CASE_SENSITIVE_HASHER;
    }
    return contains(paramCharSequence1, paramCharSequence2, localHashingStrategy);
  }
  
  public List<String> getAllAsString(CharSequence paramCharSequence)
  {
    return HeadersUtils.getAllAsString(this, paramCharSequence);
  }
  
  public String getAsString(CharSequence paramCharSequence)
  {
    return HeadersUtils.getAsString(this, paramCharSequence);
  }
  
  public Iterator<Map.Entry<String, String>> iteratorAsString()
  {
    return HeadersUtils.iteratorAsString(this);
  }
  
  private static final class HeaderValueConverterAndValidator
    extends CharSequenceValueConverter
  {
    public static final HeaderValueConverterAndValidator INSTANCE = new HeaderValueConverterAndValidator();
    
    public CharSequence convertObject(Object paramObject)
    {
      paramObject = super.convertObject(paramObject);
      SpdyCodecUtil.validateHeaderValue((CharSequence)paramObject);
      return (CharSequence)paramObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\DefaultSpdyHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */