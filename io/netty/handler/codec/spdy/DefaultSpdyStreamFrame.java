package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;

public abstract class DefaultSpdyStreamFrame
  implements SpdyStreamFrame
{
  private boolean last;
  private int streamId;
  
  protected DefaultSpdyStreamFrame(int paramInt)
  {
    setStreamId(paramInt);
  }
  
  public boolean isLast()
  {
    return this.last;
  }
  
  public SpdyStreamFrame setLast(boolean paramBoolean)
  {
    this.last = paramBoolean;
    return this;
  }
  
  public SpdyStreamFrame setStreamId(int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "streamId");
    this.streamId = paramInt;
    return this;
  }
  
  public int streamId()
  {
    return this.streamId;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\DefaultSpdyStreamFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */