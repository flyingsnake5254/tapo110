package io.netty.handler.codec.http;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class HttpServerKeepAliveHandler
  extends ChannelDuplexHandler
{
  private static final String MULTIPART_PREFIX = "multipart";
  private int pendingResponses;
  private boolean persistentConnection = true;
  
  private static boolean isInformational(HttpResponse paramHttpResponse)
  {
    boolean bool;
    if (paramHttpResponse.status().codeClass() == HttpStatusClass.INFORMATIONAL) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean isMultipart(HttpResponse paramHttpResponse)
  {
    paramHttpResponse = paramHttpResponse.headers().get(HttpHeaderNames.CONTENT_TYPE);
    boolean bool;
    if ((paramHttpResponse != null) && (paramHttpResponse.regionMatches(true, 0, "multipart", 0, 9))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean isSelfDefinedMessageLength(HttpResponse paramHttpResponse)
  {
    boolean bool;
    if ((!HttpUtil.isContentLengthSet(paramHttpResponse)) && (!HttpUtil.isTransferEncodingChunked(paramHttpResponse)) && (!isMultipart(paramHttpResponse)) && (!isInformational(paramHttpResponse)) && (paramHttpResponse.status().code() != HttpResponseStatus.NO_CONTENT.code())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean shouldKeepAlive()
  {
    boolean bool;
    if ((this.pendingResponses == 0) && (!this.persistentConnection)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void trackResponse(HttpResponse paramHttpResponse)
  {
    if (!isInformational(paramHttpResponse)) {
      this.pendingResponses -= 1;
    }
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof HttpRequest))
    {
      HttpRequest localHttpRequest = (HttpRequest)paramObject;
      if (this.persistentConnection)
      {
        this.pendingResponses += 1;
        this.persistentConnection = HttpUtil.isKeepAlive(localHttpRequest);
      }
    }
    super.channelRead(paramChannelHandlerContext, paramObject);
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if ((paramObject instanceof HttpResponse))
    {
      localObject = (HttpResponse)paramObject;
      trackResponse((HttpResponse)localObject);
      if ((!HttpUtil.isKeepAlive((HttpMessage)localObject)) || (!isSelfDefinedMessageLength((HttpResponse)localObject)))
      {
        this.pendingResponses = 0;
        this.persistentConnection = false;
      }
      if (!shouldKeepAlive()) {
        HttpUtil.setKeepAlive((HttpMessage)localObject, false);
      }
    }
    Object localObject = paramChannelPromise;
    if ((paramObject instanceof LastHttpContent))
    {
      localObject = paramChannelPromise;
      if (!shouldKeepAlive()) {
        localObject = paramChannelPromise.unvoid().addListener(ChannelFutureListener.CLOSE);
      }
    }
    super.write(paramChannelHandlerContext, paramObject, (ChannelPromise)localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpServerKeepAliveHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */