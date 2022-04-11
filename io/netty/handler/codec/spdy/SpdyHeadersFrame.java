package io.netty.handler.codec.spdy;

public abstract interface SpdyHeadersFrame
  extends SpdyStreamFrame
{
  public abstract SpdyHeaders headers();
  
  public abstract boolean isInvalid();
  
  public abstract boolean isTruncated();
  
  public abstract SpdyHeadersFrame setInvalid();
  
  public abstract SpdyHeadersFrame setLast(boolean paramBoolean);
  
  public abstract SpdyHeadersFrame setStreamId(int paramInt);
  
  public abstract SpdyHeadersFrame setTruncated();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyHeadersFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */