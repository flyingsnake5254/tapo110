package io.netty.handler.codec.http.websocketx;

import io.netty.util.internal.ObjectUtil;

public final class WebSocketServerProtocolConfig
{
  static final long DEFAULT_HANDSHAKE_TIMEOUT_MILLIS = 10000L;
  private final boolean checkStartsWith;
  private final WebSocketDecoderConfig decoderConfig;
  private final boolean dropPongFrames;
  private final long forceCloseTimeoutMillis;
  private final boolean handleCloseFrames;
  private final long handshakeTimeoutMillis;
  private final WebSocketCloseStatus sendCloseFrame;
  private final String subprotocols;
  private final String websocketPath;
  
  private WebSocketServerProtocolConfig(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, WebSocketCloseStatus paramWebSocketCloseStatus, boolean paramBoolean3, WebSocketDecoderConfig paramWebSocketDecoderConfig)
  {
    this.websocketPath = paramString1;
    this.subprotocols = paramString2;
    this.checkStartsWith = paramBoolean1;
    this.handshakeTimeoutMillis = ObjectUtil.checkPositive(paramLong1, "handshakeTimeoutMillis");
    this.forceCloseTimeoutMillis = paramLong2;
    this.handleCloseFrames = paramBoolean2;
    this.sendCloseFrame = paramWebSocketCloseStatus;
    this.dropPongFrames = paramBoolean3;
    paramString1 = paramWebSocketDecoderConfig;
    if (paramWebSocketDecoderConfig == null) {
      paramString1 = WebSocketDecoderConfig.DEFAULT;
    }
    this.decoderConfig = paramString1;
  }
  
  public static Builder newBuilder()
  {
    return new Builder("/", null, false, 10000L, 0L, true, WebSocketCloseStatus.NORMAL_CLOSURE, true, WebSocketDecoderConfig.DEFAULT, null);
  }
  
  public boolean checkStartsWith()
  {
    return this.checkStartsWith;
  }
  
  public WebSocketDecoderConfig decoderConfig()
  {
    return this.decoderConfig;
  }
  
  public boolean dropPongFrames()
  {
    return this.dropPongFrames;
  }
  
  public long forceCloseTimeoutMillis()
  {
    return this.forceCloseTimeoutMillis;
  }
  
  public boolean handleCloseFrames()
  {
    return this.handleCloseFrames;
  }
  
  public long handshakeTimeoutMillis()
  {
    return this.handshakeTimeoutMillis;
  }
  
  public WebSocketCloseStatus sendCloseFrame()
  {
    return this.sendCloseFrame;
  }
  
  public String subprotocols()
  {
    return this.subprotocols;
  }
  
  public Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebSocketServerProtocolConfig {websocketPath=");
    localStringBuilder.append(this.websocketPath);
    localStringBuilder.append(", subprotocols=");
    localStringBuilder.append(this.subprotocols);
    localStringBuilder.append(", checkStartsWith=");
    localStringBuilder.append(this.checkStartsWith);
    localStringBuilder.append(", handshakeTimeoutMillis=");
    localStringBuilder.append(this.handshakeTimeoutMillis);
    localStringBuilder.append(", forceCloseTimeoutMillis=");
    localStringBuilder.append(this.forceCloseTimeoutMillis);
    localStringBuilder.append(", handleCloseFrames=");
    localStringBuilder.append(this.handleCloseFrames);
    localStringBuilder.append(", sendCloseFrame=");
    localStringBuilder.append(this.sendCloseFrame);
    localStringBuilder.append(", dropPongFrames=");
    localStringBuilder.append(this.dropPongFrames);
    localStringBuilder.append(", decoderConfig=");
    localStringBuilder.append(this.decoderConfig);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public String websocketPath()
  {
    return this.websocketPath;
  }
  
  public static final class Builder
  {
    private boolean checkStartsWith;
    private WebSocketDecoderConfig decoderConfig;
    private WebSocketDecoderConfig.Builder decoderConfigBuilder;
    private boolean dropPongFrames;
    private long forceCloseTimeoutMillis;
    private boolean handleCloseFrames;
    private long handshakeTimeoutMillis;
    private WebSocketCloseStatus sendCloseFrame;
    private String subprotocols;
    private String websocketPath;
    
    private Builder(WebSocketServerProtocolConfig paramWebSocketServerProtocolConfig)
    {
      this(((WebSocketServerProtocolConfig)ObjectUtil.checkNotNull(paramWebSocketServerProtocolConfig, "serverConfig")).websocketPath(), paramWebSocketServerProtocolConfig.subprotocols(), paramWebSocketServerProtocolConfig.checkStartsWith(), paramWebSocketServerProtocolConfig.handshakeTimeoutMillis(), paramWebSocketServerProtocolConfig.forceCloseTimeoutMillis(), paramWebSocketServerProtocolConfig.handleCloseFrames(), paramWebSocketServerProtocolConfig.sendCloseFrame(), paramWebSocketServerProtocolConfig.dropPongFrames(), paramWebSocketServerProtocolConfig.decoderConfig());
    }
    
    private Builder(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, WebSocketCloseStatus paramWebSocketCloseStatus, boolean paramBoolean3, WebSocketDecoderConfig paramWebSocketDecoderConfig)
    {
      this.websocketPath = paramString1;
      this.subprotocols = paramString2;
      this.checkStartsWith = paramBoolean1;
      this.handshakeTimeoutMillis = paramLong1;
      this.forceCloseTimeoutMillis = paramLong2;
      this.handleCloseFrames = paramBoolean2;
      this.sendCloseFrame = paramWebSocketCloseStatus;
      this.dropPongFrames = paramBoolean3;
      this.decoderConfig = paramWebSocketDecoderConfig;
    }
    
    private WebSocketDecoderConfig.Builder decoderConfigBuilder()
    {
      if (this.decoderConfigBuilder == null) {
        this.decoderConfigBuilder = this.decoderConfig.toBuilder();
      }
      return this.decoderConfigBuilder;
    }
    
    public Builder allowExtensions(boolean paramBoolean)
    {
      decoderConfigBuilder().allowExtensions(paramBoolean);
      return this;
    }
    
    public Builder allowMaskMismatch(boolean paramBoolean)
    {
      decoderConfigBuilder().allowMaskMismatch(paramBoolean);
      return this;
    }
    
    public WebSocketServerProtocolConfig build()
    {
      String str1 = this.websocketPath;
      String str2 = this.subprotocols;
      boolean bool1 = this.checkStartsWith;
      long l1 = this.handshakeTimeoutMillis;
      long l2 = this.forceCloseTimeoutMillis;
      boolean bool2 = this.handleCloseFrames;
      WebSocketCloseStatus localWebSocketCloseStatus = this.sendCloseFrame;
      boolean bool3 = this.dropPongFrames;
      Object localObject = this.decoderConfigBuilder;
      if (localObject == null) {
        localObject = this.decoderConfig;
      } else {
        localObject = ((WebSocketDecoderConfig.Builder)localObject).build();
      }
      return new WebSocketServerProtocolConfig(str1, str2, bool1, l1, l2, bool2, localWebSocketCloseStatus, bool3, (WebSocketDecoderConfig)localObject, null);
    }
    
    public Builder checkStartsWith(boolean paramBoolean)
    {
      this.checkStartsWith = paramBoolean;
      return this;
    }
    
    public Builder closeOnProtocolViolation(boolean paramBoolean)
    {
      decoderConfigBuilder().closeOnProtocolViolation(paramBoolean);
      return this;
    }
    
    public Builder decoderConfig(WebSocketDecoderConfig paramWebSocketDecoderConfig)
    {
      WebSocketDecoderConfig localWebSocketDecoderConfig = paramWebSocketDecoderConfig;
      if (paramWebSocketDecoderConfig == null) {
        localWebSocketDecoderConfig = WebSocketDecoderConfig.DEFAULT;
      }
      this.decoderConfig = localWebSocketDecoderConfig;
      this.decoderConfigBuilder = null;
      return this;
    }
    
    public Builder dropPongFrames(boolean paramBoolean)
    {
      this.dropPongFrames = paramBoolean;
      return this;
    }
    
    public Builder expectMaskedFrames(boolean paramBoolean)
    {
      decoderConfigBuilder().expectMaskedFrames(paramBoolean);
      return this;
    }
    
    public Builder forceCloseTimeoutMillis(long paramLong)
    {
      this.forceCloseTimeoutMillis = paramLong;
      return this;
    }
    
    public Builder handleCloseFrames(boolean paramBoolean)
    {
      this.handleCloseFrames = paramBoolean;
      return this;
    }
    
    public Builder handshakeTimeoutMillis(long paramLong)
    {
      this.handshakeTimeoutMillis = paramLong;
      return this;
    }
    
    public Builder maxFramePayloadLength(int paramInt)
    {
      decoderConfigBuilder().maxFramePayloadLength(paramInt);
      return this;
    }
    
    public Builder sendCloseFrame(WebSocketCloseStatus paramWebSocketCloseStatus)
    {
      this.sendCloseFrame = paramWebSocketCloseStatus;
      return this;
    }
    
    public Builder subprotocols(String paramString)
    {
      this.subprotocols = paramString;
      return this;
    }
    
    public Builder websocketPath(String paramString)
    {
      this.websocketPath = paramString;
      return this;
    }
    
    public Builder withUTF8Validator(boolean paramBoolean)
    {
      decoderConfigBuilder().withUTF8Validator(paramBoolean);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketServerProtocolConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */