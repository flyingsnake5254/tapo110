package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.util.internal.ObjectUtil;

@Deprecated
public class Http2MultiplexCodecBuilder
  extends AbstractHttp2ConnectionHandlerBuilder<Http2MultiplexCodec, Http2MultiplexCodecBuilder>
{
  final ChannelHandler childHandler;
  private Http2FrameWriter frameWriter;
  private ChannelHandler upgradeStreamHandler;
  
  Http2MultiplexCodecBuilder(boolean paramBoolean, ChannelHandler paramChannelHandler)
  {
    server(paramBoolean);
    this.childHandler = checkSharable((ChannelHandler)ObjectUtil.checkNotNull(paramChannelHandler, "childHandler"));
    gracefulShutdownTimeoutMillis(0L);
  }
  
  private static ChannelHandler checkSharable(ChannelHandler paramChannelHandler)
  {
    if (((paramChannelHandler instanceof ChannelHandlerAdapter)) && (!((ChannelHandlerAdapter)paramChannelHandler).isSharable()) && (!paramChannelHandler.getClass().isAnnotationPresent(ChannelHandler.a.class))) {
      throw new IllegalArgumentException("The handler must be Sharable");
    }
    return paramChannelHandler;
  }
  
  public static Http2MultiplexCodecBuilder forClient(ChannelHandler paramChannelHandler)
  {
    return new Http2MultiplexCodecBuilder(false, paramChannelHandler);
  }
  
  public static Http2MultiplexCodecBuilder forServer(ChannelHandler paramChannelHandler)
  {
    return new Http2MultiplexCodecBuilder(true, paramChannelHandler);
  }
  
  public Http2MultiplexCodecBuilder autoAckPingFrame(boolean paramBoolean)
  {
    return (Http2MultiplexCodecBuilder)super.autoAckPingFrame(paramBoolean);
  }
  
  public Http2MultiplexCodecBuilder autoAckSettingsFrame(boolean paramBoolean)
  {
    return (Http2MultiplexCodecBuilder)super.autoAckSettingsFrame(paramBoolean);
  }
  
  public Http2MultiplexCodec build()
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
    return (Http2MultiplexCodec)super.build();
  }
  
  protected Http2MultiplexCodec build(Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2Settings paramHttp2Settings)
  {
    paramHttp2ConnectionDecoder = new Http2MultiplexCodec(paramHttp2ConnectionEncoder, paramHttp2ConnectionDecoder, paramHttp2Settings, this.childHandler, this.upgradeStreamHandler, decoupleCloseAndGoAway());
    paramHttp2ConnectionDecoder.gracefulShutdownTimeoutMillis(gracefulShutdownTimeoutMillis());
    return paramHttp2ConnectionDecoder;
  }
  
  public int decoderEnforceMaxConsecutiveEmptyDataFrames()
  {
    return super.decoderEnforceMaxConsecutiveEmptyDataFrames();
  }
  
  public Http2MultiplexCodecBuilder decoderEnforceMaxConsecutiveEmptyDataFrames(int paramInt)
  {
    return (Http2MultiplexCodecBuilder)super.decoderEnforceMaxConsecutiveEmptyDataFrames(paramInt);
  }
  
  public Http2MultiplexCodecBuilder decoupleCloseAndGoAway(boolean paramBoolean)
  {
    return (Http2MultiplexCodecBuilder)super.decoupleCloseAndGoAway(paramBoolean);
  }
  
  public Http2MultiplexCodecBuilder encoderEnforceMaxConcurrentStreams(boolean paramBoolean)
  {
    return (Http2MultiplexCodecBuilder)super.encoderEnforceMaxConcurrentStreams(paramBoolean);
  }
  
  public boolean encoderEnforceMaxConcurrentStreams()
  {
    return super.encoderEnforceMaxConcurrentStreams();
  }
  
  public int encoderEnforceMaxQueuedControlFrames()
  {
    return super.encoderEnforceMaxQueuedControlFrames();
  }
  
  public Http2MultiplexCodecBuilder encoderEnforceMaxQueuedControlFrames(int paramInt)
  {
    return (Http2MultiplexCodecBuilder)super.encoderEnforceMaxQueuedControlFrames(paramInt);
  }
  
  public Http2MultiplexCodecBuilder encoderIgnoreMaxHeaderListSize(boolean paramBoolean)
  {
    return (Http2MultiplexCodecBuilder)super.encoderIgnoreMaxHeaderListSize(paramBoolean);
  }
  
  public Http2FrameLogger frameLogger()
  {
    return super.frameLogger();
  }
  
  public Http2MultiplexCodecBuilder frameLogger(Http2FrameLogger paramHttp2FrameLogger)
  {
    return (Http2MultiplexCodecBuilder)super.frameLogger(paramHttp2FrameLogger);
  }
  
  Http2MultiplexCodecBuilder frameWriter(Http2FrameWriter paramHttp2FrameWriter)
  {
    this.frameWriter = ((Http2FrameWriter)ObjectUtil.checkNotNull(paramHttp2FrameWriter, "frameWriter"));
    return this;
  }
  
  public long gracefulShutdownTimeoutMillis()
  {
    return super.gracefulShutdownTimeoutMillis();
  }
  
  public Http2MultiplexCodecBuilder gracefulShutdownTimeoutMillis(long paramLong)
  {
    return (Http2MultiplexCodecBuilder)super.gracefulShutdownTimeoutMillis(paramLong);
  }
  
  public Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector()
  {
    return super.headerSensitivityDetector();
  }
  
  public Http2MultiplexCodecBuilder headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector)
  {
    return (Http2MultiplexCodecBuilder)super.headerSensitivityDetector(paramSensitivityDetector);
  }
  
  @Deprecated
  public Http2MultiplexCodecBuilder initialHuffmanDecodeCapacity(int paramInt)
  {
    return (Http2MultiplexCodecBuilder)super.initialHuffmanDecodeCapacity(paramInt);
  }
  
  public Http2MultiplexCodecBuilder initialSettings(Http2Settings paramHttp2Settings)
  {
    return (Http2MultiplexCodecBuilder)super.initialSettings(paramHttp2Settings);
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
  
  public Http2MultiplexCodecBuilder maxReservedStreams(int paramInt)
  {
    return (Http2MultiplexCodecBuilder)super.maxReservedStreams(paramInt);
  }
  
  public Http2MultiplexCodecBuilder validateHeaders(boolean paramBoolean)
  {
    return (Http2MultiplexCodecBuilder)super.validateHeaders(paramBoolean);
  }
  
  public Http2MultiplexCodecBuilder withUpgradeStreamHandler(ChannelHandler paramChannelHandler)
  {
    if (!isServer())
    {
      this.upgradeStreamHandler = paramChannelHandler;
      return this;
    }
    throw new IllegalArgumentException("Server codecs don't use an extra handler for the upgrade stream");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2MultiplexCodecBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */