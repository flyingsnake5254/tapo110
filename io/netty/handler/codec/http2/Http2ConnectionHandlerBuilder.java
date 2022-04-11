package io.netty.handler.codec.http2;

public final class Http2ConnectionHandlerBuilder
  extends AbstractHttp2ConnectionHandlerBuilder<Http2ConnectionHandler, Http2ConnectionHandlerBuilder>
{
  public Http2ConnectionHandler build()
  {
    return super.build();
  }
  
  protected Http2ConnectionHandler build(Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2Settings paramHttp2Settings)
  {
    return new Http2ConnectionHandler(paramHttp2ConnectionDecoder, paramHttp2ConnectionEncoder, paramHttp2Settings, decoupleCloseAndGoAway());
  }
  
  public Http2ConnectionHandlerBuilder codec(Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2ConnectionEncoder paramHttp2ConnectionEncoder)
  {
    return (Http2ConnectionHandlerBuilder)super.codec(paramHttp2ConnectionDecoder, paramHttp2ConnectionEncoder);
  }
  
  public Http2ConnectionHandlerBuilder connection(Http2Connection paramHttp2Connection)
  {
    return (Http2ConnectionHandlerBuilder)super.connection(paramHttp2Connection);
  }
  
  public Http2ConnectionHandlerBuilder decoupleCloseAndGoAway(boolean paramBoolean)
  {
    return (Http2ConnectionHandlerBuilder)super.decoupleCloseAndGoAway(paramBoolean);
  }
  
  public Http2ConnectionHandlerBuilder encoderEnforceMaxConcurrentStreams(boolean paramBoolean)
  {
    return (Http2ConnectionHandlerBuilder)super.encoderEnforceMaxConcurrentStreams(paramBoolean);
  }
  
  public Http2ConnectionHandlerBuilder encoderIgnoreMaxHeaderListSize(boolean paramBoolean)
  {
    return (Http2ConnectionHandlerBuilder)super.encoderIgnoreMaxHeaderListSize(paramBoolean);
  }
  
  public Http2ConnectionHandlerBuilder frameListener(Http2FrameListener paramHttp2FrameListener)
  {
    return (Http2ConnectionHandlerBuilder)super.frameListener(paramHttp2FrameListener);
  }
  
  public Http2ConnectionHandlerBuilder frameLogger(Http2FrameLogger paramHttp2FrameLogger)
  {
    return (Http2ConnectionHandlerBuilder)super.frameLogger(paramHttp2FrameLogger);
  }
  
  public Http2ConnectionHandlerBuilder gracefulShutdownTimeoutMillis(long paramLong)
  {
    return (Http2ConnectionHandlerBuilder)super.gracefulShutdownTimeoutMillis(paramLong);
  }
  
  public Http2ConnectionHandlerBuilder headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector)
  {
    return (Http2ConnectionHandlerBuilder)super.headerSensitivityDetector(paramSensitivityDetector);
  }
  
  @Deprecated
  public Http2ConnectionHandlerBuilder initialHuffmanDecodeCapacity(int paramInt)
  {
    return (Http2ConnectionHandlerBuilder)super.initialHuffmanDecodeCapacity(paramInt);
  }
  
  public Http2ConnectionHandlerBuilder initialSettings(Http2Settings paramHttp2Settings)
  {
    return (Http2ConnectionHandlerBuilder)super.initialSettings(paramHttp2Settings);
  }
  
  public Http2ConnectionHandlerBuilder maxReservedStreams(int paramInt)
  {
    return (Http2ConnectionHandlerBuilder)super.maxReservedStreams(paramInt);
  }
  
  public Http2ConnectionHandlerBuilder server(boolean paramBoolean)
  {
    return (Http2ConnectionHandlerBuilder)super.server(paramBoolean);
  }
  
  public Http2ConnectionHandlerBuilder validateHeaders(boolean paramBoolean)
  {
    return (Http2ConnectionHandlerBuilder)super.validateHeaders(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2ConnectionHandlerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */