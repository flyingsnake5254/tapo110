package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class BinaryWebSocketFrame
  extends WebSocketFrame
{
  public BinaryWebSocketFrame()
  {
    super(Unpooled.buffer(0));
  }
  
  public BinaryWebSocketFrame(ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
  }
  
  public BinaryWebSocketFrame(boolean paramBoolean, int paramInt, ByteBuf paramByteBuf)
  {
    super(paramBoolean, paramInt, paramByteBuf);
  }
  
  public BinaryWebSocketFrame copy()
  {
    return (BinaryWebSocketFrame)super.copy();
  }
  
  public BinaryWebSocketFrame duplicate()
  {
    return (BinaryWebSocketFrame)super.duplicate();
  }
  
  public BinaryWebSocketFrame replace(ByteBuf paramByteBuf)
  {
    return new BinaryWebSocketFrame(isFinalFragment(), rsv(), paramByteBuf);
  }
  
  public BinaryWebSocketFrame retain()
  {
    super.retain();
    return this;
  }
  
  public BinaryWebSocketFrame retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public BinaryWebSocketFrame retainedDuplicate()
  {
    return (BinaryWebSocketFrame)super.retainedDuplicate();
  }
  
  public BinaryWebSocketFrame touch()
  {
    super.touch();
    return this;
  }
  
  public BinaryWebSocketFrame touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\BinaryWebSocketFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */