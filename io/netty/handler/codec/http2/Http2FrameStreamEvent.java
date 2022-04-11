package io.netty.handler.codec.http2;

public final class Http2FrameStreamEvent
{
  private final Http2FrameStream stream;
  private final Type type;
  
  private Http2FrameStreamEvent(Http2FrameStream paramHttp2FrameStream, Type paramType)
  {
    this.stream = paramHttp2FrameStream;
    this.type = paramType;
  }
  
  static Http2FrameStreamEvent stateChanged(Http2FrameStream paramHttp2FrameStream)
  {
    return new Http2FrameStreamEvent(paramHttp2FrameStream, Type.State);
  }
  
  static Http2FrameStreamEvent writabilityChanged(Http2FrameStream paramHttp2FrameStream)
  {
    return new Http2FrameStreamEvent(paramHttp2FrameStream, Type.Writability);
  }
  
  public Http2FrameStream stream()
  {
    return this.stream;
  }
  
  public Type type()
  {
    return this.type;
  }
  
  static enum Type
  {
    static
    {
      Type localType1 = new Type("State", 0);
      State = localType1;
      Type localType2 = new Type("Writability", 1);
      Writability = localType2;
      $VALUES = new Type[] { localType1, localType2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2FrameStreamEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */