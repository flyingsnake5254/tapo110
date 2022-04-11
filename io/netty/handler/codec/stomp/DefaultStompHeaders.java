package io.netty.handler.codec.stomp;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.HeadersUtils;
import io.netty.util.AsciiString;
import io.netty.util.HashingStrategy;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class DefaultStompHeaders
  extends DefaultHeaders<CharSequence, CharSequence, StompHeaders>
  implements StompHeaders
{
  public DefaultStompHeaders()
  {
    super(AsciiString.CASE_SENSITIVE_HASHER, CharSequenceValueConverter.INSTANCE);
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
  
  public DefaultStompHeaders copy()
  {
    DefaultStompHeaders localDefaultStompHeaders = new DefaultStompHeaders();
    localDefaultStompHeaders.addImpl(this);
    return localDefaultStompHeaders;
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\stomp\DefaultStompHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */