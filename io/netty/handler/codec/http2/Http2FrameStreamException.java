package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

public final class Http2FrameStreamException
  extends Exception
{
  private static final long serialVersionUID = -4407186173493887044L;
  private final Http2Error error;
  private final Http2FrameStream stream;
  
  public Http2FrameStreamException(Http2FrameStream paramHttp2FrameStream, Http2Error paramHttp2Error, Throwable paramThrowable)
  {
    super(paramThrowable.getMessage(), paramThrowable);
    this.stream = ((Http2FrameStream)ObjectUtil.checkNotNull(paramHttp2FrameStream, "stream"));
    this.error = ((Http2Error)ObjectUtil.checkNotNull(paramHttp2Error, "error"));
  }
  
  public Http2Error error()
  {
    return this.error;
  }
  
  public Http2FrameStream stream()
  {
    return this.stream;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2FrameStreamException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */