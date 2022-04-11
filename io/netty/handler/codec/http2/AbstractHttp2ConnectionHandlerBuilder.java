package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

public abstract class AbstractHttp2ConnectionHandlerBuilder<T extends Http2ConnectionHandler, B extends AbstractHttp2ConnectionHandlerBuilder<T, B>>
{
  private static final Http2HeadersEncoder.SensitivityDetector DEFAULT_HEADER_SENSITIVITY_DETECTOR = Http2HeadersEncoder.NEVER_SENSITIVE;
  private boolean autoAckPingFrame = true;
  private boolean autoAckSettingsFrame = true;
  private Http2Connection connection;
  private Http2ConnectionDecoder decoder;
  private boolean decoupleCloseAndGoAway;
  private Http2ConnectionEncoder encoder;
  private Boolean encoderEnforceMaxConcurrentStreams;
  private Boolean encoderIgnoreMaxHeaderListSize;
  private Http2FrameListener frameListener;
  private Http2FrameLogger frameLogger;
  private long gracefulShutdownTimeoutMillis = Http2CodecUtil.DEFAULT_GRACEFUL_SHUTDOWN_TIMEOUT_MILLIS;
  private Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector;
  private Http2Settings initialSettings = Http2Settings.defaultSettings();
  private Boolean isServer;
  private int maxConsecutiveEmptyFrames = 2;
  private int maxQueuedControlFrames = 10000;
  private Integer maxReservedStreams;
  private Http2PromisedRequestVerifier promisedRequestVerifier = Http2PromisedRequestVerifier.ALWAYS_VERIFY;
  private Boolean validateHeaders;
  
  private T buildFromCodec(Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2ConnectionEncoder paramHttp2ConnectionEncoder)
  {
    int i = decoderEnforceMaxConsecutiveEmptyDataFrames();
    Object localObject = paramHttp2ConnectionDecoder;
    if (i > 0) {
      localObject = new Http2EmptyDataFrameConnectionDecoder(paramHttp2ConnectionDecoder, i);
    }
    try
    {
      paramHttp2ConnectionDecoder = build((Http2ConnectionDecoder)localObject, paramHttp2ConnectionEncoder, this.initialSettings);
      paramHttp2ConnectionDecoder.gracefulShutdownTimeoutMillis(this.gracefulShutdownTimeoutMillis);
      if (paramHttp2ConnectionDecoder.decoder().frameListener() == null) {
        paramHttp2ConnectionDecoder.decoder().frameListener(this.frameListener);
      }
      return paramHttp2ConnectionDecoder;
    }
    finally
    {
      paramHttp2ConnectionEncoder.close();
      ((Http2ConnectionDecoder)localObject).close();
    }
  }
  
  private T buildFromConnection(Http2Connection paramHttp2Connection)
  {
    Object localObject1 = this.initialSettings.maxHeaderListSize();
    boolean bool = isValidateHeaders();
    long l;
    if (localObject1 == null) {
      l = 8192L;
    } else {
      l = ((Long)localObject1).longValue();
    }
    Object localObject2 = new DefaultHttp2FrameReader(new DefaultHttp2HeadersDecoder(bool, l, -1));
    if (this.encoderIgnoreMaxHeaderListSize == null) {
      localObject1 = new DefaultHttp2FrameWriter(headerSensitivityDetector());
    } else {
      localObject1 = new DefaultHttp2FrameWriter(headerSensitivityDetector(), this.encoderIgnoreMaxHeaderListSize.booleanValue());
    }
    Object localObject3 = this.frameLogger;
    if (localObject3 != null)
    {
      localObject2 = new Http2InboundFrameLogger((Http2FrameReader)localObject2, (Http2FrameLogger)localObject3);
      localObject1 = new Http2OutboundFrameLogger((Http2FrameWriter)localObject1, this.frameLogger);
    }
    localObject3 = new DefaultHttp2ConnectionEncoder(paramHttp2Connection, (Http2FrameWriter)localObject1);
    bool = encoderEnforceMaxConcurrentStreams();
    localObject1 = localObject3;
    if (this.maxQueuedControlFrames != 0) {
      localObject1 = new Http2ControlFrameLimitEncoder((Http2ConnectionEncoder)localObject3, this.maxQueuedControlFrames);
    }
    if (bool) {
      if (!paramHttp2Connection.isServer())
      {
        localObject1 = new StreamBufferingEncoder((Http2ConnectionEncoder)localObject1);
      }
      else
      {
        ((Http2FrameWriter)localObject1).close();
        ((Http2FrameReader)localObject2).close();
        paramHttp2Connection = new StringBuilder();
        paramHttp2Connection.append("encoderEnforceMaxConcurrentStreams: ");
        paramHttp2Connection.append(bool);
        paramHttp2Connection.append(" not supported for server");
        throw new IllegalArgumentException(paramHttp2Connection.toString());
      }
    }
    return buildFromCodec(new DefaultHttp2ConnectionDecoder(paramHttp2Connection, (Http2ConnectionEncoder)localObject1, (Http2FrameReader)localObject2, promisedRequestVerifier(), isAutoAckSettingsFrame(), isAutoAckPingFrame()), (Http2ConnectionEncoder)localObject1);
  }
  
  private static void enforceConstraint(String paramString1, String paramString2, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append(paramString1);
    ((StringBuilder)paramObject).append("() cannot be called because ");
    ((StringBuilder)paramObject).append(paramString2);
    ((StringBuilder)paramObject).append("() has been called already.");
    throw new IllegalStateException(((StringBuilder)paramObject).toString());
  }
  
  private void enforceNonCodecConstraints(String paramString)
  {
    enforceConstraint(paramString, "server/connection", this.decoder);
    enforceConstraint(paramString, "server/connection", this.encoder);
  }
  
  protected B autoAckPingFrame(boolean paramBoolean)
  {
    enforceNonCodecConstraints("autoAckPingFrame");
    this.autoAckPingFrame = paramBoolean;
    return self();
  }
  
  protected B autoAckSettingsFrame(boolean paramBoolean)
  {
    enforceNonCodecConstraints("autoAckSettingsFrame");
    this.autoAckSettingsFrame = paramBoolean;
    return self();
  }
  
  protected T build()
  {
    Object localObject = this.encoder;
    if (localObject != null) {
      return buildFromCodec(this.decoder, (Http2ConnectionEncoder)localObject);
    }
    Http2Connection localHttp2Connection = this.connection;
    localObject = localHttp2Connection;
    if (localHttp2Connection == null) {
      localObject = new DefaultHttp2Connection(isServer(), maxReservedStreams());
    }
    return buildFromConnection((Http2Connection)localObject);
  }
  
  protected abstract T build(Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2Settings paramHttp2Settings)
    throws Exception;
  
  protected B codec(Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2ConnectionEncoder paramHttp2ConnectionEncoder)
  {
    enforceConstraint("codec", "server", this.isServer);
    enforceConstraint("codec", "maxReservedStreams", this.maxReservedStreams);
    enforceConstraint("codec", "connection", this.connection);
    enforceConstraint("codec", "frameLogger", this.frameLogger);
    enforceConstraint("codec", "validateHeaders", this.validateHeaders);
    enforceConstraint("codec", "headerSensitivityDetector", this.headerSensitivityDetector);
    enforceConstraint("codec", "encoderEnforceMaxConcurrentStreams", this.encoderEnforceMaxConcurrentStreams);
    ObjectUtil.checkNotNull(paramHttp2ConnectionDecoder, "decoder");
    ObjectUtil.checkNotNull(paramHttp2ConnectionEncoder, "encoder");
    if (paramHttp2ConnectionDecoder.connection() == paramHttp2ConnectionEncoder.connection())
    {
      this.decoder = paramHttp2ConnectionDecoder;
      this.encoder = paramHttp2ConnectionEncoder;
      return self();
    }
    throw new IllegalArgumentException("The specified encoder and decoder have different connections.");
  }
  
  protected B connection(Http2Connection paramHttp2Connection)
  {
    enforceConstraint("connection", "maxReservedStreams", this.maxReservedStreams);
    enforceConstraint("connection", "server", this.isServer);
    enforceConstraint("connection", "codec", this.decoder);
    enforceConstraint("connection", "codec", this.encoder);
    this.connection = ((Http2Connection)ObjectUtil.checkNotNull(paramHttp2Connection, "connection"));
    return self();
  }
  
  protected Http2Connection connection()
  {
    return this.connection;
  }
  
  protected Http2ConnectionDecoder decoder()
  {
    return this.decoder;
  }
  
  protected int decoderEnforceMaxConsecutiveEmptyDataFrames()
  {
    return this.maxConsecutiveEmptyFrames;
  }
  
  protected B decoderEnforceMaxConsecutiveEmptyDataFrames(int paramInt)
  {
    enforceNonCodecConstraints("maxConsecutiveEmptyFrames");
    this.maxConsecutiveEmptyFrames = ObjectUtil.checkPositiveOrZero(paramInt, "maxConsecutiveEmptyFrames");
    return self();
  }
  
  protected B decoupleCloseAndGoAway(boolean paramBoolean)
  {
    this.decoupleCloseAndGoAway = paramBoolean;
    return self();
  }
  
  protected boolean decoupleCloseAndGoAway()
  {
    return this.decoupleCloseAndGoAway;
  }
  
  protected Http2ConnectionEncoder encoder()
  {
    return this.encoder;
  }
  
  protected B encoderEnforceMaxConcurrentStreams(boolean paramBoolean)
  {
    enforceNonCodecConstraints("encoderEnforceMaxConcurrentStreams");
    this.encoderEnforceMaxConcurrentStreams = Boolean.valueOf(paramBoolean);
    return self();
  }
  
  protected boolean encoderEnforceMaxConcurrentStreams()
  {
    Boolean localBoolean = this.encoderEnforceMaxConcurrentStreams;
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected int encoderEnforceMaxQueuedControlFrames()
  {
    return this.maxQueuedControlFrames;
  }
  
  protected B encoderEnforceMaxQueuedControlFrames(int paramInt)
  {
    enforceNonCodecConstraints("encoderEnforceMaxQueuedControlFrames");
    this.maxQueuedControlFrames = ObjectUtil.checkPositiveOrZero(paramInt, "maxQueuedControlFrames");
    return self();
  }
  
  protected B encoderIgnoreMaxHeaderListSize(boolean paramBoolean)
  {
    enforceNonCodecConstraints("encoderIgnoreMaxHeaderListSize");
    this.encoderIgnoreMaxHeaderListSize = Boolean.valueOf(paramBoolean);
    return self();
  }
  
  protected B frameListener(Http2FrameListener paramHttp2FrameListener)
  {
    this.frameListener = ((Http2FrameListener)ObjectUtil.checkNotNull(paramHttp2FrameListener, "frameListener"));
    return self();
  }
  
  protected Http2FrameListener frameListener()
  {
    return this.frameListener;
  }
  
  protected B frameLogger(Http2FrameLogger paramHttp2FrameLogger)
  {
    enforceNonCodecConstraints("frameLogger");
    this.frameLogger = ((Http2FrameLogger)ObjectUtil.checkNotNull(paramHttp2FrameLogger, "frameLogger"));
    return self();
  }
  
  protected Http2FrameLogger frameLogger()
  {
    return this.frameLogger;
  }
  
  protected long gracefulShutdownTimeoutMillis()
  {
    return this.gracefulShutdownTimeoutMillis;
  }
  
  protected B gracefulShutdownTimeoutMillis(long paramLong)
  {
    if (paramLong >= -1L)
    {
      this.gracefulShutdownTimeoutMillis = paramLong;
      return self();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gracefulShutdownTimeoutMillis: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" (expected: -1 for indefinite or >= 0)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  protected B headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector)
  {
    enforceNonCodecConstraints("headerSensitivityDetector");
    this.headerSensitivityDetector = ((Http2HeadersEncoder.SensitivityDetector)ObjectUtil.checkNotNull(paramSensitivityDetector, "headerSensitivityDetector"));
    return self();
  }
  
  protected Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector()
  {
    Http2HeadersEncoder.SensitivityDetector localSensitivityDetector = this.headerSensitivityDetector;
    if (localSensitivityDetector == null) {
      localSensitivityDetector = DEFAULT_HEADER_SENSITIVITY_DETECTOR;
    }
    return localSensitivityDetector;
  }
  
  @Deprecated
  protected B initialHuffmanDecodeCapacity(int paramInt)
  {
    return self();
  }
  
  protected B initialSettings(Http2Settings paramHttp2Settings)
  {
    this.initialSettings = ((Http2Settings)ObjectUtil.checkNotNull(paramHttp2Settings, "settings"));
    return self();
  }
  
  protected Http2Settings initialSettings()
  {
    return this.initialSettings;
  }
  
  protected boolean isAutoAckPingFrame()
  {
    return this.autoAckPingFrame;
  }
  
  protected boolean isAutoAckSettingsFrame()
  {
    return this.autoAckSettingsFrame;
  }
  
  protected boolean isServer()
  {
    Boolean localBoolean = this.isServer;
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected boolean isValidateHeaders()
  {
    Boolean localBoolean = this.validateHeaders;
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected int maxReservedStreams()
  {
    Integer localInteger = this.maxReservedStreams;
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    } else {
      i = 100;
    }
    return i;
  }
  
  protected B maxReservedStreams(int paramInt)
  {
    enforceConstraint("server", "connection", this.connection);
    enforceConstraint("server", "codec", this.decoder);
    enforceConstraint("server", "codec", this.encoder);
    this.maxReservedStreams = Integer.valueOf(ObjectUtil.checkPositiveOrZero(paramInt, "maxReservedStreams"));
    return self();
  }
  
  protected B promisedRequestVerifier(Http2PromisedRequestVerifier paramHttp2PromisedRequestVerifier)
  {
    enforceNonCodecConstraints("promisedRequestVerifier");
    this.promisedRequestVerifier = ((Http2PromisedRequestVerifier)ObjectUtil.checkNotNull(paramHttp2PromisedRequestVerifier, "promisedRequestVerifier"));
    return self();
  }
  
  protected Http2PromisedRequestVerifier promisedRequestVerifier()
  {
    return this.promisedRequestVerifier;
  }
  
  protected final B self()
  {
    return this;
  }
  
  protected B server(boolean paramBoolean)
  {
    enforceConstraint("server", "connection", this.connection);
    enforceConstraint("server", "codec", this.decoder);
    enforceConstraint("server", "codec", this.encoder);
    this.isServer = Boolean.valueOf(paramBoolean);
    return self();
  }
  
  protected B validateHeaders(boolean paramBoolean)
  {
    enforceNonCodecConstraints("validateHeaders");
    this.validateHeaders = Boolean.valueOf(paramBoolean);
    return self();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\AbstractHttp2ConnectionHandlerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */