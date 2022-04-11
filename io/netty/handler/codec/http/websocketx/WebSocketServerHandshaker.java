package io.netty.handler.codec.http.websocketx;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class WebSocketServerHandshaker
{
  public static final String SUB_PROTOCOL_WILDCARD = "*";
  protected static final InternalLogger logger = InternalLoggerFactory.getInstance(WebSocketServerHandshaker.class);
  private final WebSocketDecoderConfig decoderConfig;
  private String selectedSubprotocol;
  private final String[] subprotocols;
  private final String uri;
  private final WebSocketVersion version;
  
  protected WebSocketServerHandshaker(WebSocketVersion paramWebSocketVersion, String paramString1, String paramString2, int paramInt)
  {
    this(paramWebSocketVersion, paramString1, paramString2, WebSocketDecoderConfig.newBuilder().maxFramePayloadLength(paramInt).build());
  }
  
  protected WebSocketServerHandshaker(WebSocketVersion paramWebSocketVersion, String paramString1, String paramString2, WebSocketDecoderConfig paramWebSocketDecoderConfig)
  {
    this.version = paramWebSocketVersion;
    this.uri = paramString1;
    if (paramString2 != null)
    {
      paramWebSocketVersion = paramString2.split(",");
      for (int i = 0; i < paramWebSocketVersion.length; i++) {
        paramWebSocketVersion[i] = paramWebSocketVersion[i].trim();
      }
      this.subprotocols = paramWebSocketVersion;
    }
    else
    {
      this.subprotocols = EmptyArrays.EMPTY_STRINGS;
    }
    this.decoderConfig = ((WebSocketDecoderConfig)ObjectUtil.checkNotNull(paramWebSocketDecoderConfig, "decoderConfig"));
  }
  
  public ChannelFuture close(Channel paramChannel, CloseWebSocketFrame paramCloseWebSocketFrame)
  {
    ObjectUtil.checkNotNull(paramChannel, "channel");
    return close(paramChannel, paramCloseWebSocketFrame, paramChannel.newPromise());
  }
  
  public ChannelFuture close(Channel paramChannel, CloseWebSocketFrame paramCloseWebSocketFrame, ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramChannel, "channel");
    return paramChannel.writeAndFlush(paramCloseWebSocketFrame, paramChannelPromise).addListener(ChannelFutureListener.CLOSE);
  }
  
  public WebSocketDecoderConfig decoderConfig()
  {
    return this.decoderConfig;
  }
  
  public ChannelFuture handshake(Channel paramChannel, FullHttpRequest paramFullHttpRequest)
  {
    return handshake(paramChannel, paramFullHttpRequest, null, paramChannel.newPromise());
  }
  
  public final ChannelFuture handshake(Channel paramChannel, final FullHttpRequest paramFullHttpRequest, HttpHeaders paramHttpHeaders, final ChannelPromise paramChannelPromise)
  {
    Object localObject = logger;
    if (((InternalLogger)localObject).isDebugEnabled()) {
      ((InternalLogger)localObject).debug("{} WebSocket version {} server handshake", paramChannel, version());
    }
    paramHttpHeaders = newHandshakeResponse(paramFullHttpRequest, paramHttpHeaders);
    localObject = paramChannel.pipeline();
    if (((ChannelPipeline)localObject).get(HttpObjectAggregator.class) != null) {
      ((ChannelPipeline)localObject).remove(HttpObjectAggregator.class);
    }
    if (((ChannelPipeline)localObject).get(HttpContentCompressor.class) != null) {
      ((ChannelPipeline)localObject).remove(HttpContentCompressor.class);
    }
    paramFullHttpRequest = ((ChannelPipeline)localObject).context(HttpRequestDecoder.class);
    if (paramFullHttpRequest == null)
    {
      paramFullHttpRequest = ((ChannelPipeline)localObject).context(HttpServerCodec.class);
      if (paramFullHttpRequest == null)
      {
        paramChannelPromise.setFailure(new IllegalStateException("No HttpDecoder and no HttpServerCodec in the pipeline"));
        return paramChannelPromise;
      }
      ((ChannelPipeline)localObject).addBefore(paramFullHttpRequest.name(), "wsencoder", newWebSocketEncoder());
      ((ChannelPipeline)localObject).addBefore(paramFullHttpRequest.name(), "wsdecoder", newWebsocketDecoder());
      paramFullHttpRequest = paramFullHttpRequest.name();
    }
    else
    {
      ((ChannelPipeline)localObject).replace(paramFullHttpRequest.name(), "wsdecoder", newWebsocketDecoder());
      paramFullHttpRequest = ((ChannelPipeline)localObject).context(HttpResponseEncoder.class).name();
      ((ChannelPipeline)localObject).addBefore(paramFullHttpRequest, "wsencoder", newWebSocketEncoder());
    }
    paramChannel.writeAndFlush(paramHttpHeaders).addListener(new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        throws Exception
      {
        if (paramAnonymousChannelFuture.isSuccess())
        {
          paramAnonymousChannelFuture.channel().pipeline().remove(paramFullHttpRequest);
          paramChannelPromise.setSuccess();
        }
        else
        {
          paramChannelPromise.setFailure(paramAnonymousChannelFuture.cause());
        }
      }
    });
    return paramChannelPromise;
  }
  
  public ChannelFuture handshake(Channel paramChannel, HttpRequest paramHttpRequest)
  {
    return handshake(paramChannel, paramHttpRequest, null, paramChannel.newPromise());
  }
  
  /* Error */
  public final ChannelFuture handshake(final Channel paramChannel, HttpRequest paramHttpRequest, final HttpHeaders paramHttpHeaders, final ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 220
    //   4: ifeq +16 -> 20
    //   7: aload_0
    //   8: aload_1
    //   9: aload_2
    //   10: checkcast 220	io/netty/handler/codec/http/FullHttpRequest
    //   13: aload_3
    //   14: aload 4
    //   16: invokevirtual 122	io/netty/handler/codec/http/websocketx/WebSocketServerHandshaker:handshake	(Lio/netty/channel/Channel;Lio/netty/handler/codec/http/FullHttpRequest;Lio/netty/handler/codec/http/HttpHeaders;Lio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelFuture;
    //   19: areturn
    //   20: getstatic 32	io/netty/handler/codec/http/websocketx/WebSocketServerHandshaker:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   23: astore 5
    //   25: aload 5
    //   27: invokeinterface 128 1 0
    //   32: ifeq +17 -> 49
    //   35: aload 5
    //   37: ldc -126
    //   39: aload_1
    //   40: aload_0
    //   41: invokevirtual 133	io/netty/handler/codec/http/websocketx/WebSocketServerHandshaker:version	()Lio/netty/handler/codec/http/websocketx/WebSocketVersion;
    //   44: invokeinterface 137 4 0
    //   49: aload_1
    //   50: invokeinterface 147 1 0
    //   55: astore 6
    //   57: aload 6
    //   59: ldc -94
    //   61: invokeinterface 166 2 0
    //   66: astore 7
    //   68: aload 7
    //   70: astore 5
    //   72: aload 7
    //   74: ifnonnull +43 -> 117
    //   77: aload 6
    //   79: ldc -88
    //   81: invokeinterface 166 2 0
    //   86: astore 7
    //   88: aload 7
    //   90: astore 5
    //   92: aload 7
    //   94: ifnonnull +23 -> 117
    //   97: aload 4
    //   99: new 170	java/lang/IllegalStateException
    //   102: dup
    //   103: ldc -84
    //   105: invokespecial 175	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   108: invokeinterface 181 2 0
    //   113: pop
    //   114: aload 4
    //   116: areturn
    //   117: aload 6
    //   119: aload 5
    //   121: invokeinterface 186 1 0
    //   126: ldc -34
    //   128: new 149	io/netty/handler/codec/http/HttpObjectAggregator
    //   131: dup
    //   132: sipush 8192
    //   135: invokespecial 225	io/netty/handler/codec/http/HttpObjectAggregator:<init>	(I)V
    //   138: invokeinterface 228 4 0
    //   143: pop
    //   144: aload 6
    //   146: ldc -34
    //   148: ldc -26
    //   150: new 8	io/netty/handler/codec/http/websocketx/WebSocketServerHandshaker$2
    //   153: dup
    //   154: aload_0
    //   155: aload_1
    //   156: aload_3
    //   157: aload 4
    //   159: invokespecial 233	io/netty/handler/codec/http/websocketx/WebSocketServerHandshaker$2:<init>	(Lio/netty/handler/codec/http/websocketx/WebSocketServerHandshaker;Lio/netty/channel/Channel;Lio/netty/handler/codec/http/HttpHeaders;Lio/netty/channel/ChannelPromise;)V
    //   162: invokeinterface 228 4 0
    //   167: pop
    //   168: aload 5
    //   170: aload_2
    //   171: invokestatic 239	io/netty/util/ReferenceCountUtil:retain	(Ljava/lang/Object;)Ljava/lang/Object;
    //   174: invokeinterface 243 2 0
    //   179: pop
    //   180: goto +13 -> 193
    //   183: astore_1
    //   184: aload 4
    //   186: aload_1
    //   187: invokeinterface 181 2 0
    //   192: pop
    //   193: aload 4
    //   195: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	WebSocketServerHandshaker
    //   0	196	1	paramChannel	Channel
    //   0	196	2	paramHttpRequest	HttpRequest
    //   0	196	3	paramHttpHeaders	HttpHeaders
    //   0	196	4	paramChannelPromise	ChannelPromise
    //   23	146	5	localObject	Object
    //   55	90	6	localChannelPipeline	ChannelPipeline
    //   66	27	7	localChannelHandlerContext	ChannelHandlerContext
    // Exception table:
    //   from	to	target	type
    //   168	180	183	finally
  }
  
  public int maxFramePayloadLength()
  {
    return this.decoderConfig.maxFramePayloadLength();
  }
  
  protected abstract FullHttpResponse newHandshakeResponse(FullHttpRequest paramFullHttpRequest, HttpHeaders paramHttpHeaders);
  
  protected abstract b newWebSocketEncoder();
  
  protected abstract a newWebsocketDecoder();
  
  protected String selectSubprotocol(String paramString)
  {
    if ((paramString != null) && (this.subprotocols.length != 0))
    {
      String[] arrayOfString1 = paramString.split(",");
      int i = arrayOfString1.length;
      for (int j = 0; j < i; j++)
      {
        String str = arrayOfString1[j].trim();
        String[] arrayOfString2 = this.subprotocols;
        int k = arrayOfString2.length;
        int m = 0;
        while (m < k)
        {
          paramString = arrayOfString2[m];
          if ((!"*".equals(paramString)) && (!str.equals(paramString)))
          {
            m++;
          }
          else
          {
            this.selectedSubprotocol = str;
            return str;
          }
        }
      }
    }
    return null;
  }
  
  public String selectedSubprotocol()
  {
    return this.selectedSubprotocol;
  }
  
  public Set<String> subprotocols()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Collections.addAll(localLinkedHashSet, this.subprotocols);
    return localLinkedHashSet;
  }
  
  public String uri()
  {
    return this.uri;
  }
  
  public WebSocketVersion version()
  {
    return this.version;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketServerHandshaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */