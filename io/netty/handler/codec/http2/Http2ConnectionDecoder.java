package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.io.Closeable;
import java.util.List;

public abstract interface Http2ConnectionDecoder
  extends Closeable
{
  public abstract void close();
  
  public abstract Http2Connection connection();
  
  public abstract void decodeFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Http2Exception;
  
  public abstract Http2LocalFlowController flowController();
  
  public abstract Http2FrameListener frameListener();
  
  public abstract void frameListener(Http2FrameListener paramHttp2FrameListener);
  
  public abstract void lifecycleManager(Http2LifecycleManager paramHttp2LifecycleManager);
  
  public abstract Http2Settings localSettings();
  
  public abstract boolean prefaceReceived();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2ConnectionDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */