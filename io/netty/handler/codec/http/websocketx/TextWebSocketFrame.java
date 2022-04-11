package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class TextWebSocketFrame
  extends WebSocketFrame
{
  public TextWebSocketFrame()
  {
    super(Unpooled.buffer(0));
  }
  
  public TextWebSocketFrame(ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
  }
  
  public TextWebSocketFrame(String paramString)
  {
    super(fromText(paramString));
  }
  
  public TextWebSocketFrame(boolean paramBoolean, int paramInt, ByteBuf paramByteBuf)
  {
    super(paramBoolean, paramInt, paramByteBuf);
  }
  
  public TextWebSocketFrame(boolean paramBoolean, int paramInt, String paramString)
  {
    super(paramBoolean, paramInt, fromText(paramString));
  }
  
  private static ByteBuf fromText(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return Unpooled.copiedBuffer(paramString, CharsetUtil.UTF_8);
    }
    return Unpooled.EMPTY_BUFFER;
  }
  
  public TextWebSocketFrame copy()
  {
    return (TextWebSocketFrame)super.copy();
  }
  
  public TextWebSocketFrame duplicate()
  {
    return (TextWebSocketFrame)super.duplicate();
  }
  
  public TextWebSocketFrame replace(ByteBuf paramByteBuf)
  {
    return new TextWebSocketFrame(isFinalFragment(), rsv(), paramByteBuf);
  }
  
  public TextWebSocketFrame retain()
  {
    super.retain();
    return this;
  }
  
  public TextWebSocketFrame retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public TextWebSocketFrame retainedDuplicate()
  {
    return (TextWebSocketFrame)super.retainedDuplicate();
  }
  
  public String text()
  {
    return content().toString(CharsetUtil.UTF_8);
  }
  
  public TextWebSocketFrame touch()
  {
    super.touch();
    return this;
  }
  
  public TextWebSocketFrame touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\TextWebSocketFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */