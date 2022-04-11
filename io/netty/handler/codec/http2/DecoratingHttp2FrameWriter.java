package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.ObjectUtil;

public class DecoratingHttp2FrameWriter
  implements Http2FrameWriter
{
  private final Http2FrameWriter delegate;
  
  public DecoratingHttp2FrameWriter(Http2FrameWriter paramHttp2FrameWriter)
  {
    this.delegate = ((Http2FrameWriter)ObjectUtil.checkNotNull(paramHttp2FrameWriter, "delegate"));
  }
  
  public void close()
  {
    this.delegate.close();
  }
  
  public Http2FrameWriter.Configuration configuration()
  {
    return this.delegate.configuration();
  }
  
  public ChannelFuture writeData(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    return this.delegate.writeData(paramChannelHandlerContext, paramInt1, paramByteBuf, paramInt2, paramBoolean, paramChannelPromise);
  }
  
  public ChannelFuture writeFrame(ChannelHandlerContext paramChannelHandlerContext, byte paramByte, int paramInt, Http2Flags paramHttp2Flags, ByteBuf paramByteBuf, ChannelPromise paramChannelPromise)
  {
    return this.delegate.writeFrame(paramChannelHandlerContext, paramByte, paramInt, paramHttp2Flags, paramByteBuf, paramChannelPromise);
  }
  
  public ChannelFuture writeGoAway(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ByteBuf paramByteBuf, ChannelPromise paramChannelPromise)
  {
    return this.delegate.writeGoAway(paramChannelHandlerContext, paramInt, paramLong, paramByteBuf, paramChannelPromise);
  }
  
  public ChannelFuture writeHeaders(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, ChannelPromise paramChannelPromise)
  {
    return this.delegate.writeHeaders(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramShort, paramBoolean1, paramInt3, paramBoolean2, paramChannelPromise);
  }
  
  public ChannelFuture writeHeaders(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    return this.delegate.writeHeaders(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramBoolean, paramChannelPromise);
  }
  
  public ChannelFuture writePing(ChannelHandlerContext paramChannelHandlerContext, boolean paramBoolean, long paramLong, ChannelPromise paramChannelPromise)
  {
    return this.delegate.writePing(paramChannelHandlerContext, paramBoolean, paramLong, paramChannelPromise);
  }
  
  public ChannelFuture writePriority(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, short paramShort, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    return this.delegate.writePriority(paramChannelHandlerContext, paramInt1, paramInt2, paramShort, paramBoolean, paramChannelPromise);
  }
  
  public ChannelFuture writePushPromise(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, Http2Headers paramHttp2Headers, int paramInt3, ChannelPromise paramChannelPromise)
  {
    return this.delegate.writePushPromise(paramChannelHandlerContext, paramInt1, paramInt2, paramHttp2Headers, paramInt3, paramChannelPromise);
  }
  
  public ChannelFuture writeRstStream(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ChannelPromise paramChannelPromise)
  {
    return this.delegate.writeRstStream(paramChannelHandlerContext, paramInt, paramLong, paramChannelPromise);
  }
  
  public ChannelFuture writeSettings(ChannelHandlerContext paramChannelHandlerContext, Http2Settings paramHttp2Settings, ChannelPromise paramChannelPromise)
  {
    return this.delegate.writeSettings(paramChannelHandlerContext, paramHttp2Settings, paramChannelPromise);
  }
  
  public ChannelFuture writeSettingsAck(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
  {
    return this.delegate.writeSettingsAck(paramChannelHandlerContext, paramChannelPromise);
  }
  
  public ChannelFuture writeWindowUpdate(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, ChannelPromise paramChannelPromise)
  {
    return this.delegate.writeWindowUpdate(paramChannelHandlerContext, paramInt1, paramInt2, paramChannelPromise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DecoratingHttp2FrameWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */