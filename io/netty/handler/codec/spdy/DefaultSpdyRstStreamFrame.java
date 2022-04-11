package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;

public class DefaultSpdyRstStreamFrame
  extends DefaultSpdyStreamFrame
  implements SpdyRstStreamFrame
{
  private SpdyStreamStatus status;
  
  public DefaultSpdyRstStreamFrame(int paramInt1, int paramInt2)
  {
    this(paramInt1, SpdyStreamStatus.valueOf(paramInt2));
  }
  
  public DefaultSpdyRstStreamFrame(int paramInt, SpdyStreamStatus paramSpdyStreamStatus)
  {
    super(paramInt);
    setStatus(paramSpdyStreamStatus);
  }
  
  public SpdyRstStreamFrame setLast(boolean paramBoolean)
  {
    super.setLast(paramBoolean);
    return this;
  }
  
  public SpdyRstStreamFrame setStatus(SpdyStreamStatus paramSpdyStreamStatus)
  {
    this.status = paramSpdyStreamStatus;
    return this;
  }
  
  public SpdyRstStreamFrame setStreamId(int paramInt)
  {
    super.setStreamId(paramInt);
    return this;
  }
  
  public SpdyStreamStatus status()
  {
    return this.status;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    String str = StringUtil.NEWLINE;
    localStringBuilder.append(str);
    localStringBuilder.append("--> Stream-ID = ");
    localStringBuilder.append(streamId());
    localStringBuilder.append(str);
    localStringBuilder.append("--> Status: ");
    localStringBuilder.append(status());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\DefaultSpdyRstStreamFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */