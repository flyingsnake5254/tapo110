package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class PingWebSocketFrame
  extends WebSocketFrame
{
  public PingWebSocketFrame()
  {
    super(true, 0, Unpooled.buffer(0));
  }
  
  public PingWebSocketFrame(ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
  }
  
  public PingWebSocketFrame(boolean paramBoolean, int paramInt, ByteBuf paramByteBuf)
  {
    super(paramBoolean, paramInt, paramByteBuf);
  }
  
  public PingWebSocketFrame copy()
  {
    return (PingWebSocketFrame)super.copy();
  }
  
  public PingWebSocketFrame duplicate()
  {
    return (PingWebSocketFrame)super.duplicate();
  }
  
  public PingWebSocketFrame replace(ByteBuf paramByteBuf)
  {
    return new PingWebSocketFrame(isFinalFragment(), rsv(), paramByteBuf);
  }
  
  public PingWebSocketFrame retain()
  {
    super.retain();
    return this;
  }
  
  public PingWebSocketFrame retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public PingWebSocketFrame retainedDuplicate()
  {
    return (PingWebSocketFrame)super.retainedDuplicate();
  }
  
  public PingWebSocketFrame touch()
  {
    super.touch();
    return this;
  }
  
  public PingWebSocketFrame touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\PingWebSocketFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */