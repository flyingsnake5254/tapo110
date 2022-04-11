package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WebSocketClientExtensionHandler
  extends ChannelDuplexHandler
{
  private final List<WebSocketClientExtensionHandshaker> extensionHandshakers;
  
  public WebSocketClientExtensionHandler(WebSocketClientExtensionHandshaker... paramVarArgs)
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
    if ((paramObject instanceof HttpResponse))
    {
      Object localObject1 = (HttpResponse)paramObject;
      if (WebSocketExtensionUtil.isWebsocketUpgrade(((HttpMessage)localObject1).headers()))
      {
        Object localObject2 = ((HttpMessage)localObject1).headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
        if (localObject2 != null)
        {
          localObject1 = WebSocketExtensionUtil.extractExtensions((String)localObject2);
          Object localObject3 = new ArrayList(((List)localObject1).size());
          int i = 0;
          Iterator localIterator1 = ((List)localObject1).iterator();
          while (localIterator1.hasNext())
          {
            WebSocketExtensionData localWebSocketExtensionData = (WebSocketExtensionData)localIterator1.next();
            Iterator localIterator2 = this.extensionHandshakers.iterator();
            for (localObject1 = null; (localObject1 == null) && (localIterator2.hasNext()); localObject1 = ((WebSocketClientExtensionHandshaker)localIterator2.next()).handshakeExtension(localWebSocketExtensionData)) {}
            if ((localObject1 != null) && ((((WebSocketExtension)localObject1).rsv() & i) == 0))
            {
              i |= ((WebSocketExtension)localObject1).rsv();
              ((List)localObject3).add(localObject1);
            }
            else
            {
              paramChannelHandlerContext = new StringBuilder();
              paramChannelHandlerContext.append("invalid WebSocket Extension handshake for \"");
              paramChannelHandlerContext.append((String)localObject2);
              paramChannelHandlerContext.append('"');
              throw new CodecException(paramChannelHandlerContext.toString());
            }
          }
          localObject1 = ((List)localObject3).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (a)((Iterator)localObject1).next();
            localObject2 = ((WebSocketExtension)localObject3).newExtensionDecoder();
            localObject3 = ((WebSocketExtension)localObject3).newExtensionEncoder();
            paramChannelHandlerContext.pipeline().addAfter(paramChannelHandlerContext.name(), localObject2.getClass().getName(), (ChannelHandler)localObject2);
            paramChannelHandlerContext.pipeline().addAfter(paramChannelHandlerContext.name(), localObject3.getClass().getName(), (ChannelHandler)localObject3);
          }
        }
        paramChannelHandlerContext.pipeline().remove(paramChannelHandlerContext.name());
      }
    }
    super.channelRead(paramChannelHandlerContext, paramObject);
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if ((paramObject instanceof HttpRequest))
    {
      HttpRequest localHttpRequest = (HttpRequest)paramObject;
      if (WebSocketExtensionUtil.isWebsocketUpgrade(localHttpRequest.headers()))
      {
        String str = localHttpRequest.headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
        Iterator localIterator = this.extensionHandshakers.iterator();
        while (localIterator.hasNext())
        {
          WebSocketExtensionData localWebSocketExtensionData = ((WebSocketClientExtensionHandshaker)localIterator.next()).newRequestData();
          str = WebSocketExtensionUtil.appendExtension(str, localWebSocketExtensionData.name(), localWebSocketExtensionData.parameters());
        }
        localHttpRequest.headers().set(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS, str);
      }
    }
    super.write(paramChannelHandlerContext, paramObject, paramChannelPromise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\WebSocketClientExtensionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */