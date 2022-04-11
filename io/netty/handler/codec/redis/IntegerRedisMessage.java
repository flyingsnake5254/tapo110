package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;

public final class IntegerRedisMessage
  implements a
{
  private final long value;
  
  public IntegerRedisMessage(long paramLong)
  {
    this.value = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    localStringBuilder.append("value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public long value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\IntegerRedisMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */