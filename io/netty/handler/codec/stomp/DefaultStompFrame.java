package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;

public class DefaultStompFrame
  extends DefaultStompHeadersSubframe
  implements StompFrame
{
  private final ByteBuf content;
  
  public DefaultStompFrame(StompCommand paramStompCommand)
  {
    this(paramStompCommand, Unpooled.buffer(0));
  }
  
  public DefaultStompFrame(StompCommand paramStompCommand, ByteBuf paramByteBuf)
  {
    this(paramStompCommand, paramByteBuf, null);
  }
  
  DefaultStompFrame(StompCommand paramStompCommand, ByteBuf paramByteBuf, DefaultStompHeaders paramDefaultStompHeaders)
  {
    super(paramStompCommand, paramDefaultStompHeaders);
    this.content = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "content"));
  }
  
  public ByteBuf content()
  {
    return this.content;
  }
  
  public StompFrame copy()
  {
    return replace(this.content.copy());
  }
  
  public StompFrame duplicate()
  {
    return replace(this.content.duplicate());
  }
  
  public int refCnt()
  {
    return this.content.refCnt();
  }
  
  public boolean release()
  {
    return this.content.release();
  }
  
  public boolean release(int paramInt)
  {
    return this.content.release(paramInt);
  }
  
  public StompFrame replace(ByteBuf paramByteBuf)
  {
    return new DefaultStompFrame(this.command, paramByteBuf, this.headers.copy());
  }
  
  public StompFrame retain()
  {
    this.content.retain();
    return this;
  }
  
  public StompFrame retain(int paramInt)
  {
    this.content.retain(paramInt);
    return this;
  }
  
  public StompFrame retainedDuplicate()
  {
    return replace(this.content.retainedDuplicate());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultStompFrame{command=");
    localStringBuilder.append(this.command);
    localStringBuilder.append(", headers=");
    localStringBuilder.append(this.headers);
    localStringBuilder.append(", content=");
    localStringBuilder.append(this.content.toString(CharsetUtil.UTF_8));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public StompFrame touch()
  {
    this.content.touch();
    return this;
  }
  
  public StompFrame touch(Object paramObject)
  {
    this.content.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\stomp\DefaultStompFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */