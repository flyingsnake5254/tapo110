package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public class DecoratingHttp2ConnectionDecoder
  implements Http2ConnectionDecoder
{
  private final Http2ConnectionDecoder delegate;
  
  public DecoratingHttp2ConnectionDecoder(Http2ConnectionDecoder paramHttp2ConnectionDecoder)
  {
    this.delegate = ((Http2ConnectionDecoder)ObjectUtil.checkNotNull(paramHttp2ConnectionDecoder, "delegate"));
  }
  
  public void close()
  {
    this.delegate.close();
  }
  
  public Http2Connection connection()
  {
    return this.delegate.connection();
  }
  
  public void decodeFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Http2Exception
  {
    this.delegate.decodeFrame(paramChannelHandlerContext, paramByteBuf, paramList);
  }
  
  public Http2LocalFlowController flowController()
  {
    return this.delegate.flowController();
  }
  
  public Http2FrameListener frameListener()
  {
    return this.delegate.frameListener();
  }
  
  public void frameListener(Http2FrameListener paramHttp2FrameListener)
  {
    this.delegate.frameListener(paramHttp2FrameListener);
  }
  
  public void lifecycleManager(Http2LifecycleManager paramHttp2LifecycleManager)
  {
    this.delegate.lifecycleManager(paramHttp2LifecycleManager);
  }
  
  public Http2Settings localSettings()
  {
    return this.delegate.localSettings();
  }
  
  public boolean prefaceReceived()
  {
    return this.delegate.prefaceReceived();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DecoratingHttp2ConnectionDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */