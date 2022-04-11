package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;

public class DefaultSpdySynReplyFrame
  extends DefaultSpdyHeadersFrame
  implements SpdySynReplyFrame
{
  public DefaultSpdySynReplyFrame(int paramInt)
  {
    super(paramInt);
  }
  
  public DefaultSpdySynReplyFrame(int paramInt, boolean paramBoolean)
  {
    super(paramInt, paramBoolean);
  }
  
  public SpdySynReplyFrame setInvalid()
  {
    super.setInvalid();
    return this;
  }
  
  public SpdySynReplyFrame setLast(boolean paramBoolean)
  {
    super.setLast(paramBoolean);
    return this;
  }
  
  public SpdySynReplyFrame setStreamId(int paramInt)
  {
    super.setStreamId(paramInt);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\DefaultSpdySynReplyFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */