package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;

public class Http2InboundFrameLogger
  implements Http2FrameReader
{
  private final Http2FrameLogger logger;
  private final Http2FrameReader reader;
  
  public Http2InboundFrameLogger(Http2FrameReader paramHttp2FrameReader, Http2FrameLogger paramHttp2FrameLogger)
  {
    this.reader = ((Http2FrameReader)ObjectUtil.checkNotNull(paramHttp2FrameReader, "reader"));
    this.logger = ((Http2FrameLogger)ObjectUtil.checkNotNull(paramHttp2FrameLogger, "logger"));
  }
  
  public void close()
  {
    this.reader.close();
  }
  
  public Http2FrameReader.Configuration configuration()
  {
    return this.reader.configuration();
  }
  
  public void readFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, final Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    this.reader.readFrame(paramChannelHandlerContext, paramByteBuf, new Http2FrameListener()
    {
      public int onDataRead(ChannelHandlerContext paramAnonymousChannelHandlerContext, int paramAnonymousInt1, ByteBuf paramAnonymousByteBuf, int paramAnonymousInt2, boolean paramAnonymousBoolean)
        throws Http2Exception
      {
        Http2InboundFrameLogger.this.logger.logData(Http2FrameLogger.Direction.INBOUND, paramAnonymousChannelHandlerContext, paramAnonymousInt1, paramAnonymousByteBuf, paramAnonymousInt2, paramAnonymousBoolean);
        return paramHttp2FrameListener.onDataRead(paramAnonymousChannelHandlerContext, paramAnonymousInt1, paramAnonymousByteBuf, paramAnonymousInt2, paramAnonymousBoolean);
      }
      
      public void onGoAwayRead(ChannelHandlerContext paramAnonymousChannelHandlerContext, int paramAnonymousInt, long paramAnonymousLong, ByteBuf paramAnonymousByteBuf)
        throws Http2Exception
      {
        Http2InboundFrameLogger.this.logger.logGoAway(Http2FrameLogger.Direction.INBOUND, paramAnonymousChannelHandlerContext, paramAnonymousInt, paramAnonymousLong, paramAnonymousByteBuf);
        paramHttp2FrameListener.onGoAwayRead(paramAnonymousChannelHandlerContext, paramAnonymousInt, paramAnonymousLong, paramAnonymousByteBuf);
      }
      
      public void onHeadersRead(ChannelHandlerContext paramAnonymousChannelHandlerContext, int paramAnonymousInt1, Http2Headers paramAnonymousHttp2Headers, int paramAnonymousInt2, short paramAnonymousShort, boolean paramAnonymousBoolean1, int paramAnonymousInt3, boolean paramAnonymousBoolean2)
        throws Http2Exception
      {
        Http2InboundFrameLogger.this.logger.logHeaders(Http2FrameLogger.Direction.INBOUND, paramAnonymousChannelHandlerContext, paramAnonymousInt1, paramAnonymousHttp2Headers, paramAnonymousInt2, paramAnonymousShort, paramAnonymousBoolean1, paramAnonymousInt3, paramAnonymousBoolean2);
        paramHttp2FrameListener.onHeadersRead(paramAnonymousChannelHandlerContext, paramAnonymousInt1, paramAnonymousHttp2Headers, paramAnonymousInt2, paramAnonymousShort, paramAnonymousBoolean1, paramAnonymousInt3, paramAnonymousBoolean2);
      }
      
      public void onHeadersRead(ChannelHandlerContext paramAnonymousChannelHandlerContext, int paramAnonymousInt1, Http2Headers paramAnonymousHttp2Headers, int paramAnonymousInt2, boolean paramAnonymousBoolean)
        throws Http2Exception
      {
        Http2InboundFrameLogger.this.logger.logHeaders(Http2FrameLogger.Direction.INBOUND, paramAnonymousChannelHandlerContext, paramAnonymousInt1, paramAnonymousHttp2Headers, paramAnonymousInt2, paramAnonymousBoolean);
        paramHttp2FrameListener.onHeadersRead(paramAnonymousChannelHandlerContext, paramAnonymousInt1, paramAnonymousHttp2Headers, paramAnonymousInt2, paramAnonymousBoolean);
      }
      
      public void onPingAckRead(ChannelHandlerContext paramAnonymousChannelHandlerContext, long paramAnonymousLong)
        throws Http2Exception
      {
        Http2InboundFrameLogger.this.logger.logPingAck(Http2FrameLogger.Direction.INBOUND, paramAnonymousChannelHandlerContext, paramAnonymousLong);
        paramHttp2FrameListener.onPingAckRead(paramAnonymousChannelHandlerContext, paramAnonymousLong);
      }
      
      public void onPingRead(ChannelHandlerContext paramAnonymousChannelHandlerContext, long paramAnonymousLong)
        throws Http2Exception
      {
        Http2InboundFrameLogger.this.logger.logPing(Http2FrameLogger.Direction.INBOUND, paramAnonymousChannelHandlerContext, paramAnonymousLong);
        paramHttp2FrameListener.onPingRead(paramAnonymousChannelHandlerContext, paramAnonymousLong);
      }
      
      public void onPriorityRead(ChannelHandlerContext paramAnonymousChannelHandlerContext, int paramAnonymousInt1, int paramAnonymousInt2, short paramAnonymousShort, boolean paramAnonymousBoolean)
        throws Http2Exception
      {
        Http2InboundFrameLogger.this.logger.logPriority(Http2FrameLogger.Direction.INBOUND, paramAnonymousChannelHandlerContext, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousShort, paramAnonymousBoolean);
        paramHttp2FrameListener.onPriorityRead(paramAnonymousChannelHandlerContext, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousShort, paramAnonymousBoolean);
      }
      
      public void onPushPromiseRead(ChannelHandlerContext paramAnonymousChannelHandlerContext, int paramAnonymousInt1, int paramAnonymousInt2, Http2Headers paramAnonymousHttp2Headers, int paramAnonymousInt3)
        throws Http2Exception
      {
        Http2InboundFrameLogger.this.logger.logPushPromise(Http2FrameLogger.Direction.INBOUND, paramAnonymousChannelHandlerContext, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousHttp2Headers, paramAnonymousInt3);
        paramHttp2FrameListener.onPushPromiseRead(paramAnonymousChannelHandlerContext, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousHttp2Headers, paramAnonymousInt3);
      }
      
      public void onRstStreamRead(ChannelHandlerContext paramAnonymousChannelHandlerContext, int paramAnonymousInt, long paramAnonymousLong)
        throws Http2Exception
      {
        Http2InboundFrameLogger.this.logger.logRstStream(Http2FrameLogger.Direction.INBOUND, paramAnonymousChannelHandlerContext, paramAnonymousInt, paramAnonymousLong);
        paramHttp2FrameListener.onRstStreamRead(paramAnonymousChannelHandlerContext, paramAnonymousInt, paramAnonymousLong);
      }
      
      public void onSettingsAckRead(ChannelHandlerContext paramAnonymousChannelHandlerContext)
        throws Http2Exception
      {
        Http2InboundFrameLogger.this.logger.logSettingsAck(Http2FrameLogger.Direction.INBOUND, paramAnonymousChannelHandlerContext);
        paramHttp2FrameListener.onSettingsAckRead(paramAnonymousChannelHandlerContext);
      }
      
      public void onSettingsRead(ChannelHandlerContext paramAnonymousChannelHandlerContext, Http2Settings paramAnonymousHttp2Settings)
        throws Http2Exception
      {
        Http2InboundFrameLogger.this.logger.logSettings(Http2FrameLogger.Direction.INBOUND, paramAnonymousChannelHandlerContext, paramAnonymousHttp2Settings);
        paramHttp2FrameListener.onSettingsRead(paramAnonymousChannelHandlerContext, paramAnonymousHttp2Settings);
      }
      
      public void onUnknownFrame(ChannelHandlerContext paramAnonymousChannelHandlerContext, byte paramAnonymousByte, int paramAnonymousInt, Http2Flags paramAnonymousHttp2Flags, ByteBuf paramAnonymousByteBuf)
        throws Http2Exception
      {
        Http2InboundFrameLogger.this.logger.logUnknownFrame(Http2FrameLogger.Direction.INBOUND, paramAnonymousChannelHandlerContext, paramAnonymousByte, paramAnonymousInt, paramAnonymousHttp2Flags, paramAnonymousByteBuf);
        paramHttp2FrameListener.onUnknownFrame(paramAnonymousChannelHandlerContext, paramAnonymousByte, paramAnonymousInt, paramAnonymousHttp2Flags, paramAnonymousByteBuf);
      }
      
      public void onWindowUpdateRead(ChannelHandlerContext paramAnonymousChannelHandlerContext, int paramAnonymousInt1, int paramAnonymousInt2)
        throws Http2Exception
      {
        Http2InboundFrameLogger.this.logger.logWindowsUpdate(Http2FrameLogger.Direction.INBOUND, paramAnonymousChannelHandlerContext, paramAnonymousInt1, paramAnonymousInt2);
        paramHttp2FrameListener.onWindowUpdateRead(paramAnonymousChannelHandlerContext, paramAnonymousInt1, paramAnonymousInt2);
      }
    });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2InboundFrameLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */