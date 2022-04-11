package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DefaultHeaders.NameValidator;
import io.netty.util.AsciiString;
import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.Map.Entry;

public class DefaultLastHttpContent
  extends DefaultHttpContent
  implements LastHttpContent
{
  private final HttpHeaders trailingHeaders;
  private final boolean validateHeaders;
  
  public DefaultLastHttpContent()
  {
    this(Unpooled.buffer(0));
  }
  
  public DefaultLastHttpContent(ByteBuf paramByteBuf)
  {
    this(paramByteBuf, true);
  }
  
  public DefaultLastHttpContent(ByteBuf paramByteBuf, boolean paramBoolean)
  {
    super(paramByteBuf);
    this.trailingHeaders = new TrailingHttpHeaders(paramBoolean);
    this.validateHeaders = paramBoolean;
  }
  
  private void appendHeaders(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = trailingHeaders().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramStringBuilder.append((String)localEntry.getKey());
      paramStringBuilder.append(": ");
      paramStringBuilder.append((String)localEntry.getValue());
      paramStringBuilder.append(StringUtil.NEWLINE);
    }
  }
  
  public LastHttpContent copy()
  {
    return replace(content().copy());
  }
  
  public LastHttpContent duplicate()
  {
    return replace(content().duplicate());
  }
  
  public LastHttpContent replace(ByteBuf paramByteBuf)
  {
    paramByteBuf = new DefaultLastHttpContent(paramByteBuf, this.validateHeaders);
    paramByteBuf.trailingHeaders().set(trailingHeaders());
    return paramByteBuf;
  }
  
  public LastHttpContent retain()
  {
    super.retain();
    return this;
  }
  
  public LastHttpContent retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public LastHttpContent retainedDuplicate()
  {
    return replace(content().retainedDuplicate());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    String str = StringUtil.NEWLINE;
    localStringBuilder.append(str);
    appendHeaders(localStringBuilder);
    localStringBuilder.setLength(localStringBuilder.length() - str.length());
    return localStringBuilder.toString();
  }
  
  public LastHttpContent touch()
  {
    super.touch();
    return this;
  }
  
  public LastHttpContent touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
  
  public HttpHeaders trailingHeaders()
  {
    return this.trailingHeaders;
  }
  
  private static final class TrailingHttpHeaders
    extends DefaultHttpHeaders
  {
    private static final DefaultHeaders.NameValidator<CharSequence> TrailerNameValidator = new DefaultHeaders.NameValidator()
    {
      public void validateName(CharSequence paramAnonymousCharSequence)
      {
        DefaultHttpHeaders.HttpNameValidator.validateName(paramAnonymousCharSequence);
        if ((!HttpHeaderNames.CONTENT_LENGTH.contentEqualsIgnoreCase(paramAnonymousCharSequence)) && (!HttpHeaderNames.TRANSFER_ENCODING.contentEqualsIgnoreCase(paramAnonymousCharSequence)) && (!HttpHeaderNames.TRAILER.contentEqualsIgnoreCase(paramAnonymousCharSequence))) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("prohibited trailing header: ");
        localStringBuilder.append(paramAnonymousCharSequence);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    };
    
    TrailingHttpHeaders(boolean paramBoolean)
    {
      super(localNameValidator);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\DefaultLastHttpContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */