package io.netty.handler.codec.http2;

public class DefaultHttp2WindowUpdateFrame
  extends AbstractHttp2StreamFrame
  implements Http2WindowUpdateFrame
{
  private final int windowUpdateIncrement;
  
  public DefaultHttp2WindowUpdateFrame(int paramInt)
  {
    this.windowUpdateIncrement = paramInt;
  }
  
  public String name()
  {
    return "WINDOW_UPDATE";
  }
  
  public DefaultHttp2WindowUpdateFrame stream(Http2FrameStream paramHttp2FrameStream)
  {
    super.stream(paramHttp2FrameStream);
    return this;
  }
  
  public int windowSizeIncrement()
  {
    return this.windowUpdateIncrement;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2WindowUpdateFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */