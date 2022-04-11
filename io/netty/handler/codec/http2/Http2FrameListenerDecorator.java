package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;

public class Http2FrameListenerDecorator
  implements Http2FrameListener
{
  protected final Http2FrameListener listener;
  
  public Http2FrameListenerDecorator(Http2FrameListener paramHttp2FrameListener)
  {
    this.listener = ((Http2FrameListener)ObjectUtil.checkNotNull(paramHttp2FrameListener, "listener"));
  }
  
  public int onDataRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean)
    throws Http2Exception
  {
    return this.listener.onDataRead(paramChannelHandlerContext, paramInt1, paramByteBuf, paramInt2, paramBoolean);
  }
  
  public void onGoAwayRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ByteBuf paramByteBuf)
    throws Http2Exception
  {
    this.listener.onGoAwayRead(paramChannelHandlerContext, paramInt, paramLong, paramByteBuf);
  }
  
  public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
    throws Http2Exception
  {
    this.listener.onHeadersRead(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramShort, paramBoolean1, paramInt3, paramBoolean2);
  }
  
  public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean)
    throws Http2Exception
  {
    this.listener.onHeadersRead(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramBoolean);
  }
  
  public void onPingAckRead(ChannelHandlerContext paramChannelHandlerContext, long paramLong)
    throws Http2Exception
  {
    this.listener.onPingAckRead(paramChannelHandlerContext, paramLong);
  }
  
  public void onPingRead(ChannelHandlerContext paramChannelHandlerContext, long paramLong)
    throws Http2Exception
  {
    this.listener.onPingRead(paramChannelHandlerContext, paramLong);
  }
  
  public void onPriorityRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, short paramShort, boolean paramBoolean)
    throws Http2Exception
  {
    this.listener.onPriorityRead(paramChannelHandlerContext, paramInt1, paramInt2, paramShort, paramBoolean);
  }
  
  public void onPushPromiseRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, Http2Headers paramHttp2Headers, int paramInt3)
    throws Http2Exception
  {
    this.listener.onPushPromiseRead(paramChannelHandlerContext, paramInt1, paramInt2, paramHttp2Headers, paramInt3);
  }
  
  public void onRstStreamRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong)
    throws Http2Exception
  {
    this.listener.onRstStreamRead(paramChannelHandlerContext, paramInt, paramLong);
  }
  
  public void onSettingsAckRead(ChannelHandlerContext paramChannelHandlerContext)
    throws Http2Exception
  {
    this.listener.onSettingsAckRead(paramChannelHandlerContext);
  }
  
  public void onSettingsRead(ChannelHandlerContext paramChannelHandlerContext, Http2Settings paramHttp2Settings)
    throws Http2Exception
  {
    this.listener.onSettingsRead(paramChannelHandlerContext, paramHttp2Settings);
  }
  
  public void onUnknownFrame(ChannelHandlerContext paramChannelHandlerContext, byte paramByte, int paramInt, Http2Flags paramHttp2Flags, ByteBuf paramByteBuf)
    throws Http2Exception
  {
    this.listener.onUnknownFrame(paramChannelHandlerContext, paramByte, paramInt, paramHttp2Flags, paramByteBuf);
  }
  
  public void onWindowUpdateRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2)
    throws Http2Exception
  {
    this.listener.onWindowUpdateRead(paramChannelHandlerContext, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2FrameListenerDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */