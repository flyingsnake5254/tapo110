package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class Http2EventAdapter
  implements Http2Connection.Listener, Http2FrameListener
{
  public int onDataRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean)
    throws Http2Exception
  {
    return paramByteBuf.readableBytes() + paramInt2;
  }
  
  public void onGoAwayRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ByteBuf paramByteBuf)
    throws Http2Exception
  {}
  
  public void onGoAwayReceived(int paramInt, long paramLong, ByteBuf paramByteBuf) {}
  
  public void onGoAwaySent(int paramInt, long paramLong, ByteBuf paramByteBuf) {}
  
  public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
    throws Http2Exception
  {}
  
  public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean)
    throws Http2Exception
  {}
  
  public void onPingAckRead(ChannelHandlerContext paramChannelHandlerContext, long paramLong)
    throws Http2Exception
  {}
  
  public void onPingRead(ChannelHandlerContext paramChannelHandlerContext, long paramLong)
    throws Http2Exception
  {}
  
  public void onPriorityRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, short paramShort, boolean paramBoolean)
    throws Http2Exception
  {}
  
  public void onPushPromiseRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, Http2Headers paramHttp2Headers, int paramInt3)
    throws Http2Exception
  {}
  
  public void onRstStreamRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong)
    throws Http2Exception
  {}
  
  public void onSettingsAckRead(ChannelHandlerContext paramChannelHandlerContext)
    throws Http2Exception
  {}
  
  public void onSettingsRead(ChannelHandlerContext paramChannelHandlerContext, Http2Settings paramHttp2Settings)
    throws Http2Exception
  {}
  
  public void onStreamActive(Http2Stream paramHttp2Stream) {}
  
  public void onStreamAdded(Http2Stream paramHttp2Stream) {}
  
  public void onStreamClosed(Http2Stream paramHttp2Stream) {}
  
  public void onStreamHalfClosed(Http2Stream paramHttp2Stream) {}
  
  public void onStreamRemoved(Http2Stream paramHttp2Stream) {}
  
  public void onUnknownFrame(ChannelHandlerContext paramChannelHandlerContext, byte paramByte, int paramInt, Http2Flags paramHttp2Flags, ByteBuf paramByteBuf)
    throws Http2Exception
  {}
  
  public void onWindowUpdateRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2)
    throws Http2Exception
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2EventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */