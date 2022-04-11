package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.logging.LogLevel;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class Http2FrameLogger
  extends ChannelHandlerAdapter
{
  private static final int BUFFER_LENGTH_THRESHOLD = 64;
  private final InternalLogLevel level;
  private final InternalLogger logger;
  
  public Http2FrameLogger(LogLevel paramLogLevel)
  {
    this(paramLogLevel.toInternalLevel(), InternalLoggerFactory.getInstance(Http2FrameLogger.class));
  }
  
  public Http2FrameLogger(LogLevel paramLogLevel, Class<?> paramClass)
  {
    this(paramLogLevel.toInternalLevel(), InternalLoggerFactory.getInstance(paramClass));
  }
  
  public Http2FrameLogger(LogLevel paramLogLevel, String paramString)
  {
    this(paramLogLevel.toInternalLevel(), InternalLoggerFactory.getInstance(paramString));
  }
  
  private Http2FrameLogger(InternalLogLevel paramInternalLogLevel, InternalLogger paramInternalLogger)
  {
    this.level = ((InternalLogLevel)ObjectUtil.checkNotNull(paramInternalLogLevel, "level"));
    this.logger = ((InternalLogger)ObjectUtil.checkNotNull(paramInternalLogger, "logger"));
  }
  
  private String toString(ByteBuf paramByteBuf)
  {
    if ((this.level != InternalLogLevel.TRACE) && (paramByteBuf.readableBytes() > 64))
    {
      int i = Math.min(paramByteBuf.readableBytes(), 64);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ByteBufUtil.hexDump(paramByteBuf, paramByteBuf.readerIndex(), i));
      localStringBuilder.append("...");
      return localStringBuilder.toString();
    }
    return ByteBufUtil.hexDump(paramByteBuf);
  }
  
  public boolean isEnabled()
  {
    return this.logger.isEnabled(this.level);
  }
  
  public void logData(Direction paramDirection, ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean)
  {
    if (isEnabled()) {
      this.logger.log(this.level, "{} {} DATA: streamId={} padding={} endStream={} length={} bytes={}", new Object[] { paramChannelHandlerContext.channel(), paramDirection.name(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Integer.valueOf(paramByteBuf.readableBytes()), toString(paramByteBuf) });
    }
  }
  
  public void logGoAway(Direction paramDirection, ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ByteBuf paramByteBuf)
  {
    if (isEnabled()) {
      this.logger.log(this.level, "{} {} GO_AWAY: lastStreamId={} errorCode={} length={} bytes={}", new Object[] { paramChannelHandlerContext.channel(), paramDirection.name(), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(paramByteBuf.readableBytes()), toString(paramByteBuf) });
    }
  }
  
  public void logHeaders(Direction paramDirection, ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    if (isEnabled()) {
      this.logger.log(this.level, "{} {} HEADERS: streamId={} headers={} streamDependency={} weight={} exclusive={} padding={} endStream={}", new Object[] { paramChannelHandlerContext.channel(), paramDirection.name(), Integer.valueOf(paramInt1), paramHttp2Headers, Integer.valueOf(paramInt2), Short.valueOf(paramShort), Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean2) });
    }
  }
  
  public void logHeaders(Direction paramDirection, ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean)
  {
    if (isEnabled()) {
      this.logger.log(this.level, "{} {} HEADERS: streamId={} headers={} padding={} endStream={}", new Object[] { paramChannelHandlerContext.channel(), paramDirection.name(), Integer.valueOf(paramInt1), paramHttp2Headers, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void logPing(Direction paramDirection, ChannelHandlerContext paramChannelHandlerContext, long paramLong)
  {
    if (isEnabled()) {
      this.logger.log(this.level, "{} {} PING: ack=false bytes={}", new Object[] { paramChannelHandlerContext.channel(), paramDirection.name(), Long.valueOf(paramLong) });
    }
  }
  
  public void logPingAck(Direction paramDirection, ChannelHandlerContext paramChannelHandlerContext, long paramLong)
  {
    if (isEnabled()) {
      this.logger.log(this.level, "{} {} PING: ack=true bytes={}", new Object[] { paramChannelHandlerContext.channel(), paramDirection.name(), Long.valueOf(paramLong) });
    }
  }
  
  public void logPriority(Direction paramDirection, ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, short paramShort, boolean paramBoolean)
  {
    if (isEnabled()) {
      this.logger.log(this.level, "{} {} PRIORITY: streamId={} streamDependency={} weight={} exclusive={}", new Object[] { paramChannelHandlerContext.channel(), paramDirection.name(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Short.valueOf(paramShort), Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void logPushPromise(Direction paramDirection, ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, Http2Headers paramHttp2Headers, int paramInt3)
  {
    if (isEnabled()) {
      this.logger.log(this.level, "{} {} PUSH_PROMISE: streamId={} promisedStreamId={} headers={} padding={}", new Object[] { paramChannelHandlerContext.channel(), paramDirection.name(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramHttp2Headers, Integer.valueOf(paramInt3) });
    }
  }
  
  public void logRstStream(Direction paramDirection, ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong)
  {
    if (isEnabled()) {
      this.logger.log(this.level, "{} {} RST_STREAM: streamId={} errorCode={}", new Object[] { paramChannelHandlerContext.channel(), paramDirection.name(), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    }
  }
  
  public void logSettings(Direction paramDirection, ChannelHandlerContext paramChannelHandlerContext, Http2Settings paramHttp2Settings)
  {
    if (isEnabled()) {
      this.logger.log(this.level, "{} {} SETTINGS: ack=false settings={}", new Object[] { paramChannelHandlerContext.channel(), paramDirection.name(), paramHttp2Settings });
    }
  }
  
  public void logSettingsAck(Direction paramDirection, ChannelHandlerContext paramChannelHandlerContext)
  {
    this.logger.log(this.level, "{} {} SETTINGS: ack=true", paramChannelHandlerContext.channel(), paramDirection.name());
  }
  
  public void logUnknownFrame(Direction paramDirection, ChannelHandlerContext paramChannelHandlerContext, byte paramByte, int paramInt, Http2Flags paramHttp2Flags, ByteBuf paramByteBuf)
  {
    if (isEnabled()) {
      this.logger.log(this.level, "{} {} UNKNOWN: frameType={} streamId={} flags={} length={} bytes={}", new Object[] { paramChannelHandlerContext.channel(), paramDirection.name(), Integer.valueOf(paramByte & 0xFF), Integer.valueOf(paramInt), Short.valueOf(paramHttp2Flags.value()), Integer.valueOf(paramByteBuf.readableBytes()), toString(paramByteBuf) });
    }
  }
  
  public void logWindowsUpdate(Direction paramDirection, ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2)
  {
    if (isEnabled()) {
      this.logger.log(this.level, "{} {} WINDOW_UPDATE: streamId={} windowSizeIncrement={}", new Object[] { paramChannelHandlerContext.channel(), paramDirection.name(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
  }
  
  public static enum Direction
  {
    static
    {
      Direction localDirection1 = new Direction("INBOUND", 0);
      INBOUND = localDirection1;
      Direction localDirection2 = new Direction("OUTBOUND", 1);
      OUTBOUND = localDirection2;
      $VALUES = new Direction[] { localDirection1, localDirection2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2FrameLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */