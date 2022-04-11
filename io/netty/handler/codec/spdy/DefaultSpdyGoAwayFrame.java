package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultSpdyGoAwayFrame
  implements SpdyGoAwayFrame
{
  private int lastGoodStreamId;
  private SpdySessionStatus status;
  
  public DefaultSpdyGoAwayFrame(int paramInt)
  {
    this(paramInt, 0);
  }
  
  public DefaultSpdyGoAwayFrame(int paramInt1, int paramInt2)
  {
    this(paramInt1, SpdySessionStatus.valueOf(paramInt2));
  }
  
  public DefaultSpdyGoAwayFrame(int paramInt, SpdySessionStatus paramSpdySessionStatus)
  {
    setLastGoodStreamId(paramInt);
    setStatus(paramSpdySessionStatus);
  }
  
  public int lastGoodStreamId()
  {
    return this.lastGoodStreamId;
  }
  
  public SpdyGoAwayFrame setLastGoodStreamId(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "lastGoodStreamId");
    this.lastGoodStreamId = paramInt;
    return this;
  }
  
  public SpdyGoAwayFrame setStatus(SpdySessionStatus paramSpdySessionStatus)
  {
    this.status = paramSpdySessionStatus;
    return this;
  }
  
  public SpdySessionStatus status()
  {
    return this.status;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    String str = StringUtil.NEWLINE;
    localStringBuilder.append(str);
    localStringBuilder.append("--> Last-good-stream-ID = ");
    localStringBuilder.append(lastGoodStreamId());
    localStringBuilder.append(str);
    localStringBuilder.append("--> Status: ");
    localStringBuilder.append(status());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\DefaultSpdyGoAwayFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */