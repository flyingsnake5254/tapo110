package io.netty.handler.codec.spdy;

public abstract interface SpdySynReplyFrame
  extends SpdyHeadersFrame
{
  public abstract SpdySynReplyFrame setInvalid();
  
  public abstract SpdySynReplyFrame setLast(boolean paramBoolean);
  
  public abstract SpdySynReplyFrame setStreamId(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdySynReplyFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */