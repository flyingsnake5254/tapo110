package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;

public class ArrayHeaderRedisMessage
  implements a
{
  private final long length;
  
  public ArrayHeaderRedisMessage(long paramLong)
  {
    if (paramLong >= -1L)
    {
      this.length = paramLong;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("length: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" (expected: >= ");
    localStringBuilder.append(-1);
    localStringBuilder.append(")");
    throw new RedisCodecException(localStringBuilder.toString());
  }
  
  public boolean isNull()
  {
    boolean bool;
    if (this.length == -1L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final long length()
  {
    return this.length;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    localStringBuilder.append("length=");
    localStringBuilder.append(this.length);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\ArrayHeaderRedisMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */