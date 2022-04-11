package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.internal.logging.InternalLogger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSocketServerHandshaker00
  extends WebSocketServerHandshaker
{
  private static final Pattern BEGINNING_DIGIT = Pattern.compile("[^0-9]");
  private static final Pattern BEGINNING_SPACE = Pattern.compile("[^ ]");
  
  public WebSocketServerHandshaker00(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, WebSocketDecoderConfig.newBuilder().maxFramePayloadLength(paramInt).build());
  }
  
  public WebSocketServerHandshaker00(String paramString1, String paramString2, WebSocketDecoderConfig paramWebSocketDecoderConfig)
  {
    super(WebSocketVersion.V00, paramString1, paramString2, paramWebSocketDecoderConfig);
  }
  
  public ChannelFuture close(Channel paramChannel, CloseWebSocketFrame paramCloseWebSocketFrame, ChannelPromise paramChannelPromise)
  {
    return paramChannel.writeAndFlush(paramCloseWebSocketFrame, paramChannelPromise);
  }
  
  protected FullHttpResponse newHandshakeResponse(FullHttpRequest paramFullHttpRequest, HttpHeaders paramHttpHeaders)
  {
    Object localObject1 = paramFullHttpRequest.headers();
    Object localObject2 = HttpHeaderNames.CONNECTION;
    Object localObject3 = HttpHeaderValues.UPGRADE;
    int i = 1;
    if (((HttpHeaders)localObject1).containsValue((CharSequence)localObject2, (CharSequence)localObject3, true))
    {
      AsciiString localAsciiString1 = HttpHeaderValues.WEBSOCKET;
      localObject1 = paramFullHttpRequest.headers();
      AsciiString localAsciiString2 = HttpHeaderNames.UPGRADE;
      if (localAsciiString1.contentEqualsIgnoreCase(((HttpHeaders)localObject1).get(localAsciiString2)))
      {
        localObject1 = paramFullHttpRequest.headers();
        Object localObject4 = HttpHeaderNames.SEC_WEBSOCKET_KEY1;
        if ((!((HttpHeaders)localObject1).contains((CharSequence)localObject4)) || (!paramFullHttpRequest.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_KEY2))) {
          i = 0;
        }
        String str = paramFullHttpRequest.headers().get(HttpHeaderNames.ORIGIN);
        if ((str == null) && (i == 0))
        {
          paramHttpHeaders = new StringBuilder();
          paramHttpHeaders.append("Missing origin header, got only ");
          paramHttpHeaders.append(paramFullHttpRequest.headers().names());
          throw new WebSocketHandshakeException(paramHttpHeaders.toString());
        }
        HttpVersion localHttpVersion = HttpVersion.HTTP_1_1;
        if (i != 0) {
          localObject1 = "WebSocket Protocol Handshake";
        } else {
          localObject1 = "Web Socket Protocol Handshake";
        }
        localObject1 = new DefaultFullHttpResponse(localHttpVersion, new HttpResponseStatus(101, (String)localObject1), paramFullHttpRequest.content().alloc().buffer(0));
        if (paramHttpHeaders != null) {
          ((HttpMessage)localObject1).headers().add(paramHttpHeaders);
        }
        ((HttpMessage)localObject1).headers().set(localAsciiString2, localAsciiString1).set((CharSequence)localObject2, localObject3);
        if (i != 0)
        {
          ((HttpMessage)localObject1).headers().add(HttpHeaderNames.SEC_WEBSOCKET_ORIGIN, str);
          ((HttpMessage)localObject1).headers().add(HttpHeaderNames.SEC_WEBSOCKET_LOCATION, uri());
          localObject2 = paramFullHttpRequest.headers();
          paramHttpHeaders = HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL;
          localObject2 = ((HttpHeaders)localObject2).get(paramHttpHeaders);
          if (localObject2 != null)
          {
            localObject3 = selectSubprotocol((String)localObject2);
            if (localObject3 == null)
            {
              paramHttpHeaders = WebSocketServerHandshaker.logger;
              if (paramHttpHeaders.isDebugEnabled()) {
                paramHttpHeaders.debug("Requested subprotocol(s) not supported: {}", localObject2);
              }
            }
            else
            {
              ((HttpMessage)localObject1).headers().add(paramHttpHeaders, localObject3);
            }
          }
          localObject3 = paramFullHttpRequest.headers().get((CharSequence)localObject4);
          localObject4 = paramFullHttpRequest.headers().get(HttpHeaderNames.SEC_WEBSOCKET_KEY2);
          localObject2 = BEGINNING_DIGIT;
          long l = Long.parseLong(((Pattern)localObject2).matcher((CharSequence)localObject3).replaceAll(""));
          paramHttpHeaders = BEGINNING_SPACE;
          i = (int)(l / paramHttpHeaders.matcher((CharSequence)localObject3).replaceAll("").length());
          int j = (int)(Long.parseLong(((Pattern)localObject2).matcher((CharSequence)localObject4).replaceAll("")) / paramHttpHeaders.matcher((CharSequence)localObject4).replaceAll("").length());
          l = paramFullHttpRequest.content().readLong();
          paramFullHttpRequest = Unpooled.wrappedBuffer(new byte[16]).setIndex(0, 0);
          paramFullHttpRequest.writeInt(i);
          paramFullHttpRequest.writeInt(j);
          paramFullHttpRequest.writeLong(l);
          ((ByteBufHolder)localObject1).content().writeBytes(WebSocketUtil.md5(paramFullHttpRequest.array()));
        }
        else
        {
          ((HttpMessage)localObject1).headers().add(HttpHeaderNames.WEBSOCKET_ORIGIN, str);
          ((HttpMessage)localObject1).headers().add(HttpHeaderNames.WEBSOCKET_LOCATION, uri());
          paramHttpHeaders = paramFullHttpRequest.headers();
          paramFullHttpRequest = HttpHeaderNames.WEBSOCKET_PROTOCOL;
          paramHttpHeaders = paramHttpHeaders.get(paramFullHttpRequest);
          if (paramHttpHeaders != null) {
            ((HttpMessage)localObject1).headers().add(paramFullHttpRequest, selectSubprotocol(paramHttpHeaders));
          }
        }
        return (FullHttpResponse)localObject1;
      }
    }
    throw new WebSocketHandshakeException("not a WebSocket handshake request: missing upgrade");
  }
  
  protected b newWebSocketEncoder()
  {
    return new WebSocket00FrameEncoder();
  }
  
  protected a newWebsocketDecoder()
  {
    return new WebSocket00FrameDecoder(decoderConfig());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketServerHandshaker00.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */