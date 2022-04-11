package io.netty.handler.codec.http2;

public final class HttpToHttp2ConnectionHandlerBuilder
  extends AbstractHttp2ConnectionHandlerBuilder<HttpToHttp2ConnectionHandler, HttpToHttp2ConnectionHandlerBuilder>
{
  public HttpToHttp2ConnectionHandler build()
  {
    return (HttpToHttp2ConnectionHandler)super.build();
  }
  
  protected HttpToHttp2ConnectionHandler build(Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2Settings paramHttp2Settings)
  {
    return new HttpToHttp2ConnectionHandler(paramHttp2ConnectionDecoder, paramHttp2ConnectionEncoder, paramHttp2Settings, isValidateHeaders(), decoupleCloseAndGoAway());
  }
  
  public HttpToHttp2ConnectionHandlerBuilder codec(Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2ConnectionEncoder paramHttp2ConnectionEncoder)
  {
    return (HttpToHttp2ConnectionHandlerBuilder)super.codec(paramHttp2ConnectionDecoder, paramHttp2ConnectionEncoder);
  }
  
  public HttpToHttp2ConnectionHandlerBuilder connection(Http2Connection paramHttp2Connection)
  {
    return (HttpToHttp2ConnectionHandlerBuilder)super.connection(paramHttp2Connection);
  }
  
  public HttpToHttp2ConnectionHandlerBuilder decoupleCloseAndGoAway(boolean paramBoolean)
  {
    return (HttpToHttp2ConnectionHandlerBuilder)super.decoupleCloseAndGoAway(paramBoolean);
  }
  
  public HttpToHttp2ConnectionHandlerBuilder encoderEnforceMaxConcurrentStreams(boolean paramBoolean)
  {
    return (HttpToHttp2ConnectionHandlerBuilder)super.encoderEnforceMaxConcurrentStreams(paramBoolean);
  }
  
  public HttpToHttp2ConnectionHandlerBuilder frameListener(Http2FrameListener paramHttp2FrameListener)
  {
    return (HttpToHttp2ConnectionHandlerBuilder)super.frameListener(paramHttp2FrameListener);
  }
  
  public HttpToHttp2ConnectionHandlerBuilder frameLogger(Http2FrameLogger paramHttp2FrameLogger)
  {
    return (HttpToHttp2ConnectionHandlerBuilder)super.frameLogger(paramHttp2FrameLogger);
  }
  
  public HttpToHttp2ConnectionHandlerBuilder gracefulShutdownTimeoutMillis(long paramLong)
  {
    return (HttpToHttp2ConnectionHandlerBuilder)super.gracefulShutdownTimeoutMillis(paramLong);
  }
  
  public HttpToHttp2ConnectionHandlerBuilder headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector)
  {
    return (HttpToHttp2ConnectionHandlerBuilder)super.headerSensitivityDetector(paramSensitivityDetector);
  }
  
  @Deprecated
  public HttpToHttp2ConnectionHandlerBuilder initialHuffmanDecodeCapacity(int paramInt)
  {
    return (HttpToHttp2ConnectionHandlerBuilder)super.initialHuffmanDecodeCapacity(paramInt);
  }
  
  public HttpToHttp2ConnectionHandlerBuilder initialSettings(Http2Settings paramHttp2Settings)
  {
    return (HttpToHttp2ConnectionHandlerBuilder)super.initialSettings(paramHttp2Settings);
  }
  
  public HttpToHttp2ConnectionHandlerBuilder server(boolean paramBoolean)
  {
    return (HttpToHttp2ConnectionHandlerBuilder)super.server(paramBoolean);
  }
  
  public HttpToHttp2ConnectionHandlerBuilder validateHeaders(boolean paramBoolean)
  {
    return (HttpToHttp2ConnectionHandlerBuilder)super.validateHeaders(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\HttpToHttp2ConnectionHandlerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */