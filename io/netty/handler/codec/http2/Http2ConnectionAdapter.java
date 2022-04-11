package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

public class Http2ConnectionAdapter
  implements Http2Connection.Listener
{
  public void onGoAwayReceived(int paramInt, long paramLong, ByteBuf paramByteBuf) {}
  
  public void onGoAwaySent(int paramInt, long paramLong, ByteBuf paramByteBuf) {}
  
  public void onStreamActive(Http2Stream paramHttp2Stream) {}
  
  public void onStreamAdded(Http2Stream paramHttp2Stream) {}
  
  public void onStreamClosed(Http2Stream paramHttp2Stream) {}
  
  public void onStreamHalfClosed(Http2Stream paramHttp2Stream) {}
  
  public void onStreamRemoved(Http2Stream paramHttp2Stream) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2ConnectionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */