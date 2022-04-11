package io.netty.handler.codec.redis;

public class BulkStringHeaderRedisMessage
  implements a
{
  private final int bulkStringLength;
  
  public BulkStringHeaderRedisMessage(int paramInt)
  {
    if (paramInt > 0)
    {
      this.bulkStringLength = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bulkStringLength: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: > 0)");
    throw new RedisCodecException(localStringBuilder.toString());
  }
  
  public final int bulkStringLength()
  {
    return this.bulkStringLength;
  }
  
  public boolean isNull()
  {
    boolean bool;
    if (this.bulkStringLength == -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\BulkStringHeaderRedisMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */