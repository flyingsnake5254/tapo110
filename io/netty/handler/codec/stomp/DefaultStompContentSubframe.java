package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.handler.codec.DecoderResult;

public class DefaultStompContentSubframe
  extends DefaultByteBufHolder
  implements StompContentSubframe
{
  private DecoderResult decoderResult = DecoderResult.SUCCESS;
  
  public DefaultStompContentSubframe(ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
  }
  
  public StompContentSubframe copy()
  {
    return (StompContentSubframe)super.copy();
  }
  
  public DecoderResult decoderResult()
  {
    return this.decoderResult;
  }
  
  public StompContentSubframe duplicate()
  {
    return (StompContentSubframe)super.duplicate();
  }
  
  public StompContentSubframe replace(ByteBuf paramByteBuf)
  {
    return new DefaultStompContentSubframe(paramByteBuf);
  }
  
  public StompContentSubframe retain()
  {
    super.retain();
    return this;
  }
  
  public StompContentSubframe retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public StompContentSubframe retainedDuplicate()
  {
    return (StompContentSubframe)super.retainedDuplicate();
  }
  
  public void setDecoderResult(DecoderResult paramDecoderResult)
  {
    this.decoderResult = paramDecoderResult;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultStompContent{decoderResult=");
    localStringBuilder.append(this.decoderResult);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public StompContentSubframe touch()
  {
    super.touch();
    return this;
  }
  
  public StompContentSubframe touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\stomp\DefaultStompContentSubframe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */