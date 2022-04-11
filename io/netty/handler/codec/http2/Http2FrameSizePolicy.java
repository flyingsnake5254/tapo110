package io.netty.handler.codec.http2;

public abstract interface Http2FrameSizePolicy
{
  public abstract int maxFrameSize();
  
  public abstract void maxFrameSize(int paramInt)
    throws Http2Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2FrameSizePolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */