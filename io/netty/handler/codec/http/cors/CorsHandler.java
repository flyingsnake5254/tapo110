package io.netty.handler.codec.http.cors;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CorsHandler
  extends ChannelDuplexHandler
{
  private static final String ANY_ORIGIN = "*";
  private static final String NULL_ORIGIN = "null";
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(CorsHandler.class);
  private CorsConfig config;
  private final List<CorsConfig> configList;
  private boolean isShortCircuit;
  private HttpRequest request;
  
  public CorsHandler(CorsConfig paramCorsConfig)
  {
    this(Collections.singletonList(ObjectUtil.checkNotNull(paramCorsConfig, "config")), paramCorsConfig.isShortCircuit());
  }
  
  public CorsHandler(List<CorsConfig> paramList, boolean paramBoolean)
  {
    ObjectUtil.checkNonEmpty(paramList, "configList");
    this.configList = paramList;
    this.isShortCircuit = paramBoolean;
  }
  
  private void echoRequestOrigin(HttpResponse paramHttpResponse)
  {
    setOrigin(paramHttpResponse, this.request.headers().get(HttpHeaderNames.ORIGIN));
  }
  
  private static void forbidden(ChannelHandlerContext paramChannelHandlerContext, HttpRequest paramHttpRequest)
  {
    DefaultFullHttpResponse localDefaultFullHttpResponse = new DefaultFullHttpResponse(paramHttpRequest.protocolVersion(), HttpResponseStatus.FORBIDDEN, paramChannelHandlerContext.alloc().buffer(0));
    localDefaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, HttpHeaderValues.ZERO);
    ReferenceCountUtil.release(paramHttpRequest);
    respond(paramChannelHandlerContext, paramHttpRequest, localDefaultFullHttpResponse);
  }
  
  private CorsConfig getForOrigin(String paramString)
  {
    Iterator localIterator = this.configList.iterator();
    while (localIterator.hasNext())
    {
      CorsConfig localCorsConfig = (CorsConfig)localIterator.next();
      if (localCorsConfig.isAnyOriginSupported()) {
        return localCorsConfig;
      }
      if (localCorsConfig.origins().contains(paramString)) {
        return localCorsConfig;
      }
      if ((localCorsConfig.isNullOriginAllowed()) || ("null".equals(paramString))) {
        return localCorsConfig;
      }
    }
    return null;
  }
  
  private void handlePreflight(ChannelHandlerContext paramChannelHandlerContext, HttpRequest paramHttpRequest)
  {
    DefaultFullHttpResponse localDefaultFullHttpResponse = new DefaultFullHttpResponse(paramHttpRequest.protocolVersion(), HttpResponseStatus.OK, true, true);
    if (setOrigin(localDefaultFullHttpResponse))
    {
      setAllowMethods(localDefaultFullHttpResponse);
      setAllowHeaders(localDefaultFullHttpResponse);
      setAllowCredentials(localDefaultFullHttpResponse);
      setMaxAge(localDefaultFullHttpResponse);
      setPreflightHeaders(localDefaultFullHttpResponse);
    }
    HttpHeaders localHttpHeaders = localDefaultFullHttpResponse.headers();
    AsciiString localAsciiString = HttpHeaderNames.CONTENT_LENGTH;
    if (!localHttpHeaders.contains(localAsciiString)) {
      localDefaultFullHttpResponse.headers().set(localAsciiString, HttpHeaderValues.ZERO);
    }
    ReferenceCountUtil.release(paramHttpRequest);
    respond(paramChannelHandlerContext, paramHttpRequest, localDefaultFullHttpResponse);
  }
  
  private static boolean isPreflightRequest(HttpRequest paramHttpRequest)
  {
    HttpHeaders localHttpHeaders = paramHttpRequest.headers();
    boolean bool;
    if ((HttpMethod.OPTIONS.equals(paramHttpRequest.method())) && (localHttpHeaders.contains(HttpHeaderNames.ORIGIN)) && (localHttpHeaders.contains(HttpHeaderNames.ACCESS_CONTROL_REQUEST_METHOD))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static void respond(ChannelHandlerContext paramChannelHandlerContext, HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
  {
    boolean bool = HttpUtil.isKeepAlive(paramHttpRequest);
    HttpUtil.setKeepAlive(paramHttpResponse, bool);
    paramChannelHandlerContext = paramChannelHandlerContext.writeAndFlush(paramHttpResponse);
    if (!bool) {
      paramChannelHandlerContext.addListener(ChannelFutureListener.CLOSE);
    }
  }
  
  private void setAllowCredentials(HttpResponse paramHttpResponse)
  {
    if ((this.config.isCredentialsAllowed()) && (!paramHttpResponse.headers().get(HttpHeaderNames.ACCESS_CONTROL_ALLOW_ORIGIN).equals("*"))) {
      paramHttpResponse.headers().set(HttpHeaderNames.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
    }
  }
  
  private void setAllowHeaders(HttpResponse paramHttpResponse)
  {
    paramHttpResponse.headers().set(HttpHeaderNames.ACCESS_CONTROL_ALLOW_HEADERS, this.config.allowedRequestHeaders());
  }
  
  private void setAllowMethods(HttpResponse paramHttpResponse)
  {
    paramHttpResponse.headers().set(HttpHeaderNames.ACCESS_CONTROL_ALLOW_METHODS, this.config.allowedRequestMethods());
  }
  
  private static void setAnyOrigin(HttpResponse paramHttpResponse)
  {
    setOrigin(paramHttpResponse, "*");
  }
  
  private void setExposeHeaders(HttpResponse paramHttpResponse)
  {
    if (!this.config.exposedHeaders().isEmpty()) {
      paramHttpResponse.headers().set(HttpHeaderNames.ACCESS_CONTROL_EXPOSE_HEADERS, this.config.exposedHeaders());
    }
  }
  
  private void setMaxAge(HttpResponse paramHttpResponse)
  {
    paramHttpResponse.headers().set(HttpHeaderNames.ACCESS_CONTROL_MAX_AGE, Long.valueOf(this.config.maxAge()));
  }
  
  private static void setNullOrigin(HttpResponse paramHttpResponse)
  {
    setOrigin(paramHttpResponse, "null");
  }
  
  private static void setOrigin(HttpResponse paramHttpResponse, String paramString)
  {
    paramHttpResponse.headers().set(HttpHeaderNames.ACCESS_CONTROL_ALLOW_ORIGIN, paramString);
  }
  
  private boolean setOrigin(HttpResponse paramHttpResponse)
  {
    String str = this.request.headers().get(HttpHeaderNames.ORIGIN);
    if ((str != null) && (this.config != null))
    {
      if (("null".equals(str)) && (this.config.isNullOriginAllowed()))
      {
        setNullOrigin(paramHttpResponse);
        return true;
      }
      if (this.config.isAnyOriginSupported())
      {
        if (this.config.isCredentialsAllowed())
        {
          echoRequestOrigin(paramHttpResponse);
          setVaryHeader(paramHttpResponse);
        }
        else
        {
          setAnyOrigin(paramHttpResponse);
        }
        return true;
      }
      if (this.config.origins().contains(str))
      {
        setOrigin(paramHttpResponse, str);
        setVaryHeader(paramHttpResponse);
        return true;
      }
      logger.debug("Request origin [{}]] was not among the configured origins [{}]", str, this.config.origins());
    }
    return false;
  }
  
  private void setPreflightHeaders(HttpResponse paramHttpResponse)
  {
    paramHttpResponse.headers().add(this.config.preflightResponseHeaders());
  }
  
  private static void setVaryHeader(HttpResponse paramHttpResponse)
  {
    paramHttpResponse.headers().set(HttpHeaderNames.VARY, HttpHeaderNames.ORIGIN);
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof HttpRequest))
    {
      Object localObject = (HttpRequest)paramObject;
      this.request = ((HttpRequest)localObject);
      localObject = ((HttpMessage)localObject).headers().get(HttpHeaderNames.ORIGIN);
      this.config = getForOrigin((String)localObject);
      if (isPreflightRequest(this.request))
      {
        handlePreflight(paramChannelHandlerContext, this.request);
        return;
      }
      if ((this.isShortCircuit) && (localObject != null) && (this.config == null))
      {
        forbidden(paramChannelHandlerContext, this.request);
        return;
      }
    }
    paramChannelHandlerContext.fireChannelRead(paramObject);
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    Object localObject = this.config;
    if ((localObject != null) && (((CorsConfig)localObject).isCorsSupportEnabled()) && ((paramObject instanceof HttpResponse)))
    {
      localObject = (HttpResponse)paramObject;
      if (setOrigin((HttpResponse)localObject))
      {
        setAllowCredentials((HttpResponse)localObject);
        setExposeHeaders((HttpResponse)localObject);
      }
    }
    paramChannelHandlerContext.write(paramObject, paramChannelPromise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\cors\CorsHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */