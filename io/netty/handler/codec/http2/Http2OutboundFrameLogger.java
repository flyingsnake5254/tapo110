package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.ObjectUtil;

public class Http2OutboundFrameLogger
  implements Http2FrameWriter
{
  private final Http2FrameLogger logger;
  private final Http2FrameWriter writer;
  
  public Http2OutboundFrameLogger(Http2FrameWriter paramHttp2FrameWriter, Http2FrameLogger paramHttp2FrameLogger)
  {
    this.writer = ((Http2FrameWriter)ObjectUtil.checkNotNull(paramHttp2FrameWriter, "writer"));
    this.logger = ((Http2FrameLogger)ObjectUtil.checkNotNull(paramHttp2FrameLogger, "logger"));
  }
  
  public void close()
  {
    this.writer.close();
  }
  
  public Http2FrameWriter.Configuration configuration()
  {
    return this.writer.configuration();
  }
  
  public ChannelFuture writeData(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    this.logger.logData(Http2FrameLogger.Direction.OUTBOUND, paramChannelHandlerContext, paramInt1, paramByteBuf, paramInt2, paramBoolean);
    return this.writer.writeData(paramChannelHandlerContext, paramInt1, paramByteBuf, paramInt2, paramBoolean, paramChannelPromise);
  }
  
  public ChannelFuture writeFrame(ChannelHandlerContext paramChannelHandlerContext, byte paramByte, int paramInt, Http2Flags paramHttp2Flags, ByteBuf paramByteBuf, ChannelPromise paramChannelPromise)
  {
    this.logger.logUnknownFrame(Http2FrameLogger.Direction.OUTBOUND, paramChannelHandlerContext, paramByte, paramInt, paramHttp2Flags, paramByteBuf);
    return this.writer.writeFrame(paramChannelHandlerContext, paramByte, paramInt, paramHttp2Flags, paramByteBuf, paramChannelPromise);
  }
  
  public ChannelFuture writeGoAway(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ByteBuf paramByteBuf, ChannelPromise paramChannelPromise)
  {
    this.logger.logGoAway(Http2FrameLogger.Direction.OUTBOUND, paramChannelHandlerContext, paramInt, paramLong, paramByteBuf);
    return this.writer.writeGoAway(paramChannelHandlerContext, paramInt, paramLong, paramByteBuf, paramChannelPromise);
  }
  
  public ChannelFuture writeHeaders(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, ChannelPromise paramChannelPromise)
  {
    this.logger.logHeaders(Http2FrameLogger.Direction.OUTBOUND, paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramShort, paramBoolean1, paramInt3, paramBoolean2);
    return this.writer.writeHeaders(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramShort, paramBoolean1, paramInt3, paramBoolean2, paramChannelPromise);
  }
  
  public ChannelFuture writeHeaders(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    this.logger.logHeaders(Http2FrameLogger.Direction.OUTBOUND, paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramBoolean);
    return this.writer.writeHeaders(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramBoolean, paramChannelPromise);
  }
  
  public ChannelFuture writePing(ChannelHandlerContext paramChannelHandlerContext, boolean paramBoolean, long paramLong, ChannelPromise paramChannelPromise)
  {
    if (paramBoolean) {
      this.logger.logPingAck(Http2FrameLogger.Direction.OUTBOUND, paramChannelHandlerContext, paramLong);
    } else {
      this.logger.logPing(Http2FrameLogger.Direction.OUTBOUND, paramChannelHandlerContext, paramLong);
    }
    return this.writer.writePing(paramChannelHandlerContext, paramBoolean, paramLong, paramChannelPromise);
  }
  
  public ChannelFuture writePriority(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, short paramShort, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    this.logger.logPriority(Http2FrameLogger.Direction.OUTBOUND, paramChannelHandlerContext, paramInt1, paramInt2, paramShort, paramBoolean);
    return this.writer.writePriority(paramChannelHandlerContext, paramInt1, paramInt2, paramShort, paramBoolean, paramChannelPromise);
  }
  
  public ChannelFuture writePushPromise(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, Http2Headers paramHttp2Headers, int paramInt3, ChannelPromise paramChannelPromise)
  {
    this.logger.logPushPromise(Http2FrameLogger.Direction.OUTBOUND, paramChannelHandlerContext, paramInt1, paramInt2, paramHttp2Headers, paramInt3);
    return this.writer.writePushPromise(paramChannelHandlerContext, paramInt1, paramInt2, paramHttp2Headers, paramInt3, paramChannelPromise);
  }
  
  public ChannelFuture writeRstStream(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ChannelPromise paramChannelPromise)
  {
    this.logger.logRstStream(Http2FrameLogger.Direction.OUTBOUND, paramChannelHandlerContext, paramInt, paramLong);
    return this.writer.writeRstStream(paramChannelHandlerContext, paramInt, paramLong, paramChannelPromise);
  }
  
  public ChannelFuture writeSettings(ChannelHandlerContext paramChannelHandlerContext, Http2Settings paramHttp2Settings, ChannelPromise paramChannelPromise)
  {
    this.logger.logSettings(Http2FrameLogger.Direction.OUTBOUND, paramChannelHandlerContext, paramHttp2Settings);
    return this.writer.writeSettings(paramChannelHandlerContext, paramHttp2Settings, paramChannelPromise);
  }
  
  public ChannelFuture writeSettingsAck(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
  {
    this.logger.logSettingsAck(Http2FrameLogger.Direction.OUTBOUND, paramChannelHandlerContext);
    return this.writer.writeSettingsAck(paramChannelHandlerContext, paramChannelPromise);
  }
  
  public ChannelFuture writeWindowUpdate(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, ChannelPromise paramChannelPromise)
  {
    this.logger.logWindowsUpdate(Http2FrameLogger.Direction.OUTBOUND, paramChannelHandlerContext, paramInt1, paramInt2);
    return this.writer.writeWindowUpdate(paramChannelHandlerContext, paramInt1, paramInt2, paramChannelPromise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2OutboundFrameLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */