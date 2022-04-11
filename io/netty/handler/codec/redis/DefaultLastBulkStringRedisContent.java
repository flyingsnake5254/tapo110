package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;

public final class DefaultLastBulkStringRedisContent
  extends DefaultBulkStringRedisContent
  implements LastBulkStringRedisContent
{
  public DefaultLastBulkStringRedisContent(ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
  }
  
  public LastBulkStringRedisContent copy()
  {
    return (LastBulkStringRedisContent)super.copy();
  }
  
  public LastBulkStringRedisContent duplicate()
  {
    return (LastBulkStringRedisContent)super.duplicate();
  }
  
  public LastBulkStringRedisContent replace(ByteBuf paramByteBuf)
  {
    return new DefaultLastBulkStringRedisContent(paramByteBuf);
  }
  
  public LastBulkStringRedisContent retain()
  {
    super.retain();
    return this;
  }
  
  public LastBulkStringRedisContent retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public LastBulkStringRedisContent retainedDuplicate()
  {
    return (LastBulkStringRedisContent)super.retainedDuplicate();
  }
  
  public LastBulkStringRedisContent touch()
  {
    super.touch();
    return this;
  }
  
  public LastBulkStringRedisContent touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\DefaultLastBulkStringRedisContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */