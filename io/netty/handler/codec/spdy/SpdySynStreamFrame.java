package io.netty.handler.codec.spdy;

public abstract interface SpdySynStreamFrame
  extends SpdyHeadersFrame
{
  public abstract int associatedStreamId();
  
  public abstract boolean isUnidirectional();
  
  public abstract byte priority();
  
  public abstract SpdySynStreamFrame setAssociatedStreamId(int paramInt);
  
  public abstract SpdySynStreamFrame setInvalid();
  
  public abstract SpdySynStreamFrame setLast(boolean paramBoolean);
  
  public abstract SpdySynStreamFrame setPriority(byte paramByte);
  
  public abstract SpdySynStreamFrame setStreamId(int paramInt);
  
  public abstract SpdySynStreamFrame setUnidirectional(boolean paramBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdySynStreamFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */