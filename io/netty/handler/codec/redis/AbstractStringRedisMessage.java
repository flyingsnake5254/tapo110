package io.netty.handler.codec.redis;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public abstract class AbstractStringRedisMessage
  implements a
{
  private final String content;
  
  AbstractStringRedisMessage(String paramString)
  {
    this.content = ((String)ObjectUtil.checkNotNull(paramString, "content"));
  }
  
  public final String content()
  {
    return this.content;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    localStringBuilder.append("content=");
    localStringBuilder.append(this.content);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\AbstractStringRedisMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */