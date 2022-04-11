package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.util.internal.StringUtil;

public class DefaultBulkStringRedisContent
  extends DefaultByteBufHolder
  implements BulkStringRedisContent
{
  public DefaultBulkStringRedisContent(ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
  }
  
  public BulkStringRedisContent copy()
  {
    return (BulkStringRedisContent)super.copy();
  }
  
  public BulkStringRedisContent duplicate()
  {
    return (BulkStringRedisContent)super.duplicate();
  }
  
  public BulkStringRedisContent replace(ByteBuf paramByteBuf)
  {
    return new DefaultBulkStringRedisContent(paramByteBuf);
  }
  
  public BulkStringRedisContent retain()
  {
    super.retain();
    return this;
  }
  
  public BulkStringRedisContent retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public BulkStringRedisContent retainedDuplicate()
  {
    return (BulkStringRedisContent)super.retainedDuplicate();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    localStringBuilder.append("content=");
    localStringBuilder.append(content());
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public BulkStringRedisContent touch()
  {
    super.touch();
    return this;
  }
  
  public BulkStringRedisContent touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\DefaultBulkStringRedisContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */