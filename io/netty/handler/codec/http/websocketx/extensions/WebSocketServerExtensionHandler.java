package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WebSocketServerExtensionHandler
  extends ChannelDuplexHandler
{
  private final List<WebSocketServerExtensionHandshaker> extensionHandshakers;
  private List<WebSocketServerExtension> validExtensions;
  
  public WebSocketServerExtensionHandler(WebSocketServerExtensionHandshaker... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "extensionHandshakers");
    if (paramVarArgs.length != 0)
    {
      this.extensionHandshakers = Arrays.asList(paramVarArgs);
      return;
    }
    throw new IllegalArgumentException("extensionHandshakers must contains at least one handshaker");
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof HttpRequest))
    {
      Object localObject = (HttpRequest)paramObject;
      if (WebSocketExtensionUtil.isWebsocketUpgrade(((HttpMessage)localObject).headers()))
      {
        localObject = ((HttpMessage)localObject).headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
        if (localObject != null)
        {
          localObject = WebSocketExtensionUtil.extractExtensions((String)localObject);
          int i = 0;
          Iterator localIterator1 = ((List)localObject).iterator();
          while (localIterator1.hasNext())
          {
            WebSocketExtensionData localWebSocketExtensionData = (WebSocketExtensionData)localIterator1.next();
            Iterator localIterator2 = this.extensionHandshakers.iterator();
            for (localObject = null; (localObject == null) && (localIterator2.hasNext()); localObject = ((WebSocketServerExtensionHandshaker)localIterator2.next()).handshakeExtension(localWebSocketExtensionData)) {}
            if ((localObject != null) && ((((WebSocketExtension)localObject).rsv() & i) == 0))
            {
              if (this.validExtensions == null) {
                this.validExtensions = new ArrayList(1);
              }
              i |= ((WebSocketExtension)localObject).rsv();
              this.validExtensions.add(localObject);
            }
          }
        }
      }
    }
    super.channelRead(paramChannelHandlerContext, paramObject);
  }
  
  public void write(final ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if ((paramObject instanceof HttpResponse))
    {
      HttpHeaders localHttpHeaders = ((HttpResponse)paramObject).headers();
      if (WebSocketExtensionUtil.isWebsocketUpgrade(localHttpHeaders))
      {
        if (this.validExtensions != null)
        {
          String str = localHttpHeaders.getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
          Iterator localIterator = this.validExtensions.iterator();
          while (localIterator.hasNext())
          {
            WebSocketExtensionData localWebSocketExtensionData = ((WebSocketServerExtension)localIterator.next()).newReponseData();
            str = WebSocketExtensionUtil.appendExtension(str, localWebSocketExtensionData.name(), localWebSocketExtensionData.parameters());
          }
          paramChannelPromise.addListener(new ChannelFutureListener()
          {
            public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
            {
              if (paramAnonymousChannelFuture.isSuccess())
              {
                paramAnonymousChannelFuture = WebSocketServerExtensionHandler.this.validExtensions.iterator();
                while (paramAnonymousChannelFuture.hasNext())
                {
                  Object localObject = (WebSocketServerExtension)paramAnonymousChannelFuture.next();
                  WebSocketExtensionDecoder localWebSocketExtensionDecoder = ((WebSocketExtension)localObject).newExtensionDecoder();
                  localObject = ((WebSocketExtension)localObject).newExtensionEncoder();
                  paramChannelHandlerContext.pipeline().addAfter(paramChannelHandlerContext.name(), localWebSocketExtensionDecoder.getClass().getName(), localWebSocketExtensionDecoder).addAfter(paramChannelHandlerContext.name(), localObject.getClass().getName(), (ChannelHandler)localObject);
                }
              }
            }
          });
          if (str != null) {
            localHttpHeaders.set(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS, str);
          }
        }
        paramChannelPromise.addListener(new ChannelFutureListener()
        {
          public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
          {
            if (paramAnonymousChannelFuture.isSuccess()) {
              paramChannelHandlerContext.pipeline().remove(WebSocketServerExtensionHandler.this);
            }
          }
        });
      }
    }
    super.write(paramChannelHandlerContext, paramObject, paramChannelPromise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\WebSocketServerExtensionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */