package io.netty.handler.codec.http2;

public abstract interface Http2StreamFrame
  extends Http2Frame
{
  public abstract Http2FrameStream stream();
  
  public abstract Http2StreamFrame stream(Http2FrameStream paramHttp2FrameStream);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2StreamFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */