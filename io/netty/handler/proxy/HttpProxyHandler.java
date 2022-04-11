package io.netty.handler.proxy;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public final class HttpProxyHandler
  extends ProxyHandler
{
  private static final String AUTH_BASIC = "basic";
  private static final String PROTOCOL = "http";
  private final CharSequence authorization = null;
  private final HttpClientCodecWrapper codecWrapper = new HttpClientCodecWrapper(null);
  private final boolean ignoreDefaultPortsInConnectHostHeader;
  private HttpHeaders inboundHeaders;
  private final HttpHeaders outboundHeaders;
  private final String password = null;
  private HttpResponseStatus status;
  private final String username = null;
  
  public HttpProxyHandler(SocketAddress paramSocketAddress)
  {
    this(paramSocketAddress, null);
  }
  
  public HttpProxyHandler(SocketAddress paramSocketAddress, HttpHeaders paramHttpHeaders)
  {
    this(paramSocketAddress, paramHttpHeaders, false);
  }
  
  public HttpProxyHandler(SocketAddress paramSocketAddress, HttpHeaders paramHttpHeaders, boolean paramBoolean)
  {
    super(paramSocketAddress);
    this.outboundHeaders = paramHttpHeaders;
    this.ignoreDefaultPortsInConnectHostHeader = paramBoolean;
  }
  
  public HttpProxyHandler(SocketAddress paramSocketAddress, String paramString1, String paramString2)
  {
    this(paramSocketAddress, paramString1, paramString2, null);
  }
  
  public HttpProxyHandler(SocketAddress paramSocketAddress, String paramString1, String paramString2, HttpHeaders paramHttpHeaders)
  {
    this(paramSocketAddress, paramString1, paramString2, paramHttpHeaders, false);
  }
  
  /* Error */
  public HttpProxyHandler(SocketAddress paramSocketAddress, String paramString1, String paramString2, HttpHeaders paramHttpHeaders, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 43	io/netty/handler/proxy/ProxyHandler:<init>	(Ljava/net/SocketAddress;)V
    //   5: aload_0
    //   6: new 6	io/netty/handler/proxy/HttpProxyHandler$HttpClientCodecWrapper
    //   9: dup
    //   10: aconst_null
    //   11: invokespecial 46	io/netty/handler/proxy/HttpProxyHandler$HttpClientCodecWrapper:<init>	(Lio/netty/handler/proxy/HttpProxyHandler$a;)V
    //   14: putfield 48	io/netty/handler/proxy/HttpProxyHandler:codecWrapper	Lio/netty/handler/proxy/HttpProxyHandler$HttpClientCodecWrapper;
    //   17: aload_0
    //   18: aload_2
    //   19: ldc 66
    //   21: invokestatic 72	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   24: checkcast 74	java/lang/String
    //   27: putfield 50	io/netty/handler/proxy/HttpProxyHandler:username	Ljava/lang/String;
    //   30: aload_0
    //   31: aload_3
    //   32: ldc 75
    //   34: invokestatic 72	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   37: checkcast 74	java/lang/String
    //   40: putfield 52	io/netty/handler/proxy/HttpProxyHandler:password	Ljava/lang/String;
    //   43: new 77	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: aload_2
    //   53: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_1
    //   58: bipush 58
    //   60: invokevirtual 87	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_1
    //   65: aload_3
    //   66: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_1
    //   71: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: getstatic 97	io/netty/util/CharsetUtil:UTF_8	Ljava/nio/charset/Charset;
    //   77: invokestatic 103	io/netty/buffer/Unpooled:copiedBuffer	(Ljava/lang/CharSequence;Ljava/nio/charset/Charset;)Lio/netty/buffer/ByteBuf;
    //   80: astore_2
    //   81: aload_2
    //   82: iconst_0
    //   83: invokestatic 109	io/netty/handler/codec/base64/Base64:encode	(Lio/netty/buffer/ByteBuf;Z)Lio/netty/buffer/ByteBuf;
    //   86: astore_1
    //   87: aload_2
    //   88: invokeinterface 115 1 0
    //   93: pop
    //   94: new 117	io/netty/util/AsciiString
    //   97: astore_3
    //   98: new 77	java/lang/StringBuilder
    //   101: astore_2
    //   102: aload_2
    //   103: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   106: aload_2
    //   107: ldc 119
    //   109: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: aload_1
    //   115: getstatic 122	io/netty/util/CharsetUtil:US_ASCII	Ljava/nio/charset/Charset;
    //   118: invokevirtual 127	io/netty/buffer/ByteBuf:toString	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   121: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_3
    //   126: aload_2
    //   127: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokespecial 130	io/netty/util/AsciiString:<init>	(Ljava/lang/CharSequence;)V
    //   133: aload_0
    //   134: aload_3
    //   135: putfield 54	io/netty/handler/proxy/HttpProxyHandler:authorization	Ljava/lang/CharSequence;
    //   138: aload_1
    //   139: invokeinterface 115 1 0
    //   144: pop
    //   145: aload_0
    //   146: aload 4
    //   148: putfield 56	io/netty/handler/proxy/HttpProxyHandler:outboundHeaders	Lio/netty/handler/codec/http/HttpHeaders;
    //   151: aload_0
    //   152: iload 5
    //   154: putfield 58	io/netty/handler/proxy/HttpProxyHandler:ignoreDefaultPortsInConnectHostHeader	Z
    //   157: return
    //   158: astore_2
    //   159: aload_1
    //   160: invokeinterface 115 1 0
    //   165: pop
    //   166: aload_2
    //   167: athrow
    //   168: astore_1
    //   169: aload_2
    //   170: invokeinterface 115 1 0
    //   175: pop
    //   176: aload_1
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	HttpProxyHandler
    //   0	178	1	paramSocketAddress	SocketAddress
    //   0	178	2	paramString1	String
    //   0	178	3	paramString2	String
    //   0	178	4	paramHttpHeaders	HttpHeaders
    //   0	178	5	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   94	138	158	finally
    //   81	87	168	finally
  }
  
  protected void addCodec(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.pipeline().addBefore(paramChannelHandlerContext.name(), null, this.codecWrapper);
  }
  
  public String authScheme()
  {
    String str;
    if (this.authorization != null) {
      str = "basic";
    } else {
      str = "none";
    }
    return str;
  }
  
  protected boolean handleResponse(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof HttpResponse)) {
      if (this.status == null)
      {
        paramChannelHandlerContext = (HttpResponse)paramObject;
        this.status = paramChannelHandlerContext.status();
        this.inboundHeaders = paramChannelHandlerContext.headers();
      }
      else
      {
        throw new HttpProxyConnectException(exceptionMessage("too many responses"), null);
      }
    }
    boolean bool = paramObject instanceof LastHttpContent;
    if (bool)
    {
      paramChannelHandlerContext = this.status;
      if (paramChannelHandlerContext != null)
      {
        if (paramChannelHandlerContext.code() != 200)
        {
          paramChannelHandlerContext = new StringBuilder();
          paramChannelHandlerContext.append("status: ");
          paramChannelHandlerContext.append(this.status);
          throw new HttpProxyConnectException(exceptionMessage(paramChannelHandlerContext.toString()), this.inboundHeaders);
        }
      }
      else {
        throw new HttpProxyConnectException(exceptionMessage("missing response"), this.inboundHeaders);
      }
    }
    return bool;
  }
  
  protected Object newInitialMessage(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext = (InetSocketAddress)destinationAddress();
    Object localObject = HttpUtil.formatHostnameForHttp(paramChannelHandlerContext);
    int i = paramChannelHandlerContext.getPort();
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append((String)localObject);
    paramChannelHandlerContext.append(":");
    paramChannelHandlerContext.append(i);
    String str = paramChannelHandlerContext.toString();
    if (this.ignoreDefaultPortsInConnectHostHeader)
    {
      paramChannelHandlerContext = (ChannelHandlerContext)localObject;
      if (i == 80) {
        break label81;
      }
      if (i == 443)
      {
        paramChannelHandlerContext = (ChannelHandlerContext)localObject;
        break label81;
      }
    }
    paramChannelHandlerContext = str;
    label81:
    localObject = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.CONNECT, str, Unpooled.EMPTY_BUFFER, false);
    ((HttpMessage)localObject).headers().set(HttpHeaderNames.HOST, paramChannelHandlerContext);
    if (this.authorization != null) {
      ((HttpMessage)localObject).headers().set(HttpHeaderNames.PROXY_AUTHORIZATION, this.authorization);
    }
    if (this.outboundHeaders != null) {
      ((HttpMessage)localObject).headers().add(this.outboundHeaders);
    }
    return localObject;
  }
  
  public String password()
  {
    return this.password;
  }
  
  public String protocol()
  {
    return "http";
  }
  
  protected void removeDecoder(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.codecWrapper.codec.removeInboundHandler();
  }
  
  protected void removeEncoder(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.codecWrapper.codec.removeOutboundHandler();
  }
  
  public String username()
  {
    return this.username;
  }
  
  private static final class HttpClientCodecWrapper
    implements ChannelInboundHandler, ChannelOutboundHandler
  {
    final HttpClientCodec codec = new HttpClientCodec();
    
    public void bind(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
      throws Exception
    {
      this.codec.bind(paramChannelHandlerContext, paramSocketAddress, paramChannelPromise);
    }
    
    public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      this.codec.channelActive(paramChannelHandlerContext);
    }
    
    public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      this.codec.channelInactive(paramChannelHandlerContext);
    }
    
    public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
      throws Exception
    {
      this.codec.channelRead(paramChannelHandlerContext, paramObject);
    }
    
    public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      this.codec.channelReadComplete(paramChannelHandlerContext);
    }
    
    public void channelRegistered(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      this.codec.channelRegistered(paramChannelHandlerContext);
    }
    
    public void channelUnregistered(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      this.codec.channelUnregistered(paramChannelHandlerContext);
    }
    
    public void channelWritabilityChanged(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      this.codec.channelWritabilityChanged(paramChannelHandlerContext);
    }
    
    public void close(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
      throws Exception
    {
      this.codec.close(paramChannelHandlerContext, paramChannelPromise);
    }
    
    public void connect(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
      throws Exception
    {
      this.codec.connect(paramChannelHandlerContext, paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
    }
    
    public void deregister(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
      throws Exception
    {
      this.codec.deregister(paramChannelHandlerContext, paramChannelPromise);
    }
    
    public void disconnect(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
      throws Exception
    {
      this.codec.disconnect(paramChannelHandlerContext, paramChannelPromise);
    }
    
    public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
      throws Exception
    {
      this.codec.exceptionCaught(paramChannelHandlerContext, paramThrowable);
    }
    
    public void flush(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      this.codec.flush(paramChannelHandlerContext);
    }
    
    public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      this.codec.handlerAdded(paramChannelHandlerContext);
    }
    
    public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      this.codec.handlerRemoved(paramChannelHandlerContext);
    }
    
    public void read(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      this.codec.read(paramChannelHandlerContext);
    }
    
    public void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
      throws Exception
    {
      this.codec.userEventTriggered(paramChannelHandlerContext, paramObject);
    }
    
    public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
      throws Exception
    {
      this.codec.write(paramChannelHandlerContext, paramObject, paramChannelPromise);
    }
  }
  
  public static final class HttpProxyConnectException
    extends ProxyConnectException
  {
    private static final long serialVersionUID = -8824334609292146066L;
    private final HttpHeaders headers;
    
    public HttpProxyConnectException(String paramString, HttpHeaders paramHttpHeaders)
    {
      super();
      this.headers = paramHttpHeaders;
    }
    
    public HttpHeaders headers()
    {
      return this.headers;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\proxy\HttpProxyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */