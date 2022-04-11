package io.netty.handler.codec.spdy;

public abstract interface SpdyRstStreamFrame
  extends SpdyStreamFrame
{
  public abstract SpdyRstStreamFrame setLast(boolean paramBoolean);
  
  public abstract SpdyRstStreamFrame setStatus(SpdyStreamStatus paramSpdyStreamStatus);
  
  public abstract SpdyRstStreamFrame setStreamId(int paramInt);
  
  public abstract SpdyStreamStatus status();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyRstStreamFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */