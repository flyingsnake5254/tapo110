package io.netty.handler.codec.spdy;

public abstract interface SpdyWindowUpdateFrame
  extends a
{
  public abstract int deltaWindowSize();
  
  public abstract SpdyWindowUpdateFrame setDeltaWindowSize(int paramInt);
  
  public abstract SpdyWindowUpdateFrame setStreamId(int paramInt);
  
  public abstract int streamId();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyWindowUpdateFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */