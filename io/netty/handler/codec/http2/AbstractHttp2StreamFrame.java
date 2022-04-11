package io.netty.handler.codec.http2;

public abstract class AbstractHttp2StreamFrame
  implements Http2StreamFrame
{
  private Http2FrameStream stream;
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Http2StreamFrame;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Http2StreamFrame localHttp2StreamFrame = (Http2StreamFrame)paramObject;
    if (this.stream != localHttp2StreamFrame.stream())
    {
      paramObject = this.stream;
      bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (!paramObject.equals(localHttp2StreamFrame.stream())) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public int hashCode()
  {
    Http2FrameStream localHttp2FrameStream = this.stream;
    if (localHttp2FrameStream == null) {
      return super.hashCode();
    }
    return localHttp2FrameStream.hashCode();
  }
  
  public AbstractHttp2StreamFrame stream(Http2FrameStream paramHttp2FrameStream)
  {
    this.stream = paramHttp2FrameStream;
    return this;
  }
  
  public Http2FrameStream stream()
  {
    return this.stream;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\AbstractHttp2StreamFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */