package io.netty.handler.codec.spdy;

import io.netty.handler.codec.Headers;
import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.Map.Entry;

public class DefaultSpdyHeadersFrame
  extends DefaultSpdyStreamFrame
  implements SpdyHeadersFrame
{
  private final SpdyHeaders headers;
  private boolean invalid;
  private boolean truncated;
  
  public DefaultSpdyHeadersFrame(int paramInt)
  {
    this(paramInt, true);
  }
  
  public DefaultSpdyHeadersFrame(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.headers = new DefaultSpdyHeaders(paramBoolean);
  }
  
  protected void appendHeaders(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = headers().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramStringBuilder.append("    ");
      paramStringBuilder.append((CharSequence)localEntry.getKey());
      paramStringBuilder.append(": ");
      paramStringBuilder.append((CharSequence)localEntry.getValue());
      paramStringBuilder.append(StringUtil.NEWLINE);
    }
  }
  
  public SpdyHeaders headers()
  {
    return this.headers;
  }
  
  public boolean isInvalid()
  {
    return this.invalid;
  }
  
  public boolean isTruncated()
  {
    return this.truncated;
  }
  
  public SpdyHeadersFrame setInvalid()
  {
    this.invalid = true;
    return this;
  }
  
  public SpdyHeadersFrame setLast(boolean paramBoolean)
  {
    super.setLast(paramBoolean);
    return this;
  }
  
  public SpdyHeadersFrame setStreamId(int paramInt)
  {
    super.setStreamId(paramInt);
    return this;
  }
  
  public SpdyHeadersFrame setTruncated()
  {
    this.truncated = true;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(last: ");
    localStringBuilder.append(isLast());
    localStringBuilder.append(')');
    String str = StringUtil.NEWLINE;
    localStringBuilder.append(str);
    localStringBuilder.append("--> Stream-ID = ");
    localStringBuilder.append(streamId());
    localStringBuilder.append(str);
    localStringBuilder.append("--> Headers:");
    localStringBuilder.append(str);
    appendHeaders(localStringBuilder);
    localStringBuilder.setLength(localStringBuilder.length() - str.length());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\DefaultSpdyHeadersFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */