package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.util.internal.StringUtil;

public abstract class WebSocketFrame
  extends DefaultByteBufHolder
{
  private final boolean finalFragment;
  private final int rsv;
  
  protected WebSocketFrame(ByteBuf paramByteBuf)
  {
    this(true, 0, paramByteBuf);
  }
  
  protected WebSocketFrame(boolean paramBoolean, int paramInt, ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
    this.finalFragment = paramBoolean;
    this.rsv = paramInt;
  }
  
  public WebSocketFrame copy()
  {
    return (WebSocketFrame)super.copy();
  }
  
  public WebSocketFrame duplicate()
  {
    return (WebSocketFrame)super.duplicate();
  }
  
  public boolean isFinalFragment()
  {
    return this.finalFragment;
  }
  
  public abstract WebSocketFrame replace(ByteBuf paramByteBuf);
  
  public WebSocketFrame retain()
  {
    super.retain();
    return this;
  }
  
  public WebSocketFrame retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public WebSocketFrame retainedDuplicate()
  {
    return (WebSocketFrame)super.retainedDuplicate();
  }
  
  public int rsv()
  {
    return this.rsv;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(data: ");
    localStringBuilder.append(contentToString());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public WebSocketFrame touch()
  {
    super.touch();
    return this;
  }
  
  public WebSocketFrame touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */