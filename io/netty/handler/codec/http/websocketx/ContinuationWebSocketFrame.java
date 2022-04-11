package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class ContinuationWebSocketFrame
  extends WebSocketFrame
{
  public ContinuationWebSocketFrame()
  {
    this(Unpooled.buffer(0));
  }
  
  public ContinuationWebSocketFrame(ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
  }
  
  public ContinuationWebSocketFrame(boolean paramBoolean, int paramInt, ByteBuf paramByteBuf)
  {
    super(paramBoolean, paramInt, paramByteBuf);
  }
  
  public ContinuationWebSocketFrame(boolean paramBoolean, int paramInt, String paramString)
  {
    this(paramBoolean, paramInt, fromText(paramString));
  }
  
  private static ByteBuf fromText(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return Unpooled.copiedBuffer(paramString, CharsetUtil.UTF_8);
    }
    return Unpooled.EMPTY_BUFFER;
  }
  
  public ContinuationWebSocketFrame copy()
  {
    return (ContinuationWebSocketFrame)super.copy();
  }
  
  public ContinuationWebSocketFrame duplicate()
  {
    return (ContinuationWebSocketFrame)super.duplicate();
  }
  
  public ContinuationWebSocketFrame replace(ByteBuf paramByteBuf)
  {
    return new ContinuationWebSocketFrame(isFinalFragment(), rsv(), paramByteBuf);
  }
  
  public ContinuationWebSocketFrame retain()
  {
    super.retain();
    return this;
  }
  
  public ContinuationWebSocketFrame retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public ContinuationWebSocketFrame retainedDuplicate()
  {
    return (ContinuationWebSocketFrame)super.retainedDuplicate();
  }
  
  public String text()
  {
    return content().toString(CharsetUtil.UTF_8);
  }
  
  public ContinuationWebSocketFrame touch()
  {
    super.touch();
    return this;
  }
  
  public ContinuationWebSocketFrame touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\ContinuationWebSocketFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */