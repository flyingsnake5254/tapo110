package io.netty.handler.codec.http.websocketx;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.util.AsciiString;
import io.netty.util.NetUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.net.URI;
import java.nio.channels.ClosedChannelException;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class WebSocketClientHandshaker
{
  protected static final int DEFAULT_FORCE_CLOSE_TIMEOUT_MILLIS = 10000;
  private static final AtomicIntegerFieldUpdater<WebSocketClientHandshaker> FORCE_CLOSE_INIT_UPDATER = AtomicIntegerFieldUpdater.newUpdater(WebSocketClientHandshaker.class, "forceCloseInit");
  private static final String HTTPS_SCHEME_PREFIX;
  private static final String HTTP_SCHEME_PREFIX;
  private final boolean absoluteUpgradeUrl;
  private volatile String actualSubprotocol;
  protected final HttpHeaders customHeaders;
  private final String expectedSubprotocol;
  private volatile boolean forceCloseComplete;
  private volatile int forceCloseInit;
  private volatile long forceCloseTimeoutMillis = 10000L;
  private volatile boolean handshakeComplete;
  private final int maxFramePayloadLength;
  private final URI uri;
  private final WebSocketVersion version;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HttpScheme.HTTP);
    localStringBuilder.append("://");
    HTTP_SCHEME_PREFIX = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(HttpScheme.HTTPS);
    localStringBuilder.append("://");
    HTTPS_SCHEME_PREFIX = localStringBuilder.toString();
  }
  
  protected WebSocketClientHandshaker(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, HttpHeaders paramHttpHeaders, int paramInt)
  {
    this(paramURI, paramWebSocketVersion, paramString, paramHttpHeaders, paramInt, 10000L);
  }
  
  protected WebSocketClientHandshaker(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, HttpHeaders paramHttpHeaders, int paramInt, long paramLong)
  {
    this(paramURI, paramWebSocketVersion, paramString, paramHttpHeaders, paramInt, paramLong, false);
  }
  
  protected WebSocketClientHandshaker(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, HttpHeaders paramHttpHeaders, int paramInt, long paramLong, boolean paramBoolean)
  {
    this.uri = paramURI;
    this.version = paramWebSocketVersion;
    this.expectedSubprotocol = paramString;
    this.customHeaders = paramHttpHeaders;
    this.maxFramePayloadLength = paramInt;
    this.forceCloseTimeoutMillis = paramLong;
    this.absoluteUpgradeUrl = paramBoolean;
  }
  
  private void applyForceCloseTimeout(final Channel paramChannel, ChannelFuture paramChannelFuture)
  {
    final long l = this.forceCloseTimeoutMillis;
    if ((l > 0L) && (paramChannel.isActive()) && (this.forceCloseInit == 0)) {
      paramChannelFuture.addListener(new ChannelFutureListener()
      {
        public void operationComplete(final ChannelFuture paramAnonymousChannelFuture)
          throws Exception
        {
          if ((paramAnonymousChannelFuture.isSuccess()) && (paramChannel.isActive()) && (WebSocketClientHandshaker.FORCE_CLOSE_INIT_UPDATER.compareAndSet(jdField_this, 0, 1)))
          {
            paramAnonymousChannelFuture = paramChannel.eventLoop().schedule(new Runnable()
            {
              public void run()
              {
                if (WebSocketClientHandshaker.5.this.val$channel.isActive())
                {
                  WebSocketClientHandshaker.5.this.val$channel.close();
                  WebSocketClientHandshaker.access$102(WebSocketClientHandshaker.this, true);
                }
              }
            }, l, TimeUnit.MILLISECONDS);
            paramChannel.closeFuture().addListener(new ChannelFutureListener()
            {
              public void operationComplete(ChannelFuture paramAnonymous2ChannelFuture)
                throws Exception
              {
                paramAnonymousChannelFuture.cancel(false);
              }
            });
          }
        }
      });
    }
  }
  
  private void setActualSubprotocol(String paramString)
  {
    this.actualSubprotocol = paramString;
  }
  
  private void setHandshakeComplete()
  {
    this.handshakeComplete = true;
  }
  
  static CharSequence websocketHostValue(URI paramURI)
  {
    int i = paramURI.getPort();
    if (i == -1) {
      return paramURI.getHost();
    }
    String str1 = paramURI.getHost();
    String str2 = paramURI.getScheme();
    HttpScheme localHttpScheme = HttpScheme.HTTP;
    if (i == localHttpScheme.port())
    {
      paramURI = str1;
      if (!localHttpScheme.name().contentEquals(str2)) {
        if (WebSocketScheme.WS.name().contentEquals(str2)) {
          paramURI = str1;
        } else {
          paramURI = NetUtil.toSocketAddressString(str1, i);
        }
      }
      return paramURI;
    }
    localHttpScheme = HttpScheme.HTTPS;
    if (i == localHttpScheme.port())
    {
      paramURI = str1;
      if (!localHttpScheme.name().contentEquals(str2)) {
        if (WebSocketScheme.WSS.name().contentEquals(str2)) {
          paramURI = str1;
        } else {
          paramURI = NetUtil.toSocketAddressString(str1, i);
        }
      }
      return paramURI;
    }
    return NetUtil.toSocketAddressString(str1, i);
  }
  
  static CharSequence websocketOriginValue(URI paramURI)
  {
    String str = paramURI.getScheme();
    int i = paramURI.getPort();
    Object localObject = WebSocketScheme.WSS;
    int j;
    if ((!((WebSocketScheme)localObject).name().contentEquals(str)) && (!HttpScheme.HTTPS.name().contentEquals(str)) && ((str != null) || (i != ((WebSocketScheme)localObject).port())))
    {
      str = HTTP_SCHEME_PREFIX;
      j = WebSocketScheme.WS.port();
    }
    else
    {
      str = HTTPS_SCHEME_PREFIX;
      j = ((WebSocketScheme)localObject).port();
    }
    paramURI = paramURI.getHost().toLowerCase(Locale.US);
    if ((i != j) && (i != -1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(NetUtil.toSocketAddressString(paramURI, i));
      return ((StringBuilder)localObject).toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(paramURI);
    return ((StringBuilder)localObject).toString();
  }
  
  public String actualSubprotocol()
  {
    return this.actualSubprotocol;
  }
  
  public ChannelFuture close(Channel paramChannel, CloseWebSocketFrame paramCloseWebSocketFrame)
  {
    ObjectUtil.checkNotNull(paramChannel, "channel");
    return close(paramChannel, paramCloseWebSocketFrame, paramChannel.newPromise());
  }
  
  public ChannelFuture close(Channel paramChannel, CloseWebSocketFrame paramCloseWebSocketFrame, ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramChannel, "channel");
    paramChannel.writeAndFlush(paramCloseWebSocketFrame, paramChannelPromise);
    applyForceCloseTimeout(paramChannel, paramChannelPromise);
    return paramChannelPromise;
  }
  
  public String expectedSubprotocol()
  {
    return this.expectedSubprotocol;
  }
  
  public final void finishHandshake(Channel paramChannel, final FullHttpResponse paramFullHttpResponse)
  {
    verify(paramFullHttpResponse);
    paramFullHttpResponse = paramFullHttpResponse.headers().get(HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL);
    if (paramFullHttpResponse != null) {
      paramFullHttpResponse = paramFullHttpResponse.trim();
    } else {
      paramFullHttpResponse = null;
    }
    final Object localObject = this.expectedSubprotocol;
    if (localObject == null) {
      localObject = "";
    }
    int i;
    if ((((String)localObject).isEmpty()) && (paramFullHttpResponse == null))
    {
      setActualSubprotocol(this.expectedSubprotocol);
      i = 1;
    }
    else
    {
      if ((!((String)localObject).isEmpty()) && (paramFullHttpResponse != null) && (!paramFullHttpResponse.isEmpty()))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        for (i = 0;; i++)
        {
          if (i >= j) {
            break label140;
          }
          if (localObject[i].trim().equals(paramFullHttpResponse))
          {
            setActualSubprotocol(paramFullHttpResponse);
            break;
          }
        }
      }
      label140:
      i = 0;
    }
    if (i != 0)
    {
      setHandshakeComplete();
      paramFullHttpResponse = paramChannel.pipeline();
      localObject = (HttpContentDecompressor)paramFullHttpResponse.get(HttpContentDecompressor.class);
      if (localObject != null) {
        paramFullHttpResponse.remove((ChannelHandler)localObject);
      }
      localObject = (HttpObjectAggregator)paramFullHttpResponse.get(HttpObjectAggregator.class);
      if (localObject != null) {
        paramFullHttpResponse.remove((ChannelHandler)localObject);
      }
      localObject = paramFullHttpResponse.context(HttpResponseDecoder.class);
      if (localObject == null)
      {
        localObject = paramFullHttpResponse.context(HttpClientCodec.class);
        if (localObject != null)
        {
          final HttpClientCodec localHttpClientCodec = (HttpClientCodec)((ChannelHandlerContext)localObject).handler();
          localHttpClientCodec.removeOutboundHandler();
          paramFullHttpResponse.addAfter(((ChannelHandlerContext)localObject).name(), "ws-decoder", newWebsocketDecoder());
          paramChannel.eventLoop().execute(new Runnable()
          {
            public void run()
            {
              paramFullHttpResponse.remove(localHttpClientCodec);
            }
          });
        }
        else
        {
          throw new IllegalStateException("ChannelPipeline does not contain an HttpRequestEncoder or HttpClientCodec");
        }
      }
      else
      {
        if (paramFullHttpResponse.get(HttpRequestEncoder.class) != null) {
          paramFullHttpResponse.remove(HttpRequestEncoder.class);
        }
        paramFullHttpResponse.addAfter(((ChannelHandlerContext)localObject).name(), "ws-decoder", newWebsocketDecoder());
        paramChannel.eventLoop().execute(new Runnable()
        {
          public void run()
          {
            paramFullHttpResponse.remove(localObject.handler());
          }
        });
      }
      return;
    }
    throw new WebSocketHandshakeException(String.format("Invalid subprotocol. Actual: %s. Expected one of: %s", new Object[] { paramFullHttpResponse, this.expectedSubprotocol }));
  }
  
  public long forceCloseTimeoutMillis()
  {
    return this.forceCloseTimeoutMillis;
  }
  
  public ChannelFuture handshake(Channel paramChannel)
  {
    ObjectUtil.checkNotNull(paramChannel, "channel");
    return handshake(paramChannel, paramChannel.newPromise());
  }
  
  public final ChannelFuture handshake(Channel paramChannel, final ChannelPromise paramChannelPromise)
  {
    ChannelPipeline localChannelPipeline = paramChannel.pipeline();
    if (((HttpResponseDecoder)localChannelPipeline.get(HttpResponseDecoder.class) == null) && ((HttpClientCodec)localChannelPipeline.get(HttpClientCodec.class) == null))
    {
      paramChannelPromise.setFailure(new IllegalStateException("ChannelPipeline does not contain an HttpResponseDecoder or HttpClientCodec"));
      return paramChannelPromise;
    }
    paramChannel.writeAndFlush(newHandshakeRequest()).addListener(new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
      {
        if (paramAnonymousChannelFuture.isSuccess())
        {
          ChannelPipeline localChannelPipeline = paramAnonymousChannelFuture.channel().pipeline();
          ChannelHandlerContext localChannelHandlerContext = localChannelPipeline.context(HttpRequestEncoder.class);
          paramAnonymousChannelFuture = localChannelHandlerContext;
          if (localChannelHandlerContext == null) {
            paramAnonymousChannelFuture = localChannelPipeline.context(HttpClientCodec.class);
          }
          if (paramAnonymousChannelFuture == null)
          {
            paramChannelPromise.setFailure(new IllegalStateException("ChannelPipeline does not contain an HttpRequestEncoder or HttpClientCodec"));
            return;
          }
          localChannelPipeline.addAfter(paramAnonymousChannelFuture.name(), "ws-encoder", WebSocketClientHandshaker.this.newWebSocketEncoder());
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
  
  protected boolean isForceCloseComplete()
  {
    return this.forceCloseComplete;
  }
  
  public boolean isHandshakeComplete()
  {
    return this.handshakeComplete;
  }
  
  public int maxFramePayloadLength()
  {
    return this.maxFramePayloadLength;
  }
  
  protected abstract FullHttpRequest newHandshakeRequest();
  
  protected abstract b newWebSocketEncoder();
  
  protected abstract a newWebsocketDecoder();
  
  public final ChannelFuture processHandshake(Channel paramChannel, HttpResponse paramHttpResponse)
  {
    return processHandshake(paramChannel, paramHttpResponse, paramChannel.newPromise());
  }
  
  /* Error */
  public final ChannelFuture processHandshake(final Channel paramChannel, HttpResponse paramHttpResponse, final ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 388
    //   4: ifeq +34 -> 38
    //   7: aload_0
    //   8: aload_1
    //   9: aload_2
    //   10: checkcast 388	io/netty/handler/codec/http/FullHttpResponse
    //   13: invokevirtual 390	io/netty/handler/codec/http/websocketx/WebSocketClientHandshaker:finishHandshake	(Lio/netty/channel/Channel;Lio/netty/handler/codec/http/FullHttpResponse;)V
    //   16: aload_3
    //   17: invokeinterface 393 1 0
    //   22: pop
    //   23: goto +158 -> 181
    //   26: astore_1
    //   27: aload_3
    //   28: aload_1
    //   29: invokeinterface 367 2 0
    //   34: pop
    //   35: goto +146 -> 181
    //   38: aload_1
    //   39: invokeinterface 274 1 0
    //   44: astore 4
    //   46: aload 4
    //   48: ldc_w 289
    //   51: invokeinterface 293 2 0
    //   56: astore 5
    //   58: aload 5
    //   60: astore 6
    //   62: aload 5
    //   64: ifnonnull +41 -> 105
    //   67: aload 4
    //   69: ldc_w 295
    //   72: invokeinterface 293 2 0
    //   77: astore 5
    //   79: aload 5
    //   81: astore 6
    //   83: aload 5
    //   85: ifnonnull +20 -> 105
    //   88: aload_3
    //   89: new 333	java/lang/IllegalStateException
    //   92: dup
    //   93: ldc_w 361
    //   96: invokespecial 337	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   99: invokeinterface 367 2 0
    //   104: areturn
    //   105: aload 4
    //   107: aload 6
    //   109: invokeinterface 308 1 0
    //   114: ldc_w 395
    //   117: new 287	io/netty/handler/codec/http/HttpObjectAggregator
    //   120: dup
    //   121: sipush 8192
    //   124: invokespecial 398	io/netty/handler/codec/http/HttpObjectAggregator:<init>	(I)V
    //   127: invokeinterface 318 4 0
    //   132: pop
    //   133: aload 4
    //   135: ldc_w 395
    //   138: ldc_w 400
    //   141: new 12	io/netty/handler/codec/http/websocketx/WebSocketClientHandshaker$4
    //   144: dup
    //   145: aload_0
    //   146: aload_1
    //   147: aload_3
    //   148: invokespecial 403	io/netty/handler/codec/http/websocketx/WebSocketClientHandshaker$4:<init>	(Lio/netty/handler/codec/http/websocketx/WebSocketClientHandshaker;Lio/netty/channel/Channel;Lio/netty/channel/ChannelPromise;)V
    //   151: invokeinterface 318 4 0
    //   156: pop
    //   157: aload 6
    //   159: aload_2
    //   160: invokestatic 409	io/netty/util/ReferenceCountUtil:retain	(Ljava/lang/Object;)Ljava/lang/Object;
    //   163: invokeinterface 413 2 0
    //   168: pop
    //   169: goto +12 -> 181
    //   172: astore_1
    //   173: aload_3
    //   174: aload_1
    //   175: invokeinterface 367 2 0
    //   180: pop
    //   181: aload_3
    //   182: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	WebSocketClientHandshaker
    //   0	183	1	paramChannel	Channel
    //   0	183	2	paramHttpResponse	HttpResponse
    //   0	183	3	paramChannelPromise	ChannelPromise
    //   44	90	4	localChannelPipeline	ChannelPipeline
    //   56	28	5	localChannelHandlerContext1	ChannelHandlerContext
    //   60	98	6	localChannelHandlerContext2	ChannelHandlerContext
    // Exception table:
    //   from	to	target	type
    //   7	23	26	finally
    //   157	169	172	finally
  }
  
  public WebSocketClientHandshaker setForceCloseTimeoutMillis(long paramLong)
  {
    this.forceCloseTimeoutMillis = paramLong;
    return this;
  }
  
  protected String upgradeUrl(URI paramURI)
  {
    if (this.absoluteUpgradeUrl) {
      return paramURI.toString();
    }
    String str1 = paramURI.getRawPath();
    String str2;
    if (str1 != null)
    {
      str2 = str1;
      if (!str1.isEmpty()) {}
    }
    else
    {
      str2 = "/";
    }
    str1 = paramURI.getRawQuery();
    paramURI = str2;
    if (str1 != null)
    {
      paramURI = str2;
      if (!str1.isEmpty())
      {
        paramURI = new StringBuilder();
        paramURI.append(str2);
        paramURI.append('?');
        paramURI.append(str1);
        paramURI = paramURI.toString();
      }
    }
    return paramURI;
  }
  
  public URI uri()
  {
    return this.uri;
  }
  
  protected abstract void verify(FullHttpResponse paramFullHttpResponse);
  
  public WebSocketVersion version()
  {
    return this.version;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketClientHandshaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */