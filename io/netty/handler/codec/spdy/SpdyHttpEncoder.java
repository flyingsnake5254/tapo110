package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class SpdyHttpEncoder
  extends MessageToMessageEncoder<HttpObject>
{
  private int currentStreamId;
  private final boolean headersToLowerCase;
  private final boolean validateHeaders;
  
  public SpdyHttpEncoder(SpdyVersion paramSpdyVersion)
  {
    this(paramSpdyVersion, true, true);
  }
  
  public SpdyHttpEncoder(SpdyVersion paramSpdyVersion, boolean paramBoolean1, boolean paramBoolean2)
  {
    ObjectUtil.checkNotNull(paramSpdyVersion, "version");
    this.headersToLowerCase = paramBoolean1;
    this.validateHeaders = paramBoolean2;
  }
  
  private SpdyHeadersFrame createHeadersFrame(HttpResponse paramHttpResponse)
    throws Exception
  {
    Object localObject1 = paramHttpResponse.headers();
    Object localObject2 = SpdyHttpHeaders.Names.STREAM_ID;
    int i = ((HttpHeaders)localObject1).getInt((CharSequence)localObject2).intValue();
    ((HttpHeaders)localObject1).remove((CharSequence)localObject2);
    ((HttpHeaders)localObject1).remove(HttpHeaderNames.CONNECTION);
    ((HttpHeaders)localObject1).remove("Keep-Alive");
    ((HttpHeaders)localObject1).remove("Proxy-Connection");
    ((HttpHeaders)localObject1).remove(HttpHeaderNames.TRANSFER_ENCODING);
    if (SpdyCodecUtil.isServerId(i)) {
      localObject2 = new DefaultSpdyHeadersFrame(i, this.validateHeaders);
    } else {
      localObject2 = new DefaultSpdySynReplyFrame(i, this.validateHeaders);
    }
    Object localObject3 = ((SpdyHeadersFrame)localObject2).headers();
    ((Headers)localObject3).set(SpdyHeaders.HttpNames.STATUS, paramHttpResponse.status().codeAsText());
    ((Headers)localObject3).set(SpdyHeaders.HttpNames.VERSION, paramHttpResponse.protocolVersion().text());
    Iterator localIterator = ((HttpHeaders)localObject1).iteratorCharSequence();
    while (localIterator.hasNext())
    {
      localObject3 = (Map.Entry)localIterator.next();
      if (this.headersToLowerCase) {
        localObject1 = AsciiString.of((CharSequence)((Map.Entry)localObject3).getKey()).toLowerCase();
      } else {
        localObject1 = (CharSequence)((Map.Entry)localObject3).getKey();
      }
      ((SpdyHeadersFrame)localObject2).headers().add(localObject1, ((Map.Entry)localObject3).getValue());
    }
    this.currentStreamId = i;
    ((SpdyHeadersFrame)localObject2).setLast(isLast(paramHttpResponse));
    return (SpdyHeadersFrame)localObject2;
  }
  
  private SpdySynStreamFrame createSynStreamFrame(HttpRequest paramHttpRequest)
    throws Exception
  {
    Object localObject1 = paramHttpRequest.headers();
    Object localObject2 = SpdyHttpHeaders.Names.STREAM_ID;
    int i = ((HttpHeaders)localObject1).getInt((CharSequence)localObject2).intValue();
    Object localObject3 = SpdyHttpHeaders.Names.ASSOCIATED_TO_STREAM_ID;
    int j = ((HttpHeaders)localObject1).getInt((CharSequence)localObject3, 0);
    Object localObject4 = SpdyHttpHeaders.Names.PRIORITY;
    byte b = (byte)((HttpHeaders)localObject1).getInt((CharSequence)localObject4, 0);
    Object localObject5 = SpdyHttpHeaders.Names.SCHEME;
    Object localObject6 = ((HttpHeaders)localObject1).get((CharSequence)localObject5);
    ((HttpHeaders)localObject1).remove((CharSequence)localObject2);
    ((HttpHeaders)localObject1).remove((CharSequence)localObject3);
    ((HttpHeaders)localObject1).remove((CharSequence)localObject4);
    ((HttpHeaders)localObject1).remove((CharSequence)localObject5);
    ((HttpHeaders)localObject1).remove(HttpHeaderNames.CONNECTION);
    ((HttpHeaders)localObject1).remove("Keep-Alive");
    ((HttpHeaders)localObject1).remove("Proxy-Connection");
    ((HttpHeaders)localObject1).remove(HttpHeaderNames.TRANSFER_ENCODING);
    localObject4 = new DefaultSpdySynStreamFrame(i, j, b, this.validateHeaders);
    localObject3 = ((SpdyHeadersFrame)localObject4).headers();
    ((Headers)localObject3).set(SpdyHeaders.HttpNames.METHOD, paramHttpRequest.method().name());
    ((Headers)localObject3).set(SpdyHeaders.HttpNames.PATH, paramHttpRequest.uri());
    ((Headers)localObject3).set(SpdyHeaders.HttpNames.VERSION, paramHttpRequest.protocolVersion().text());
    localObject5 = HttpHeaderNames.HOST;
    localObject2 = ((HttpHeaders)localObject1).get((CharSequence)localObject5);
    ((HttpHeaders)localObject1).remove((CharSequence)localObject5);
    ((Headers)localObject3).set(SpdyHeaders.HttpNames.HOST, localObject2);
    localObject5 = localObject6;
    if (localObject6 == null) {
      localObject5 = "https";
    }
    ((Headers)localObject3).set(SpdyHeaders.HttpNames.SCHEME, localObject5);
    localObject6 = ((HttpHeaders)localObject1).iteratorCharSequence();
    while (((Iterator)localObject6).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject6).next();
      if (this.headersToLowerCase) {
        localObject5 = AsciiString.of((CharSequence)((Map.Entry)localObject1).getKey()).toLowerCase();
      } else {
        localObject5 = (CharSequence)((Map.Entry)localObject1).getKey();
      }
      ((Headers)localObject3).add(localObject5, ((Map.Entry)localObject1).getValue());
    }
    this.currentStreamId = ((SpdyStreamFrame)localObject4).streamId();
    if (j == 0) {
      ((SpdySynStreamFrame)localObject4).setLast(isLast(paramHttpRequest));
    } else {
      ((SpdySynStreamFrame)localObject4).setUnidirectional(true);
    }
    return (SpdySynStreamFrame)localObject4;
  }
  
  private static boolean isLast(HttpMessage paramHttpMessage)
  {
    if ((paramHttpMessage instanceof FullHttpMessage))
    {
      paramHttpMessage = (FullHttpMessage)paramHttpMessage;
      if ((paramHttpMessage.trailingHeaders().isEmpty()) && (!paramHttpMessage.content().isReadable())) {
        return true;
      }
    }
    return false;
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, HttpObject paramHttpObject, List<Object> paramList)
    throws Exception
  {
    boolean bool = paramHttpObject instanceof HttpRequest;
    int i = 1;
    int j;
    if (bool)
    {
      paramChannelHandlerContext = createSynStreamFrame((HttpRequest)paramHttpObject);
      paramList.add(paramChannelHandlerContext);
      if ((!paramChannelHandlerContext.isLast()) && (!paramChannelHandlerContext.isUnidirectional())) {
        bool = false;
      } else {
        bool = true;
      }
      j = 1;
    }
    else
    {
      bool = false;
      j = 0;
    }
    if ((paramHttpObject instanceof HttpResponse))
    {
      paramChannelHandlerContext = createHeadersFrame((HttpResponse)paramHttpObject);
      paramList.add(paramChannelHandlerContext);
      bool = paramChannelHandlerContext.isLast();
      j = 1;
    }
    if (((paramHttpObject instanceof HttpContent)) && (!bool))
    {
      paramChannelHandlerContext = (HttpContent)paramHttpObject;
      paramChannelHandlerContext.content().retain();
      DefaultSpdyDataFrame localDefaultSpdyDataFrame = new DefaultSpdyDataFrame(this.currentStreamId, paramChannelHandlerContext.content());
      if ((paramChannelHandlerContext instanceof LastHttpContent))
      {
        paramChannelHandlerContext = ((LastHttpContent)paramChannelHandlerContext).trailingHeaders();
        if (paramChannelHandlerContext.isEmpty())
        {
          localDefaultSpdyDataFrame.setLast(true);
          paramList.add(localDefaultSpdyDataFrame);
          j = i;
        }
        else
        {
          DefaultSpdyHeadersFrame localDefaultSpdyHeadersFrame = new DefaultSpdyHeadersFrame(this.currentStreamId, this.validateHeaders);
          localDefaultSpdyHeadersFrame.setLast(true);
          Iterator localIterator = paramChannelHandlerContext.iteratorCharSequence();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (this.headersToLowerCase) {
              paramChannelHandlerContext = AsciiString.of((CharSequence)localEntry.getKey()).toLowerCase();
            } else {
              paramChannelHandlerContext = (CharSequence)localEntry.getKey();
            }
            localDefaultSpdyHeadersFrame.headers().add(paramChannelHandlerContext, localEntry.getValue());
          }
          paramList.add(localDefaultSpdyDataFrame);
          paramList.add(localDefaultSpdyHeadersFrame);
          j = i;
        }
      }
      else
      {
        paramList.add(localDefaultSpdyDataFrame);
        j = i;
      }
    }
    if (j != 0) {
      return;
    }
    throw new UnsupportedMessageTypeException(paramHttpObject, new Class[0]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyHttpEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */