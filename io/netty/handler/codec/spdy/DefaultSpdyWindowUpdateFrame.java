package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultSpdyWindowUpdateFrame
  implements SpdyWindowUpdateFrame
{
  private int deltaWindowSize;
  private int streamId;
  
  public DefaultSpdyWindowUpdateFrame(int paramInt1, int paramInt2)
  {
    setStreamId(paramInt1);
    setDeltaWindowSize(paramInt2);
  }
  
  public int deltaWindowSize()
  {
    return this.deltaWindowSize;
  }
  
  public SpdyWindowUpdateFrame setDeltaWindowSize(int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "deltaWindowSize");
    this.deltaWindowSize = paramInt;
    return this;
  }
  
  public SpdyWindowUpdateFrame setStreamId(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "streamId");
    this.streamId = paramInt;
    return this;
  }
  
  public int streamId()
  {
    return this.streamId;
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
    localStringBuilder.append("--> Delta-Window-Size = ");
    localStringBuilder.append(deltaWindowSize());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\DefaultSpdyWindowUpdateFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */