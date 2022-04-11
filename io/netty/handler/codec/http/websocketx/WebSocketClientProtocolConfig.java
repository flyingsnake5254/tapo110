package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.internal.ObjectUtil;
import java.net.URI;

public final class WebSocketClientProtocolConfig
{
  static final boolean DEFAULT_ALLOW_MASK_MISMATCH = false;
  static final boolean DEFAULT_DROP_PONG_FRAMES = true;
  static final boolean DEFAULT_HANDLE_CLOSE_FRAMES = true;
  static final boolean DEFAULT_PERFORM_MASKING = true;
  private final boolean absoluteUpgradeUrl;
  private final boolean allowExtensions;
  private final boolean allowMaskMismatch;
  private final HttpHeaders customHeaders;
  private final boolean dropPongFrames;
  private final long forceCloseTimeoutMillis;
  private final boolean handleCloseFrames;
  private final long handshakeTimeoutMillis;
  private final int maxFramePayloadLength;
  private final boolean performMasking;
  private final WebSocketCloseStatus sendCloseFrame;
  private final String subprotocol;
  private final WebSocketVersion version;
  private final URI webSocketUri;
  
  private WebSocketClientProtocolConfig(URI paramURI, String paramString, WebSocketVersion paramWebSocketVersion, boolean paramBoolean1, HttpHeaders paramHttpHeaders, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, WebSocketCloseStatus paramWebSocketCloseStatus, boolean paramBoolean5, long paramLong1, long paramLong2, boolean paramBoolean6)
  {
    this.webSocketUri = paramURI;
    this.subprotocol = paramString;
    this.version = paramWebSocketVersion;
    this.allowExtensions = paramBoolean1;
    this.customHeaders = paramHttpHeaders;
    this.maxFramePayloadLength = paramInt;
    this.performMasking = paramBoolean2;
    this.allowMaskMismatch = paramBoolean3;
    this.forceCloseTimeoutMillis = paramLong2;
    this.handleCloseFrames = paramBoolean4;
    this.sendCloseFrame = paramWebSocketCloseStatus;
    this.dropPongFrames = paramBoolean5;
    this.handshakeTimeoutMillis = ObjectUtil.checkPositive(paramLong1, "handshakeTimeoutMillis");
    this.absoluteUpgradeUrl = paramBoolean6;
  }
  
  public static Builder newBuilder()
  {
    return new Builder(URI.create("https://localhost/"), null, WebSocketVersion.V13, false, EmptyHttpHeaders.INSTANCE, 65536, true, false, true, WebSocketCloseStatus.NORMAL_CLOSURE, true, 10000L, -1L, false, null);
  }
  
  public boolean absoluteUpgradeUrl()
  {
    return this.absoluteUpgradeUrl;
  }
  
  public boolean allowExtensions()
  {
    return this.allowExtensions;
  }
  
  public boolean allowMaskMismatch()
  {
    return this.allowMaskMismatch;
  }
  
  public HttpHeaders customHeaders()
  {
    return this.customHeaders;
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
  
  public int maxFramePayloadLength()
  {
    return this.maxFramePayloadLength;
  }
  
  public boolean performMasking()
  {
    return this.performMasking;
  }
  
  public WebSocketCloseStatus sendCloseFrame()
  {
    return this.sendCloseFrame;
  }
  
  public String subprotocol()
  {
    return this.subprotocol;
  }
  
  public Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebSocketClientProtocolConfig {webSocketUri=");
    localStringBuilder.append(this.webSocketUri);
    localStringBuilder.append(", subprotocol=");
    localStringBuilder.append(this.subprotocol);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", allowExtensions=");
    localStringBuilder.append(this.allowExtensions);
    localStringBuilder.append(", customHeaders=");
    localStringBuilder.append(this.customHeaders);
    localStringBuilder.append(", maxFramePayloadLength=");
    localStringBuilder.append(this.maxFramePayloadLength);
    localStringBuilder.append(", performMasking=");
    localStringBuilder.append(this.performMasking);
    localStringBuilder.append(", allowMaskMismatch=");
    localStringBuilder.append(this.allowMaskMismatch);
    localStringBuilder.append(", handleCloseFrames=");
    localStringBuilder.append(this.handleCloseFrames);
    localStringBuilder.append(", sendCloseFrame=");
    localStringBuilder.append(this.sendCloseFrame);
    localStringBuilder.append(", dropPongFrames=");
    localStringBuilder.append(this.dropPongFrames);
    localStringBuilder.append(", handshakeTimeoutMillis=");
    localStringBuilder.append(this.handshakeTimeoutMillis);
    localStringBuilder.append(", forceCloseTimeoutMillis=");
    localStringBuilder.append(this.forceCloseTimeoutMillis);
    localStringBuilder.append(", absoluteUpgradeUrl=");
    localStringBuilder.append(this.absoluteUpgradeUrl);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public WebSocketVersion version()
  {
    return this.version;
  }
  
  public URI webSocketUri()
  {
    return this.webSocketUri;
  }
  
  public static final class Builder
  {
    private boolean absoluteUpgradeUrl;
    private boolean allowExtensions;
    private boolean allowMaskMismatch;
    private HttpHeaders customHeaders;
    private boolean dropPongFrames;
    private long forceCloseTimeoutMillis;
    private boolean handleCloseFrames;
    private long handshakeTimeoutMillis;
    private int maxFramePayloadLength;
    private boolean performMasking;
    private WebSocketCloseStatus sendCloseFrame;
    private String subprotocol;
    private WebSocketVersion version;
    private URI webSocketUri;
    
    private Builder(WebSocketClientProtocolConfig paramWebSocketClientProtocolConfig)
    {
      this(((WebSocketClientProtocolConfig)ObjectUtil.checkNotNull(paramWebSocketClientProtocolConfig, "clientConfig")).webSocketUri(), paramWebSocketClientProtocolConfig.subprotocol(), paramWebSocketClientProtocolConfig.version(), paramWebSocketClientProtocolConfig.allowExtensions(), paramWebSocketClientProtocolConfig.customHeaders(), paramWebSocketClientProtocolConfig.maxFramePayloadLength(), paramWebSocketClientProtocolConfig.performMasking(), paramWebSocketClientProtocolConfig.allowMaskMismatch(), paramWebSocketClientProtocolConfig.handleCloseFrames(), paramWebSocketClientProtocolConfig.sendCloseFrame(), paramWebSocketClientProtocolConfig.dropPongFrames(), paramWebSocketClientProtocolConfig.handshakeTimeoutMillis(), paramWebSocketClientProtocolConfig.forceCloseTimeoutMillis(), paramWebSocketClientProtocolConfig.absoluteUpgradeUrl());
    }
    
    private Builder(URI paramURI, String paramString, WebSocketVersion paramWebSocketVersion, boolean paramBoolean1, HttpHeaders paramHttpHeaders, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, WebSocketCloseStatus paramWebSocketCloseStatus, boolean paramBoolean5, long paramLong1, long paramLong2, boolean paramBoolean6)
    {
      this.webSocketUri = paramURI;
      this.subprotocol = paramString;
      this.version = paramWebSocketVersion;
      this.allowExtensions = paramBoolean1;
      this.customHeaders = paramHttpHeaders;
      this.maxFramePayloadLength = paramInt;
      this.performMasking = paramBoolean2;
      this.allowMaskMismatch = paramBoolean3;
      this.handleCloseFrames = paramBoolean4;
      this.sendCloseFrame = paramWebSocketCloseStatus;
      this.dropPongFrames = paramBoolean5;
      this.handshakeTimeoutMillis = paramLong1;
      this.forceCloseTimeoutMillis = paramLong2;
      this.absoluteUpgradeUrl = paramBoolean6;
    }
    
    public Builder absoluteUpgradeUrl(boolean paramBoolean)
    {
      this.absoluteUpgradeUrl = paramBoolean;
      return this;
    }
    
    public Builder allowExtensions(boolean paramBoolean)
    {
      this.allowExtensions = paramBoolean;
      return this;
    }
    
    public Builder allowMaskMismatch(boolean paramBoolean)
    {
      this.allowMaskMismatch = paramBoolean;
      return this;
    }
    
    public WebSocketClientProtocolConfig build()
    {
      return new WebSocketClientProtocolConfig(this.webSocketUri, this.subprotocol, this.version, this.allowExtensions, this.customHeaders, this.maxFramePayloadLength, this.performMasking, this.allowMaskMismatch, this.handleCloseFrames, this.sendCloseFrame, this.dropPongFrames, this.handshakeTimeoutMillis, this.forceCloseTimeoutMillis, this.absoluteUpgradeUrl, null);
    }
    
    public Builder customHeaders(HttpHeaders paramHttpHeaders)
    {
      this.customHeaders = paramHttpHeaders;
      return this;
    }
    
    public Builder dropPongFrames(boolean paramBoolean)
    {
      this.dropPongFrames = paramBoolean;
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
      this.maxFramePayloadLength = paramInt;
      return this;
    }
    
    public Builder performMasking(boolean paramBoolean)
    {
      this.performMasking = paramBoolean;
      return this;
    }
    
    public Builder sendCloseFrame(WebSocketCloseStatus paramWebSocketCloseStatus)
    {
      this.sendCloseFrame = paramWebSocketCloseStatus;
      return this;
    }
    
    public Builder subprotocol(String paramString)
    {
      this.subprotocol = paramString;
      return this;
    }
    
    public Builder version(WebSocketVersion paramWebSocketVersion)
    {
      this.version = paramWebSocketVersion;
      return this;
    }
    
    public Builder webSocketUri(String paramString)
    {
      return webSocketUri(URI.create(paramString));
    }
    
    public Builder webSocketUri(URI paramURI)
    {
      this.webSocketUri = paramURI;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketClientProtocolConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */