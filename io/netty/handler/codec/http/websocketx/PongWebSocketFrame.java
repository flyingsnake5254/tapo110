package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class PongWebSocketFrame
  extends WebSocketFrame
{
  public PongWebSocketFrame()
  {
    super(Unpooled.buffer(0));
  }
  
  public PongWebSocketFrame(ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
  }
  
  public PongWebSocketFrame(boolean paramBoolean, int paramInt, ByteBuf paramByteBuf)
  {
    super(paramBoolean, paramInt, paramByteBuf);
  }
  
  public PongWebSocketFrame copy()
  {
    return (PongWebSocketFrame)super.copy();
  }
  
  public PongWebSocketFrame duplicate()
  {
    return (PongWebSocketFrame)super.duplicate();
  }
  
  public PongWebSocketFrame replace(ByteBuf paramByteBuf)
  {
    return new PongWebSocketFrame(isFinalFragment(), rsv(), paramByteBuf);
  }
  
  public PongWebSocketFrame retain()
  {
    super.retain();
    return this;
  }
  
  public PongWebSocketFrame retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public PongWebSocketFrame retainedDuplicate()
  {
    return (PongWebSocketFrame)super.retainedDuplicate();
  }
  
  public PongWebSocketFrame touch()
  {
    super.touch();
    return this;
  }
  
  public PongWebSocketFrame touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\PongWebSocketFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */