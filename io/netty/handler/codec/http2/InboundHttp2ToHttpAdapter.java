package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;

public class InboundHttp2ToHttpAdapter
  extends Http2EventAdapter
{
  private static final ImmediateSendDetector DEFAULT_SEND_DETECTOR = new ImmediateSendDetector()
  {
    public FullHttpMessage copyIfNeeded(ByteBufAllocator paramAnonymousByteBufAllocator, FullHttpMessage paramAnonymousFullHttpMessage)
    {
      if ((paramAnonymousFullHttpMessage instanceof FullHttpRequest))
      {
        paramAnonymousByteBufAllocator = ((FullHttpRequest)paramAnonymousFullHttpMessage).replace(paramAnonymousByteBufAllocator.buffer(0));
        paramAnonymousByteBufAllocator.headers().remove(HttpHeaderNames.EXPECT);
        return paramAnonymousByteBufAllocator;
      }
      return null;
    }
    
    public boolean mustSendImmediately(FullHttpMessage paramAnonymousFullHttpMessage)
    {
      boolean bool1 = paramAnonymousFullHttpMessage instanceof FullHttpResponse;
      boolean bool2 = false;
      if (bool1)
      {
        if (((FullHttpResponse)paramAnonymousFullHttpMessage).status().codeClass() == HttpStatusClass.INFORMATIONAL) {
          bool2 = true;
        }
        return bool2;
      }
      if ((paramAnonymousFullHttpMessage instanceof FullHttpRequest)) {
        return paramAnonymousFullHttpMessage.headers().contains(HttpHeaderNames.EXPECT);
      }
      return false;
    }
  };
  protected final Http2Connection connection;
  private final int maxContentLength;
  private final Http2Connection.a messageKey;
  private final boolean propagateSettings;
  private final ImmediateSendDetector sendDetector;
  protected final boolean validateHttpHeaders;
  
  protected InboundHttp2ToHttpAdapter(Http2Connection paramHttp2Connection, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt > 0)
    {
      this.connection = ((Http2Connection)ObjectUtil.checkNotNull(paramHttp2Connection, "connection"));
      this.maxContentLength = paramInt;
      this.validateHttpHeaders = paramBoolean1;
      this.propagateSettings = paramBoolean2;
      this.sendDetector = DEFAULT_SEND_DETECTOR;
      this.messageKey = paramHttp2Connection.newKey();
      return;
    }
    paramHttp2Connection = new StringBuilder();
    paramHttp2Connection.append("maxContentLength: ");
    paramHttp2Connection.append(paramInt);
    paramHttp2Connection.append(" (expected: > 0)");
    throw new IllegalArgumentException(paramHttp2Connection.toString());
  }
  
  private void processHeadersEnd(ChannelHandlerContext paramChannelHandlerContext, Http2Stream paramHttp2Stream, FullHttpMessage paramFullHttpMessage, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (getMessage(paramHttp2Stream) != paramFullHttpMessage) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      fireChannelRead(paramChannelHandlerContext, paramFullHttpMessage, paramBoolean, paramHttp2Stream);
    }
    else
    {
      putMessage(paramHttp2Stream, paramFullHttpMessage);
    }
  }
  
  protected void fireChannelRead(ChannelHandlerContext paramChannelHandlerContext, FullHttpMessage paramFullHttpMessage, boolean paramBoolean, Http2Stream paramHttp2Stream)
  {
    removeMessage(paramHttp2Stream, paramBoolean);
    HttpUtil.setContentLength(paramFullHttpMessage, paramFullHttpMessage.content().readableBytes());
    paramChannelHandlerContext.fireChannelRead(paramFullHttpMessage);
  }
  
  protected final FullHttpMessage getMessage(Http2Stream paramHttp2Stream)
  {
    return (FullHttpMessage)paramHttp2Stream.getProperty(this.messageKey);
  }
  
  protected FullHttpMessage newMessage(Http2Stream paramHttp2Stream, Http2Headers paramHttp2Headers, boolean paramBoolean, ByteBufAllocator paramByteBufAllocator)
    throws Http2Exception
  {
    if (this.connection.isServer()) {
      paramHttp2Stream = HttpConversionUtil.toFullHttpRequest(paramHttp2Stream.id(), paramHttp2Headers, paramByteBufAllocator, paramBoolean);
    } else {
      paramHttp2Stream = HttpConversionUtil.toFullHttpResponse(paramHttp2Stream.id(), paramHttp2Headers, paramByteBufAllocator, paramBoolean);
    }
    return paramHttp2Stream;
  }
  
  public int onDataRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean)
    throws Http2Exception
  {
    Http2Stream localHttp2Stream = this.connection.stream(paramInt1);
    FullHttpMessage localFullHttpMessage = getMessage(localHttp2Stream);
    if (localFullHttpMessage != null)
    {
      ByteBuf localByteBuf = localFullHttpMessage.content();
      int i = paramByteBuf.readableBytes();
      int j = localByteBuf.readableBytes();
      int k = this.maxContentLength;
      if (j <= k - i)
      {
        localByteBuf.writeBytes(paramByteBuf, paramByteBuf.readerIndex(), i);
        if (paramBoolean) {
          fireChannelRead(paramChannelHandlerContext, localFullHttpMessage, false, localHttp2Stream);
        }
        return i + paramInt2;
      }
      throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Content length exceeded max of %d for stream id %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt1) });
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Data Frame received for unknown stream id %d", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
    throws Http2Exception
  {
    Http2Stream localHttp2Stream = this.connection.stream(paramInt1);
    paramHttp2Headers = processHeadersBegin(paramChannelHandlerContext, localHttp2Stream, paramHttp2Headers, paramBoolean2, true, true);
    if (paramHttp2Headers != null)
    {
      if (paramInt2 != 0) {
        paramHttp2Headers.headers().setInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_DEPENDENCY_ID.text(), paramInt2);
      }
      paramHttp2Headers.headers().setShort(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text(), paramShort);
      processHeadersEnd(paramChannelHandlerContext, localHttp2Stream, paramHttp2Headers, paramBoolean2);
    }
  }
  
  public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean)
    throws Http2Exception
  {
    Http2Stream localHttp2Stream = this.connection.stream(paramInt1);
    paramHttp2Headers = processHeadersBegin(paramChannelHandlerContext, localHttp2Stream, paramHttp2Headers, paramBoolean, true, true);
    if (paramHttp2Headers != null) {
      processHeadersEnd(paramChannelHandlerContext, localHttp2Stream, paramHttp2Headers, paramBoolean);
    }
  }
  
  public void onPushPromiseRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, Http2Headers paramHttp2Headers, int paramInt3)
    throws Http2Exception
  {
    Http2Stream localHttp2Stream = this.connection.stream(paramInt2);
    if (paramHttp2Headers.status() == null) {
      paramHttp2Headers.status(HttpResponseStatus.OK.codeAsText());
    }
    paramHttp2Headers = processHeadersBegin(paramChannelHandlerContext, localHttp2Stream, paramHttp2Headers, false, false, false);
    if (paramHttp2Headers != null)
    {
      paramHttp2Headers.headers().setInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_PROMISE_ID.text(), paramInt1);
      paramHttp2Headers.headers().setShort(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text(), (short)16);
      processHeadersEnd(paramChannelHandlerContext, localHttp2Stream, paramHttp2Headers, false);
      return;
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Push Promise Frame received for pre-existing stream id %d", new Object[] { Integer.valueOf(paramInt2) });
  }
  
  public void onRstStreamRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong)
    throws Http2Exception
  {
    Http2Stream localHttp2Stream = this.connection.stream(paramInt);
    FullHttpMessage localFullHttpMessage = getMessage(localHttp2Stream);
    if (localFullHttpMessage != null) {
      onRstStreamRead(localHttp2Stream, localFullHttpMessage);
    }
    paramChannelHandlerContext.fireExceptionCaught(Http2Exception.streamError(paramInt, Http2Error.valueOf(paramLong), "HTTP/2 to HTTP layer caught stream reset", new Object[0]));
  }
  
  protected void onRstStreamRead(Http2Stream paramHttp2Stream, FullHttpMessage paramFullHttpMessage)
  {
    removeMessage(paramHttp2Stream, true);
  }
  
  public void onSettingsRead(ChannelHandlerContext paramChannelHandlerContext, Http2Settings paramHttp2Settings)
    throws Http2Exception
  {
    if (this.propagateSettings) {
      paramChannelHandlerContext.fireChannelRead(paramHttp2Settings);
    }
  }
  
  public void onStreamRemoved(Http2Stream paramHttp2Stream)
  {
    removeMessage(paramHttp2Stream, true);
  }
  
  protected FullHttpMessage processHeadersBegin(ChannelHandlerContext paramChannelHandlerContext, Http2Stream paramHttp2Stream, Http2Headers paramHttp2Headers, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws Http2Exception
  {
    FullHttpMessage localFullHttpMessage1 = getMessage(paramHttp2Stream);
    FullHttpMessage localFullHttpMessage2 = null;
    boolean bool = false;
    if (localFullHttpMessage1 == null)
    {
      paramHttp2Headers = newMessage(paramHttp2Stream, paramHttp2Headers, this.validateHttpHeaders, paramChannelHandlerContext.alloc());
      paramBoolean2 = true;
    }
    else if (paramBoolean2)
    {
      HttpConversionUtil.addHttp2ToHttpHeaders(paramHttp2Stream.id(), paramHttp2Headers, localFullHttpMessage1, paramBoolean3);
      paramHttp2Headers = localFullHttpMessage1;
      paramBoolean2 = bool;
    }
    else
    {
      paramHttp2Headers = null;
      paramBoolean2 = bool;
    }
    if (this.sendDetector.mustSendImmediately(paramHttp2Headers))
    {
      if (!paramBoolean1) {
        localFullHttpMessage2 = this.sendDetector.copyIfNeeded(paramChannelHandlerContext.alloc(), paramHttp2Headers);
      }
      fireChannelRead(paramChannelHandlerContext, paramHttp2Headers, paramBoolean2, paramHttp2Stream);
      return localFullHttpMessage2;
    }
    return paramHttp2Headers;
  }
  
  protected final void putMessage(Http2Stream paramHttp2Stream, FullHttpMessage paramFullHttpMessage)
  {
    paramHttp2Stream = (FullHttpMessage)paramHttp2Stream.setProperty(this.messageKey, paramFullHttpMessage);
    if ((paramHttp2Stream != paramFullHttpMessage) && (paramHttp2Stream != null)) {
      paramHttp2Stream.release();
    }
  }
  
  protected final void removeMessage(Http2Stream paramHttp2Stream, boolean paramBoolean)
  {
    paramHttp2Stream = (FullHttpMessage)paramHttp2Stream.removeProperty(this.messageKey);
    if ((paramBoolean) && (paramHttp2Stream != null)) {
      paramHttp2Stream.release();
    }
  }
  
  private static abstract interface ImmediateSendDetector
  {
    public abstract FullHttpMessage copyIfNeeded(ByteBufAllocator paramByteBufAllocator, FullHttpMessage paramFullHttpMessage);
    
    public abstract boolean mustSendImmediately(FullHttpMessage paramFullHttpMessage);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\InboundHttp2ToHttpAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */