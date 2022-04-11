package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.ReferenceCounted;

public class InboundHttpToHttp2Adapter
  extends ChannelInboundHandlerAdapter
{
  private final Http2Connection connection;
  private final Http2FrameListener listener;
  
  public InboundHttpToHttp2Adapter(Http2Connection paramHttp2Connection, Http2FrameListener paramHttp2FrameListener)
  {
    this.connection = paramHttp2Connection;
    this.listener = paramHttp2FrameListener;
  }
  
  private static int getStreamId(Http2Connection paramHttp2Connection, HttpHeaders paramHttpHeaders)
  {
    return paramHttpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), paramHttp2Connection.remote().incrementAndGetNextStreamId());
  }
  
  static void handle(ChannelHandlerContext paramChannelHandlerContext, Http2Connection paramHttp2Connection, Http2FrameListener paramHttp2FrameListener, FullHttpMessage paramFullHttpMessage)
    throws Http2Exception
  {
    try
    {
      int i = getStreamId(paramHttp2Connection, paramFullHttpMessage.headers());
      Http2Stream localHttp2Stream1 = paramHttp2Connection.stream(i);
      Http2Stream localHttp2Stream2 = localHttp2Stream1;
      if (localHttp2Stream1 == null) {
        localHttp2Stream2 = paramHttp2Connection.remote().createStream(i, false);
      }
      paramFullHttpMessage.headers().set(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), HttpScheme.HTTP.name());
      paramHttp2Connection = HttpConversionUtil.toHttp2Headers(paramFullHttpMessage, true);
      boolean bool1 = paramFullHttpMessage.content().isReadable();
      boolean bool2 = paramFullHttpMessage.trailingHeaders().isEmpty() ^ true;
      boolean bool3;
      if ((!bool1) && (!bool2)) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      paramHttp2FrameListener.onHeadersRead(paramChannelHandlerContext, i, paramHttp2Connection, 0, bool3);
      if (bool1)
      {
        paramHttp2Connection = paramFullHttpMessage.content();
        if (!bool2) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        paramHttp2FrameListener.onDataRead(paramChannelHandlerContext, i, paramHttp2Connection, 0, bool3);
      }
      if (bool2) {
        paramHttp2FrameListener.onHeadersRead(paramChannelHandlerContext, i, HttpConversionUtil.toHttp2Headers(paramFullHttpMessage.trailingHeaders(), true), 0, true);
      }
      localHttp2Stream2.closeRemoteSide();
      return;
    }
    finally
    {
      paramFullHttpMessage.release();
    }
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof FullHttpMessage)) {
      handle(paramChannelHandlerContext, this.connection, this.listener, (FullHttpMessage)paramObject);
    } else {
      super.channelRead(paramChannelHandlerContext, paramObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\InboundHttpToHttp2Adapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */