package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

public abstract interface BulkStringRedisContent
  extends a, ByteBufHolder
{
  public abstract BulkStringRedisContent copy();
  
  public abstract BulkStringRedisContent duplicate();
  
  public abstract BulkStringRedisContent replace(ByteBuf paramByteBuf);
  
  public abstract BulkStringRedisContent retain();
  
  public abstract BulkStringRedisContent retain(int paramInt);
  
  public abstract BulkStringRedisContent retainedDuplicate();
  
  public abstract BulkStringRedisContent touch();
  
  public abstract BulkStringRedisContent touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\BulkStringRedisContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */