package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class CloseWebSocketFrame
  extends WebSocketFrame
{
  public CloseWebSocketFrame()
  {
    super(Unpooled.buffer(0));
  }
  
  public CloseWebSocketFrame(int paramInt, String paramString)
  {
    this(true, 0, paramInt, paramString);
  }
  
  public CloseWebSocketFrame(WebSocketCloseStatus paramWebSocketCloseStatus)
  {
    this(paramWebSocketCloseStatus.code(), paramWebSocketCloseStatus.reasonText());
  }
  
  public CloseWebSocketFrame(WebSocketCloseStatus paramWebSocketCloseStatus, String paramString)
  {
    this(paramWebSocketCloseStatus.code(), paramString);
  }
  
  public CloseWebSocketFrame(boolean paramBoolean, int paramInt)
  {
    this(paramBoolean, paramInt, Unpooled.buffer(0));
  }
  
  public CloseWebSocketFrame(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    super(paramBoolean, paramInt1, newBinaryData(paramInt2, paramString));
  }
  
  public CloseWebSocketFrame(boolean paramBoolean, int paramInt, ByteBuf paramByteBuf)
  {
    super(paramBoolean, paramInt, paramByteBuf);
  }
  
  private static ByteBuf newBinaryData(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = Unpooled.buffer(str.length() + 2);
    paramString.writeShort(paramInt);
    if (!str.isEmpty()) {
      paramString.writeCharSequence(str, CharsetUtil.UTF_8);
    }
    paramString.readerIndex(0);
    return paramString;
  }
  
  public CloseWebSocketFrame copy()
  {
    return (CloseWebSocketFrame)super.copy();
  }
  
  public CloseWebSocketFrame duplicate()
  {
    return (CloseWebSocketFrame)super.duplicate();
  }
  
  public String reasonText()
  {
    ByteBuf localByteBuf = content();
    if ((localByteBuf != null) && (localByteBuf.capacity() > 2))
    {
      localByteBuf.readerIndex(2);
      String str = localByteBuf.toString(CharsetUtil.UTF_8);
      localByteBuf.readerIndex(0);
      return str;
    }
    return "";
  }
  
  public CloseWebSocketFrame replace(ByteBuf paramByteBuf)
  {
    return new CloseWebSocketFrame(isFinalFragment(), rsv(), paramByteBuf);
  }
  
  public CloseWebSocketFrame retain()
  {
    super.retain();
    return this;
  }
  
  public CloseWebSocketFrame retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public CloseWebSocketFrame retainedDuplicate()
  {
    return (CloseWebSocketFrame)super.retainedDuplicate();
  }
  
  public int statusCode()
  {
    ByteBuf localByteBuf = content();
    if ((localByteBuf != null) && (localByteBuf.capacity() != 0))
    {
      localByteBuf.readerIndex(0);
      return localByteBuf.getShort(0);
    }
    return -1;
  }
  
  public CloseWebSocketFrame touch()
  {
    super.touch();
    return this;
  }
  
  public CloseWebSocketFrame touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\CloseWebSocketFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */