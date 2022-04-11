package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.http.DefaultHttpContent;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.AsciiString;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.AttributeMap;
import java.util.List;

@ChannelHandler.a
public class Http2StreamFrameToHttpObjectCodec
  extends MessageToMessageCodec<Http2StreamFrame, HttpObject>
{
  private static final AttributeKey<HttpScheme> SCHEME_ATTR_KEY = AttributeKey.valueOf(HttpScheme.class, "STREAMFRAMECODEC_SCHEME");
  private final boolean isServer;
  private final boolean validateHeaders;
  
  public Http2StreamFrameToHttpObjectCodec(boolean paramBoolean)
  {
    this(paramBoolean, true);
  }
  
  public Http2StreamFrameToHttpObjectCodec(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.isServer = paramBoolean1;
    this.validateHeaders = paramBoolean2;
  }
  
  private static Channel connectionChannel(ChannelHandlerContext paramChannelHandlerContext)
  {
    Channel localChannel = paramChannelHandlerContext.channel();
    paramChannelHandlerContext = localChannel;
    if ((localChannel instanceof Http2StreamChannel)) {
      paramChannelHandlerContext = localChannel.parent();
    }
    return paramChannelHandlerContext;
  }
  
  private static HttpScheme connectionScheme(ChannelHandlerContext paramChannelHandlerContext)
  {
    HttpScheme localHttpScheme = (HttpScheme)connectionSchemeAttribute(paramChannelHandlerContext).get();
    paramChannelHandlerContext = localHttpScheme;
    if (localHttpScheme == null) {
      paramChannelHandlerContext = HttpScheme.HTTP;
    }
    return paramChannelHandlerContext;
  }
  
  private static Attribute<HttpScheme> connectionSchemeAttribute(ChannelHandlerContext paramChannelHandlerContext)
  {
    return connectionChannel(paramChannelHandlerContext).attr(SCHEME_ATTR_KEY);
  }
  
  private void encodeLastContent(LastHttpContent paramLastHttpContent, List<Object> paramList)
  {
    int i;
    if ((!(paramLastHttpContent instanceof FullHttpMessage)) && (paramLastHttpContent.trailingHeaders().isEmpty())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramLastHttpContent.content().isReadable()) || (i != 0)) {
      paramList.add(new DefaultHttp2DataFrame(paramLastHttpContent.content().retain(), paramLastHttpContent.trailingHeaders().isEmpty()));
    }
    if (!paramLastHttpContent.trailingHeaders().isEmpty()) {
      paramList.add(new DefaultHttp2HeadersFrame(HttpConversionUtil.toHttp2Headers(paramLastHttpContent.trailingHeaders(), this.validateHeaders), true));
    }
  }
  
  private FullHttpMessage newFullMessage(int paramInt, Http2Headers paramHttp2Headers, ByteBufAllocator paramByteBufAllocator)
    throws Http2Exception
  {
    if (this.isServer) {
      paramHttp2Headers = HttpConversionUtil.toFullHttpRequest(paramInt, paramHttp2Headers, paramByteBufAllocator, this.validateHeaders);
    } else {
      paramHttp2Headers = HttpConversionUtil.toFullHttpResponse(paramInt, paramHttp2Headers, paramByteBufAllocator, this.validateHeaders);
    }
    return paramHttp2Headers;
  }
  
  private HttpMessage newMessage(int paramInt, Http2Headers paramHttp2Headers)
    throws Http2Exception
  {
    if (this.isServer) {
      paramHttp2Headers = HttpConversionUtil.toHttpRequest(paramInt, paramHttp2Headers, this.validateHeaders);
    } else {
      paramHttp2Headers = HttpConversionUtil.toHttpResponse(paramInt, paramHttp2Headers, this.validateHeaders);
    }
    return paramHttp2Headers;
  }
  
  private Http2Headers toHttp2Headers(ChannelHandlerContext paramChannelHandlerContext, HttpMessage paramHttpMessage)
  {
    if ((paramHttpMessage instanceof HttpRequest)) {
      paramHttpMessage.headers().set(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), connectionScheme(paramChannelHandlerContext));
    }
    return HttpConversionUtil.toHttp2Headers(paramHttpMessage, this.validateHeaders);
  }
  
  public boolean acceptInboundMessage(Object paramObject)
    throws Exception
  {
    boolean bool;
    if ((!(paramObject instanceof Http2HeadersFrame)) && (!(paramObject instanceof Http2DataFrame))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, Http2StreamFrame paramHttp2StreamFrame, List<Object> paramList)
    throws Exception
  {
    if ((paramHttp2StreamFrame instanceof Http2HeadersFrame))
    {
      Http2HeadersFrame localHttp2HeadersFrame = (Http2HeadersFrame)paramHttp2StreamFrame;
      paramHttp2StreamFrame = localHttp2HeadersFrame.headers();
      Object localObject = localHttp2HeadersFrame.stream();
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = ((Http2FrameStream)localObject).id();
      }
      localObject = paramHttp2StreamFrame.status();
      if ((localObject != null) && (HttpResponseStatus.CONTINUE.codeAsText().contentEquals((CharSequence)localObject)))
      {
        paramList.add(newFullMessage(i, paramHttp2StreamFrame, paramChannelHandlerContext.alloc()));
        return;
      }
      if (localHttp2HeadersFrame.isEndStream())
      {
        if ((paramHttp2StreamFrame.method() == null) && (localObject == null))
        {
          paramChannelHandlerContext = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.validateHeaders);
          HttpConversionUtil.addHttp2ToHttpHeaders(i, paramHttp2StreamFrame, paramChannelHandlerContext.trailingHeaders(), HttpVersion.HTTP_1_1, true, true);
          paramList.add(paramChannelHandlerContext);
        }
        else
        {
          paramList.add(newFullMessage(i, paramHttp2StreamFrame, paramChannelHandlerContext.alloc()));
        }
      }
      else
      {
        paramChannelHandlerContext = newMessage(i, paramHttp2StreamFrame);
        if (!HttpUtil.isContentLengthSet(paramChannelHandlerContext)) {
          paramChannelHandlerContext.headers().add(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
        }
        paramList.add(paramChannelHandlerContext);
      }
    }
    else if ((paramHttp2StreamFrame instanceof Http2DataFrame))
    {
      paramChannelHandlerContext = (Http2DataFrame)paramHttp2StreamFrame;
      if (paramChannelHandlerContext.isEndStream()) {
        paramList.add(new DefaultLastHttpContent(paramChannelHandlerContext.content().retain(), this.validateHeaders));
      } else {
        paramList.add(new DefaultHttpContent(paramChannelHandlerContext.content().retain()));
      }
    }
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, HttpObject paramHttpObject, List<Object> paramList)
    throws Exception
  {
    Object localObject;
    if ((paramHttpObject instanceof HttpResponse))
    {
      HttpResponse localHttpResponse = (HttpResponse)paramHttpObject;
      HttpResponseStatus localHttpResponseStatus = localHttpResponse.status();
      localObject = HttpResponseStatus.CONTINUE;
      if (localHttpResponseStatus.equals(localObject))
      {
        if ((localHttpResponse instanceof FullHttpResponse))
        {
          paramList.add(new DefaultHttp2HeadersFrame(toHttp2Headers(paramChannelHandlerContext, localHttpResponse), false));
          return;
        }
        paramChannelHandlerContext = new StringBuilder();
        paramChannelHandlerContext.append(((HttpResponseStatus)localObject).toString());
        paramChannelHandlerContext.append(" must be a FullHttpResponse");
        throw new EncoderException(paramChannelHandlerContext.toString());
      }
    }
    if ((paramHttpObject instanceof HttpMessage))
    {
      paramChannelHandlerContext = toHttp2Headers(paramChannelHandlerContext, (HttpMessage)paramHttpObject);
      if ((paramHttpObject instanceof FullHttpMessage))
      {
        localObject = (FullHttpMessage)paramHttpObject;
        if ((!((ByteBufHolder)localObject).content().isReadable()) && (((LastHttpContent)localObject).trailingHeaders().isEmpty()))
        {
          bool = true;
          break label171;
        }
      }
      boolean bool = false;
      label171:
      paramList.add(new DefaultHttp2HeadersFrame(paramChannelHandlerContext, bool));
    }
    if ((paramHttpObject instanceof LastHttpContent)) {
      encodeLastContent((LastHttpContent)paramHttpObject, paramList);
    } else if ((paramHttpObject instanceof HttpContent)) {
      paramList.add(new DefaultHttp2DataFrame(((HttpContent)paramHttpObject).content().retain(), false));
    }
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    super.handlerAdded(paramChannelHandlerContext);
    Attribute localAttribute = connectionSchemeAttribute(paramChannelHandlerContext);
    if (localAttribute.get() == null)
    {
      if (isSsl(paramChannelHandlerContext)) {
        paramChannelHandlerContext = HttpScheme.HTTPS;
      } else {
        paramChannelHandlerContext = HttpScheme.HTTP;
      }
      localAttribute.set(paramChannelHandlerContext);
    }
  }
  
  protected boolean isSsl(ChannelHandlerContext paramChannelHandlerContext)
  {
    boolean bool;
    if (connectionChannel(paramChannelHandlerContext).pipeline().get(SslHandler.class) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2StreamFrameToHttpObjectCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */