package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

public class Http2FrameCodecBuilder
  extends AbstractHttp2ConnectionHandlerBuilder<Http2FrameCodec, Http2FrameCodecBuilder>
{
  private Http2FrameWriter frameWriter;
  
  Http2FrameCodecBuilder(boolean paramBoolean)
  {
    server(paramBoolean);
    gracefulShutdownTimeoutMillis(0L);
  }
  
  public static Http2FrameCodecBuilder forClient()
  {
    return new Http2FrameCodecBuilder(false);
  }
  
  public static Http2FrameCodecBuilder forServer()
  {
    return new Http2FrameCodecBuilder(true);
  }
  
  public Http2FrameCodecBuilder autoAckPingFrame(boolean paramBoolean)
  {
    return (Http2FrameCodecBuilder)super.autoAckPingFrame(paramBoolean);
  }
  
  public Http2FrameCodecBuilder autoAckSettingsFrame(boolean paramBoolean)
  {
    return (Http2FrameCodecBuilder)super.autoAckSettingsFrame(paramBoolean);
  }
  
  public Http2FrameCodec build()
  {
    Object localObject1 = this.frameWriter;
    if (localObject1 != null)
    {
      Object localObject2 = new DefaultHttp2Connection(isServer(), maxReservedStreams());
      Object localObject3 = initialSettings().maxHeaderListSize();
      if (localObject3 == null) {
        localObject3 = new DefaultHttp2HeadersDecoder(isValidateHeaders());
      } else {
        localObject3 = new DefaultHttp2HeadersDecoder(isValidateHeaders(), ((Long)localObject3).longValue());
      }
      localObject3 = new DefaultHttp2FrameReader((Http2HeadersDecoder)localObject3);
      if (frameLogger() != null)
      {
        localObject1 = new Http2OutboundFrameLogger((Http2FrameWriter)localObject1, frameLogger());
        localObject3 = new Http2InboundFrameLogger((Http2FrameReader)localObject3, frameLogger());
      }
      localObject1 = new DefaultHttp2ConnectionEncoder((Http2Connection)localObject2, (Http2FrameWriter)localObject1);
      if (encoderEnforceMaxConcurrentStreams()) {
        localObject1 = new StreamBufferingEncoder((Http2ConnectionEncoder)localObject1);
      }
      localObject2 = new DefaultHttp2ConnectionDecoder((Http2Connection)localObject2, (Http2ConnectionEncoder)localObject1, (Http2FrameReader)localObject3, promisedRequestVerifier(), isAutoAckSettingsFrame(), isAutoAckPingFrame());
      int i = decoderEnforceMaxConsecutiveEmptyDataFrames();
      localObject3 = localObject2;
      if (i > 0) {
        localObject3 = new Http2EmptyDataFrameConnectionDecoder((Http2ConnectionDecoder)localObject2, i);
      }
      return build((Http2ConnectionDecoder)localObject3, (Http2ConnectionEncoder)localObject1, initialSettings());
    }
    return (Http2FrameCodec)super.build();
  }
  
  protected Http2FrameCodec build(Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2Settings paramHttp2Settings)
  {
    paramHttp2ConnectionDecoder = new Http2FrameCodec(paramHttp2ConnectionEncoder, paramHttp2ConnectionDecoder, paramHttp2Settings, decoupleCloseAndGoAway());
    paramHttp2ConnectionDecoder.gracefulShutdownTimeoutMillis(gracefulShutdownTimeoutMillis());
    return paramHttp2ConnectionDecoder;
  }
  
  public int decoderEnforceMaxConsecutiveEmptyDataFrames()
  {
    return super.decoderEnforceMaxConsecutiveEmptyDataFrames();
  }
  
  public Http2FrameCodecBuilder decoderEnforceMaxConsecutiveEmptyDataFrames(int paramInt)
  {
    return (Http2FrameCodecBuilder)super.decoderEnforceMaxConsecutiveEmptyDataFrames(paramInt);
  }
  
  public Http2FrameCodecBuilder decoupleCloseAndGoAway(boolean paramBoolean)
  {
    return (Http2FrameCodecBuilder)super.decoupleCloseAndGoAway(paramBoolean);
  }
  
  public Http2FrameCodecBuilder encoderEnforceMaxConcurrentStreams(boolean paramBoolean)
  {
    return (Http2FrameCodecBuilder)super.encoderEnforceMaxConcurrentStreams(paramBoolean);
  }
  
  public boolean encoderEnforceMaxConcurrentStreams()
  {
    return super.encoderEnforceMaxConcurrentStreams();
  }
  
  public int encoderEnforceMaxQueuedControlFrames()
  {
    return super.encoderEnforceMaxQueuedControlFrames();
  }
  
  public Http2FrameCodecBuilder encoderEnforceMaxQueuedControlFrames(int paramInt)
  {
    return (Http2FrameCodecBuilder)super.encoderEnforceMaxQueuedControlFrames(paramInt);
  }
  
  public Http2FrameCodecBuilder encoderIgnoreMaxHeaderListSize(boolean paramBoolean)
  {
    return (Http2FrameCodecBuilder)super.encoderIgnoreMaxHeaderListSize(paramBoolean);
  }
  
  public Http2FrameCodecBuilder frameLogger(Http2FrameLogger paramHttp2FrameLogger)
  {
    return (Http2FrameCodecBuilder)super.frameLogger(paramHttp2FrameLogger);
  }
  
  public Http2FrameLogger frameLogger()
  {
    return super.frameLogger();
  }
  
  Http2FrameCodecBuilder frameWriter(Http2FrameWriter paramHttp2FrameWriter)
  {
    this.frameWriter = ((Http2FrameWriter)ObjectUtil.checkNotNull(paramHttp2FrameWriter, "frameWriter"));
    return this;
  }
  
  public long gracefulShutdownTimeoutMillis()
  {
    return super.gracefulShutdownTimeoutMillis();
  }
  
  public Http2FrameCodecBuilder gracefulShutdownTimeoutMillis(long paramLong)
  {
    return (Http2FrameCodecBuilder)super.gracefulShutdownTimeoutMillis(paramLong);
  }
  
  public Http2FrameCodecBuilder headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector)
  {
    return (Http2FrameCodecBuilder)super.headerSensitivityDetector(paramSensitivityDetector);
  }
  
  public Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector()
  {
    return super.headerSensitivityDetector();
  }
  
  @Deprecated
  public Http2FrameCodecBuilder initialHuffmanDecodeCapacity(int paramInt)
  {
    return (Http2FrameCodecBuilder)super.initialHuffmanDecodeCapacity(paramInt);
  }
  
  public Http2FrameCodecBuilder initialSettings(Http2Settings paramHttp2Settings)
  {
    return (Http2FrameCodecBuilder)super.initialSettings(paramHttp2Settings);
  }
  
  public Http2Settings initialSettings()
  {
    return super.initialSettings();
  }
  
  public boolean isServer()
  {
    return super.isServer();
  }
  
  public boolean isValidateHeaders()
  {
    return super.isValidateHeaders();
  }
  
  public int maxReservedStreams()
  {
    return super.maxReservedStreams();
  }
  
  public Http2FrameCodecBuilder maxReservedStreams(int paramInt)
  {
    return (Http2FrameCodecBuilder)super.maxReservedStreams(paramInt);
  }
  
  public Http2FrameCodecBuilder validateHeaders(boolean paramBoolean)
  {
    return (Http2FrameCodecBuilder)super.validateHeaders(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2FrameCodecBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */