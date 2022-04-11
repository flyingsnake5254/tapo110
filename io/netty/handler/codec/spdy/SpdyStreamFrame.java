package io.netty.handler.codec.spdy;

public abstract interface SpdyStreamFrame
  extends a
{
  public abstract boolean isLast();
  
  public abstract SpdyStreamFrame setLast(boolean paramBoolean);
  
  public abstract SpdyStreamFrame setStreamId(int paramInt);
  
  public abstract int streamId();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyStreamFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */