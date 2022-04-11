package io.netty.handler.codec.spdy;

public abstract interface SpdyGoAwayFrame
  extends a
{
  public abstract int lastGoodStreamId();
  
  public abstract SpdyGoAwayFrame setLastGoodStreamId(int paramInt);
  
  public abstract SpdyGoAwayFrame setStatus(SpdySessionStatus paramSpdySessionStatus);
  
  public abstract SpdySessionStatus status();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyGoAwayFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */