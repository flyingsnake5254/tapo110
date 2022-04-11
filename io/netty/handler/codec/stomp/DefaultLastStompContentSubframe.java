package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;

public class DefaultLastStompContentSubframe
  extends DefaultStompContentSubframe
  implements LastStompContentSubframe
{
  public DefaultLastStompContentSubframe(ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
  }
  
  public LastStompContentSubframe copy()
  {
    return (LastStompContentSubframe)super.copy();
  }
  
  public LastStompContentSubframe duplicate()
  {
    return (LastStompContentSubframe)super.duplicate();
  }
  
  public LastStompContentSubframe replace(ByteBuf paramByteBuf)
  {
    return new DefaultLastStompContentSubframe(paramByteBuf);
  }
  
  public DefaultLastStompContentSubframe retain()
  {
    super.retain();
    return this;
  }
  
  public LastStompContentSubframe retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public LastStompContentSubframe retainedDuplicate()
  {
    return (LastStompContentSubframe)super.retainedDuplicate();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultLastStompContent{decoderResult=");
    localStringBuilder.append(decoderResult());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public LastStompContentSubframe touch()
  {
    super.touch();
    return this;
  }
  
  public LastStompContentSubframe touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\stomp\DefaultLastStompContentSubframe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */