package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.AttributeMap;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public class WebSocketServerProtocolHandler
  extends WebSocketProtocolHandler
{
  private static final AttributeKey<WebSocketServerHandshaker> HANDSHAKER_ATTR_KEY = AttributeKey.valueOf(WebSocketServerHandshaker.class, "HANDSHAKER");
  private final WebSocketServerProtocolConfig serverConfig;
  
  public WebSocketServerProtocolHandler(WebSocketServerProtocolConfig paramWebSocketServerProtocolConfig)
  {
    super(((WebSocketServerProtocolConfig)ObjectUtil.checkNotNull(paramWebSocketServerProtocolConfig, "serverConfig")).dropPongFrames(), paramWebSocketServerProtocolConfig.sendCloseFrame(), paramWebSocketServerProtocolConfig.forceCloseTimeoutMillis());
    this.serverConfig = paramWebSocketServerProtocolConfig;
  }
  
  public WebSocketServerProtocolHandler(String paramString)
  {
    this(paramString, 10000L);
  }
  
  public WebSocketServerProtocolHandler(String paramString, long paramLong)
  {
    this(paramString, false, paramLong);
  }
  
  public WebSocketServerProtocolHandler(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, 10000L);
  }
  
  public WebSocketServerProtocolHandler(String paramString1, String paramString2, long paramLong)
  {
    this(paramString1, paramString2, false, paramLong);
  }
  
  public WebSocketServerProtocolHandler(String paramString1, String paramString2, boolean paramBoolean)
  {
    this(paramString1, paramString2, paramBoolean, 10000L);
  }
  
  public WebSocketServerProtocolHandler(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    this(paramString1, paramString2, paramBoolean, paramInt, 10000L);
  }
  
  public WebSocketServerProtocolHandler(String paramString1, String paramString2, boolean paramBoolean, int paramInt, long paramLong)
  {
    this(paramString1, paramString2, paramBoolean, paramInt, false, paramLong);
  }
  
  public WebSocketServerProtocolHandler(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this(paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, 10000L);
  }
  
  public WebSocketServerProtocolHandler(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, long paramLong)
  {
    this(paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, false, paramLong);
  }
  
  public WebSocketServerProtocolHandler(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, paramBoolean3, 10000L);
  }
  
  public WebSocketServerProtocolHandler(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    this(paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, paramBoolean3, true, paramLong);
  }
  
  public WebSocketServerProtocolHandler(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this(paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, paramBoolean3, paramBoolean4, 10000L);
  }
  
  public WebSocketServerProtocolHandler(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, long paramLong)
  {
    this(paramString1, paramString2, paramBoolean3, paramBoolean4, paramLong, WebSocketDecoderConfig.newBuilder().maxFramePayloadLength(paramInt).allowMaskMismatch(paramBoolean2).allowExtensions(paramBoolean1).build());
  }
  
  public WebSocketServerProtocolHandler(String paramString1, String paramString2, boolean paramBoolean, long paramLong)
  {
    this(paramString1, paramString2, paramBoolean, 65536, paramLong);
  }
  
  public WebSocketServerProtocolHandler(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong, WebSocketDecoderConfig paramWebSocketDecoderConfig)
  {
    this(WebSocketServerProtocolConfig.newBuilder().websocketPath(paramString1).subprotocols(paramString2).checkStartsWith(paramBoolean1).handshakeTimeoutMillis(paramLong).dropPongFrames(paramBoolean2).decoderConfig(paramWebSocketDecoderConfig).build());
  }
  
  public WebSocketServerProtocolHandler(String paramString, boolean paramBoolean)
  {
    this(paramString, paramBoolean, 10000L);
  }
  
  public WebSocketServerProtocolHandler(String paramString, boolean paramBoolean, long paramLong)
  {
    this(paramString, null, false, 65536, false, paramBoolean, paramLong);
  }
  
  static WebSocketServerHandshaker getHandshaker(Channel paramChannel)
  {
    return (WebSocketServerHandshaker)paramChannel.attr(HANDSHAKER_ATTR_KEY).get();
  }
  
  static void setHandshaker(Channel paramChannel, WebSocketServerHandshaker paramWebSocketServerHandshaker)
  {
    paramChannel.attr(HANDSHAKER_ATTR_KEY).set(paramWebSocketServerHandshaker);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, WebSocketFrame paramWebSocketFrame, List<Object> paramList)
    throws Exception
  {
    if ((this.serverConfig.handleCloseFrames()) && ((paramWebSocketFrame instanceof CloseWebSocketFrame)))
    {
      paramList = getHandshaker(paramChannelHandlerContext.channel());
      if (paramList != null)
      {
        paramWebSocketFrame.retain();
        paramList.close(paramChannelHandlerContext.channel(), (CloseWebSocketFrame)paramWebSocketFrame);
      }
      else
      {
        paramChannelHandlerContext.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
      }
      return;
    }
    super.decode(paramChannelHandlerContext, paramWebSocketFrame, paramList);
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    if ((paramThrowable instanceof WebSocketHandshakeException))
    {
      paramThrowable = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST, Unpooled.wrappedBuffer(paramThrowable.getMessage().getBytes()));
      paramChannelHandlerContext.channel().writeAndFlush(paramThrowable).addListener(ChannelFutureListener.CLOSE);
    }
    else
    {
      paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
      paramChannelHandlerContext.close();
    }
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
  {
    ChannelPipeline localChannelPipeline = paramChannelHandlerContext.pipeline();
    if (localChannelPipeline.get(WebSocketServerProtocolHandshakeHandler.class) == null) {
      localChannelPipeline.addBefore(paramChannelHandlerContext.name(), WebSocketServerProtocolHandshakeHandler.class.getName(), new WebSocketServerProtocolHandshakeHandler(this.serverConfig));
    }
    if ((this.serverConfig.decoderConfig().withUTF8Validator()) && (localChannelPipeline.get(Utf8FrameValidator.class) == null)) {
      localChannelPipeline.addBefore(paramChannelHandlerContext.name(), Utf8FrameValidator.class.getName(), new Utf8FrameValidator());
    }
  }
  
  public static final class HandshakeComplete
  {
    private final HttpHeaders requestHeaders;
    private final String requestUri;
    private final String selectedSubprotocol;
    
    HandshakeComplete(String paramString1, HttpHeaders paramHttpHeaders, String paramString2)
    {
      this.requestUri = paramString1;
      this.requestHeaders = paramHttpHeaders;
      this.selectedSubprotocol = paramString2;
    }
    
    public HttpHeaders requestHeaders()
    {
      return this.requestHeaders;
    }
    
    public String requestUri()
    {
      return this.requestUri;
    }
    
    public String selectedSubprotocol()
    {
      return this.selectedSubprotocol;
    }
  }
  
  public static enum ServerHandshakeStateEvent
  {
    static
    {
      ServerHandshakeStateEvent localServerHandshakeStateEvent1 = new ServerHandshakeStateEvent("HANDSHAKE_COMPLETE", 0);
      HANDSHAKE_COMPLETE = localServerHandshakeStateEvent1;
      ServerHandshakeStateEvent localServerHandshakeStateEvent2 = new ServerHandshakeStateEvent("HANDSHAKE_TIMEOUT", 1);
      HANDSHAKE_TIMEOUT = localServerHandshakeStateEvent2;
      $VALUES = new ServerHandshakeStateEvent[] { localServerHandshakeStateEvent1, localServerHandshakeStateEvent2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketServerProtocolHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */