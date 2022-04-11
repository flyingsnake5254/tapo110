package io.netty.handler.codec.http.websocketx;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.internal.ObjectUtil;
import java.net.URI;
import java.util.List;

public class WebSocketClientProtocolHandler
  extends WebSocketProtocolHandler
{
  private final WebSocketClientProtocolConfig clientConfig;
  private final WebSocketClientHandshaker handshaker;
  
  public WebSocketClientProtocolHandler(WebSocketClientHandshaker paramWebSocketClientHandshaker)
  {
    this(paramWebSocketClientHandshaker, 10000L);
  }
  
  public WebSocketClientProtocolHandler(WebSocketClientHandshaker paramWebSocketClientHandshaker, long paramLong)
  {
    this(paramWebSocketClientHandshaker, true, paramLong);
  }
  
  public WebSocketClientProtocolHandler(WebSocketClientHandshaker paramWebSocketClientHandshaker, boolean paramBoolean)
  {
    this(paramWebSocketClientHandshaker, paramBoolean, 10000L);
  }
  
  public WebSocketClientProtocolHandler(WebSocketClientHandshaker paramWebSocketClientHandshaker, boolean paramBoolean, long paramLong)
  {
    this(paramWebSocketClientHandshaker, paramBoolean, true, paramLong);
  }
  
  public WebSocketClientProtocolHandler(WebSocketClientHandshaker paramWebSocketClientHandshaker, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramWebSocketClientHandshaker, paramBoolean1, paramBoolean2, 10000L);
  }
  
  public WebSocketClientProtocolHandler(WebSocketClientHandshaker paramWebSocketClientHandshaker, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    super(paramBoolean2);
    this.handshaker = paramWebSocketClientHandshaker;
    this.clientConfig = WebSocketClientProtocolConfig.newBuilder().handleCloseFrames(paramBoolean1).handshakeTimeoutMillis(paramLong).build();
  }
  
  public WebSocketClientProtocolHandler(WebSocketClientProtocolConfig paramWebSocketClientProtocolConfig)
  {
    super(((WebSocketClientProtocolConfig)ObjectUtil.checkNotNull(paramWebSocketClientProtocolConfig, "clientConfig")).dropPongFrames(), paramWebSocketClientProtocolConfig.sendCloseFrame(), paramWebSocketClientProtocolConfig.forceCloseTimeoutMillis());
    this.handshaker = WebSocketClientHandshakerFactory.newHandshaker(paramWebSocketClientProtocolConfig.webSocketUri(), paramWebSocketClientProtocolConfig.version(), paramWebSocketClientProtocolConfig.subprotocol(), paramWebSocketClientProtocolConfig.allowExtensions(), paramWebSocketClientProtocolConfig.customHeaders(), paramWebSocketClientProtocolConfig.maxFramePayloadLength(), paramWebSocketClientProtocolConfig.performMasking(), paramWebSocketClientProtocolConfig.allowMaskMismatch(), paramWebSocketClientProtocolConfig.forceCloseTimeoutMillis(), paramWebSocketClientProtocolConfig.absoluteUpgradeUrl());
    this.clientConfig = paramWebSocketClientProtocolConfig;
  }
  
  public WebSocketClientProtocolHandler(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean, HttpHeaders paramHttpHeaders, int paramInt)
  {
    this(paramURI, paramWebSocketVersion, paramString, paramBoolean, paramHttpHeaders, paramInt, 10000L);
  }
  
  public WebSocketClientProtocolHandler(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean, HttpHeaders paramHttpHeaders, int paramInt, long paramLong)
  {
    this(paramURI, paramWebSocketVersion, paramString, paramBoolean, paramHttpHeaders, paramInt, true, paramLong);
  }
  
  public WebSocketClientProtocolHandler(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean1, HttpHeaders paramHttpHeaders, int paramInt, boolean paramBoolean2)
  {
    this(paramURI, paramWebSocketVersion, paramString, paramBoolean1, paramHttpHeaders, paramInt, paramBoolean2, 10000L);
  }
  
  public WebSocketClientProtocolHandler(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean1, HttpHeaders paramHttpHeaders, int paramInt, boolean paramBoolean2, long paramLong)
  {
    this(paramURI, paramWebSocketVersion, paramString, paramBoolean1, paramHttpHeaders, paramInt, paramBoolean2, true, false, paramLong);
  }
  
  public WebSocketClientProtocolHandler(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean1, HttpHeaders paramHttpHeaders, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this(paramURI, paramWebSocketVersion, paramString, paramBoolean1, paramHttpHeaders, paramInt, paramBoolean2, paramBoolean3, paramBoolean4, 10000L);
  }
  
  public WebSocketClientProtocolHandler(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean1, HttpHeaders paramHttpHeaders, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, long paramLong)
  {
    this(WebSocketClientHandshakerFactory.newHandshaker(paramURI, paramWebSocketVersion, paramString, paramBoolean1, paramHttpHeaders, paramInt, paramBoolean3, paramBoolean4), paramBoolean2, paramLong);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, WebSocketFrame paramWebSocketFrame, List<Object> paramList)
    throws Exception
  {
    if ((this.clientConfig.handleCloseFrames()) && ((paramWebSocketFrame instanceof CloseWebSocketFrame)))
    {
      paramChannelHandlerContext.close();
      return;
    }
    super.decode(paramChannelHandlerContext, paramWebSocketFrame, paramList);
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
  {
    ChannelPipeline localChannelPipeline = paramChannelHandlerContext.pipeline();
    if (localChannelPipeline.get(WebSocketClientProtocolHandshakeHandler.class) == null) {
      paramChannelHandlerContext.pipeline().addBefore(paramChannelHandlerContext.name(), WebSocketClientProtocolHandshakeHandler.class.getName(), new WebSocketClientProtocolHandshakeHandler(this.handshaker, this.clientConfig.handshakeTimeoutMillis()));
    }
    if (localChannelPipeline.get(Utf8FrameValidator.class) == null) {
      paramChannelHandlerContext.pipeline().addBefore(paramChannelHandlerContext.name(), Utf8FrameValidator.class.getName(), new Utf8FrameValidator());
    }
  }
  
  public WebSocketClientHandshaker handshaker()
  {
    return this.handshaker;
  }
  
  public static enum ClientHandshakeStateEvent
  {
    static
    {
      ClientHandshakeStateEvent localClientHandshakeStateEvent1 = new ClientHandshakeStateEvent("HANDSHAKE_TIMEOUT", 0);
      HANDSHAKE_TIMEOUT = localClientHandshakeStateEvent1;
      ClientHandshakeStateEvent localClientHandshakeStateEvent2 = new ClientHandshakeStateEvent("HANDSHAKE_ISSUED", 1);
      HANDSHAKE_ISSUED = localClientHandshakeStateEvent2;
      ClientHandshakeStateEvent localClientHandshakeStateEvent3 = new ClientHandshakeStateEvent("HANDSHAKE_COMPLETE", 2);
      HANDSHAKE_COMPLETE = localClientHandshakeStateEvent3;
      $VALUES = new ClientHandshakeStateEvent[] { localClientHandshakeStateEvent1, localClientHandshakeStateEvent2, localClientHandshakeStateEvent3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketClientProtocolHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */